package app.pages.contextMenuPages;

import app.pages.basePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class messagePage extends basePage {
    private final SelenideElement messageText = $(By.xpath(".//div[@data-region='text-container']" ));
    private final SelenideElement messageClick = $(By.xpath(".//div[@data-region='message']" ));
    private final SelenideElement messageField = $(By.xpath(".//textarea" ));
    private final SelenideElement dialog = $(By.xpath(".//div[@class='list-group']/child::a" ));
    private final SelenideElement btnSend = $(By.xpath(".//button[@data-action='send-message']" ));
    private final SelenideElement btnDelete = $(By.xpath(".//button[@data-action='delete-selected-messages']" ));
    private final SelenideElement turnOnEnter = $(By.xpath(".//div[@data-preference='entertosend']/descendant::label"));
    private final SelenideElement settingsBtn = $(By.xpath(".//a[@data-route='view-settings']"));

    public messagePage(String pageUrl) {
        super(pageUrl);
    }

    public messagePage() {
    }

    public void turnOnEnter(){
        settingsBtn.click();
        turnOnEnter.getAttribute("checked");
    }

    public void sendMessage(String text){

        dialog.click();
        messageField.sendKeys(text);
        btnSend.click();
    }

    public void deleteMessage(){
        dialog.click();
        messageClick.click();
        btnDelete.click();
    }

    public void searchFriends(String name){

    }
}
