package app;

import app.pages.*;
import app.pages.settings.*;
import helpers.Page;
import helpers.PageType;

public class PageFactory {


    public static Page getPage(PageType type) {
        switch (type) {
            case MAIN -> {
                return new MainPage("");
            }
            case CALENDAR -> {
                return new CalendarPage("/calendar/view.php?view=month");
            }
            case LOGIN -> {
                return new LoginPage("/login");
            }
            case MARKS -> {
                return new MarksPage("/grade/report/overview/index.php");
            }
            case MESSENGER -> {
                return new MessengerPage("/message/index.php");
            }
            case USER_INF_EDITOR -> {
                return new UserInfEditorPage("/user/edit.php");
            }
            case USER -> {
                return new UserPage("/user/profile.php?id=31455");
            }
            case SEARCH -> {
                return new SearchPage("/course/search.php?q=&areaids=core_course-course");
            }
            case PASSWORD -> {
                return new PasswordPage("");
            }
            case COURSE -> {
                return new CoursePage("enrol/index.php?id=181");
            }
            case TASK -> {
                return new TaskPage("/course/view.php?id=181");
            }

        }
        return null;
    }


}
