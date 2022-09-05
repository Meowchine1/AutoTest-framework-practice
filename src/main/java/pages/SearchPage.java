package pages;

import pages.base.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.base.Page;
import org.openqa.selenium.By;
import pages.commonElements.UserMenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage extends BasePage implements Page {
    private static final SelenideElement exseptionMessageLocator = $(By.xpath(".//h2"));
    private static final ElementsCollection searcresults = $$(By.xpath(".//a[@class='aalink']"));
    private static final ElementsCollection searcresultsContent =
            $$(By.xpath(".//div[@data-type='1']/descendant::div[@class='content']"));
    private static final SelenideElement searcresultsContentNoResults = $(By.xpath(".//div[@id='page-content'] "));
    private static final SelenideElement searchInput = $("#coursesearchbox");
    private static final SelenideElement showall = $(By.xpath("//*[contains(text(),'Показать все')]"));
    private static final SelenideElement searchBtn = $(By.xpath(".//button[@type='submit']"));

    private static final  String QUICK_SEARCH_HREF = PageHrefs.quickSearchHref;
    private static final  String EXSEPTION_MESSAGE = "не найдено";
    private static final  int MAX_LENGTH = 20;

    private final UserMenu userMenu = new UserMenu();

    public SearchPage(String pageUrl) {
        super(pageUrl);
    }

    public SearchPage() {
    }

    //Курсов со словами «$» не найдено
    public boolean validSearch(String request) {
        searchInput.sendKeys(request);
        searchBtn.click();
        showall.click();
        int i = 0;
        //не найдено
        if (searcresultsContentNoResults.getText().contains("найдено")) {
            return true;
        }
        for (SelenideElement element : searcresults) {
            if (!searcresults.get(i).getText().toLowerCase().contains(request) &
                    !searcresultsContent.get(i).getText().toLowerCase().contains(request)) {
                System.out.print(searcresults.get(i).getText() + "  " + searcresultsContent.get(i).getText());
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean invalidSearch(String request) {
        searchInput.sendKeys(request);
        searchBtn.click();
        return (exseptionMessageLocator
                .getText()
                .toLowerCase()
                .contains(EXSEPTION_MESSAGE));
    }

    public boolean writeBigSizeString(String request) {
        searchInput.sendKeys(request);
        System.out.print(searchInput.getText());
        if (request.length() > 20) {
            return request.substring(0, MAX_LENGTH - 1).equals(searchInput.getText());
        }
        return true;
    }
}
