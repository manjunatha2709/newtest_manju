package com.symantec.vip.automation.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

public class CloudUsersPropertiesHelper {
	Properties properties = CloudUsersProperties.getInstance().GetCloudUsersProperties();
	
	Map<String, String> map = new HashMap<String, String>();
	public Map<String, String> GetConfiguration() {
		//Getting all the properties from properties file....
		Enumeration<?> keys = properties.propertyNames();
		keys = properties.propertyNames();
		while(keys.hasMoreElements()){
			String key = (String)keys.nextElement().toString().trim();
			map.put(key.toLowerCase(), properties.getProperty(key));
		}
		return map;
	}
	
	public Map<String, String> GetCommonPropertiesAndLastStringAsKey(String keyString) {
		//System.out.println("Key String is "+keyString);
		Map<String,String> newMap = new HashMap<String, String>();
		Map<String,String> out = new HashMap<String, String>();
		map = this.GetConfiguration();
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> pairs = (Map.Entry<String, String>)it.next();
			if ((pairs.getKey().toString()).contains(keyString)) {
				newMap.put(pairs.getKey().toString().trim(), pairs.getValue().toString().trim());
				//System.out.println(pairs.getKey() + " = " + pairs.getValue());
			}

			for (Map.Entry<String, String> entry : newMap.entrySet()) {
				int len = entry.getKey().toString().split("\\.").length;
				String key = entry.getKey().toString().split("\\.")[len-1].trim();
				String value = entry.getValue().toString().trim();
				out.put(key, value);
			}
			//it.remove(); // avoids a ConcurrentModificationException
		}

		return out;

	}

}
