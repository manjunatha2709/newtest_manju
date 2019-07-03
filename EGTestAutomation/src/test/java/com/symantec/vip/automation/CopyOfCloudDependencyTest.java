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

public class CopyOfCloudDependencyTest extends TestBase {
	public String productSourceVersion;
	public static Logger logger = TestBase.logger;
	SeleniumTestHelper sTestHelper = new SeleniumTestHelper();
	RestClient rClient = new RestClient();
	RadiusTestHelper radiusTestHelper = new RadiusTestHelper();
	TestDriverHelper tdh = new TestDriverHelper();
	AutomationPropertiesHelper aph = new AutomationPropertiesHelper();

	@BeforeSuite
	public void SetEnvironment() throws Exception {
		tdh.setTempOTP(config);
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

	@Test(dataProviderClass = DataProvider.class, dataProvider = "VIPManagerIDPLoginDifferentFormat", groups = { "baseconfig", "SanityTests", "RegressionTests" }, priority = 2, dependsOnMethods = { "Start_VIP_Manager_IDP_Service" })
	public void VIP_Manager_IDP_Login_Different_Login_Format(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.loginToVIPMGRWithoutSSL(configuration, driver);
	}

	@Test(groups = { "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void add_TrustedRoot_Certificate_AD2008R2() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2008r2");
		configuration.put("expected_result", "true");
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		sTestHelper.AddTrustedCACertificate(configuration, driver);
	}

	@Test(priority = 0, dataProviderClass = DataProvider.class, dataProvider = "BVTCeateUserStoreBasic", groups = { "SanityTests", "RegressionTests" }, dependsOnMethods = { "add_TrustedRoot_Certificate_AD2008R2" })
	public void Create_Userstore_basic_scenarios(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		sTestHelper.CreateUserStore(configuration, driver);
	}

	@Test(priority = 2, dataProviderClass = DataProvider.class, dataProvider = "PushAuthOnApplicaitonServers", groups = { "SanityTests", "RegressionTests" }, dependsOnMethods = { "Create_Userstore_basic_scenarios" })
	public void Push_authentication_on_Application_Server_UO_UPO_ULO(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	@Test(priority = 1, dataProviderClass = DataProvider.class, dataProvider = "passwordManagement", groups = { "SanityTests", "RegressionTests" }, dependsOnMethods = { "add_TrustedRoot_Certificate_AD2008R2" })
	public void Configure_LDAPs_Userstore(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		configuration.put("expected_result", "true");
		configuration.put("test_scenario", "Configure LDAPS (636) Userstore");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		configuration.put("userstore_name", "ad2008r2_ssl");
		sTestHelper.CreateUserStore(configuration, driver);
	}

	@Test(priority = 1, dataProviderClass = DataProvider.class, dataProvider = "SSPIDPPasswordResetConfiguration", groups = { "SanityTests", "RegressionTests" }, dependsOnMethods = { "add_TrustedRoot_Certificate_AD2008R2" })
	public void Configure_LDAPs_Userstore_With_Password_Management_With_OOB(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		configuration.put("expected_result", "true");
		configuration.put("test_scenario", "Configure LDAPS (636) Userstore");
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2008r2_ssl_pm");
		sTestHelper.CreateUserStore(configuration, driver);
		sTestHelper.enablePasswordManagement(driver, configuration);
		configuration.put("userstore_name", "ad2008r2_ssl_pm");
		configuration.put("enable_mobile", "true");
		configuration.put("enable_phone", "true");
		configuration.put("enable_email", "true");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.configureOOBAttributesInUserStore(driver, configuration);
	}

	@Test(priority = 5, dataProviderClass = DataProvider.class, dataProvider = "passwordManagement", groups = { "SanityTests", "RegressionTests" }, dependsOnMethods = { "Configure_LDAPs_Userstore_With_Password_Management_With_OOB" })
	public void Password_Reset_Tests_On_Application_Aware_Validation_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2008r2_ssl_pm");
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.StartValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "ValidationRequestUPOPINResetFlows", groups = { "SmokeTests", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Create_Basic_Application_Template_UO_UPO_ULO" })
	public void PIN_Reset_Flow_Validation_Tests_on_UPO_Application_Server_via_Inline_OTP(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		configuration.put("validation_server_name", "jun_sbr_upo");
		configuration.put("server_port", "4888");
		configuration.put("validation_server_shared_secret", "password1");
		configuration.put("enable_access_challenge", "true");
		configuration.put("confirm_rad_shared", "password1");
		configuration.put("radius_ldap_supported", "false");
		configuration.put("delegation_status", "false");
		configuration.put("enable_access_challenge", "true");
		configuration.put("confirm_rad_shared", "password1");
		configuration.put("use_ldap_username", "false");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.updateValidationServer(configuration, driver);
		sTestHelper.RestartValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	@Test(priority = 0, dataProviderClass = DataProvider.class, dataProvider = "createBasicApplicationTemplateUO_UPO_ULO", groups = { "SanityTests", "RegressionTests" }, dependsOnMethods = { "Create_Userstore_basic_scenarios" })
	public void Create_Basic_Application_Template_UO_UPO_ULO(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.StartValidationServer(configuration, driver);
	}

	@Test(priority = 1, groups = { "SmokeTests", "SanityTests", "RegressionTests" }, dataProviderClass = DataProvider.class, dataProvider = "ValidationRequestUPOPINResetFlowsExtended", dependsOnMethods = { "Create_Basic_Application_Template_UO_UPO_ULO" })
	public void PIN_Reset_Flow_Extended_Tests_on_UPO(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.updateValidationServer(configuration, driver);
		sTestHelper.RestartValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	@Test(priority = 1, groups = { "SmokeTests", "SanityTests", "RegressionTests" }, dataProviderClass = DataProvider.class, dataProvider = "InfoCall", dependsOnMethods = { "Create_Basic_Application_Template_UO_UPO_ULO" })
	public void Info_Call_Tests_On_Application_Validation_server_UO_UPO_ULO(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.updateValidationServer(configuration, driver);
		sTestHelper.RestartValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "BVT_VIPAdministratorConfigWithDiffDNUserStore", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Create_Userstore_basic_scenarios" })
	public void Configure_VIP_Administrator(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.VIPAdministratorConfigration(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "BVT_VIPAdministratorConfigWithDiffDNUserStore", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Configure_VIP_Administrator" })
	public void Configure_VIP_Admin_Group_Mapping(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ConfigureVIPAdminGroupMappingAndAttributes(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "BVT_VIPAdministratorConfigWithDiffDNUserStore", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Configure_VIP_Admin_Group_Mapping" })
	public void Start_LDAP_Directory_Sync_Service_By_Enabling_Admin_User_Sync(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ConfigureLDAPSync(configuration, driver);
		sTestHelper.StopLDAPSyncService(configuration, driver);
		sTestHelper.StartLDAPSyncService(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "BVT_CreateUserStoreDiffDN", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Create_Userstore_basic_scenarios" })
	public void SSP_IDP_Login_With_SSL(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("enable_mobile", "true");
		configuration.put("enable_phone", "true");
		configuration.put("enable_email", "true");
		sTestHelper.configureOOBAttributesInUserStore(driver, configuration);
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.SSPIdpConfigrationSetup(configuration, driver);
		sTestHelper.StartSSPIDPService(driver, Boolean.valueOf(configuration.get("expected_result_sspidp")));
		sTestHelper.LoginToSSP(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "SSPIDPPasswordResetConfiguration", groups = { "baseconfig", "SanityTests", "RegressionTests" }, priority = 5, dependsOnMethods = { "Configure_LDAPs_Userstore" })
	public void Configure_SSPIDP_With_PasswordManagement(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2008r2_ssl");
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.SSPIdpConfigrationSetup(configuration, driver);
		sTestHelper.restartSSPIDPService(driver, true);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "SSPIDPPasswordReset", groups = { "RegressionTests" }, dependsOnMethods = { "Configure_SSPIDP_With_PasswordManagement" })
	public void SSP_IDP_Password_Reset(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.resetLDAPPasswordViaSSP(configuration, driver);
	}

	@Test(priority = 0, groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
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
		String vip_certificate_path = configuration.get("vip_certificate_path") + "\\" + configuration.get("selected_env") + "_vip_cert.p12";
		configuration.put("vip_certificate_password", "1Password");
		configuration.put("vip_certificate_path", vip_certificate_path);
		sTestHelper.AddVIPCertificate(configuration, driver);
		driver.findElement(By.linkText("Use this Key")).click();
		TestBed tBed = new TestBed();
		tBed.changeAuthURL(configuration);
	}

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
}
