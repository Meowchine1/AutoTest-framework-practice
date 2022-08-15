package app.pages.settings;

import app.pages.common.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PasswordPage extends BasePage {

    public SelenideElement oldPassword = $(By.xpath(".//input[@name='password']"));
    public SelenideElement newPassword = $(By.xpath(".//input[@name='newpassword1']"));
    public SelenideElement repeatPassword = $(By.xpath(".//input[@name='newpassword2']"));
    public SelenideElement saveBtn = $(By.xpath(".//input[@name='submitbutton']"));
    public SelenideElement cancelBtn = $(By.xpath(".//input[@name='cancel']"));

    public PasswordPage(String pageUrl) {
        super(pageUrl);
    }

    public PasswordPage() {
    }

    // global OldPASSWORD MAYBE CLASS? YES need -> configure file
    public void changePassword(String oldpassword) {

    }
}
