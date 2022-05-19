package app.pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Href;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class mainPage extends basePage {
    public final SelenideElement searchbox = $("#shortsearchbox");
    public final SelenideElement searchbtn = $(By.xpath("//*[text() = 'Применить'] "));
    public final SelenideElement navigateMenu = $(By.xpath("//div[@class='d-inline-block mr-3']/child::button"));
    public final ElementsCollection categories = $$(By.xpath(".//div[@class = 'category loaded']//a"));

    public mainPage(String pageUrl) {
        super(pageUrl);
    }
    public mainPage() {
        super();
    }

    public void search(){}
    public void chooseCategory(String categoryName){
        
       for(SelenideElement element : categories){
          System.out.println(element.getText() + categoryName);
       }

    }
    public void chooseCalendar(){}
    public void chooseOwnRoom(){}
    public void chooseMyCourses(){


    }

    public void chooseContestCourse(){


    }
  //  public void chooseCategory(){}
}
