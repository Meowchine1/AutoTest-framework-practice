package pages.common;

import app.AppConfig;
import com.codeborne.selenide.Selenide;
import pages.interfaces.Page;
import helpers.Trim;

public abstract class BasePage implements Page {

    protected  String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public BasePage() {
    }

    public void open() {
        String url = Trim.rtrim(AppConfig.BASE_URL, "/") + "/" + Trim.ltrim(pageUrl, "/");
        Selenide.open(url);
    }
}