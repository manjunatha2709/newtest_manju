package com.symantec.vip.automation;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.symantec.vip.automation.eg.radius.RadiusTestHelper;
import com.symantec.vip.automation.eg.radius.TestBed;
import com.symantec.vip.automation.restapi.RestClient;
import com.symantec.vip.automation.utils.AutomationPropertiesHelper;
import com.symantec.vip.automation.utils.TestDriverHelper;

public class ConfigurationImportTest extends TestBase {
	public String productSourceVersion;
	public static Logger logger = TestBase.logger;
	SeleniumTestHelper sTestHelper = new SeleniumTestHelper();
	RestClient rClient = new RestClient();
	RadiusTestHelper radiusTestHelper = new RadiusTestHelper();
	TestDriverHelper tdh = new TestDriverHelper();
	AutomationPropertiesHelper aph = new AutomationPropertiesHelper();

	@BeforeSuite
	public void SetEnvironment() throws Exception {
		//tdh.setTempOTP(config);
	}

	@Parameters({ "productSourceVersion" })
	@BeforeClass
	public void setProductSourceVersion(String productSourceVersion) throws IOException {
		config.putAll(aph.GetCommonPropertiesAndLastStringAsKey("common.prop."));
		this.productSourceVersion = productSourceVersion;
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "/n############# STARTING IMPORT TEST ON " + config.get("server_context").toUpperCase() + ": SOURCE VERSION  "
			+ productSourceVersion + " #############");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting product source version as " + productSourceVersion);
		config.put("product_source_version", productSourceVersion);
	}

	@AfterClass
	public void afterImportTests() throws IOException {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "############# ENDING IMPORT TEST ON " + configuration.get("server_context").toUpperCase() + ": SOURCE VERSION  "
			+ configuration.get("product_source_version") + " #############/n");
	}

	// @BeforeMethod
	// public void ConfigConsoleBasicLogin() throws Exception {
	// sTestHelper.ConfigConsoleBasicLogin(config, driver);
	// }
	@Test
	public void AddVIPCertificate_FirstTime() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		configuration.put("selected_env", "production");
		configuration.putAll(testDriverHelper.getVIPServicesEnvironment(configuration));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		sTestHelper.AddVIPCertificate_FirstTime(configuration, driver);
	}

	// @Test(priority = 0, groups = { "baseconfig", "SanityTests",
	// "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime"
	// })
	// public void Import_Cross_Version_Configuration() throws Exception {
	// configuration.put("settings", "All");
	// configuration.put("expected_result", "true");
	// configuration.put("product_source_version", productSourceVersion);
	// sTestHelper.ImportSettings(config, driver);
	// configuration.put("selected_env", "qa");
	// configuration.putAll(testDriverHelper.getVIPServicesEnvironment(config));
	// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	// "**********Configuration for this test is**********" + config);
	// sTestHelper.AddVIPCertificate(config, driver);
	// }
	/*@Test(priority = 0, groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Import_Cross_Version_Configuration() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		configuration.put("settings", "All");
		configuration.put("expected_result", "true");
		configuration.put("product_source_version", this.productSourceVersion);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		sTestHelper.ImportSettings(configuration, driver);
		configuration.put("selected_env", "qa");
		configuration.putAll(testDriverHelper.getVIPServicesEnvironment(configuration));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ConfigConsoleBasicLogin(configuration, driver);
		configuration.put("alias_name", "qacert");
		String vip_certificate_path = configuration.get("vip_certificate_path") + "/" + configuration.get("selected_env") + "_vip_cert.p12";
		configuration.put("vip_certificate_password", "1Password");
		configuration.put("vip_certificate_path", vip_certificate_path);
		sTestHelper.AddVIPCertificate(configuration, driver);
		driver.findElement(By.linkText("Use this Key")).click();
		TestBed tBed = new TestBed();
		tBed.changeAuthURL(configuration);
	}
*/
	@Test(priority = 1, groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Import_Cross_Version_Configuration" })
	public void Start_All_Validation_Servers() throws Exception {
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		sTestHelper.StartAllValidationServers(config, driver);
	}

	@Test(priority = 1, groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Import_Cross_Version_Configuration" })
	public void Start_All_Tunnel_Servers() throws Exception {
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		sTestHelper.StartAllTunnelServers(config, driver);
	}

	@Test(priority = 1, groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Import_Cross_Version_Configuration" })
	public void Start_SSP_Service() throws Exception {
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		sTestHelper.StartSSPIDPService(driver, true);
	}

	@Test(priority = 1, groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Import_Cross_Version_Configuration" })
	public void Start_VIP_Manager_IDP_Service() throws Exception {
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		sTestHelper.StartVIPManagerIDPService(config, driver);
	}

	@Test(priority = 1, groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Import_Cross_Version_Configuration" })
	public void Start_LDAP_Sync_Service() throws Exception {
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		sTestHelper.StartLDAPSyncService(config, driver);
	}

	// @Test(dataProviderClass = DataProvider.class, dataProvider =
	// "SSPIDPLoginWithoutSSL", groups = { "SanityTests", "RegressionTests" },
	// dependsOnMethods = { "Start_SSP_Service" })
	// public void SSP_IDP_login_Different_Login_Format(HashMap<String, String>
	// configuration) throws Exception {
	// configuration.putAll(config);
	// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	// "**********Configuration for this test is**********" + configuration);
	// sTestHelper.loginToSSPwithOutSSL(configuration, driver);
	// }
	//
	// @Test(dataProviderClass = DataProvider.class, dataProvider =
	// "VIPManagerIDPLoginDifferentFormat", groups = { "baseconfig",
	// "SanityTests", "RegressionTests" }, priority = 2, dependsOnMethods = {
	// "Start_VIP_Manager_IDP_Service" })
	// public void VIP_Manager_IDP_Login_Different_Login_Format(HashMap<String,
	// String> configuration) throws Exception {
	// configuration.putAll(config);
	// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	// "**********Configuration for this test is**********" + configuration);
	// sTestHelper.loginToVIPMGRWithoutSSL(configuration, driver);
	// }
	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "postImportUO", groups = { "RegressionTests" }, dependsOnMethods = { "Start_All_Validation_Servers" })
	public void Post_Import_UO_OTP_All_Validation_Tests(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		if (tdh.isSupportedVersion(configuration)) {
			radiusTestHelper.InvokeRadiusTests(configuration);
		}
	}

	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "postImportUOPush", groups = { "RegressionTests" }, dependsOnMethods = { "Start_All_Validation_Servers" })
	public void Post_Import_UO_Push_All_Validation_Tests(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		if (tdh.isSupportedVersion(configuration)) {
			Thread.sleep(15000);
			radiusTestHelper.InvokeRadiusTests(configuration);
		}
	}

	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "postImportULO", groups = { "RegressionTests" }, dependsOnMethods = { "Start_All_Validation_Servers" })
	public void Post_Import_ULO_OTP_All_Validation_Tests(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		if (tdh.isSupportedVersion(configuration)) {
			radiusTestHelper.InvokeRadiusTests(configuration);
		}
	}

	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "postImportULOPush", groups = { "RegressionTests" }, dependsOnMethods = { "Start_All_Validation_Servers" })
	public void Post_Import_ULO_Push_All_Validation_Tests(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		if (tdh.isSupportedVersion(configuration)) {
			Thread.sleep(15000);
			radiusTestHelper.InvokeRadiusTests(configuration);
		}
	}

	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "postImportUOL", groups = { "RegressionTests" }, dependsOnMethods = { "Start_All_Validation_Servers" })
	public void Post_Import_UOL_OTP_All_Validation_Tests(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		if (tdh.isSupportedVersion(configuration)) {
			radiusTestHelper.InvokeRadiusTests(configuration);
		}
	}

	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "postImportULUO", groups = { "RegressionTests" }, dependsOnMethods = { "Start_All_Validation_Servers" })
	public void Post_Import_ULUO_OTP_All_Validation_Tests(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		if (tdh.isSupportedVersion(configuration)) {
			radiusTestHelper.InvokeRadiusTests(configuration);
		}
	}

	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "postImportUAO", groups = { "RegressionTests" }, dependsOnMethods = { "Start_All_Validation_Servers" })
	public void Post_Import_UAO_OTP_All_Validation_Tests(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		if (tdh.isSupportedVersion(configuration)) {
			radiusTestHelper.InvokeRadiusTests(configuration);
		}
	}

	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "postImportTunnelForwarderUO", groups = { "RegressionTests" }, dependsOnMethods = { "Start_All_Validation_Servers",
		"Start_All_Tunnel_Servers" })
	public void Post_Import_All_Tunnel_Server_Tests(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		if (tdh.isSupportedVersion(configuration)) {
			radiusTestHelper.InvokeRadiusTests(configuration);
		}
	}
}
