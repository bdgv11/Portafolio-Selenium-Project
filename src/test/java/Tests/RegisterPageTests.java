package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTests extends BaseClass {

    @Test(description = "Verify that create a new user is completed successfully")
    public void test_create_new_account() {

        headerPage().clickRegisterLink();

        // Creating a new account.
        String firstName = "Eddy";
        String lastName = "Fizzio";
        String email = registerPage().getRandomEmail(10);
        String telephone = registerPage().getRandomNumber(8);
        String password = registerPage().getRandomPassword(10);

        String titleAccountCreated = "Your Account Has Been Created!";

        // Filling out the form.
        registerPage().typeOnFirstName(firstName);
        registerPage().typeOnLastName(lastName);
        registerPage().typeOnEmail(email);
        registerPage().typeTelephone(telephone);
        registerPage().typePassword(password);
        registerPage().typePasswordConfirm(password);
        registerPage().clickNOTSubscribe();
        registerPage().clickOnPrivacyPolicy();
        registerPage().clickContinueButton();

        // Verifying that the text "Your Account Has Been Created!" is displayed on the
        // page.
        Assert.assertTrue(registerPage().getTextAccountCreated(titleAccountCreated),
                "Account title created doesn't match! ");

        System.out.println("Email: " + email + " password: " + password);
    }

    @Test(description = "Verify that error message is displayed when user click on continue button without filling all fields")
    public void test_error_messages_displayed() {

        // The above code is verifying the error messages when the user clicks on the
        // continue button without
        // entering any details.
        Assert.assertTrue(headerPage().verifyLoadsHeaderPage(), "Header page is not displayed ");

        headerPage().clickRegisterLink();

        Assert.assertTrue(registerPage().verifyRegisterPageLoad(), "Register page is not displayed ");

        registerPage().clickContinueButton();

        Assert.assertTrue(registerPage().verifyErrorMsgs(), "Error messages doesn't appear!!! ");
    }
}