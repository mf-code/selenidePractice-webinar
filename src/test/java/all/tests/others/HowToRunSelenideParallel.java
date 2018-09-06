package all.tests.others;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class HowToRunSelenideParallel {
    String readArcticle = "https://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/";

    static void setWebDriverForSelenide() throws MalformedURLException {
        RemoteWebDriver driver = new RemoteWebDriver(new URL("someUrl"), new DesiredCapabilities());
        WebDriverRunner.setWebDriver(driver);
        //or use driver configuration through Configuration.class
        //don't forget to close() driver by using @AfterMethod
    }
}
