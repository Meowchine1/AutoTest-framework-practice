package app.pages;

import app.pages.common.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TaskPage extends BasePage {
    public boolean locked = false;
    public String task = "";
    public SelenideElement taskName = $("#problemselect");
    public ElementsCollection taskDescriptions = $$(By.xpath(".//td[@align = 'center' and @valign = 'middle']/child::a"));
    public ElementsCollection sendTaskButtons = $$(By.xpath(".//input[@type='submit']"));
    public final SelenideElement sendTask = $(By.xpath("//input[@type = 'submit']"));
    public final SelenideElement lastTask = $(By.xpath(".//tr[@class = 'lastrow']/descendant::a"));
    public final SelenideElement chooseLang = $(By.xpath(".//select[@name = 'lang']"));
    public final SelenideElement errormess = $(By.xpath(".//*[@class = 'errormessage']"));
    public final SelenideElement codeArea = $(By.xpath(".//textarea[@name='code']"));
    public final SelenideElement myAnswers = $(By.xpath("//nobr[3]/a"));
    public final ElementsCollection langCategory = $$(By.xpath(".//select[@name = 'lang']/child::option"));

    public TaskPage(String pageUrl) {
        super(pageUrl);
    }

    public TaskPage() {
    }

    public TaskPage sendAnswer() {
        sendTask.click();
        return new TaskPage();
    }

    public TaskPage setLang(String catName) {
        chooseLang.click();
        for (SelenideElement element : langCategory) {
            if (element.getText().equals(catName)) {
                element.click();
                break;
            }
        }
        return new TaskPage();
    }

    public TaskPage sendCode(String code) {
        codeArea.sendKeys(code);
        task = taskName.getText();
        sendTask.click();
        if (code.trim().length() == 0) {
            errormess.shouldBe(Condition.visible);
        }
        return new TaskPage();
    }

    public TaskPage checkMyAnswers() {
        myAnswers.click();
        return new TaskPage();
    }

    public boolean isEquals() {
        return task.equals(lastTask.getText());
    }
}
