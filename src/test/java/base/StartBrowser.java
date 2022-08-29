package base;

import app.App;
import browserDriver.Browser;
import browserDriver.BrowserPool;
import browserDriver.BrowserType;
import org.testng.annotations.*;


public class StartBrowser {
    protected App app;
    private Browser instance;
    private BrowserType type;

    @Parameters("browser")
    @BeforeClass
    public void startSession(String browser) {

        switch (browser) {
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

    @BeforeMethod(groups = "authorization")
    public void login() {
        app.loginPage.open();
        app.loginPage.login("katevoronina128@gmail.com", "8962615kate");
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
