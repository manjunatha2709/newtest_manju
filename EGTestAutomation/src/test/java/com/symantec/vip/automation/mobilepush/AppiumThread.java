package com.symantec.vip.automation.mobilepush;

import org.apache.log4j.Logger;

import com.symantec.vip.automation.utils.AutomationPropertiesHelper;

public class AppiumThread implements Runnable {
	Logger logger = Logger.getLogger("VIP_EG_AUTOMATION");
	AppiumTests atsts = new AppiumTests();
	String actionOnPushNotification;
	String deviceNumber;
	static AutomationPropertiesHelper tcph = new AutomationPropertiesHelper();

	@Override
	public void run() {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Invoking Appium Thread to act on push notification");
		String os = tcph.GetPropertiesValueByKey("mobile.os");
		atsts.actOnAppium(deviceNumber, actionOnPushNotification, os);
	}

	public void actOnAppium(String deviceNo, String pushAction) {
		this.actionOnPushNotification = pushAction;
		this.deviceNumber = deviceNo;
	}
}