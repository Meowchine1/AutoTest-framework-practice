package app.pages;

import app.pages.common.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    public final SelenideElement loginField = $("#username");
    public final SelenideElement passwordField = $("#password");
    public final SelenideElement signInButton = $("#loginbtn");

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