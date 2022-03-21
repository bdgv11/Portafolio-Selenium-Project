package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage extends UtilitiesPage{

    // Web Elements
    WebElement currencyDropDown = driver.findElement(By.xpath("//div[@class='pull-left']/form/div/button"));
    WebElement euroCurrencyButton = driver.findElement(By.xpath("//div[@class='pull-left']/form/div/ul/li[1]/button"));
    WebElement poundCurrencyButton = driver.findElement(By.xpath("//div[@class='pull-left']/form/div/ul/li[2]/button"));
    WebElement dollarCurrencyButton = driver.findElement(By.xpath("//div[@class='pull-left']/form/div/ul/li[3]/button"));
    WebElement contactUsLink = driver.findElement(By.cssSelector("[class='fa fa-phone']"));
    WebElement myAccountDropDown = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[1]"));
    WebElement registerLink = driver.findElement(By.xpath("//ul/li/a[text()='Register']"));
    WebElement loginLink = driver.findElement(By.xpath("//li/a[text()='Login']"));
    WebElement wishListLink = driver.findElement(By.id("wishlist-total"));
    WebElement shoppingCartLink = driver.findElement(By.xpath("//a/span[text()='Shopping Cart']"));
    WebElement checkOutLink = driver.findElement(By.xpath("//a/span[text()='Checkout']"));
    WebElement yourStoreMainTitle = driver.findElement(By.xpath("//h1/a[text()='Your Store']"));
    WebElement searchField = driver.findElement(By.name("search"));
    WebElement searchButton = driver.findElement(By.cssSelector("[class='fa fa-search']"));
    WebElement cartButton = driver.findElement(By.cssSelector("[class='btn btn-inverse btn-block btn-lg dropdown-toggle']"));

    // Constructor
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    // Methods
    public boolean verifyLoadsHeaderPage() {
        return waitForElementToBeVisible(myAccountDropDown) && waitForElementToBeVisible(currencyDropDown) && waitForElementToBeVisible(wishListLink) &&
                waitForElementToBeVisible(contactUsLink) && waitForElementToBeVisible(yourStoreMainTitle);
    }

    public void backToHomepage(){
        clickOnElement(yourStoreMainTitle);
    }

    public void changeCurrencyToEuro() {
        hoverOnElement(currencyDropDown);
        clickOnElement(euroCurrencyButton);
    }

    public void changeCurrencyToPound() {
        hoverOnElement(currencyDropDown);
        clickOnElement(poundCurrencyButton);
    }

    public void changeCurrencyToDollar() {
        hoverOnElement(currencyDropDown);
        clickOnElement(dollarCurrencyButton);
    }

    public void clickRegisterLink() {
        hoverOnElement(myAccountDropDown);
        clickOnElement(registerLink);
    }

    public void clickLoginLink(){
        hoverOnElement(loginLink);
        clickOnElement(loginLink);
    }

    public void typeOnSearchButton(String text){
        typeOnElement(searchField, text);
    }

    public void clickOnSearchButton(){
        clickOnElement(searchButton);
    }

    public void clickOnCartButton(){
        clickOnElement(cartButton);
    }

    public String getActualCurrency(){
        WebElement el = driver.findElement(By.xpath("//div[@class='pull-left']/form/div/button"));
        return el.getText();
    }
}