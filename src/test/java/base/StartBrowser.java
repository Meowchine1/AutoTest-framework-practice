package base;

import app.App;
import browserDriver.Browser;
import browserDriver.BrowserPool;
import browserDriver.BrowserType;
import data.ConfigProvider;
import helpers.PasswordLogger;
import org.testng.annotations.*;

public class StartBrowser {
    protected App app;
    private Browser instance;
    private BrowserType type;

    @Parameters("browser")
    @BeforeClass
    public void startSession(String browser) {

        switch (browser.toLowerCase()) {
            case ("edge"):
                type = BrowserType.EDGE;
                break;
            case ("opera"):
                type = BrowserType.OPERA;
                break;
            case ("ie"):
                type = BrowserType.IE;
                break;
            case ("firefox"):
                type = BrowserType.FIREFOX;
                break;
            case ("safari"):
                type = BrowserType.SAFARI;
                break;
            case ("chrome"):
                type = BrowserType.CHROME;
                break;
        }
        instance = BrowserPool.getInstance(type);
        instance.initDriver();
        app = new App();
    }

    // [0] - previous passwordHistory, [1] - actual passwordHistory
    @BeforeMethod(groups = "authorization")
    public void login() {
        app.loginPage.open();
        app.loginPage.login(ConfigProvider.REAL_USER_LOGIN, PasswordLogger.getLastPasswords()[1]);

    }

    @AfterMethod
    public void clearCookies() {
        instance.clearCookies();
    }

    @AfterClass
    public void tearDown() {
        instance.close();
    }

}
