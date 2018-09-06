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
                {"digital experiences", 277}, //277 to demonstrate failed test
        };
    }

    @Test(dataProvider = "searchPhrases", invocationCount = 1)
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
    }

    @AfterMethod(alwaysRun = true)
    void close() {
        Selenide.close();
    }
}
