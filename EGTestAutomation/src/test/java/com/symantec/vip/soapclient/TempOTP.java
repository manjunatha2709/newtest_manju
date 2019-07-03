package com.symantec.vip.soapclient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.symantec.vip.automation.TestBase;
import com.verisign.sharedtoken.Status;
import com.verisign.webserviceclient.WebServiceClient;
import com.verisign.webserviceclient.WebServiceClientException;

public class TempOTP {
	public static Logger logger = LoggerFactory.getLogger(TestBase.class);

	public void generateTempOTP(String userName, String tempOTP, String env, String dateInString) throws ParseException {
		WebServiceClient wClient;
		Status status = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Date date = sdf.parse(dateInString);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Properties properties = VIPWebServicesProperties.getInstance(env).VIPWebServicesProperties();
		try {
			wClient = new WebServiceClient(properties);
			if (wClient.getuserinfo(userName).getStatusCode() == 0) {
				// logger.info("Setting temp OTP:" + tempOTP + " for the user "
				// + userName);
				status = wClient.setTemporaryOtp(userName, tempOTP, calendar, false);
			} else {
				logger.info("User " + userName + " does not exist in VIP " + env + " environment. So creating a user");
				wClient.createUser(userName, "123456");
				status = wClient.setTemporaryOtp(userName, tempOTP, calendar, false);
			}
			if (status != null) {
				if (status.getStatusCode() == 0) {
					logger.info("Generate Temp OTP succeeded for the user " + userName);
				} else {
					logger.error("*****Generate Temp OTP failed for the user*****" + userName);
				}
			} else {
				logger.error("Generate Temp OTP failed for the user " + userName);
			}
		} catch (WebServiceClientException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
