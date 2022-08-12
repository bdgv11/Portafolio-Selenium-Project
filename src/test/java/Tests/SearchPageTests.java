package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTests extends BaseClass {

    @Test(description = "Verify that search is completed successfully and products showed are related with the word used")
    public void test_search_product() {

        // Search for a product
        String prod = "IPHONE";
        String titleSearch = "Search - " + prod;

        headerPage().typeOnSearch(prod);
        headerPage().clickOnSearchButton();

        Assert.assertTrue(searchPage().verifyLoads());
        Assert.assertEquals(searchPage().getTitleSearchText(), titleSearch);
        Assert.assertTrue(searchPage().getProductDescription(prod));
    }

    @Test(description = "Verify that search page title is showed")
    public void test_search_title_isShowed() {

        // Search for a product
        String prod = "IPHONE";
        String titleSearch = "Search - " + prod;

        headerPage().typeOnSearch(prod);
        headerPage().clickOnSearchButton();

        Assert.assertTrue(searchPage().verifyLoads());
        Assert.assertEquals(searchPage().getTitleSearchText(), titleSearch);
    }

    @Test(description = "Verify that each price is showed for all the products")
    public void test_price_isShowed() {

        // Search one product
        String prod = "Macbook";
        headerPage().typeOnSearch(prod);
        headerPage().clickOnSearchButton();

        // Checking that the page loads and that the price is showed.
        Assert.assertTrue(searchPage().verifyLoads());
        Assert.assertTrue(searchPage().getProductPrice(prod), "Price not showed");

    }

    @Test(description = "Verify that if you try to click 'Add to Wish List' without log in an error msg is showed")
    public void test_wishList_error_msg() {

        // Search one product
        String prod = "Air";

        // Searching for the product.
        headerPage().typeOnSearch(prod);
        headerPage().clickOnSearchButton();

        // Clicking on the first product's wish list button.
        searchPage().clickWishListButton();

        // Getting the first product name
        String firstProductName = searchPage().getFirstProductName(prod);

        // Creating the expected error message.
        String expectedErrorMsg = "you must login or create an account to save " + firstProductName.toLowerCase()
                + " to your wish list!";

        // Checking that the error message contains the expected error message.
        Assert.assertTrue((searchPage().getLoginMsg().toLowerCase().contains(expectedErrorMsg)),
                "There are some diff.");
    }
}