package app;

import pages.*;

public class App {
    public final LoginPage loginPage;
    public final MainPage mainPage;
    public final ChatPage chatPage;
    public final UserInfEditorPage userInfEditorPage;
    public final UserPage userPage;
    public final SearchPage searchPage;
    public final PasswordPage passwordPage;
    public final CoursePage coursePage;
    public final TaskPage taskPage;

    public App() {
        loginPage = (LoginPage) PageInitializer.initialize(LoginPage.class);
        mainPage = (MainPage) PageInitializer.initialize(MainPage.class);
        chatPage = (ChatPage) PageInitializer.initialize(ChatPage.class);
        userInfEditorPage = (UserInfEditorPage) PageInitializer.initialize(UserInfEditorPage.class);
        userPage = (UserPage) PageInitializer.initialize(UserPage.class);
        searchPage = (SearchPage) PageInitializer.initialize(SearchPage.class);
        passwordPage = (PasswordPage) PageInitializer.initialize(PasswordPage.class);
        coursePage = (CoursePage) PageInitializer.initialize(CoursePage.class);
        taskPage = (TaskPage) PageInitializer.initialize(TaskPage.class);
    }
}
