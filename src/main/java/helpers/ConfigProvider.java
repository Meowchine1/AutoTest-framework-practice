package helpers;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    Config config = readConfig();
    static Config readConfig () {
        return ConfigFactory.load("application.conf");
    }

    String CHANGE_LANGUAGE_TO_ENG = config.getString("href.changeLanguage.english");
    String CHANGE_LANGUAGE_TO_RUS = config.getString("href.changeLanguage.russian");
    String BASE_URL = config.getString("href.page.BASE_URL");
    String MAIN_URL = config.getString("href.page.MAIN_URL");
    String LOGIN_URL = config.getString("href.page.LOGIN_URL");
    String CHAT_URL = config.getString("href.page.CHAT_URL");
    String USER_INF_EDITOR_URL = config.getString("href.page.USER_INF_EDITOR_URL");
    String USER_URL = config.getString("href.page.USER_URL");
    String SEARCH_URL = config.getString("href.page.SEARCH_URL");
    String PASSWORD_URL = config.getString("href.page.PASSWORD_URL");
    String COURSE_URL = config.getString("href.page.COURSE_URL");
    String TASK_URL = config.getString("href.page.TASK_URL");
    String SETTINGS_URL = config.getString("href.page.SETTINGS_URL");

    String QUICK_SEARCH = config.getString("href.page.QUICK_SEARCH");

    String PASSWORD_HISTORY_FILE_PATH = config.getString("filePath.passwordHistory");

}
