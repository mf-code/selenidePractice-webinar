package all.models;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainContainer {
    private final SelenideElement root = $(".main-container");
    public final SelenideElement submitButton = root.$("button.submit");
    public final SelenideElement checkbox = root.$("#checkbox");
    public final SelenideElement title = root.$("title");
    public final SelenideElement previewImage = root.$("img");
    public final SelenideElement text = root.$("text");

    public SelenideElement first() {
        return SpecificItem.children(root).get(0);
    }

    public boolean is(Condition condition) {
        return root.is(condition);
    }
}
