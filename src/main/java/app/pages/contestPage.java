package app.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class contestPage extends basePage {

    public final SelenideElement loginField = $("#username");
    public void showTask(){

    }

  public  contestPage(String pageUrl) {
        super(pageUrl);
    }
}
