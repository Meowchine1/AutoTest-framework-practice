package driver;

import app.AppConfig;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import io.qameta.allure.selenide.AllureSelenide;

import java.util.List;
import java.util.Locale;

public class Driver {

    public static void initDriver() {
        DriverProperties.initConfig();
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.headless = DriverProperties.isHeadless();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());


        switch (DriverProperties.browser.toLowerCase(Locale.ROOT)) {
            case "chrome" -> Configuration.browser = Browsers.CHROME;
            case "firefox" -> Configuration.browser = Browsers.FIREFOX;
            case "edge" -> Configuration.browser = Browsers.EDGE;
            case "ie" -> Configuration.browser = Browsers.IE;
            case "opera" -> Configuration.browser = Browsers.OPERA;
            case "safari" -> Configuration.browser = Browsers.SAFARI;
            default -> Configuration.browser = Browsers.CHROME;
        }
    }

    public static WebDriver currentDriver() {
        return WebDriverRunner.getWebDriver();
    }

    public static void open(String url) {
        Selenide.open(url);
    }

    public static void refresh() {
        Selenide.refresh();
    }

    public static void maximize() {
        currentDriver().manage().window().maximize();
    }

    public static void changeWindowSize(int width, int height) {
        currentDriver().manage().window().setSize(new Dimension(width, height));
    }

    public static void clearCookies() {
        open(AppConfig.BASE_URL);
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    public static void close() {
        currentDriver().quit();
    }

    public static List<LogEntry> getBrowserLogs() {
        LogEntries log = currentDriver().manage().logs().get("browser");
        return log.getAll();
    }

    // COOKIES

    public static void addCookie(Cookie cookie) {
        currentDriver().manage().addCookie(cookie);
    }

    public static Cookie getCookie(String cookieName) {
        return currentDriver().manage().getCookieNamed(cookieName);
    }

    public static void deleteCookie(String cookieName) {
        currentDriver().manage().deleteCookieNamed(cookieName);
    }

}