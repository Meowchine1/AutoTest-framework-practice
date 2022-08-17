package app.pages;

import app.pages.common.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MessagePage extends BasePage {
    private static final SelenideElement messageText = $(By.xpath(".//div[@data-region='text-container']"));
    private static final SelenideElement messageClick = $(By.xpath(".//div[@data-region='message']"));
    private static final SelenideElement messageField = $(By.xpath(".//textarea"));
    private static final SelenideElement dialog = $(By.xpath(".//div[@class='list-group']/child::a"));
    private static final SelenideElement btnSend = $(By.xpath(".//button[@data-action='send-message']"));
    private static final SelenideElement btnDelete =
            $(By.xpath(".//button[@data-action='delete-selected-messages']"));
    private static final SelenideElement turnOnEnter =
            $(By.xpath(".//div[@data-preference='entertosend']/descendant::label"));
    private static final SelenideElement settingsBtn = $(By.xpath(".//a[@data-route='view-settings']"));

    public MessagePage(String pageUrl) {
        super(pageUrl);
    }

    public MessagePage() {
    }

    public void turnOnEnter() {
        settingsBtn.click();
        turnOnEnter.getAttribute("checked");
    }

    public void sendMessage(String text) {

        dialog.click();
        messageField.sendKeys(text);
        btnSend.click();
    }

    public void deleteMessage() {
        dialog.click();
        messageClick.click();
        btnDelete.click();
    }

    public void searchFriends(String name) {

    }
}
