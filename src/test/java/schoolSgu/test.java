package schoolSgu;
import base.baseTest;
import utils.UrlValidator;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class test extends baseTest {

    @Test
    public void choseCategory(){
        app.MainPage
                .chooseCategory("Задачник");
               // .chooseCourse("Задачник по программированию");

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