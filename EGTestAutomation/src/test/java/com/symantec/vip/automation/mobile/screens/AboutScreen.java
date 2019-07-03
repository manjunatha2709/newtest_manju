package com.symantec.vip.automation.mobile.screens;

import io.appium.java_client.AppiumDriver;

import java.util.Map;
import org.openqa.selenium.By;

public class AboutScreen extends Page {
	/* close button that closes the wrapper after a fresh install */
	public static By aboutVIPAccessContentAndroid = By.id("com.verisign.mvip.main:id/id_icon_close");
	public static By aboutVIPAccessContentIos = By.xpath("//*[@name='id_about_details']");

	// public static By aboutVIPAccessContentIos = By.name("id_about_details");
	// public static By buttonCloseWrapperIos = By.name("id_coachmarks_close");
	// public static By buttonCloseWrapperIos = By.name("id_coachmarks_close");
	/* Security Code value */
	public By aboutContent() throws Exception {
		return getLocator(AboutScreen.class, "aboutVIPAccessContent" + os);
	}

	public String getAboutWindowContent() throws Exception {
		return driver.findElement(aboutContent()).getText();
	}

	public String getSecurityCode(AppiumDriver driver, Map<String, String> configuration) throws Exception {
		String securityCode = null;
		System.out.println("Getting security code");
		if (configuration.get("os").equalsIgnoreCase("android")) {
			// securityCode =
			// driver.findElement(fieldSecurityCode()).getText().trim();
		} else if (configuration.get("os").equalsIgnoreCase("ios")) {
			// securityCode =
			// driver.findElement(fieldSecurityCode()).getText().split(",")[1].trim();
		}
		System.out.println("Retrieved security code " + securityCode);
		return securityCode;
	}

	public AboutScreen(AppiumDriver driver, String os) {
		super(driver, os);
	}
}
