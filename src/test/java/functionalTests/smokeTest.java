package functionalTests;
import base.baseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.ConfigProvider;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class smokeTest extends baseTest {

    public final SelenideElement ERROR_SING_IN_MESSAGE = $(By.xpath(".//div[@role='alert']"));

    @DataProvider(name = "validSearch", parallel = true)
    public static Object[][] searchRequest() {
        return new Object[][] {{"курс"}, {"информация"}, {"2012"}, {"у"},
                {"икт"}};
    }

    @DataProvider(name = "invalidSearch", parallel = true)
    public static Object[][] invalidSearch() {
        return new Object[][]{{""}, {"#"}, {"&&&&&^^^"}, {"%"}, {"   "}
        };
    }

    @DataProvider(name = "longRequest", parallel = true)
    public static Object[][] longRequest() {
        return new Object[][]{{19}, {20}, {21}, {50}
        };
    }

//    @DataProvider(name = "search", parallel = true)
//    public static Object[][] searchRequest() {
//        return new Object[][] {{""}, {"#"}, {"34"}, {"%"}, {"course"},
//                {"икт"}};
//    }

    //data.ConfigProvider
    @Test
    public void positiveSignIn(){
        app.LoginPage.open();

        app.LoginPage.login(ConfigProvider.REAL_USER_LOGIN, ConfigProvider.REAL_USER_PASSWORD);
        $(By.xpath(".//h1"))
                .shouldBe(Condition.visible);
    }

    @Test
    public void signInWithEmptyLogin(){
        app.LoginPage.open();
        app.LoginPage.login(ConfigProvider.EMPTY_LOGIN, ConfigProvider.REAL_USER_PASSWORD);
        ERROR_SING_IN_MESSAGE
                .shouldBe(Condition.visible);
    }

    @Test
    public void signInWithEmptyPassword(){
        app.LoginPage.open();
        app.LoginPage.login(ConfigProvider.REAL_USER_LOGIN, ConfigProvider.EMPTY_PASSWORD);
        ERROR_SING_IN_MESSAGE
                .shouldBe(Condition.visible);
    }

    @Test
    public void signInWithEmptyFields(){
        app.LoginPage.open();
        app.LoginPage.login(ConfigProvider.EMPTY_LOGIN, ConfigProvider.EMPTY_PASSWORD);
        ERROR_SING_IN_MESSAGE
                .shouldBe(Condition.visible);
    }

    @Test(groups = "autorization")
    public void openCourse(){
        app.MainPage
                .chooseCourseCategory("Задачник")
     //  System.out.println($(By.xpath(".//a[@class='aalink']")).getAttribute("href"));
               .chooseCourse("Задачник по программированию");
        //$(By.xpath(".//h1")).shouldBe(Condition.exist);

    }

   @Test(groups = "autorization", dataProvider = "validSearch" )
    public void validSearch(String request){  //параметризованный тест
        app.SearchPage.open();
        Assert.assertTrue(app.SearchPage.validSearch(request));
    }

    @Test(groups = "autorization", dataProvider = "invalidSearch")
    public void invalidSearch( String request){  //параметризованный тест
        app.SearchPage.open();
        Assert.assertTrue(app.SearchPage.invalidSearch(request));
    }

    @Test(groups = "autorization",  dataProvider = "longRequest")
    public void bigSizeStringformat(int length){
        byte[] array = new byte[length]; // length is bounded by 7
        new Random().nextBytes(array);
        String request = new String(array, StandardCharsets.UTF_8);
        app.SearchPage.open();
        Assert.assertTrue(app.SearchPage.writeBigSizeString(request));

    }

    @Test (groups = "autorization")
    public void loadFile(){
        SelenideElement input = $(By.xpath(".//input[@id='filesourcekey-6289f2e207b6d']"));
        //.//input[@name='files_filemanager']
        app.CoursePage.open();
        input.sendKeys("C:\\Users\\katev\\IdeaProjects\\PetShop_GradleAllure2\\src\\test\\java\\files\\test.gif");
    }

    public void unhide( SelenideElement element) {
        String script = "arguments[0].style.opacity=1;"
                + "arguments[0].removeAttribute('hidden')";
        executeJavaScript(script, element);
    }

    @Test(groups = "autorization")
    public void attachFile() throws InterruptedException {
        app.CoursePage.open();
        SelenideElement input = $(By.xpath(".//input[@name='files_filemanager']"));
        SelenideElement input2 = $(By.xpath(".//input[@id='filesourcekey-6289f2e207b6d']"));
        executeJavaScript("arguments[0].setAttribute('type', 'inline')",input );
        String file = "src/test/java/files/test.gif";
        input.uploadFile(new File(file));
        $(By.xpath(".//input[@value='Сохранить'] ")).click();

    }

    @Test(groups = "autorization")
    public void exitFromcourse() throws InterruptedException {
        app.TaskPage.open();
        $(By.xpath(".//a[@id='action-menu-toggle-2']")).click();
        $(By.xpath(".//div[@class='dropdown-item'] /child::a")).click();
        $(By.xpath(".//form[@method='post']/child::button")).click();

    }

    @Test(groups = "autorization")
    public void enrollAndExitFromcourse() throws InterruptedException {
       app.CoursePage.open();
       app.CoursePage.enroll();
       app.CoursePage.exit();
    }

    @Test(groups = "autorization")
    public void enrollCourseAndGetTask() throws InterruptedException {
        app.CoursePage.open();
        app.CoursePage.chooseTask("Практикум. Первая задача\nКонтестер")
                .sendAnswer()
                .setLang("Python 3")
                .sendCode(" g")
                .checkMyAnswers()
                .isEquals();

    }
}



