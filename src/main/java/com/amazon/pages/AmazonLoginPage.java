/**
 * The AmazonLoginPage class extends BasePage(AndroidUIActions) class and uses basic functionality and common utilities on the elements of this page. This class initialize and implements
 * the elements of Amazon app -- Login Page.
 *
 * @author  Riya Malhotra
 * @version 1.0
 * @since   2020-05-08
 */
package com.amazon.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import com.amazon.logManager.MyLogger;
import com.amazon.utils.AndroidUiActions;

public class AmazonLoginPage extends AndroidUiActions {
	public AmazonLoginPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		MyLogger.log.info("AmazonHomePage Objects instance is created");
	}

	// UserName
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private AndroidElement username;

	// Password
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private AndroidElement password;

	// Continue button
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
	private AndroidElement continueBtn;

	// SignIn button
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Login']")
	private AndroidElement signInButton;

	/*
	 * enterUsername function enters the username to login into account
	 *
	 * @author Riya Malhotra
	 */
	public AmazonLoginPage enterUsername() {
		try {
			typeText(username, getPropertiesFileData("username"));
			MyLogger.log.info("Entered mobile number to login");

		} catch (Exception e) {
			MyLogger.log.error("Unable to enter mobile number");
			Assert.fail("Unable to enter mobile number" + e.getMessage());
		}
		return this;
	}

	/*
	 * tapContinueButton function taps on Continue button
	 *
	 * @author Riya Malhotra
	 */
	public AmazonLoginPage tapContinueButton() {
		try {
			tap(continueBtn);
			MyLogger.log.info("Tapped on continue button");

		} catch (Exception e) {
			MyLogger.log.error("Unable to tap on continue button");
			Assert.fail("Unable to tap on continue button" + e.getMessage());
		}
		return this;
	}

	/*
	 * enterPassword function enters the password to login into account
	 *
	 * @author Riya Malhotra
	 */
	public AmazonLoginPage enterPassword() {
		try {
			Thread.sleep(2000);
			typeText(password, getPropertiesFileData("password"));
			MyLogger.log.info("Entered password");

		} catch (Exception e) {
			MyLogger.log.error("Unable to enter password");
			Assert.fail("Unable to enter password" + e.getMessage());
		}
		return this;
	}

	/*
	 * tapSignInButton function taps on SignIn button
	 *
	 * @author Riya Malhotra
	 */
	public AmazonLoginPage tapSignInButton() {
		try {
			tap(signInButton);
			MyLogger.log.info("Tapped on SignIn button");

		} catch (Exception e) {
			MyLogger.log.error("Unable to tap on SignIn button");
			Assert.fail("Unable to tap on SignIn button" + e.getMessage());
		}
		return this;
	}
}
