/**
 * The AmazonHomePage class extends BasePage(AndroidUIActions) class and uses basic functionality and common utilities on the elements of this page. This class initialize and implements
 * the elements of Amazon app -- Home Page.
 *
 * @author  Riya Malhotra
 * @version 1.0
 * @since   2020-05-08
 */
package com.amazon.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import org.testng.Assert;

import com.amazon.logManager.MyLogger;
import com.amazon.utils.AndroidUiActions;

public class AmazonHomePage extends AndroidUiActions {
	public AmazonHomePage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		MyLogger.log.info("AmazonHomePage Objects instance is created");
	}

	// Hamburger Icon
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon")
	private AndroidElement hamburgerIcon;

	// Home Icon
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Home']")
	private AndroidElement homeIcon;

	// Search Bar
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Search']")
	private AndroidElement searchBar;

	// Item
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/list_product_linear_layout")
	private List<AndroidElement> searchedItem;

	/*
	 * tapHamburgerIcon function taps on Hamburger Icon
	 *
	 * @author Riya Malhotra
	 */
	public AmazonHomePage tapHamburgerIcon() {
		try {
			tap(hamburgerIcon);
			MyLogger.log.info("Tapped on Hamburger Icon");

		} catch (Exception e) {
			MyLogger.log.error("Unable to tap on Hamburger Icon");
			Assert.fail("Unable to tap on Hamburger Icon" + e.getMessage());
		}
		return this;
	}

	/*
	 * tapHomeIcon function taps on Home Icon
	 *
	 * @author Riya Malhotra
	 */
	public AmazonHomePage tapHomeIcon() {
		try {
			tap(homeIcon);
			MyLogger.log.info("Tapped on Home Icon");

		} catch (Exception e) {
			MyLogger.log.error("Unable to tap on Home Icon");
			Assert.fail("Unable to tap on Home Icon" + e.getMessage());
		}
		return this;
	}

	/*
	 * enterProductName function enters the item to be searched in search bar
	 *
	 * @author Riya Malhotra
	 */
	public AmazonHomePage enterProductName() {
		try {
			tap(searchBar);
			Thread.sleep(2000);
			typeText(searchBar, getPropertiesFileData("product"));
			pressEnterKey();
			MyLogger.log.info("enters the item to be searched");

		} catch (Exception e) {
			MyLogger.log.error("Unable to enter item");
			Assert.fail("Unable to enter item" + e.getMessage());
		}
		return this;
	}

	/*
	 * selectProductFromList function selects the item from the list of searched
	 * items
	 *
	 * @author Riya Malhotra
	 */
	public AmazonHomePage selectProductFromList() {
		try {
			tap(searchedItem.get(1));
			MyLogger.log.info("selected the desired item");

		} catch (Exception e) {
			MyLogger.log.error("Unable to select item");
			Assert.fail("Unable to select item" + e.getMessage());
		}
		return this;
	}

}
