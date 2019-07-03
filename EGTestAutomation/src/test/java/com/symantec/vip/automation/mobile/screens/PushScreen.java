package com.symantec.vip.automation.mobile.screens;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class PushScreen extends Page {
	/* close button that closes the wrapper after a fresh install */
	public static By windowSignInRequestAndroid = By.id("id_push_approve_button");
	public static By windowSignInRequestIos = By.xpath("//*[@name='Sign In Request']");
	// public static By windowSignInRequestIos = By.name("Sign In Request");
	public static By buttonApproveAndroid = By.id("id_push_approve_button");
	public static By buttonApproveIos = By.xpath("//*[@name='Approve']");
	// public static By buttonApproveIos = By.name("Approve");
	public static By buttonDenyAndroid = By.id("id_push_deny_button");
	public static By buttonDenyIos = By.xpath("//*[@name='Deny']");
	// public static By buttonDenyIos = By.name("Deny");
	public static By textPushUrlIos = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[2]");
	public static By textPushUrlAndroid = By.id("id_push_url");
	public static By textPushTitleIos = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]");
	public static By textPushTitleAndroid = By.id("id_push_title");
	public static By textPushMessageIos = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[2]");
	public static By textPushMessageAndroid = By.id("id_push_displayMsg");

	/* Settings Button */
	public By buttonApprove() throws Exception {
		return getLocator(PushScreen.class, "buttonApprove" + os);
	}

	public By buttonDeny() throws Exception {
		return getLocator(PushScreen.class, "buttonDeny" + os);
	}

	public By textPushURL() throws Exception {
		return getLocator(PushScreen.class, "textPushUrl" + os);
	}

	public By textPushTitle() throws Exception {
		return getLocator(PushScreen.class, "textPushTitle" + os);
	}

	public By textPushMessage() throws Exception {
		return getLocator(PushScreen.class, "textPushMessage" + os);
	}

	public void ActOnPushNotification(Map<String, String> configuration) throws Exception {
		try {
			WebDriverWait wdw = new WebDriverWait(driver, 15);
			if (configuration.get("push_action").equalsIgnoreCase("approve")) {
				System.out.println("Trying to locate approve button");
				wdw.until(ExpectedConditions.presenceOfElementLocated(buttonApprove()));
				System.out.println("Clicking on approve button");
				driver.findElement(buttonApprove()).click();
			} else if (configuration.get("push_action").equalsIgnoreCase("deny")) {
				System.out.println("Trying to locate deny button");
				wdw.until(ExpectedConditions.presenceOfElementLocated(buttonDeny()));
				System.out.println("Clicking on deny button");
				driver.findElement(buttonDeny()).click();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			Thread.sleep(2000);
			driver.quit();
		}
	}

	public void verifyPushNotificationDetails(Map<String, String> configuration) throws Exception {
		WebDriverWait wdw = new WebDriverWait(driver, 15);
		System.out.println("Waiting to get push dialog");
		wdw.until(ExpectedConditions.presenceOfElementLocated(buttonApprove()));
		String validationType = configuration.get("push_validation_type");
		if (validationType.equalsIgnoreCase("push_url")) {
			System.out.println("Validating push URL");
			String remoteAccessTest = driver.findElement(textPushURL()).getText();
			System.out.println("Push Message Received is " + remoteAccessTest);
			Assert.assertTrue(remoteAccessTest.contains(configuration.get("remote_service_name")), "Remove Access Service Name does not match. Expected: " + configuration.get("remote_service_name")
				+ ". Actual: " + remoteAccessTest);
		} else if (validationType.equalsIgnoreCase("push_title")) {
			System.out.println("Validating push Title");
			String pushTitle = driver.findElement(textPushTitle()).getText();
			System.out.println("Push Title received is " + pushTitle);
			Assert.assertTrue(pushTitle.contains("Sign In Request"), "Push title does not match. Expected: " + "Sign In Request" + ". Actual: " + pushTitle);
		} else if (validationType.equalsIgnoreCase("push_message")) {
			System.out.println("Validating push message");
			String pushMsg = driver.findElement(textPushMessage()).getText();
			System.out.println("Push Message received is " + pushMsg);
			Assert.assertTrue(pushMsg.contains("Sign in request from: VIPEGAutomation"), "Push message does not match. Expected: " + "Sign in request from: VIPEGAutomation" + ". Actual: " + pushMsg);
		}
		if (configuration.get("push_action").equalsIgnoreCase("approve")) {
			driver.findElement(buttonApprove()).click();
		} else if (configuration.get("push_action").equalsIgnoreCase("deny")) {
			driver.findElement(buttonDeny()).click();
		}
	}

	public PushScreen(AppiumDriver webDriver, String os) {
		super(webDriver, os);
	}
}
