package app;

import app.pages.*;
import app.pages.settings.*;

public class PageBuilder {

    public static LoginPage buildLoginPage() {
        return new LoginPage("/login");
    }

    public static MainPage buildMainPage() {
        return new MainPage("");
    }

    public static MarksPage buildMarksPage() {
        return new MarksPage("/grade/report/overview/index.php");
    }

    public static MessagePage buildMessagePage() {
        return new MessagePage("/message/index.php");
    }

    public static EditUserInfPage buildSettingsPage() {
        return new EditUserInfPage("/user/edit.php");
    }

    public static UserPage buildUserPage() {
        return new UserPage("/user/profile.php?id=31455");
    }

    public static CalendarPage buildCalendarPage() {
        return new CalendarPage("/calendar/view.php?view=month");
    }

    public static SearchPage buildSearchPage() {
        return new SearchPage("/course/search.php?q=&areaids=core_course-course");
    }

    public static PasswordPage buildPasswordPage() {
        return new PasswordPage("");
    }

    public static CoursePage buildCoursePage() {
        return new CoursePage("enrol/index.php?id=181");
    }

    public static TaskPage buildTaskPage() {
        return new TaskPage("/course/view.php?id=181");
    }


}
