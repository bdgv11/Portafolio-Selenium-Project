package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;



public class RegisterPageTests extends BaseClass{

    @Test
    public void test_create_new_account(){

        headerPage().clickRegisterLink();

        String firstName = "Eddy";
        String lastName = "Fizzio";
        String email = registerPage().getRandomEmail(10);
        String telephone = registerPage().getRandomNumber(8);
        String password = registerPage().getRandomPassword(10);

        String titleAccountCreated = "Your Account Has Been Created!";

        registerPage().typeOnFirstName(firstName);
        registerPage().typeOnLastName(lastName);
        registerPage().typeOnEmail(email);
        registerPage().typeTelephone(telephone);
        registerPage().typePassword(password);
        registerPage().typePasswordConfirm(password);
        registerPage().clickNOTSubscribe();
        registerPage().clickOnPrivacyPolicy();
        registerPage().clickContinueButton();

        Assert.assertTrue(registerPage().getTextAccountCreated(titleAccountCreated),"Account title created doesn't match! ");

        System.out.println("Email: " + email + " password: " + password);
    }

    @Test
    public void test_error_messages_displayed() {

        Assert.assertTrue(headerPage().verifyLoadsHeaderPage(),"Header page is not displayed ");

        headerPage().clickRegisterLink();

        Assert.assertTrue(registerPage().verifyRegisterPageLoad(),"Register page is not displayed ");

        registerPage().clickContinueButton();

        Assert.assertTrue(registerPage().verifyErrorMsgs(),"Error messages doesn't appear!!! ");
    }
}