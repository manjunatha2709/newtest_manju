package com.symantec.vip.automation;

import java.util.ArrayList;
import java.util.HashMap;

import com.symantec.vip.automation.utils.DataReader;

public class DataProvider {
	static DataReader csvReader = new DataReader();

	@org.testng.annotations.DataProvider(name = "test")
	public static Object[][] test() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("add_ssl_certificate.json");
		jsonFileList.add("1test.json");
				Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
		
	}

	@org.testng.annotations.DataProvider(name = "test1")
	public static Object[][] ApplicationAwareValidationServerSupportsChallenge1() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("1test1.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ConfigConsoleLogin")
	public static Object[][] getDataForConfigurationConsoleLgin() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("config_console_login.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "CreateValidationServerNegative")
	public static Object[][] getDataForValidationserverCreate() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("create_validation_server_negative.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "CreateValidationServerBasic")
	public static Object[][] getDataForValidationserverCreateNegative() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("create_validation_server.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ValidationServerDataForPerfTest")
	public static Object[][] validationServerDataForPerfTest() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("perf_create_validation_server.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "CreateUserStoreBasic")
	public static Object[][] GetDataForUserStoreCreate() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("create_userstore.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ConfigureProxy")
	public static Object[][] ConfigureProxyParameterized_positive() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("configure_proxy.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ConfigureProxyNegative")
	public static Object[][] ConfigureProxyParameterized_negative() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("configure_proxy_negative_tests.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "VIPDiagToolTestData")
	public static Object[][] VIPDiagToolTestData() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("vipdiagnostictool_test.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ExportSettingsData")
	public static Object[][] ExportSettingsData() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("export_configuration.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ImportSettingsData")
	public static Object[][] ImportSettingsData() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("import_configuration.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "HelpLinkData")
	public static Object[][] HelpLinkData() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("help_link.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "SSPIDPLoginDiffDN")
	public static Object[][] CreateUserStoreDiffDN() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("add_ssl_certificate.json");
		jsonFileList.add("create_userstore_diffdn.json");
		jsonFileList.add("ssp_idp_login.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BVT_CreateUserStoreDiffDN")
	public static Object[][] BVT_CreateUserStoreDiffDN() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("bvt_add_ssl_certificate.json");
		jsonFileList.add("bvt_create_userstore_diffdn.json");
		jsonFileList.add("ssp_idp_login.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ImportSettingsDataWithPassword")
	public static Object[][] ImportSettingsDataWithPassword() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("import_configuration_password.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "VIPManagerIDPLoginDifferentFormat")
	public static Object[][] VIPManagerIDPLoginDifferentFormat() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("vip_mgr_idp_login_diff_format.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "VIPAdministratorConfigWithDiffDNUserStore")
	public static Object[][] VIPAdministratorConfigWithDiffDNUserStore() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("vipadministrator_config_userstore_diffDN.json");
		jsonFileList.add("create_userstore_diffdn.json");
		jsonFileList.add("add_ssl_certificate.json");
		jsonFileList.add("vip_mgr_idp_login.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BVT_VIPAdministratorConfigWithDiffDNUserStore")
	public static Object[][] BVT_VIPAdministratorConfigWithDiffDNUserStore() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("vipadministrator_config_userstore_diffDN.json");
		jsonFileList.add("bvt_create_userstore_diffdn.json");
		jsonFileList.add("bvt_add_ssl_certificate.json");
		jsonFileList.add("vip_mgr_idp_login.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "UpdateValidationServerUO")
	public static Object[][] UpdateValidationServerUO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("update_validationserver.json");
		jsonFileList.add("create_validationserver_uo.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "UpdateValidationServerUOL")
	public static Object[][] UpdateValidationServerUOL() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("update_validationserver_uol.json");
		jsonFileList.add("create_validationserver_uol.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "UpdateValidationServerULO")
	public static Object[][] UpdateValidationServerULO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("update_validationserver_ulo.json");
		jsonFileList.add("create_validationserver_ulo.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "UpdateValidationServerUPO")
	public static Object[][] UpdateValidationServerUPO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("update_validationserver_upo.json");
		jsonFileList.add("create_validationserver_upo.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "UpdateValidationServerULUO")
	public static Object[][] UpdateValidationServerULUO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("update_validationserver_uluo.json");
		jsonFileList.add("create_validationserver_uluo.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "UpdateValidationServerRadiusLDAPMappingUOL")
	public static Object[][] UpdateValidationServerRadiusLDAPMappingUOL() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("update_validationserver_radius_ldapmapping.json");
		jsonFileList.add("create_validationserver_uol.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "UpdateValidationServerRadiusLDAPMappingULO")
	public static Object[][] UpdateValidationServerRadiusLDAPMappingULO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("update_validationserver_radius_ldapmapping_ulo.json");
		jsonFileList.add("create_validationserver_ulo.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "DuplicateValidationServerWithUO")
	public static Object[][] DuplicateValidationServerWithUO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("duplicate_validation_server_uo.json");
		jsonFileList.add("create_validationserver_uo.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "DuplicateValidationServerWithUPO")
	public static Object[][] DuplicateValidationServerWithUPO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("duplicate_validation_server_upo.json");
		jsonFileList.add("create_validationserver_upo.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "DuplicateValidationServerWithULUO")
	public static Object[][] DuplicateValidationServerWithULUO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("duplicate_validation_server_uluo.json");
		jsonFileList.add("create_validationserver_uluo.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "DuplicateValidationServerWithUOL")
	public static Object[][] DuplicateValidationServerWithUOL() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("duplicate_validation_server_uol.json");
		jsonFileList.add("create_validationserver_uol.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "DuplicateValidationServerWithULO")
	public static Object[][] DuplicateValidationServerWithULO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("duplicate_validation_server_ulo.json");
		jsonFileList.add("create_validationserver_ulo.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "DuplicateValidationServerradiusToLDAPMappingUOL")
	public static Object[][] DuplicateValidationServerradiusToLDAPMappingUOL() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("create_validationserver_ulo.json");
		jsonFileList.add("update_validationserver_radius_ldapmapping.json");
		jsonFileList.add("duplicate_validation_server_radius_to_ldap.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "DuplicateValidationServerradiusToLDAPMappingULO")
	public static Object[][] DuplicateValidationServerradiusToLDAPMappingULO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("create_validationserver_ulo.json");
		jsonFileList.add("update_validationserver_radius_ldapmapping_ulo.json");
		jsonFileList.add("duplicate_validation_server_radius_to_ldap.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "DuplicateValidationServerradiusToLDAPMappingULUO")
	public static Object[][] DuplicateValidationServerradiusToLDAPMappingULUO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("create_validationserver_ulo.json");
		jsonFileList.add("update_validationserver_radius_ldapmapping_uluo.json");
		jsonFileList.add("duplicate_validation_server_radius_to_ldap.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "UOLValidationServerWithDifferentBindDNInUserstore")
	public static Object[][] UOLValidationServerWithDifferentBindDNInUserstore() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("create_validationserver_userstore_diffdn.json");
		jsonFileList.add("create_userstore_diffdn.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ULOValidationServerWithDifferentBindDNInUserstore")
	public static Object[][] ULOValidationServerWithDifferentBindDNInUserstore() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("create_validationserver_user_diffdn_ulo.json");
		jsonFileList.add("create_userstore_diffdn.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ConfigureConsoleAuthenticate")
	public static Object[][] ConfigureConsoleAuthenticate() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("configure_console_authentication.json");
		jsonFileList.add("create_userstore_diffdn.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BVT_ConfigureConsoleAuthenticate")
	public static Object[][] BVT_ConfigureConsoleAuthenticate() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("configure_console_authentication.json");
		jsonFileList.add("bvt_create_userstore_diffdn.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "AddVIPCertificate")
	public static Object[][] AddVIPCertificate() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("add_vip_certificate.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "AddSSLCertificate")
	public static Object[][] AddSSLCertificate() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("add_ssl_certificate.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BVT_AddSSLCertificate")
	public static Object[][] BVT_AddSSLCertificate() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("bvt_add_ssl_certificate.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ConsoleSettingHTTPSLogin")
	public static Object[][] ConsoleSettingHTTPSLogin() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("add_ssl_certificate.json");
		jsonFileList.add("console_https_login.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BVT_ConsoleSettingHTTPSLogin")
	public static Object[][] BVT_ConsoleSettingHTTPSLogin() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("bvt_add_ssl_certificate.json");
		jsonFileList.add("console_https_login.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "UpdateValidationServerAutoBCMode")
	public static Object[][] UpdateValidationServerAutoBCMode() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("create_validationserver_uo.json");
		jsonFileList.add("update_automatic_bcmode_validationserver.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "AddTunnelReceiverWithSSLCert")
	public static Object[][] AddTunnelReceiverWithSSLCert() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("add_ssl_certificate.json");
		jsonFileList.add("add_tunnel_receiver.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "AddTunnelForwarderWithSSLCert")
	public static Object[][] AddTunnelForwarderWithSSLCert() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("add_ssl_certificate.json");
		jsonFileList.add("add_tunnel_forwarder.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BVT_AddTunnelForwarderWithSSLCert")
	public static Object[][] BVT_AddTunnelForwarderWithSSLCert() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("bvt_add_ssl_certificate.json");
		jsonFileList.add("add_tunnel_forwarder.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "CreateUOValidationAndUOPushValidation")
	public static Object[][] CreateValidationServerUOWithPushWithDeviceValidaiton() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("create_validaiton_server_uo_with_push_and_validation.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "CreateUOValidationServerWithPush")
	public static Object[][] CreateValidationServerUOWithPush() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("create_validaiton_server_with_uo_push.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ValidationRequestsUO")
	public static Object[][] ValidationRequestsUO() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("uo_otp_validaton_tests.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "CreateValidaitonServerwithPushBoundaryTest")
	public static Object[][] CreateUOValidationServerWithPushBoundary() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("create_uo_validation_server_with_push_boundary.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "CreateValidaitonServerwithPushBoundaryTest1")
	public static Object[][] CreateUOValidationServerWithPushBoundary1() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("config_console_login.json");
		jsonFileList.add("config_console_login1.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "Test_SSPIDP_login_DiffFormat")
	public static Object[][] Test_SSPIDP_login_DiffFormat() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("add_ssl_certificate.json");
		jsonFileList.add("ssp_idp_diff_login_format.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "SSPIDPLoginWithoutSSL")
	public static Object[][] Test_SSPIDP_login_format() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("ssp_idp_diff_login_format_without_ssl.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "UpdateSettingsData")
	public static Object[][] UpdateSettingsData() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("update_settings.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BVTCeateUserStoreBasic")
	public static Object[][] BVTUserStoreCreate() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("bvt_create_userstore.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "CeateUserStoreBasic")
	public static Object[][] UserStoreCreate() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("create_userstore_basic.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BVTCreateValidationServerBasic")
	public static Object[][] BVTCreateValidationServer() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("bvt_create_validation_server.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "SystemSettingData")
	public static Object[][] SystemSettingData() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("system_setting.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "SysLogData")
	public static Object[][] SysLogData() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("sys_log.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "RegressionValidationTestsOnBasicServerUPO")
	public static Object[][] BasicValidaitonServerTestDataUPO() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_basic_server_upo.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "RegressionValidationTestsOnBasicServerULO")
	public static Object[][] BasicValidaitonServerTestDataULO() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_basic_server_ulo.json");
		return (retObjArr);
	}
	
	

	@org.testng.annotations.DataProvider(name = "RegressionValidationTestsOnBasicServerULOPUSH")
	public static Object[][] BasicValidaitonServerTestDataULOPUSH() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_basic_server_ulopush.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "RegressionValidationTestsOnBasicServerUOL")
	public static Object[][] BasicValidaitonServerTestDataUOL() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_basic_server_uol.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "RegressionValidationTestsOnBasicServerUOLPUSH")
	public static Object[][] BasicValidaitonServerTestDataUOLPUSH() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_basic_server_uolpush.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "RegressionValidationTestsOnBasicServerUO")
	public static Object[][] BasicValidaitonServerTestDataUO() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_basic_server_uo.json");
		return (retObjArr);
	}
	

	

	@org.testng.annotations.DataProvider(name = "RegressionValidationTestsOnBasicServerUOPUSH")
	public static Object[][] BasicValidaitonServerTestDataUOPUSH() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_basic_server_uopush.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "RegressionValidationTestsOnBasicServerULUO")
	public static Object[][] BasicValidaitonServerTestDataULUO() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_basic_server_uluo.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "LDAPToRadiusMappingULO")
	public static Object[][] RadiusToLDAPMappingULO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("r_validation_tests_with_ldap_to_rad_mapping.json");
		jsonFileList.add("r_validation_tests_on_ulo.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}
	
	@org.testng.annotations.DataProvider(name = "Test")
	public static Object[][] Test_Kesav() throws Exception {
		
		
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("1test.json");
		return (retObjArr);
	}
	
	/*@org.testng.annotations.DataProvider(name = "LDAPToRadiusMappingULO_kesav")
	public static Object[][] RadiusToLDAPMappingULO_kesav() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("test_kesav.json");
		jsonFileList.add("r_validation_tests_on_ulo.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}*/

	@org.testng.annotations.DataProvider(name = "LDAPToRadiusMappingUOL")
	public static Object[][] RadiusToLDAPMappingUOL() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("r_validation_tests_with_ldap_to_rad_mapping.json");
		jsonFileList.add("r_validation_tests_on_uol.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "LDAPToRadiusMappingULUO")
	public static Object[][] RadiusToLDAPMappingULUO() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("r_validation_tests_with_ldap_to_rad_mapping.json");
		jsonFileList.add("r_validation_tests_on_uluo.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "LDAPToRadiusMappingULOPush")
	public static Object[][] RadiusToLDAPMappingULOPush() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("r_validation_tests_with_ldap_to_rad_mapping.json");
		jsonFileList.add("r_validation_tests_on_ulopush.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "LDAPToRadiusMappingUOLPush")
	public static Object[][] RadiusToLDAPMappingUOLPush() throws Exception {
		ArrayList<String> jsonFileList = new ArrayList<String>();
		jsonFileList.add("r_validation_tests_with_ldap_to_rad_mapping.json");
		jsonFileList.add("r_validation_tests_on_uolpush.json");
		Object[][] retObjArr = csvReader.getHashMapFromMultipleJsonFile(jsonFileList);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BCModeTestDataOnULOValidationServer")
	public static Object[][] BCModeTestDataOnULOValidationServer() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_ulo_bc_enabled.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BCModeTestDataOnUOLValidationServer")
	public static Object[][] BCModeTestDataOnUOLValidationServer() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_uol_bc_enabled.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BCModeTestDataOnUOLPUSHValidationServer")
	public static Object[][] BCModeTestDataOnUOLPUSHValidationServer() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_uolpush_bc_enabled.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BCModeTestDataOnULOPUSHValidationServer")
	public static Object[][] BCModeTestDataOnULOPUSHValidationServer() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_ulopush_bc_enabled.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BCModeTestDataOnULUOValidationServer")
	public static Object[][] BCModeTestDataOnULUOValidationServer() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_uluo_bc_enabled.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BCModeTestDataOnUOValidationServer")
	public static Object[][] BCModeTestDataOnUOValidationServer() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_uo_bc_enabled.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BCModeTestDataOnUOPUSHValidationServer")
	public static Object[][] BCModeTestDataOnUOPUSHValidationServer() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_on_uopush_bc_enabled.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ValidationPerformanceTestData")
	public static Object[][] ValidationPerformanceTestData() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("p_performance_tests_on_validation_server.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "CreateUPOValidationServerWithPinReset")
	public static Object[][] CreateUPOValidationServerWithPinReset() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("create_validationserver_upo_pin_reset.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ValidationRequestUPOPINResetFlows")
	public static Object[][] ValidationRequestUPOPINResetFlows() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_pin_reset_on_upo.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "postImportUO")
	public static Object[][] postImportUO() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("post_import_uo_otp_all_validation_tests.json");
		// Object[][] retObjArr =
		// csvReader.getHashMapFromJsonFile("trialuobc.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "postImportUOPush")
	public static Object[][] postImportUOPush() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("post_import_uo_push_all_validation_tests.json");
		// Object[][] retObjArr =
		// csvReader.getHashMapFromJsonFile("trialuobc.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "postImportULO")
	public static Object[][] postImportULO() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("post_import_ulo_otp_all_validation_tests.json");
		// Object[][] retObjArr =
		// csvReader.getHashMapFromJsonFile("trialuobc.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "postImportULOPush")
	public static Object[][] postImportULOPush() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("post_import_ulo_push_all_validation_tests.json");
		// Object[][] retObjArr =
		// csvReader.getHashMapFromJsonFile("trialuobc.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "postImportUOL")
	public static Object[][] postImportUOL() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("post_import_uol_otp_all_validation_tests.json");
		// Object[][] retObjArr =
		// csvReader.getHashMapFromJsonFile("trialuobc.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "postImportULUO")
	public static Object[][] postImportULUO() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("post_import_uluo_otp_all_validation_tests.json");
		// Object[][] retObjArr =
		// csvReader.getHashMapFromJsonFile("trialuobc.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "postImportUAO")
	public static Object[][] postImportUAO() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("post_import_uao_otp_all_validation_tests.json");
		// Object[][] retObjArr =
		// csvReader.getHashMapFromJsonFile("trialuobc.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "postImportTunnelForwarderUO")
	public static Object[][] postImportTunnelForwarderUO() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("post_import_tunnel_forwarder_uo_all_validation_tests.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "createBasicApplicationAwareValidationServer")
	public static Object[][] createBasicApplicationAwareValidationServer() throws Exception {
		Object[][] retObjArr = csvReader.getTestDataFromApplicationTemplates("create_validaiton_server_application_aware.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "createApplicaitonServerWithDelegation")
	public static Object[][] createApplicationAwareValidationServerWithDelegation() throws Exception {
		HashMap<String, Boolean> condition = new HashMap<String, Boolean>();
		condition.put("delegation_supported", true);
		Object[][] retObjArr = csvReader.getFilteredDataFromApplicationTemplates("create_validaiton_server_application_aware_with_delegation.json", condition);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "createApplicaitonServerWithRLdapMapping")
	public static Object[][] createApplicationAwareValidationServerWithRLDAPMapping() throws Exception {
		HashMap<String, Boolean> condition = new HashMap<String, Boolean>();
		condition.put("radius_ldap_supported", true);
		Object[][] retObjArr = csvReader.getFilteredDataFromApplicationTemplates("create_validaiton_server_application_aware_with_rldap_mapping.json", condition);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "applicationAwareValidaitonServerSupportsChallenge")
	public static Object[][] ApplicationAwareValidationServerSupportsChallenge() throws Exception {
		HashMap<String, Boolean> condition = new HashMap<String, Boolean>();
		condition.put("challenge_supported", true);
		condition.put("radius_ldap_supported", true);
		Object[][] retObjArr = csvReader.getFilteredDataFromApplicationTemplates("create_validaiton_server_application_aware_challenge.json", condition);
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "PushAuthOnApplicaitonServers")
	public static Object[][] pushAuthOnApplicationServers() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("authentication_with_push_on_application_servers.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "PasswordResetOnApplicationServer")
	public static Object[][] passwordResetOnApplicationServers() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("password_reset_on_application_server.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "PinResetOnApplicationServer")
	public static Object[][] pinResetOnApplicationServers() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("pin_reset_on_application_server.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "passwordManagement")
	public static Object[][] dataForPasswordManagement() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("password_reset_on_application_server.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "createBasicApplicationTemplateUO_UPO_ULO")
	public static Object[][] createBasicApplicationTemplates() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("create_basic_uo_upo_ulo_application_template.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "InfoCall")
	public static Object[][] infoCall() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("infocall_tests.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "BCTests")
	public static Object[][] bcTests() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("application_aware_bc_tests.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "ValidationRequestUPOPINResetFlowsExtended")
	public static Object[][] ValidationRequestUPOPINResetFlowsExtended() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("r_validation_tests_pin_reset_on_upo_extended.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "SSPIDPPasswordReset")
	public static Object[][] SSPIDPPasswordReset() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("ssp_idp_password_reset.json");
		return (retObjArr);
	}

	@org.testng.annotations.DataProvider(name = "SSPIDPPasswordResetConfiguration")
	public static Object[][] SSPIDPPasswordResetConfig() throws Exception {
		Object[][] retObjArr = csvReader.getHashMapFromJsonFile("ssp_idp_password_reset_config.json");
		return (retObjArr);
	}
}
