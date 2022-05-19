package app.pages;

import app.appConfig;
import com.codeborne.selenide.Selenide;
import helpers.Trim;

public abstract class basePage {

    protected String pageUrl;

    public basePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }
    public basePage() {}
    public void open() {
        String url = Trim.rtrim(appConfig.baseUrl, "/") + "/" + Trim.ltrim(pageUrl, "/");
        Selenide.open(url);
    }
}
