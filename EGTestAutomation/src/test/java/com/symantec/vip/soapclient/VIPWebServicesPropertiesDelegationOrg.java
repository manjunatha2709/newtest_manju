package com.symantec.vip.soapclient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class VIPWebServicesPropertiesDelegationOrg {
	private Properties properties = new Properties();
	public static Logger logger = Logger.getLogger("VIP_EG_AUTOMATION");
	private static VIPWebServicesPropertiesDelegationOrg instance = null;
	private VIPWebServicesPropertiesDelegationOrg(String env) {

		String workingDir = System.getProperty("user.dir");
		String path = workingDir+"//"+env+"_vswebserviceclient_del_org.conf";
		//logger.info("ws config Path is "+path);


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

	public static VIPWebServicesPropertiesDelegationOrg getInstance(String env) {
		if (instance==null) {
			instance = new VIPWebServicesPropertiesDelegationOrg(env);
		}
		return instance;
	}
	
	public Properties VIPWebServicesPropertiesDelegationOrg() {
		return properties;
		
	}

}
