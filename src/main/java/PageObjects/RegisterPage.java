package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends UtilitiesPage {

    // Web Elements

    WebElement accountTitle = driver.findElement(By.xpath("//div/h1[text()='Account']"));
    WebElement firstNameField = driver.findElement(By.id("input-firstname"));
    WebElement lastNameField = driver.findElement(By.id("input-lastname"));
    WebElement emailField = driver.findElement(By.id("input-email"));
    WebElement telephoneField = driver.findElement(By.id("input-telephone"));
    WebElement passwordField = driver.findElement(By.id("input-password"));
    WebElement passwordConfirmField = driver.findElement(By.id("input-confirm"));
    WebElement subscribeRadioButtonYES = driver.findElement(By.cssSelector("input[name='newsletter'][value='1']"));
    WebElement subscribeRadioButtonNO = driver.findElement(By.cssSelector("input[name='newsletter'][value='0']"));
    WebElement privacyPolicyAgreeCheckbox = driver.findElement(By.cssSelector("input[name='agree']"));
    WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit'][value='Continue']"));

    WebElement warning;
    WebElement firstNameErrorMsg;


    // Methods
    public RegisterPage(WebDriver driver){
        super(driver);
    }

    public boolean verifyRegisterPageLoad(){

        return waitForElementToBeVisible(accountTitle) && waitForElementToBeVisible(firstNameField) && waitForElementToBeVisible(lastNameField) &&
                waitForElementToBeVisible(emailField) && waitForElementToBeVisible(telephoneField) &&  waitForElementToBeVisible(passwordField) &&
                waitForElementToBeVisible(passwordConfirmField) && waitForElementToBeClickeable(subscribeRadioButtonYES) && waitForElementToBeClickeable(subscribeRadioButtonNO) &&
                waitForElementToBeClickeable(privacyPolicyAgreeCheckbox) && waitForElementToBeClickeable(continueButton);
    }

    public String getRandomEmail(int length){
        return getAlphaNumericEmail(length);
    }

    public String getRandomNumber(int length){
        return getNumber(length);
    }

    public String getRandomPassword(int length){
        return getAlphaNumericPassword(length);
    }

    public void typeOnFirstName(String text){
         typeOnElement(firstNameField, text);
    }

    public void typeOnLastName(String text){
         typeOnElement(lastNameField, text);
    }

    public void typeOnEmail(String text){
         typeOnElement(emailField, text);
    }

    public void typeTelephone(String text){
         typeOnElement(telephoneField, text);
    }

    public void typePassword(String text){
         typeOnElement(passwordField, text);
    }

    public void typePasswordConfirm(String text){
         typeOnElement(passwordConfirmField, text);
    }

    public void clickNOTSubscribe(){
         clickOnElement(subscribeRadioButtonNO);
    }

    public void clickSubscribe(){
        clickOnElement(subscribeRadioButtonYES);
    }

    public void clickOnPrivacyPolicy(){
         clickOnElement(privacyPolicyAgreeCheckbox);
    }

    public void clickContinueButton(){
         clickOnElement(continueButton);
    }

    public boolean getTextAccountCreated(String title){
        return getTitleText().equals(title);
    }

   public boolean verifyErrorMsgs(){
        warning = driver.findElement(By.cssSelector("div[class='alert alert-danger alert-dismissible']"));
        firstNameErrorMsg = driver.findElement(By.xpath("//*[@id='account']/div[2]/div/div"));
        return waitForElementToBeVisible(warning) && waitForElementToBeVisible(firstNameErrorMsg);
   }
}