package pages;

import pages.base.BasePage;
import com.codeborne.selenide.SelenideElement;
import pages.base.Page;
import pages.commonElements.UserMenu;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage implements Page {

    private static final SelenideElement loginField = $("#username");
    private static final SelenideElement passwordField = $("#password");
    private static final SelenideElement signInButton = $("#loginbtn");

    private final UserMenu userMenu = new UserMenu();

    public LoginPage(String pageUrl) {
        super(pageUrl);
    }

    public MainPage login(String email, String password) {
        loginField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();
        return new MainPage();
    }

}