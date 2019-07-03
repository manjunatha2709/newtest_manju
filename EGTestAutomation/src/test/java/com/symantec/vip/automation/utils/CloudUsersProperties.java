package com.symantec.vip.automation.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class CloudUsersProperties {
	private Properties properties = new Properties();
	private static CloudUsersProperties instance = null;
	private CloudUsersProperties() {

		String workingDir = System.getProperty("user.dir");
		String path = workingDir+"//cloud_users.properties";
		
		try {
			FileInputStream fiStream = new FileInputStream(path);
			InputStreamReader isReader = new InputStreamReader(fiStream, "ISO-8859-1");
			BufferedReader bReader = new BufferedReader(isReader);
			properties.load(bReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static CloudUsersProperties getInstance() {
		if (instance==null) {
			instance = new CloudUsersProperties();
		}
		return instance;
	}
	
	Properties GetCloudUsersProperties() {
		return properties;
		
	}

}
