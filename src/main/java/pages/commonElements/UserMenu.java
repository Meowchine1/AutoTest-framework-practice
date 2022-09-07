package pages.commonElements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.ConfigProvider;
import org.openqa.selenium.By;
import pages.ChatPage;
import pages.PasswordPage;
import pages.SettingsPage;
import pages.UserPage;

import static com.codeborne.selenide.Selenide.$;

public class UserMenu  {
    private static final SelenideElement logout = $(By.xpath(".//a[@data-title='logout,moodle']"));
    private static final SelenideElement moveToSettings = $(By.xpath(".//a[@data-title='preferences,moodle']"));
    private static final SelenideElement moveToChat = $(By.xpath(".//a[@data-title='messages,message']"));
    private static final SelenideElement dropDownMenu = $(By.xpath(".//div[@class = 'dropdown']/child::a"));
    private static final SelenideElement dropDownLanguageMenu = $(By.xpath(".//a[@class='dropdown-toggle nav-link']"));

    public UserMenu() {
    }

    public static void changeLanguageToEng(){
        dropDownLanguageMenu.click();
        Selenide.open(ConfigProvider.CHANGE_LANGUAGE_TO_ENG);
    }

    public static void changeLanguageToRus(){
        dropDownLanguageMenu.click();
        Selenide.open(ConfigProvider.CHANGE_LANGUAGE_TO_RUS);
    }

    public static void logout(){
        dropDownMenu.click();
        logout.click();
    }

    public static ChatPage goToChatPage(){
        dropDownMenu.click();
        moveToChat.click();
        return new ChatPage();
    }

    public static SettingsPage goToSettingsPage(){
        dropDownMenu.click();
        moveToSettings.click();
        return new SettingsPage();
    }

}
