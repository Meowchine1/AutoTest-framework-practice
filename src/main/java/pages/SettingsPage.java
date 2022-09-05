package pages;

import pages.base.BasePage;
import pages.base.Page;

public class SettingsPage extends BasePage implements Page {

    public UserInfEditorPage goToUserInfEditorPage(){

        return new UserInfEditorPage();
    }
    public PasswordPage goToPasswordPage() {
        return new PasswordPage();}

    public SettingsPage() {
    }

    public SettingsPage(String pageUrl) {
        super(pageUrl);
    }
}
