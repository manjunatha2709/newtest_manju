package com.symantec.vip.reporting;import java.util.HashMap;import java.util.Map;import java.util.Properties;import org.apache.log4j.Logger;import com.symantec.vip.automation.restapi.RestClient;import com.symantec.vip.automation.utils.AutomationProperties;public class CodeCoverageReportGeneration {	static RestClient ent = new RestClient();	static Logger logger = Logger.getLogger("VIP_EG_AUTOMATION");	static Properties properties = AutomationProperties.getInstance().GetAutomationProperties();	public void GenerateCodeCoveageReportOnEGServer() {		Map<String, String> testParamForThisTest = new HashMap<String, String>();		logger.info(("Generating Code coverage report on server"));		String codeCoverageServer = properties.getProperty("codecoverage.java.java_cc_host").trim();		testParamForThisTest.put("validation_server_host", codeCoverageServer);		ent.PerformRemoteAction("GenerateJavaCodeCoverageReport", testParamForThisTest);	}}