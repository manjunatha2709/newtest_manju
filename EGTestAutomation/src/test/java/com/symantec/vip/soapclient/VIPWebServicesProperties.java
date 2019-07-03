package com.symantec.vip.soapclient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class VIPWebServicesProperties {
	private Properties properties = new Properties();
	private static VIPWebServicesProperties instance = null;
	private VIPWebServicesProperties(String env) {
		String workingDir = System.getProperty("user.dir");
		String path = workingDir+"//"+env+"_vswebserviceclient.conf";


		try {
			properties.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static VIPWebServicesProperties getInstance(String env) {
		if (instance==null) {
			instance = new VIPWebServicesProperties(env);
		}
		return instance;
	}
	
	public Properties VIPWebServicesProperties() {
		return properties;
	}

}
