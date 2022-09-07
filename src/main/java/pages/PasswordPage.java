package pages;

import com.codeborne.selenide.Condition;
import helpers.PasswordLogger;
import pages.base.BasePage;
import com.codeborne.selenide.SelenideElement;
import pages.base.Page;
import org.openqa.selenium.By;
import pages.commonElements.UserMenu;
import java.io.FileWriter;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class PasswordPage extends BasePage  implements Page {

    private final static SelenideElement currentPasswordField = $(By.xpath(".//input[@autocomplete='current-passwordHistory']"));
    private final static SelenideElement firstNewPasswordField = $(By.xpath(".//input[@name='newpassword1']"));
    private final static SelenideElement secondNewPasswordField = $(By.xpath(".//input[@name='newpassword2']"));
    private final static SelenideElement saveBtn = $(By.xpath(".//input[@value='Save changes']"));

    private final static SelenideElement errorPasswordMessage = $(By.xpath(".//div[@id='id_error_password']"));
    private final static SelenideElement error1PasswordMessage = $(By.xpath(".//div[@id='id_error_newpassword1']"));
    private final static SelenideElement error2PasswordMessage = $(By.xpath(".//div[@id='id_error_newpassword2']"));
    private final static SelenideElement successMessage = $(By.xpath(".//div[@id='notice']"));
    private final static String SUCCESS_MESSAGE_EN = "Password has been changed";
    private final static String SUCCESS_MESSAGE_RU = "Пароль был изменен";

    private final UserMenu userMenu = new UserMenu();

    public PasswordPage() {
    }

    public PasswordPage(String pageUrl) {
        super(pageUrl);
    }

    public void changeToNewPassword(String newPassword){
        currentPasswordField.sendKeys(PasswordLogger.getLastPasswords());
        firstNewPasswordField.sendKeys(newPassword);
        secondNewPasswordField.sendKeys(newPassword);
        saveBtn.click();

        successMessage.shouldBe(Condition.visible);
        if (successMessage.text().equals(SUCCESS_MESSAGE_RU)
                | successMessage.text().equals(SUCCESS_MESSAGE_EN)
                | !error1PasswordMessage.isDisplayed())
        {
            PasswordLogger.overwritePassword(newPassword);
        }
        else
        {
            try(FileWriter writer = new FileWriter("passwordHistory.txt", true)) {
                writer.write("try change to=" + newPassword);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeToTheSamePassword(){
        String actualPassword = PasswordLogger.getLastPasswords()[1];
        currentPasswordField.sendKeys(actualPassword);
        firstNewPasswordField.sendKeys(actualPassword);
        secondNewPasswordField.sendKeys(actualPassword);
        saveBtn.click();
        error1PasswordMessage.shouldBe(Condition.visible);
        error2PasswordMessage.shouldBe(Condition.visible);

    }

    public void changeTwoDifferentPassword(String password1, String password2){
        String actualPassword = PasswordLogger.getLastPasswords()[1];
        currentPasswordField.sendKeys(actualPassword);
        firstNewPasswordField.sendKeys(password1);
        secondNewPasswordField.sendKeys(password2);
        saveBtn.click();
        error1PasswordMessage.shouldBe(Condition.visible);
        error2PasswordMessage.shouldBe(Condition.visible);
    }
}
