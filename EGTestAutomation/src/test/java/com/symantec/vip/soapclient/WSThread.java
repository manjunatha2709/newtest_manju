package com.symantec.vip.soapclient;

import java.text.ParseException;
import org.apache.log4j.Logger;

public class WSThread implements Runnable {
	Logger logger = Logger.getLogger("VIP_EG_AUTOMATION");
	String userName;
	String tempOTP;
	String env;
	String date;
	TempOTP tmpOTP = new TempOTP();

	@Override
	public void run() {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Invoking WS thread to generate temp OTP for " + userName);
		try {
			tmpOTP.generateTempOTP(userName, tempOTP, env, date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void generateTempOTP(String userName, String tempOTP, String env, String date) {
		this.userName = userName;
		this.tempOTP = tempOTP;
		this.env = env;
		this.date = date;
	}
}