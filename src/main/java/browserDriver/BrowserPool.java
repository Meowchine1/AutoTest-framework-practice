package browserDriver;

import com.codeborne.selenide.Browsers;

import java.util.HashMap;

public class BrowserPool {
    public static final HashMap<BrowserType, Browser> browsers = new HashMap<>();

    public static Browser getInstance(BrowserType type) {
        Browser browserImpl = browsers.get(type);

        if (browserImpl == null) {
            if (type.equals(BrowserType.CHROME)) {
                browserImpl = new Chrome(Browsers.CHROME);
            } else if (type.equals(BrowserType.OPERA)) {
                browserImpl = new Opera(Browsers.OPERA);
            } else if (type.equals(BrowserType.IE)) {
                browserImpl = new IE(Browsers.IE);
            } else if (type.equals(BrowserType.FIREFOX)) {
                browserImpl = new Firefox(Browsers.FIREFOX);
            } else if (type.equals(BrowserType.EDGE)) {
                browserImpl = new EDGE(Browsers.EDGE);
            } else if (type.equals(BrowserType.SAFARI)) {
                browserImpl = new Safari(Browsers.SAFARI);
            }
            browsers.put(type, browserImpl);
        }
        return browserImpl;
    }

}
