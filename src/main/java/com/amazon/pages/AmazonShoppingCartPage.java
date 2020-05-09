/**
 * The AmazonShoppingCartPage class extends BasePage(AndroidUIActions) class and uses basic functionality 
 * and common utilities on the elements of this page.
 * This class initialize and implements the elements of Amazon app -- Shopping Cart Page.
 *
 * @author  Riya Malhotra
 * @version 1.0
 * @since   2020-05-09
 */

package com.amazon.pages;

import org.testng.Assert;
import com.amazon.logManager.MyLogger;
import com.amazon.utils.AndroidUiActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AmazonShoppingCartPage extends AndroidUiActions {
	public static String cartProductName;
	public static String cartProductPrice;
	
	public AmazonShoppingCartPage(AndroidDriver<AndroidElement> driver){
        super(driver);
        MyLogger.log.info("AmazonShoppingCartPage Objects instance is created");
    }
	
	//cart product price
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.TextView[3]")
    private AndroidElement cartPrice;
    
	//cart product name
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View[5]/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View")
    private AndroidElement cartName;
    
    /*
	 * productPriceOnCartPage function saves the product price visible on cart screen
	 *
	 * @author Riya Malhotra
	 */
	public AmazonShoppingCartPage productPriceOnCartPage() {
		try {
			cartProductPrice=getText(cartPrice);	
			System.out.println(cartProductPrice);
			MyLogger.log.info("saved product price");

		} catch (Exception e) {
			MyLogger.log.error("Unable to get product price");
			Assert.fail("Unable to get product price" + e.getMessage());
		}
		return this;
	}
	
	/*
	 * productNameOnCartPage function saves the product name visible on cart screen
	 *
	 * @author Riya Malhotra
	 */
	public AmazonShoppingCartPage productNameOnCartPage() {
		try {
			cartProductName=getText(cartName);		
			MyLogger.log.info("saved product name");

		} catch (Exception e) {
			MyLogger.log.error("Unable to get product name");
			Assert.fail("Unable to get product name" + e.getMessage());
		}
		return this;
	}
}
