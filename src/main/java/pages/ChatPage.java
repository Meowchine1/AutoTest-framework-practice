package pages;

import pages.common.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.interfaces.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChatPage extends BasePage implements Page {

    private static final ElementsCollection messages = $$(By.xpath(".//div[@data-region='message']"));
    private static final ElementsCollection messagesValues = $$(By.xpath(".//div[@data-region='message']//p"));
    private static final SelenideElement messageInputField = $(By.xpath(".//textarea"));
    private static final SelenideElement dialog = $(By.xpath(".//div[@class='list-group']/child::a"));
    private static final SelenideElement btnSend = $(By.xpath(".//button[@data-action='send-message']"));
    private static final SelenideElement btnDelete =
            $(By.xpath(".//button[@data-action='delete-selected-messages']"));
    private static final SelenideElement turnOnEnter =
            $(By.xpath(".//div[@data-preference='entertosend']/descendant::label"));
    private static final SelenideElement settingsBtn = $(By.xpath(".//a[@data-route='view-settings']"));

    public ChatPage(String pageUrl) {
        super(pageUrl);
    }

    public ChatPage() {
    }

    public void turnOnEnter() {
        settingsBtn.click();
        turnOnEnter.getAttribute("checked");
    }

    public void sendMessage(String text) {

        dialog.click();
        messageInputField.sendKeys(text);
        btnSend.click();
    }

    public void deleteMessage() {
        dialog.click();
      //  messages.click();
        btnDelete.click();
    }

    public void searchFriends(String name) {

    }
}
