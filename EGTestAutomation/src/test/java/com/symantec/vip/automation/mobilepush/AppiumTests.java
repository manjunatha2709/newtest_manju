package com.symantec.vip.automation.mobilepush;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.symantec.vip.automation.mobile.screens.PushScreen;

import io.appium.java_client.AppiumDriver;

public class AppiumTests {
	Logger logger = Logger.getLogger("VIP_EG_AUTOMATION");
	AppiumDriver appiumDriver;

	public void actOnAppium(String deviceNumber, String action, String os) {
		LocalAppiumDriverFactory localDriverFactory = new LocalAppiumDriverFactory();
		try {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Appium Action is " + action.toUpperCase());
			if ("makedriver".equalsIgnoreCase(action)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "No existing driver found, so making a new appium driver");
				appiumDriver = localDriverFactory.createInstance(deviceNumber, os);
			} else if ("allow".equalsIgnoreCase(action)) {
				PushScreen pushScreen = new PushScreen(appiumDriver, os);
				HashMap<String, String> configuration = new HashMap<String, String>();
				configuration.put("push_action", "approve");
				pushScreen.ActOnPushNotification(configuration);
			} else if ("deny".equalsIgnoreCase(action)) {
				PushScreen pushScreen = new PushScreen(appiumDriver, os);
				HashMap<String, String> configuration = new HashMap<String, String>();
				configuration.put("push_action", "deny");
				pushScreen.ActOnPushNotification(configuration);
				// appiumDriver.closeApp();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void takeScreenshot(AppiumDriver appiumDriver) {
		try {
			logger.error("Thread-" + Thread.currentThread().getId() + ": " + "Taking screenshot of Appium Driver");
			File scrFile = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy
			// somewhere
			String workingDir = System.getProperty("user.dir");
			String path = workingDir + "/Screenshots";
			FileUtils.copyFile(scrFile, new File(path + "/" + Thread.currentThread().getName() + ".png"));
		} catch (Exception e) {
			logger.error("Thread-" + Thread.currentThread().getId() + ": " + "Error occured while taking the screenshot");
		}
	}
}
