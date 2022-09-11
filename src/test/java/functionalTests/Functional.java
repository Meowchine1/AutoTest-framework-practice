package functionalTests;

import com.github.javafaker.Faker;
import data.CustomDataProvider;
import base.StartBrowser;
import com.codeborne.selenide.Condition;
import browserDriver.BrowserType;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;


public class Functional extends StartBrowser {

    private Faker faker = new Faker();
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

    @Test(groups = authorization, dataProvider = "correctPhoto", dataProviderClass = CustomDataProvider.class)
    public void load(String filename) {// norm
       app.userInfEditorPage.open();
       app.userInfEditorPage.setCorrectUserPhoto(filename);

    }

    @Test(groups = authorization)
    public void positiveFillingInf(){// -----------
        app.userInfEditorPage
                .setCity(faker.address().city())
                .chooseRandomCountry()
                .setName(faker.name().firstName())
                .setSurname(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setInformation(faker.funnyName().name());
    }


    public void course2() {
        app.mainPage.chooseCourseCategory("Задачник");
        $(By.xpath(".//h1")).shouldBe(Condition.exist);
    }
}