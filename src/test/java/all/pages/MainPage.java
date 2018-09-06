package all.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public final class MainPage extends Page<MainPage> {
    private final SelenideElement searchButton = $("button.header-search__button");
    private final SelenideElement searchField = $("input#new_form_search");
    private final SelenideElement submitSearchButton = $("button.header-search__submit");
    private final SelenideElement submitSearchButton2 = $(byText("Find"));

    public MainPage() {
        super(Configuration.baseUrl);
    }

    @Step("Search phrase from main page")
    public SearchPage search(String searchPhrase) {
        searchButton.click();
        searchField.setValue(searchPhrase);
        submitSearchButton.click();
        return new SearchPage(searchPhrase);
    }

    @AfterMethod(alwaysRun = true)
    void close(){
        Selenide.close();
    }
}
