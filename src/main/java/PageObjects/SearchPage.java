package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchPage extends UtilitiesPage {

    // Web Elements

    WebElement searchField = driver.findElement(By.id("input-search"));
    WebElement dropdownCategory = driver.findElement(By.cssSelector("select[name='category_id']"));
    WebElement subCategoryCheckbox = driver.findElement(By.name("sub_category"));
    WebElement searchProductDescCheckbox = driver.findElement(By.id("description"));
    WebElement searchButton = driver.findElement(By.cssSelector("input[id='button-search']"));
    WebElement sortByDropdown = driver.findElement(By.id("input-sort"));
    WebElement showQuantityByDropdown = driver.findElement(By.id("input-limit"));
    WebElement searchTitle = driver.findElement(By.cssSelector("#content > h1"));

    // List of web elements
    List<WebElement> titleOfEachProduct = driver.findElements(By.cssSelector(
            "[class='caption'] > h4 > a"));
    List<WebElement> priceOfEachProduct = driver.findElements(By.cssSelector(
            "[class='caption'] p.price"));
    List<WebElement> listOfProductsWishListButton = driver.findElements(By.cssSelector(
            "button[data-original-title='Add to Wish List']"));

    // Methods
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyLoads() {
        return waitForElementToBeVisible(searchField) && waitForElementToBeVisible(searchButton)
                && waitForElementToBeVisible(searchTitle);
    }

    public void typeOnSearchField(String text) {
        typeOnElement(searchField, text);
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    public void clickOnSearchSUbCategories() {
        clickOnElement(subCategoryCheckbox);
    }

    public void clickOnSearchProdDescription() {
        clickOnElement(searchProductDescCheckbox);
    }

    public void changeSortDropdown(String text) {
        Select drop = new Select(sortByDropdown);
        drop.selectByVisibleText(text);
        searchButton.sendKeys(Keys.RETURN);
    }

    public String getTitleSearchText() {
        return searchTitle.getText();
    }

    public String getLoginMsg() {
        WebElement alertLogInMsg = driver
                .findElement(By.cssSelector("div[class='alert alert-success alert-dismissible'"));
        return alertLogInMsg.getText();
    }

    // This method was created to validate if the DESC is present in every product
    // showed when you search it
    public boolean getProductDescription(String desc) {

        boolean flag = true;

        for (int i = 0; i < titleOfEachProduct.size(); i++) {

            String textValueOfEach = (titleOfEachProduct.get(i).getAttribute("text"));
            String mainString = textValueOfEach.toLowerCase();

            flag = mainString.contains(desc.toLowerCase());
        }
        return flag;
    }

    public boolean getProductPrice(String desc) {

        boolean flag = true;

        for (int i = 0; i < priceOfEachProduct.size(); i++) {

            String textValueOfEach = (priceOfEachProduct.get(i).getText());
            if (textValueOfEach != "") {
                flag = true;
            }
        }
        return flag;
    }

    public void clickWishListButton() {

        for (int i = 0; i < listOfProductsWishListButton.size(); i++) {
            listOfProductsWishListButton.get(i).click();
        }
    }

}