package helpers;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    Config config = readConfig();
    static Config readConfig () {
        return ConfigFactory.load("helpers/application1.conf");
    }

    String CHANGE_LANGUAGE_TO_ENG = "https://school.sgu.ru/user/preferences.php?userid=31455&lang=en";
    String CHANGE_LANGUAGE_TO_RUS = "https://school.sgu.ru/user/preferences.php?userid=31455&lang=ru";
    String BASE_URL = "https://school.sgu.ru";
//    String MAIN_URL = config.getString("href.page.MAIN_URL");
//    String LOGIN_URL = config.getString("href.page.LOGIN_URL");
//    String CHAT_URL = config.getString("href.page.CHAT_URL");
//    String USER_INF_EDITOR_URL = config.getString("href.page.USER_INF_EDITOR_URL");
//    String USER_URL = config.getString("href.page.USER_URL");
//    String SEARCH_URL = config.getString("href.page.SEARCH_URL");
//    String PASSWORD_URL = config.getString("href.page.PASSWORD_URL");
//    String COURSE_URL = config.getString("href.page.COURSE_URL");
//    String TASK_URL = config.getString("href.page.TASK_URL");
//    String SETTINGS_URL = config.getString("href.page.SETTINGS_URL");

    String QUICK_SEARCH = "https://school.sgu.ru/course/search.php?q=";

    String PASSWORD_HISTORY_FILE_PATH = "src/test/java/data/password/passwordHistory.txt";

}
