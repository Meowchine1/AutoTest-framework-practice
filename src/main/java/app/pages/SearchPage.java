package app.pages;

import app.pages.common.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage extends BasePage {
    public static final String exseptionMessage = "не найдено";
    public static final int maxLength = 20;
    public static final SelenideElement exseptionMessageLocator = $(By.xpath(".//h2"));
    public static final ElementsCollection searcresults = $$(By.xpath(".//a[@class='aalink']"));
    public static final ElementsCollection searcresultsContent = $$(By.xpath(".//div[@data-type='1']" +
            " /descendant::div[@class='content']"));
    public static final SelenideElement searcresultsContentNoResults = $(By.xpath(".//div[@id='page-content'] "));
    public static final SelenideElement searchInput = $("#coursesearchbox");
    public static final SelenideElement showall = $(By.xpath("//*[contains(text(),'Показать все')]"));
    public static final SelenideElement searchBtn = $(By.xpath(".//button[@type='submit']"));

    public SearchPage(String pageUrl) {
        super(pageUrl);
    }

    public SearchPage() {
    }

    //Курсов со словами «$» не найдено
    public static boolean validSearch(String request) {
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

    public static boolean invalidSearch(String request) {
        searchInput.sendKeys(request);
        searchBtn.click();
        return (exseptionMessageLocator
                .getText()
                .toLowerCase()
                .contains(exseptionMessage));
    }

    public static boolean writeBigSizeString(String request) {
        searchInput.sendKeys(request);
        System.out.print(searchInput.getText());
        if (request.length() > 20) {
            return request.substring(0, maxLength - 1).equals(searchInput.getText());
        }
        return true;
    }
}
