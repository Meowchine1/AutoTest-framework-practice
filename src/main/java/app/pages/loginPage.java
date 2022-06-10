package app.pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class loginPage extends basePage {

    private SelenideElement loginField = $("#username");
    private SelenideElement passwordField = $("#password");
    private SelenideElement signInButton = $("#loginbtn");

    public loginPage(String pageUrl) {
        super(pageUrl);
    }

    public mainPage login(String email, String password) {
        getLoginField().setValue(email);
        getPasswordField().setValue(password);
        getSignInButton().click();
        return new mainPage();
    }


    public SelenideElement getLoginField() {
        return loginField;
    }

    public void setLoginField(SelenideElement loginField) {
        this.loginField = loginField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(SelenideElement passwordField) {
        this.passwordField = passwordField;
    }

    public SelenideElement getSignInButton() {
        return signInButton;
    }

    public void setSignInButton(SelenideElement signInButton) {
        this.signInButton = signInButton;
    }
}