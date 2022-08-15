package app.pages.settings;

import app.pages.common.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class EditUserInfPage extends BasePage {
    private final SelenideElement lastname = $("#id_lastname");
    private final SelenideElement openPhotoLoadForm = $(By.xpath("//a[@title='Добавить...']"));
    private final SelenideElement photoLoadForm = $("//form[@class='form']");
    private final SelenideElement photoInput = $(By.xpath("//input[@type='file']"));
    private final SelenideElement photoLoadBtn = $(By.xpath("//button[contains(text(),'Загрузить этот файл')]"));
    private final SelenideElement saveChangesBtn = $(By.xpath("//input[@name='submitbutton']"));
    private final SelenideElement name = $("#firstname");
    private final SelenideElement email = $("#id_email");
    private final SelenideElement city = $("#id_city");

    public EditUserInfPage(String pageUrl) {
        super(pageUrl);
    }

    public EditUserInfPage() {
    }

    public void setName(String text) {

        name.sendKeys(text);
    }

    public void setSurname(String text) {

        lastname.sendKeys(text);
    }

    public void setEmail(String text) {

        email.sendKeys(text);
    }

    public void setEmailSettings() {

    }

    public void chooseCountry(String text) {

    }

    public void setCity(String text) {

        city.sendKeys(text);
    }

    public void setInformation() {
    }

    public static void setCorrectUserPhoto(String path) {
        File file = new File(path);
        openPhotoLoadForm.shouldBe(Condition.visible).click();
        photoInput.sendKeys(file.getAbsolutePath());
        photoLoadBtn.click();
        saveChangesBtn.click();
    }


}
