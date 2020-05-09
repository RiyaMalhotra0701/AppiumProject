package com.amazon.pages;

import java.io.FileReader;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.amazon.logManager.MyLogger;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonApp {

	public AndroidDriver<AndroidElement> driver;
	public AmazonHomePage amazonHomePage;
	public AmazonLoginPage amazonLoginPage;
	public AmazonSelectedProductPage amazonSelectedProductPage;
	public AmazonShoppingCartPage amazonShoppingCartPage;
	
	public AmazonApp(String deviceType,boolean noReset) throws Exception {
        init(deviceType,noReset);
    }
	
	public void init(String deviceType,boolean noReset) throws Exception {
	   DesiredCapabilities caps = new DesiredCapabilities();
	   Object obj = new JsonParser().parse(new FileReader(System.getProperty("user.dir") + "\\src\\resources\\java\\" + "deviceDetails.json")); 
	   JsonObject jo = (JsonObject) obj;
       caps.setCapability(MobileCapabilityType.UDID, jo.getAsJsonObject(deviceType).get("udid").getAsString()); 
       caps.setCapability(MobileCapabilityType.DEVICE_NAME, jo.getAsJsonObject(deviceType).get("deviceName").getAsString());
       caps.setCapability(MobileCapabilityType.PLATFORM_NAME, jo.getAsJsonObject(deviceType).get("platformName").getAsString());
       caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, jo.getAsJsonObject(deviceType).get("appPackage").getAsString());
       caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, jo.getAsJsonObject(deviceType).get("appActivity").getAsString());
       caps.setCapability(MobileCapabilityType.NO_RESET, noReset);    
       driver=new AndroidDriver<AndroidElement>(new URL(jo.getAsJsonObject(deviceType).get("appiumServerUrl").getAsString()),caps);
       MyLogger.log.info("Session created successfully with  " + driver.getCapabilities());
       amazonHomePage= new AmazonHomePage(driver);
       MyLogger.log.info("AmazonHomePage instance is created");
       amazonLoginPage=new AmazonLoginPage(driver);
       MyLogger.log.info("AmazonLoginPage instance is created");
       amazonSelectedProductPage = new AmazonSelectedProductPage(driver);
       MyLogger.log.info("AmazonSelectedProductPage instance is created");
       amazonShoppingCartPage = new AmazonShoppingCartPage(driver);
       MyLogger.log.info("AmazonShoppingCartPage instance is created");
	}
}
