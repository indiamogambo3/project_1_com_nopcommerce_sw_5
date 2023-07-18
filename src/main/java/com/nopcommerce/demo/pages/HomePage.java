package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(className = "page-title")
    WebElement verifyPageTitle;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
    WebElement verifyWelcomeText;
    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'top-menu notmobile']//a[text() = 'Electronics ']")
    WebElement electronics;
    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")
    WebElement cellPhone;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logOut;

    public void selectMenu(String menu) {
        By topMenuBar = By.xpath("//ul[@class='top-menu notmobile']/li/a[text() = '" + menu + " ']");
        clickOnElement(topMenuBar);
    }


    public String verifyPageNavigation() {
        CustomListeners.test.log(Status.PASS, "Verify text");
        Reporter.log("Verify Text" + verifyPageTitle.toString());
        return getTextFromElement(verifyPageTitle);
    }

    public String verifyWelcomeToStoreText() {
        CustomListeners.test.log(Status.PASS, "Verify Welcome To Store text");
        Reporter.log("Verify Welcome To Store text" + verifyWelcomeText.toString());
        return getTextFromElement(verifyWelcomeText);
    }

    public void mouseHoverToElectronics() {
        mouseHoverToElement(electronics);
        CustomListeners.test.log(Status.PASS, "Mouse hover to electronics");
        Reporter.log("Mouse hover to electronics" + electronics.toString());
    }

    public void mouseHoverAndClickOnCellPhones() {
        mouseHoverToElementAndClick(cellPhone);
        CustomListeners.test.log(Status.PASS, "Mouse hover and click on cell phones");
        Reporter.log("Mouse hover and click on cell phones" + cellPhone.toString());
    }

    public void clickOnLogoutLink() {
        clickOnElement(logOut);
        CustomListeners.test.log(Status.PASS, "Click on logout link");
        Reporter.log("Click on logout link" + logOut.toString());
    }

}
