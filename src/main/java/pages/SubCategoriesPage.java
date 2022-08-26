package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.interfaces.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SubCategoriesPage implements Page {
    private static final ElementsCollection courses = $$(By.xpath(".//a[@class='aalink']"));
    private static final SelenideElement nextBtn = $(By.xpath(".//a[@aria-label='Next']"));
    private static final SelenideElement submitBtn = $(By.xpath(".//input[@type ='submit']"));

    public SubCategoriesPage() {
    }

    public void chooseCourse(String courseName) {
        boolean isFind = false;
        while (nextBtn.exists()) {
            int i = 0;
            for (SelenideElement element : courses) {  // меняется ли локатор коллекции после
                if (element.getText().equals(courseName)) {
                    courses.get(i).click();
                    isFind = true;
                    break;
                }
                i++;
            }
            nextBtn.click();
        }
        if (!isFind) {
            int i = 0;
            for (SelenideElement element : courses) {
                if (element.getText().equals(courseName)) {
                    courses.get(i).click();
                }
                i++;
            }
        }
    }

    public TaskPage submitCourse() {
        submitBtn.shouldBe(Condition.visible).click();
        return new TaskPage();
    }


}
