package all.tests;

import all.models.MainContainer;
import all.tests.others.BaseTest;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;

public class WrappedTest extends BaseTest {

    MainContainer mainContainer = new MainContainer();

    @Test(description = "Example with dynamic proxy")
    public void test() {
        SelenideElement passwordField = mainContainer.first();
        passwordField.click();  //overridden call
        passwordField
                .shouldBe(visible)
                .shouldBe(checked);
    }
}
