package all.tests;

import all.models.MainContainer;
import all.tests.others.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.not;

public class ExtraCodeCases extends BaseTest {
    //how we can create specific conditions: case 2
    private final static Condition active = cssClass("active");
    private MainContainer mainContainer = new MainContainer();
    private Condition relAuthor = attribute("rel", "author");

    ///========================================================================
    @Test
    public void case1() {
        bad:
        {
            shouldBeChecked(true);
            shouldBeChecked(false);
        }
        good:
        {
            mainContainer.checkbox.shouldBe(checked);
            mainContainer.checkbox.shouldBe(not(checked));  //1
            mainContainer.checkbox.shouldNotBe(checked);    //2
        }
    }

    private void shouldBeChecked(Boolean check) {
        if (check) {
            mainContainer.checkbox.shouldBe(checked);
        } else {
            mainContainer.checkbox.shouldNotBe(checked);
        }
    }

    ///========================================================================
    @Test
    public void case2() {
        bad:
        {
            checkMainContainerCheckBox(true);
            checkMainContainerCheckBox(false);
        }
        good:
        {
            check(mainContainer.checkbox);
            uncheck(mainContainer.checkbox);
        }
    }

    private void checkMainContainerCheckBox(Boolean setCheck) {
        if (setCheck) {
            if (!mainContainer.checkbox.is(checked)) {
                mainContainer.checkbox.click();
                mainContainer.checkbox.shouldBe(checked);
            }
        } else {
            if (mainContainer.checkbox.is(checked)) {
                mainContainer.checkbox.click();
                mainContainer.checkbox.shouldNotBe(checked);
            }
        }
    }

    private void check(SelenideElement element) {
        element.shouldNotBe(checked).click();
        element.shouldBe(checked);
    }

    private void uncheck(SelenideElement element) {
        element.shouldBe(checked).click();
        element.shouldNotBe(checked);
    }

    ///========================================================================
    @Test
    public void case3() {
        bad:
        {
            mainContainer.title
                    .shouldHave(attribute("rel", "author"));
            mainContainer.text
                    .shouldHave(attribute("rel", "author"));
            mainContainer.previewImage
                    .shouldHave(attribute("rel", "author"));
        }
        good:
        {
            mainContainer.title.shouldHave(relAuthor);
            mainContainer.text.shouldHave(relAuthor);
            mainContainer.previewImage.shouldHave(relAuthor);
        }
    }

    @Test
    public void case3Alternate() {
        bad:
        {
            mainContainer.title
                    .shouldHave(attribute("rel", "author"));
            mainContainer.text
                    .shouldHave(attribute("rel", "canonical"));
            mainContainer.previewImage
                    .shouldHave(attribute("rel", "preload"));
        }
        good:
        {
            mainContainer.title.shouldHave(rel("author"));
            mainContainer.text.shouldHave(rel("canonical"));
            mainContainer.previewImage.shouldHave(rel("preload"));
        }
    }

    private Condition rel(String relValue) {
        return attribute("rel", relValue);
    }

    @Test(description = "Bad case because we use the same code twice (in the example: mainContainer.submitButton), we can make mistake if it will be a little bit tricky")
    public void testIf() {
        if (mainContainer.is(active)) {
            mainContainer.submitButton.shouldBe(enabled);
        } else {
            mainContainer.submitButton.shouldBe(disabled);
        }
    }

    @Test(description = "Good practice: if statement contains only code that is really depending on")
    public void testCondition() {
        Condition expectedState = mainContainer.is(active) ? enabled : disabled;
        mainContainer
                .submitButton
                .shouldHave(expectedState);
    }
}
