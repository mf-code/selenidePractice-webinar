package all.tests;

import all.pages.MainPage;
import all.pages.SearchPage;
import all.tests.others.BaseTest;
import all.utils.Utils;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class FirstTest extends BaseTest {

    private MainPage mainPage = new MainPage();

    //how we can create specific conditions: case 1
    //TODO add case 3
    private static Condition counterText(String searchPhrase, Integer resultsCount) {
        String phrase = Utils.format("{} results for \"{}\"", resultsCount, searchPhrase);
        return exactText(phrase);
    }

    @DataProvider(name = "searchPhrases")
    public Object[][] searchPhrases() {
        return new Object[][]{
                {"benefits", 195},
                {"digital experiences", 277},
        };
    }

    @Test(dataProvider = "searchPhrases", invocationCount = 5)
    public void test(String searchPhrase, Integer resultsCount) {
        SearchPage searchPage = mainPage
                .open()
                .search(searchPhrase);
        searchPage
                .searchField
                .shouldBe(visible)
                .shouldHave(value(searchPhrase));
        Selenide.screenshot(searchPhrase);
        searchPage
                .searchResultCounter
                .shouldHave(counterText(searchPhrase, resultsCount));
        searchPage
                .searchResultCounter
                .shouldHave(exactText("Some text")).getText();
    }

    @AfterMethod(alwaysRun = true)
    void close() {
        Selenide.close();
    }
}