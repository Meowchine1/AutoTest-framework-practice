package pages;

import pages.base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.base.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TaskPage extends BasePage implements Page {

    private static final SelenideElement taskName = $("#problemselect");
    private static final ElementsCollection taskDescriptions = $$(By.xpath(".//td[@align = 'center' and @valign = 'middle']/child::a"));
    private static final ElementsCollection sendTaskButtons = $$(By.xpath(".//input[@type='submit']"));
    private static final SelenideElement sendTask = $(By.xpath("//input[@type = 'submit']"));
    private static final SelenideElement lastTask = $(By.xpath(".//tr[@class = 'lastrow']/descendant::a"));
    private static final SelenideElement chooseLang = $(By.xpath(".//select[@name = 'lang']"));
    private static final SelenideElement errormess = $(By.xpath(".//*[@class = 'errormessage']"));
    private static final SelenideElement codeArea = $(By.xpath(".//textarea[@name='code']"));
    private static final SelenideElement myAnswers = $(By.xpath("//nobr[3]/a"));
    private static final ElementsCollection langCategory = $$(By.xpath(".//select[@name = 'lang']/child::option"));

    private boolean locked = false ;
    private String task;

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
