package app;

import app.pages.*;
import app.pages.settings.*;

public class App {
    public final LoginPage loginPage;
    public final MainPage mainPage;
    public final MarksPage marksPage;
    public final MessagePage messagePage;
    public final EditUserInfPage editUserInfPage;
    public final UserPage userPage;
    public final CalendarPage calendarPage;
    public final SearchPage searchPage;
    public final PasswordPage passwordPage;
    public final CoursePage coursePage;
    public final TaskPage taskPage;

    public App() {
        loginPage = PageBuilder.buildLoginPage();
        mainPage = PageBuilder.buildMainPage();
        marksPage = PageBuilder.buildMarksPage();
        messagePage = PageBuilder.buildMessagePage();
        editUserInfPage = PageBuilder.buildSettingsPage();
        userPage = PageBuilder.buildUserPage();
        calendarPage = PageBuilder.buildCalendarPage();
        searchPage = PageBuilder.buildSearchPage();
        passwordPage = PageBuilder.buildPasswordPage();
        coursePage = PageBuilder.buildCoursePage();
        taskPage = PageBuilder.buildTaskPage();
    }
}
