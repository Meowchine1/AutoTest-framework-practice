package app.pages.settingsPages;

import app.pages.basePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class editUserInformationPage extends basePage {
    private final SelenideElement lastname = $("#id_lastname");
    private final SelenideElement openPhotoLoadForm = $(By.xpath("//a[@title='��������...']"));
    private final SelenideElement photoLoadForm = $("//form[@class='form']");
    private final SelenideElement photoInput = $(By.xpath("//input[@type='file']"));
    private final SelenideElement photoLoadBtn = $(By.xpath("//button[contains(text(),'��������� ���� ����')]"));
    private final SelenideElement saveChangesBtn = $(By.xpath("//input[@name='submitbutton']"));
    private final SelenideElement name = $("#firstname");
    private final SelenideElement email = $("#id_email");
    private final SelenideElement city = $("#id_city");

    public editUserInformationPage(String pageUrl) {
        super(pageUrl);
    }

    public editUserInformationPage() {}

    public void setName(String text){

        name.sendKeys(text);
    }
    public void setSurname(String text){

        lastname.sendKeys(text);
    }
    public void setEmail(String text){

        email.sendKeys(text);
    }
    public void setEmailSettings(){

    }
    public void chooseCountry(String text){

    }
    public void setCity(String text){

        city.sendKeys(text);
    }
    public void setInformation(){}
    public void setUserPhoto(){
        openPhotoLoadForm.shouldBe(Condition.visible);
        openPhotoLoadForm.click();
        photoInput.sendKeys(System.getProperty("user.dir") + "/test.gif");
        photoLoadBtn.click();
        saveChangesBtn.click();
        //  switchTo().f
    }   //.gif .jpe .jpeg .jpg .png





}
