package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import helpers.ConfigProvider;
import org.apache.commons.lang3.RandomStringUtils;
import pages.base.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.base.Page;
import org.openqa.selenium.By;
import pages.commonElements.UserMenu;

import java.nio.charset.Charset;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage extends BasePage implements Page {
    private static final SelenideElement notFound = $(By.xpath(".//div[@id='page-content']/descendant::h2"));
    private static final SelenideElement searchInput = $("#coursesearchbox");
    private static final SelenideElement showall_ru = $(By.xpath("//*[contains(text(),'Показать все')]"));
    private static final SelenideElement showall_en = $(By.xpath("//*[contains(text(),'Show all')]"));
    private static final SelenideElement searchBtn = $(By.xpath(".//button[@type='submit']"));
    private static final ElementsCollection responses = $$(By.xpath(".//h3[@class='coursename']"));
    private static final ElementsCollection matches = $$(By.xpath(".//h3[@class='coursename']/descendant::span"));

    private static final  String QUICK_SEARCH_HREF = ConfigProvider.QUICK_SEARCH;
    private static final  String EXSEPTION_MESSAGE_RU = "не найдено";
    private static final  String EXSEPTION_MESSAGE_EN = "No courses were found with the words";
    private static final  int MAX_LENGTH = 20;

    private final UserMenu userMenu = new UserMenu();

    public SearchPage(String pageUrl) {
        super(pageUrl);
    }

    public SearchPage() {
    }

    public boolean quickSearch(String request){

        Selenide.open(QUICK_SEARCH_HREF + request);

        if(responses.isEmpty()){  // hz
            return true;
        }

        if (showall_ru.isDisplayed()){
            showall_ru.click();
        }
        else if (showall_en.isDisplayed()){
            showall_en.click();
        }

        return responses.size() == matches.size();

    }

    public boolean search(String request){
        searchInput.sendKeys(request);
        searchBtn.click();

        if(responses.isEmpty()){ // hz
            return true;
        }

        if (showall_ru.isDisplayed()){
            showall_ru.click();
        }
        else if (showall_en.isDisplayed()){
            showall_en.click();
        }

        return responses.size() == matches.size();
    }

    public boolean invalidSearch(String request) { // invalid requests collection
        searchInput.sendKeys(request);
        searchBtn.click();
        return notFound.text().contains(EXSEPTION_MESSAGE_RU) | notFound.text().contains(EXSEPTION_MESSAGE_EN);

    }

    public boolean invalidQuickSearch(String request) { // invalid requests collection
        Selenide.open(QUICK_SEARCH_HREF + request);

        return notFound.text().contains(EXSEPTION_MESSAGE_RU) | notFound.text().contains(EXSEPTION_MESSAGE_EN);
    }


    public void longSearchRequest() {
        searchInput.sendKeys(generateString());
        System.out.print(searchInput.getText());
        notFound.shouldBe(Condition.visible);
    }

    private static String generateString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5000;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
