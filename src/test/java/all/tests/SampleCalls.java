package all.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.focused;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.id;
import static com.codeborne.selenide.Condition.readonly;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static java.util.Arrays.asList;

public class SampleCalls {
    @Test
    public void mainCode() {
        $(".loading_progress").shouldBe(visible);
        $(".save-dialog").should(disappear);
        $$(".menu-entry")
                .shouldHave(texts("Entry 1", "Entry 2"))
                .shouldHave(size(2));
        Selenide.screenshot("beforeCheckboxes");
        $$("input").filter(type("checkbox")).forEach(checkbox ->
                checkbox.shouldNotBe(hidden).click()
        );
        $$("").shouldHaveSize(3);
    }

    @Test
    public void uploadDownload() throws FileNotFoundException {
        $("#upload").uploadFile(new File("file.odt"));
        File odt = $(".btn#download").download();
    }

    @Test
    public void searchBy() {
        $(byText("Hello, World!")).shouldBe(visible);
        $(withText("orld")).shouldHave(text("Hello, World!"));
        $(byTitle("title")).shouldHave(cssClass("page"));
        $(byValue("value")).should(exist);
        $(by("placeholder", "Password")).shouldBe(empty);
    }

    @Test
    public void selenideElementMethods() {
        $("div#1").scrollTo();
        $("div#2").doubleClick();
        $("div#3").contextClick();
        $("div#4").hover();
        $("div#5").exists();
        $("div#6").is(enabled);
        $("div#7").dragAndDropTo("div#2");
        $("div#8").waitWhile(visible, 6000);
        $("select").isImage();
        $("select").getSelectedText();
    }

    @Test
    public void selenideClassMethods() {
        Selenide.zoom(2.5);
        Selenide.open("https://example.com");
        Selenide.forward();
        Selenide.back();
        Selenide.executeJavaScript("localStorage.clear();");
        Selenide.clearBrowserLocalStorage();
        Selenide.screenshot("fileName");
    }

    @Test
    public void webDriverRunner() {
        WebDriverRunner.url();
        WebDriverRunner.getWebDriver();
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.isChrome();
        WebDriverRunner.isHeadless();
    }

    @Test
    public void conditions() {
        List<Condition> conditions = asList(
                type("type"),
                cssClass("class"),
                exactText("text"),
                id("id"),
                checked,
                empty,
                focused,
                hidden,
                readonly,
                selected,
                enabled
        );
    }
}
