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
        getSearchbox().clear();
        getSearchbox().sendKeys(request);
        getSearchbtn().click();
        return new SearchPage(); // return search page
    }

    public static SubCategoriesPage chooseCourseCategory(String categoryName){
        int i = 0;
       for(SelenideElement element : getCourseCategories()){
           if (element.getText().equals(categoryName)){
               getCourseCategories().get(i).click();
           }
            i++;
       }
       return new SubCategoriesPage();
    }

    public CalendarPage moveToCalendarPage(){
        //   calendar  myhome  home
        String categoryName = "calendar";
        getNavigateMenu().click();
        for(SelenideElement element : getNavigateCategories()){
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
        getUserMenu().click();
        for(int i = 0; i< getUserMenuNameCategories().size(); i++){
            if(getUserMenuNameCategories().get(i).getText().equals(category)){
                getUserMenuHrefsCategories().get(i).click();
                break;
            }
        }
        return new UserPage();
    }

    public MessagePage moveToMessagePage( ){
        String category = "Сообщения";
        getUserMenu().click();
        for(int i = 0; i< getUserMenuNameCategories().size(); i++){
            if(getUserMenuNameCategories().get(i).getText().equals(category)){
                getUserMenuHrefsCategories().get(i).click();
                break;
            }
        }
        return new MessagePage();
    }

    public EditUserInfPage moveToSettingsPage( ){
        String category = "Настройки";
        getUserMenu().click();
        for(int i = 0; i< getUserMenuNameCategories().size(); i++){
            if(getUserMenuNameCategories().get(i).getText().equals(category)){
                getUserMenuHrefsCategories().get(i).click();
                break;
            }
        }
        return new EditUserInfPage();
    }

  /*  public mainPage chooseMyCourses(){

        return new mainPage();
    }

    public mainPage chooseContestCourse(){

        return new mainPage();
    }*/

    public SelenideElement getSearchbox() {
        return searchbox;
    }

    public SelenideElement getSearchbtn() {
        return searchbtn;
    }

    public SelenideElement getUserMenu() {
        return userMenu;
    }

    public ElementsCollection getUserMenuNameCategories() {
        return userMenuNameCategories;
    }

    public ElementsCollection getUserMenuHrefsCategories() {
        return userMenuHrefsCategories;
    }

    public SelenideElement getNavigateMenu() {
        return navigateMenu;
    }

    public ElementsCollection getCourseCategories() {
        return courseCategories;
    }

    public ElementsCollection getNavigateCategories() {
        return navigateCategories;
    }
    //  public void chooseCategory(){}
}
