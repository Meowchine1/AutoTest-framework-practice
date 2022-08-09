package app.pages;
import app.pages.contextMenuPages.messagePage;
import app.pages.settingsPages.editUserInformationPage;
import app.pages.contextMenuPages.userPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class mainPage extends basePage {
    public final SelenideElement searchbox = $("#shortsearchbox");
    public final SelenideElement searchbtn = $(By.xpath("//button[@type ='submit']"));
    public final SelenideElement userMenu = $(By.xpath(".//div[@class = 'dropdown']/child::a"));
    public final ElementsCollection userMenuNameCategories = $$(By.xpath(".//div[@data-rel='menu-content']/descendant::i/following-sibling::*"));
    public final ElementsCollection userMenuHrefsCategories = $$(By.xpath(".//div[@data-rel='menu-content']/descendant::a"));
    public final SelenideElement navigateMenu = $(By.xpath("//div[@class='d-inline-block mr-3']/child::button"));
    public final ElementsCollection courseCategories = $$(By.xpath(".//div[@class = 'category loaded']//a"));
    public final ElementsCollection navigateCategories = $$(By.xpath(".//nav[@class = 'list-group']/descendant::a"));

    public mainPage(String pageUrl) {
        super(pageUrl);
    }
    public mainPage() {
        super();
    }

    public searchPage search(String request){
        getSearchbox().clear();
        getSearchbox().sendKeys(request);
        getSearchbtn().click();
        return new searchPage(); // return search page
    }

    public subCategoriesPage chooseCourseCategory(String categoryName){
        int i = 0;
       for(SelenideElement element : getCourseCategories()){
           if (element.getText().equals(categoryName)){
               getCourseCategories().get(i).click();
           }
            i++;
       }
       return new subCategoriesPage();
    }

    public calendarPage moveToCalendarPage(){
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
        return new calendarPage();
    }

    public userPage moveToUserPage( ){
        String category = "О пользователе";
        getUserMenu().click();
        for(int i = 0; i< getUserMenuNameCategories().size(); i++){
            if(getUserMenuNameCategories().get(i).getText().equals(category)){
                getUserMenuHrefsCategories().get(i).click();
                break;
            }
        }
        return new userPage();
    }

    public messagePage moveToMessagePage( ){
        String category = "Сообщения";
        getUserMenu().click();
        for(int i = 0; i< getUserMenuNameCategories().size(); i++){
            if(getUserMenuNameCategories().get(i).getText().equals(category)){
                getUserMenuHrefsCategories().get(i).click();
                break;
            }
        }
        return new messagePage();
    }

    public editUserInformationPage moveToSettingsPage( ){
        String category = "Настройки";
        getUserMenu().click();
        for(int i = 0; i< getUserMenuNameCategories().size(); i++){
            if(getUserMenuNameCategories().get(i).getText().equals(category)){
                getUserMenuHrefsCategories().get(i).click();
                break;
            }
        }
        return new editUserInformationPage();
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
