package base;

import app.App;
import helpers.Driver;
import org.testng.annotations.*;

public class BaseTest {
    private App app;

    @BeforeClass
    public void setUp() {

        Driver.initDriver();
        app = new App();

    }

    @BeforeMethod(groups = "authorization")
    public void login() {
        app.LoginPage.open();
        app.LoginPage.login("katevoronina128@gmail.com", "8962615kate");
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
