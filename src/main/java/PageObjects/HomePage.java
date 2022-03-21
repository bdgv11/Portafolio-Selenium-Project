package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends UtilitiesPage {

    // Web Elements
    WebElement slideShow = driver.findElement(By.id("slideshow0"));

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Actions - Methods
    public boolean verifyLoadsHomePage() {
        return waitForElementToBeVisible(slideShow);
    }

    public boolean getHomePageTitle(String text){
        return (getTitleText().equals(text));
    }
}