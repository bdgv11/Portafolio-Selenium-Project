package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTests extends BaseClass{

    @Test(description = "Verify that search is completed successfully")
    public void test_search_product(){

        // Search for a product
        String prod = "Macbook";
        String titleSearch = "Search - " + prod;

        headerPage().typeOnSearch(prod);
        headerPage().clickOnSearchButton();

        Assert.assertTrue(searchPage().verifyLoads());
        Assert.assertEquals(searchPage().getTitleSearchText(),titleSearch); 
    }
    
}
