package app.pages.common;

import app.AppConfig;
import com.codeborne.selenide.Selenide;
import helpers.Trim;

public abstract class BasePage {

    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public BasePage() {
    }

    public  void open() {
        String url = Trim.rtrim(AppConfig.baseUrl, "/") + "/" + Trim.ltrim(pageUrl, "/");
        Selenide.open(url);
    }
}