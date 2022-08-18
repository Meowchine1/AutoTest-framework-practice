package app.pages;

import app.pages.common.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private static final SelenideElement loginField = $("#username");
    private static final SelenideElement passwordField = $("#password");
    private static final SelenideElement signInButton = $("#loginbtn");

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