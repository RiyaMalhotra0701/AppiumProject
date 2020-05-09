/**
 * The AmazonSelectedProductPage class extends BasePage(AndroidUIActions) class and uses basic functionality 
 * and common utilities on the elements of this page.
 * This class initialize and implements the elements of Amazon app -- Selected Item Page.
 *
 * @author  Riya Malhotra
 * @version 1.0
 * @since   2020-05-08
 */

package com.amazon.pages;

import org.testng.Assert;
import com.amazon.logManager.MyLogger;
import com.amazon.utils.AndroidUiActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AmazonSelectedProductPage extends AndroidUiActions{
	public static String selectedProductName;
	public static String selectedProductPrice;
	
	public AmazonSelectedProductPage(AndroidDriver<AndroidElement> driver){
        super(driver);
        MyLogger.log.info("AmazonSelectedProductPage Objects instance is created");
    }

    //Product name
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='title']")
    private AndroidElement productName;
    
    //Product price
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='ourPrice_availability']")
    private AndroidElement productPrice;
    
    //     @AndroidFindBy(xpath = "//android.widget.Button[@text=’Add to Cart’]"
    //Add to Cart button
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='add-to-cart-button']")
    private AndroidElement addToCartButton;
    
    //Cart Icon
    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/chrome_action_bar_cart_count")
    private AndroidElement cartIcon;
    
    
    /*
	 * productNameOnProductPage function saves the product name visible on product information screen
	 *
	 * @author Riya Malhotra
	 */
	public AmazonSelectedProductPage productNameOnProductPage() {
		try {
			selectedProductName=getText(productName);	
			MyLogger.log.info("saved product name");

		} catch (Exception e) {
			MyLogger.log.error("Unable to get product name");
			Assert.fail("Unable to get product name" + e.getMessage());
		}
		return this;
	}
	
	/*
	 * productPriceOnProductPage function saves the product price visible on product information screen
	 *
	 * @author Riya Malhotra
	 */
	public AmazonSelectedProductPage productPriceOnProductPage() {
		try {
			selectedProductPrice=getText(productPrice);
			System.out.println(selectedProductPrice);
			MyLogger.log.info("saved product price");

		} catch (Exception e) {
			MyLogger.log.error("Unable to get product price");
			Assert.fail("Unable to get product price" + e.getMessage());
		}
		return this;
	}
	
	/*
	 * tapOnAddToCartButton function clicks on add to cart button
	 *
	 * @author Riya Malhotra
	 */
	public AmazonSelectedProductPage tapOnAddToCartButton() {
		try {
			scrollToText("Add to Cart");
			tap(addToCartButton);		
			MyLogger.log.info("Clicked on add to cart button");
		} catch (Exception e) {
			MyLogger.log.error("Unable to click on add to cart button");
			Assert.fail("Unable to click on add to cart button" + e.getMessage());
		}
		return this;
	}
	
	/*
	 * tapOnCartIcon function clicks on cart icon on the rightmost corner
	 *
	 * @author Riya Malhotra
	 */
	public AmazonSelectedProductPage tapOnCartIcon() {
		try {
			Thread.sleep(2000);
			tap(cartIcon);		
			MyLogger.log.info("Clicked on cart icon");

		} catch (Exception e) {
			MyLogger.log.error("Unable to click on cart icon");
			Assert.fail("Unable to click on cart icon" + e.getMessage());
		}
		return this;
	}
}
