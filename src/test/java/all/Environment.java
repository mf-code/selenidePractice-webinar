package all;

import all.utils.Log;
import ch.qos.logback.classic.Level;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Environment {
    public static void setUp() {
        Log.setLevel(Level.INFO);
        Configuration.baseUrl = "https://www.epam.com/";
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        Configuration.remote = null; //default value
        //you can create any driver and pass it to selenide:
        //WebDriverRunner.setWebDriver(driver);
        Configuration.reopenBrowserOnFail = true;
    }
}
