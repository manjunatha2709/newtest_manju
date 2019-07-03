package com.symantec.vip.automation;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.symantec.vip.automation.eg.radius.RadiusTestHelper;
import com.symantec.vip.automation.utils.TestDriverHelper;

public class ValidationServerRegressionTest extends TestBase {
	SeleniumTestHelper sTestHelper = new SeleniumTestHelper();
	RadiusTestHelper radiusTestHelper = new RadiusTestHelper();
	TestDriverHelper tdh = new TestDriverHelper();

	// @BeforeSuite
	// public void generateTempOTP() {
	// tdh.SetTempOTP();
	// }
	@BeforeSuite
	public void SetEnvironment() throws Exception {
		//tdh.setTempOTP(config);
	}

	@BeforeMethod
	public void ConfigConsoleBasicLogin() throws Exception {
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
	}

	@Test(priority = 0)
	public void AddVIPCertificate_FirstTime() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Configuration for this test is:\n" + configuration);
		sTestHelper.AddVIPCertificate_FirstTime(configuration, driver);
	}

	@Test(priority = 0, groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
	public void Add_TrustedRoot_Certificate_AD2008R2() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		configuration.put("userstore_name", "ad2008r2");
		configuration.put("expected_result", "true");
		sTestHelper.AddTrustedCACertificate(configuration, driver);
	}

	@Test(priority = 0, dataProviderClass = DataProvider.class, dataProvider = "BVTCeateUserStoreBasic", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Add_TrustedRoot_Certificate_AD2008R2" })
	public void Create_Userstore_basic_scenarios(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CreateUserStore(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "RegressionValidationTestsOnBasicServerUPO", groups = { "SmokeTests", "SanityTests", "RegressionTests" })
	public void Validation_Tests_on_UPO_Mode_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}
	@Test(dataProviderClass = DataProvider.class, priority = 0, dataProvider = "LDAPToRadiusMappingULO", groups = { "SmokeTests", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Create_Userstore_basic_scenarios" })
	public void Validation_Tests_on_ULO_Mode_Server_With_LDAP_To_RADIUS_Attribute_Configuration(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndCreateValidationServer(configuration, driver);
		sTestHelper.updateValidationServerRadiusToLDAPMapping(configuration, driver);
		sTestHelper.startOrRestartValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}
	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "RegressionValidationTestsOnBasicServerULO", groups = { "SmokeTests", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Create_Userstore_basic_scenarios" })
	public void Validation_Tests_on_ULO_Mode_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	/*
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
	 */
	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "RegressionValidationTestsOnBasicServerUO", groups = { "SmokeTests", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Create_Userstore_basic_scenarios" })
	public void Validation_Tests_on_UO_Mode_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	/*
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
	 */
	/*
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
	 */
	

	/*
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
	 */
	/*
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
	 */
	/*
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
	 */
	// BC Mode Tests starts from here
	/*
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
	 */
	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "BCModeTestDataOnULOValidationServer", groups = { "SmokeTests", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Create_Userstore_basic_scenarios" })
	public void Business_Continuity_Tests_on_ULO_Mode_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	/*
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
	 */
	/*
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
	 */
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
	@Test(dataProviderClass = DataProvider.class, priority = 1, dataProvider = "BCModeTestDataOnUOValidationServer", groups = { "SmokeTests", "SanityTests", "RegressionTests" }, dependsOnMethods = { "Create_Userstore_basic_scenarios" })
	public void Business_Continuity_Tests_on_UO_Mode_Server(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CheckAndConfigureValidationServer(configuration, driver);
		radiusTestHelper.InvokeRadiusTests(configuration);
	}

	// BC Mode tests ends here
	@Test(dataProviderClass = DataProvider.class, dataProvider = "CreateUPOValidationServerWithPinReset", groups = { "baseconfig", "SanityTests", "RegressionTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" })
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
	/*
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
	 */
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
}
