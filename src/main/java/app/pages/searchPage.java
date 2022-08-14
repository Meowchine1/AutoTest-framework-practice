package app.pages;

import app.pages.basePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class searchPage extends basePage {
    public final String exseptionMessage = "не найдено";
    public final int maxLength = 20;
    public final SelenideElement exseptionMessageLocator = $(By.xpath(".//h2"));
    public final ElementsCollection searcresults = $$(By.xpath(".//a[@class='aalink']"));
    public final ElementsCollection searcresultsContent = $$(By.xpath(".//div[@data-type='1'] /descendant::div[@class='content']"));
    public final SelenideElement searcresultsContentNoResults = $(By.xpath(".//div[@id='page-content'] "));
    public final SelenideElement searchInput = $("#coursesearchbox");

    public final SelenideElement showall = $(By.xpath("//*[contains(text(),'Показать все')]"));
    public final SelenideElement searchBtn = $(By.xpath(".//button[@type='submit']"));

    public searchPage(String pageUrl) {
        super(pageUrl);
    }
    public searchPage(){}
//Курсов со словами «$» не найдено
    public boolean validSearch(String request) {
        searchInput.sendKeys(request);
        searchBtn.click();
        showall.click();
        int i = 0;
        //не найдено
        if(searcresultsContentNoResults.getText().contains("найдено")){
            return true;
        }
            for(SelenideElement element : searcresults)
            {
                if(!searcresults.get(i).getText().toLowerCase().contains(request) &
                        !searcresultsContent.get(i).getText().toLowerCase().contains(request)){
                    System.out.print(searcresults.get(i).getText() + "  " + searcresultsContent.get(i).getText() );
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
                        .contains(exseptionMessage));
        }

        public boolean writeBigSizeString(String request){
            searchInput.sendKeys(request);
            System.out.print(searchInput.getText());
            if(request.length()>20){
                return request.substring(0,maxLength-1).equals(searchInput.getText());
            }
            return true;
        }
}
