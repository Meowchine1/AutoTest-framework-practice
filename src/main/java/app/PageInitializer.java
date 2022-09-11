package app;


import pages.*;
import pages.base.Page;

public class PageInitializer {

    public static Page initialize(Class type) {
        if (MainPage.class.equals(type)) {
            return new MainPage("");
        } else if (LoginPage.class.equals(type)) {
            return new LoginPage("/login");
        } else if (ChatPage.class.equals(type)) {
            return new ChatPage(AppConfig.CHAT_URL);
        } else if (UserInfEditorPage.class.equals(type)) {
            return new UserInfEditorPage(AppConfig.USER_INF_EDITOR_URL);
        } else if (UserPage.class.equals(type)) {
            return new UserPage(AppConfig.USER_URL);
        } else if (SearchPage.class.equals(type)) {
            return new SearchPage(AppConfig.SEARCH_URL);
        } else if (PasswordPage.class.equals(type)) {
            return new PasswordPage(AppConfig.PASSWORD_URL);
        } else if (CoursePage.class.equals(type)) {
            return new CoursePage(AppConfig.COURSE_URL);
        } else if (TaskPage.class.equals(type)) {
            return new TaskPage(AppConfig.TASK_URL);
        }
      else if (SettingsPage.class.equals(type)){
           return new SettingsPage(AppConfig.SETTINGS_URL);
        }
        return new NotFoundPage();
    }


}
