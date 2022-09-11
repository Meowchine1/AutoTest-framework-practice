package functionalTests;

import base.StartBrowser;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.ConfigProvider;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import data.CustomDataProvider;

import static com.codeborne.selenide.Selenide.*;

public class Smoke extends StartBrowser {

    private static final String authorization = "authorization";
    public final SelenideElement ERROR_SING_IN_MESSAGE = $(By.xpath(".//div[@role='alert']"));

    @Test
    public void positiveSignIn() {

        app.loginPage.open();

        app.loginPage.login(ConfigProvider.REAL_USER_LOGIN, ConfigProvider.REAL_USER_PASSWORD);
        $(By.xpath(".//h1"))
                .shouldBe(Condition.visible);
    }

    @Test
    public void signInWithEmptyLogin() {
        app.loginPage.open();
        app.loginPage.login(ConfigProvider.EMPTY_LOGIN, ConfigProvider.REAL_USER_PASSWORD);
        ERROR_SING_IN_MESSAGE
                .shouldBe(Condition.visible);
    }

    @Test
    public void signInWithEmptyPassword() {
        app.loginPage.open();
        app.loginPage.login(ConfigProvider.REAL_USER_LOGIN, ConfigProvider.EMPTY_PASSWORD);
        ERROR_SING_IN_MESSAGE
                .shouldBe(Condition.visible);
    }

    @Test
    public void signInWithEmptyFields() {
        app.loginPage.open();
        app.loginPage.login(ConfigProvider.EMPTY_LOGIN, ConfigProvider.EMPTY_PASSWORD);
        ERROR_SING_IN_MESSAGE
                .shouldBe(Condition.visible);
    }

    @Test(groups = authorization)
    public void openCourse() {
        app.mainPage
                .chooseCourseCategory("Задачник")
                //  System.out.println($(By.xpath(".//a[@class='aalink']")).getAttribute("href"));
                .chooseCourse("Задачник по программированию");
        //$(By.xpath(".//h1")).shouldBe(Condition.exist);

    }

    @Test(groups = authorization, dataProvider = "validSearch", dataProviderClass = CustomDataProvider.class)
    public void validSearch(String request) {  //параметризованный тест
        app.searchPage.open();
        Assert.assertTrue(app.searchPage.search(request));
    }

    @Test(groups = authorization, dataProvider = "invalidSearch", dataProviderClass = CustomDataProvider.class)
    public void invalidSearch(String request) {  //параметризованный тест
        app.searchPage.open();
        Assert.assertTrue(app.searchPage.invalidSearch(request));
    }

    @Test(groups = authorization, dataProvider = "longRequest", dataProviderClass = CustomDataProvider.class)
    public void bigSizeStringformat(int length) {
        app.searchPage.open();
        app.searchPage.longSearchRequest();

    }

    @Test(groups = authorization, dataProvider = "correctPhoto", dataProviderClass = CustomDataProvider.class)
    public void loadFile() {
        SelenideElement input = $(By.xpath(".//input[@id='filesourcekey-6289f2e207b6d']"));
        //.//input[@name='files_filemanager']
        app.coursePage.open();
        input.sendKeys();
    }

    public void unhide(SelenideElement element) {
        String script = "arguments[0].style.opacity=1;"
                + "arguments[0].removeAttribute('hidden')";
        executeJavaScript(script, element);
    }

    @Test(groups = authorization)
    public void attachFile() throws InterruptedException {
        app.coursePage.open();
        SelenideElement input = $(By.xpath(".//input[@name='files_filemanager']"));
        SelenideElement input2 = $(By.xpath(".//input[@id='filesourcekey-6289f2e207b6d']"));
        executeJavaScript("arguments[0].setAttribute('type', 'inline')", input);
        String file = "";
        input.uploadFile(new File(file));
        $(By.xpath(".//input[@value='Сохранить'] ")).click();

    }

    @Test(groups = authorization)
    public void exitFromcourse() throws InterruptedException {
        app.taskPage.open();
        $(By.xpath(".//a[@id='action-menu-toggle-2']")).click();
        $(By.xpath(".//div[@class='dropdown-item'] /child::a")).click();
        $(By.xpath(".//form[@method='post']/child::button")).click();

    }

    @Test(groups = authorization)
    public void enrollAndExitFromcourse() throws InterruptedException {
        app.coursePage.open();
        app.coursePage.enroll().exit();
    }

    @Test(groups = authorization)
    public void enrollCourseAndGetTask() throws InterruptedException {
        app.coursePage.open();
        app.coursePage.chooseTask("Практикум. Первая задача\nКонтестер")
                .sendAnswer()
                .setLang("Python 3")
                .sendCode(" g")
                .checkMyAnswers()
                .isEquals();

    }
}



