package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//select[@id='products-orderby']")
    WebElement sortByDropDownList;

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]")
    WebElement addToCart;


    public void selectDropDown(String text) {

        selectByVisibleTextFromDropDown(sortByDropDownList, text);
        CustomListeners.test.log(Status.PASS, "Unable to select dropdown");
        Reporter.log("Click on dropdown link" + sortByDropDownList.toString());
    }

    public void verifyProductsInDescendingOrder() {

        SoftAssert softAssert = new SoftAssert();

        CustomListeners.test.log(Status.PASS, "Product not arranged in descending order.");
        Reporter.log("Products arranged in descending order");

        List<WebElement> productNames = driver.findElements(By.xpath("//h2[@class='product-name']/a"));
        List<String> productNameStrings = new ArrayList<String>();
        for (WebElement productName : productNames) {
            productNameStrings.add(productName.getText());
        }
        List<String> sortedProductNames = new ArrayList<String>(productNameStrings);
        Collections.sort(sortedProductNames, Collections.reverseOrder());
        softAssert.assertEquals(productNameStrings, sortedProductNames);
        softAssert.assertAll();
//        Assert.assertEquals(productNameStrings, sortedProductNames);
    }

    public void addProductToCart() throws InterruptedException {
        Thread.sleep(2000);

        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS, "Add product to cart.");
        Reporter.log("Add product to cart." + addToCart.toString());
    }

}
