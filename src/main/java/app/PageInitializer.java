package app;

import pages.*;
import pages.settingsPages.*;
import pages.interfaces.Page;

public class PageInitializer {

    public static Page initialize(Class type) {
        if (MainPage.class.equals(type)) {
            return new MainPage(AppConfig.MAIN_URL);
        } else if (CalendarPage.class.equals(type)) {
            return new CalendarPage(AppConfig.CALENDAR_URL);
        } else if (LoginPage.class.equals(type)) {
            return new LoginPage(AppConfig.LOGIN_URL);
        } else if (MarksPage.class.equals(type)) {
            return new MarksPage(AppConfig.MARKS_URL);
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
        return new NotFoundPage();
    }


}
