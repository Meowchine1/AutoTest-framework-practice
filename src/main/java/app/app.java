package app;

import app.pages.*;
import app.pages.contextMenuPages.marksPage;
import app.pages.contextMenuPages.messagePage;
import app.pages.settingsPages.editUserInformationPage;
import app.pages.contextMenuPages.userPage;
import app.pages.settingsPages.languagePage;
import app.pages.settingsPages.passwordPage;

public class app {
    public final loginPage LoginPage;
    public final mainPage MainPage;
    public final marksPage MarksPage;
    public final messagePage MessagePage;
    public final editUserInformationPage editUserInformationPage;
    public final userPage UserPage;
    public final calendarPage CalendarPage;
    public final searchPage SearchPage;
    public final languagePage LanguagePage;
    public final passwordPage PasswordPage;
    public final coursePage CoursePage;
    public final taskPage  TaskPage;

    public app() {
        LoginPage = pageBuilder.buildLoginPage();
        MainPage = pageBuilder.buildMainPage();
        MarksPage = pageBuilder.buildMarksPage();
        MessagePage = pageBuilder.buildMessagePage();
        editUserInformationPage = pageBuilder.buildSettingsPage();
        UserPage = pageBuilder.buildUserPage();
        CalendarPage = pageBuilder.buildCalendarPage();
        SearchPage = pageBuilder.buildSearchPage();
        LanguagePage = pageBuilder.buildLanguagePage();
        PasswordPage = pageBuilder.buildPasswordPage();
        CoursePage = pageBuilder.buildCoursePage();
        TaskPage = pageBuilder.buildTaskPage();
    }
}
