package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This page will contain all the reusable methods for the PageObjects page
 */

public class UtilitiesPage {

    protected WebDriver driver;
    public Actions action;

    public UtilitiesPage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
    }

    public void hoverOnElement(WebElement element) {
        if(waitForElementToBeClickeable(element)){
            action.moveToElement(element).click().perform();
        }
    }

    public boolean waitForElementToBeClickeable(WebElement element) {

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
            return true;

        } catch (Exception e) {

            System.out.println("Element is not able to click now (WaitForElementToBeClickeable Method) " + element + e.toString());
            return false;
        }
    }

    public boolean waitForElementToBeVisible(WebElement element) {

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
            return true;

        } catch (Exception e) {

            System.out.println("Element is not visible yet (WaitForElementVisible Method) " + element + e.toString());
            return false;
        }
    }

    public boolean typeOnElement(WebElement element, String text) {

        try {

            if (waitForElementToBeVisible(element)) {
                element.clear();
                element.sendKeys(text);
            }

            return true;

        } catch (Exception e) {

            System.out.println("Element is not enabled to type in (typeOnElement Method)" + element + e.toString());
            return false;
        }
    }

    public boolean clickOnElement(WebElement element) {
        try {
            if (waitForElementToBeClickeable(element)) {
                element.click();
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println("Element is not enabled to click (clickOnElement Method) " + e.toString());
            return false;
        }
    }

    public String getTitleText() {
        return driver.getTitle();
    }

    public String getTextFromElement(WebElement element) {
        try {
            if (waitForElementToBeVisible(element)) {
                return element.getText();
            }
        } catch (Exception e) {
            System.out.println("Element is not enabled to get text " + e.toString());
            return null;
        }
        return null;
    }

    public static String getAlphaNumericEmail(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "0123456789" + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString() + "@test.com";
    }

    public static String getNumber(int n) {

        String AlphaNumericString = "1234567890";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static String getAlphaNumericPassword(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "0123456789" + "abcdefghijklmnopqrstuvxyz" + "#!$&*()-=";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }
}