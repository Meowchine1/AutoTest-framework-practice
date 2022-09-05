package pages.base;

import com.codeborne.selenide.Selenide;
import helpers.ConfigProvider;
import helpers.Trim;

public abstract class BasePage implements Page {

    protected  String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public BasePage() {
    }

    public void open() {
        String url = Trim.rtrim(ConfigProvider.BASE_URL, "/") + "/" + Trim.ltrim(pageUrl, "/");
        Selenide.open(url);
    }
}