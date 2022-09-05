package pages;

import pages.base.BasePage;
import com.codeborne.selenide.SelenideElement;
import pages.base.Page;
import org.openqa.selenium.By;
import pages.commonElements.UserMenu;

import static com.codeborne.selenide.Selenide.$;

public class PasswordPage extends BasePage  implements Page {

    private static final SelenideElement oldPassword = $(By.xpath(".//input[@name='password']"));
    private static final SelenideElement newPassword = $(By.xpath(".//input[@name='newpassword1']"));
    private static final SelenideElement repeatPassword = $(By.xpath(".//input[@name='newpassword2']"));
    private static final SelenideElement saveBtn = $(By.xpath(".//input[@name='submitbutton']"));
    private static final SelenideElement cancelBtn = $(By.xpath(".//input[@name='cancel']"));

    private final UserMenu userMenu = new UserMenu();

    public PasswordPage() {
    }

    public PasswordPage(String pageUrl) {
        super(pageUrl);
    }

    // global OldPASSWORD MAYBE CLASS? YES need -> configure file
    public PasswordPage changePassword(String oldpassword) {

        return this;
    }
}
