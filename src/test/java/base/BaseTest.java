package base;

import app.App;
import driver.Driver;
import org.testng.annotations.*;

public class BaseTest {
    protected App app;

    @BeforeClass
    public void setUp() {

        Driver.initDriver();
        app = new App();

    }

    @BeforeMethod(groups = "authorization")
    public void login() {
        app.loginPage.open();
        app.loginPage.login("katevoronina128@gmail.com", "8962615kate");
    }

    @AfterMethod
    public void clearCookies() {
        Driver.clearCookies();
    }

    @AfterClass
    public void tearDown() {
        Driver.close();
    }
}
