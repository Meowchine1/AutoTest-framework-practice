package functionalTests;

import base.StartBrowser;
import com.github.javafaker.Faker;
import data.CustomDataProvider;
import org.testng.annotations.Test;

public class LoginPageTests extends StartBrowser {

    @Test(dataProvider = "validLogin", dataProviderClass = CustomDataProvider.class)
    public void CorrectLogin (String email, String password){
        app.loginPage.login(email, password);
        //should good
    }
    @Test(dataProvider = "invalidLogin", dataProviderClass = CustomDataProvider.class)
    public void IncorrectLogin(String email, String password){
        app.loginPage.login(email, password);
        //should bad
    }

}
