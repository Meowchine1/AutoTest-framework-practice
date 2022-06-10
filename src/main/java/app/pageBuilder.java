package app;

import app.pages.*;
import app.pages.contextMenuPages.marksPage;
import app.pages.contextMenuPages.messagePage;
import app.pages.settingsPages.editUserInformationPage;
import app.pages.contextMenuPages.userPage;
import app.pages.settingsPages.languagePage;
import app.pages.settingsPages.passwordPage;

public class pageBuilder {

    public static loginPage buildLoginPage() {
        return new loginPage("/login");
    }
    public static mainPage buildMainPage() {
        return new mainPage("");
    }
    public static marksPage buildMarksPage() {
        return new marksPage("/grade/report/overview/index.php");
    }

    public static messagePage buildMessagePage() {
        return new messagePage("/message/index.php");
    }

    public static editUserInformationPage buildSettingsPage() {
        return new editUserInformationPage("/user/edit.php");
    }

    public static userPage buildUserPage() {
        return new userPage("/user/profile.php?id=31455");
    }

    public static calendarPage buildCalendarPage() {
        return new calendarPage("/calendar/view.php?view=month");
    }

    public static searchPage buildSearchPage() {
        return new searchPage("/course/search.php?q=&areaids=core_course-course");
    }
    public static languagePage buildLanguagePage() {
        return new languagePage("");
    }

     public static passwordPage buildPasswordPage() {
        return new passwordPage("");
    }
     public static coursePage  buildCoursePage() {
        return new coursePage ("enrol/index.php?id=181");
    }
    public static taskPage buildTaskPage() {
        return new taskPage("/course/view.php?id=181");
    }


//https://school.sgu.ru/mod/assign/view.php?id=11533&action=editsubmission
//https://school.sgu.ru/message/index.php

}
