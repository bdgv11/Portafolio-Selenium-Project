package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

/**
 * This class will contain the creation ob driver (chrome, firefox, etc.) and
 * manage the WebDriver version.
 */

public class BaseClass extends PageObjectHandler {

    private final String URL = "http://opencart.abstracta.us";

    @Parameters({ "browser" })
    @BeforeMethod()
    public void before(@Optional("chrome") String browser) {

        try {

            if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }

            driver.get(URL);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        try {
            driver.manage().deleteAllCookies();
            driver.close();
        } catch (WebDriverException ex) {
            System.out.println("Driver didn't close");
        }
    }
}