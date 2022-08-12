package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends UtilitiesPage {

    // Web Elements
    WebElement slideShow = driver.findElement(By.id("slideshow0"));

    List<WebElement> listOfProductNames = driver
            .findElements(By.cssSelector("div.caption > h4 > a"));

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Actions - Methods
    public boolean verifyLoadsHomePage() {
        return waitForElementToBeVisible(slideShow);
    }

    public boolean getHomePageTitle(String text) {
        return (getTitleText().equals(text));
    }

    public int getProductNameCount() {

        int count = 0;

        for (int i = 0; i < listOfProductNames.size(); i++) {

            if (listOfProductNames.get(i).getAttribute("text") != "") {
                count++;
            }
        }

        return count;
    }
}