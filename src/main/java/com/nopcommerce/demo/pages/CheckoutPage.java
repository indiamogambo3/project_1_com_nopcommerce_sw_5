package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckoutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement verifyWelcomeText;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Checkout as Guest')]")
    WebElement guestCheckout;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_Email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement countryField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_City")
    WebElement cityField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement addressLine1Field;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement postalCodeField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumberField;
    @CacheLookup
    @FindBy(xpath = "//div[@id = 'billing-buttons-container']//button[@class = 'button-1 new-address-next-step-button']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(id = "shippingoption_1")
    WebElement nextDayRadioButton;
    @CacheLookup
    @FindBy(xpath = "//button[@class = 'button-1 shipping-method-next-step-button']")
    WebElement continueShipping;
    @CacheLookup
    @FindBy(id = "paymentmethod_1")
    WebElement creditCard;
    @CacheLookup
    @FindBy(xpath = "//button[@class = 'button-1 payment-method-next-step-button']")
    WebElement continuePayment;
    @CacheLookup
    @FindBy(id = "CreditCardType")
    WebElement creditCardType;
    @CacheLookup
    @FindBy(id = "CardholderName")
    WebElement cardHolderNameField;
    @CacheLookup
    @FindBy(id = "CardNumber")
    WebElement cardNumberField;
    @CacheLookup
    @FindBy(id = "ExpireMonth")
    WebElement expiryMonth;
    @CacheLookup
    @FindBy(id = "ExpireYear")
    WebElement expiryYear;
    @CacheLookup
    @FindBy(id = "CardCode")
    WebElement cardCode;
    @CacheLookup
    @FindBy(xpath = "//button[@class = 'button-1 payment-info-next-step-button']")
    WebElement continueNextStep;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Credit Card')]")
    WebElement verifyPaymentText;
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space() = 'Next Day Air']")
    WebElement verifyShippingText;
    @CacheLookup
    @FindBy(xpath = "//span[1]/strong[1]")
    WebElement verifyTotal;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    WebElement confirmButton;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Thank you')]")
    WebElement verifyText;
    @CacheLookup
    @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
    WebElement verifyOrderSuccessfulText;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueAtThankYouPage;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement register;
    @CacheLookup
    @FindBy(id = "shippingoption_2")
    WebElement secondDayAir;
    @CacheLookup
    @FindBy(xpath = "//li[@class = 'shipping-method']//span[@class = 'value']")
    WebElement verifySecondAir;


    public String verifyWelcomeSignInText() {
        CustomListeners.test.log(Status.PASS, "Verify welcome sign in text");
        Reporter.log("Verify welcome sign in text" + verifyWelcomeText.toString());
        return getTextFromElement(verifyWelcomeText);
    }

    public void clickOnGuestCheckout() {
        clickOnElement(guestCheckout);
        CustomListeners.test.log(Status.PASS, "Click on guest checkout");
        Reporter.log("Click on guest checkout" + guestCheckout.toString());
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

    public void enterEmailId(String email) {
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS, "Enter email");
        Reporter.log("Enter email" + emailField.toString());
    }

    public void selectCountryName(String country) {
        selectByVisibleTextFromDropDown(countryField, country);
        CustomListeners.test.log(Status.PASS, "Enter country");
        Reporter.log("Enter country" + countryField.toString());
    }

    public void enterCityName(String city) {
        sendTextToElement(cityField, city);
        CustomListeners.test.log(Status.PASS, "Enter city");
        Reporter.log("Enter city" + cityField.toString());
    }

    public void enterAddressLine1(String address1) {
        sendTextToElement(addressLine1Field, address1);
        CustomListeners.test.log(Status.PASS, "Enter address1");
        Reporter.log("Enter address1" + addressLine1Field.toString());
    }

    public void enterPostalCode(String postalCode) {
        sendTextToElement(postalCodeField, postalCode);
        CustomListeners.test.log(Status.PASS, "Enter postal code");
        Reporter.log("Enter postal code" + postalCodeField.toString());
    }

    public void enterPhoneNumber(String phoneNumber) {
        sendTextToElement(phoneNumberField, phoneNumber);
        CustomListeners.test.log(Status.PASS, "Enter phone number");
        Reporter.log("Enter phone number" + phoneNumberField.toString());
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue button");
        Reporter.log("Click on continue button" + continueButton.toString());
    }

    public void clickOnNextDayAirRadioButton() {
        clickOnElement(nextDayRadioButton);
        CustomListeners.test.log(Status.PASS, "Click on next day air radio button");
        Reporter.log("Click on next day air radio button" + nextDayRadioButton.toString());
    }

    public void clickOnContinueLink() {
        clickOnElement(continueShipping);
        CustomListeners.test.log(Status.PASS, "Click on continue link");
        Reporter.log("Click on continue link" + continueShipping.toString());
    }

    public void selectCreditCardRadioButton() {
        clickOnElement(creditCard);
        CustomListeners.test.log(Status.PASS, "Select credit card radio button");
        Reporter.log("Select credit card radio button" + creditCard.toString());
    }

    public void clickOnContinue() {
        clickOnElement(continuePayment);
        CustomListeners.test.log(Status.PASS, "Click on continue");
        Reporter.log("Click on continue" + continuePayment.toString());
    }

    public void selectCreditCard(String value) throws InterruptedException {
        Thread.sleep(2000);
        selectByValueFromDropDown(creditCardType, value);
        CustomListeners.test.log(Status.PASS, "Select credit card");
        Reporter.log("Select credit card" + creditCardType.toString());
    }

    public void enterCardHolderName(String name) {
        sendTextToElement(cardHolderNameField, name);
        CustomListeners.test.log(Status.PASS, "Enter card holder name");
        Reporter.log("Enter card holder name" + cardHolderNameField.toString());
    }

    public void enterCardNumber(String number) {
        sendTextToElement(cardNumberField, number);
        CustomListeners.test.log(Status.PASS, "Enter card number");
        Reporter.log("Enter card holder number" + cardNumberField.toString());
    }

    public void selectExpiryMonth(String value) {
        selectByValueFromDropDown(expiryMonth, value);
        CustomListeners.test.log(Status.PASS, "Select expiry month");
        Reporter.log("Select expiry month" + expiryMonth.toString());
    }

    public void selectExpiryYear(String value) {
        selectByValueFromDropDown(expiryYear, value);
        CustomListeners.test.log(Status.PASS, "Select expiry year");
        Reporter.log("Select expiry year" + expiryYear.toString());
    }

    public void enterCardCode(String number) {
        sendTextToElement(cardCode, number);
        CustomListeners.test.log(Status.PASS, "Enter card code");
        Reporter.log("Enter card code" + cardCode.toString());
    }

    public void clickContinueButton() {
        clickOnElement(continueNextStep);
        CustomListeners.test.log(Status.PASS, "Click on continue button");
        Reporter.log("Click on continue button" + continueNextStep.toString());
    }

    public String verifyPaymentMethod() {
        CustomListeners.test.log(Status.PASS, "Verify payment method");
        Reporter.log("Verify payment method" + verifyPaymentText.toString());
        return getTextFromElement(verifyPaymentText);
    }

    public String verifyShippingMethod() {
        CustomListeners.test.log(Status.PASS, "Verify shipping method");
        Reporter.log("Verify shipping method" + verifyPaymentText.toString());
        return getTextFromElement(verifyShippingText);
    }

    public String verifyTotalAmount() {
        CustomListeners.test.log(Status.PASS, "Verify total amount");
        Reporter.log("Verify total amount" + verifyTotal.toString());
        return getTextFromElement(verifyTotal);
    }

    public void clickOnConfirmButton() {
        clickOnElement(confirmButton);
        CustomListeners.test.log(Status.PASS, "Click on confirm button");
        Reporter.log("Click on confirm button" + confirmButton.toString());
    }

    public String verifyThankYouText() {
        CustomListeners.test.log(Status.PASS, "Verify Thank you text");
        Reporter.log("Verify Thank you text" + verifyText.toString());
        return getTextFromElement(verifyText);
    }

    public String verifyOrderIsSuccessful() {
        CustomListeners.test.log(Status.PASS, "Verify order is successful");
        Reporter.log("Verify order is successful" + verifyOrderSuccessfulText.toString());
        return getTextFromElement(verifyOrderSuccessfulText);
    }

    public void clickOnContinueButtonOnThankYouPage() {
//        clickOnElement(continueAtThankYouPage);
        try{
            driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();

        }catch (StaleElementReferenceException e) {

        }
        CustomListeners.test.log(Status.PASS, "Click on continue button on Thank you page");
        Reporter.log("Click on continue button on Thank you page" + continueAtThankYouPage.toString());
    }

    public void clickOnRegisterTab() {
        clickOnElement(register);
        CustomListeners.test.log(Status.PASS, "Click on register tab");
        Reporter.log("Click on register tab" + register.toString());
    }

    public void clickOnSecondDayAir() {
        clickOnElement(secondDayAir);
        CustomListeners.test.log(Status.PASS, "Click on second day air");
        Reporter.log("Click on second day air" + secondDayAir.toString());
    }

    public String verifySecondDayAir() {
        CustomListeners.test.log(Status.PASS, "Verify second day air");
        Reporter.log("Verify second day air" + verifySecondAir.toString());
        return getTextFromElement(verifySecondAir);
    }

}
