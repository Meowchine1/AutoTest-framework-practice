package schoolSgu;
import base.baseTest;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeGroups;
import utils.UrlValidator;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static com.codeborne.selenide.Selenide.$;

public class test extends baseTest {

    @Test
    public void choseCategory(){
        System.out.print("Задачник");
    }

    @Test(groups = "autorization")
    public void course(){
        app.MainPage.chooseCourseCategory("Задачник");
        $(By.xpath(".//h1")).shouldBe(Condition.exist);
    }
    @Test
    public void search(){// norm
        app.editUserInformationPage.open();
        app.editUserInformationPage.setUserPhoto();

    }

    public static void main(String[] args) {
        System.out.println("Россия");
    }
    @Test
    public void validLink() throws MalformedURLException, URISyntaxException {

        UrlValidator urlValidator = new UrlValidator();
        urlValidator.sanitize("https://studme.org/121249/informatika/osobennosti_polzovatelskogo_interfeysa");
    }


}