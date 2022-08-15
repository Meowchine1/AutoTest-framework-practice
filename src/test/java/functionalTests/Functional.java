package functionalTests;

import base.BaseTest;
import base.CustomDataProvider;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class Functional extends BaseTest {

    private static final String authorization = "authorization";

    @Test
    public void choseCategory() {
        System.out.print("Задачник");
    }

    @Test(groups = authorization)
    public void course() {
        app.pages.MainPage.chooseCourseCategory("Задачник");
        $(By.xpath(".//h1")).shouldBe(Condition.exist);
    }

    @Test(groups = authorization, dataProvider = "correctPhoto", dataProviderClass = CustomDataProvider.class)
    public void load(String filename) {// norm
        app.pages.settings.EditUserInfPage.open();
        app.pages.settings.EditUserInfPage.setCorrectUserPhoto(filename);

    }

    @Test
    public void course2() {
        app.pages.MainPage.chooseCourseCategory("Задачник");
        $(By.xpath(".//h1")).shouldBe(Condition.exist);
    }
}