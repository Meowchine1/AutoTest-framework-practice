package app.pages;

import app.pages.common.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CoursePage extends BasePage {
    private static final SelenideElement enrollCourse =
            $(By.xpath(".//input[@type='submit']"));
    private static final ElementsCollection userMenuNameCategories =
            $$(By.xpath(".//div[@class='activityinstance']/descendant::span[@class='instancename']"));
    private static final ElementsCollection userMenuHrefsCategories =
            $$(By.xpath(".//div[@class='activityinstance']"));

    public CoursePage(String pageUrl) {
        super(pageUrl);
    }

    public CoursePage() {
    }

    public CoursePage enroll() {
        enrollCourse.click();
        return this;
    }

    public CoursePage exit() {
        $(By.xpath(".//a[@id='action-menu-toggle-2']")).click();
        $(By.xpath(".//div[@class='dropdown-item'] /child::a")).click();
        $(By.xpath(".//form[@method='post']/child::button")).click();
        return this;
    }

    public TaskPage chooseTask(String courseName) {
        int i = 0;
        for (SelenideElement element : userMenuNameCategories) {
            if (element.getText().equals(courseName)) {
                userMenuHrefsCategories.get(i).click();
                break;
            }
            i++;
        }
        return new TaskPage();

    }

}
