package data;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();
    static Config readConfig () {
        return ConfigFactory.load("application.conf");
    }
    public   String REAL_USER_LOGIN = config.getString("usersParams.realUser.login");
    public  String REAL_USER_PASSWORD = config.getString("usersParams.realUser.password");
    public String EMPTY_PASSWORD = config.getString("password.empty");
    public String EMPTY_LOGIN = config.getString("email.empty");

    public String symbol_grid =  config.getString("search.symbol_grid");
    public  String symbol_dollar =  config.getString("search.symbol_dollar");
    public String symbol_dog =  config.getString("search.symbol_dog");
    public String symbols =  config.getString("search.symbols");
    public String space =  config.getString("search.space");
    public String empty =  config.getString("search.empty");
    public String onEnglish =  config.getString("search.onEnglish");
    public String num =  config.getString("search.num");

}
