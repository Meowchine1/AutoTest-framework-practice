package app.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;

public class categoryListPage extends basePage{
    public final SelenideElement course = $(By.xpath(".//h3[@class = 'coursename']/child::a"));

    public categoryListPage() { }

    public void chooseCourse(String courseName){
        course.click();
    }
}
