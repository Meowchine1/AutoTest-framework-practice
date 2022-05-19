package app;

import app.pages.loginPage;
import app.pages.mainPage;
import app.pages.myPage;

public class app {

    public final loginPage LoginPage;
    public final mainPage MainPage;
    public final myPage OwnPage;

    public app() {

        LoginPage = pageBuilder.buildLoginPage();
        MainPage = pageBuilder.buildMainPage();
        OwnPage = pageBuilder.buildOwnPage();

    }
}
