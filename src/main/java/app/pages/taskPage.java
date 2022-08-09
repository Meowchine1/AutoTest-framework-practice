package app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class taskPage extends basePage {
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

    public taskPage(String pageUrl) {
        super(pageUrl);
    }

    public taskPage() {
    }

    public taskPage sendAnswer(){
        sendTask.click();
        return new taskPage();
    }

    public taskPage setLang(String catName){
        chooseLang.click();
        for(SelenideElement element : langCategory){
            if (element.getText().equals(catName)){
                element.click();
                break;
            }
        }
        return new taskPage();
    }
    public taskPage sendCode(String code){
        codeArea.sendKeys(code);
        task = taskName.getText();
        sendTask.click();
        if(code.trim().length() == 0){
            errormess.shouldBe(Condition.visible);
        }
        return new taskPage();
    }

    public taskPage checkMyAnswers(){
        myAnswers.click();
        return new taskPage();
    }

    public boolean isEquals(){
        return task.equals(lastTask.getText());
    }
}
