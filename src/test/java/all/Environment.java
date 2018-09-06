package all;

import all.utils.Log;
import ch.qos.logback.classic.Level;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import java.util.Locale;

public class Environment {
    public static void setUp() {
        Log.setLevel(Level.INFO);
        setupAllureReports();
        Configuration.baseUrl = "https://www.epam.com/";
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        Configuration.remote = null; //default value
        //you can create any driver and pass it to selenide:
        //WebDriverRunner.setWebDriver(driver);
        Configuration.reopenBrowserOnFail = true;
    }

    private static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tT %4$s %5$s%6$s%n"); // add %2$s for source
        Locale.setDefault(Locale.ENGLISH);
    }
}
