package com.symantec.vip.automation.utils;import java.io.File;import java.io.FileInputStream;import java.io.IOException;import java.io.InputStream;import java.io.StringReader;import java.nio.file.Files;import java.nio.file.Paths;import java.util.ArrayList;import java.util.HashMap;import java.util.Iterator;import java.util.List;import java.util.Map;import java.util.Map.Entry;import java.util.Properties;import org.apache.log4j.Logger;import org.codehaus.jackson.map.ObjectMapper;import org.codehaus.jackson.type.TypeReference;import com.google.gson.Gson;import com.google.gson.stream.JsonReader;import com.symantec.vip.automation.eg.radius.Application;import com.symantec.vip.automation.eg.radius.ApplicationTemplate;import com.symantec.vip.automation.eg.radius.Vendor;public class DataReader {	Logger logger = Logger.getLogger("VIP_EG_AUTOMATION");	String readFile(String path) throws IOException {		{			byte[] encoded = Files.readAllBytes(Paths.get(path));			return new String(encoded, java.nio.charset.StandardCharsets.UTF_8);		}	}	public Object[][] getHashMapFromJsonFile(String jsonFileName) throws Exception {		Object[][] tabArray = null;		Map<String, String> map = null;		Map<String, String> map1 = null;		String[] splitted = null;		String jsonContent = null;		String json = null;		JsonReader reader = null;		String workingDir = System.getProperty("user.dir");		String path = workingDir + "/src/test/resources/testdata/" + jsonFileName;		jsonContent = readFile(path);		splitted = jsonContent.split("},");		tabArray = new Object[splitted.length][1];		Gson gson = new Gson();		for (int i = 0; i < splitted.length; i++) {			map = new HashMap<String, String>();			map1 = new HashMap<String, String>();			if (i == 0) {				splitted[i] = splitted[0].substring(1);			}			if (i == splitted.length - 1) {				splitted[i] = splitted[i].substring(0, splitted[i].length() - 2);			}			json = splitted[i].trim() + "}";			// System.out.println("splitted libs are "+string);			reader = new JsonReader(new StringReader(json));			reader.setLenient(true);			map = gson.fromJson(reader, Map.class);			// map = mapper.readValue(string, new			// TypeReference<HashMap<String,String>>(){});			Iterator it = map.entrySet().iterator();			while (it.hasNext()) {				Map.Entry pairs = (Map.Entry) it.next();				map1.put(pairs.getKey().toString().trim().toLowerCase(), pairs.getValue().toString().trim());				if (pairs.getValue().toString().equalsIgnoreCase("")) {					map1.put(pairs.getKey().toString().trim().toLowerCase(), null);				}				// if				// (pairs.getKey().toString().equalsIgnoreCase("application_template"))				// {				// String[] content =				// prop.getProperty(pairs.getKey().toString().toLowerCase()).split(".");				// map1.put("vendor", content[0]);				// map1.put("application_name", content[1]);				// map1.put("authentication_type", content[2]);				// }				it.remove(); // avoids a ConcurrentModificationException			}			tabArray[i][0] = map1;			// logger.info("Thread-" + Thread.currentThread().getId() + ": " +			// map1);		}		return tabArray;	}	public Object[][] getHashMapFromMultipleJsonFile(ArrayList<String> jsonFileList) throws Exception {		Object[][] tabArray = null;		Map<String, String> map = null;		Map<String, String> map1 = null;		String[] splitted = null;		String jsonContent = null;		String json = null;		JsonReader reader = null;		String workingDir = System.getProperty("user.dir");		int jsonParamLength = 0;		String path;		Properties prop = new Properties();		InputStream input;		int itCount = 0;		for (int n = 0; n < jsonFileList.size(); n++) {			path = workingDir + "/src/test/resources/testdata/" + jsonFileList.get(n);			jsonContent = readFile(path);			splitted = jsonContent.split("},");			if (splitted.length > jsonParamLength) {				jsonParamLength = splitted.length;			}		}		tabArray = new Object[jsonParamLength][1];		Gson gson = new Gson();		ArrayList<Map<String, String>> hArrayList1 = new ArrayList<Map<String, String>>();		ArrayList<Map<String, String>> hArrayList = null;		for (int i = 0; i < jsonParamLength; i++) {			hArrayList1 = hArrayList;			hArrayList = new ArrayList<Map<String, String>>();			Map<String, String> map3 = new HashMap<String, String>();			for (int k = 0; k < jsonFileList.size(); k++) {				map1 = new HashMap<String, String>();				path = workingDir + "/src/test/resources/testdata/" + jsonFileList.get(k);				jsonContent = readFile(path);				splitted = jsonContent.split("},");				if (i == 0) {					splitted[i] = splitted[0].substring(1);				}				if (splitted.length > i) {					map = new HashMap<String, String>();					map1 = new HashMap<String, String>();					if (i == splitted.length - 1) {						splitted[i] = splitted[i].substring(0, splitted[i].length() - 2);					}					json = splitted[i].trim() + "}";					reader = new JsonReader(new StringReader(json));					reader.setLenient(true);					map = gson.fromJson(reader, Map.class);					Iterator<Entry<String, String>> it = map.entrySet().iterator();					while (it.hasNext()) {						Map.Entry<String, String> pairs = it.next();						map1.put(pairs.getKey().toString().trim().toLowerCase(), pairs.getValue().toString().trim());						if (pairs.getValue().toString().equalsIgnoreCase("")) {							map1.put(pairs.getKey().toString().trim().toLowerCase(), null);						}						if (pairs.getKey().toString().equalsIgnoreCase("application_template")) {							if (itCount == 0) {								input = new FileInputStream("/src/test/resources/application_template.properties");								prop.load(input);								itCount++;							}							String[] content = prop.getProperty(pairs.getKey().toString().toLowerCase()).split(".");							map1.put("vendor", content[0]);							map1.put("application_name", content[1]);							map1.put("authentication_type", content[2]);						}						it.remove();					}					hArrayList.add(k, map1);				} else {					map1 = hArrayList1.get(k);					hArrayList.add(k, map1);				}				map3.putAll(map1);			}			tabArray[i][0] = map3;			// logger.info("Thread-" + Thread.currentThread().getId() + ": " +			// map3);		}		return tabArray;	}	public Object[][] getTestDataFromApplicationTemplates(String jsonFileName) throws Exception {		Map<String, String> map1 = null;		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Getting Test data for Application Aware Validation Server");		boolean readCommonJson = false;		if (jsonFileName != null) {			readCommonJson = true;		}		int portNo = 0;		String workingDir = System.getProperty("user.dir");		String jsonContent = null;		if (readCommonJson) {			String path = workingDir + "/src/test/resources/testdata/" + jsonFileName;			jsonContent = readFile(path).trim();			if (String.valueOf(jsonContent.charAt(0)).contains("[")) {				jsonContent = jsonContent.substring(1);				jsonContent = jsonContent.substring(0, jsonContent.length() - 1);			}		}		ObjectMapper objMapper = new ObjectMapper();		ApplicationTemplate appTemplate = objMapper.readValue(new File(workingDir + "/src/test/resources/application_template.json"), ApplicationTemplate.class);		Vendor[] myObjects = appTemplate.getVendors();		Gson gson = new Gson();		int arrayLength = 0;		for (int m = 0; m < myObjects.length; m++) {			Vendor vendor = myObjects[m];			List<Application> apps = vendor.getApplications();			for (int n = 0; n < apps.size(); n++) {				Application app = apps.get(n);				List<String> modes = app.getModes();				for (int o = 0; o < modes.size(); o++) {					arrayLength = arrayLength + 1;				}			}		}		// logger.info("3");		Object[][] tabArray = new Object[arrayLength][1];		int item = 0;		for (int i = 0; i < myObjects.length; i++) {			Vendor vendor = myObjects[i];			List<Application> apps = vendor.getApplications();			for (int j = 0; j < apps.size(); j++) {				Application app = apps.get(j);				List<String> modes = app.getModes();				for (int k = 0; k < modes.size(); k++) {					map1 = new HashMap<String, String>();					String mode = modes.get(k);					map1.put("vendor", vendor.getVendorName().trim());					map1.put("application_name", app.getApplicationName().trim());					map1.put("challenge_supported", String.valueOf(app.isChallengeSupported()));					map1.put("delegation_supported", String.valueOf(app.isDelegation()));					map1.put("radius_ldap_supported", String.valueOf(app.isLdapToRadiusMapping()));					map1.put("pin_reset_supported", String.valueOf(app.isPinReset()));					map1.put("template_version", String.valueOf(app.get_version()));					map1.put("template_id", app.get_id());					if (mode.trim().toLowerCase().contains("ldap")) {						map1.put("mode_keyword", "UserID - LDAP Password - Security Code");						map1.put("mode", "ulo");					} else if (mode.trim().toLowerCase().contains("pin")) {						map1.put("mode_keyword", "UserID - Access PIN - Security Code");						map1.put("radius_ldap_supported", "false");						map1.put("mode", "upo");					} else {						map1.put("mode_keyword", "UserID - Security Code");						map1.put("radius_ldap_supported", "false");						map1.put("mode", "uo");					}					if (readCommonJson) {						String appNametrimmed = app.getApplicationName().replaceAll("\\s+", "");						String appTemplateAccronym = vendor.getVendorName() + "_" + app.getApplicationName() + "_" + mode.trim();						String app1stChar = vendor.getVendorName().toUpperCase().substring(0, Math.min(vendor.getVendorName().length(), 4));						String appName = appNametrimmed.replaceAll("\\s+", "").substring(0, Math.min(appNametrimmed.length(), 10));						String[] modeSplitted = mode.trim().replaceAll("\\s+", "").split("-");						String serverName = app1stChar.trim().replaceAll("\\s+", "") + "_" + appName.trim() + "_" + modeSplitted[0].charAt(0) + modeSplitted[1].charAt(0);						portNo = portNo + 1;						JsonReader reader = new JsonReader(new StringReader(jsonContent));						reader.setLenient(true);						Map<String, String> map = gson.fromJson(reader, Map.class);						Iterator<Entry<String, String>> it = map.entrySet().iterator();						while (it.hasNext()) {							Map.Entry<String, String> pairs = it.next();							String key = pairs.getKey().toString().trim().toLowerCase();							String value = pairs.getValue().toString().trim();							map1.put(key, value);							if (key.equalsIgnoreCase("")) {								map1.put(key, null);							}							if (key.equalsIgnoreCase("test_scenario")) {								map1.put(key, value + appTemplateAccronym);							}							if (key.equalsIgnoreCase("server_port")) {								if (item == 0) {									portNo = Integer.valueOf(value);								}								map1.put(key, String.valueOf(portNo));							}							if (key.equalsIgnoreCase("validation_server_name")) {								map1.put(key, value + serverName);							}							it.remove(); // avoids a							// ConcurrentModificationException						}					}					// logger.info("*******Adding Map " + map1);					tabArray[item][0] = map1;					item++;				}			}		}		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "$$$$$$$$$$$$$$$$$$$$$$$$$$$ Found " + item + " entries from application template $$$$$$$$$$$$$$$$$$$$$$$$$$$");		return tabArray;	}	public Object[][] getFilteredDataFromApplicationTemplates(String jsonFileName, HashMap<String, Boolean> conditions) throws Exception {		List<Map<String, String>> intermediate = new ArrayList<Map<String, String>>();		Object[][] testData = getTestDataFromApplicationTemplates(jsonFileName);		Object[][] out;		int item = 0;		for (int i = 0; i < testData.length; i++) {			boolean add = true;			HashMap<String, String> map = null;			map = (HashMap<String, String>) testData[i][0];			Iterator<Entry<String, Boolean>> it = null;			it = conditions.entrySet().iterator();			while (it.hasNext()) {				Map.Entry<String, Boolean> pairs = it.next();				String key = pairs.getKey().toString().trim().toLowerCase();				boolean value = pairs.getValue();				if (map.get(key) != null) {					if (Boolean.valueOf(map.get(key)) != value) {						add = false;						break;					}				}				// it.remove(); // avoids a ConcurrentModificationException			}			if (add) {				intermediate.add(item, map);				item++;			}		}		logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$ Found " + intermediate.size() + " filtered entries from application template $$$$$$$$$$$$$$$$$$$$$$$$$$$");		out = new Object[intermediate.size()][1];		for (int n = 0; n < intermediate.size(); n++) {			// logger.info("Adding map index " + (n + 1) + " to array. MAP: " +			// intermediate.get(n));			out[n][0] = intermediate.get(n);		}		// logger.info("Filtered Map is " + out);		return out;	}	public Object[][] getFilteredDataFromApplicationTemplates1(String jsonFileName, HashMap<String, Object> conditions) throws Exception {		List<Map<String, String>> intermediate = new ArrayList<Map<String, String>>();		Object[][] testData = getTestDataFromApplicationTemplates(jsonFileName);		Object[][] out;		int item = 0;		for (int i = 0; i < testData.length; i++) {			boolean add = true;			HashMap<String, String> map = null;			map = (HashMap<String, String>) testData[i][0];			Iterator<Entry<String, Object>> it = null;			it = conditions.entrySet().iterator();			while (it.hasNext()) {				Map.Entry<String, Object> pairs = it.next();				String key = pairs.getKey().toString().trim().toLowerCase();				Object value = pairs.getValue();				if (map.get(key) != null) {					if (!String.valueOf(map.get(key)).equalsIgnoreCase(String.valueOf(value))) {						add = false;						break;					}				}				// it.remove(); // avoids a ConcurrentModificationException			}			if (add) {				intermediate.add(item, map);				item++;			}		}		logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$ Found " + intermediate.size() + " filtered entries from application template $$$$$$$$$$$$$$$$$$$$$$$$$$$");		out = new Object[intermediate.size()][1];		for (int n = 0; n < intermediate.size(); n++) {			// logger.info("Adding map index " + (n + 1) + " to array. MAP: " +			// intermediate.get(n));			out[n][0] = intermediate.get(n);		}		return out;	}}