package functionalTests;
import base.baseTest;
import base.staticDataProvider;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import utils.UrlValidator;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import static com.codeborne.selenide.Selenide.$;

public class test extends baseTest {

    private static final String authorization = "authorization";
    @Test
    public void choseCategory(){
        System.out.print("Задачник");
    }

    @Test(groups = authorization)
    public void course(){
        app.MainPage.chooseCourseCategory("Задачник");
        $(By.xpath(".//h1")).shouldBe(Condition.exist);
    }

    @Test ( groups = authorization, dataProvider = "correctPhoto",  dataProviderClass = staticDataProvider.class)
    public void load(String filename){// norm
        app.editUserInformationPage.open();
        app.editUserInformationPage.setCorrectUserPhoto(filename);

    }

    @Test
    public void course2(){
        app.MainPage.chooseCourseCategory("Задачник");
        $(By.xpath(".//h1")).shouldBe(Condition.exist);
    }
}