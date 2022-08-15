package functionalTests;

import base.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.ConfigProvider;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import base.CustomDataProvider;

import static com.codeborne.selenide.Selenide.*;

public class Smoke extends BaseTest {

    private static final String authorization = "authorization";
    public final SelenideElement ERROR_SING_IN_MESSAGE = $(By.xpath(".//div[@role='alert']"));

    @Test
    public void positiveSignIn() {

        app.pages.LoginPage.open();

        app.pages.LoginPage.login(ConfigProvider.REAL_USER_LOGIN, ConfigProvider.REAL_USER_PASSWORD);
        $(By.xpath(".//h1"))
                .shouldBe(Condition.visible);
    }

    @Test
    public void signInWithEmptyLogin() {
        app.pages.LoginPage.open();
        app.pages.LoginPage.login(ConfigProvider.EMPTY_LOGIN, ConfigProvider.REAL_USER_PASSWORD);
        ERROR_SING_IN_MESSAGE
                .shouldBe(Condition.visible);
    }

    @Test
    public void signInWithEmptyPassword() {
        app.pages.LoginPage.open();
        app.pages.LoginPage.login(ConfigProvider.REAL_USER_LOGIN, ConfigProvider.EMPTY_PASSWORD);
        ERROR_SING_IN_MESSAGE
                .shouldBe(Condition.visible);
    }

    @Test
    public void signInWithEmptyFields() {
        app.pages.LoginPage.open();
        app.pages.LoginPage.login(ConfigProvider.EMPTY_LOGIN, ConfigProvider.EMPTY_PASSWORD);
        ERROR_SING_IN_MESSAGE
                .shouldBe(Condition.visible);
    }

    @Test(groups = authorization)
    public void openCourse() {
        app.pages.MainPage
                .chooseCourseCategory("Задачник")
                //  System.out.println($(By.xpath(".//a[@class='aalink']")).getAttribute("href"));
                .chooseCourse("Задачник по программированию");
        //$(By.xpath(".//h1")).shouldBe(Condition.exist);

    }

    @Test(groups = authorization, dataProvider = "validSearch", dataProviderClass = CustomDataProvider.class)
    public void validSearch(String request) {  //параметризованный тест
        app.pages.SearchPage.open();
        Assert.assertTrue(app.pages.SearchPage.validSearch(request));
    }

    @Test(groups = authorization, dataProvider = "invalidSearch", dataProviderClass = CustomDataProvider.class)
    public void invalidSearch(String request) {  //параметризованный тест
        app.pages.SearchPage.open();
        Assert.assertTrue(app.pages.SearchPage.invalidSearch(request));
    }

    @Test(groups = authorization, dataProvider = "longRequest", dataProviderClass = CustomDataProvider.class)
    public void bigSizeStringformat(int length) {
        byte[] array = new byte[length]; // length is bounded by 7
        new Random().nextBytes(array);
        String request = new String(array, StandardCharsets.UTF_8);
        app.pages.SearchPage.open();
        Assert.assertTrue(app.pages.SearchPage.writeBigSizeString(request));

    }

    @Test(groups = authorization, dataProvider = "correctPhoto", dataProviderClass = CustomDataProvider.class)
    public void loadFile() {
        SelenideElement input = $(By.xpath(".//input[@id='filesourcekey-6289f2e207b6d']"));
        //.//input[@name='files_filemanager']
        app.pages.CoursePage.open();
        input.sendKeys("C:\\Users\\katev\\IdeaProjects\\PetShop_GradleAllure2\\src\\test\\java\\files\\test.gif");
    }

    public void unhide(SelenideElement element) {
        String script = "arguments[0].style.opacity=1;"
                + "arguments[0].removeAttribute('hidden')";
        executeJavaScript(script, element);
    }

    @Test(groups = authorization)
    public void attachFile() throws InterruptedException {
        app.pages.CoursePage.open();
        SelenideElement input = $(By.xpath(".//input[@name='files_filemanager']"));
        SelenideElement input2 = $(By.xpath(".//input[@id='filesourcekey-6289f2e207b6d']"));
        executeJavaScript("arguments[0].setAttribute('type', 'inline')", input);
        String file = "src/test/java/files/test.gif";
        input.uploadFile(new File(file));
        $(By.xpath(".//input[@value='Сохранить'] ")).click();

    }

    @Test(groups = authorization)
    public void exitFromcourse() throws InterruptedException {
        app.pages.TaskPage.open();
        $(By.xpath(".//a[@id='action-menu-toggle-2']")).click();
        $(By.xpath(".//div[@class='dropdown-item'] /child::a")).click();
        $(By.xpath(".//form[@method='post']/child::button")).click();

    }

    @Test(groups = authorization)
    public void enrollAndExitFromcourse() throws InterruptedException {
        app.pages.CoursePage.open();
        app.pages.CoursePage.enroll();
        app.pages.CoursePage.exit();
    }

    @Test(groups = authorization)
    public void enrollCourseAndGetTask() throws InterruptedException {
        app.pages.CoursePage.open();
        app.pages.CoursePage.chooseTask("Практикум. Первая задача\nКонтестер")
                .sendAnswer()
                .setLang("Python 3")
                .sendCode(" g")
                .checkMyAnswers()
                .isEquals();

    }
}



