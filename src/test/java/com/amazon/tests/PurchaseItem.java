/**
 * The PurchaseItem class specifies test case: Login into application->Search for item->Select item->Add to cart->
 * Verify product details on product description page matches with cart page.
 *
 * @author  Riya Malhotra
 * @version 1.0
 * @since   2020-05-09
 */

package com.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.amazon.pages.AmazonApp;
import com.amazon.pages.AmazonSelectedProductPage;
import com.amazon.pages.AmazonShoppingCartPage;

public class PurchaseItem {

	AmazonApp amazonApp;
	
	//Initialize driver to invoke Amazon application
	@Parameters({"DeviceType"})
	@BeforeMethod
	public void initializeDriver(String DeviceType) throws Exception {
		amazonApp=new AmazonApp(DeviceType,true);	
	}
	
	@Test
	public void purchaseItem() {
		amazonApp.amazonHomePage.tapHamburgerIcon().tapHomeIcon();
		amazonApp.amazonLoginPage.enterUsername().tapContinueButton().enterPassword().tapSignInButton();
		amazonApp.amazonHomePage.enterProductName().selectProductFromList();
		amazonApp.amazonSelectedProductPage.productNameOnProductPage().productPriceOnProductPage().tapOnAddToCartButton().tapOnCartIcon();
		amazonApp.amazonShoppingCartPage.productNameOnCartPage().productPriceOnCartPage();
		System.out.println(AmazonSelectedProductPage.selectedProductName);
		System.out.println(AmazonShoppingCartPage.cartProductName);
		System.out.println(AmazonSelectedProductPage.selectedProductPrice);
		System.out.println(AmazonShoppingCartPage.cartProductPrice);
		Assert.assertEquals(AmazonSelectedProductPage.selectedProductName, AmazonShoppingCartPage.cartProductName);
		Assert.assertEquals(AmazonSelectedProductPage.selectedProductPrice, AmazonShoppingCartPage.cartProductPrice);
	}

	//Quit the driver after execution of test case
	@AfterMethod
	public void quitDriver() {
		amazonApp.driver.quit();
	}
	
}
