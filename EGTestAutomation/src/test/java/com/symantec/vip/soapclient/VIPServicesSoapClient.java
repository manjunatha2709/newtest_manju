package com.symantec.vip.soapclient;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.symantec.vip.automation.TestBase;
import com.verisign.sharedtoken.Status;
import com.verisign.webserviceclient.WebServiceClient;
import com.verisign.webserviceclient.WebServiceClientException;

public class VIPServicesSoapClient {
	public static Logger logger = LoggerFactory.getLogger(TestBase.class);

	// public static boolean SetUser(String userName, String pin, String
	// tempOTP, String credentialId, String otp ) {
	// boolean result = false;
	// WebServiceClient wClient;
	// Status status;
	// Properties properties =
	// VIPWebServicesProperties.getInstance(env).VIPWebServicesProperties();
	// try {
	// wClient = new WebServiceClient(properties);
	// //if (wClient.getuserinfo(userName).getStatusCode()==0) {
	// // wClient.deleteUser(userName);
	// //}
	// //else {
	// status =wClient.createUser(userName, pin);
	// if (status.getStatusCode() == 0) {
	// status = wClient.setTemporaryOtp(userName, tempOTP, null, false);
	// wClient.updateUser(userName, userName, pin, pin, "enabled");
	// //status =wClient.addCredential(userName, credentialId, null);
	// if (status != null) {
	// System.out.println("StatusCode: 0x"
	// + Integer.toHexString(status.getStatusCode())
	// + ", StatusMessage: " + status.getStatusMessage()
	// + ", DetailCode: 0x"
	// + Integer.toHexString(status.getStatusCode())
	// + ", DetailMessage: " + status.getDetailMessage());
	// } else {
	// System.out.println("Status is null");
	// }
	// //System.out.println(wClient.authenticate(0, userName,tempOTP));
	// if (status.getStatusCode() == 0) {
	// return true;
	// }
	// else {
	// return false;
	// }
	// }
	// else{
	// return false;
	// }
	//
	// //}
	//
	// } catch (WebServiceClientException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// System.exit(-1);
	// }
	// //Status status = wClient.getuserinfo("bobby");
	//
	//
	// return result;
	//
	// }
	public boolean UpdateUser(String userName, String newUserName, String oldPin, String newPin, String newStateOfTheUser, boolean forcePinReset, String env) {
		boolean result = false;
		WebServiceClient wClient;
		Status status = null;
		Properties properties = VIPWebServicesProperties.getInstance(env).VIPWebServicesProperties();
		try {
			wClient = new WebServiceClient(properties);
			logger.info("Invoking update user in VIP cloud through WS API");
			status = wClient.updateUser(userName, newUserName, oldPin, newPin, newStateOfTheUser, forcePinReset);
			// status =wClient.addCredential(userName, credentialId, null);
			if (status != null) {
				logger.info("StatusCode: 0x" + Integer.toHexString(status.getStatusCode()) + ", StatusMessage: " + status.getStatusMessage() + ", DetailCode: 0x"
					+ Integer.toHexString(status.getStatusCode()) + ", DetailMessage: " + status.getDetailMessage());
			} else {
				logger.info("Status is null");
			}
			// System.out.println(wClient.authenticate(0, userName,tempOTP));
			if (status.getStatusCode() == 0) {
				logger.info("Successfully updated the user");
				return true;
			} else {
				logger.error("Failed to update the user");
				return false;
			}
			// }
		} catch (WebServiceClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		// Status status = wClient.getuserinfo("bobby");
		return result;
	}

	public static boolean generateTempOTP(String userName, String tempOTP, String env) {
		boolean result = false;
		WebServiceClient wClient;
		Status status = null;
		Properties properties = VIPWebServicesProperties.getInstance(env).VIPWebServicesProperties();
		try {
			wClient = new WebServiceClient(properties);
			if (wClient.getuserinfo(userName).getStatusCode() == 0) {
				logger.info("Setting temp OTP:" + tempOTP + " for the user " + userName);
				status = wClient.setTemporaryOtp(userName, tempOTP, null, false);
			} else {
				logger.info("User " + userName + " does not exist in VIP " + env + " environment. So creating a user");
				wClient.createUser(userName, "123456");
				status = wClient.setTemporaryOtp(userName, tempOTP, null, false);
			}
			if (status != null) {
				if (status.getStatusCode() == 0) {
					logger.info("Generate Temp OTP succeeded for the user " + userName);
					return true;
				} else {
					logger.error("Generate Temp OTP failed for the user " + userName);
					return false;
				}
			} else {
				logger.error("Generate Temp OTP failed for the user " + userName);
				return false;
			}
		} catch (WebServiceClientException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		return result;
	}

	public static boolean generateTempOTPBulk(String userPrefix, String tempOTP, String env) throws ParseException {
		final int count = 50000;
		boolean result = false;
		WebServiceClient wClient;
		Status status = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "28-04-2016 10:20:56";
		Date date = sdf.parse(dateInString);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Properties properties = VIPWebServicesProperties.getInstance(env).VIPWebServicesProperties();
		try {
			wClient = new WebServiceClient(properties);
			for (int j = 23500; j < count; j++) {
				String userName = userPrefix + String.valueOf(j);
				if (wClient.getuserinfo(userName).getStatusCode() == 0) {
					logger.info("Setting temp OTP:" + tempOTP + " for the user " + userName);
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
						logger.error("Generate Temp OTP failed for the user " + userName);
					}
				} else {
					logger.error("Generate Temp OTP failed for the user " + userName);
				}
			}
		} catch (WebServiceClientException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		return result;
	}

	public static boolean GenerateTempOTPDelegationOrg(String userName, String tempOTP, String env) {
		boolean result = false;
		WebServiceClient wClient;
		Status status = null;
		Properties properties = VIPWebServicesPropertiesDelegationOrg.getInstance(env).VIPWebServicesPropertiesDelegationOrg();
		try {
			wClient = new WebServiceClient(properties);
			if (wClient.getuserinfo(userName).getStatusCode() == 0) {
				logger.info("Setting temp OTP:" + tempOTP + " for the user " + userName);
				status = wClient.setTemporaryOtp(userName, tempOTP, null, false);
				// if (status != null) {
				// System.out.println("StatusCode: 0x"
				// + Integer.toHexString(status.getStatusCode())
				// + ", StatusMessage: " + status.getStatusMessage()
				// + ", DetailCode: 0x"
				// + Integer.toHexString(status.getStatusCode())
				// + ", DetailMessage: " + status.getDetailMessage());
				// } else {
				// System.out.println("Status is null");
				// }
			}
			if (status != null) {
				if (status.getStatusCode() == 0) {
					logger.info("Generate Temp OTP succeeded for the user " + userName);
					return true;
				} else {
					logger.error("Generate Temp OTP failed for the user " + userName);
					return false;
				}
			} else {
				logger.error("Generate Temp OTP failed for the user " + userName);
				return false;
			}
		} catch (WebServiceClientException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		return result;
	}

	public static synchronized boolean UnlockCredential(Map<String, String> config, boolean delegationOrg, String credentialID) {
		String vipCertJKSlocation = config.get("vip_jks_certificate_path");
		String soapURL = "https://" + config.get("vip_service_token_url");
		String vipCertPath = vipCertJKSlocation + "\\" + config.get("selected_env") + "_vip_cert.jks";
		String vipCertPathDelegationOrg = vipCertJKSlocation + "\\" + "qa_vip_cert_delegation.jks";
		String vip_certficate_password = config.get("vip_certificate_password");
		String result = null;
		try {
			if (delegationOrg) {
				vipCertPath = vipCertPathDelegationOrg;
				logger.info("Invoking to Unlock Credential for delegaiton org");
			}
			logger.info("Invoking to Unlock Credential ws API on " + config.get("selected_env") + " org");
			Credential cred = new Credential(soapURL, vipCertPath, vip_certficate_password);
			result = cred.UnlockToken(credentialID);
			logger.info("Result was: " + result);
			if (result.toLowerCase().contains("success")) {
				logger.info("Successfully unlocked the credential");
				return true;
			} else {
				logger.error("Failed to unlock the credential");
				logger.error(result);
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("An exception occured. " + Stack2string(e));
			return false;
		}
	}

	public static synchronized String Stack2string(Throwable e) {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return "------\r\n" + sw.toString() + "------\r\n";
		} catch (Exception e2) {
			return "bad stack2string";
		}
	}
}
