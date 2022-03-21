package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * This class will contain the creation ob driver (chrome, firefox, etc.) and manage the WebDriver version.
 */

public class BaseClass extends PageObjectHandler {

    private final String URL = "http://opencart.abstracta.us";

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void before(@Optional("chrome") String browser) {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }else{
            driver = new FirefoxDriver();
        }

        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void after() {
        driver.close();
    }
}