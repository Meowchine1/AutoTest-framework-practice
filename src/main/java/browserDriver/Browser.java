package browserDriver;

import app.AppConfig;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;


public abstract class Browser {
    public  String browser;

    public Browser(String browser) {
        this.browser = browser;

    }

    public void initDriver() {
        Configuration.driverManagerEnabled = false;
        Configuration.browser = browser;
        Configuration.remote = " http://localhost:4444/wd/hub";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.headless = false;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    public void open(String url) {
        Selenide.open(url);
    }

    public void refresh() {
        Selenide.refresh();
    }

    public WebDriver currentDriver() {
        return WebDriverRunner.getWebDriver();
    }

    public void maximize() {
        currentDriver().manage().window().maximize();
    }

    public void changeWindowSize(int width, int height) {
        currentDriver().manage().window().setSize(new Dimension(width, height));
    }

    public void clearCookies() {
        open(AppConfig.BASE_URL);
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    public void close() {
        currentDriver().quit();
    }

    // COOKIES

    public void addCookie(Cookie cookie) {
        currentDriver().manage().addCookie(cookie);
    }

    public Cookie getCookie(String cookieName) {
        return currentDriver().manage().getCookieNamed(cookieName);
    }

    public void deleteCookie(String cookieName) {
        currentDriver().manage().deleteCookieNamed(cookieName);
    }
}
