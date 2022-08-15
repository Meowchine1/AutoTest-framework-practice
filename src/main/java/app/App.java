package app;

import app.pages.settings.EditUserInfPage;

public class App {
    public final app.pages.LoginPage LoginPage;
    public final app.pages.MainPage MainPage;
    public final app.pages.MarksPage MarksPage;
    public final app.pages.MessagePage MessagePage;
    public final EditUserInfPage editUserInformationPage;
    public final app.pages.UserPage UserPage;
    public final app.pages.CalendarPage CalendarPage;
    public final app.pages.SearchPage SearchPage;
    public final app.pages.settings.PasswordPage PasswordPage;
    public final app.pages.CoursePage CoursePage;
    public final app.pages.TaskPage TaskPage;

    public App() {
        LoginPage = PageBuilder.buildLoginPage();
        MainPage = PageBuilder.buildMainPage();
        MarksPage = PageBuilder.buildMarksPage();
        MessagePage = PageBuilder.buildMessagePage();
        editUserInformationPage = PageBuilder.buildSettingsPage();
        UserPage = PageBuilder.buildUserPage();
        CalendarPage = PageBuilder.buildCalendarPage();
        SearchPage = PageBuilder.buildSearchPage();
        PasswordPage = PageBuilder.buildPasswordPage();
        CoursePage = PageBuilder.buildCoursePage();
        TaskPage = PageBuilder.buildTaskPage();
    }
}
