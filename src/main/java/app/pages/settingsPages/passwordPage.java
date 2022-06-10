package app.pages.settingsPages;

import app.pages.basePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class passwordPage extends basePage  {

    public SelenideElement oldPassword = $(By.xpath(".//input[@name='password']"));
    public SelenideElement newPassword = $(By.xpath(".//input[@name='newpassword1']"));
    public SelenideElement repeatPassword = $(By.xpath(".//input[@name='newpassword2']"));
    public SelenideElement saveBtn = $(By.xpath(".//input[@name='submitbutton']"));
    public SelenideElement cancelBtn = $(By.xpath(".//input[@name='cancel']"));

    public passwordPage(String pageUrl) {
        super(pageUrl);
    }

    public passwordPage() {
    }
// global OldPASSWORD MAYBE CLASS? YES need -> configure file
    public void changePassword(String oldpassword){

    }
}
