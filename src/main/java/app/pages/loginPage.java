package app.pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class loginPage extends basePage {

    public SelenideElement loginField = $("#username");
    public SelenideElement passwordField = $("#password");
    public SelenideElement signInButton = $("#loginbtn");

    public loginPage(String pageUrl) {
        super(pageUrl);
    }

    public mainPage login(String email, String password) {
        loginField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();
        return new mainPage();
    }




}