package com.symantec.vip.automation.eg.testbed;

import java.util.Map;

import org.apache.log4j.Logger;

import com.symantec.vip.automation.restapi.RestClient;

public class ProductInstallation {
	RestClient rClient = new RestClient();
	Logger logger = Logger.getLogger("VIP_EG_AUTOMATION");

	public boolean InstallBuild(Map<String, String> config) {
		Map<String, String> configStatus = rClient.PerformRemoteAction("CheckConfigurationStatus", config);
	//	logger.info("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"  );
		
		logger.info(configStatus);

		//String buildToBeInstalled = config.get("build_no").toString();
		String buildToBeInstalled = "9.8.5.66";
		//String buildToBeInstalled = "9.9.0.53";
		String server = config.get("eg_server_host").toString();
		logger.info("Build to be installed on server " + server + " is " + buildToBeInstalled);
		boolean isInstalled = false;
		try {
		//String currentBuild = configStatus.get("build_no");
		String currentBuild = "9.8.5.66";
			//String currentBuild = "9.9.0.53";
		logger.info("Current build is " + currentBuild);
			if (currentBuild.equalsIgnoreCase(buildToBeInstalled)) {
				isInstalled = true;
				logger.info("Build " + currentBuild + " has already been installed on server " + server);
			} else if (!(currentBuild.equalsIgnoreCase(buildToBeInstalled))) {
				logger.info("Invoking build installation REST API call ");
				rClient.PerformRemoteAction("InstallEG", config);
				configStatus = rClient.PerformRemoteAction("CheckConfigurationStatus", config);
				// String installedBuild =
				// (ent.GetCurrentConfiguration(server)).get("build_no");
				String installedBuild = configStatus.get("build_no");
				if (installedBuild.equalsIgnoreCase(buildToBeInstalled)) {
					logger.info("Build " + installedBuild + " installed successfully");
					isInstalled = true;
				} else {
					logger.error("Build " + buildToBeInstalled + " installation failed on server " + server);
					isInstalled = false;
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Could not check the build readiness on server " + server);
			isInstalled = false;
		}
		return isInstalled;
	}
}


