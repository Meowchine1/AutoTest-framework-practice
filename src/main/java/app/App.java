package app;

import app.pages.*;
import app.pages.settings.*;
import helpers.PageType;

public class App {
    public final LoginPage loginPage;
    public final MainPage mainPage;
    public final MarksPage marksPage;
    public final MessengerPage messengerPage;
    public final UserInfEditorPage userInfEditorPage;
    public final UserPage userPage;
    public final CalendarPage calendarPage;
    public final SearchPage searchPage;
    public final PasswordPage passwordPage;
    public final CoursePage coursePage;
    public final TaskPage taskPage;

    public App() {
        loginPage = (LoginPage) PageFactory.getPage(PageType.LOGIN);
        mainPage = (MainPage) PageFactory.getPage(PageType.MAIN);
        marksPage = (MarksPage) PageFactory.getPage(PageType.MARKS);
        messengerPage = (MessengerPage) PageFactory.getPage(PageType.MESSENGER);
        userInfEditorPage = (UserInfEditorPage) PageFactory.getPage(PageType.USER_INF_EDITOR);
        userPage = (UserPage) PageFactory.getPage(PageType.USER);
        calendarPage = (CalendarPage) PageFactory.getPage(PageType.CALENDAR);
        searchPage = (SearchPage) PageFactory.getPage(PageType.SEARCH);
        passwordPage = (PasswordPage) PageFactory.getPage(PageType.PASSWORD);
        coursePage = (CoursePage) PageFactory.getPage(PageType.COURSE);
        taskPage = (TaskPage) PageFactory.getPage(PageType.TASK);
    }
}
