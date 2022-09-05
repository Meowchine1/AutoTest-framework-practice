package pages;
import pages.base.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.base.Page;
import org.openqa.selenium.By;
import pages.commonElements.UserMenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BasePage implements Page {
    private static final SelenideElement searchbox = $("#shortsearchbox");
    private static final SelenideElement searchbtn = $(By.xpath("//button[@type ='submit']"));
  //  private static final SelenideElement userMenu = $(By.xpath(".//div[@class = 'dropdown']/child::a"));
  //  private static final ElementsCollection userMenuNameCategories = $$(By.xpath(".//div[@data-rel='menu-content']/descendant::i/following-sibling::*"));
    //private static final ElementsCollection userMenuHrefsCategories = $$(By.xpath(".//div[@data-rel='menu-content']/descendant::a"));
    private static final SelenideElement navigateMenu = $(By.xpath("//div[@class='d-inline-block mr-3']/child::button"));
    private static final ElementsCollection courseCategories = $$(By.xpath(".//div[@class = 'category loaded']//a"));
    private static final ElementsCollection navigateCategories = $$(By.xpath(".//nav[@class = 'list-group']/descendant::a"));

    private final UserMenu userMenu = new UserMenu();

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




}
