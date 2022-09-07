package pages;

import com.github.javafaker.Faker;
import pages.base.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.base.Page;
import org.openqa.selenium.By;
import pages.commonElements.UserMenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChatPage extends BasePage implements Page {
    private Faker faker = new Faker();
    private static final SelenideElement message = $(By.xpath(".//div[@data-region='message']"));
    private static final SelenideElement searchInputField = $(By.xpath(".//input[@data-region='search-input']"));
    private static final SelenideElement searchBtn = $(By.xpath(".//button[@aria-label='Search']"));
    private static final SelenideElement messageInputField = $(By.xpath(".//textarea"));
    private static final SelenideElement dialog = $(By.xpath(".//div[@class='list-group']/child::a"));
    private static final SelenideElement btnSend = $(By.xpath(".//button[@data-action='send-message']"));
    private static final SelenideElement btnDelete =
            $(By.xpath(".//button[@data-action='delete-selected-messages']"));

    public static final UserMenu userMenu = new UserMenu();

    public ChatPage(String pageUrl) {
        super(pageUrl);
    }

    public ChatPage() {
    }

    public void sendMessage(String text) {

        dialog.click();
        messageInputField.sendKeys(text);
        btnSend.click();
    }

    public void deleteMessage() {

        sendMessage(faker.animal().name());
        message.click();
        btnDelete.click();
    }

    public void searchDialog(String name) {
        searchInputField.sendKeys(name);
        searchBtn.click();
    }
}
