package base;
import app.app;
import helpers.Driver;
import org.testng.annotations.*;

public class baseTest {
    protected app app;

    @BeforeClass
    public void setUp() {

        Driver.initDriver();
        app = new app();

    }

    @BeforeMethod (groups = "authorization")
    public void login(){
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
