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

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Shopping cart')]")
    WebElement verifyText;

    @CacheLookup
    @FindBy(xpath = "//input[@class = 'qty-input']")
    WebElement quantity;

    @CacheLookup
    @FindBy(id = "updatecart")
    WebElement updateCart;

    @CacheLookup
    @FindBy(xpath = "//span[@class ='value-summary']/strong")
    WebElement verifyTotal;

    @CacheLookup
    @FindBy(id = "termsofservice")
    WebElement termsOfService;
    @CacheLookup
    @FindBy(id = "checkout")
    WebElement checkout;
    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement login;


    public String verifyTextShoppingCart() {
        CustomListeners.test.log(Status.PASS, "Verify text shopping cart");
        Reporter.log("verify text shopping cart" + verifyText.toString());
        return getTextFromElement(verifyText);
    }

    public void clearQuantity() {
        driver.findElement(By.xpath("//input[@class = 'qty-input']")).clear();
        CustomListeners.test.log(Status.PASS, "Clear quantity");
        Reporter.log("Clear quantity" + quantity.toString());
    }

    public void quantityAmount(String quantityRequired) {
        sendTextToElement(quantity, quantityRequired);
        CustomListeners.test.log(Status.PASS, "Enter quantity amount");
        Reporter.log("Enter quantity amount" + quantity.toString());
    }

    public void updateShoppingCart() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(updateCart);
        CustomListeners.test.log(Status.PASS, "Update shopping cart");
        Reporter.log("Update shopping cart" + updateCart.toString());
    }

    public String verifyTotalAmount() {
        CustomListeners.test.log(Status.PASS, "Verify total amount");
        Reporter.log("Verify total amount" + verifyTotal.toString());
        return getTextFromElement(verifyTotal);
    }

    public void clickOnTermsOfService() {
//        clickOnElement(termsOfService);
        try{
            driver.findElement(By.id("termsofservice")).click();

        }catch (StaleElementReferenceException e) {

        }
        CustomListeners.test.log(Status.PASS, "Click on terms of service");
        Reporter.log("Click on terms of service" + termsOfService.toString());
    }

    public void clickOnCheckoutButton() {
//        clickOnElement(checkout);
        try{
            driver.findElement(By.id("checkout")).click();

        }catch (StaleElementReferenceException e) {

        }
        CustomListeners.test.log(Status.PASS, "Click on checkout button");
        Reporter.log("Click on checkout button" + checkout.toString());
    }

    public void clickOnLoginLink() {
//        clickOnElement(login);
        try{
            driver.findElement(By.linkText("Log in")).click();

        }catch (StaleElementReferenceException e) {

        }
        CustomListeners.test.log(Status.PASS, "Click on login link");
        Reporter.log("Click on login link" + login.toString());
    }

}
