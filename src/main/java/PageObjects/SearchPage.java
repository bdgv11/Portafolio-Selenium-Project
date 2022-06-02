package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
        
    // Methods
    public SearchPage(WebDriver driver){
        super(driver);
    }    

    public boolean verifyLoads(){
        return waitForElementToBeVisible(searchField) && waitForElementToBeVisible(searchButton) && waitForElementToBeVisible(searchTitle)
                && waitForElementToBeVisible(sortByDropdown) && waitForElementToBeVisible(showQuantityByDropdown);
    }

    public void typeOnSearchField(String text){
        typeOnElement(searchField, text);
    }

    public void clickOnSearchButton(){
        clickOnElement(searchButton);
    }

    public void clickOnSearchSUbCategories(){
        clickOnElement(subCategoryCheckbox);
    }

    public void clickOnSearchProdDescription(){
        clickOnElement(searchProductDescCheckbox);
    }

    public void changeSortDropdown(String text){
        Select drop = new Select(sortByDropdown);
        drop.selectByVisibleText(text);
        searchButton.sendKeys(Keys.RETURN);
    }

    public String getTitleSearchText(){
        return searchTitle.getText();
    }
}