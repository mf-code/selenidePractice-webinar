package all.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public final class SearchPage extends Page<SearchPage> {

    public final SelenideElement searchResultCounter = $(".search-results__counter");
    public final SelenideElement searchField = $("input.search-results__input");

    public SearchPage(String searchPhrase) {
        super("/search?q=" + searchPhrase.replace(" ", "+"));
    }
}
