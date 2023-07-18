package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)

public class ComputerTest extends BaseTest {

    HomePage homePage;
    ComputersPage computersPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;


    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        computersPage = new ComputersPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();
    }

    @Test(groups = {"sanity", "regression"})

    public void verifyProductArrangeInAlphabeticalOrder() {

        //1.1 Click on Computer Menu.
        homePage.selectMenu("Computers");
        //1.2 Click on Desktop
        computersPage.clickOnDesktop();
        //1.3 Select Sort By position "Name: Z to A"
        desktopsPage.selectDropDown("Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        desktopsPage.verifyProductsInDescendingOrder();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //2.1 Click on Computer Menu.
        homePage.selectMenu("Computers");
        //2.2 Click on Desktop
        computersPage.clickOnDesktop();
        //2.3 Select Sort By position "Name: A to Z"
        desktopsPage.selectDropDown("Name: A to Z");
        //2.4 Click on "Add To Cart"
        desktopsPage.addProductToCart();
        //2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        softAssert.assertTrue(expectedText == "Build your own computer", "Unable to verify text.");
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        buildYourOwnComputerPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        buildYourOwnComputerPage.selectRam("8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        buildYourOwnComputerPage.selectHDDRadioButton();
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        buildYourOwnComputerPage.selectOSRadioButton();
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        buildYourOwnComputerPage.selectSoftware();
        //2.11 Verify the price "$1,475.00"
        Thread.sleep(2000);
        String expectedPrice = "$1,475.00";
        softAssert.assertEquals(buildYourOwnComputerPage.verifyCorrectPrice(), expectedPrice, "Unable to verify price.");
        //2.12 Click on "ADD TO CARD" Button.
        buildYourOwnComputerPage.clickOnAddToCartButton();
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        String expectedMessage = "The product has been added to your shopping cart";
        softAssert.assertTrue(expectedMessage == "The product has been added to your shopping cart", "Unable to verify message.");
        //After that close the bar clicking on the cross button.
        buildYourOwnComputerPage.closeTheBar();
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        buildYourOwnComputerPage.mouseHoverToShoppingCart();
        buildYourOwnComputerPage.clickOnGoToCart();
        //2.15 Verify the message "Shopping cart"
        String expectedShoppingCartMessage = "Shopping cart";
        softAssert.assertTrue(expectedShoppingCartMessage == "Shopping cart", "Unable to verify message.");
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        shoppingCartPage.clearQuantity();
        shoppingCartPage.quantityAmount("2");
        shoppingCartPage.updateShoppingCart();
        //2.17 Verify the Total"$2,950.00"
        String expectedTotal = "$2,950.00";
        softAssert.assertTrue(expectedTotal == "$2,950.00", "Unable to verify total.");
        //2.18 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermsOfService();
        //2.19 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckoutButton();
        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedWelcomeSignInText = "Welcome, Please Sign In!";
        softAssert.assertTrue(expectedWelcomeSignInText == "Welcome, Please Sign In!", "Unable to verify text.");
        //2.21Click on “CHECKOUT AS GUEST” Tab
        checkoutPage.clickOnGuestCheckout();
        //2.22 Fill the all mandatory field
        checkoutPage.enterFirstName("Mukz");
        checkoutPage.enterLastName("Shah");
        checkoutPage.enterEmailId("mukz1234@gmail.com");
        checkoutPage.selectCountryName("United Kingdom");
        checkoutPage.enterCityName("London");
        checkoutPage.enterAddressLine1("123 The Best Street");
        checkoutPage.enterPostalCode("LN1 1LN");
        checkoutPage.enterPhoneNumber("11223344556");
        //2.23 Click on “CONTINUE”
        checkoutPage.clickOnContinueButton();
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        checkoutPage.clickOnNextDayAirRadioButton();
        //2.25 Click on “CONTINUE”
        checkoutPage.clickOnContinueLink();
        //2.26 Select Radio Button “Credit Card”
        checkoutPage.selectCreditCardRadioButton();
        //Click on continue
        checkoutPage.clickOnContinue();
        //2.27 Select “Master card” From Select credit card dropdown
        checkoutPage.selectCreditCard("MasterCard");
        //2.28 Fill all the details
        checkoutPage.enterCardHolderName("Mr. M. Shah");
        checkoutPage.enterCardNumber("5534 5678 1234 5678");
        checkoutPage.selectExpiryMonth("9");
        checkoutPage.selectExpiryYear("2027");
        checkoutPage.enterCardCode("587");
        //2.29 Click on “CONTINUE”
        checkoutPage.clickContinueButton();
        //2.30 Verify “Payment Method” is “Credit Card”
        String expectedPaymentMethod = "“Credit Card";
        softAssert.assertTrue(expectedPaymentMethod == "Credit Card", "Unable to verify method");
        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Next Day Air";
        softAssert.assertTrue(expectedShippingMethod == "Next Day Air", "Unable to verify Next Day Air");
        //2.33 Verify Total is “$2,950.00”
        String expectedTotalIs = "$2,950.00";
        softAssert.assertTrue(expectedTotalIs == "$2,950.00", "Unable to verify total.");
        //2.34 Click on “CONFIRM”
        checkoutPage.clickOnConfirmButton();
        //2.35 Verify the Text “Thank You”
        String expectedThankYouText = "Thank you";
        softAssert.assertTrue(expectedThankYouText == "Thank you", "Unable to verify message.");
        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedSuccessfulText = "Your order has been successfully processed!";
        softAssert.assertTrue(expectedSuccessfulText == "Your order has been successfully processed!", "Unable to verify message");
        //2.37 Click on “CONTINUE”
        Thread.sleep(2000);
        checkoutPage.clickOnContinueButtonOnThankYouPage();
        //2.37 Verify the text “Welcome to our store”
        String expectedWelcomeText = "Welcome to our store";
        softAssert.assertEquals(homePage.verifyWelcomeToStoreText(), expectedWelcomeText);


    }

}


