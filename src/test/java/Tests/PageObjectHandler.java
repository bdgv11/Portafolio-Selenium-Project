package Tests;

import PageObjects.*;
import org.openqa.selenium.WebDriver;

/**
 * This class will be used to manage all the instances of page objects to avoid create them in every test page
 */

public class PageObjectHandler {

    public WebDriver driver;

    private HomePage homePage;
    private HeaderPage headerPage;
    private RegisterPage registerPage;
    private SearchPage searchPage;

    public PageObjectHandler() {

    }


    public HomePage homePage() {
        if(this.homePage == null) {
            homePage = new HomePage(driver);
        }
        return this.homePage;
    }

    public HeaderPage headerPage(){
        if(this.headerPage == null){
            headerPage = new HeaderPage(driver);
        }
        return this.headerPage;
    }

    public RegisterPage registerPage(){
        if(this.registerPage == null){
            registerPage = new RegisterPage(driver);
        }
        return this.registerPage;
    }

    public SearchPage searchPage(){
        if(this.searchPage == null){
            searchPage = new SearchPage(driver);
        }
        return this.searchPage;
    }
}