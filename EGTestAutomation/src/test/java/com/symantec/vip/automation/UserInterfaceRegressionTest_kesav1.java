package com.symantec.vip.automation;

import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.symantec.vip.automation.utils.CodeCoverageProcedure;
import com.symantec.vip.soapclient.VIPServicesSoapClient;

public class UserInterfaceRegressionTest_kesav1 extends TestBase {
	SeleniumTestHelper sTestHelper = new SeleniumTestHelper();

	@AfterTest
	public void codeCoveragePreparation() {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		CodeCoverageProcedure.executeCodeCoverageScript(configuration);
	}

	@BeforeClass
	public void setVIPEnvironment() throws Exception {
		config.putAll(aph.GetCommonPropertiesAndLastStringAsKey("common.prop."));
		config.put("selected_env", "production");
		config.putAll(testDriverHelper.getVIPServicesEnvironment(config));
		VIPServicesSoapClient.generateTempOTP("bobby", "494949", config.get("selected_env"));
		VIPServicesSoapClient.generateTempOTP("ssppwd", "494949", config.get("selected_env"));
		VIPServicesSoapClient.generateTempOTP("autoèéëùúüà", "494949", config.get("selected_env"));
		VIPServicesSoapClient.generateTempOTP("autoË.Reqñ", "494949", config.get("selected_env"));
		VIPServicesSoapClient.generateTempOTP("arjunmurthywithslash", "494949", config.get("selected_env"));
		VIPServicesSoapClient.generateTempOTP("arjunmurthywithslash@xuv.prupleclub.europe.internal", "494949", config.get("selected_env"));
		VIPServicesSoapClient.generateTempOTP("tan.bobby", "494949", config.get("selected_env"));
		VIPServicesSoapClient.generateTempOTP("tan_bobby", "494949", config.get("selected_env"));
		VIPServicesSoapClient.generateTempOTP("t", "494949", config.get("selected_env"));
		VIPServicesSoapClient.generateTempOTP("bobby3pwd", "494949", config.get("selected_env"));
		VIPServicesSoapClient.generateTempOTP("cn_comma_slash_user", "494949", config.get("selected_env"));
		VIPServicesSoapClient.generateTempOTP("arjunmurthywithcomma", "494949", config.get("selected_env"));
		VIPServicesSoapClient.generateTempOTP("pmuther", "494949", config.get("selected_env"));
	}

	@BeforeMethod
	public void ConfigConsoleBasicLogin() throws Exception {
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
	}

	// @Test(dataProviderClass = DataProvider.class, dataProvider =
	// "ImportSettingsData", groups = { "baseconfig", "SanityTests",
	// "RegressionTests" }, priority = 1, dependsOnMethods = {
	// "AddVIPCertificate_FirstTime" })
	// public void ImportSettings(HashMap<String, String> configuration) throws
	// Exception {
	// configuration.putAll(config);
	// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	// "**********Configuration for this test is**********" + configuration);
	// sTestHelper.ImportSettings(configuration, driver);
	// }
	// @Test(dataProviderClass = DataProvider.class, dataProvider =
	// "ImportSettingsDataWithPassword", groups = { "baseconfig", "SanityTests",
	// "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime"
	// })
	// public void ImportSettingsDataWithPassword(HashMap<String, String>
	// configuration) throws Exception {
	// configuration.putAll(config);
	// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	// "**********Configuration for this test is**********" + configuration);
	// sTestHelper.ImportSettingsWithPassword(configuration, driver);
	// }
	/*@Test(priority = 0)
	public void AddVIPCertificate_FirstTime() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.AddVIPCertificate_FirstTime(configuration, driver);
	}*/

	@Test(dataProviderClass = DataProvider.class, dataProvider = "CreateUserStoreBasic", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void CreateUserStoreBasic(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CreateUserStore(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "CreateValidationServerBasic", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void CreateValidationServer(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
	}

	// ======
	@Test(dataProviderClass = DataProvider.class, dataProvider = "UpdateValidationServerUO", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Update_UO_Validation_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.UpdateValidationServer(configuration, driver);
		sTestHelper.StartValidationServer(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "UpdateValidationServerULO", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = {
		"AddVIPCertificate_FirstTime", "CreateUserStoreBasic" })
	public void Update_ULO_Validation_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.UpdateValidationServer(configuration, driver);
		sTestHelper.StartValidationServer(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "UpdateValidationServerUPO", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Configure_Syslog_Servers" })
	public void Update_UPO_Validation_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.UpdateValidationServer(configuration, driver);
		sTestHelper.StartValidationServer(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "UpdateValidationServerULUO", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = {
		"AddVIPCertificate_FirstTime", "CreateUserStoreBasic" })
	public void Update_ULUO_Validation_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.UpdateValidationServer(configuration, driver);
		sTestHelper.StartValidationServer(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "UpdateValidationServerRadiusLDAPMappingULO", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = {
		"AddVIPCertificate_FirstTime", "CreateUserStoreBasic" })
	public void Update_LDAP_To_Radius_Mapping_On_ULO_Validation_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.updateValidationServerRadiusToLDAPMapping(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "DuplicateValidationServerWithUO", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Configure_Syslog_Servers" })
	public void Duplicate_UO_ValidationServer(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.UpdateValidationServer(configuration, driver);
		sTestHelper.DuplicateValdationServer(configuration, driver);
		String servername = configuration.get("validation_server_name");
		configuration.put("validation_server_name", servername + "-copy");
		String port = configuration.get("duplicate_port_number");
		configuration.put("update_server_port", port);
		sTestHelper.CheckUpdatedValidationServerValues(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "DuplicateValidationServerWithUPO", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Configure_Syslog_Servers" })
	public void Duplicate_UPO_ValidationServer(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.UpdateValidationServer(configuration, driver);
		sTestHelper.DuplicateValdationServer(configuration, driver);
		String servername = configuration.get("validation_server_name");
		configuration.put("validation_server_name", servername + "-copy");
		String port = configuration.get("duplicate_port_number");
		configuration.put("update_server_port", port);
		sTestHelper.CheckUpdatedValidationServerValues(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "DuplicateValidationServerWithULUO", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = {
		"Configure_Syslog_Servers", "CreateUserStoreBasic" })
	public void Duplicate_ULUO_ValidationServer(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.UpdateValidationServer(configuration, driver);
		sTestHelper.DuplicateValdationServer(configuration, driver);
		String servername = configuration.get("validation_server_name");
		configuration.put("validation_server_name", servername + "-copy");
		String port = configuration.get("duplicate_port_number");
		configuration.put("update_server_port", port);
		sTestHelper.CheckUpdatedValidationServerValues(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "DuplicateValidationServerWithULO", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = {
		"Configure_Syslog_Servers", "CreateUserStoreBasic" })
	public void Duplicate_ULO_ValidationServer(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.UpdateValidationServer(configuration, driver);
		sTestHelper.DuplicateValdationServer(configuration, driver);
		String servername = configuration.get("validation_server_name");
		configuration.put("validation_server_name", servername + "-copy");
		String port = configuration.get("duplicate_port_number");
		configuration.put("update_server_port", port);
		sTestHelper.CheckUpdatedValidationServerValues(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "DuplicateValidationServerradiusToLDAPMappingULUO", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = {
		"Configure_Syslog_Servers", "CreateUserStoreBasic" })
	public void Duplicate_Validation_Server_With_LDAP_To_Radius_Configuration_In_ULUO(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.updateValidationServerRadiusToLDAPMapping(configuration, driver);
		sTestHelper.DuplicateValdationServer(configuration, driver);
		String servername = configuration.get("validation_server_name");
		configuration.put("validation_server_name", servername + "-copy");
		sTestHelper.CheckUpdatedValdationServerradiusToLDAPMappingValues(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "DuplicateValidationServerradiusToLDAPMappingULO", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = {
		"Configure_Syslog_Servers", "CreateUserStoreBasic" })
	public void Duplicate_Validation_Server_With_LDAP_To_Radius_Configuration_In_ULO(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.updateValidationServerRadiusToLDAPMapping(configuration, driver);
		sTestHelper.DuplicateValdationServer(configuration, driver);
		String servername = configuration.get("validation_server_name");
		configuration.put("validation_server_name", servername + "-copy");
		sTestHelper.CheckUpdatedValdationServerradiusToLDAPMappingValues(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "AddSSLCertificate", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Import_SSL_Certificate(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.CheckSSLCertAdded(configuration, driver);
		sTestHelper.DeleteSSLCertificate(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "AddVIPCertificate", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Add_VIP_Certificate(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.AddVIPCertificate(configuration, driver);
		sTestHelper.CheckVIPCertAdded(configuration, driver);
		sTestHelper.DeleteVIPCertificate(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "UpdateValidationServerAutoBCMode", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Update_Automatic_Business_Continuity_In_Validation_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.UpdateValidationServerAutomaticBCMode(configuration, driver);
		sTestHelper.CheckUpdatedValidationServerAutomaticBCMode(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "AddSSLCertificate", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Check_SSL_Certificate_Details_In_SSPIDP_Configuration_PAge(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.CheckSSLCertDetailsInSSPIDP(configuration, driver);
		sTestHelper.DeleteSSLCertificate(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "AddSSLCertificate", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Check_SSL_Certificate_Details_In_VIP_Manager_IDP_Configuration_Page(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.CheckSSLCertDetailsInVIPManagerIDP(configuration, driver);
		sTestHelper.DeleteSSLCertificate(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "AddSSLCertificate", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Check_SSL_Certificate_Details_In_Console_Settings_Page(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.CheckSSLCertDetailsInConsoleSettings(configuration, driver);
		sTestHelper.DeleteSSLCertificate(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "AddTunnelReceiverWithSSLCert", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Configure_Tunnel_Reciever_With_SSL(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.AddTunnelReceiver(configuration, driver);
		sTestHelper.CheckSSLCertDetailsInTunnelReceiver(configuration, driver);
		sTestHelper.DeleteSSLCertificate(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "Test_SSPIDP_login_DiffFormat", priority = 5, groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Test_SSPIDP_login_DiffFormat(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.DeleteUserStore(configuration, driver);
		sTestHelper.CreateUserStore(configuration, driver);
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.SSPIdpConfigrationSetup(configuration, driver);
		sTestHelper.StartSSPIDPService(driver, Boolean.valueOf(configuration.get("expected_result_sspidp")));
		sTestHelper.LoginToSSPSAMLSuccessCheck(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "UpdateSettingsData", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void UpdateSettings(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.UpdateSettings(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "ConsoleSettingHTTPSLogin", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void ConsoleSetting_HTTPS_Login(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.ConsoleSettings_HTTPS_Login(configuration, driver);
		sTestHelper.ConfigConsoleBasicLogin(configuration, driver);
		sTestHelper.Disable_HTTPS_ConsoleSetting(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "AddTunnelForwarderWithSSLCert", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Test_AddTunnelForwarder(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.AddTunnelForwarder(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "ConfigureConsoleAuthenticate", groups = { "baseconfig", "SanityTests", "RegressionTests" }, priority = 5, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Console_Authentication_by_configuring_different_bindDN_in_UserstoreDiffDN(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.DeleteUserStore(configuration, driver);
		sTestHelper.CreateUserStore(configuration, driver);
		sTestHelper.ConfigureConsoleAuthentication(configuration, driver);
		sTestHelper.ConfigureConsoleAuthenticationLoginFlow(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "SystemSettingData", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Configure_System_Settings(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.SystemSettingsEdit(configuration, driver);
		sTestHelper.SystemSettingsCheck(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "SysLogData", groups = { "baseconfig", "SanityTests", "RegressionTests" }, priority = 5, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Configure_Syslog_Servers(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.SysLogConfiguration(configuration, driver);
	}

	@Test(groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Help_Link_In_Login_Page() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.Verify_HelpLink_In_Login_Page(configuration, driver);
	}

	@Test(groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Legal_Notice_FooterLink() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.verify_Legal_Notice_FooterLink(configuration, driver);
	}

	@Test(groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Privacy_FooterLink() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.Verify_Privacy_FooterLink(configuration, driver);
	}

	@Test(groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Repository_FooterLink() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.Verify_Repository_FooterLink(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, priority = 5, dataProvider = "CreateValidaitonServerwithPushBoundaryTest", groups = { "RegressionTests" })
	public void Create_UO_ValidationServer_With_Push_UI_Boundary(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
	}

	@Test(priority = 1, dataProviderClass = DataProvider.class, dataProvider = "SSPIDPPasswordResetConfiguration", groups = { "SanityTests", "RegressionTests" }, dependsOnMethods = { "add_TrustedRoot_Certificate_AD2008R2" })
	public void Configure_LDAPs_Userstore(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		configuration.put("expected_result", "true");
		configuration.put("test_scenario", "Configure LDAPS (636) Userstore");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2008r2_ssl");
		sTestHelper.DeleteUserStore(configuration, driver);
		configuration.put("userstore_name", "ad2008r2_ssl");
		sTestHelper.CreateUserStore(configuration, driver);
		sTestHelper.enablePasswordManagement(driver, configuration);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "SSPIDPPasswordResetConfiguration", groups = { "baseconfig", "SanityTests", "RegressionTests" }, priority = 5, dependsOnMethods = { "Configure_LDAPs_Userstore" })
	public void Configure_SSPIDP_With_PasswordManagement(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2008r2_ssl");
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.SSPIdpConfigrationSetup(configuration, driver);
		sTestHelper.restartSSPIDPService(driver, true);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "SSPIDPPasswordReset", groups = { "RegressionTests" }, dependsOnMethods = { "Configure_SSPIDP_With_PasswordManagement" })
	public void SSP_IDP_Password_Reset(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.resetLDAPPasswordViaSSP(configuration, driver);
	}

	// ===============
	@Test(groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void add_TrustedRoot_Certificate_AD2008R2() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2008r2");
		configuration.put("expected_result", "true");
		sTestHelper.AddTrustedCACertificate(configuration, driver);
	}

	@Test(groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void add_TrustedRoot_Certificate_AD2003() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2003");
		configuration.put("expected_result", "true");
		sTestHelper.AddTrustedCACertificate(configuration, driver);
	}

	@Test(groups = { "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void addTrustedRoot_WrongTeustedTRootFile() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2008r21");
		configuration.put("expected_result", "false");
		sTestHelper.AddTrustedCACertificate(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "CreateValidationServerNegative", groups = { "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void CreateValidationServer_Negative_Scenarios(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "ConfigureProxy", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void ConfigureProxy_Parameterized(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ConfigureProxySettings(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "ExportSettingsData", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void ExportSettings(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.ExportSettings(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "SSPIDPLoginDiffDN", groups = { "baseconfig", "SanityTests", "RegressionTests" }, priority = 5, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void SSP_Login_by_configuring_different_BindDN_in_UserstoreDiffDN(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.DeleteUserStore(configuration, driver);
		sTestHelper.CreateUserStore(configuration, driver);
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.SSPIdpConfigrationSetup(configuration, driver);
		sTestHelper.StartSSPIDPService(driver, Boolean.valueOf(configuration.get("expected_result_sspidp")));
		sTestHelper.LoginToSSPSAMLSuccessCheck(configuration, driver);
	}

	// @Test(dataProviderClass = DataProvider.class, dataProvider =
	// "HelpLinkData", groups = { "baseconfig", "SanityTests", "RegressionTests"
	// }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	// public void HelpPage(HashMap<String, String> configuration) throws
	// Exception {
	// configuration.putAll(config);
	// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	// "**********Configuration for this test is**********" + configuration);
	// sTestHelper.HelpSettings(configuration, driver);
	// }
	@Test(dataProviderClass = DataProvider.class, dataProvider = "ULOValidationServerWithDifferentBindDNInUserstore", groups = { "baseconfig", "SanityTests", "RegressionTests" }, priority = 5, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Start_ULO_Validation_Server_by_configuring_different_BindDN_in_Userstore(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.DeleteUserStore(configuration, driver);
		sTestHelper.CreateUserStore(configuration, driver);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.StartValidationServer(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "VIPAdministratorConfigWithDiffDNUserStore", groups = { "baseconfig", "SanityTests", "RegressionTests" }, priority = 5, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void VIP_Manager_IDP_Login_by_configuring_different_BindDN_in_Userstore(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.DeleteUserStore(configuration, driver);
		sTestHelper.CreateUserStore(configuration, driver);
		sTestHelper.ImportSSLCertificate(configuration, driver);
		sTestHelper.VIPAdministratorConfigration(configuration, driver);
		sTestHelper.VIPManagerIdpConfigration(configuration, driver);
		sTestHelper.StopVIPManagerIDPService(configuration, driver);
		sTestHelper.StartVIPManagerIDPService(configuration, driver);
		sTestHelper.LoginToVIPMGR(configuration, driver);
	} 

	@Test(dataProviderClass = DataProvider.class, dataProvider = "VIPAdministratorConfigWithDiffDNUserStore", groups = { "baseconfig", "SanityTests", "RegressionTests" }, priority = 5, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Start_LDAPSync_Service_by_configuring_different_BindDN_in_Userstore(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.DeleteUserStore(configuration, driver);
		sTestHelper.CreateUserStore(configuration, driver);
		sTestHelper.VIPAdministratorConfigration(configuration, driver);
		sTestHelper.ConfigureVIPAdminGroupMappingAndAttributes(configuration, driver);
		sTestHelper.ConfigureLDAPSync(configuration, driver);
		sTestHelper.StopLDAPSyncService(configuration, driver);
		sTestHelper.StartLDAPSyncService(configuration, driver);
	}
}
