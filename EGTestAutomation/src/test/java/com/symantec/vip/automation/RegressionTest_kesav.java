package com.symantec.vip.automation;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.symantec.vip.automation.eg.radius.RadiusTestHelper;
import com.symantec.vip.automation.utils.TestDriverHelper;

public class RegressionTest_kesav extends TestBase {
	SeleniumTestHelper sTestHelper = new SeleniumTestHelper();
	RadiusTestHelper radiusTestHelper = new RadiusTestHelper();
	TestDriverHelper tdh = new TestDriverHelper();

	@BeforeSuite
	public void generateTempOTP() throws Exception {
	 tdh.setTempOTP(config);
	}

	@BeforeMethod
	public void configConsoleBasicLogin() throws Exception {
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
	}

	@Test(priority = 0)
	public void AddVIPCertificate_FirstTime() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Configuration for this test is:\n" + configuration);
		sTestHelper.AddVIPCertificate_FirstTime(configuration, driver);
	}

	@Test(priority = 0, groups = { "SanityTests", "RegressionTests" })
	public void add_TrustedRoot_Certificate_AD2008R2() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2008r2");
		configuration.put("expected_result", "true");
		sTestHelper.AddTrustedCACertificate(configuration, driver);
	}

	@Test(priority = 0, dataProviderClass = DataProvider.class, dataProvider = "BVTCeateUserStoreBasic", groups = { "SanityTests", "RegressionTests" }, dependsOnMethods = { "add_TrustedRoot_Certificate_AD2008R2" })
	public void Create_Userstore_basic_scenarios(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CreateUserStore(configuration, driver);
	}

	@Test(priority = 0, dataProviderClass = DataProvider.class, dataProvider = "createBasicApplicationTemplateUO_UPO_ULO", groups = { "SanityTests", "RegressionTests" })
	public void Create_Basic_Application_Template_UO_UPO_ULO(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.StartValidationServer(configuration, driver);
	}

	/*// @Test(dataProviderClass = DataProvider.class, dataProvider =
	// "createBasicApplicationAwareValidationServer", groups = { "SanityTests",
	// "RegressionTests" }, dependsOnMethods = {
	// "Create_Userstore_basic_scenarios" })
	// public void
	// Create_Application_Aware_Validation_Server_With_Default_Configuration(HashMap<String,
	// String> configuration) throws Exception {
	// configuration.putAll(config);
	// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	// "**********Configuration for this test is**********" + configuration);
	// sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
	// }
	@Test(dataProviderClass = DataProvider.class, dataProvider = "createBasicApplicationAwareValidationServer", groups = { "SanityTests", "RegressionTests" })
	public void Verify_OTP_authentication_on_all_application_servers(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		configuration.put("test_scenario", "Verify_OTP_authentication_to_all_application_servers");
		configuration.put("user_name", "bobby");
		configuration.put("user_ldap_password", "1Password");
		configuration.put("user_otp", "494949");
		configuration.put("user_pin", "123456");
		configuration.put("expected-return-packet-type", "access-accept");
		configuration.put("expected-return-code", "0");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
		sTestHelper.DeleteValidaitonServer(driver, configuration.get("validation_server_name"));
	}

	
	 * @Test(dataProviderClass = DataProvider.class, dataProvider =
	 * "createBasicApplicationAwareValidationServer", groups = { "SanityTests",
	 * "RegressionTests" }, dependsOnMethods = {
	 * "Create_Userstore_basic_scenarios" }) public void
	 * Delete_All_Application_Validation_Servers_Created_With_Default_Configuration
	 * (HashMap<String, String> configuration) throws Exception {
	 * configuration.putAll(config); configuration.put("test_scenario",
	 * "Delete all application validation servers created with default configuration"
	 * ); logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * sTestHelper.CheckAndCreateValidationServer(configuration, driver);
	 * sTestHelper.DeleteValidaitonServer(driver,
	 * configuration.get("validation_server_name")); }
	 * 
	 * @Test(priority = 1, dataProviderClass = DataProvider.class, dataProvider
	 * = "createApplicaitonServerWithRLdapMapping", groups = { "SanityTests",
	 * "RegressionTests" }, dependsOnMethods = {
	 * "Create_Userstore_basic_scenarios" }) public void
	 * Create_Application_Server_By_Configuring_RLDAPMapping(HashMap<String,
	 * String> configuration) throws Exception { configuration.putAll(config);
	 * logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * sTestHelper.CheckAndConfigureValidationServer(configuration, driver); }
	 
	@Test(dataProviderClass = DataProvider.class, dataProvider = "createApplicaitonServerWithRLdapMapping", groups = { "SanityTests", "RegressionTests" })
	public void Verify_PrimaryQuery_Of_Radius_To_LDAP_Mapping_Authentication_Response_from_all_supported_Application_Servers(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		configuration.put("test_scenario", "Verify_PrimaryQuery_Of_Radius_To_LDAP_Mapping_Authentication_Response_from_all_supported_application_servers");
		configuration.put("user_name", "bobby");
		configuration.put("user_ldap_password", "1Password");
		configuration.put("user_otp", "494949");
		configuration.put("user_pin", "123456");
		configuration.put("expected-return-packet-type", "access-accept");
		configuration.put("expected-return-code", "0");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
		sTestHelper.DeleteValidaitonServer(driver, configuration.get("validation_server_name"));
	}

	// @Test(dataProviderClass = DataProvider.class, dataProvider =
	// "createApplicaitonServerWithRLdapMapping", groups = { "SanityTests",
	// "RegressionTests" }, dependsOnMethods = {
	// "Create_Application_Server_By_Configuring_RLDAPMapping" })
	// public void
	// Delete_All_Application_Validation_Servers_supports_RLDAP_Mapping(HashMap<String,
	// String> configuration) throws Exception {
	// configuration.putAll(config);
	// configuration.put("test_scenario",
	// "Delete all application validation servers that supports RLDAP Mapping");
	// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	// "**********Configuration for this test is**********" + configuration);
	// // sTestHelper.CheckAndCreateValidationServer(configuration, driver);
	// sTestHelper.DeleteValidaitonServer(driver,
	// configuration.get("validation_server_name"));
	// }
	@Test(priority = 2, groups = { "SanityTests", "RegressionTests" })
	public void Configure_OOB_Attributes_In_The_UserStore() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		configuration.put("userstore_name", "ad2008r2_oob");
		configuration.put("enable_mobile", "true");
		configuration.put("enable_phone", "true");
		configuration.put("enable_email", "true");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.configureOOBAttributesInUserStore(driver, configuration);
	}

	@Test(priority = 2, dataProviderClass = DataProvider.class, dataProvider = "applicationAwareValidaitonServerSupportsChallenge", groups = { "SanityTests", "RegressionTests" }, dependsOnMethods = { "Configure_OOB_Attributes_In_The_UserStore" })
	public void Authetication_with_Challenge_Via_OOB_From_Userstore_Along_with_Radius_To_LDAP_Mapping_from_all_supported_application_servers(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		configuration.put("test_scenario", "Authentication via challenge on application servers via userstore OOB");
		configuration.put("userstore_name", "ad2008r2_oob");
		configuration.put("auth_type", "oob_challenge");
		configuration.put("user_name", "autoË.Reqñ");
		configuration.put("user_keyword", "send");
		configuration.put("user_ldap_password", "âäñÒÙË@12pas");
		configuration.put("user_otp", "494949");
		configuration.put("user_pin", "123456");
		configuration.put("expected-return-packet-type", "access-accept");
		configuration.put("expected-return-code", "0");
		configuration.put("use_userstore_oob", "true");
		configuration.put("ldap_mapping_user_store", "ad2008r2_oob");
		configuration.put("validation_server_name", configuration.get("validation_server_name") + "_uoob");
		// sTestHelper.configureOOBAttributesInUserStore(driver, configuration);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
		sTestHelper.DeleteValidaitonServer(driver, configuration.get("validation_server_name"));
	}

	@Test(priority = 2, dataProviderClass = DataProvider.class, dataProvider = "applicationAwareValidaitonServerSupportsChallenge", groups = { "SanityTests", "RegressionTests" })
	public void Authetication_with_Challenge_along_with_Radius_To_LDAP_Mapping_from_all_supported_application_servers(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		configuration.put("test_scenario", "Verify_Authetication_with_Challenge_along_with_Radius_To_LDAP_Mapping_from_all_supported_application_servers");
		configuration.put("userstore_name", "ad2008r2");
		configuration.put("auth_type", "challenge");
		configuration.put("user_name", "bobby");
		configuration.put("user_keyword", "push");
		configuration.put("user_ldap_password", "1Password");
		configuration.put("user_otp", "494949");
		configuration.put("user_pin", "123456");
		configuration.put("expected-return-packet-type", "access-accept");
		configuration.put("expected-return-code", "0");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
		sTestHelper.DeleteValidaitonServer(driver, configuration.get("validation_server_name"));
	}

	// @Test(priority = 1, dataProviderClass = DataProvider.class, dataProvider
	// = "createApplicaitonServerWithDelegation", groups = { "SanityTests",
	// "RegressionTests" }, dependsOnMethods = {
	// "Create_Userstore_basic_scenarios" })
	// public void
	// Create_Application_Server_by_Configuring_Delegation(HashMap<String,
	// String> configuration) throws Exception {
	// configuration.putAll(config);
	// configuration.put("use_ldap_username", "true");
	// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	// "**********Configuration for this test is**********" + configuration);
	// sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
	// }
	@Test(priority = 1, dataProviderClass = DataProvider.class, dataProvider = "createApplicaitonServerWithDelegation", groups = { "SanityTests", "RegressionTests" })
	public void Verify_Delegation_Authentication_Condition_3_User_Exists_With_No_Credentails_On_All_Application_Servers_Which_Supports_Delegation(HashMap<String, String> configuration)
		throws Exception {
		configuration.putAll(config);
		configuration.put("test_scenario", "Verify Delegation Authentication On All Application Servers Which Supports Delegation");
		configuration.put("user_name", "delegation_eg");
		configuration.put("user_ldap_password", "1Password");
		configuration.put("user_otp", "494949");
		configuration.put("user_pin", "123456");
		configuration.put("expected-return-packet-type", "access-accept");
		configuration.put("expected-return-code", "0");
		configuration.put("use_ldap_username", "true");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
		sTestHelper.DeleteValidaitonServer(driver, configuration.get("validation_server_name"));
	}

	@Test(priority = 1, dataProviderClass = DataProvider.class, dataProvider = "createApplicaitonServerWithDelegation", groups = { "SanityTests", "RegressionTests" })
	public void Verify_Delegation_Authentication_Condition_1_Userstore_Does_Not_Exist_In_Userstore_All_Application_Servers_Which_Supports_Delegation(HashMap<String, String> configuration)
		throws Exception {
		configuration.putAll(config);
		configuration.put("test_scenario", "Verify Delegation Authentication On All Application Servers Which Supports Delegation");
		configuration.put("user_name", "nouserin_ldap");
		configuration.put("user_ldap_password", "1Password");
		configuration.put("user_otp", "494949");
		configuration.put("user_pin", "123456");
		configuration.put("expected-return-packet-type", "access-accept");
		configuration.put("expected-return-code", "0");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
		sTestHelper.DeleteValidaitonServer(driver, configuration.get("validation_server_name"));
	}

	@Test(priority = 1, dataProviderClass = DataProvider.class, dataProvider = "createApplicaitonServerWithDelegation", groups = { "SanityTests", "RegressionTests" })
	public void Verify_Delegation_Authentication_Condition_2_User_Does_Not_Exist_In_The_Cloud_In_All_Application_Servers_Which_Supports_Delegation(HashMap<String, String> configuration)
		throws Exception {
		configuration.putAll(config);
		configuration.put("test_scenario", "Verify Delegation Authentication On All Application Servers Which Supports Delegation");
		configuration.put("user_name", "nouser");
		configuration.put("user_ldap_password", "1Password");
		configuration.put("user_otp", "494949");
		configuration.put("user_pin", "123456");
		configuration.put("expected-return-packet-type", "access-accept");
		configuration.put("expected-return-code", "0");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
		sTestHelper.DeleteValidaitonServer(driver, configuration.get("validation_server_name"));
	}

	// @Test(priority = 5, dataProviderClass = DataProvider.class, dataProvider
	// = "createApplicaitonServerWithDelegation", groups = { "SanityTests",
	// "RegressionTests" }, dependsOnMethods = {
	// "Create_Application_Server_by_Configuring_Delegation" })
	// public void
	// Delete_All_Application_Validation_Servers_supports_Delegation(HashMap<String,
	// String> configuration) throws Exception {
	// configuration.putAll(config);
	// configuration.put("test_scenario",
	// "Delete all application validation servers that supports delegation");
	// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	// "**********Configuration for this test is**********" + configuration);
	// // sTestHelper.CheckAndCreateValidationServer(configuration, driver);
	// sTestHelper.DeleteValidaitonServer(driver,
	// configuration.get("validation_server_name"));
	// }
	@Test(priority = 2, dataProviderClass = DataProvider.class, dataProvider = "PushAuthOnApplicaitonServers", groups = { "SanityTests", "RegressionTests" })
	public void Push_authentication_on_Application_Server_UO_UPO_ULO(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	@Test(priority = 1, dataProviderClass = DataProvider.class, dataProvider = "passwordManagement", groups = { "SanityTests", "RegressionTests" })
	public void Configure_LDAPs_Userstore(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		configuration.put("expected_result", "true");
		configuration.put("test_scenario", "Configure LDAPS (636) Userstore");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2008r2_ssl");
		sTestHelper.CreateUserStore(configuration, driver);
	}

	@Test(priority = 1, dataProviderClass = DataProvider.class, dataProvider = "SSPIDPPasswordResetConfiguration", groups = { "SanityTests", "RegressionTests" })
	public void Configure_LDAPs_Userstore_With_Password_Management_With_OOB(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		configuration.put("expected_result", "true");
		configuration.put("test_scenario", "Configure LDAPS (636) Userstore");
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
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2008r2_ssl_pm");
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.StartValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "ValidationRequestUPOPINResetFlows", groups = { "SmokeTests", "SanityTests", "RegressionTests" })
	public void PIN_Reset_Flow_Validation_Tests_on_UPO_Application_Server_via_Inline_OTP(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
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

	@Test(priority = 1, groups = { "SmokeTests", "SanityTests", "RegressionTests" }, dataProviderClass = DataProvider.class, dataProvider = "ValidationRequestUPOPINResetFlowsExtended")
	public void PIN_Reset_Flow_Extended_Tests_on_UPO(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.updateValidationServer(configuration, driver);
		sTestHelper.RestartValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	@Test(priority = 2, groups = { "SmokeTests", "SanityTests", "RegressionTests" }, dataProviderClass = DataProvider.class, dataProvider = "BCTests")
	public void Business_Continuity_Tests_On_Application_Aware_Server_UO_ULO(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.updateValidationServer(configuration, driver);
		sTestHelper.RestartValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	@Test(priority = 1, groups = { "SmokeTests", "SanityTests", "RegressionTests" }, dataProviderClass = DataProvider.class, dataProvider = "InfoCall")
	public void Info_Call_Tests_On_Application_Validation_server_UO_UPO_ULO(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.updateValidationServer(configuration, driver);
		sTestHelper.RestartValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}
	


	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "RegressionValidationTestsOnBasicServerUPO", groups = { "SmokeTests", "SanityTests", "RegressionTests" })
	public void Validation_Tests_on_UPO_Mode_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "RegressionValidationTestsOnBasicServerULO", groups = { "SmokeTests", "SanityTests", "RegressionTests" })
	public void Validation_Tests_on_ULO_Mode_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	
	 * @Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider
	 * = "RegressionValidationTestsOnBasicServerULOPUSH", groups = {
	 * "SmokeTests", "SanityTests", "RegressionTests" }, dependsOnMethods = {
	 * "Create_Userstore_basic_scenarios" }) public void
	 * Validation_Tests_on_ULOPUSH_Mode_Server(HashMap<String, String>
	 * configuration) throws Exception { configuration.putAll(config);
	 * logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
	 * radiusTestHelper.InvokeRadiusTests(configuration); }
	 
	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "RegressionValidationTestsOnBasicServerUO", groups = { "SmokeTests", "SanityTests", "RegressionTests" })
	public void Validation_Tests_on_UO_Mode_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	
	 * @Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider
	 * = "RegressionValidationTestsOnBasicServerUOPUSH", groups = {
	 * "SmokeTests", "SanityTests", "RegressionTests" }, dependsOnMethods = {
	 * "Create_Userstore_basic_scenarios" }) public void
	 * Validation_Tests_on_UOPUSH_Mode_Server(HashMap<String, String>
	 * configuration) throws Exception { configuration.putAll(config);
	 * logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
	 * radiusTestHelper.InvokeRadiusTests(configuration); }
	 
	
	 * @Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider
	 * = "RegressionValidationTestsOnBasicServerULUO", groups = { "SmokeTests",
	 * "SanityTests", "RegressionTests" }, dependsOnMethods = {`
	 * "Create_Userstore_basic_scenarios" }) public void
	 * Validation_Tests_on_ULUO_Mode_Server(HashMap<String, String>
	 * configuration) throws Exception { configuration.putAll(config);
	 * logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
	 * radiusTestHelper.InvokeRadiusTests(configuration); }
	 
	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "LDAPToRadiusMappingULO", groups = { "SmokeTests", "SanityTests", "RegressionTests" })
	public void Validation_Tests_on_ULO_Mode_Server_With_LDAP_To_RADIUS_Attribute_Configuration(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndCreateValidationServer(configuration, driver);
		sTestHelper.updateValidationServerRadiusToLDAPMapping(configuration, driver);
		sTestHelper.startOrRestartValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	
	 * @Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider
	 * = "LDAPToRadiusMappingULUO", groups = { "SmokeTests", "SanityTests",
	 * "RegressionTests" }, dependsOnMethods = {
	 * "Create_Userstore_basic_scenarios" }) public void
	 * Validation_Tests_on_ULUO_Mode_Server_With_LDAP_To_RADIUS_Attribute_Configuration
	 * (HashMap<String, String> configuration) throws Exception {
	 * configuration.putAll(config); logger.info("Thread-" +
	 * Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * sTestHelper.createValidationServer(configuration, driver);
	 * sTestHelper.updateValidationServerRadiusTo Mapping(configuration,
	 * driver); sTestHelper.RestartValidationServer(configuration, driver);
	 * radiusTestHelper.InvokeRadiusTests(configuration); }
	 
	
	 * @Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider
	 * = "LDAPToRadiusMappingULOPush", groups = { "SmokeTests", "SanityTests",
	 * "RegressionTests" }, dependsOnMethods = {
	 * "Create_Userstore_basic_scenarios" }) public void
	 * Validation_Tests_on_ULOPush_Mode_Server_With_LDAP_To_RADIUS_Attribute_Configuration
	 * (HashMap<String, String> configuration) throws Exception {
	 * configuration.putAll(config); logger.info("Thread-" +
	 * Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * sTestHelper.createValidationServer(configuration, driver);
	 * sTestHelper.updateValidationServerRadiusToLDAPMapping(configuration,
	 * driver); sTestHelper.RestartValidationServer(configuration, driver);
	 * radiusTestHelper.InvokeRadiusTests(configuration); }
	 
	
	 * @Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider
	 * = "LDAPToRadiusMappingUOLPush", groups = { "SmokeTests", "SanityTests",
	 * "RegressionTests" }, dependsOnMethods = {
	 * "Create_Userstore_basic_scenarios" }) public void
	 * Validation_Tests_on_UOLPush_Mode_Server_With_LDAP_To_RADIUS_Attribute_Configuration
	 * (HashMap<String, String> configuration) throws Exception {
	 * configuration.putAll(config); logger.info("Thread-" +
	 * Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * sTestHelper.createValidationServer(configuration, driver);
	 * sTestHelper.updateValidationServerRadiusToLDAPMapping(configuration,
	 * driver); sTestHelper.RestartValidationServer(configuration, driver);
	 * radiusTestHelper.InvokeRadiusTests(configuration); }
	 
	// BC Mode Tests starts from here
	
	 * @Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider
	 * = "BCModeTestDataOnULUOValidationServer", groups = { "SmokeTests",
	 * "SanityTests", "RegressionTests" }, dependsOnMethods = {
	 * "Create_Userstore_basic_scenarios" }) public void
	 * Business_Continuity_Tests_on_ULUO_Mode_Server(HashMap<String, String>
	 * configuration) throws Exception { configuration.putAll(config);
	 * logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
	 * radiusTestHelper.InvokeRadiusTests(configuration); }
	 
	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "BCModeTestDataOnULOValidationServer", groups = { "SmokeTests", "SanityTests", "RegressionTests" })
	public void Business_Continuity_Tests_on_ULO_Mode_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	
	 * @Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider
	 * = "BCModeTestDataOnULOPUSHValidationServer", groups = { "SmokeTests",
	 * "SanityTests", "RegressionTests" }, dependsOnMethods = {
	 * "Create_Userstore_basic_scenarios" }) public void
	 * Business_Continuity_Tests_on_ULOPUSH_Mode_Server(HashMap<String, String>
	 * configuration) throws Exception { configuration.putAll(config);
	 * logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
	 * radiusTestHelper.InvokeRadiusTests(configuration); }
	 
	
	 * @Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider
	 * = "BCModeTestDataOnUOLPUSHValidationServer", groups = { "SmokeTests",
	 * "SanityTests", "RegressionTests" }, dependsOnMethods = {
	 * "Create_Userstore_basic_scenarios" }) public void
	 * Business_Continuity_Tests_on_UOLPUSH_Mode_Server(HashMap<String, String>
	 * configuration) throws Exception { configuration.putAll(config);
	 * logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
	 * radiusTestHelper.InvokeRadiusTests(configuration); }
	 
	// @Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider
	// = "BCModeTestDataOnUOPUSHValidationServer", groups = { "SmokeTests",
	// "SanityTests", "RegressionTests" }, dependsOnMethods = {
	// "Create_Userstore_basic_scenarios" })
	// public void
	// Business_Continuity_Tests_on_UOPUSH_Mode_Server(HashMap<String, String>
	// configuration) throws Exception {
	// configuration.putAll(config);
	// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	// "**********Configuration for this test is**********" + configuration);
	// sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
	// radiusTestHelper.InvokeRadiusTests(configuration);
	// }
	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "BCModeTestDataOnUOValidationServer", groups = { "SmokeTests", "SanityTests", "RegressionTests" })
	public void Business_Continuity_Tests_on_UO_Mode_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	// BC Mode tests ends here
	@Test(dataProviderClass = DataProvider.class, dataProvider = "CreateUPOValidationServerWithPinReset", groups = { "baseconfig", "SanityTests", "RegressionTests" })
	public void Create_UPO_Validation_Server_By_Enabling_Pin_Reset_Option(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.StartValidationServer(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "ValidationRequestUPOPINResetFlows", groups = { "SmokeTests", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Create_UPO_Validation_Server_By_Enabling_Pin_Reset_Option" })
	public void PIN_Reset_Flow_Validation_Tests_on_UPO_Mode_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		configuration.put("validation_server_shared_secret", "password1");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}
	
	 * @Test(priority = 2, dataProviderClass = DataProvider.class, dataProvider
	 * = "CreateUOValidationServerWithPush", groups = { "SmokeTests",
	 * "SanityTests", "RegressionTests" }) public void
	 * Create_UO_ValidationServer_With_Push(HashMap<String, String>
	 * configuration) throws Exception { configuration.putAll(config);
	 * logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * sTestHelper.createValidationServer(configuration, driver);
	 * sTestHelper.StartValidationServer(configuration, driver); }
	 * 
	 * @Test(priority = 3, dataProviderClass = DataProvider.class, dataProvider
	 * = "ValidationRequestsUO", groups = { "SanityTests", "RegressionTests" },
	 * dependsOnMethods = { "Create_UO_ValidationServer_With_Push" }) public
	 * void OTP_Validation_Test_On_Push_Enabled_UO_Server(HashMap<String,
	 * String> configuration) throws Exception { configuration.putAll(config);
	 * logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	 * "**********Configuration for this test is**********" + configuration);
	 * radiusTestHelper.InvokeRadiusTests(configuration); }
	 
	// @Test(dataProviderClass = DataProvider.class, dataProvider =
	// "CreateUOValidationAndUOPushValidation", groups = { "SanityTests",
	// "RegressionTests" })
	// public void
	// Create_UO_ValidationServer_And_Validate_Push_On_Device(HashMap<String,
	// String> configuration) throws Exception {
	// configuration.putAll(config);
	// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
	// "**********Configuration for this test is**********" + configuration);
	// sTestHelper.createValidationServer(configuration, driver);
	// sTestHelper.StartValidationServer(configuration, driver);
	// radiusTestHelper.InvokeRadiusTests(configuration);
	// }
*/}
