package data;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();
    static Config readConfig () {
        return ConfigFactory.load("application.conf");
    }
    String REAL_USER_LOGIN = config.getString("usersParams.validUser.login");
    String EMPTY_PASSWORD = config.getString("editData.negative.password.empty");
    String EMPTY_LOGIN = config.getString("email.empty");




}
