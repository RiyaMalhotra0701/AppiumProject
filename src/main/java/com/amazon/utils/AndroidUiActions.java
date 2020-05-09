/**
 * The AndroidUiActions class defines all basic and common utilities such as click, sendKeys, scroll etc.
 * which can further be used by multiple classes and test cases.
 *
 * @author  Riya Malhotra
 * @version 1.0
 * @since   2020-05-08
 */
package com.amazon.utils;

import com.amazon.logManager.MyLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import java.time.Duration;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;

public class AndroidUiActions {
	public AndroidDriver<AndroidElement> driver;

	public AndroidUiActions(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
		MyLogger.log.info("AndroidUiActions Objects instance is created");
	}

	public WebElement waitToAppear(AndroidElement element) throws Exception {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException toe) {
			MyLogger.log.info("No element was found within specified wait time " + element.toString());
			throw new Exception();
		}
	}

	public String getText(AndroidElement element) {
		try {
			return waitToAppear(element).getText();
		} catch (Exception e) {
			return null;
		}
	}

	public AndroidUiActions clearText(AndroidElement element) {
		try {
			waitToAppear(element).clear();
		} catch (Exception e) {
		}
		return this;
	}

	public AndroidUiActions typeText(AndroidElement element, String text) {
		try {
			waitToAppear(element).sendKeys(text);
		} catch (Exception e) {
		}
		return this;
	}

	public AndroidUiActions tap(AndroidElement element) throws Exception {
		MyLogger.log.info("Inside tap");
		try{
			waitToAppear(element).click();
		}
		catch(Exception e) {
		}
		return this;
	}

	public AndroidUiActions pressEnterKey() {
		try {
			pressKey(AndroidKey.ENTER);
			MyLogger.log.info("Successfully pressed the ENTER key");
		} catch (Exception e) {
			MyLogger.log.debug("Not able to pressed the ENTER key" + e.getMessage());
			Assert.fail("Not able to pressed the ENTER key" + e.getMessage());
		}

		return this;
	}

	private AndroidUiActions pressKey(AndroidKey androidKey) {
		try {
			driver.pressKey(new KeyEvent(androidKey));
			MyLogger.log.info("Pressed key " + androidKey.name());
		} catch (Exception e) {
			Assert.fail("Failed in pressAndroidKeyAction(" + androidKey.name() + ")", e);
		}
		return this;
	}

	
	public AndroidUiActions scrollToText(String visibleElementText) {
		try {
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(" + "new UiSelector().scrollable(true).instance(0))" + ".scrollIntoView("
							+ "new UiSelector().textContains(\"" + visibleElementText + "\").instance(0))");

		} catch (Exception e) {
			Assert.fail("Failed in scrollTo " + e.getMessage(), e);
		}
		return this;
	}

	public String getPropertiesFileData(String data) throws IOException {
		FileReader reader=new FileReader(System.getProperty("user.dir") + "\\src\\resources\\java\\" + "credentials.properties");
		Properties p=new Properties();
		p.load(reader);
		return p.getProperty(data);
	}
}
