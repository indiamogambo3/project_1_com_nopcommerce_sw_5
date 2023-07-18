package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BuildYourOwnComputerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement verifyTextBuildYourOwnComputer;

    @CacheLookup
    @FindBy(id = "product_attribute_1")
    WebElement processor;

    @CacheLookup
    @FindBy(id = "product_attribute_2")
    WebElement ram;

    @CacheLookup
    @FindBy(id = "product_attribute_3_7")
    WebElement hddRadio;

    @CacheLookup
    @FindBy(id = "product_attribute_4_9")
    WebElement osRadio;

    @CacheLookup
    @FindBy(id = "product_attribute_5_12")
    WebElement software;

    @CacheLookup
    @FindBy(xpath = "//span[@id='price-value-1']")
    WebElement verifyPrice;

    @CacheLookup
    @FindBy(id = "add-to-cart-button-1")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='bar-notification success']/p")
    WebElement verifyProductAddedMessage;

    @CacheLookup
    @FindBy(xpath = "//span[@class = 'close']")
    WebElement crossButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement shoppingCart;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement goToCart;


    public String verifyBuildYourOwnComputerText() {
        CustomListeners.test.log(Status.PASS, "Verify Build YourOwn Computer Text.");
        Reporter.log("Verify Build YourOwn Computer Text." + verifyTextBuildYourOwnComputer.toString());
        return getTextFromElement(verifyTextBuildYourOwnComputer);
    }

    public void selectProcessor(String text) {
        selectByVisibleTextFromDropDown(processor, text);
        CustomListeners.test.log(Status.PASS, "Select processor.");
        Reporter.log("Select Processor." + processor.toString());
    }

    public void selectRam(String text) {
        selectByVisibleTextFromDropDown(ram, text);
        CustomListeners.test.log(Status.PASS, "Select ram.");
        Reporter.log("Select ram." + ram.toString());
    }

    public void selectHDDRadioButton() {
        clickOnElement(hddRadio);
        CustomListeners.test.log(Status.PASS, "Select HDD radio button.");
        Reporter.log("Select HDD radio button." + hddRadio.toString());
    }

    public void selectOSRadioButton() {
        clickOnElement(osRadio);
        CustomListeners.test.log(Status.PASS, "Select OS radio button.");
        Reporter.log("Select OS radio button." + osRadio.toString());
    }

    public void selectSoftware() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(software);
        CustomListeners.test.log(Status.PASS, "Select software.");
        Reporter.log("Select software." + software.toString());
    }

    public String verifyCorrectPrice() {
        CustomListeners.test.log(Status.PASS, "Verify correct price.");
        Reporter.log("Verify correct price." + verifyPrice.toString());
        return getTextFromElement(verifyPrice);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "Click on add to cart button.");
        Reporter.log("Click on add to cart button." + addToCart.toString());
    }

    public String verifyProductHasBeenAddedText() {
        CustomListeners.test.log(Status.PASS, "Verify product has been added text.");
        Reporter.log("Verify product has been added text." + verifyProductAddedMessage.toString());
        return getTextFromElement(verifyProductAddedMessage);
    }

    public void closeTheBar() {
        clickOnElement(crossButton);
        CustomListeners.test.log(Status.PASS, "Close the bar.");
        Reporter.log("Close the bar." + crossButton.toString());
    }

    public void mouseHoverToShoppingCart() {
        mouseHoverToElement(shoppingCart);
        CustomListeners.test.log(Status.PASS, "Mouse hover to shopping cart.");
        Reporter.log("Mouse hover to shopping cart." + shoppingCart.toString());
    }

    public void clickOnGoToCart() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(goToCart);
        CustomListeners.test.log(Status.PASS, "Click on go to cart.");
        Reporter.log("Click on go to cart." + goToCart.toString());
    }

}
