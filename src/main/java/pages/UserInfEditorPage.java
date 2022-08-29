package pages;

import pages.common.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.interfaces.Page;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class UserInfEditorPage extends BasePage implements Page {
    private static final SelenideElement lastname = $("#id_lastname");
    private static final SelenideElement openPhotoLoadForm = $(By.xpath("//a[@title='Add...']"));
    private static final SelenideElement photoLoadForm = $("//form[@class='form']");
    private static final SelenideElement photoInput = $(By.xpath("//input[@type='file']"));
    private static final SelenideElement photoLoadBtn = $(By.xpath("//button[contains(text(),'Upload this file')]"));
    private static final SelenideElement saveChangesBtn = $(By.xpath("//input[@name='submitbutton']"));
    private static final SelenideElement name = $("#firstname");
    private static final SelenideElement email = $("#id_email");
    private static final SelenideElement city = $("#id_city");

    public UserInfEditorPage(String pageUrl) {
        super(pageUrl);
    }

    public UserInfEditorPage() {
    }

    public UserInfEditorPage setName(String text) {

        name.sendKeys(text);
        return this;
    }

    public UserInfEditorPage setSurname(String text) {

        lastname.sendKeys(text);
        return this;
    }

    public UserInfEditorPage setEmail(String text) {

        email.sendKeys(text);
        return this;
    }

    public UserInfEditorPage setEmailSettings() {
        return this;
    }

    public UserInfEditorPage chooseCountry(String text) {
        return this;
    }

    public UserInfEditorPage setCity(String text) {

        city.sendKeys(text);
        return this;
    }

    public UserInfEditorPage setInformation() {
        return this;
    }

    public UserInfEditorPage setCorrectUserPhoto(String path) {
        File file = new File(path);
        openPhotoLoadForm.shouldBe(Condition.visible).click();
        photoInput.sendKeys(file.getAbsolutePath());
        photoLoadBtn.click();
        saveChangesBtn.click();
        return this;
    }


}
