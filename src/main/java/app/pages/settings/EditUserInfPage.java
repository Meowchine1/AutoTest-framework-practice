package app.pages.settings;

import app.pages.common.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class EditUserInfPage extends BasePage {
    private static final SelenideElement lastname = $("#id_lastname");
    private static final SelenideElement openPhotoLoadForm = $(By.xpath("//a[@title='��������...']"));
    private static final SelenideElement photoLoadForm = $("//form[@class='form']");
    private static final SelenideElement photoInput = $(By.xpath("//input[@type='file']"));
    private static final SelenideElement photoLoadBtn = $(By.xpath("//button[contains(text(),'��������� ���� ����')]"));
    private static final SelenideElement saveChangesBtn = $(By.xpath("//input[@name='submitbutton']"));
    private static final SelenideElement name = $("#firstname");
    private static final SelenideElement email = $("#id_email");
    private static final SelenideElement city = $("#id_city");

    public EditUserInfPage(String pageUrl) {
        super(pageUrl);
    }

    public EditUserInfPage() {
    }

    public EditUserInfPage setName(String text) {

        name.sendKeys(text);
        return this;
    }

    public EditUserInfPage setSurname(String text) {

        lastname.sendKeys(text);
        return this;
    }

    public EditUserInfPage setEmail(String text) {

        email.sendKeys(text);
        return this;
    }

    public EditUserInfPage setEmailSettings() {
        return this;
    }

    public EditUserInfPage chooseCountry(String text) {
        return this;
    }

    public EditUserInfPage setCity(String text) {

        city.sendKeys(text);
        return this;
    }

    public EditUserInfPage setInformation() {
        return this;
    }

    public EditUserInfPage setCorrectUserPhoto(String path) {
        File file = new File(path);
        openPhotoLoadForm.shouldBe(Condition.visible).click();
        photoInput.sendKeys(file.getAbsolutePath());
        photoLoadBtn.click();
        saveChangesBtn.click();
        return this;
    }


}
