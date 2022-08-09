package app.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class coursePage extends basePage{
    public SelenideElement enrollCourse = $(By.xpath(".//input[@type='submit']"));
    public final ElementsCollection userMenuNameCategories = $$(By.xpath(".//div[@class='activityinstance']/descendant::span[@class='instancename']"));
    public final ElementsCollection userMenuHrefsCategories = $$(By.xpath(".//div[@class='activityinstance']"));

    public coursePage(String pageUrl) {
        super(pageUrl);
    }
    public coursePage(){}

    public void enroll(){
        enrollCourse.click();
    }

    public void exit(){
         $(By.xpath(".//a[@id='action-menu-toggle-2']")).click();
         $(By.xpath(".//div[@class='dropdown-item'] /child::a")).click();
         $(By.xpath(".//form[@method='post']/child::button")).click();
    }

    public taskPage chooseTask(String courseName){
        int i = 0;
        for(SelenideElement element : userMenuNameCategories){
            if (element.getText().equals(courseName)){
                userMenuHrefsCategories.get(i).click();
                break;
            }
            i++;
        }
        return new taskPage();

    }


}