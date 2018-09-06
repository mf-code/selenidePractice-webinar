package all.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static org.testng.Assert.assertEquals;

public class Page<T extends Page> {
    private final String url;
    private final String redirectedUrl;

    protected Page(String url) {
        this(url, url);
    }

    protected Page(String url, String redirectedUrl) {
        this.url = url;
        this.redirectedUrl = redirectedUrl;
    }

    @Step("Open page")
    public T open() {
        Selenide.open(url);
        return shouldBeOpen();
    }

    public T shouldBeOpen() {
        assertEquals(redirectedUrl, WebDriverRunner.url());
        return This();
    }

    @SuppressWarnings("unchecked")
    public T This() {
        return (T) this;
    }
}
