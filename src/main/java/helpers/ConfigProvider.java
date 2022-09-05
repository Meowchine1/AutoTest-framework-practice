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
    String BASE_URL = config.getString("href.BASE_URL");
    String MAIN_URL = config.getString("href.MAIN_URL");
    String LOGIN_URL = config.getString("href.LOGIN_URL");
    String CHAT_URL = config.getString("href.CHAT_URL");
    String USER_INF_EDITOR_URL = config.getString("href.USER_INF_EDITOR_URL");
    String USER_URL = config.getString("href.USER_URL");
    String SEARCH_URL = config.getString("href.SEARCH_URL");
    String PASSWORD_URL = config.getString("href.PASSWORD_URL");
    String COURSE_URL = config.getString("href.COURSE_URL");
    String TASK_URL = config.getString("href.TASK_URL");
    String SETTINGS_URL = config.getString("href.SETTINGS_URL");


      String QUICK_SEARCH = config.getString("href.QUICK_SEARCH");

}
