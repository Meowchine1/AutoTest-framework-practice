package data;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();
    static Config readConfig () {
        return ConfigFactory.load("application.conf");
    }
    String REAL_USER_LOGIN = config.getString("usersParams.validUser.login");
    String REAL_USER_PASSWORD = config.getString("usersParams.validUser.passwordHistory");
    String EMPTY_PASSWORD = config.getString("passwordHistory.empty");
    String EMPTY_LOGIN = config.getString("email.empty");
    String symbol_grid =  config.getString("search.symbol_grid");
    String symbol_dollar =  config.getString("search.symbol_dollar");
    String symbol_dog =  config.getString("search.symbol_dog");
    String symbols =  config.getString("search.symbols");
    String space =  config.getString("search.space");
    String empty =  config.getString("search.empty");
    String onEnglish =  config.getString("search.onEnglish");
    String num =  config.getString("search.num");



}
