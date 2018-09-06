package all.tests.others;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class ClassesOverview {
    @Test
    public void selenideClasses() {
        List<Class> selenideClasses = asList(
                Selenide.class,
                Configuration.class,
                WebDriverRunner.class,
                ElementsCollection.class,
                Selectors.class,
                Condition.class,
                CollectionCondition.class,
                SelenideElement.class
        );
    }
}
