package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners(CustomListeners.class)

public class ElectronicsTest extends BaseTest {

    HomePage homePage;
    CellPhonePage cellPhonePage;
    NokiaLumiaPage nokiaLumiaPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    RegisterPage registerPage;
    LoginPage loginPage;


    @BeforeMethod
    public void inIt() {

        homePage = new HomePage();
        cellPhonePage = new CellPhonePage();
        nokiaLumiaPage = new NokiaLumiaPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
    }


    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

        SoftAssert softAssert = new SoftAssert();

        //1.1 Mouse Hover on “Electronics” Tab
        homePage.mouseHoverToElectronics();
        //1.2 Mouse Hover on “Cell phones” and click
        homePage.mouseHoverAndClickOnCellPhones();
        //1.3 Verify the text “Cell phones”1.3 Verify the text “Cell phones”
        String expectedCellPhoneText = "Cell phones";
        softAssert.assertTrue(expectedCellPhoneText == "Cell phones", "Unable to verify text.");
        softAssert.assertAll();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //2.1 Mouse Hover on “Electronics” Tab
        homePage.mouseHoverToElectronics();
        //2.2 Mouse Hover on “Cell phones” and click
        homePage.mouseHoverAndClickOnCellPhones();
        //2.3 Verify the text “Cell phones”
        String expectedCellPhoneText = "Cell phones";
        softAssert.assertTrue(expectedCellPhoneText == "Cell phones", "Unable to verify text.");
        //2.4 Click on List View Tab
        cellPhonePage.clickOnListViewTab();
        //2.5 Click on product name “Nokia Lumia 1020” link
        cellPhonePage.clickOnNokiaLumia1020Link();
        //2.6 Verify the text “Nokia Lumia 1020”
        String expectedText = "Nokia Lumia 1020";
        softAssert.assertTrue(expectedText == "Nokia Lumia 1020", "Unable to verify text.");
        //2.7 Verify the price “$349.00”
        String expectedPrice = "$349.00";
        softAssert.assertTrue(expectedPrice == "$349.00", "Unable to verify price.");
        //2.8 Change quantity to 2
        Thread.sleep(2000);
        nokiaLumiaPage.clearQuantity();
        Thread.sleep(2000);
        nokiaLumiaPage.inputQuantity("2");
        //2.9 Click on “ADD TO CART” tab
        nokiaLumiaPage.clickOnAddToCart();
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedAddedToCartMessage = "The product has been added to your shopping cart";
        softAssert.assertTrue(expectedAddedToCartMessage == "The product has been added to your shopping cart", "Unable to verify message.");
        //After that close the bar clicking on the cross button.
        nokiaLumiaPage.clickOnCrossButtonToCloseBar();
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        nokiaLumiaPage.mouseHoverOnShoppingCart();
        nokiaLumiaPage.clickOnGoToCart();
        //2.12 Verify the message "Shopping cart"
        String expectedShoppingCartMessage = "Shopping cart";
        softAssert.assertEquals(expectedShoppingCartMessage == "Shopping cart", "Unable to verify text.");
        //2.13 Verify the quantity is 2
        String expectedQuantity = "2";
        String actualQuantity = driver.findElement(By.xpath("//input[@class='qty-input']")).getAttribute("value");
        Assert.assertEquals(actualQuantity, expectedQuantity, "Unable to verify quantity.");
        //2.14 Verify the Total $698.00
        String expectedTotalAmount = "$698.00";
        softAssert.assertTrue(expectedTotalAmount == "$698.00", "Unable to verify total.");
        //2.15 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermsOfService();
        //2.16 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckoutButton();
        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedWelcomeText = "Welcome, Please Sign In!";
        softAssert.assertTrue(expectedWelcomeText == "Welcome, Please Sign In!", "Unable to verify text.");
        //2.18 Click on “REGISTER” tab
        checkoutPage.clickOnRegisterTab();
        //2.19 Verify the text “Register”
        String expectedRegisterText = "Register";
        softAssert.assertTrue(expectedRegisterText == "Register", "Unable to verify text.");
        //2.20 Fill the mandatory fields
        registerPage.enterFirstName("Mukz");
        registerPage.enterLastName("Shah");
        registerPage.enterEmail("mukesh20@gmail.com");
        registerPage.enterPassword("Mukz123");
        registerPage.enterConfirmPassword("Mukz123");
        //2.21 Click on “REGISTER” Button
        registerPage.clickOnRegisterButton();
        //2.22 Verify the message “Your registration completed”
        String expectedRegistrationMessage = "Your registration completed";
        softAssert.assertTrue(expectedRegistrationMessage == "Your registration completed", "Unable to verify message.");
        //2.23 Click on “CONTINUE” tab
        registerPage.clickOnContinueTab();
        //2.24 Verify the text “Shopping cart”
        String expectedShoppingCartText = "Shopping cart";
        softAssert.assertTrue(expectedShoppingCartText == "Shopping cart", "Unable to verify text.");
        //2.25 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnLoginLink();
        loginPage.enterEmail("mukesh20@gmail.com");
        loginPage.enterPassword("Mukz123");
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
        shoppingCartPage.clickOnTermsOfService();
        Thread.sleep(2000);
        //2.26 Click on “CHECKOUT”
        Thread.sleep(2000);
        shoppingCartPage.clickOnCheckoutButton();
        //2.27 Fill the Mandatory fields
        checkoutPage.selectCountryName("United Kingdom");
        checkoutPage.enterCityName("London");
        checkoutPage.enterAddressLine1("123 The Best Street");
        checkoutPage.enterPostalCode("LN1 1LN");
        checkoutPage.enterPhoneNumber("11223344556");
        //2.28 Click on “CONTINUE”
        checkoutPage.clickOnContinueButton();
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        checkoutPage.clickOnSecondDayAir();
        //2.30 Click on “CONTINUE”
        checkoutPage.clickOnContinueLink();
        //2.31 Select Radio Button “Credit Card”
        checkoutPage.selectCreditCardRadioButton();
        checkoutPage.clickOnContinue();
        //2.32 Select “Visa” From Select credit card dropdown
        checkoutPage.selectCreditCard("visa");
        //2.33 Fill all the details
        checkoutPage.enterCardHolderName("Mukz");
        checkoutPage.enterCardNumber("1254658974125698");
        checkoutPage.selectExpiryMonth("10");
        checkoutPage.selectExpiryYear("2025");
        checkoutPage.enterCardCode("222");
        //2.34 Click on “CONTINUE”
        checkoutPage.clickContinueButton();
        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedPaymentMethod = "Credit Card";
        softAssert.assertTrue(expectedPaymentMethod == "Credit Card", "Unable to verify method.");
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedShippingMethod = "2nd Day Air";
        softAssert.assertTrue(expectedShippingMethod == "2nd Day Air", "Unable to verify method.");
        //2.37 Verify Total is “$698.00”
        String expectedTotal = "$698.00";
        softAssert.assertTrue(expectedTotal == "$698.00", "Unable to verify total.");
        //2.38 Click on “CONFIRM”
        checkoutPage.clickOnConfirmButton();
        //2.39 Verify the Text “Thank You”
        String expectedThankYouText = "Thank you";
        softAssert.assertTrue(expectedThankYouText == "Thank you", "Unable to verify text.");
        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedOrderSuccessfulMessage = "Your order has been successfully processed!";
        softAssert.assertTrue(expectedOrderSuccessfulMessage == "Your order has been successfully processed!", "Unable to verify message.");
        //2.41 Click on “CONTINUE”
        checkoutPage.clickOnContinueButtonOnThankYouPage();
        //2.42 Verify the text “Welcome to our store”
        String expectedWelcomeStoreText = "Welcome to our store";
        softAssert.assertTrue(expectedWelcomeStoreText == "Welcome to our store", "Unable to verify text.");
        //2.43 Click on “Logout” link
        homePage.clickOnLogoutLink();
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Unable to verify URL.");

    }

}
