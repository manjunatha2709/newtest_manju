package com.symantec.vip.automation.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.jcraft.jsch.JSchException;
import com.symantec.vip.automation.restapi.RestClient;

public class Helper {
	Logger logger = Logger.getLogger("VIP_EG_AUTOMATION");
	static Properties properties = AutomationProperties.getInstance().GetAutomationProperties();

	public String getHostName(String operatingSystem, String testType) {
		String host = null;
		Properties properties = AutomationProperties.getInstance().GetAutomationProperties();
		if (operatingSystem != null && testType != null) {
			host = properties.getProperty("hostname." + testType + "." + operatingSystem).trim();
			logger.info("Hostname where test to be executed is " + host);
		} else {
			// TODO
		}
		return host;
	}

	public String[] splitTestStepAttribute(String testattributename) {
		String[] splittedattributes = testattributename.split(":");
		return splittedattributes;
	}

	public String getBuildNumber() {
		String buildNumber = null;
		RestClient resClient = new RestClient();
		String linuxBuild = null;
		String windowsBuild = null;
		Map<String, String> getLatestBuildActionDetails = new HashMap<String, String>();
		boolean wait;
		try {
			do {
				getLatestBuildActionDetails.put("eg_server_host", properties.getProperty("tomcat.unique.action.server_ip"));
				getLatestBuildActionDetails.put("build_share", (properties.getProperty("common.prop.eg.build_share").toString() + "/windows").trim());
				windowsBuild = resClient.PerformRemoteAction("GetLatestBuildNumber", getLatestBuildActionDetails).get("available_build");
				getLatestBuildActionDetails.put("build_share", (properties.getProperty("common.prop.eg.build_share").toString() + "/Linux").trim());
				linuxBuild = resClient.PerformRemoteAction("GetLatestBuildNumber", getLatestBuildActionDetails).get("available_build");
				if (windowsBuild.equalsIgnoreCase(linuxBuild)) {
					logger.info("Returning build to be used as " + windowsBuild);
					return buildNumber = windowsBuild;
				} else {
					logger.info("Sleeping for 5 minutes as common build is not availabe in the build share");
					wait = true;
					Thread.sleep(300000);
				}
			} while (wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return buildNumber;
	}

	public String getProperty(String filePath, String propertyName) {
		// logger.info("["+(Thread.currentThread().getStackTrace()[1].getMethodName())+"]"+"PAth is:"+path);
		FileInputStream stream = null;
		String value = null;
		try {
			Properties properties = new Properties();
			stream = new FileInputStream(filePath);
			properties.load(stream);
			value = properties.getProperty(propertyName);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			closeStream(stream);
		}
		return value;
	}

	
	public String getBuildNumberFromRemote() throws Exception {
		JCraft jc = new JCraft();
		Properties ps = new Properties();
		//InputStream is = jc.getFile("10.212.127.197", "build", "1Password", 
			//	"BuildList.txt");
		InputStream is = jc.getFile("10.7.147.59", "build", "1Password", 
				"BuildList.txt");
		if (is!=null) {
			ps.load(is);
		//	logger.info(ps.);
		}
		System.out.println("Property name is "+ps.getProperty("LatestBuild"));
		return ps.getProperty("LatestBuild");
	}
	
	private static void closeStream(InputStream iStream) {
		try {
			if (iStream != null) {
				iStream.close();
			}
		} catch (IOException ioEx) {
		}
	}

	public List<String> GetFilenames(String filepath) {
		List<String> filename = null;
		File fs = new File(filepath);
		File[] listOfFiles = fs.listFiles();
		if (listOfFiles != null) {
			filename = new ArrayList<String>();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					filename.add(listOfFiles[i].getName());
				}
			}
		}
		return filename;
	}
}
