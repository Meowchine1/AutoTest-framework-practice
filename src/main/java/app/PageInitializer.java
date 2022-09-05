package app;

import helpers.ConfigProvider;
import pages.*;
import pages.base.Page;

public class PageInitializer {

    public static Page initialize(Class type) {
        if (MainPage.class.equals(type)) {
            return new MainPage(ConfigProvider.MAIN_URL);
        } else if (LoginPage.class.equals(type)) {
            return new LoginPage(ConfigProvider.LOGIN_URL);
        } else if (ChatPage.class.equals(type)) {
            return new ChatPage(ConfigProvider.CHAT_URL);
        } else if (UserInfEditorPage.class.equals(type)) {
            return new UserInfEditorPage(ConfigProvider.USER_INF_EDITOR_URL);
        } else if (UserPage.class.equals(type)) {
            return new UserPage(ConfigProvider.USER_URL);
        } else if (SearchPage.class.equals(type)) {
            return new SearchPage(ConfigProvider.SEARCH_URL);
        } else if (PasswordPage.class.equals(type)) {
            return new PasswordPage(ConfigProvider.PASSWORD_URL);
        } else if (CoursePage.class.equals(type)) {
            return new CoursePage(ConfigProvider.COURSE_URL);
        } else if (TaskPage.class.equals(type)) {
            return new TaskPage(ConfigProvider.TASK_URL);
        }
        else if (SettingsPage.class.equals(type)){
            return new SettingsPage(ConfigProvider.SETTINGS_URL);
        }
        return new NotFoundPage();
    }


}
