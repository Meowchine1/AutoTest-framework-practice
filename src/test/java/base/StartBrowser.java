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
    private static final BrowserType[] browsers = {BrowserType.CHROME,
            BrowserType.EDGE, BrowserType.FIREFOX,
            BrowserType.OPERA, BrowserType.SAFARI};

    @BeforeClass
    public void startSession() {
        instance = BrowserPool.getInstance(BrowserType.CHROME);
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

    public static void main(String[] args) {


    }
}
