package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerText;
    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "Password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordField;
    @CacheLookup
    @FindBy(id = "register-button")
    WebElement registerButton;
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement verifyRegistration;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueTab;


    public String verifyRegisterText() {
        CustomListeners.test.log(Status.PASS, "Verify register text");
        Reporter.log("Verify register text" + registerText.toString());
        return getTextFromElement(registerText);
    }

    public void enterFirstName(String firstName) {
        sendTextToElement(firstNameField, firstName);
        CustomListeners.test.log(Status.PASS, "Enter first name");
        Reporter.log("Enter first name" + firstNameField.toString());
    }

    public void enterLastName(String lastName) {
        sendTextToElement(lastNameField, lastName);
        CustomListeners.test.log(Status.PASS, "Enter last name");
        Reporter.log("Enter last name" + lastNameField.toString());
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS, "Enter email");
        Reporter.log("Enter email" + emailField.toString());
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter password");
        Reporter.log("Enter password" + passwordField.toString());
    }

    public void enterConfirmPassword(String confirmPassword) {
        sendTextToElement(confirmPasswordField, confirmPassword);
        CustomListeners.test.log(Status.PASS, "Enter confirm password");
        Reporter.log("Enter confirm password" + confirmPasswordField.toString());
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
        CustomListeners.test.log(Status.PASS, "Click on register button");
        Reporter.log("Click on register button" + registerButton.toString());
    }

    public String verifyRegistrationCompleteMessage() {
        CustomListeners.test.log(Status.PASS, "Verify registration complete message");
        Reporter.log("Verify registration complete message" + verifyRegistration.toString());
        return getTextFromElement(verifyRegistration);
    }

    public void clickOnContinueTab() {
        clickOnElement(continueTab);
        CustomListeners.test.log(Status.PASS, "Click on continue tab");
        Reporter.log("Click on continue tab" + continueTab.toString());
    }

}
