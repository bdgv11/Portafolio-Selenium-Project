package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HeaderPageTests extends BaseClass{

    /**
     * Test to be executed:
     * 1. Verify that the header page is displayed
     * 2. Verify that currency dropdown is displayed and once changed to select currency, dropdown is updated (3 TCs)
     * 3. Verify that register and log in links works (2 Tcs)
     */

    @Test(description = "Test to check if currency dropdown is displayed and once changed to select currency, dropdown title is updated with the symbol of the selected currency")
    public void verifyUSDollarCurrencyIsDisplayed() {

        String currencyToBeDisplayed = "$ Currency ";

        //Assert.assertTrue(headerPage().verifyLoadsHeaderPage(),"Header page is not displayed ");
        headerPage().changeCurrencyToDollar();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Assert.assertEquals(headerPage().getActualCurrency(),currencyToBeDisplayed,"Currency is not updated to $ Currency");

    }

    @Test(description = "Test to check if currency dropdown is displayed and once changed to select currency, dropdown title is updated with the symbol of the selected currency")
    public void verifyEuroCurrencyIsDisplayed() {

        String currencyToBeDisplayed = "€ Currency ";

        //Assert.assertTrue(headerPage().verifyLoadsHeaderPage(),"Header page is not displayed ");
        headerPage().changeCurrencyToEuro();
        Assert.assertEquals(headerPage().getActualCurrency(),currencyToBeDisplayed,"Currency is not updated to € Currency");

    }

    @Test(description = "Test to check if currency dropdown is displayed and once changed to select currency, dropdown title is updated with the symbol of the selected currency")
    public void verifyPoundsCurrencyIsDisplayed() {
        
        String currencyToBeDisplayed = "£ Currency ";

        //Assert.assertTrue(headerPage().verifyLoadsHeaderPage(),"Header page is not displayed ");
        headerPage().changeCurrencyToPound();
        Assert.assertEquals(headerPage().getActualCurrency(),currencyToBeDisplayed,"Currency is not updated to £ Currency");

    }
}