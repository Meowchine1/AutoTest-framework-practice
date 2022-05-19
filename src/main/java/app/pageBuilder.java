package app;

import app.pages.loginPage;
import app.pages.mainPage;
import app.pages.myPage;

public class pageBuilder {

    public static loginPage buildLoginPage() {
        return new loginPage("/login");
    }

    public static mainPage buildMainPage() {
        return new mainPage("");
    }

    public static myPage buildOwnPage() {
        return new myPage("my/");
    }


}
