package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

/**
 * This class will contain the creation ob driver (chrome, firefox, etc.) and manage the WebDriver version.
 */

public class BaseClass extends PageObjectHandler {

    private final String URL = "http://opencart.abstracta.us";

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void before(@Optional("chrome") String browser) {

        try {

            Thread.sleep(5000);
            WebDriverManager.chromedriver().setup();
            WebDriverManager.firefoxdriver().setup();
    
            if(browser.equals("chrome")){
                driver = new ChromeDriver();
            }else{
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
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}