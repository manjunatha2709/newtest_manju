package com.symantec.vip.automation.mobile.screens;

import io.appium.java_client.AppiumDriver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeScreen extends Page {
	/* close button that closes the wrapper after a fresh install */
	public static By buttonCloseWrapperAndroid = By.id("com.verisign.mvip.main:id/id_icon_close");
	// public static By buttonCloseWrapperIos = By.name("id_coachmarks_close");
	public static By buttonCloseWrapperIos = By.xpath("//*[@name='id_coachmarks_close']");
	// public static By buttonCloseWrapperIos = By.name("id_coachmarks_close");
	// public static By buttonCloseWrapperIos = By.name("id_coachmarks_close");
	/* Security Code value */
	public static By fieldSecuritycodeAndroid = By.id("com.verisign.mvip.main:id/scValue");
	public static By fieldSecuritycodeIos = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]");
	/* Credential ID value */
	public static By fieldCredentialIdAndroid = By.id("com.verisign.mvip.main:id/credValue");
	public static By fieldCredentialIdIos = By.xpath("//*[@name='id_credential_id']");
	// public static By fieldCredentialIdIos = By.name("id_credential_id");
	/* Timer Counter */
	public static By fieldCounterAndroid = By.id("com.verisign.mvip.main:id/counter");
	public static By fieldCounterIos = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[1]");
	/* Settings Button */
	public static By buttonMenuAndroid = By.id("com.verisign.mvip.main:id/SliderIconImg_home");
	public static By buttonMenuIos = By.xpath("//*[@name='id_menu']");
	// public static By buttonMenuIos = By.name("id_menu");
	/* Home sub Menu */
	public static By LinkHomeOnMenuAndroid = By
		.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
	public static By LinkHomeOnMenuIos = By.xpath("//*[@name='id_menu_home']");
	// public static By LinkHomeOnMenuIos = By.name("id_menu_home");
	/* Setting Sub Menu */
	public static By LinkSettingsOnMenuAndroid = By
		.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[2]/android.widget.TextView[1]");
	public static By LinkSettingsOnMenuIos = By.xpath("//*[@name='id_menu_settings']");
	// public static By LinkSettingsOnMenuIos = By.name("id_menu_settings");
	/* Setting How to Use Menu */
	public static By LinkHowToUseOnMenuAndroid = By
		.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]/android.widget.TextView[1]");
	public static By LinkHowToUseOnMenuIos = By.xpath("//*[@name='id_menu_how_to_use']");
	// public static By LinkHowToUseOnMenuIos = By.name("id_menu_how_to_use");
	/* Setting Troubleshooting Submenu */
	public static By LinkTroubleshootingOnMenuAndroid = By
		.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[4]/android.widget.TextView[1]");
	public static By LinkTroubleshootingOnMenuIos = By.xpath("//*[@name='id_menu_troubleshooting']");
	// public static By LinkTroubleshootingOnMenuIos =
	// By.name("id_menu_troubleshooting");
	/* Setting About Submenu */
	public static By LinkAboutOnMenuAndroid = By
		.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[5]/android.widget.TextView[1]");
	public static By LinkAboutOnMenuIos = By.xpath("//*[@name='id_menu_about']");

	// public static By LinkAboutOnMenuIos = By.name("id_menu_about");
	public By buttonMenu() throws Exception {
		return getLocator(HomeScreen.class, "buttonMenu" + os);
	}

	public By buttonCloseWrapper() throws Exception {
		return getLocator(HomeScreen.class, "buttonCloseWrapper" + os);
	}

	public By fieldCredentialId() throws Exception {
		return getLocator(HomeScreen.class, "fieldCredentialId" + os);
	}

	public By fieldSecurityCode() throws Exception {
		return getLocator(HomeScreen.class, "fieldSecuritycode" + os);
	}

	public By fieldTimeCounter() throws Exception {
		return getLocator(HomeScreen.class, "fieldCounter" + os);
	}

	public By LinkHomeOnMenu() throws Exception {
		return getLocator(HomeScreen.class, "LinkHomeOnMenu" + os);
	}

	public By LinkSettingsOnMenu() throws Exception {
		return getLocator(HomeScreen.class, "LinkSettingsOnMenu" + os);
	}

	public By LinkAboutOnMenu() throws Exception {
		return getLocator(HomeScreen.class, "LinkAboutOnMenu" + os);
	}

	public By LinkTroubleshootingOnMenu() throws Exception {
		return getLocator(HomeScreen.class, "LinkTroubleshootingOnMenu" + os);
	}

	public By LinkHowToUseOnMenu() throws Exception {
		return getLocator(HomeScreen.class, "LinkHowToUseOnMenu" + os);
	}

	public String getLabelOfHomeMenu() throws Exception {
		return driver.findElement(LinkHomeOnMenu()).getText();
	}

	public String getLabelOfAboutMenu() throws Exception {
		return driver.findElement(LinkAboutOnMenu()).getText();
	}

	public String getLabelOfTroubleshootingMenu() throws Exception {
		return driver.findElement(LinkTroubleshootingOnMenu()).getText();
	}

	public String getLabelOfSettingsMenu() throws Exception {
		return driver.findElement(LinkSettingsOnMenu()).getText();
	}

	public String getLabelOfHowToUseMenuMenu() throws Exception {
		return driver.findElement(LinkHowToUseOnMenu()).getText();
	}

	public void navigateToHome() throws Exception {
		System.out.println("Navigating to home screen");
		driver.findElement(buttonMenu()).click();
		if (isElementPresent(driver, LinkHomeOnMenu())) {
			driver.findElement(LinkHomeOnMenu()).click();
		} else {
			driver.findElement(buttonMenu()).click();
			driver.findElement(LinkHomeOnMenu()).click();
		}
	}

	public void navigateToAboutScreen() throws Exception {
		System.out.println("Navigating to about screen");
		driver.findElement(buttonMenu()).click();
		Thread.sleep(1000);
		driver.findElement(LinkAboutOnMenu()).click();
	}

	public void navigateToTroubleshootingScreen() throws Exception {
		System.out.println("Navigating to Troubleshooting screen");
		driver.findElement(buttonMenu()).click();
		Thread.sleep(1000);
		driver.findElement(LinkTroubleshootingOnMenu()).click();
	}

	public void navigateToSettingsScreen() throws Exception {
		System.out.println("Navigating to Settings screen");
		driver.findElement(buttonMenu()).click();
		Thread.sleep(1000);
		driver.findElement(LinkSettingsOnMenu()).click();
	}

	public void navigateToHowToUseScreen() throws Exception {
		System.out.println("Navigating to How_To_Use screen");
		driver.findElement(buttonMenu()).click();
		driver.findElement(LinkHowToUseOnMenu()).click();
	}

	public void navigateToSubmenu() throws Exception {
		System.out.println("Navigating to Sub-Menu screen");
		driver.findElement(buttonMenu()).click();
	}

	public String getCredentialId(Map<String, String> configuration) throws Exception {
		String credentialId = null;
		System.out.println("Getting credential ID");
		credentialId = driver.findElement(fieldCredentialId()).getText().trim();
		System.out.println("Retrieved credential ID " + credentialId);
		Assert.assertTrue(credentialId.length() == 12, "Recieved Credential Id " + credentialId + " length is not 12. ");
		Assert.assertTrue(credentialId.substring(Math.max(0, credentialId.length() - 8)).matches(".*[1-9].*"), "Recieved Credential ID " + credentialId + " does not have in required format. ");
		Assert.assertTrue(!credentialId.contains("88888888"), "Recieved Credential ID " + credentialId + " is a dummy credential ID. ");
		return credentialId;
	}

	public String getSecurityCode(Map<String, String> configuration) throws Exception {
		String securityCode = null;
		System.out.println("Getting security code");
		if (configuration.get("os").equalsIgnoreCase("android")) {
			securityCode = driver.findElement(fieldSecurityCode()).getText().trim();
		} else if (configuration.get("os").equalsIgnoreCase("ios")) {
			securityCode = driver.findElement(fieldSecurityCode()).getText().split(",")[1].trim();
		}
		System.out.println("Retrieved security code " + securityCode);
		return securityCode;
	}

	public boolean isElementPresent(WebDriver driver, By locator) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try {
			driver.findElement(locator);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return false;
		}
	}

	public HomeScreen(AppiumDriver driver, String os) {
		super(driver, os);
	}
}
