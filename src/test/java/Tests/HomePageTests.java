package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseClass {

    @Test(description = "Verify that Home Page is displayed correctly")
    public void verifyHomePageIsDisplayed() {

        String title = "Your Store";
        Assert.assertTrue(homePage().getHomePageTitle(title), "Home Page title is not displayed. ");
        Assert.assertTrue(headerPage().verifyLoadsHeaderPage(),"Header page elements are not displayed correctly. ");
        Assert.assertTrue(homePage().verifyLoadsHomePage());
    }
}