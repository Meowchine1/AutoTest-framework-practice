package app.pages;
import app.pages.common.BasePage;
import app.pages.settings.EditUserInfPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BasePage {
    public final SelenideElement searchbox = $("#shortsearchbox");
    public final SelenideElement searchbtn = $(By.xpath("//button[@type ='submit']"));
    public final SelenideElement userMenu = $(By.xpath(".//div[@class = 'dropdown']/child::a"));
    public final ElementsCollection userMenuNameCategories = $$(By.xpath(".//div[@data-rel='menu-content']/descendant::i/following-sibling::*"));
    public final ElementsCollection userMenuHrefsCategories = $$(By.xpath(".//div[@data-rel='menu-content']/descendant::a"));
    public final SelenideElement navigateMenu = $(By.xpath("//div[@class='d-inline-block mr-3']/child::button"));
    public final ElementsCollection courseCategories = $$(By.xpath(".//div[@class = 'category loaded']//a"));
    public final ElementsCollection navigateCategories = $$(By.xpath(".//nav[@class = 'list-group']/descendant::a"));

    public MainPage(String pageUrl) {
        super(pageUrl);
    }
    public MainPage() {
        super();
    }

    public SearchPage search(String request){
        searchbox.clear();
        searchbox.sendKeys(request);
        searchbtn.click();
        return new SearchPage(); // return search page
    }

    public SubCategoriesPage chooseCourseCategory(String categoryName){
        int i = 0;
       for(SelenideElement element : courseCategories){
           if (element.getText().equals(categoryName)){
               courseCategories.get(i).click();
           }
            i++;
       }
       return new SubCategoriesPage();
    }

    public CalendarPage moveToCalendarPage(){
        //   calendar  myhome  home
        String categoryName = "calendar";
        navigateMenu.click();
        for(SelenideElement element : navigateCategories){
            if(Objects.equals(element.getAttribute("data-key"), categoryName))
            {
                element.click();
                break;
            }
        }
        return new CalendarPage();
    }

    public UserPage moveToUserPage( ){
        String category = "О пользователе";
        userMenu.click();
        for(int i = 0; i< userMenuNameCategories.size(); i++){
            if(userMenuNameCategories.get(i).getText().equals(category)){
                userMenuHrefsCategories.get(i).click();
                break;
            }
        }
        return new UserPage();
    }

    public MessagePage moveToMessagePage( ){
        String category = "Сообщения";
        userMenu.click();
        for(int i = 0; i< userMenuNameCategories.size(); i++){
            if(userMenuNameCategories.get(i).getText().equals(category)){
                userMenuHrefsCategories.get(i).click();
                break;
            }
        }
        return new MessagePage();
    }

    public EditUserInfPage moveToSettingsPage( ){
        String category = "Настройки";
        userMenu.click();
        for(int i = 0; i< userMenuNameCategories.size(); i++){
            if(userMenuNameCategories.get(i).getText().equals(category)){
                userMenuHrefsCategories.get(i).click();
                break;
            }
        }
        return new EditUserInfPage();
    }

}
