package app.pages.settingsPages;

import app.pages.basePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class editUserInformationPage extends basePage {
    private final SelenideElement lastname = $("#id_lastname");
    private final SelenideElement photoLoad = $(".dndupload-arrow");
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
        photoLoad.click();
    }    //.gif .jpe .jpeg .jpg .png





}
