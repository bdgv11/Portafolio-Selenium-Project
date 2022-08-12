package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseClass {

    @Test(description = "Verify that Home Page is displayed correctly")
    public void verifyHomePageIsDisplayed() {

        // A variable that is being used to store the title of the page.
        String title = "Your Store";

        // The above code is verifying that the title of the page is correct, the header
        // page elements are
        // displayed correctly, and that the home page is loaded.
        Assert.assertTrue(homePage().getHomePageTitle(title), "Home Page title is not displayed. ");
        Assert.assertTrue(headerPage().verifyLoadsHeaderPage(), "Header page elements are not displayed correctly. ");
        Assert.assertTrue(homePage().verifyLoadsHomePage());
    }
}