package functionalTests;

import data.CustomDataProvider;
import base.StartBrowser;
import com.codeborne.selenide.Condition;
import browserDriver.BrowserType;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;


public class Functional extends StartBrowser {

    private static final String authorization = "authorization";

    @Test
    public void choseCategory() {
        System.out.print("Задачник");
    }

    @Test(groups = authorization)
    public void course() {
        app.mainPage.chooseCourseCategory("Задачник");
        $(By.xpath(".//h1")).shouldBe(Condition.exist);
    }

    @Test(groups = authorization, dataProvider = "correctPhoto", dataProviderClass = CustomDataProvider.class) // depends from language
    public void load(String filename) {// norm
       app.userInfEditorPage.open();
       app.userInfEditorPage.setCorrectUserPhoto(filename);

    }


    public void course2() {
        app.mainPage.chooseCourseCategory("Задачник");
        $(By.xpath(".//h1")).shouldBe(Condition.exist);
    }
}