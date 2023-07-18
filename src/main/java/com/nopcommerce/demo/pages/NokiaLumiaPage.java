package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class NokiaLumiaPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Nokia Lumia 1020')]")
    WebElement verifyPhoneText;
    @CacheLookup
    @FindBy(id = "price-value-20")
    WebElement verifyPhonePrice;
    @CacheLookup
    @FindBy(id = "product_enteredQuantity_20")
    WebElement quantity;
    @CacheLookup
    @FindBy(id = "add-to-cart-button-20")
    WebElement addToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'bar-notification success']//p[@class = 'content']")
    WebElement verifyProductAddedMessage;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'bar-notification success']//span[@class = 'close']")
    WebElement closeBar;
    @CacheLookup
    @FindBy(xpath = "//span[@class = 'cart-label']")
    WebElement mouseHover;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 cart-button']")
    WebElement goToCart;

    public String verifyNokiaLumiaText() {
        CustomListeners.test.log(Status.PASS, "Verify Nokia Lumia text");
        Reporter.log("Verify Nokia Lumia text" + verifyPhoneText.toString());
        return getTextFromElement(verifyPhoneText);
    }

    public String verifyPrice() {
        CustomListeners.test.log(Status.PASS, "Verify price");
        Reporter.log("Verify price" + verifyPhonePrice.toString());
        return getTextFromElement(verifyPhonePrice);
    }

    public void clearQuantity() {
        driver.findElement(By.id("product_enteredQuantity_20")).clear();
        CustomListeners.test.log(Status.PASS, "Clear quantity");
        Reporter.log("Clear quantity" + quantity.toString());
    }

    public void inputQuantity(String number) {
        sendTextToElement(quantity, number);
        CustomListeners.test.log(Status.PASS, "Input quantity");
        Reporter.log("Input quantity" + quantity.toString());
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "Click on add to cart");
        Reporter.log("Click on add to cart" + addToCart.toString());
    }

    public String verifyProductHasBeenAddedMessage() {
        CustomListeners.test.log(Status.PASS, "Verify product has been added message");
        Reporter.log("Verify product has been added message" + verifyProductAddedMessage.toString());
        return getTextFromElement(verifyProductAddedMessage);
    }

    public void clickOnCrossButtonToCloseBar() {
        clickOnElement(closeBar);
        CustomListeners.test.log(Status.PASS, "Click on cross button to close bar");
        Reporter.log("Click on cross button to close bar" + closeBar.toString());
    }

    public void mouseHoverOnShoppingCart() {
        mouseHoverToElement(mouseHover);
        CustomListeners.test.log(Status.PASS, "Mouse hover on shopping cart");
        Reporter.log("Mouse hover on shopping cart" + mouseHover.toString());
    }

    public void clickOnGoToCart() {
        clickOnElement(goToCart);
        CustomListeners.test.log(Status.PASS, "Click on go to cart");
        Reporter.log("Click on go to cart" + goToCart.toString());
    }

}
