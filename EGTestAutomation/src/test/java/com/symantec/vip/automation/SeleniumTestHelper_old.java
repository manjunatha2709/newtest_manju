package com.symantec.vip.automation;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.Assert;

import com.symantec.vip.automation.eg.pages.AddEditVIPUserGroupMappingPage;
import com.symantec.vip.automation.eg.pages.AddSSLCertificatePage;
import com.symantec.vip.automation.eg.pages.AddTunnelForwarderPage;
import com.symantec.vip.automation.eg.pages.AddTunnelReceiverPage;
import com.symantec.vip.automation.eg.pages.AddVIPCertificatePage;
import com.symantec.vip.automation.eg.pages.ConfigurationConsoleHomePage;
import com.symantec.vip.automation.eg.pages.ConfigurationConsoleLoginPage;
import com.symantec.vip.automation.eg.pages.ConfigurationSummaryPage;
import com.symantec.vip.automation.eg.pages.ConsoleAuthenticationConfigurationPage;
import com.symantec.vip.automation.eg.pages.ConsoleSettingsPage;
import com.symantec.vip.automation.eg.pages.DeleteUserStorePage;
import com.symantec.vip.automation.eg.pages.DuplicateValidationServerPage;
import com.symantec.vip.automation.eg.pages.EditUserStoreHomePage;
import com.symantec.vip.automation.eg.pages.ExportSettingsPage;
import com.symantec.vip.automation.eg.pages.FooterLinksDetailsPage;
import com.symantec.vip.automation.eg.pages.HTTPProxyPage;
import com.symantec.vip.automation.eg.pages.HelpPage;
import com.symantec.vip.automation.eg.pages.IdentityProvidersHomePage;
import com.symantec.vip.automation.eg.pages.ImportSettingsPage;
import com.symantec.vip.automation.eg.pages.LDAPDirectorySyncronizationConfigurationPage;
import com.symantec.vip.automation.eg.pages.LogsMainPage;
import com.symantec.vip.automation.eg.pages.PasswordManagementTabInUserStoreEditPage;
import com.symantec.vip.automation.eg.pages.ProductUpdateSettingsPage;
import com.symantec.vip.automation.eg.pages.RadiusToLDAPMappingConfigurationPage;
import com.symantec.vip.automation.eg.pages.SSLCertificateHomePage;
import com.symantec.vip.automation.eg.pages.SelfServicePortalIdPConfigurationPage;
import com.symantec.vip.automation.eg.pages.SelfServicePortalLoginPage;
import com.symantec.vip.automation.eg.pages.SettingsHomePage;
import com.symantec.vip.automation.eg.pages.SyslogConfigurationPage;
import com.symantec.vip.automation.eg.pages.SystemSettingsPage;
import com.symantec.vip.automation.eg.pages.TrustedCACertificatePage;
import com.symantec.vip.automation.eg.pages.TunnelServerHomePage;
import com.symantec.vip.automation.eg.pages.UpdateSettings;
import com.symantec.vip.automation.eg.pages.UserStoreConfigurationPage;
import com.symantec.vip.automation.eg.pages.UserStoreMainPage;
import com.symantec.vip.automation.eg.pages.VIPAdministratorConfigurationPage;
import com.symantec.vip.automation.eg.pages.VIPManagerIdpConfiguraionPage;
import com.symantec.vip.automation.eg.pages.VIPUserSettingsTabInUserStoreEditPage;
import com.symantec.vip.automation.eg.pages.ValidationMainPage;
import com.symantec.vip.automation.eg.pages.ValidationServerConfigurationPage;
import com.symantec.vip.automation.eg.pages.ValidationServerHomePage;
import com.symantec.vip.automation.eg.pages.ViewLogsArchivedLogsPage;
import com.symantec.vip.automation.eg.pages.ViewLogsCurrentLogsPage;
import com.symantec.vip.automation.eg.pages.ViewLogsHomePage;
import com.symantec.vip.automation.eg.pages.VipmgrIDPPortalLoginPage;
import com.symantec.vip.automation.eg.radius.TestBed;
import com.symantec.vip.automation.restapi.RestClient;
import com.symantec.vip.automation.utils.Helper;
import com.symantec.vip.automation.utils.SeleniumHelper;
import com.thoughtworks.selenium.Wait;

public class SeleniumTestHelper_old {
	ConfigurationConsoleHomePage Configuration_Console_Home_Page;
	ConfigurationConsoleLoginPage Configuration_Console_Login_Page;
	LDAPDirectorySyncronizationConfigurationPage LDAP_Sync_Config_Page;
	UserStoreMainPage UserStore_Main_Page;
	ConsoleAuthenticationConfigurationPage Console_Auth_Config_Page;
	VIPAdministratorConfigurationPage VIP_Admin_Config_Page;
	SettingsHomePage Settings_Home_Page;
	HTTPProxyPage HTTP_Proxy_Page;
	VIPManagerIdpConfiguraionPage VIP_Manager_Idp_Config_Page;
	IdentityProvidersHomePage IdP_Home_Page;
	SelfServicePortalIdPConfigurationPage SSP_Configuration_Page;
	UserStoreConfigurationPage UserStore_Config_Page;
	ConsoleSettingsPage Console_Settings_Page;
	ValidationServerConfigurationPage Validation_Server_Config_Page;
	ConfigurationSummaryPage Config_Summary_Page;
	SystemSettingsPage System_Settings_Page;
	ProductUpdateSettingsPage Product_Update_Settings_Page;
	ValidationServerHomePage Validation_Server_Home_Page;
	TrustedCACertificatePage Trusted_CA_Certificate_Page;
	PasswordManagementTabInUserStoreEditPage Password_Management_tab;
	EditUserStoreHomePage UserStore_Edit_Home_Page;
	VIPUserSettingsTabInUserStoreEditPage VIP_User_Settings_Tab;
	AddEditVIPUserGroupMappingPage VIP_User_Group_Mapping_Frame;
	RadiusToLDAPMappingConfigurationPage Radius_To_LDAP_Mapping_Frame;
	ValidationMainPage Validation_Main_Page;
	TunnelServerHomePage Tunnel_Server_Home_Page;
	AddTunnelReceiverPage Add_Tunnel_Receiver_Page;
	AddTunnelForwarderPage Add_Tunnel_Forwarder_Page;
	LogsMainPage Logs_Main_Page;
	SyslogConfigurationPage Syslog_Configuration_Page;
	ViewLogsArchivedLogsPage Archived_Logs_Page;
	ViewLogsCurrentLogsPage Current_Logs_Page;
	ViewLogsHomePage View_Logs_Home_Page;
	SSLCertificateHomePage SSL_Certificate_Home_Page;
	AddSSLCertificatePage Add_SSL_Certificate_Page;
	AddVIPCertificatePage Add_VIP_Certificate_Page;
	ExportSettingsPage Export_Settings_Page;
	ImportSettingsPage Import_Settings_Page;
	DeleteUserStorePage DeleteUserStore_Page;
	HelpPage Help_Page;
	DuplicateValidationServerPage Duplicate_Validation_Server_Page;
	SelfServicePortalLoginPage Self_ServicePortal_LoginPage;
	VipmgrIDPPortalLoginPage Vip_Mgr_IDPPortal_LoginPage;
	UpdateSettings Update_Settings_Page;
	SystemSettingsPage System_Setting_Page;
	FooterLinksDetailsPage Footer_Links_Details_Page;
	SeleniumHelper sHelper = new SeleniumHelper();
	public static Logger logger = TestBase.logger;
	Helper helper = new Helper();
	TestBed tBed = new TestBed();
	RestClient rClient = new RestClient();

	public void createValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		boolean expectedResult = Boolean.valueOf(config.get("expected_result_cv"));
		String mode = config.get("mode");
		String userStore = config.get("userstore_name");
		// boolean delegation =
		// Boolean.valueOf(config.get("delegation_status"));
		// String delegationServer = config.get("delegation_host");
		String serverName = config.get("validation_server_name");
		String valServerHost = config.get("validation_server_host");
		String pushTimeOut = config.get("push_timeout");
		String pushRemoteServiceName = config.get("remote_service_name");
		String bc = config.get("bc_mode");
		String port = config.get("server_port");
		boolean pinReset = Boolean.valueOf(config.get("enable_pin_reset"));
		String loggingLevel = config.get("log_level");
		String radiusSharedSecret = config.get("validation_server_shared_secret");
		String radiusConfirmSharedSecret = config.get("confirm_rad_shared");
		boolean useLDAPUserName = Boolean.valueOf(config.get("use_ldap_username"));
		boolean userUserStoreOOB = Boolean.valueOf(config.get("use_userstore_oob"));
		// String expectedMessage =
		// "Validation server created with server name " + serverName;
		String expectedMessage = "successfully. Start the server when required.";
		String vendor = config.get("vendor");
		String applicationName = config.get("application_name");
		WebDriverWait wt = new WebDriverWait(driver, 20);
		// String radiusMapAttribute = config.get("radius_map_attribute");
		// String vendorId = config.get("vendor_id");
		// String vendorAttributeType = config.get("vendor_attribute_type");
		// String vendorAttributeId = config.get("vendor_attribute_id");
		// String ldapRadiusVendorOther =
		// config.get("ldap_radius_vendor_other");
		// String ldapMappingAttribute = config.get("ldap_mapping_attribute");
		// boolean includeSecondaryQuery =
		// Boolean.valueOf(config.get("include_secondary_query"));
		// String testUserName = config.get("test_user_name");
		// String secondaryFilter = config.get("secondary_filter");
		// String secondaryBaseDN = config.get("secondary_basedn");
		// String searchAttribute = config.get("search_attribute");
		// boolean enableRadiusToLDAPMapping =
		// Boolean.valueOf(config.get("enable-radius-ldap-mapping"));
		String actualMessage = null;
		boolean result = false;
		this.DeleteValidaitonServer(driver, serverName);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		Radius_To_LDAP_Mapping_Frame = PageFactory.initElements(driver, RadiusToLDAPMappingConfigurationPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		// Configuration_Console_Home_Page = PageFactory.initElements(driver,
		// ConfigurationConsoleHomePage.class);
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		boolean customConfiguration = true;
		if (vendor != null) {
			customConfiguration = false;
		}
		Configuration_Console_Home_Page.Validation_Tab.click();
		Thread.sleep(1000);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Add Server button");
		Validation_Server_Home_Page.Add_Server_Button.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to Add Server window.");
		wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.AddServer_Frame));
		driver.switchTo().activeElement();
		if (!customConfiguration) {
			wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.VendorName_SelectBox));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting application aware validation details");
			Thread.sleep(1000);
			Select dropdownVendor = new Select(Validation_Server_Config_Page.VendorName_SelectBox);
			List<WebElement> optionsVendor = dropdownVendor.getOptions();
			for (WebElement optionVendor : optionsVendor) {
				// logger.info("Vendor name is " + optionVendor.getText() +
				// " and matching with test data " + vendor);
				if (optionVendor.getText().trim().equalsIgnoreCase(vendor)) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting vendor to " + vendor.toUpperCase());
					optionVendor.click();
					break;
				}
			}
			Thread.sleep(1000);
			Select dropdownApplicationName = new Select(Validation_Server_Config_Page.ApplicationName_SelectBox);
			System.out.println("Selecting Application Name");
			List<WebElement> optionsApplicationName = dropdownApplicationName.getOptions();
			for (WebElement optionApplicationName : optionsApplicationName) {
				// logger.info("Application name is " +
				// optionApplicationName.getText() +
				// " and matching with test data " + applicationName);
				if (optionApplicationName.getText().trim().equalsIgnoreCase(applicationName)) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting ApplicationName to " + applicationName.toUpperCase());
					optionApplicationName.click();
					break;
				}
			}
			Thread.sleep(1000);
			Select dropdownAuthType = new Select(Validation_Server_Config_Page.Auth_Type_SelectBox);
			List<WebElement> optionsAuthType = dropdownAuthType.getOptions();
			for (WebElement optionAuthType : optionsAuthType) {
				// logger.info("Authentication Type is " +
				// optionAuthType.getText() + " and matching with test data " +
				// config.get("mode_keyword"));
				if (optionAuthType.getText().trim().equalsIgnoreCase(config.get("mode_keyword"))) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting AuthType to " + config.get("mode_keyword"));
					optionAuthType.click();
					break;
				}
			}
			Validation_Server_Config_Page.Continue_Button_On_Add_Server_Wizard.click();
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to Custom mode.");
			Validation_Server_Config_Page.Custom_Configuration_Link.click();
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to configuration page.");
		driver.switchTo().defaultContent();
		wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.ServerName_TextBox));
		if (!customConfiguration) {
			if (config.get("show_advanced_settings") != null) {
				if (config.get("show_advanced_settings").equalsIgnoreCase("true")) {
					Validation_Server_Config_Page.Show_Advanced_Settings_Link.click();
				}
			}
		}
		if (customConfiguration) {
			boolean isFistFactorEnabled = Boolean.valueOf(Validation_Server_Config_Page.Enable_FirstFactor_Checkbox.getAttribute("checked"));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "First Factor enable status is " + isFistFactorEnabled);
			switch (mode) {
			case "uo": {
				if (isFistFactorEnabled) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Unchecking First Factor selection box");
					Validation_Server_Config_Page.Enable_FirstFactor_Checkbox.click();
				}
				break;
			}
			case "upo": {
				if (!isFistFactorEnabled) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enabling first factor checkbox");
					Validation_Server_Config_Page.Enable_FirstFactor_Checkbox.click();
				}
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting UPO mode ");
				wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.FirstFactor_VIPServices_RadioButton));
				Validation_Server_Config_Page.FirstFactor_VIPServices_RadioButton.click();
				break;
			}
			case "ulo": {
				if (!isFistFactorEnabled) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enabling first factor checkbox");
					Validation_Server_Config_Page.Enable_FirstFactor_Checkbox.click();
				}
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting ULO mode ");
				wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.FirstFactor_Enterprise_RadioButton));
				Validation_Server_Config_Page.FirstFactor_Enterprise_RadioButton.click();
				break;
			}
			case "ulopush": {
				if (!isFistFactorEnabled) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enabling first factor checkbox");
					Validation_Server_Config_Page.Enable_FirstFactor_Checkbox.click();
				}
				wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.FirstFactor_Enterprise_RadioButton));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting ULO Push mode ");
				Validation_Server_Config_Page.FirstFactor_Enterprise_RadioButton.click();
				break;
			}
			case "uol": {
				if (!isFistFactorEnabled) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enabling first factor checkbox");
					Validation_Server_Config_Page.Enable_FirstFactor_Checkbox.click();
				}
				wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.FirstFactor_Enterprise_RadioButton));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting UOL mode ");
				Validation_Server_Config_Page.FirstFactor_Enterprise_RadioButton.click();
				break;
			}
			case "uolpush": {
				if (!isFistFactorEnabled) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enabling first factor checkbox");
					Validation_Server_Config_Page.Enable_FirstFactor_Checkbox.click();
				}
				wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.FirstFactor_Enterprise_RadioButton));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting UOL Push mode ");
				Validation_Server_Config_Page.FirstFactor_Enterprise_RadioButton.click();
				break;
			}
			case "uluo": {
				if (!isFistFactorEnabled) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enabling first factor checkbox");
					Validation_Server_Config_Page.Enable_FirstFactor_Checkbox.click();
				}
				wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.FirstFactor_Enterprise_RadioButton));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting ULUO mode ");
				Validation_Server_Config_Page.FirstFactor_Enterprise_RadioButton.click();
				break;
			}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate server name as " + serverName);
		if (serverName != null) {
			Validation_Server_Config_Page.ServerName_TextBox.sendKeys(serverName);
		}
		// Selecting local IP
		Select localIPDropDown = new Select(Validation_Server_Config_Page.Local_IP_SelectBox);
		List<WebElement> optionslocalIPDropDown = localIPDropDown.getOptions();
		for (WebElement option2 : optionslocalIPDropDown) {
			logger.info("Setting local IP as " + valServerHost);
			logger.info("Got IP " + option2.getText() + " from drop down list ");
			if (option2.getText().equalsIgnoreCase(valServerHost)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing logging level to " + valServerHost);
				option2.click();
				break;
			}
		}
		// Selecting port
		if (port != null) {
			Validation_Server_Config_Page.Port_TextBox.clear();
			Validation_Server_Config_Page.Port_TextBox.sendKeys(port);
		}
		if (mode != null) {
			if (!mode.equalsIgnoreCase("upo")) {
				if (bc != null) {
					switch (bc) {
					case "enabled":
						Validation_Server_Config_Page.BusinessContinuity_Enabled_RadioButton.click();
						break;
					case "disabled":
						Validation_Server_Config_Page.BusinessContinuity_Disabled_RadioButton.click();
						break;
					case "auto":
						Validation_Server_Config_Page.BusinessContinuity_Automatic_RadioButton.click();
						break;
					case "notify":
						Validation_Server_Config_Page.BusinessContinuity_Notify_Only_RadioButton.click();
						break;
					}
				}
			}
		}
		if (loggingLevel != null) {
			Select dropdown = new Select(Validation_Server_Config_Page.Logging_Level_SelectBox);
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).equalsIgnoreCase(loggingLevel.toLowerCase())) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing logging level to " + loggingLevel.toUpperCase());
					option.click();
					break;
				}
			}
		}
		if (radiusSharedSecret != null) {
			Validation_Server_Config_Page.RadiusSharedSecret_TextBox.sendKeys(radiusSharedSecret);
		}
		if (radiusConfirmSharedSecret != null) {
			Validation_Server_Config_Page.Confirm_RadiusSharedSecret_TextBox.sendKeys(radiusConfirmSharedSecret);
		}
		setUseUserStoreAndEnableOOBOptionInValidationServer(config, driver);
		// if (mode != null) {
		// if (mode.equalsIgnoreCase("uo") || mode.equalsIgnoreCase("upo")) {
		// if (useLDAPUserName) {
		// if
		// (!Boolean.valueOf(Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.getAttribute("checked")))
		// {
		// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
		// "User recides in user store is NOT CHECKED. So enabling the option.");
		// Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.click();
		// Thread.sleep(1000);
		// }
		// if (userUserStoreOOB) {
		// Validation_Server_Config_Page.Use_UserStore_Data_For_OOB_CheckBox.click();
		// }
		// }
		// } else {
		// if (userUserStoreOOB) {
		// Validation_Server_Config_Page.Use_UserStore_Data_For_OOB_CheckBox.click();
		// }
		// }
		// }
		if (pushTimeOut != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting push timeout as " + pushTimeOut);
			Validation_Server_Config_Page.TextBox_Push_TimeOut.clear();
			Validation_Server_Config_Page.TextBox_Push_TimeOut.sendKeys(pushTimeOut);
		}
		if (pushRemoteServiceName != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting push remote service name " + pushRemoteServiceName);
			Validation_Server_Config_Page.TextBox_Push_RemoteAccessServiceURL.clear();
			Validation_Server_Config_Page.TextBox_Push_RemoteAccessServiceURL.sendKeys(pushRemoteServiceName);
		}
		setSpecificUserstoreInValidationServer(config, driver);
		setDelegationInValidationServer(config, driver);
		setRadiusToLdapMappingInValidationServer(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on submit button");
		//Validation_Server_Config_Page.Submit_Button.click();
		driver.findElement(By.name("submitButton")).sendKeys(Keys.RETURN);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicked on submit button");
		actualMessage = Validation_Server_Config_Page.Message_on_page.getText();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Submit message was " + actualMessage);
		if (expectedResult == true || expectedResult == false) {
			result = actualMessage.trim().contains(expectedMessage);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expectedResult + "| | Actual result:" + result + " | | Test case status :"
					+ (expectedResult == result ? "Pass" : "Fail") + " |");
			Assert.assertEquals(result, expectedResult, actualMessage + ": Expected Message was: " + expectedMessage + ":");
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected Message was: " + expectedMessage + "| | Actual message:" + expectedMessage + " | | Test case status :"
					+ (expectedMessage.equalsIgnoreCase(actualMessage) ? "Pass" : "Fail") + " |");
			Assert.assertTrue(actualMessage.trim().contains(expectedMessage));
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void ConfigConsoleBasicLogin(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String login_protocol = config.get("login_protocol");
		String login_port = config.get("login_port");
		String sUsername = config.get("login_username");
		String sPassword = config.get("login_password");
		String server = config.get("eg_server_host");
		boolean isHTTPS = Boolean.valueOf(config.get("is_https_console"));
		// String hostName = config.get("ssl_hostname");
		int counter = 0;
		int maxRetry = 5;
		String loginURL;
		// driver.switchTo().alert().accept();
		if (isHTTPS) {
			loginURL = "https://" + server + ":8232/";
		} else {
			loginURL = sHelper.MakeURL(login_protocol, server, login_port);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Login username is : " + sUsername);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Login password is : " + sPassword);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Login url is : " + loginURL);
		Configuration_Console_Login_Page = PageFactory.initElements(driver, ConfigurationConsoleLoginPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(loginURL);
		while (counter <= maxRetry) {
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.UserName_TextBox) || sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link))
				break;
			else {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Refreshing the page. Tries : " + (counter + 1));
				counter++;
				// driver.get(driver.getCurrentUrl());
				driver.get(loginURL);
			}
			if (counter == maxRetry) {
				loginURL = "https://" + server + ":8232/";
				driver.get(loginURL);
			}
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.UserName_TextBox)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Invoking Configuration Console login flow");
			Configuration_Console_Login_Page.UserName_TextBox.sendKeys(sUsername);
			Configuration_Console_Login_Page.Password_TextBox.sendKeys(sPassword);
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Login_Auth_Type_SelectBox)) {
				Select dropdown = new Select(Configuration_Console_Login_Page.Login_Auth_Type_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).equalsIgnoreCase("Local Administrator")) {
						option.click();
						break;
					}
				}
			}
			Configuration_Console_Login_Page.Submit_Button.click();
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button)) {
				Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button.click();
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + " Test case status :" + (sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link) ? "Pass" : "Fail"));
			Assert.assertTrue(sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link));
		} else if (sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Already logged in to Configuration Console");
			Assert.assertTrue(true);
		}
		config.put("is_https_console", "false");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void ConfigConsoleLoginWithSignOut(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String login_protocol = config.get("login_protocol");
		String login_port = config.get("login_port");
		String server = config.get("eg_server_host");
		String loginURL = sHelper.MakeURL(login_protocol, server, login_port);
		Configuration_Console_Login_Page = PageFactory.initElements(driver, ConfigurationConsoleLoginPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String adminName = config.get("admin_name");
		String adminPassword = config.get("admin_password");
		boolean result = false;
		boolean expectedResult = Boolean.valueOf(config.get("expected_result"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(loginURL);
		int counter = 0;
		int maxRetry = 3;
		while (counter <= maxRetry) {
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.UserName_TextBox) || sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link))
				break;
			else {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Refreshing the page. Tries : " + (counter + 1));
				counter++;
				driver.get(driver.getCurrentUrl());
			}
			if (counter == maxRetry) {
				loginURL = "https://" + server + ":8232/";
				driver.get(loginURL);
			}
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.UserName_TextBox)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Invoking Configuration Console login flow");
			Configuration_Console_Login_Page.UserName_TextBox.sendKeys(adminName);
			Configuration_Console_Login_Page.Password_TextBox.sendKeys(adminPassword);
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Login_Auth_Type_SelectBox)) {
				Select dropdown = new Select(Configuration_Console_Login_Page.Login_Auth_Type_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).equalsIgnoreCase("Local Administrator")) {
						option.click();
						break;
					}
				}
			}
			Configuration_Console_Login_Page.Submit_Button.click();
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button)) {
				Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button.click();
			}
		} else if (sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link)) {
			Configuration_Console_Home_Page.SignOut_Link.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Already logged in. Invoking signout.");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Invoking Configuration Console login flow");
			Configuration_Console_Login_Page.UserName_TextBox.sendKeys(adminName);
			Configuration_Console_Login_Page.Password_TextBox.sendKeys(adminPassword);
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Login_Auth_Type_SelectBox)) {
				Select dropdown = new Select(Configuration_Console_Login_Page.Login_Auth_Type_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).equalsIgnoreCase("Local Administrator")) {
						option.click();
						break;
					}
				}
			}
			Configuration_Console_Login_Page.Submit_Button.click();
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button)) {
				Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button.click();
			}
		}
		result = sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Username was " + adminName);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Password was " + adminPassword);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expectedResult + "| | Actual result:" + result + " | | Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail") + " |");
		Assert.assertEquals(result, expectedResult);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void AddVIPCertificate_FirstTime(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Add_VIP_Certificate_Page = PageFactory.initElements(driver, AddVIPCertificatePage.class);
		Settings_Home_Page = PageFactory.initElements(driver, SettingsHomePage.class);
		Config_Summary_Page = PageFactory.initElements(driver, ConfigurationSummaryPage.class);
		// driver.get("http://www.google.com");
		String vip_certificate_path = config.get("vip_certificate_path");
		String vip_certficate_password = config.get("vip_certificate_password");
		String confirm_text = "VIP certificate was successfully imported";
		String aliasName = "vipcert";// config.get("alias_name");
		String vip_cert_subject_dn = "vip_cert_automation";
		final String BROWSE_BUTTON_ADD_VIP_CERT_PAGE_NAME = "pkcsFile";
		final String PASSWORD_TEXTBOX_NAME = "pkcsPassword";
		final String SUBMIT_BUTTON_NAME = "method:doIt";// "sbtbtn";
		boolean vipCertAdded = false;
		final String submitMessage = ".//*[@id='errors-inpage']/div/div";// "/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[2]";
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking for visibility of vip cert section in home page");
		if (!Config_Summary_Page.Section_VIPCertificate.isDisplayed()) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking add vip button");
			Config_Summary_Page.Button_AddVIPCertificate.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Sending keys for cert path for " + config.get("selected_env").toUpperCase());
			driver.findElement(By.name(BROWSE_BUTTON_ADD_VIP_CERT_PAGE_NAME)).sendKeys(vip_certificate_path + "/" + config.get("selected_env") + "_vip_cert.p12");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "password: " + vip_certficate_password);
			driver.findElement(By.name(PASSWORD_TEXTBOX_NAME)).sendKeys(vip_certficate_password);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Alias name : " + aliasName);
			Add_VIP_Certificate_Page.Alias_Field.sendKeys(aliasName);
			System.out.println("password: " + vip_certficate_password);
			WebElement element_submit = driver.findElement(By.name(SUBMIT_BUTTON_NAME));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking submity button");
			element_submit.click();
			String import_certficicate_text = driver.findElement(By.xpath(submitMessage)).getText();
			System.out.println("cert path: " + vip_certificate_path + "/" + config.get("selected_env") + "_vip_cert.p12" + "---------validation path erro:" + import_certficicate_text
					+ "  ***comparing error:" + confirm_text);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + " Test case status :" + (import_certficicate_text.contains(confirm_text) ? "Pass" : "Fail"));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			vipCertAdded = true;
			System.out.println("Vip cert addedd succssfully "); // kesav 

			Assert.assertTrue(import_certficicate_text.contains(confirm_text), "Add vip certificate failed.");
			tBed.ConfigureJettyForCodeCoverage(config);
		} else if (Config_Summary_Page.VIPCert_Subject_DN_ReadOnlyField.getText().contains(vip_cert_subject_dn)
				|| Config_Summary_Page.VIPCert_Subject_DN_ReadOnlyField.getText().contains("VIPEGAutomation")) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Cert subject DN : " + Config_Summary_Page.VIPCert_Subject_DN_ReadOnlyField.getText());
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "certificate already present");
			vipCertAdded = true;
			Assert.assertTrue(true);
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Couldnot find vip certificate section nor certificate subject dn elements.");
			Assert.assertTrue(false, "Couldnot find vip certificate section nor certificate subject dn elements.");
		}
		if (vipCertAdded) {
			tBed.changeAuthURL(config);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void AddVIPCertificate(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Add_VIP_Certificate_Page = PageFactory.initElements(driver, AddVIPCertificatePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		Config_Summary_Page = PageFactory.initElements(driver, ConfigurationSummaryPage.class);
		// driver.get("http://www.google.com");
		String vip_certificate_path = config.get("vip_certificate_path");
		String vip_certficate_password = config.get("vip_certificate_password");
		String confirm_text = "VIP certificate was successfully imported";
		String aliasName = config.get("alias_name");
		String testName = config.get("test_name");
		WebDriverWait wt = new WebDriverWait(driver, 15);
		final String BROWSE_BUTTON_ADD_VIP_CERT_PAGE_NAME = "pkcsFile";
		final String PASSWORD_TEXTBOX_NAME = "pkcsPassword";
		final String SUBMIT_BUTTON_NAME = "method:doIt";// "sbtbtn";
		final String VALIDATATION_IMPORT_XPATH = "/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div/div";// "/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[2]";
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "***** Test Run description: " + testName + "  *********");
		if (!sHelper.isElementPresent(driver, Config_Summary_Page.Button_AddVIPCertificate)) {
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
			Configuration_Console_Home_Page.Settings_Tab.click();
			Add_VIP_Certificate_Page.VIPCertificate_link.click();
			wt.until(ExpectedConditions.elementToBeClickable(Add_VIP_Certificate_Page.Button_AddVIPCertificate));
			Add_VIP_Certificate_Page.Button_AddVIPCertificate.click();
			driver.findElement(By.name(BROWSE_BUTTON_ADD_VIP_CERT_PAGE_NAME)).sendKeys(vip_certificate_path);
			
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + " Clicking Sumbmit button :"  );
			driver.findElement(By.name(PASSWORD_TEXTBOX_NAME)).sendKeys(vip_certficate_password);
			Add_VIP_Certificate_Page.Alias_Field.sendKeys(aliasName);
			System.out.println("password: " + vip_certficate_password);
			WebElement element_submit = driver.findElement(By.name(SUBMIT_BUTTON_NAME));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + " Clicking Sumbmit button :" );
			element_submit.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + " Clicked Sumbmit button :" );
			String import_certficicate_text = driver.findElement(By.xpath(VALIDATATION_IMPORT_XPATH)).getText();
			System.out.println("cert path: " + vip_certificate_path + "  ---------Success message from page :" + import_certficicate_text + "  ***Expected message :" + confirm_text);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + " Test case status :" + (import_certficicate_text.contains(confirm_text) ? "Pass" : "Fail"));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
			Assert.assertTrue(import_certficicate_text.contains(confirm_text), "Adding VIP certificate fails.");
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Couldnot find vip certificate section nor certificate subject dn elements.");
			Assert.assertTrue(false, "Couldnot find vip certificate section nor certificate subject dn elements.");
		}
	}

	public void CheckVIPCertAdded(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Add_VIP_Certificate_Page = PageFactory.initElements(driver, AddVIPCertificatePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		// driver.get("http://www.google.com");
		// String vip_certificate_path = config.get("vip_certificate_path");
		// String vip_certficate_password =
		// config.get("vip_certificate_password");
		// String confirm_text = "VIP certificate was successfully imported";
		String aliasName = config.get("alias_name");
		String cnName = config.get("cn_name");
		String validFromDate = config.get("valid_from_date");
		String validTillDate = config.get("valid_till_date");
		int noOfRows;
		boolean pagination, certFound = false;
		List<WebElement> listOfServers;
		WebDriverWait wt = new WebDriverWait(driver, 20);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Settings_Tab.click();
		Add_VIP_Certificate_Page.VIPCertificate_link.click();
		wt.until(ExpectedConditions.elementToBeClickable(Add_VIP_Certificate_Page.Button_AddVIPCertificate));
		listOfServers = Add_VIP_Certificate_Page.CertificatesList_Table;
		noOfRows = listOfServers.size();
		String state = Add_VIP_Certificate_Page.Pagination_Table.getAttribute("class");
		if (state.contains("disabled")) {
			pagination = false;
		} else {
			pagination = true;
		}
		for (int j = 1; j <= 10; j++) {
			if (pagination) {
				Add_VIP_Certificate_Page.PageNo_TextBox.clear();
				Add_VIP_Certificate_Page.PageNo_TextBox.sendKeys(Integer.toString(j));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Navigating to validation server page " + Integer.toString(j) + " to restart the validation server");
				Add_VIP_Certificate_Page.PageNo_TextBox.sendKeys(Keys.RETURN);
			}
			listOfServers = Add_VIP_Certificate_Page.CertificatesList_Table;
			noOfRows = listOfServers.size();
			for (int i = 2; i <= noOfRows; i++) {
				String cert_name = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[1]/a")).getText();
				if (cert_name.equalsIgnoreCase(aliasName)) {
					certFound = true;
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Certificate found " + aliasName);
					if (cnName != null) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "cn name : "
								+ driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[2]")).getText());
						Assert.assertTrue(driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[2]")).getText().contains(cnName), "CN Name mismatch");
					}
					if (validFromDate != null) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "valid from date: "
								+ driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[3]")).getText());
						Assert.assertTrue(driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[3]")).getText().contains(validFromDate), "Valid from date mismatch");
					}
					if (validTillDate != null) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "valid till date: "
								+ driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[4]")).getText());
						Assert.assertTrue(driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[4]")).getText().contains(validTillDate), "Valid till date mismatch");
					}
					break;
				}
			}
			if (certFound) {
				break;
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "*** Checking done ***");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void DeleteVIPCertificate(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Add_VIP_Certificate_Page = PageFactory.initElements(driver, AddVIPCertificatePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		// driver.get("http://www.google.com");
		String confirm_text = "has been deleted";
		String aliasName = config.get("alias_name");
		int noOfRows;
		boolean pagination, certFound = false;
		List<WebElement> listOfServers;
		WebDriverWait wt = new WebDriverWait(driver, 20);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Settings_Tab.click();
		Add_VIP_Certificate_Page.VIPCertificate_link.click();
		wt.until(ExpectedConditions.elementToBeClickable(Add_VIP_Certificate_Page.Button_AddVIPCertificate));
		listOfServers = Add_VIP_Certificate_Page.CertificatesList_Table;
		noOfRows = listOfServers.size();
		String state = Add_VIP_Certificate_Page.Pagination_Table.getAttribute("class");
		if (state.contains("disabled")) {
			pagination = false;
		} else {
			pagination = true;
		}
		for (int j = 1; j <= 10; j++) {
			if (pagination) {
				Add_VIP_Certificate_Page.PageNo_TextBox.clear();
				Add_VIP_Certificate_Page.PageNo_TextBox.sendKeys(Integer.toString(j));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Navigating to validation server page " + Integer.toString(j) + " to restart the validation server");
				Add_VIP_Certificate_Page.PageNo_TextBox.sendKeys(Keys.RETURN);
			}
			listOfServers = Add_VIP_Certificate_Page.CertificatesList_Table;
			noOfRows = listOfServers.size();
			for (int i = 2; i <= noOfRows; i++) {
				String cert_name = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[1]/a")).getText();
				if (cert_name.equalsIgnoreCase(aliasName)) {
					certFound = true;
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Certificate found " + aliasName);
					driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[6]/a[text()='Delete']")).click();
					Alert alert = wt.until(ExpectedConditions.alertIsPresent());
					// Accepting alert.
					alert.accept();
					System.out.println("Accepted the alert successfully.");
					break;
				}
			}
			if (certFound) {
				Assert.assertTrue(Add_VIP_Certificate_Page.Message_on_page.getText().contains(confirm_text), "Deletion of certificate " + aliasName + " failed");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Deletion successfull");
				break;
			}
		}
		if (!certFound) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Certificate with alias name " + aliasName + " not found");
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void ImportSSLCertificate(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		final String saveSuccessMessage = "SSL certificate was successfully imported";
		boolean certFound = false;
		int noOfRows;
		boolean pagination;
		List<WebElement> listOfServers;
		Add_SSL_Certificate_Page = PageFactory.initElements(driver, AddSSLCertificatePage.class);
		SSL_Certificate_Home_Page = PageFactory.initElements(driver, SSLCertificateHomePage.class);
		Settings_Home_Page = PageFactory.initElements(driver, SettingsHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String certPath = config.get("ssl_certificate_path");
		String certPassword = config.get("ssl_certificate_password");
		String aliasName = config.get("alias_name");
		String testName = config.get("test_name");
		WebDriverWait wt = new WebDriverWait(driver, 30);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Test description : " + testName);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Setting tab");
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Settings_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on SSL Certificate tab");
		Settings_Home_Page.SSL_Certificate_Tab.click();
		// wt.until(ExpectedConditions.visibilityOf(SSL_Certificate_Home_Page.Button_AddSSLCerificate));
		// Thread.sleep(4000);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking whether the certificate " + aliasName + " is present");
		if (sHelper.isElementPresent(driver, SSL_Certificate_Home_Page.Certificate_Table)) {
			listOfServers = SSL_Certificate_Home_Page.CertificatesList_Table;
			noOfRows = listOfServers.size();
			String state = SSL_Certificate_Home_Page.Pagination_Table.getAttribute("class");
			if (state.contains("disabled")) {
				pagination = false;
			} else {
				pagination = true;
			}
			for (int j = 1; j <= 10; j++) {
				if (pagination) {
					SSL_Certificate_Home_Page.PageNo_TextBox.clear();
					SSL_Certificate_Home_Page.PageNo_TextBox.sendKeys(Integer.toString(j));
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Navigating to validation server page " + Integer.toString(j) + " to restart the validation server");
					SSL_Certificate_Home_Page.PageNo_TextBox.sendKeys(Keys.RETURN);
				}
				listOfServers = SSL_Certificate_Home_Page.CertificatesList_Table;
				noOfRows = listOfServers.size();
				for (int i = 2; i <= noOfRows; i++) {
					String cert_name = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[1]/a")).getText();
					if (cert_name.equalsIgnoreCase(aliasName)) {
						certFound = true;
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Certificate found " + aliasName);
						break;
					}
				}
				if (certFound) {
					break;
				}
			}
		}
		if (!certFound) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Add SSL Certificate button");
			SSL_Certificate_Home_Page.Button_AddSSLCerificate.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Waiting for import ssl certificate radio button.");
			wt.until(ExpectedConditions.visibilityOf(Add_SSL_Certificate_Page.RadioButton_ImportSSLCerificate));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting import cert option");
			wt.until(ExpectedConditions.visibilityOf(Add_SSL_Certificate_Page.RadioButton_ImportSSLCerificate));
			Add_SSL_Certificate_Page.RadioButton_ImportSSLCerificate.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "selected Import button");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting cert details");
			Add_SSL_Certificate_Page.BrowseButton_SSLCertFileName.sendKeys(certPath);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "cert path" + certPath);
			Add_SSL_Certificate_Page.TextBox_Password.sendKeys(certPassword);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "cert password" + certPassword);
			Add_SSL_Certificate_Page.AliasName_TextBox.sendKeys(aliasName);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "cert password" + certPassword);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting submit option");
			Add_SSL_Certificate_Page.Button_Submit.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "cert password" + aliasName);
			String actualMessage = SSL_Certificate_Home_Page.MessageElement.getText();
			Assert.assertTrue(actualMessage.contains(saveSuccessMessage), "Expected message:" + saveSuccessMessage + ". Actual Message:" + actualMessage);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + actualMessage);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void CheckSSLCertAdded(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Add_SSL_Certificate_Page = PageFactory.initElements(driver, AddSSLCertificatePage.class);
		SSL_Certificate_Home_Page = PageFactory.initElements(driver, SSLCertificateHomePage.class);
		Settings_Home_Page = PageFactory.initElements(driver, SettingsHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		// driver.get("http://www.google.com");
		String aliasName = config.get("alias_name");
		String cnName = config.get("cn_name");
		String validFromDate = config.get("valid_from_date");
		String validTillDate = config.get("valid_till_date");
		int noOfRows;
		boolean pagination, certFound = false;
		List<WebElement> listOfServers;
		WebDriverWait wt = new WebDriverWait(driver, 20);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Setting tab");
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Settings_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on SSL Certificate tab");
		Settings_Home_Page.SSL_Certificate_Tab.click();
		if (sHelper.isElementPresent(driver, SSL_Certificate_Home_Page.Certificate_Table)) {
			wt.until(ExpectedConditions.elementToBeClickable(SSL_Certificate_Home_Page.Button_AddSSLCerificate));
			listOfServers = SSL_Certificate_Home_Page.CertificatesList_Table;
			noOfRows = listOfServers.size();
			String state = SSL_Certificate_Home_Page.Pagination_Table.getAttribute("class");
			if (state.contains("disabled")) {
				pagination = false;
			} else {
				pagination = true;
			}
			for (int j = 1; j <= 10; j++) {
				if (pagination) {
					SSL_Certificate_Home_Page.PageNo_TextBox.clear();
					SSL_Certificate_Home_Page.PageNo_TextBox.sendKeys(Integer.toString(j));
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Navigating to validation server page " + Integer.toString(j) + " to restart the validation server");
					SSL_Certificate_Home_Page.PageNo_TextBox.sendKeys(Keys.RETURN);
				}
				listOfServers = SSL_Certificate_Home_Page.CertificatesList_Table;
				noOfRows = listOfServers.size();
				for (int i = 2; i <= noOfRows; i++) {
					String cert_name = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[1]/a")).getText();
					if (cert_name.equalsIgnoreCase(aliasName)) {
						certFound = true;
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Certificate found " + aliasName);
						if (cnName != null) {
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "cn name : "
									+ driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[2]")).getText());
							Assert.assertTrue(driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[2]")).getText().contains(cnName), "CN Name mismatch");
						}
						if (validFromDate != null) {
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking valid from date");
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "valid from date: "
									+ driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[3]")).getText());
							Assert.assertTrue(driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[3]")).getText().contains(validFromDate),
									"Certificate validity start date mismatch");
						}
						if (validTillDate != null) {
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking valid till date");
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "valid till date: "
									+ driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[4]")).getText());
							Assert.assertTrue(driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[4]")).getText().contains(validTillDate),
									"certificate expiry date mismatch");
						}
						break;
					}
				}
				if (certFound) {
					break;
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "*** Checking done ***");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void CheckSSLCertDetailsInSSPIDP(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String aliasName = config.get("alias_name");
		String cnName = config.get("cn_name");
		String validFromDate = config.get("valid_from_date");
		String validTillDate = config.get("valid_till_date");
		SSP_Configuration_Page = PageFactory.initElements(driver, SelfServicePortalIdPConfigurationPage.class);
		IdP_Home_Page = PageFactory.initElements(driver, IdentityProvidersHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		WebDriverWait wt = new WebDriverWait(driver, 15);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.elementToBeClickable(Configuration_Console_Home_Page.Identity_Providers_Tab));
		Configuration_Console_Home_Page.Identity_Providers_Tab.click();
		IdP_Home_Page.Self_Service_Portal_IdP_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking edit button");
		wt.until(ExpectedConditions.elementToBeClickable(SSP_Configuration_Page.Edit_Button1));
		SSP_Configuration_Page.Edit_Button1.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking HTTPS button");
		// wt.until(ExpectedConditions
		// .elementToBeClickable(SSP_Configuration_Page.Enable_SSP_IDP_Yes_RadioButton));
		SSP_Configuration_Page.HTTPS_Enable_Yes_RadioButton.click();
		Thread.sleep(1000);
		List<WebElement> list = SSP_Configuration_Page.SSlListElement();
		for (WebElement li : list) {
			if (aliasName != null && li.findElement(By.className("certNameSSL")).getText().contains(aliasName)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Alias name : " + li.findElement(By.className("certNameSSL")).getText());
				Assert.assertTrue(li.findElement(By.className("certNameSSL")).getText().contains(aliasName));
				if (cnName != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "CN Name : " + li.findElement(By.xpath("div[@class='certNameSSL']/span")).getText());
					Assert.assertTrue(li.findElement(By.xpath("div[@class='certNameSSL']/span")).getText().contains(cnName), "CN Name mismatch");
				}
				if (validFromDate != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Valid from date : " + li.findElement(By.className("storeNameSSL")).getText());
					Assert.assertTrue(li.findElement(By.className("storeNameSSL")).getText().contains(validFromDate), "certificate validity start date mismatch");
				}
				if (validTillDate != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Valid to date : " + li.findElement(By.className("locationDivSSL")).getText());
					Assert.assertTrue(li.findElement(By.className("locationDivSSL")).getText().contains(validTillDate), "Certificate expiry mismatch");
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "*** Checking done ***");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void CheckSSLCertDetailsInVIPManagerIDP(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String aliasName = config.get("alias_name");
		String cnName = config.get("cn_name");
		String validFromDate = config.get("valid_from_date");
		String validTillDate = config.get("valid_till_date");
		VIP_Manager_Idp_Config_Page = PageFactory.initElements(driver, VIPManagerIdpConfiguraionPage.class);
		UserStore_Main_Page = PageFactory.initElements(driver, UserStoreMainPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		IdP_Home_Page = PageFactory.initElements(driver, IdentityProvidersHomePage.class);
		WebDriverWait wt = new WebDriverWait(driver, 15);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.elementToBeClickable(Configuration_Console_Home_Page.Identity_Providers_Tab));
		Configuration_Console_Home_Page.Identity_Providers_Tab.click();
		IdP_Home_Page.VIP_Manager_IdP_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking edit button");
		wt.until(ExpectedConditions.elementToBeClickable(VIP_Manager_Idp_Config_Page.Edit_Button));
		VIP_Manager_Idp_Config_Page.Edit_Button.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking HTTPS button");
		// wt.until(ExpectedConditions
		// .elementToBeClickable(SSP_Configuration_Page.Enable_SSP_IDP_Yes_RadioButton));
		VIP_Manager_Idp_Config_Page.HTTPS_Enable_Yes_RadioButton.click();
		Thread.sleep(1000);
		List<WebElement> list = VIP_Manager_Idp_Config_Page.SSlListElement();
		for (WebElement li : list) {
			if (aliasName != null && li.findElement(By.className("certNameSSL")).getText().contains(aliasName)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Alias name : " + li.findElement(By.className("certNameSSL")).getText());
				Assert.assertTrue(li.findElement(By.className("certNameSSL")).getText().contains(aliasName));
				if (cnName != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "CN Name : " + li.findElement(By.xpath("div[@class='certNameSSL']/span")).getText());
					Assert.assertTrue(li.findElement(By.xpath("div[@class='certNameSSL']/span")).getText().contains(cnName), "CN Name mismatch");
				}
				if (validFromDate != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Valid from date : " + li.findElement(By.className("storeNameSSL")).getText());
					Assert.assertTrue(li.findElement(By.className("storeNameSSL")).getText().contains(validFromDate), "certificate validity start date mismatch");
				}
				if (validTillDate != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Valid to date : " + li.findElement(By.className("locationDivSSL")).getText());
					Assert.assertTrue(li.findElement(By.className("locationDivSSL")).getText().contains(validTillDate), "certificate expiry date mismatch");
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "*** Checking done ***");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void Disable_HTTPS_ConsoleSetting(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Settings_Home_Page = PageFactory.initElements(driver, SettingsHomePage.class);
		Console_Settings_Page = PageFactory.initElements(driver, ConsoleSettingsPage.class);
		Configuration_Console_Login_Page = PageFactory.initElements(driver, ConfigurationConsoleLoginPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		// String hostName = config.get("ssl_hostname");
		String server = config.get("eg_server_host");
		String sUsername = config.get("login_username");
		String sPassword = config.get("login_password");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Login password is " + sPassword);
		String url;
		url = "https://" + server + ":8232/";
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " SSP IDP URL : " + url);
		WebDriverWait wt = new WebDriverWait(driver, 15);
		int counter = 0;
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "refreshing the page");
			while (counter <= 3) {
				if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.UserName_TextBox) || sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link))
					break;
				else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Refreshing the page. Tries : " + (counter + 1));
					counter++;
					driver.get(driver.getCurrentUrl());
				}
			}
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.UserName_TextBox)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Invoking Configuration Console login flow");
				Configuration_Console_Login_Page.UserName_TextBox.sendKeys(sUsername);
				Configuration_Console_Login_Page.Password_TextBox.sendKeys(sPassword);
				if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Login_Auth_Type_SelectBox)) {
					Select dropdown = new Select(Configuration_Console_Login_Page.Login_Auth_Type_SelectBox);
					List<WebElement> options = dropdown.getOptions();
					for (WebElement option : options) {
						if ((option.getText()).equalsIgnoreCase("Local Administrator")) {
							option.click();
							break;
						}
					}
				}
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking submit button");
				Configuration_Console_Login_Page.Submit_Button.click();
				if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button)) {
					Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button.click();
				}
				Thread.sleep(2000);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + " Test case status :"
						+ (sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link) ? "Pass" : "Fail"));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
				Assert.assertTrue(sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link));
			} else {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Login page not found. ");
				Assert.assertTrue(false, "Login page not found");
			}
		}
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking settings tab");
		Configuration_Console_Home_Page.Settings_Tab.click();
		wt.until(ExpectedConditions.elementToBeClickable(Settings_Home_Page.Console_Settings_Tab));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking console settings tab");
		Settings_Home_Page.Console_Settings_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking HTTPS button");
		Console_Settings_Page.Protocol_Http_RadioButton.click();
		Thread.sleep(1000);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking submit button");
		Console_Settings_Page.Submit_Button.click();
		Thread.sleep(5000);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void CheckSSLCertDetailsInConsoleSettings(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String aliasName = config.get("alias_name");
		String cnName = config.get("cn_name");
		String validFromDate = config.get("valid_from_date");
		String validTillDate = config.get("valid_till_date");
		Settings_Home_Page = PageFactory.initElements(driver, SettingsHomePage.class);
		Console_Settings_Page = PageFactory.initElements(driver, ConsoleSettingsPage.class);
		WebDriverWait wt = new WebDriverWait(driver, 15);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.elementToBeClickable(Settings_Home_Page.Console_Settings_Tab));
		Settings_Home_Page.Console_Settings_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking HTTPS button");
		Console_Settings_Page.Protocol_Https_RadioButton.click();
		Thread.sleep(1000);
		List<WebElement> list = Console_Settings_Page.SSlListElement();
		for (WebElement li : list) {
			if (aliasName != null && li.findElement(By.className("certNameSSL")).getText().contains(aliasName)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Alias name : " + li.findElement(By.className("certNameSSL")).getText());
				Assert.assertTrue(li.findElement(By.className("certNameSSL")).getText().contains(aliasName));
				if (cnName != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "CN Name : " + li.findElement(By.xpath("div[@class='certNameSSL']/span")).getText());
					Assert.assertTrue(li.findElement(By.xpath("div[@class='certNameSSL']/span")).getText().contains(cnName), "CN name mismatch");
				}
				if (validFromDate != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Valid from date : " + li.findElement(By.className("storeNameSSL")).getText());
					Assert.assertTrue(li.findElement(By.className("storeNameSSL")).getText().contains(validFromDate), "Certificate validity start date mismatch");
				}
				if (validTillDate != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Valid to date : " + li.findElement(By.className("locationDivSSL")).getText());
					Assert.assertTrue(li.findElement(By.className("locationDivSSL")).getText().contains(validTillDate), "certificate expiry date mismatch");
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "*** Checking done ***");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void ConsoleSettings_HTTPS_Login(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String aliasName = config.get("alias_name");
		Settings_Home_Page = PageFactory.initElements(driver, SettingsHomePage.class);
		Console_Settings_Page = PageFactory.initElements(driver, ConsoleSettingsPage.class);
		// String hostName = config.get("ssl_hostname");
		String server = config.get("eg_server_host");
		// String sUsername = config.get("login_username");
		// String sPassword = config.get("login_password");
		// logger.info("Thread-"+Thread.currentThread().getId()+": "+"Login password is "
		// +
		// sPassword);
		Configuration_Console_Login_Page = PageFactory.initElements(driver, ConfigurationConsoleLoginPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String url;
		url = "https://" + server + ":8232/";
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " SSP IDP URL : " + url);
		WebDriverWait wt = new WebDriverWait(driver, 15);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Settings_Tab.click();
		wt.until(ExpectedConditions.elementToBeClickable(Settings_Home_Page.Console_Settings_Tab));
		Settings_Home_Page.Console_Settings_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking HTTPS button");
		Console_Settings_Page.Protocol_Https_RadioButton.click();
		Thread.sleep(1000);
		List<WebElement> list = Console_Settings_Page.SSlListElement();
		for (WebElement li : list) {
			if (aliasName != null && li.findElement(By.className("certNameSSL")).getText().contains(aliasName)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Alias name : " + li.findElement(By.className("certNameSSL")).getText());
				li.findElement(By.name("selectedSslKeyIndex")).click();
			}
		}
		Thread.sleep(1000);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking submit button");
		Console_Settings_Page.Submit_Button.click();
		Thread.sleep(2000);
		// ////
		/*
		 * logger.info("Thread-"+Thread.currentThread().getId()+": "+
		 * "Navigating to url : " + url); driver.navigate().to(url);
		 * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * logger .info("Thread-"+Thread.currentThread().getId()+": "+
		 * "refreshing the page"); while (true) {
		 * driver.get(driver.getCurrentUrl()); if
		 * (sHelper.isElementPresent(driver,
		 * Configuration_Console_Login_Page.UserName_TextBox)) break; } //
		 * WebDriverWait wt1 = new WebDriverWait(driver, 120);
		 * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); if
		 * (sHelper.isElementPresent(driver,
		 * Configuration_Console_Login_Page.UserName_TextBox)) {
		 * logger.info("Thread-"+Thread.currentThread().getId()+": "+
		 * "Invoking Configuration Console login flow");
		 * Configuration_Console_Login_Page
		 * .UserName_TextBox.sendKeys(sUsername);
		 * Configuration_Console_Login_Page
		 * .Password_TextBox.sendKeys(sPassword); if
		 * (sHelper.isElementPresent(driver,
		 * Configuration_Console_Login_Page.Login_Auth_Type_SelectBox)) { Select
		 * dropdown = new
		 * Select(Configuration_Console_Login_Page.Login_Auth_Type_SelectBox );
		 * List<WebElement> options = dropdown.getOptions(); for (WebElement
		 * option : options) { if
		 * ((option.getText()).equalsIgnoreCase("Local Administrator")) {
		 * option.click(); break; } } } logger.info(Thread.currentThread().getId
		 * ()+"clicking login submit button");
		 * Configuration_Console_Login_Page.Submit_Button.click(); if
		 * (sHelper.isElementPresent(driver,
		 * Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button)) {
		 * Configuration_Console_Login_Page .Confirm_SignIn_Yes_Button.click();
		 * } logger.info("Thread-"+Thread
		 * .currentThread().getId()+": "+" Test case status :" +
		 * (sHelper.isElementPresent(driver,
		 * Configuration_Console_Home_Page.SignOut_Link) ? "Pass" : "Fail"));
		 * Assert.assertTrue(sHelper.isElementPresent(driver,
		 * Configuration_Console_Home_Page.SignOut_Link)); } else { logger.info
		 * ("Thread-"+Thread.currentThread().getId()+": "+
		 * "Login page not found. "); Assert.assertTrue(false); } //////
		 */
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void CheckSSLCertDetailsInTunnelReceiver(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String aliasName = config.get("alias_name");
		String cnName = config.get("cn_name");
		String validFromDate = config.get("valid_from_date");
		String validTillDate = config.get("valid_till_date");
		Validation_Main_Page = PageFactory.initElements(driver, ValidationMainPage.class);
		Tunnel_Server_Home_Page = PageFactory.initElements(driver, TunnelServerHomePage.class);
		Add_Tunnel_Receiver_Page = PageFactory.initElements(driver, AddTunnelReceiverPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String tunnelName = config.get("tunnel_receiver_name");
		WebDriverWait wt = new WebDriverWait(driver, 15);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Validation tab");
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Validation")));
		Configuration_Console_Home_Page.Validation_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Tunnel Server tab");
		Validation_Main_Page.Tab_TunnelServer.click();
		wt.until(ExpectedConditions.elementToBeClickable(Tunnel_Server_Home_Page.Button_AddServer));
		if (sHelper.isElementPresent(driver, By.linkText(tunnelName))) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking the tunnel receiver  " + tunnelName);
			driver.findElement(By.linkText(tunnelName)).click();
			wt.until(ExpectedConditions.elementToBeClickable(Add_Tunnel_Receiver_Page.Button_Submit));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking Enable SSL button");
			Add_Tunnel_Receiver_Page.Enable_SSL_RadioButton.click();
			Thread.sleep(1000);
			List<WebElement> list = Add_Tunnel_Receiver_Page.SSlListElement();
			for (WebElement li : list) {
				if (aliasName != null && li.findElement(By.className("certNameSSL")).getText().contains(aliasName)) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Alias name : " + li.findElement(By.className("certNameSSL")).getText());
					Assert.assertTrue(li.findElement(By.className("certNameSSL")).getText().contains(aliasName));
					if (cnName != null) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "CN Name : " + li.findElement(By.xpath("div[@class='certNameSSL']/span")).getText());
						Assert.assertTrue(li.findElement(By.xpath("div[@class='certNameSSL']/span")).getText().contains(cnName));
					}
					if (validFromDate != null) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Valid from date : " + li.findElement(By.className("storeNameSSL")).getText());
						Assert.assertTrue(li.findElement(By.className("storeNameSSL")).getText().contains(validFromDate));
					}
					if (validTillDate != null) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Valid to date : " + li.findElement(By.className("locationDivSSL")).getText());
						Assert.assertTrue(li.findElement(By.className("locationDivSSL")).getText().contains(validTillDate));
					}
				}
			}
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Tunnel receiver " + tunnelName + " not found");
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void AddTunnelReceiver(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Validation_Main_Page = PageFactory.initElements(driver, ValidationMainPage.class);
		Tunnel_Server_Home_Page = PageFactory.initElements(driver, TunnelServerHomePage.class);
		Add_Tunnel_Receiver_Page = PageFactory.initElements(driver, AddTunnelReceiverPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		String tunnelName = config.get("tunnel_receiver_name");
		String tunnelTCPPort = config.get("tunnel_receiver_tcp_port");
		String successMessage = "Tunnel Receiver " + tunnelName + " was added successfully.";
		String aliasName = config.get("alias_name");
		String loggingLevel = config.get("log_level");
		String loggingRotLevel = config.get("log_rot_level");
		String noOfFilesToKeep = config.get("no_of_files_to_keep");
		this.DeleteTunnelServer(driver, tunnelName);
		WebDriverWait wt = new WebDriverWait(driver, 15);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Validation tab");
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Validation")));
		Configuration_Console_Home_Page.Validation_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Tunnel Server tab");
		Validation_Main_Page.Tab_TunnelServer.click();
		if (sHelper.isElementPresent(driver, By.linkText(tunnelName))) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Tunnel Receiver " + tunnelName + " already created");
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Add Server button");
			Tunnel_Server_Home_Page.Button_AddServer.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting Tunnel Receiver radio button");
			Tunnel_Server_Home_Page.RadioButton_TunnelReceiver.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on continue");
			Tunnel_Server_Home_Page.Button_Continue.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate details in Add Tunnel Receiver page");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting tunnel name");
			Add_Tunnel_Receiver_Page.TextBox_TunnelName.sendKeys(tunnelName);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting TCP port name");
			Add_Tunnel_Receiver_Page.TextBox_TCPPort.clear();
			Add_Tunnel_Receiver_Page.TextBox_TCPPort.sendKeys(tunnelTCPPort);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate log level");
			if (loggingLevel != null) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "log level :" + loggingLevel);
				Select dropdown = new Select(Add_Tunnel_Receiver_Page.Logging_Level_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).equalsIgnoreCase(loggingLevel.toLowerCase())) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing logging level to : " + loggingLevel.toUpperCase());
						option.click();
						break;
					}
				}
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate log rotation level");
			if (loggingRotLevel != null) {
				Select dropdown = new Select(Add_Tunnel_Receiver_Page.Logging_Rotation_Level_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).equalsIgnoreCase(loggingRotLevel.toLowerCase())) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing log rotation level to : " + loggingRotLevel.toUpperCase());
						option.click();
						break;
					}
				}
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate no of files to keep");
			if (noOfFilesToKeep != null) {
				Select dropdown = new Select(Add_Tunnel_Receiver_Page.NumberOf_Files_To_Keep_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).equalsIgnoreCase(noOfFilesToKeep.toLowerCase())) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing number of files to keep : " + noOfFilesToKeep.toUpperCase());
						option.click();
						break;
					}
				}
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking Enable SSL button");
			Add_Tunnel_Receiver_Page.Enable_SSL_RadioButton.click();
			List<WebElement> list = Add_Tunnel_Receiver_Page.SSlListElement();
			for (WebElement li : list) {
				if (aliasName != null && li.findElement(By.className("certNameSSL")).getText().contains(aliasName)) {
					li.findElement(By.name("chkUserStore")).click();
				}
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on submit button");
			Add_Tunnel_Receiver_Page.Button_Submit.click();
			String actualMessage = Tunnel_Server_Home_Page.MessageElement.getText();
			Assert.assertTrue(actualMessage.equalsIgnoreCase(successMessage), "Actual message : " + actualMessage + " | Expected message was : " + successMessage);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void AddTunnelForwarder(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Validation_Main_Page = PageFactory.initElements(driver, ValidationMainPage.class);
		Tunnel_Server_Home_Page = PageFactory.initElements(driver, TunnelServerHomePage.class);
		Add_Tunnel_Forwarder_Page = PageFactory.initElements(driver, AddTunnelForwarderPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		String tunnelName = config.get("tunnel_forwarder_name");
		String tunnelUDPPort = config.get("tunnel_forwarder_udp_port");
		String recHost = config.get("tunnel_forwarder_host");
		String recPort = config.get("tunnel_forwarder_port");
		String successMessage = "Tunnel Forwarder " + tunnelName + " was added successfully.";
		WebDriverWait wt = new WebDriverWait(driver, 20);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking if the forwarder is already present. If present, deleting.");
		this.DeleteTunnelServer(driver, tunnelName);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Validation tab");
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Validation")));
		Configuration_Console_Home_Page.Validation_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Tunnel Server tab");
		Validation_Main_Page.Tab_TunnelServer.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicked on tunnel server tab");
		if (sHelper.isElementPresent(driver, By.linkText(tunnelName))) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Tunnel Forwarder " + tunnelName + " already created");
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Add Server button");
			Tunnel_Server_Home_Page.Button_AddServer.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting Tunnel Forwarder radio button");
			Tunnel_Server_Home_Page.RadioButton_TunnelForwarder.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on continue");
			Tunnel_Server_Home_Page.Button_Continue.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate details in Add Tunnel Forwarder page");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting tunnel name");
			Add_Tunnel_Forwarder_Page.TextBox_TunnelName.sendKeys(tunnelName);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting UDP port number");
			Add_Tunnel_Forwarder_Page.TextBox_UDPPort.clear();
			Add_Tunnel_Forwarder_Page.TextBox_UDPPort.sendKeys(tunnelUDPPort);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting Receiver Host");
			Add_Tunnel_Forwarder_Page.TextBox_Host.clear();
			Add_Tunnel_Forwarder_Page.TextBox_Host.sendKeys(recHost);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting Receiver Port");
			Add_Tunnel_Forwarder_Page.TextBox_Port.clear();
			Add_Tunnel_Forwarder_Page.TextBox_Port.sendKeys(recPort);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on submit button");
			Add_Tunnel_Forwarder_Page.Button_Submit.click();
			Tunnel_Server_Home_Page.MessageElement.getText();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Status : " + Tunnel_Server_Home_Page.MessageElement.getText());
			Assert.assertTrue(Tunnel_Server_Home_Page.MessageElement.getText().equalsIgnoreCase(successMessage), "Submit action failed. Actual message :"
					+ Tunnel_Server_Home_Page.MessageElement.getText());
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void DeleteSSLCertificate(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Add_SSL_Certificate_Page = PageFactory.initElements(driver, AddSSLCertificatePage.class);
		SSL_Certificate_Home_Page = PageFactory.initElements(driver, SSLCertificateHomePage.class);
		Settings_Home_Page = PageFactory.initElements(driver, SettingsHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String confirm_text = "Deleted";
		String aliasName = config.get("alias_name");
		int noOfRows;
		boolean pagination, certFound = false;
		List<WebElement> listOfServers;
		WebDriverWait wt = new WebDriverWait(driver, 20);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Settings_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on SSL Certificate tab");
		Settings_Home_Page.SSL_Certificate_Tab.click();
		wt.until(ExpectedConditions.elementToBeClickable(SSL_Certificate_Home_Page.Button_AddSSLCerificate));
		listOfServers = SSL_Certificate_Home_Page.CertificatesList_Table;
		noOfRows = listOfServers.size();
		String state = SSL_Certificate_Home_Page.Pagination_Table.getAttribute("class");
		if (state.contains("disabled")) {
			pagination = false;
		} else {
			pagination = true;
		}
		for (int j = 1; j <= 10; j++) {
			if (pagination) {
				SSL_Certificate_Home_Page.PageNo_TextBox.clear();
				SSL_Certificate_Home_Page.PageNo_TextBox.sendKeys(Integer.toString(j));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Navigating to validation server page " + Integer.toString(j) + " to restart the validation server");
				SSL_Certificate_Home_Page.PageNo_TextBox.sendKeys(Keys.RETURN);
			}
			listOfServers = SSL_Certificate_Home_Page.CertificatesList_Table;
			noOfRows = listOfServers.size();
			logger.info("Thread-" + Thread.currentThread().getId() + ": "+"no of cert rows " + noOfRows);
			for (int i = 2; i < noOfRows; i++) {
				String cert_name = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[1]/a")).getText();
				if (cert_name.equalsIgnoreCase(aliasName)) {
					certFound = true;
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Certificate found " + aliasName);
					driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[6]/a[text()='Delete']")).click();
					wt.until(ExpectedConditions.elementToBeClickable(Add_SSL_Certificate_Page.Button_Submit));
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking submit button");
					Add_SSL_Certificate_Page.Button_Submit.click();
					break;
				}
			}
			if (certFound) {
				Assert.assertTrue(SSL_Certificate_Home_Page.MessageElement.getText().contains(confirm_text), "Deletion of certificate " + aliasName + " failed");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Deletion successfull");
				break;
			}
		}
		if (!certFound)
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Certificate with alias name " + aliasName + " not found");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void ExportSettings(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Export_Settings_Page = PageFactory.initElements(driver, ExportSettingsPage.class);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Initializing the variable values started ");
		boolean result = false;
		String errorTextExpectedForPwdMatch = "The encryption passwords did not match.";
		String errorText = "";
		boolean expectedResult = Boolean.valueOf(config.get("expected_result"));
		String password = config.get("password");
		String passwordConfirm = config.get("confirm_password");
		boolean encrypt = Boolean.valueOf(config.get("is_encrypted"));
		WebDriverWait wt = new WebDriverWait(driver, 30);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Initializing the variable values completed");
		if (sHelper.isElementPresent(driver, Export_Settings_Page.Tab_Settings)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Settings tab");
			Export_Settings_Page.Tab_Settings.click();
			if (sHelper.isElementPresent(driver, Export_Settings_Page.Link_ExportSettings)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Export Settings ");
				Export_Settings_Page.Link_ExportSettings.click();
			}
			wt.until(ExpectedConditions.visibilityOf(Export_Settings_Page.Export_Button));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Export button");
			Export_Settings_Page.Export_Button.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to export window");
			driver.switchTo().frame(0);
			// driver.manage().timeouts().pageLoadTimeout(45,
			// TimeUnit.SECONDS);
			// driver.manage().timeouts().implicitlyWait(20,
			// TimeUnit.SECONDS);
			List<WebElement> FeatureConfigs = Export_Settings_Page.Get_Webelements(1);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Next button");
			Export_Settings_Page.Next_button.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			List<WebElement> radios = Export_Settings_Page.Get_Webelements(3);
			if (encrypt) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Encrypt Radio button enabled.");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Encrypt Radio button");
				if (!radios.get(0).isDisplayed())
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				radios.get(0).click();
				Export_Settings_Page.Password_InputField.sendKeys(password);
				Export_Settings_Page.ConfirmPassword_InputField.sendKeys(passwordConfirm);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Next button");
				Export_Settings_Page.Next_button.click();
				errorText = (password.equals(passwordConfirm)) ? " " : Export_Settings_Page.Error_label.getText();
				if (errorText.equals(errorTextExpectedForPwdMatch)) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Error message : password and confirm password is missing/mismatch. ");
					result = false;
					return;
				}
			} else {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Do Not Encrypt Radio button");
				if (!radios.get(1).isDisplayed())
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				radios.get(1).click();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Next button");
				Export_Settings_Page.Next_button.click();
			}
			List<WebElement> checkFeatureConfigs = Export_Settings_Page.Get_Webelements(2);
			if (FeatureConfigs.size() != checkFeatureConfigs.size()) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Features configuration  mismatch, before and after export functionality.");
				result = false;
				return;
			}
			result = true;
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking Finish button.");
			Export_Settings_Page.Finish_button.click();
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Settings tab missing/mismatch in EG");
			result = false;
			return;
		}
		Assert.assertEquals(result, expectedResult);
		driver.switchTo().defaultContent();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to main page");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expectedResult + "| | Actual result:" + result + " | | Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail") + " |");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void ImportSettings(Map<String, String> config, WebDriver driver) throws Exception {
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		Import_Settings_Page = PageFactory.initElements(driver, ImportSettingsPage.class);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Initializing the variable values started ");
		boolean result = false;
		String path = null;
		String importConfigurationDir = config.get("import_configuration_dir");
		boolean expectedResult = Boolean.valueOf(config.get("expected_result"));
		String settings = config.get("settings");
		boolean flag = settings.isEmpty() ? true : false;
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "EG Version " + Import_Settings_Page.Version_Label.getText());
		WebDriverWait wt = new WebDriverWait(driver, 60);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Initializing the variable values completed");
		String[] itemSettings = null;
		if (config.get("product_source_version") != null) {
			String sourceVersion = config.get("product_source_version");
			path = Import_Settings_Page.Version_Label.getText().contains("Windows") ? importConfigurationDir + "/" + sourceVersion.replaceAll("[.]+", "_") + "_windows.zip" : importConfigurationDir
					+ "/" + sourceVersion.replaceAll("[.]+", "_") + "_linux.zip";
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Path for zip file is " + path);
		} else {
			path = Import_Settings_Page.Version_Label.getText().contains("Windows") ? importConfigurationDir + "/windows.zip" : importConfigurationDir + "/linux.zip";
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Path for zip file is " + path);
		}
		if (!flag) {
			if (settings.contains(",")) {
				itemSettings = settings.split(",");
			} else {
				itemSettings = new String[1];
				itemSettings[0] = settings;
			}
		} else {
			result = false;
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Exiting due to empty input in setting to state about the modules needs to be selected while import ");
			return;
		}
		if (sHelper.isElementPresent(driver, Import_Settings_Page.Tab_Settings)) {
			Import_Settings_Page.Tab_Settings.click();
			if (sHelper.isElementPresent(driver, Import_Settings_Page.Link_ImportSettings)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Import Settings ");
				Import_Settings_Page.Link_ImportSettings.click();
			}
			Thread.sleep(2000);
			// wt.until(ExpectedConditions
			// .visibilityOf(Import_Settings_Page.Import_Button));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Import button");
			Import_Settings_Page.Import_Button.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to import window.");
			driver.switchTo().frame(0);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Sending path key to browse field ");
			Import_Settings_Page.BrowsePath_Field.sendKeys(path);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking Next  button ");
			Import_Settings_Page.Next_Button.click();
			// Thread.sleep(5000);
			if (itemSettings[0].contains("All")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "NO CUSTOMIZED module selection is needed, clicking on NEXT with default settings");
			} else {
				List<WebElement> checkBxs = Import_Settings_Page.Get_Webelements();
				for (WebElement checkBx : checkBxs) {
					checkBx.click();
				}
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Unchecked all boxes");
				for (String setting : itemSettings) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "input setting from json: " + setting);
					for (WebElement checkBx : checkBxs) {
						if (checkBx.getAttribute("id").equals(setting)) {
							checkBx.click();
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking the box " + checkBx.getAttribute("id"));
						}
					}
				}
			}
			// driver.manage().timeouts().pageLoadTimeout(45,
			// TimeUnit.SECONDS);
			// driver.manage().timeouts().implicitlyWait(20,
			// TimeUnit.SECONDS);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking whether next button is active");
			if (Import_Settings_Page.Next_Button.isEnabled()) {
				Import_Settings_Page.Next_Button.click();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking next button");
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				Thread.sleep(1000);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Recieved alert " + alert.getText());
				alert.accept();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Accepted alert");
				// } else {
				// }
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Waiting to finish the import process");
				wt.until(ExpectedConditions.elementToBeClickable(Import_Settings_Page.Finish_button));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking finish button");
				Import_Settings_Page.Finish_button.click();
			} else {
				result = false;
				return;
			}
			result = true;
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Settings tab missing/mismatch in EG");
			result = false;
			return;
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to main page");
		driver.switchTo().defaultContent();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expectedResult + "| | Actual result:" + result + " | | Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail") + " |");
		Assert.assertEquals(result, expectedResult);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public enum HelpLinks {
		SigningIntoVIPEnterpriseGatewayConfigurationConsole("I_1"), ViewingHomePage("I_2"), ViewingConfigurationSummary("I_3"), ManagingCertificates("B_4"), SecuringYourConnectiontotheVIPAuthenticationService(
				"I_5"), ImportingaVIPCertificate("I_6"), SecuringDataUsingSSLCertificates("I_7"), ImportingaPKCS("I_8"), GeneratinganSSLKey("I_9"), SubmittingaCertificateSigningRequest("I_10"), InstallinganSSLCertificate(
						"I_11"), EnablingSSLforVIPEnterpriseGateway("I_12"), ImportingaCAChainintoYourTrustedCAStore("I_13"), TrustedCACertificates("I_14"), AddingaTrustedCACertificatetoVIPEnterpriseGateway(
								"I_15"), InitialConfigurations("B_16"), ConfiguringtheConsoleSettings("I_17"), ConfiguringHTTPProxySettings("I_18"), ImportingVIPEnterpriseGatewayConfigurationSettings("I_19"), ConfiguringUserStores(
										"B_20"), AddingaUserStore("I_21"), Re("I_17"), DeletingaUserStore("I_23"), EditingtheConfigurationofaUserStore("I_24"), ViewingtheDetailsofaConnection("I_25"), AddingaNewConnectiontoaUserStore(
												"I_26"), DeletingaConnectionAssociatedwithaUserStore("I_27"), ModifyingtheUserSearchCriteriaConfiguredforaUserStore("I_28"), ConfiguringOptionalAttributestoEnhanceUserSearchinVIPManager(
														"I_29"), EnablingUserstoResetActiveDirectoryPassword("I_30"), AddingaVIPUserGroupMapping("I_31"), ManagingtheVIPUserGroupMappingRecords("I_32"), ConfiguringRADIUSValidationServer("B_33"), AddingaValidationServer(
																"I_34"), AboutConfiguringaDelegationServer("I_35"), ConfiguringAutomaticBusinessContinuitySettings("I_36"), ViewingtheAutomaticBusinessContinuitySettings("I_37"), ModifyingtheAutomaticBusinessContinuitySettings(
																		"I_38"), ModifyingRADIUSValidationServers("I_39"), DuplicatingaValidationServer("I_40"), DeletingaRADIUSValidationServer("I_41"), TunnelServersOverview("I_42"), AddingaTunnelForwarder(
																				"I_43"), ModifyingTunnelValidationServers("I_44"), DeletingaTunnelValidationServer("I_45"), ConfiguringAdministrators("B_46"), ConfiguringVIPAdministrators("I_47"), EditingVIPAdministratorConfiguration(
																						"I_48"), ConfiguringVIPAdministratorSynchronizationSettings("I_49"), EditingaVIPAdministratorGroupMapping("I_50"), ManagingtheVIPAdministratorGroupMappingRecords("I_51"), AuthenticatingConsoleAdministratorstoSign(
																								"I_52"), ConfiguringIdentityProviders("B_53"), ConfiguringSelfServicePortalIdP("I_54"), ConfiguringVIPManagerIdP("I_55"), ConfiguringLDAPSynchronizationService("B_56"), ConfigureLDAPDirectorySynchronizationService(
																										"I_57"), SimulatingLDAPDirectorySynchronization("I_58"), ConfiguringSynchronizationCluster("I_59"), UpdateSettings("B_60"), ConfiguringUpdateSettings("I_61"), CheckingfortheProductUpdatesintheAutomaticMode(
																												"I_62"), CheckingfortheProductUpdatesintheManualMode("I_63"), InstallingVIPEnterpriseGatewayUpgradesandPatches("I_64"), ManagingLogs("B_65"), ConfiguringSyslogSettings("I_66"), ExportingVIPEnterpriseGatewayConfiguration(
																														"I_67"), ScreenandErrorMessages("B_68"), Error("I_69"), Cross("I_70"), Host("I_71");
		private final String value;

		private HelpLinks(String value) {
			this.value = value;
		}
	};

	public void HelpSettings(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Initializing the variable values started ");
		Help_Page = PageFactory.initElements(driver, HelpPage.class);
		Boolean result = true;
		String id1 = "", id2 = "", compareString = "", parentHandle = "";
		Boolean expectedResult = Boolean.valueOf(config.get("expected_result"));
		String input = config.get("input_link");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "expected result");
		if (input.isEmpty())
			return;
		String[] arrayInput = input.split(",");
		// ----for debugging purpose
		// for(String s : arrayInput)
		// logger.info("Thread-"+Thread.currentThread().getId()+": "+"Array elements :"
		// + s
		// +"  Length : "+
		// arrayInput.length);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Initializing to check the link values");
		for (HelpLinks link : HelpLinks.values()) {
			if (arrayInput.length > 0 && (!arrayInput[0].isEmpty()) && arrayInput[0].trim().equalsIgnoreCase(link.toString())) {
				id1 = link.value;
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Parent link initialised value : " + id1.toString());
			} else if (arrayInput.length > 1 && (!arrayInput[1].isEmpty()) && arrayInput[1].trim().equalsIgnoreCase(link.toString())) {
				id2 = link.value;
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Child link  initialised value : " + id2.toString());
			} else {
				result = false;
			}
		}
		parentHandle = driver.getWindowHandle();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Help tab");
		if (sHelper.isElementPresent(driver, Help_Page.Tab_Help)) {
			Help_Page.Tab_Help.click();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle); // switch focus of
				// WebDriver to the
				// next found window
				// handle (that's
				// the newly opened
				// window)
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "moving to main  frame ");
			Thread.sleep(2500);
			driver.switchTo().frame(1);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "moving to left side mini navigation bar frame");
			driver.switchTo().frame("minibar_navpane");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "moving to settings menu frame");
			driver.switchTo().frame("navpane");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "moving to settings menu links frame");
			driver.switchTo().frame("tocIFrame");
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (arrayInput.length > 0 && (!id1.isEmpty()) && sHelper.isElementPresent(driver, driver.findElement(By.id(id1)))) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking the parent link: " + driver.findElement(By.id(id1)).getText());
				driver.findElement(By.id(id1)).click();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicked the parent link : " + driver.findElement(By.id(id1)).getText());
				compareString = arrayInput[0].equals("SigningIntoVIPEnterpriseGatewayConfigurationConsole") ? "SigningInasLocalAdministrator" : arrayInput[0];
				if (arrayInput.length > 1 && (!id2.isEmpty()) && sHelper.isElementPresent(driver, driver.findElement(By.id(id2)))) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking the child link : " + driver.findElement(By.id(id2)).getText());
					driver.findElement(By.id(id2)).click();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicked the child link : " + driver.findElement(By.id(id2)).getText());
					compareString = arrayInput[1];
				}
			} else {
				result = false;
				return;
			}
			driver.switchTo().defaultContent();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "moving to main  frame ");
			driver.switchTo().frame(1);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "moving to link's content frame");
			driver.switchTo().frame("topic");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Text from the header =====" + driver.findElement(By.tagName("h1")).getText().replace(" ", ""));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Compare Input Text =====" + compareString);
			result = (driver.findElement(By.tagName("h1")).getText().replace(" ", "").contains(compareString)) ? true : false;
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "result :" + result);
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Help tab missing/mismatch in EG");
			result = false;
			return;
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Closing the newly opened window");
		driver.close(); // close newly opened window when done with it
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to main window");
		driver.switchTo().window(parentHandle);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expectedResult + "| | Actual result:" + result + " | | Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail") + " |");
		Assert.assertEquals(result, expectedResult);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void DeleteValidaitonServer(WebDriver driver, String server) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		findAndActOnValidationServer(driver, server, "delete");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void DeleteTunnelServer(WebDriver driver, String server) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 45);
		int noOfRows;
		int flag = 0;
		boolean pagination;
		List<WebElement> listOfServers;
		boolean isDeleted = false;
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Validation")));
		Configuration_Console_Home_Page.Validation_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Tunnel Server tab");
		Validation_Main_Page.Tab_TunnelServer.click();
		listOfServers = Validation_Server_Home_Page.ValidationServersList_Table;
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicked tunnel server tab");
		if (listOfServers == null) {
			return;
		}
		noOfRows = listOfServers.size();
		if (noOfRows > 1) {
			String state = Validation_Server_Home_Page.Pagination_Table.getAttribute("class");
			if (state.contains("disabled")) {
				pagination = false;
			} else {
				pagination = true;
			}
			for (int j = 1; j <= 10; j++) {
				if (pagination) {
					Validation_Server_Home_Page.PageNo_TextBox.clear();
					Validation_Server_Home_Page.PageNo_TextBox.sendKeys(Integer.toString(j));
					Thread.sleep(100);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Navigating to validation server page " + Integer.toString(j) + " to restart the validation server");
					Validation_Server_Home_Page.PageNo_TextBox.sendKeys(Keys.RETURN);
				}
				listOfServers = Validation_Server_Home_Page.ValidationServersList_Table;
				if (listOfServers == null) {
					break;
				}
				noOfRows = listOfServers.size();
				flag = flag + 1;
				for (int i = 2; i <= noOfRows; i++) {
					String server_name = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[1]/a")).getText();
					if (server_name.equalsIgnoreCase(server)) {
						WebElement deleteLink = driver.findElement(By.xpath(".//*[@id='delete_" + server + "&forward=tunnel']"));
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Found the tunnel server. Deleting the server " + server);
						deleteLink.click();
						Alert alert = driver.switchTo().alert();
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Recieved alert" + alert.getText());
						alert.accept();
						isDeleted = true;
						break;
					}
					if (isDeleted) {
						break;
					}
				}
				if (flag == -1) {
					break;
				}
				if (isDeleted) {
					break;
				}
			}
			if (!isDeleted) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
				return;
			}
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace());
			return;
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void CreateUserStore(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		boolean result;
		WebDriverWait wt = new WebDriverWait(driver, 15);
		UserStore_Config_Page = PageFactory.initElements(driver, UserStoreConfigurationPage.class);
		boolean expectedResult = Boolean.valueOf(config.get("expected_result_cr"));
		String userStoreName = config.get("userstore_name");
		String connectionName = config.get("connection_name");
		String ldapHostFQDN = config.get("ldap_host_name");
		String ldapHostIP = config.get("ldap_host_ip");
		String ldapPortSSL = config.get("ldap_host_port_ssl");
		String ldapPortNonSSL = config.get("ldap_host_port_nonssl");
		String timeOut = config.get("time_out");
		String userDistinguishedName = config.get("ldap_bind_user_dn");
		String ldapBindpassword = config.get("ldap_bind_user_password");
		String baseDN = config.get("ldap_base_dn");
		String userFilter = config.get("user_filter");
		String testUserName = config.get("ldap_testuser_name");
		boolean isSSLEnabled = Boolean.valueOf(config.get("is_ssl_enabled"));
		String vipUserNameAttribute = config.get("vip_username_attribute");
		String expectedMessageAfterTest = "Test connection is successful.";
		String expectedMessageAfterSubmit = "User Store " + userStoreName.trim() + " has been configured successfully for VIP Enterprise Gateway.";
		String duplicateStoreMessage = userStoreName.trim() + " already exists.Enter a unique name for the User Store.";
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("User Store")));
		Configuration_Console_Home_Page.UserStore_Tab.click();
		if (sHelper.isElementPresent(driver, UserStore_Config_Page.Add_New_Button)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Add User stroe button");
			UserStore_Config_Page.Add_New_Button.click();
		}
		if (userStoreName != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Populating user store name as " + userStoreName);
			UserStore_Config_Page.Name_TextBox.sendKeys(userStoreName);
		}
		if (connectionName != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Populating conntection name");
			UserStore_Config_Page.Connection_TextBox.sendKeys(connectionName);
		}
		if (isSSLEnabled) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on enable ssl check box");
			UserStore_Config_Page.EnableSSL_CheckBox.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Populating LDAP Host FQDN as +ldapHostFQDN");
			UserStore_Config_Page.Host_TextBox.sendKeys(ldapHostFQDN);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Populating LDAP SSL port number as " + ldapPortSSL);
			UserStore_Config_Page.Port_TextBox.sendKeys(ldapPortSSL);
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Populating LDAP Host IP as" + ldapHostIP);
			UserStore_Config_Page.Host_TextBox.sendKeys(ldapHostIP);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Populating LDAP Non-SSL port number as " + ldapPortNonSSL);
			UserStore_Config_Page.Port_TextBox.sendKeys(ldapPortNonSSL);
		}
		if (timeOut != null) {
			Select dropdown = new Select(UserStore_Config_Page.Timeout_DropDownBox);
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).equalsIgnoreCase(timeOut.toLowerCase())) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing timeOut to " + timeOut);
					option.click();
					break;
				}
			}
		}
		if (userDistinguishedName != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Populating user DN as " + userDistinguishedName);
			UserStore_Config_Page.UserDN_TextBox.sendKeys(userDistinguishedName);
		}
		if (ldapBindpassword != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Populating bind user password as " + ldapBindpassword);
			UserStore_Config_Page.UserDN_Password_TextBox.sendKeys(ldapBindpassword);
		}
		if (baseDN != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Populating base DN " + baseDN);
			UserStore_Config_Page.BaseDN_TextBox.sendKeys(baseDN);
		}
		if (userFilter != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Populating user filter as " + userFilter);
			UserStore_Config_Page.UserFilter_TextBox.sendKeys(userFilter);
		}
		if (vipUserNameAttribute != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enabling checkbox VIP username attribute ");
			UserStore_Config_Page.VIP_UserName_Attribute_CheckBox.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Populating VIP user name attribute as " + vipUserNameAttribute);
			UserStore_Config_Page.VIP_UserName_attribute_TextBox.clear();
			UserStore_Config_Page.VIP_UserName_attribute_TextBox.sendKeys(vipUserNameAttribute);
		}
		if (testUserName != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Populating test username as " + testUserName);
			UserStore_Config_Page.TestUser_TextBox.sendKeys(testUserName);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on test button");
		UserStore_Config_Page.Test_Button.click();
		Thread.sleep(10000);
		String actualTestMessage = UserStore_Config_Page.Test_Button_Message.getText();
		// Thread.sleep(5000);
		result = actualTestMessage.contains(expectedMessageAfterTest);
		if (!result) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "User store test failed");
		} else {
			UserStore_Config_Page.Submit_Button.click();
			Thread.sleep(2000);
			String creationMessage = UserStore_Config_Page.Save_Message.getText();
			if (expectedMessageAfterSubmit.contains(creationMessage) || duplicateStoreMessage.contains(creationMessage)) {
				result = true;
			} else {
				logger.error("Thread-" + Thread.currentThread().getId() + ": " + "user store submit operation failed and got message " + creationMessage);
				result = false;
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " | Actual message : " + actualTestMessage + " | | Expected message : " + expectedMessageAfterTest + " |");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expectedResult + "| | Actual result:" + result + " | | Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail") + " |");
		Assert.assertEquals(result, expectedResult);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void AddTrustedCACertificate(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		boolean expected = true;
		boolean result = false;
		expected = Boolean.valueOf(config.get("expected_result"));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Invoking Add Trusted CA cert");
		WebDriverWait wt = new WebDriverWait(driver, 30);
		Trusted_CA_Certificate_Page = PageFactory.initElements(driver, TrustedCACertificatePage.class);
		Settings_Home_Page = PageFactory.initElements(driver, SettingsHomePage.class);
		String message = " ";
		result = false;
		String trustedca_certificate_path = null;
		List<String> fileNames = null;
		String UserStorename = config.get("userstore_name");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "User store name is " + UserStorename);
		trustedca_certificate_path = config.get("root_cert_path");
		if (UserStorename.contains("_")) {
			String[] userstoreparts = UserStorename.split("_");
			trustedca_certificate_path = trustedca_certificate_path + "/" + userstoreparts[0] + "/";
			fileNames = helper.GetFilenames(trustedca_certificate_path);
		} else {
			trustedca_certificate_path = trustedca_certificate_path + "/" + UserStorename + "/";
			fileNames = helper.GetFilenames(trustedca_certificate_path);
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking Settings tab");
		Configuration_Console_Home_Page.Settings_Tab.click();
		wt.until(ExpectedConditions.visibilityOf(Settings_Home_Page.Trusted_CA_Certificate_Tab));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking Trsuted CA Certificate tab");
		Settings_Home_Page.Trusted_CA_Certificate_Tab.click();
		for (int i = 0; i < fileNames.size(); i++) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Number of root cert needs to be added is "+fileNames.size());
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Waiting for add certificate button");
			wt.until(ExpectedConditions.visibilityOf(Trusted_CA_Certificate_Page.Add_Certificate_Button));
			// wt.until(ExpectedConditions
			// .elementToBeClickable(Trusted_CA_Certificate_Page.Add_Certificate_Button));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Add Certificate button");
			Trusted_CA_Certificate_Page.Add_Certificate_Button.click();
			String filenamepart = fileNames.get(i);
			int length = filenamepart.length();
			String filenameparts = filenamepart.substring(0, length - 4);
			Thread.sleep(3000);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "calling AddCACertificate method. Sending path, alias name and clicking submit.");
			Trusted_CA_Certificate_Page.AddCACertificate(trustedca_certificate_path + fileNames.get(i), filenameparts);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Waiting for submit message ");
			wt.until(ExpectedConditions.visibilityOf(Trusted_CA_Certificate_Page.Submit_Message));
			message = Trusted_CA_Certificate_Page.Submit_Message.getText();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + " message : " + message);
			if (message.contains("The CA Certificate was added successfully.")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking save button");
				Trusted_CA_Certificate_Page.Save_Changes.click();
				// totsuccesscnt =
				// driver.findElements(By.xpath("//td[@class='errortext' and contains(text(),'Trusted Root CA Stores have been changed.')]")).size();
				// if (totsuccesscnt > 0) {
				// result = true;
				// } else {
				// result = false;
				// }
				result = true;
			} else if (message.contains("Certificate already exists in the CA") || message.contains("The certificate alias provided already exists in the CA Trust Store.")) {
				result = true;
				Trusted_CA_Certificate_Page.Cancel_Button.click();
			} else if (message.contains("No Certificate or Incorrect Certificate Format")) {
				result = false;
				break;
			} else {
				result = false;
				break;
			}
		}
		if (result) {
			if (config.get("selected_env").equalsIgnoreCase("qa")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Added trusted root cert successfully. Restarting VIP Enterprise Gateway Service");
				rClient.PerformRemoteAction("ChangeAuthenticationURL", config);
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expected + "| | Actual result:" + result + " | | Test case status :"
				+ (expected == result ? "Pass" : "Fail") + " |");
		Assert.assertEquals(result, expected);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void ConfigureProxySettings(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		boolean result = false;
		HTTP_Proxy_Page = PageFactory.initElements(driver, HTTPProxyPage.class);
		Settings_Home_Page = PageFactory.initElements(driver, SettingsHomePage.class);
		WebDriverWait wt = new WebDriverWait(driver, 20);
		boolean expectedResult = Boolean.valueOf(config.get("expected_result"));
		String proxyHostIP = config.get("proxy_host_ip");
		String proxyHostPort = config.get("proxy_host_port");
		String proxyHostUserName = config.get("proxy_username");
		String proxyHostPassword = config.get("proxy_password");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Settings_Tab.click();
		Thread.sleep(5000);
		Settings_Home_Page.HTTP_Proxy_Settings_Tab.click();
		if (sHelper.isElementPresent(driver, HTTP_Proxy_Page.Edit_Button)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "proxy is already configured, so deleting");
			HTTP_Proxy_Page.Delete_Button.click();
		}
		if (proxyHostIP != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting proxy host IP as " + proxyHostIP);
			HTTP_Proxy_Page.Host_TextBox.clear();
			HTTP_Proxy_Page.Host_TextBox.sendKeys(proxyHostIP);
		}
		if (proxyHostPort != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting proxy host port as " + proxyHostPort);
			HTTP_Proxy_Page.Port_TextBox.clear();
			HTTP_Proxy_Page.Port_TextBox.sendKeys(proxyHostPort);
		}
		if (proxyHostUserName != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting proxy host username as " + proxyHostUserName);
			HTTP_Proxy_Page.UserName_TextBox.clear();
			HTTP_Proxy_Page.UserName_TextBox.sendKeys(proxyHostUserName);
		}
		if (proxyHostPassword != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting proxy host password as " + proxyHostPassword);
			HTTP_Proxy_Page.Password_TextBox.clear();
			HTTP_Proxy_Page.Password_TextBox.sendKeys(proxyHostPassword);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on submit button");
		HTTP_Proxy_Page.Submit_Button.click();
		wt.until(ExpectedConditions.visibilityOf(HTTP_Proxy_Page.Submit_Message));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking whether submit message contains :must restart: message");
		if (HTTP_Proxy_Page.Submit_Message.getText().contains("must restart")) {
			result = true;
		} else {
			result = false;
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Recieved message as " + HTTP_Proxy_Page.Submit_Message.getText());
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Expected result: " + expectedResult + " Actual result:" + result + " Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail"));
		Assert.assertEquals(result, expectedResult);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void VIPDiagnosticToolTest(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		boolean result = false;
		HTTP_Proxy_Page = PageFactory.initElements(driver, HTTPProxyPage.class);
		Settings_Home_Page = PageFactory.initElements(driver, SettingsHomePage.class);
		WebDriverWait wt = new WebDriverWait(driver, 20);
		boolean expectedResult = Boolean.valueOf(config.get("expected_result"));
		String proxyHostIP = config.get("proxy_host_ip");
		String proxyHostPort = config.get("proxy_host_port");
		String proxyHostUserName = config.get("proxy_username");
		String proxyHostPassword = config.get("proxy_password");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Settings_Tab.click();
		Settings_Home_Page.HTTP_Proxy_Settings_Tab.click();
		if (sHelper.isElementPresent(driver, HTTP_Proxy_Page.Edit_Button)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "proxy is already configured, so deleting");
			HTTP_Proxy_Page.Delete_Button.click();
		}
		if (proxyHostIP != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting proxy host IP as " + proxyHostIP);
			HTTP_Proxy_Page.Host_TextBox.clear();
			HTTP_Proxy_Page.Host_TextBox.sendKeys(proxyHostIP);
		}
		if (proxyHostPort != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting proxy host port as " + proxyHostPort);
			HTTP_Proxy_Page.Port_TextBox.clear();
			HTTP_Proxy_Page.Port_TextBox.sendKeys(proxyHostPort);
		}
		if (proxyHostUserName != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting proxy host username as " + proxyHostUserName);
			HTTP_Proxy_Page.UserName_TextBox.clear();
			HTTP_Proxy_Page.UserName_TextBox.sendKeys(proxyHostUserName);
		}
		if (proxyHostPassword != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting proxy host password as " + proxyHostPassword);
			HTTP_Proxy_Page.Password_TextBox.clear();
			HTTP_Proxy_Page.Password_TextBox.sendKeys(proxyHostPassword);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on submit button");
		HTTP_Proxy_Page.Submit_Button.click();
		wt.until(ExpectedConditions.visibilityOf(HTTP_Proxy_Page.Submit_Message));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking whether the submit message contains : must restart : message ");
		if (HTTP_Proxy_Page.Submit_Message.getText().contains("must restart")) {
			result = true;
		} else {
			result = false;
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Recieved message as " + HTTP_Proxy_Page.Submit_Message.getText());
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Expected result: " + expectedResult + " Actual result:" + result + " Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail"));
		Assert.assertEquals(result, expectedResult);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void DeleteUserStore(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 15);
		UserStore_Config_Page = PageFactory.initElements(driver, UserStoreConfigurationPage.class);
		DeleteUserStore_Page = PageFactory.initElements(driver, DeleteUserStorePage.class);
		String userStoreName = config.get("userstore_name");
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("User Store")));
		Configuration_Console_Home_Page.UserStore_Tab.click();
		List<WebElement> lst = DeleteUserStore_Page.Delete_Button_List;
		int size = lst.size();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "size of delete : " + size);
		for (int i = 0; i < size; i++) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Deleting existing user store");
			lst.get(0).click();
			Thread.sleep(2000);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking submit button");
			DeleteUserStore_Page.Submit_Button.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicked submit");
			Thread.sleep(2000);
		}
		/*
		 * int counter=0; while (DeleteUserStore_Page.Edit_Button.isEnabled()) {
		 * 
		 * logger.info("Thread-"+Thread.currentThread().getId()+": "+
		 * "User store is already configured, so deleting");
		 * DeleteUserStore_Page.Delete_Button.click(); Thread.sleep(2000);
		 * 
		 * logger.info("Thread-"+Thread.currentThread().getId()+": "+
		 * "clicking submit button");
		 * DeleteUserStore_Page.Submit_Button.click();
		 * 
		 * logger.info("Thread-"+Thread.currentThread().getId()+": "+
		 * "clicked submit"); counter++; if(counter==10) break; }
		 */
		if (sHelper.isElementPresent(driver, UserStore_Config_Page.UserStore_Sortable_Table)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "user store name check : " + userStoreName);
			List<WebElement> list = DeleteUserStore_Page.SSlListElement();
			for (WebElement li : list) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking User store in table  : " + li.findElement(By.xpath("div[@class='nameDiv']/div/a")).getText());
				if (userStoreName != null && (li.findElement(By.xpath("div[@class='nameDiv']/div/a")).getText().contains(userStoreName))) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Deleteing user store :  " + userStoreName);
					li.findElement(By.linkText("Delete")).click(); // /a[text()='Duplicate']")).click();
					// li.findElement(By.xpath("div[@class='actionDiv']/a[text()='Delete']")).click();
					// nameInternalDiv
					Thread.sleep(2000);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking submit button");
					DeleteUserStore_Page.Submit_Button.click();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicked submit");
					break;
				}
			}
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "No userstore exists");
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void SSPIdpConfigrationSetup(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Boolean result = false;
		String aliasName = config.get("alias_name");
		String hostName = "", url = "";
		String server = config.get("eg_server_host");
		boolean enableAutomaticDistribution = Boolean.valueOf(config.get("enable_automatic_distribution"));
		boolean enablePasswordManagement = Boolean.valueOf(config.get("ssp_enable_password_management"));
		boolean isHTTPS = Boolean.valueOf(config.get("is_https"));
		// final String saveSuccessMessage =
		// "Self Service Portal was added and started successfully.";
		final String saveSuccessMessage = "SSP IdP Service was added and started successfully.";
		final String saveUpdatedSuccessMessage = "service has been restarted";
		final String saveUpdatedSuccessMessageNoChange = "There is no change to update";
		if (isHTTPS) {
			hostName = config.get("ssl_hostname");
			url = "https://" + server + ":8233";
		}
		SSP_Configuration_Page = PageFactory.initElements(driver, SelfServicePortalIdPConfigurationPage.class);
		IdP_Home_Page = PageFactory.initElements(driver, IdentityProvidersHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		WebDriverWait wt = new WebDriverWait(driver, 60);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.elementToBeClickable(Configuration_Console_Home_Page.Identity_Providers_Tab));
		Configuration_Console_Home_Page.Identity_Providers_Tab.click();
		IdP_Home_Page.Self_Service_Portal_IdP_Tab.click();
		if (sHelper.isElementPresent(driver, SSP_Configuration_Page.Service_Status_Slider_Button)) {
			if (isHTTPS) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking edit button");
				SSP_Configuration_Page.Edit_Button1.click();
				Thread.sleep(3000);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering host name : " + hostName);
				SSP_Configuration_Page.Host_TextBox.clear();
				if (enablePasswordManagement) {
					SSP_Configuration_Page.Host_TextBox.sendKeys(server);
				} else {
					SSP_Configuration_Page.Host_TextBox.sendKeys(hostName);
				}
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering load balancer : " + url);
				SSP_Configuration_Page.LoadBalancer_TextBox.clear();
				SSP_Configuration_Page.LoadBalancer_TextBox.sendKeys(url);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking HTTPS button");
				// wt.until(ExpectedConditions
				// .elementToBeClickable(SSP_Configuration_Page.Enable_SSP_IDP_Yes_RadioButton));
				SSP_Configuration_Page.HTTPS_Enable_Yes_RadioButton.click();
				if (enableAutomaticDistribution) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enabling Automatic distribution to Yes");
					SSP_Configuration_Page.Enable_Automatic_Distribution_Yes_RadioButton.click();
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enabling Automatic distribution to No");
					SSP_Configuration_Page.Enable_Automatic_Distribution_No_RadioButton.click();
				}
				if (enablePasswordManagement) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enabling password Management");
					SSP_Configuration_Page.Enable_Password_Management.click();
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Disalbing password Management");
					SSP_Configuration_Page.Disable_Password_Management.click();
				}
				Thread.sleep(3000);
				List<WebElement> list = SSP_Configuration_Page.SSlListElement();
				for (WebElement li : list) {
					if (aliasName != null && li.findElement(By.className("certNameSSL")).getText().contains(aliasName)) {
						li.findElement(By.name("chkUserStore")).click();
					}
				}
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking apply changes button");
				SSP_Configuration_Page.Apply_Changes_Button.click();
				wt.until(ExpectedConditions.visibilityOf(SSP_Configuration_Page.Start_Service_Message));
				if (SSP_Configuration_Page.Start_Service_Message.getText().contains(saveUpdatedSuccessMessage)
						|| SSP_Configuration_Page.Start_Service_Message.getText().contains(saveUpdatedSuccessMessageNoChange)) {
					result = true;
					Assert.assertTrue(true);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "\nActual message was:" + SSP_Configuration_Page.Start_Service_Message.getText());
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "SSP IDP successfully configured");
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Expected message:" + saveUpdatedSuccessMessage + ". Actual Message:"
							+ SSP_Configuration_Page.Start_Service_Message.getText());
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Failed to configure SSP IdP");
					result = false;
					Assert.assertTrue(false, "Expected message:" + saveUpdatedSuccessMessage + ". Actual Message:" + SSP_Configuration_Page.Start_Service_Message.getText());
				}
			}
			result = true;
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + " was successful");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "SSP IdP is already configured");
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking SSP IDP Yes radio button");
			SSP_Configuration_Page.Enable_SSP_IDP_Yes_RadioButton.click();
			if (isHTTPS) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking HTTPS button");
				// wt.until(ExpectedConditions
				// .elementToBeClickable(SSP_Configuration_Page.Enable_SSP_IDP_Yes_RadioButton));
				SSP_Configuration_Page.HTTPS_Enable_Yes_RadioButton.click();
				Thread.sleep(3000);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering host name : " + hostName);
				SSP_Configuration_Page.Host_TextBox.clear();
				if (enablePasswordManagement) {
					SSP_Configuration_Page.Host_TextBox.sendKeys(server);
				} else {
					SSP_Configuration_Page.Host_TextBox.sendKeys(hostName);
				}
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering load balancer : " + url);
				SSP_Configuration_Page.LoadBalancer_TextBox.clear();
				SSP_Configuration_Page.LoadBalancer_TextBox.sendKeys(url);
				List<WebElement> list = SSP_Configuration_Page.SSlListElement();
				for (WebElement li : list) {
					if (aliasName != null && li.findElement(By.className("certNameSSL")).getText().contains(aliasName)) {
						li.findElement(By.name("chkUserStore")).click();
					}
				}
				if (enableAutomaticDistribution) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enabling Automatic distribution to Yes");
					SSP_Configuration_Page.Enable_Automatic_Distribution_Yes_RadioButton.click();
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enabling Automatic distribution to No");
					SSP_Configuration_Page.Enable_Automatic_Distribution_No_RadioButton.click();
				}
				if (enablePasswordManagement) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enabling password Management");
					SSP_Configuration_Page.Enable_Password_Management.click();
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Disalbing password Management");
					SSP_Configuration_Page.Disable_Password_Management.click();
				}
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking Start service button");
			SSP_Configuration_Page.Start_Service_Button.click();
			// Alert alert = wt.until(ExpectedConditions.alertIsPresent());
			// Accepting alert.
			// alert.accept();
			// System.out.println("Accepted the alert successfully.");
			wt.until(ExpectedConditions.elementToBeClickable(SSP_Configuration_Page.Service_Status_Slider_Button));
			if (SSP_Configuration_Page.Start_Service_Message.getText().equalsIgnoreCase(saveSuccessMessage)) {
				tBed.ConfigureSSPJettyForCodeCoverage(config);
				Assert.assertTrue(true);
				result = true;
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "\nActual message was:" + SSP_Configuration_Page.Start_Service_Message.getText());
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "SSP IDP successfully configured");
			} else {
				result = false;
				Assert.assertTrue(false, "Expected message:" + saveSuccessMessage + ". Actual Message:" + SSP_Configuration_Page.Start_Service_Message.getText());
				logger
				.info("Thread-" + Thread.currentThread().getId() + ": " + "Expected message:" + saveSuccessMessage + ". Actual Message:" + SSP_Configuration_Page.Start_Service_Message.getText());
				logger.error("Thread-" + Thread.currentThread().getId() + ": " + "Failed to configure SSP IdP");
			}

		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing SSP Cloud URL to " + config.get("selected_env"));
		if (config.get("selected_env").equalsIgnoreCase("qa")) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing SSP Cloud URL to " + config.get("selected_env"));
			rClient.PerformRemoteAction("ChangeSSPURL", config);
			StopSSPIDPService(driver);
			StartSSPIDPService(driver, true);

		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Test case status : " + (result == true ? "Pass" : " Fail"));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void StartSSPIDPService(WebDriver driver, Boolean expectedResult) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 45);
		Boolean result = false;
		SSP_Configuration_Page = PageFactory.initElements(driver, SelfServicePortalIdPConfigurationPage.class);
		IdP_Home_Page = PageFactory.initElements(driver, IdentityProvidersHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.elementToBeClickable(Configuration_Console_Home_Page.Identity_Providers_Tab));
		Configuration_Console_Home_Page.Identity_Providers_Tab.click();
		IdP_Home_Page.Self_Service_Portal_IdP_Tab.click();
		if (sHelper.isElementPresent(driver, SSP_Configuration_Page.Service_Status_Slider_Button)) {
			Thread.sleep(2000);
			String sliderStatus = SSP_Configuration_Page.Service_Status_Slider_Button.getAttribute("class");
			if (sliderStatus.equalsIgnoreCase("slider on")) {
				result = StopSSPIDPService(driver);
				Assert.assertEquals(result, expectedResult, " SSP IDP Service was ON, but stop SSP failed");
			}
			result = StartService(wt);
			Assert.assertEquals(result, expectedResult, " SSP IDP Service was OFF and start SSP service failed");
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expectedResult + "| | Actual result:" + result + " | | Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail") + " |");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void restartSSPIDPService(WebDriver driver, Boolean expectedResult) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 45);
		Boolean result = false;
		SSP_Configuration_Page = PageFactory.initElements(driver, SelfServicePortalIdPConfigurationPage.class);
		IdP_Home_Page = PageFactory.initElements(driver, IdentityProvidersHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.elementToBeClickable(Configuration_Console_Home_Page.Identity_Providers_Tab));
		Configuration_Console_Home_Page.Identity_Providers_Tab.click();
		IdP_Home_Page.Self_Service_Portal_IdP_Tab.click();
		if (sHelper.isElementPresent(driver, SSP_Configuration_Page.Service_Status_Slider_Button)) {
			Thread.sleep(2000);
			String sliderStatus = SSP_Configuration_Page.Service_Status_Slider_Button.getAttribute("class");
			if (sliderStatus.equalsIgnoreCase("slider on")) {
				result = StopSSPIDPService(driver);
				StartSSPIDPService(driver, expectedResult);
				Assert.assertEquals(result, expectedResult, " SSP IDP Service was ON, but stop SSP failed");
			} else if (sliderStatus.equalsIgnoreCase("slider off")) {
				StartSSPIDPService(driver, expectedResult);
			}
			sliderStatus = SSP_Configuration_Page.Service_Status_Slider_Button.getAttribute("class");
			if (sliderStatus.equalsIgnoreCase("slider on")) {
				Assert.assertTrue(true);
			} else if (sliderStatus.equalsIgnoreCase("slider off")) {
				Assert.assertTrue(false, ". SSP IDP Service is not started");
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	private Boolean StartService(WebDriverWait wt) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String sliderStatus;
		Boolean status = false;
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "SSP IDP service is currently not running. Starting the service..");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking the SSP IDP Slider button");
		SSP_Configuration_Page.Service_Status_Slider_Button.click();
		wt.until(ExpectedConditions.visibilityOf(SSP_Configuration_Page.Service_Status_Slider_Button));
		Thread.sleep(1000);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking identity provider tab");
		Configuration_Console_Home_Page.Identity_Providers_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking SSP IDP tab");
		IdP_Home_Page.Self_Service_Portal_IdP_Tab.click();
		Thread.sleep(1000);
		sliderStatus = SSP_Configuration_Page.Service_Status_Slider_Button.getAttribute("class");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Check Service status from slider button. Status : " + sliderStatus);
		if (sliderStatus.equalsIgnoreCase("slider on")) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + ": Successfully Started SSP IDP Service");
			status = true;
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + ": Failed to start SSP IDP Service");
			status = false;
		}
		return status;
	}

	public Boolean StopSSPIDPService(WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 45);
		Boolean status = false;
		SSP_Configuration_Page = PageFactory.initElements(driver, SelfServicePortalIdPConfigurationPage.class);
		IdP_Home_Page = PageFactory.initElements(driver, IdentityProvidersHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.elementToBeClickable(Configuration_Console_Home_Page.Identity_Providers_Tab));
		Configuration_Console_Home_Page.Identity_Providers_Tab.click();
		IdP_Home_Page.Self_Service_Portal_IdP_Tab.click();
		if (sHelper.isElementPresent(driver, SSP_Configuration_Page.Service_Status_Slider_Button)) {
			String sliderStatus = SSP_Configuration_Page.Service_Status_Slider_Button.getAttribute("class");
			if (sliderStatus.equalsIgnoreCase("slider off")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + ": Successfully Stopped SSP IdP Service");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "SSP IdP is already stopped");
			} else {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "SSP IDP service is currently running. Stopping the service..");
				SSP_Configuration_Page.Service_Status_Slider_Button.click();
				Thread.sleep(5000);
				wt.until(ExpectedConditions.visibilityOf(SSP_Configuration_Page.Service_Status_Slider_Button));
				IdP_Home_Page.Self_Service_Portal_IdP_Tab.click();
				sliderStatus = SSP_Configuration_Page.Service_Status_Slider_Button.getAttribute("class");
				if (sliderStatus.equalsIgnoreCase("slider off")) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + ": Successfully Stopped SSP IDP Service");
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Successfully Stopped SSP IDP Service");
					status = true;
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + ": Failed to stop SSP IDP Service");
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Failed to stop SSP IDP Service");
					status = false;
				}
			}
		}
		return status;
	}

	public void ImportSettingsWithPassword(Map<String, String> config, WebDriver driver) throws Exception {
		Import_Settings_Page = PageFactory.initElements(driver, ImportSettingsPage.class);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Initializing the variable values started ");
		boolean result = false;
		String path;
		// String
		// errorTextExpectedForPwdMatch="Failed to import. Make sure the encryption password is correct.";
		boolean expectedResult = Boolean.valueOf(config.get("expected_result"));
		// boolean expectedResult=false;
		String settings = config.get("settings");
		// String settings="asdsad,asdsad";
		String password = config.get("password");
		boolean flag = settings.isEmpty() ? true : false;
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "EG Version " + Import_Settings_Page.Version_Label.getText());
		path = Import_Settings_Page.Version_Label.getText().contains("Windows") ? "C:\\Automation\\Resources\\importfiles\\windows_password.zip"
				: "C:\\Automation\\Resources\\importfiles\\linux_password.zip";
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Initializing the variable values completed");
		WebDriverWait wt = new WebDriverWait(driver, 30);
		String[] itemSettings = settings.split(",");
		if (sHelper.isElementPresent(driver, Import_Settings_Page.Tab_Settings)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Settings tab");
			Import_Settings_Page.Tab_Settings.click();
			if (sHelper.isElementPresent(driver, Import_Settings_Page.Link_ImportSettings)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Import Settings ");
				Import_Settings_Page.Link_ImportSettings.click();
			}
			Thread.sleep(2000);
			// wt.until(ExpectedConditions
			// .visibilityOf(Import_Settings_Page.Import_Button));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Import button");
			Import_Settings_Page.Import_Button.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to the import window");
			driver.switchTo().frame(0);
			// driver.manage().timeouts().pageLoadTimeout(45,
			// TimeUnit.SECONDS);
			// driver.manage().timeouts().implicitlyWait(20,
			// TimeUnit.SECONDS);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Sending path key to browse field ");
			Import_Settings_Page.BrowsePath_Field.sendKeys(path);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking Next  button ");
			Import_Settings_Page.Next_Button.click();
			// Thread.sleep(6000);
			wt.until(ExpectedConditions.visibilityOf((Import_Settings_Page.Password_Field)));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Sending password to password field ");
			Import_Settings_Page.Password_Field.sendKeys(password);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking Next  button ");
			Import_Settings_Page.Next_Button.click();
			if (Import_Settings_Page.Error_label.isDisplayed()) {
				result = false;
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "exiting due to wrong password");
				return;
			}
			if (flag) {
				result = false;
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "exiting due to empty input");
				return;
			}
			if (itemSettings[0].contains("All"))
				Import_Settings_Page.Next_Button.click();
			else {
				List<WebElement> checkBxs = Import_Settings_Page.Get_Webelements();
				for (WebElement checkBx : checkBxs) {
					checkBx.click();
				}
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Unchecked all boxes");
				for (String setting : itemSettings) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "input setting from json: " + setting);
					for (WebElement checkBx : checkBxs) {
						if (checkBx.getAttribute("id").equals(setting)) {
							checkBx.click();
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking the box " + checkBx.getAttribute("id"));
						}
					}
				}
			}
			// driver.manage().timeouts().pageLoadTimeout(45,
			// TimeUnit.SECONDS);
			// driver.manage().timeouts().implicitlyWait(20,
			// TimeUnit.SECONDS);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking whether next button is active");
			if (Import_Settings_Page.Next_Button.isEnabled()) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking next button");
				Import_Settings_Page.Next_Button.click();
				wt.until(ExpectedConditions.visibilityOf((Import_Settings_Page.Finish_button)));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking finish button");
				Import_Settings_Page.Finish_button.click();
			} else {
				result = false;
				return;
			}
			result = true;
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Settings tab missing/mismatch in EG");
			result = false;
			return;
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to main page");
		driver.switchTo().defaultContent();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expectedResult + "| | Actual result:" + result + " | | Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail") + " |");
		Assert.assertEquals(result, expectedResult);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Exit: ImportSettings ");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void StartAllValidationServers(Map<String, String> config, WebDriver driver) throws Exception {
		findAndActOnValidationServer(driver, null, "startall");
	}

	public void StartAllTunnelServers(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String tunneServerName;
		String tunnelServerType;
		WebDriverWait wt = new WebDriverWait(driver, 60);
		int flag = 0;
		boolean pagination;
		Validation_Main_Page = PageFactory.initElements(driver, ValidationMainPage.class);
		Tunnel_Server_Home_Page = PageFactory.initElements(driver, TunnelServerHomePage.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Validation tab");
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Validation")));
		Configuration_Console_Home_Page.Validation_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Tunnel Server tab");
		Validation_Main_Page.Tab_TunnelServer.click();
		wt.until(ExpectedConditions.elementToBeClickable(Tunnel_Server_Home_Page.Button_AddServer));
		List<WebElement> listOfServers = null;
		int noOfRows = 0;
		String state = Tunnel_Server_Home_Page.Pagination_Table.getAttribute("class");
		String status = null;
		if (state.contains("disabled")) {
			pagination = false;
		} else {
			pagination = true;
		}
		for (int j = 1; j <= 10; j++) {
			if (pagination) {
				Tunnel_Server_Home_Page.PageNo_TextBox.clear();
				Tunnel_Server_Home_Page.PageNo_TextBox.sendKeys(Integer.toString(j));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Navigating to tunnel server page " + Integer.toString(j) + " to restart the tunnel server");
				Tunnel_Server_Home_Page.PageNo_TextBox.sendKeys(Keys.RETURN);
			}
			listOfServers = Tunnel_Server_Home_Page.TunnelServersList_Table;
			noOfRows = listOfServers.size();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Landed to " + j + " page. Total Servers are: " + (noOfRows - 1));
			flag = flag + 1;
			for (int x = 2; x <= noOfRows; x++) {
				logger.info("Starting all the Receivers First");
				if (pagination) {
					Tunnel_Server_Home_Page.PageNo_TextBox.clear();
					Tunnel_Server_Home_Page.PageNo_TextBox.sendKeys(Integer.toString(j));
					Tunnel_Server_Home_Page.PageNo_TextBox.sendKeys(Keys.RETURN);
				}
				tunneServerName = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + x + "]/td[1]/a")).getText();
				tunnelServerType = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + x + "]/td[2]/span")).getText();
				logger.info("Tunnel Server Type is " + tunnelServerType);
				if (tunnelServerType.contains("Receiver")) {
					String startMsg = tunneServerName + " was started successfully.";
					status = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + x + "]/td[4]/div/div")).getAttribute("class");
					if (status.equalsIgnoreCase("slider on")) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Validation Server " + tunneServerName + " already in started state");
					} else {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Starting the tunnel server " + tunneServerName);
						driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + x + "]/td[4]/div/div")).click();
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Waiting for the Start tunnel server status message .");
						wt.until(ExpectedConditions.visibilityOf(Tunnel_Server_Home_Page.Action_Message));
						Assert.assertTrue(Tunnel_Server_Home_Page.Action_Message.getText().contains(startMsg), "Expected Message " + startMsg + ". Actual: "
								+ Tunnel_Server_Home_Page.Action_Message.getText());
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Tunnel server start status : " + Tunnel_Server_Home_Page.Action_Message.getText());
					}
				}
			}
			int i = 0;
			for (i = 2; i <= noOfRows; i++) {
				if (pagination) {
					Tunnel_Server_Home_Page.PageNo_TextBox.clear();
					Tunnel_Server_Home_Page.PageNo_TextBox.sendKeys(Integer.toString(j));
					Tunnel_Server_Home_Page.PageNo_TextBox.sendKeys(Keys.RETURN);
				}
				for (int x = 2; x <= noOfRows; x++) {
					if (pagination) {
						Tunnel_Server_Home_Page.PageNo_TextBox.clear();
						Tunnel_Server_Home_Page.PageNo_TextBox.sendKeys(Integer.toString(j));
						Tunnel_Server_Home_Page.PageNo_TextBox.sendKeys(Keys.RETURN);
					}
					tunneServerName = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[1]/a")).getText();
					tunnelServerType = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[2]/span")).getText();
					logger.info("Tunnel Server Type is " + tunnelServerType);
					String startMsg = tunneServerName + " was started successfully.";
					status = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[4]/div/div")).getAttribute("class");
					if (status.equalsIgnoreCase("slider on")) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Validation Server " + tunneServerName + " already in started state");
					} else {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Starting the tunnel server " + tunneServerName);
						driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[4]/div/div")).click();
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Waiting for the Start tunnel server status message .");
						wt.until(ExpectedConditions.visibilityOf(Tunnel_Server_Home_Page.Action_Message));
						Assert.assertTrue(Tunnel_Server_Home_Page.Action_Message.getText().contains(startMsg), "Expected Message " + startMsg + ". Actual: "
								+ Tunnel_Server_Home_Page.Action_Message.getText());
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Tunnel server start status : " + Tunnel_Server_Home_Page.Action_Message.getText());
					}
				}
				tunneServerName = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[1]/a")).getText();
				tunnelServerType = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[2]/span")).getText();
				logger.info("Tunnel Server Type is " + tunnelServerType);
				String startMsg = tunneServerName + " was started successfully.";
				status = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[4]/div/div")).getAttribute("class");
				if (status.equalsIgnoreCase("slider on")) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Validation Server " + tunneServerName + " already in started state");
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Starting the tunnel server " + tunneServerName);
					driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[4]/div/div")).click();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Waiting for the Start tunnel server status message .");
					wt.until(ExpectedConditions.visibilityOf(Tunnel_Server_Home_Page.Action_Message));
					Assert.assertTrue(Tunnel_Server_Home_Page.Action_Message.getText().contains(startMsg), "Expected Message " + startMsg + ". Actual: "
							+ Tunnel_Server_Home_Page.Action_Message.getText());
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Tunnel server start status : " + Tunnel_Server_Home_Page.Action_Message.getText());
				}
			}
			if (!pagination) {
				break;
			}
		}
	}

	public void StartValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String valServerName = config.get("validation_server_name");
		findAndActOnValidationServer(driver, valServerName, "start");
	}

	public void StopValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String valServerName = config.get("validation_server_name");
		findAndActOnValidationServer(driver, valServerName, "stop");
	}

	public void RestartValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String valServerName = config.get("validation_server_name");
		findAndActOnValidationServer(driver, valServerName, "restart");
	}

	public void startOrRestartValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String valServerName = config.get("validation_server_name");
		findAndActOnValidationServer(driver, valServerName, "startOrRestart");
	}

	public void StartVIPManagerIDPService(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 45);
		VIP_Manager_Idp_Config_Page = PageFactory.initElements(driver, VIPManagerIdpConfiguraionPage.class);
		IdP_Home_Page = PageFactory.initElements(driver, IdentityProvidersHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.elementToBeClickable(Configuration_Console_Home_Page.Identity_Providers_Tab));
		Configuration_Console_Home_Page.Identity_Providers_Tab.click();
		IdP_Home_Page.VIP_Manager_IdP_Tab.click();
		if (sHelper.isElementPresent(driver, VIP_Manager_Idp_Config_Page.Edit_Button)) {
			String sliderStatus = VIP_Manager_Idp_Config_Page.Service_Status_Slider_Button.getAttribute("class");
			if (sliderStatus.equalsIgnoreCase("slider on")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + ": Successfully Started VIP manager IDP Service");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Manager IdP is already started");
			} else {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP manager IDP service is currently not running. Starting the service..");
				VIP_Manager_Idp_Config_Page.Service_Status_Slider_Button.click();
				wt.until(ExpectedConditions.visibilityOf(VIP_Manager_Idp_Config_Page.Service_Status_Slider_Button));
				Configuration_Console_Home_Page.Identity_Providers_Tab.click();
				IdP_Home_Page.VIP_Manager_IdP_Tab.click();
				sliderStatus = VIP_Manager_Idp_Config_Page.Service_Status_Slider_Button.getAttribute("class");
				if (sliderStatus.equalsIgnoreCase("slider on")) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + ": Successfully Started VIP manager IDP Service");
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Successfully Started VIP manager IDP Service");
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + ": Failed to start VIP manager IDP Service");
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Failed to start VIP manager IDP Service");
					Assert.assertTrue(false, "Unable to start VIP Manager IDP Service");
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void StopVIPManagerIDPService(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 45);
		VIP_Manager_Idp_Config_Page = PageFactory.initElements(driver, VIPManagerIdpConfiguraionPage.class);
		IdP_Home_Page = PageFactory.initElements(driver, IdentityProvidersHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.elementToBeClickable(Configuration_Console_Home_Page.Identity_Providers_Tab));
		Configuration_Console_Home_Page.Identity_Providers_Tab.click();
		IdP_Home_Page.VIP_Manager_IdP_Tab.click();
		if (sHelper.isElementPresent(driver, VIP_Manager_Idp_Config_Page.Edit_Button)) {
			String sliderStatus = VIP_Manager_Idp_Config_Page.Service_Status_Slider_Button.getAttribute("class");
			if (sliderStatus.equalsIgnoreCase("slider off")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + ": Successfully Stopped VIP manager IDP Service");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Manager IdP is already in stopped state");
			} else {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP manager IDP service is currently running. Stopping the service..");
				VIP_Manager_Idp_Config_Page.Service_Status_Slider_Button.click();
				wt.until(ExpectedConditions.visibilityOf(VIP_Manager_Idp_Config_Page.Service_Status_Slider_Button));
				Configuration_Console_Home_Page.Identity_Providers_Tab.click();
				IdP_Home_Page.VIP_Manager_IdP_Tab.click();
				sliderStatus = VIP_Manager_Idp_Config_Page.Service_Status_Slider_Button.getAttribute("class");
				if (sliderStatus.equalsIgnoreCase("slider off")) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + ": Successfully Stopped VIP manager IDP Service");
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Successfully stopped VIP manager IDP Service");
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + ": Failed to stop VIP manager IDP Service");
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Failed to stop VIP manager IDP Service");
					Assert.assertTrue(false, "Unable to stop VIP Manager IDP Service");
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void VIPAdministratorConfigration(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		boolean result = false;
		boolean expectedResult = Boolean.valueOf(config.get("expected_result_vipadmin"));
		final String userStoreName = config.get("vip_admin_userstore");
		final String baseDN = config.get("vip_admin_base_dn");
		final String userFilter = config.get("vip_admin_user_filter");
		final String groupFilter = config.get("vip_admin_group_fliter");
		final String testUserName = config.get("vip_admin_test_user");
		final String testSuccessMessage = "Test connection is successful.";
		final String saveSuccessMessage = "VIP Administrator has been configured successfully.";
		VIP_Admin_Config_Page = PageFactory.initElements(driver, VIPAdministratorConfigurationPage.class);
		UserStore_Main_Page = PageFactory.initElements(driver, UserStoreMainPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		WebDriverWait wt = new WebDriverWait(driver, 15);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("User Store")));
		Configuration_Console_Home_Page.UserStore_Tab.click();
		UserStore_Main_Page.VIP_Administrator_Configuration_Tab.click();
		if (sHelper.isElementPresent(driver, VIP_Admin_Config_Page.Edit_Button)) {
			result = true;
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + " was successful");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Administrator is already configured");
			return;
		} else {
			VIP_Admin_Config_Page.Enable_VIPAdministrator_Yes_RadioButton.click();
			Select dropdown = new Select(VIP_Admin_Config_Page.UserStore_Name_Selection_Box);
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).equalsIgnoreCase(userStoreName.toLowerCase())) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing the userStore to " + userStoreName);
					option.click();
					break;
				}
			}
			Thread.sleep(1000);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering base dn : " + baseDN);
			VIP_Admin_Config_Page.BaseDN_TextBox.clear();
			VIP_Admin_Config_Page.BaseDN_TextBox.sendKeys(baseDN);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering user Filter : " + userFilter);
			VIP_Admin_Config_Page.UserFilter_TextBox.clear();
			VIP_Admin_Config_Page.UserFilter_TextBox.sendKeys(userFilter);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering group Filter : " + groupFilter);
			VIP_Admin_Config_Page.GroupFilter_TextBox.clear();
			VIP_Admin_Config_Page.GroupFilter_TextBox.sendKeys(groupFilter);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering testUserName : " + testUserName);
			VIP_Admin_Config_Page.TestUser_TextBox.clear();
			VIP_Admin_Config_Page.TestUser_TextBox.sendKeys(testUserName);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking test button");
			VIP_Admin_Config_Page.Test_Button.click();
			Thread.sleep(1000);
			// String a = VIP_Admin_Config_Page.Test_Message.getText();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking test message");
			if (VIP_Admin_Config_Page.Test_Message.getText().equalsIgnoreCase(testSuccessMessage)) {
				result = true;
			} else {
				result = false;
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking save button");
			VIP_Admin_Config_Page.Save_Button.click();
			Thread.sleep(6000);
			wt.until(ExpectedConditions.visibilityOf(VIP_Admin_Config_Page.Save_Message));
			// String b = VIP_Admin_Config_Page.Save_Message.getText();
			String testMsgActual = VIP_Admin_Config_Page.Save_Message.getText();
			if (testMsgActual.contains(saveSuccessMessage) && (result)) {
				result = true;
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "\nActual message was:" + VIP_Admin_Config_Page.Save_Message.getText());
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Administrator successfully configured");
			} else {
				result = false;
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Expected message:" + saveSuccessMessage + ". Actual Message:" + VIP_Admin_Config_Page.Save_Message.getText()
				+ ". Test message expected was:" + testSuccessMessage + ". But received from UI was:" + testMsgActual);
				logger.error("Thread-" + Thread.currentThread().getId() + ": " + "Failed to configure VIP Administrator");
			}
			if (result) {
				if (config.get("selected_env").equalsIgnoreCase("qa")) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing LDAP Sync Cloud REST ful URL to " + config.get("selected_env"));
					rClient.PerformRemoteAction("ChangeRestfulURLs", config);
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expectedResult + "| | Actual result:" + result + " | | Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail") + " |");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertEquals(result, expectedResult);
	}

	public void VIPManagerIdpConfigration(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		final String saveSuccessMessage = "VIP Manager service was added and started successfully.";
		final String saveUpdatedSuccessMessage = "service has been restarted";
		final String editUpdateChangesMessage = "Your changes have been applied, and the service has been restarted.";
		final String saveUpdatedSuccessMessageNoChange = "There is no change to update";
		Boolean result = false;
		String hostName = "", url = "";
		boolean expectedResult = Boolean.valueOf(config.get("expected_result_vipadmin"));
		boolean isHTTPS = Boolean.valueOf(config.get("is_https"));
		String aliasName = config.get("alias_name");
		String server = config.get("eg_server_host");
		VIP_Manager_Idp_Config_Page = PageFactory.initElements(driver, VIPManagerIdpConfiguraionPage.class);
		IdP_Home_Page = PageFactory.initElements(driver, IdentityProvidersHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		if (isHTTPS) {
			hostName = config.get("ssl_hostname"); //
			url = "https://" + server + ":8234";
		}
		WebDriverWait wt = new WebDriverWait(driver, 60);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.elementToBeClickable(Configuration_Console_Home_Page.Identity_Providers_Tab));
		Configuration_Console_Home_Page.Identity_Providers_Tab.click();
		IdP_Home_Page.VIP_Manager_IdP_Tab.click();
		if (!sHelper.isElementPresent(driver, VIP_Manager_Idp_Config_Page.Enable_VIPManagerIdP_Yes_RadioButton)) {
			if (isHTTPS) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking edit button");
				wt.until(ExpectedConditions.elementToBeClickable(VIP_Manager_Idp_Config_Page.Edit_Button));
				VIP_Manager_Idp_Config_Page.Edit_Button.click();
				Thread.sleep(3000);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering host name : " + hostName);
				VIP_Manager_Idp_Config_Page.Host_TextBox.clear();
				VIP_Manager_Idp_Config_Page.Host_TextBox.sendKeys(hostName);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering load balancer : " + url);
				VIP_Manager_Idp_Config_Page.LoadBalancer_TextBox.clear();
				VIP_Manager_Idp_Config_Page.LoadBalancer_TextBox.sendKeys(url);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking HTTPS button");
				// wt.until(ExpectedConditions
				// .elementToBeClickable(SSP_Configuration_Page.Enable_SSP_IDP_Yes_RadioButton));
				VIP_Manager_Idp_Config_Page.HTTPS_Enable_Yes_RadioButton.click();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicked HTTPS button");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "ssl cert name: " + aliasName);
				List<WebElement> list = VIP_Manager_Idp_Config_Page.SSlListElement();
				for (WebElement li : list) {
					if (aliasName != null && li.findElement(By.className("certNameSSL")).getText().contains(aliasName)) {
						li.findElement(By.name("chkUserStore")).click();
					}
				}
				VIP_Manager_Idp_Config_Page.Apply_Changes_Button.click();
				wt.until(ExpectedConditions.visibilityOf(VIP_Manager_Idp_Config_Page.Start_Service_Message));
				if (VIP_Manager_Idp_Config_Page.Start_Service_Message.getText().contains(editUpdateChangesMessage)
						|| VIP_Manager_Idp_Config_Page.Start_Service_Message.getText().contains(saveUpdatedSuccessMessageNoChange)) {
					result = true;
					Assert.assertTrue(true);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "\nActual message was:" + VIP_Manager_Idp_Config_Page.Start_Service_Message.getText());
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Manager IDP successfully configured");
				} else {
					result = false;
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Expected message:" + saveUpdatedSuccessMessage + ". Actual Message:"
							+ VIP_Manager_Idp_Config_Page.Start_Service_Message.getText());
					logger.error("Thread-" + Thread.currentThread().getId() + ": " + "Failed to configure VIP Manager IdP");
					Assert.assertTrue(false, "Expected message:" + saveUpdatedSuccessMessage + ". Actual Message:" + VIP_Manager_Idp_Config_Page.Start_Service_Message.getText());
				}
				// Alert alert =
				// wt.until(ExpectedConditions.alertIsPresent());
				// Accepting alert.
				// alert.accept();
				// System.out.println("Accepted the alert successfully.");
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + "VIP Manager IDP configured successfully");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Manager IdP is already configured");
			return;
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Yes radio button to configure VIP manager");
			VIP_Manager_Idp_Config_Page.Enable_VIPManagerIdP_Yes_RadioButton.click();
			Thread.sleep(3000);
			if (isHTTPS) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering host name : " + hostName);
				VIP_Manager_Idp_Config_Page.Host_TextBox.clear();
				VIP_Manager_Idp_Config_Page.Host_TextBox.sendKeys(hostName);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering load balancer : " + url);
				VIP_Manager_Idp_Config_Page.LoadBalancer_TextBox.clear();
				VIP_Manager_Idp_Config_Page.LoadBalancer_TextBox.sendKeys(url);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking HTTPS button");
				// wt.until(ExpectedConditions
				// .elementToBeClickable(SSP_Configuration_Page.Enable_SSP_IDP_Yes_RadioButton));
				VIP_Manager_Idp_Config_Page.HTTPS_Enable_Yes_RadioButton.click();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicked HTTPS button");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "ssl cert name: " + aliasName);
				List<WebElement> list = VIP_Manager_Idp_Config_Page.SSlListElement();
				for (WebElement li : list) {
					if (aliasName != null && li.findElement(By.className("certNameSSL")).getText().contains(aliasName)) {
						li.findElement(By.name("chkUserStore")).click();
					}
				}
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "trying to start the service");
			VIP_Manager_Idp_Config_Page.Start_Service_Button.click();
			// Alert alert = wt.until(ExpectedConditions.alertIsPresent());
			// alert.accept();
			// System.out.println("Accepted the alert successfully.");
			wt.until(ExpectedConditions.visibilityOf(VIP_Manager_Idp_Config_Page.Start_Service_Message));
			if (VIP_Manager_Idp_Config_Page.Start_Service_Message.getText().equalsIgnoreCase(saveSuccessMessage)) {
				result = true;
				tBed.ConfigureVIPMGRJettyForCodeCoverage(config);
				Assert.assertTrue(true);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "\nActual message was:" + VIP_Manager_Idp_Config_Page.Start_Service_Message.getText());
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Manager IDP successfully configured");
			} else {
				result = false;
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Expected message:" + saveSuccessMessage + ". Actual Message:"
						+ VIP_Manager_Idp_Config_Page.Start_Service_Message.getText());
				logger.error("Thread-" + Thread.currentThread().getId() + ": " + "Failed to configure VIP Manager IdP");
				Assert.assertTrue(false, "Expected message:" + saveSuccessMessage + ". Actual Message:" + VIP_Manager_Idp_Config_Page.Start_Service_Message.getText());
			}
			if (result) {
				if (config.get("selected_env").equalsIgnoreCase("qa")) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing VIP Manager Cloud URL to " + config.get("selected_env"));
					rClient.PerformRemoteAction("ChangeVIPManagerURL", config);
					StopVIPManagerIDPService(config, driver);
					StartVIPManagerIDPService(config, driver);
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expectedResult + "| | Actual result:" + result + " | | Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail") + " |");
		// Assert.assertEquals(result, expectedResult);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void ConfigureLDAPSync(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 45);
		boolean result = false, expectedResult = Boolean.valueOf(config.get("expected_result_vipadmin"));
		String successMessage = "Ldap sync has been configured.";
		String successMessage1 = "Ldap Sync was successfully updated.";
		LDAP_Sync_Config_Page = PageFactory.initElements(driver, LDAPDirectorySyncronizationConfigurationPage.class);
		UserStore_Main_Page = PageFactory.initElements(driver, UserStoreMainPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String status = null;
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("User Store")));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "CLicking User store tab");
		Configuration_Console_Home_Page.UserStore_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "CLicking LDAP Sync tab");
		UserStore_Main_Page.LDAPSync_Tab.click();
		// boolean changeURLRequired = false;
		if (!sHelper.isElementPresent(driver, LDAP_Sync_Config_Page.LDAPSync_Edit_Button)) {
			LDAP_Sync_Config_Page.Enable_LDAPSync_Yes_RadioButton.click();
			// changeURLRequired = true;
		}
		LDAP_Sync_Config_Page.LDAPSync_Edit_Button.click();
		if (!LDAP_Sync_Config_Page.Enable_UserSync_Root_CheckBox.isSelected()) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicked the enable user sync root checkbox");
			LDAP_Sync_Config_Page.Enable_UserSync_Root_CheckBox.click();
		}
		if (!LDAP_Sync_Config_Page.Enable_AdminSync_Root_CheckBox.isSelected()) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking the admin sync root checkbox");
			LDAP_Sync_Config_Page.Enable_AdminSync_Root_CheckBox.click();
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicked the admin sync root checkbox");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking save button");
		LDAP_Sync_Config_Page.Save_Changes_Button.click();
		wt.until(ExpectedConditions.elementToBeClickable(LDAP_Sync_Config_Page.Service_StartStop_Slider));
		status = LDAP_Sync_Config_Page.Save_Changes_Message.getText();
		if (status.contains(successMessage) || status.contains(successMessage1)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + " was successful");
			result = true;
		} else {
			result = false;
		}
		// if (result && changeURLRequired) {
		// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
		// "Changing LDAP Sync Cloud REST ful URL to " +
		// config.get("selected_env"));
		// rClient.PerformRemoteAction("ChangeRestfulURLs", config);
		// }
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expectedResult + "| | Actual result:" + result + " | | Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail") + " |");
		Assert.assertEquals(result, expectedResult, status);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void StartLDAPSyncService(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 45);
		LDAP_Sync_Config_Page = PageFactory.initElements(driver, LDAPDirectorySyncronizationConfigurationPage.class);
		UserStore_Main_Page = PageFactory.initElements(driver, UserStoreMainPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("User Store")));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking user store tab");
		Configuration_Console_Home_Page.UserStore_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking LDAP sync tab");
		UserStore_Main_Page.LDAPSync_Tab.click();
		if (sHelper.isElementPresent(driver, LDAP_Sync_Config_Page.LDAPSync_Edit_Button)) {
			String status = LDAP_Sync_Config_Page.Service_StartStop_Slider.getAttribute("class");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking if slider is OFF");
			if (status.equalsIgnoreCase("slider on")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "LDAP Sync service is already in started state");
			} else {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Starting LDAP Sync Service ");
				LDAP_Sync_Config_Page.Service_StartStop_Slider.click();
				wt.until(ExpectedConditions.elementToBeClickable(LDAP_Sync_Config_Page.Service_StartStop_Slider));
				Thread.sleep(1000);
				status = LDAP_Sync_Config_Page.Service_StartStop_Slider.getAttribute("class");
				if (status.equalsIgnoreCase("slider on")) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "LDAP Sync service successfully started");
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Could not start LDAP Sync Service");
					Assert.assertTrue(false, "Could not start LDAP Sync Service");
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void StopLDAPSyncService(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 45);
		LDAP_Sync_Config_Page = PageFactory.initElements(driver, LDAPDirectorySyncronizationConfigurationPage.class);
		UserStore_Main_Page = PageFactory.initElements(driver, UserStoreMainPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("User Store")));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking user store tab");
		Configuration_Console_Home_Page.UserStore_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking LDAP Sync tab");
		UserStore_Main_Page.LDAPSync_Tab.click();
		if (sHelper.isElementPresent(driver, LDAP_Sync_Config_Page.LDAPSync_Edit_Button)) {
			String status = LDAP_Sync_Config_Page.Service_StartStop_Slider.getAttribute("class");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Check if slider is OFF");
			if (status.equalsIgnoreCase("slider off")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "LDAP Sync service is already in stopped state");
			} else {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Stopping LDAP Sync Service ");
				LDAP_Sync_Config_Page.Service_StartStop_Slider.click();
				wt.until(ExpectedConditions.elementToBeClickable(LDAP_Sync_Config_Page.Service_StartStop_Slider));
				Thread.sleep(1000);
				status = LDAP_Sync_Config_Page.Service_StartStop_Slider.getAttribute("class");
				if (status.equalsIgnoreCase("slider off")) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "LDAP Sync service successfully stopped");
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Could not stop LDAP Sync Service");
					Assert.assertTrue(false, "Could not stop LDAP Sync Service");
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void ConfigureVIPAdminGroupMappingAndAttributes(Map<String, String> config, WebDriver driver) throws Exception {
		// String messageAfterSavingVIPAdminAttributes =
		// "Administrator attributes have been saved successfully.";
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Boolean result = false, expectedResult = Boolean.valueOf(config.get("expected_result_vipadmin"));
		String messageAfterCreatingAdminGroupMapping = "successfully";
		final String firstNameAttribute = config.get("firstname_attribute");
		final String lastNameAttribute = config.get("lastname_attribute");
		final String adminGroupMappingName = config.get("group_mapping_name");
		final String membershipAttributeName = config.get("membership_attribute_name");
		final String memberShipGroupDN = config.get("membership_group_dn");
		final String vipAdministrtorGroupName = config.get("vip_administrator_group_name");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "firstNameAttribute :" + firstNameAttribute);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "lastNameAttribute :" + lastNameAttribute);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "adminGroupMappingName :" + adminGroupMappingName);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "membershipAttributeName :" + membershipAttributeName);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "memberShipGroupDN :" + memberShipGroupDN);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "vipAdministrtorGroupName :" + vipAdministrtorGroupName);
		VIP_Admin_Config_Page = PageFactory.initElements(driver, VIPAdministratorConfigurationPage.class);
		UserStore_Main_Page = PageFactory.initElements(driver, UserStoreMainPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		// WebElement frame = driver.findElement(By.tagName("IFRAME"));
		WebDriverWait wt = new WebDriverWait(driver, 15);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("User Store")));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking user store tab");
		Configuration_Console_Home_Page.UserStore_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking VIP_Administrator_Configuration tab");
		UserStore_Main_Page.VIP_Administrator_Configuration_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking Edit button");
		VIP_Admin_Config_Page.Edit_Button.click();
		wt.until(ExpectedConditions.elementToBeClickable(VIP_Admin_Config_Page.Synchronization_Tab));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking Synchronization tab");
		VIP_Admin_Config_Page.Synchronization_Tab.click();
		if (sHelper.isElementPresent(driver, VIP_Admin_Config_Page.AdminGroupMapping_Delete_Link)) {
			result = true;
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + (Thread.currentThread().getStackTrace()[1].getMethodName()) + " was successful");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Admin Group Mapping is already configured");
		} else {
			VIP_Admin_Config_Page.VIPAdminAttributes_FirstNameAttribute_TextBox.clear();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Filling first name attribute  field with value: " + firstNameAttribute);
			VIP_Admin_Config_Page.VIPAdminAttributes_FirstNameAttribute_TextBox.sendKeys(firstNameAttribute);
			VIP_Admin_Config_Page.VIPAdminAttributes_LastNameAttribute_TextBox.clear();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Filling last name attribute field with value: " + lastNameAttribute);
			VIP_Admin_Config_Page.VIPAdminAttributes_LastNameAttribute_TextBox.sendKeys(lastNameAttribute);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking Apply changes button");
			VIP_Admin_Config_Page.VIPAdminAttributes_ApplyChanges_Button.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking Add New button in group mapping");
			VIP_Admin_Config_Page.AddNewGroupMapping_Link.click();
			Thread.sleep(2000);
			driver.switchTo().activeElement();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Filling admin Group Mapping Name field with value: " + adminGroupMappingName);
			VIP_Admin_Config_Page.AdminGroupMapping_Name_TextBox.sendKeys(adminGroupMappingName);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Filling membership Attribute Name field with value: " + membershipAttributeName);
			VIP_Admin_Config_Page.AdminGroupMapping_Membership_AttributeName_TextBox.sendKeys(membershipAttributeName);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Filling memberShip Group DN field with value: " + memberShipGroupDN);
			VIP_Admin_Config_Page.AdminGroupMapping_Membership_GroupDN_TextBox.sendKeys(memberShipGroupDN);
			Select dropdown = new Select(VIP_Admin_Config_Page.AdminGroupMapping_VIPAdministratorsGroup_SelectBox);
			int a = 0;
			int size = 0;
			do {
				Thread.sleep(1000);
				size = dropdown.getOptions().size();
				if (size > 1) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Current size in the drop down is " + size);
				}
				a++;
			} while ((size <= 1) && (a < 40));
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).contains(vipAdministrtorGroupName)) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting the groupName as " + option.getText());
					option.click();
					break;
				}
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking the save button");
			VIP_Admin_Config_Page.AdminGroupMapping_Save_Button.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching back to main page");
			driver.switchTo().activeElement();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String actualMessage = VIP_Admin_Config_Page.AdminGroupMapping_Save_Message.getText();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "actual message : " + actualMessage);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "expected message " + messageAfterCreatingAdminGroupMapping);
			if (actualMessage.contains(messageAfterCreatingAdminGroupMapping)) {
				result = true;
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Expected string in the content was:" + messageAfterCreatingAdminGroupMapping + ". Actual Content \"" + actualMessage
						+ "\" contains the expected string");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Admin Group Mapping configured successfully");
			} else {
				result = false;
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Expected string in the content was:" + messageAfterCreatingAdminGroupMapping + ". Actual Content \"" + actualMessage
						+ "\" does not contain the expected string");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Admin Group Mapping configuration failed");
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "| Expected result: " + expectedResult + "| | Actual result:" + result + " | | Test case status :"
				+ (expectedResult == result ? "Pass" : "Fail") + " |");
		Assert.assertEquals(result, expectedResult);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void UpdateValidationServerAutomaticBCMode(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String switchTime = config.get("update_switch_time");
		Boolean emailNotification = Boolean.valueOf(config.get("update_email_notification"));
		String smtpHostName = config.get("update_smtp_hotsname");
		String smtpPort = config.get("update_smtp_port");
		boolean enableSSL = Boolean.valueOf(config.get("update_enable_ssl"));
		String smtpUserName = config.get("update_smtp_username");
		String smtpPassword = config.get("update_smtp_password");
		String smtpSenderEmail = config.get("update_smtp_sender_email");
		String smtpRecieverEmail = config.get("update_smtp_receiver_email");
		String startBCAutomaticMsgSubject = config.get("update_start_automatic_msg_subject");
		String startBCAutomaticMsg = config.get("update_start_automatic_msg");
		String endBCAutomaticMsgSubject = config.get("update_end_automatic_msg_subject");
		String endBCAutomaticMsg = config.get("update_end_automatic_msg");
		String AutomaticBCSuccessMessage = "";
		boolean testConfiguration = Boolean.valueOf(config.get("test_configuration"));
		String testDescription = config.get("test_description");
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		WebDriverWait wt = new WebDriverWait(driver, 5);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Test description : " + testDescription);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Validation")));
		Configuration_Console_Home_Page.Validation_Tab.click();
		if (!Validation_Server_Home_Page.View_link.isDisplayed()) {
			UpdateValidationServer(config, driver);
		} else {
			Validation_Server_Home_Page.View_link.click();
			driver.switchTo().frame(0);
			wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.Close_AutomaticBC_Button));
			Validation_Server_Config_Page.Edit_AutomaticBC_Button.click();
			wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.Switching_Time_SelectBox));
			if (switchTime != null) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "setting for switch time");
				Select dropdown = new Select(Validation_Server_Config_Page.Switching_Time_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).contains(switchTime.toLowerCase())) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing switching time to : " + switchTime.toUpperCase());
						option.click();
						break;
					}
				}
			}
			if (emailNotification) {
				Validation_Server_Config_Page.Email_Notification_Enable_RadioButton.click();
				if (smtpHostName != null) {
					Validation_Server_Config_Page.SMTP_HostName_input.clear();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting SMTP Host name : " + smtpHostName);
					Validation_Server_Config_Page.SMTP_HostName_input.sendKeys(smtpHostName);
				}
				if (smtpPort != null) {
					Validation_Server_Config_Page.SMTP_Port_input.clear();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting SMTP Port :  " + smtpPort);
					Validation_Server_Config_Page.SMTP_Port_input.sendKeys(smtpPort);
				}
				if (enableSSL)
					Validation_Server_Config_Page.SSL_Enable_Yes_RadioButton.click();
				else
					Validation_Server_Config_Page.SSL_Enable_No_RadioButton.click();
				if (smtpUserName != null) {
					Validation_Server_Config_Page.SMTP_UserName_input.clear();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting SMTP User name : " + smtpUserName);
					Validation_Server_Config_Page.SMTP_UserName_input.sendKeys(smtpUserName);
				}
				if (smtpPassword != null) {
					Validation_Server_Config_Page.SMTP_Password_input.clear();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting SMTP Password : " + smtpPassword);
					Validation_Server_Config_Page.SMTP_Password_input.sendKeys(smtpPassword);
				}
				if (smtpSenderEmail != null) {
					Validation_Server_Config_Page.SMTP_From_Address_input.clear();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting SMTP Sender Email id:  " + smtpSenderEmail);
					Validation_Server_Config_Page.SMTP_From_Address_input.sendKeys(smtpSenderEmail);
				}
				if (smtpRecieverEmail != null) {
					Validation_Server_Config_Page.SMTP_To_Address_input.clear();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting SMTP Receiver Email id:  " + smtpRecieverEmail);
					Validation_Server_Config_Page.SMTP_To_Address_input.sendKeys(smtpRecieverEmail);
				}
				if (startBCAutomaticMsgSubject != null) {
					Validation_Server_Config_Page.SMTP_BC_Automatic_StartMsgSubject.clear();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting SMTP Start BC Message subject : " + startBCAutomaticMsgSubject);
					Validation_Server_Config_Page.SMTP_BC_Automatic_StartMsgSubject.sendKeys(startBCAutomaticMsgSubject);
				}
				if (startBCAutomaticMsg != null) {
					Validation_Server_Config_Page.SMTP_BC_Automatic_StartMsg.clear();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting SMTP Start BC Message :  " + startBCAutomaticMsg);
					Validation_Server_Config_Page.SMTP_BC_Automatic_StartMsg.sendKeys(startBCAutomaticMsg);
				}
				if (endBCAutomaticMsgSubject != null) {
					Validation_Server_Config_Page.SMTP_BC_Automatic_EndMsgSubject.clear();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting SMTP End BC Message subject : " + endBCAutomaticMsgSubject);
					Validation_Server_Config_Page.SMTP_BC_Automatic_EndMsgSubject.sendKeys(endBCAutomaticMsgSubject);
				}
				if (endBCAutomaticMsg != null) {
					Validation_Server_Config_Page.SMTP_BC_Automatic_EndMsg.clear();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting SMTP End BC Message : " + endBCAutomaticMsg);
					Validation_Server_Config_Page.SMTP_BC_Automatic_EndMsg.sendKeys(endBCAutomaticMsg);
				}
				if (testConfiguration) {
					Validation_Server_Config_Page.Test_AutomaticBC_Button.click();
					Thread.sleep(10000);
					if (Validation_Server_Config_Page.SMTP_Test_Configuration_MessageField.getText().contains("success"))
						LoginAndValidateFromGmail();
				}
			} else
				Validation_Server_Config_Page.Email_Notification_Disable_RadioButton.click();
			Validation_Server_Config_Page.SMTP_Save_Button.click();
			if (!Validation_Server_Config_Page.Message_on_page.getText().contains(AutomaticBCSuccessMessage))
				return;
			Validation_Server_Config_Page.SMTP_Close_button.click();
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void CheckUpdatedValidationServerAutomaticBCMode(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String switchTime = config.get("update_switch_time");
		Boolean emailNotification = Boolean.valueOf(config.get("update_email_notification"));
		String smtpHostName = config.get("update_smtp_hotsname");
		String smtpPort = config.get("update_smtp_port");
		boolean enableSSL = Boolean.valueOf(config.get("update_enable_ssl"));
		String smtpUserName = config.get("update_smtp_username");
		String smtpSenderEmail = config.get("update_smtp_sender_email");
		String smtpRecieverEmail = config.get("update_smtp_receiver_email");
		String startBCAutomaticMsgSubject = config.get("update_start_automatic_msg_subject");
		String startBCAutomaticMsg = config.get("update_start_automatic_msg");
		String endBCAutomaticMsgSubject = config.get("update_end_automatic_msg_subject");
		String endBCAutomaticMsg = config.get("update_end_automatic_msg");
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		WebDriverWait wt = new WebDriverWait(driver, 5);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "***** checking started ******");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Validation")));
		Configuration_Console_Home_Page.Validation_Tab.click();
		if (Validation_Server_Home_Page.View_link.isDisplayed()) {
			Validation_Server_Home_Page.View_link.click();
			driver.switchTo().frame(0);
			wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.Close_AutomaticBC_Button));
			Validation_Server_Config_Page.Edit_AutomaticBC_Button.click();
			wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.Switching_Time_SelectBox));
			if (switchTime != null) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for switch time");
				Select dropdown = new Select(Validation_Server_Config_Page.Switching_Time_SelectBox);
				Assert.assertTrue(dropdown.getFirstSelectedOption().getText().toLowerCase().contains(switchTime), "Switch time input didnot match");
			}
			if (emailNotification) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for Email notificaton enable radio button");
				Assert.assertEquals(Validation_Server_Config_Page.Email_Notification_Enable_RadioButton.getAttribute("checked"), "true");
				if (smtpHostName != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for SMTP Host name");
					Assert.assertEquals((Validation_Server_Config_Page.SMTP_HostName_input.getAttribute("value")), smtpHostName);
				}
				if (smtpPort != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for SMTP Port");
					Assert.assertEquals((Validation_Server_Config_Page.SMTP_Port_input.getAttribute("value")), smtpPort);
				}
				if (enableSSL) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for SSL enable radio button");
					Assert.assertEquals(Validation_Server_Config_Page.SSL_Enable_Yes_RadioButton.getAttribute("checked"), "true");
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for SSL Disable radio button");
					Assert.assertEquals(Validation_Server_Config_Page.SSL_Enable_No_RadioButton.getAttribute("checked"), "true");
				}
				if (smtpUserName != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for SMTP user name");
					Assert.assertEquals((Validation_Server_Config_Page.SMTP_UserName_input.getAttribute("value")), smtpUserName);
				}
				if (smtpSenderEmail != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for SMTP Sender email");
					Assert.assertEquals((Validation_Server_Config_Page.SMTP_From_Address_input.getAttribute("value")), smtpSenderEmail);
				}
				if (smtpRecieverEmail != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for SMTP receiver email");
					Assert.assertEquals((Validation_Server_Config_Page.SMTP_To_Address_input.getAttribute("value")), smtpRecieverEmail);
				}
				if (startBCAutomaticMsgSubject != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for SMTP start BC Automatic message subject");
					Assert.assertEquals((Validation_Server_Config_Page.SMTP_BC_Automatic_StartMsgSubject.getAttribute("value")), startBCAutomaticMsgSubject);
				}
				if (startBCAutomaticMsg != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for SMTP start BC Automatic message");
					Assert.assertEquals((Validation_Server_Config_Page.SMTP_BC_Automatic_StartMsg.getAttribute("value")), startBCAutomaticMsg);
				}
				if (endBCAutomaticMsgSubject != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for SMTP Ending BC Automatic message subject");
					Assert.assertEquals((Validation_Server_Config_Page.SMTP_BC_Automatic_EndMsgSubject.getAttribute("value")), endBCAutomaticMsgSubject);
				}
				if (endBCAutomaticMsg != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking for SMTP ending BC Automatic message ");
					Assert.assertEquals((Validation_Server_Config_Page.SMTP_BC_Automatic_EndMsg.getAttribute("value")), endBCAutomaticMsg);
				}
			}
			Validation_Server_Config_Page.Cancel_Button.click();
			Validation_Server_Config_Page.SMTP_Close_button.click();
			driver.switchTo().defaultContent();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "***** checking done ******");
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void LoginAndValidateFromGmail() {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriver dr2 = null;
		dr2 = new FirefoxDriver();
		dr2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		dr2.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Launching gmail to get sec code ");
		dr2.get("http://www.gmail.com");
		WebDriverWait wt1 = new WebDriverWait(dr2, 120);
		wt1.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));
		dr2.findElement(By.id("Email")).sendKeys("vipautomationtest@gmail.com");
		dr2.findElement(By.id("Passwd")).sendKeys("p@ssword123");
		dr2.findElement(By.id("signIn")).click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicked on Sign In button to login to gmail ");
		wt1.until(ExpectedConditions.visibilityOf(dr2.findElement(By.xpath("//div[@class='UI']/div/descendant::table/descendant::tr[1]/td[6]/descendant::span[1]"))));
		String message = dr2.findElement(By.xpath("//div[@class='UI']/div/descendant::table/descendant::tr[1]/td[6]/descendant::span[1]")).getText();
		if (message.contains("Temporary access to VIP Manager")) {
			dr2.findElement(By.xpath("//div[@class='UI']/div/descendant::table/descendant::tr[1]/td[6]/descendant::span[1]")).click();
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to grab security code for authentication ");
		String securitycode = dr2.findElement(By.xpath("//td[text()='Symantec User Authentication Technical Support']/ancestor::tr[1]/preceding-sibling::tr[2]/td/b")).getText();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Got security code: " + securitycode);
		dr2.quit();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Received the message " + securitycode);
		if (securitycode.contains("You have successfully edited the credential")) {
			Assert.assertTrue(true);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Successfully enabled the credential");
		} else {
			Assert.assertTrue(false);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Failed to enable the credential");
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void UpdateValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		String mode = config.get("mode").toLowerCase();
		String vendor = config.get("vendor");
		String applicationName = config.get("application_name");
		String serverName = config.get("validation_server_name");
		String pushTimeOut = config.get("update_push_timeout");
		// String pushSecret = config.get("update_push_shared_secret");
		String pushRemoteServiceName = config.get("update_remote_service_name");
		String bc = config.get("update_bc_mode");
		String port = config.get("update_server_port");
		String loggingLevel = config.get("update_log_level");
		String loggingRotLevel = config.get("update_log_rot_level");
		String noOfFilesToKeep = config.get("update_no_of_files_to_keep");
		String enableSyslog = config.get("update_enable_syslog");
		String passEncoding = config.get("update_pass_encoding");
		String userStore = config.get("update_user_store");
		String radiusSharedSecret = config.get("update_validation_server_shared_secret");
		String radiusConfirmSharedSecret = config.get("update_confirm_rad_shared");
		boolean useLDAPUserName = Boolean.valueOf(config.get("update_use_ldap_username"));
		String validationSuccessMessageOnDelegation = "Validation Server " + serverName + " was updated successfully.";
		// String threadPoolSize = config.get("update_thread_pool_size");
		// String actualMessage = null;
		String newPIN = config.get("update_new_pin");
		String newPINReenter = config.get("update_renenter_new_pin");
		String pinResetMsg = config.get("update_pin_reset_msg");
		String pinTimeOut = config.get("update_pin_timeout");
		boolean userUserStoreOOB = Boolean.valueOf(config.get("use_userstore_oob"));
		boolean userPINReset = Boolean.valueOf(config.get("update_user_pin_reset"));
		String AutomaticBCSuccessMessage = "Automatic Business Continuity settings has been updated successfully";
		String switchTime = config.get("update_switch_time");
		Boolean emailNotification = Boolean.valueOf(config.get("update_email_notification"));
		String smtpHostName = config.get("update_smtp_hotsname");
		String smtpPort = config.get("update_smtp_port");
		boolean enableSSL = Boolean.valueOf(config.get("update_enable_ssl"));
		String smtpUserName = config.get("update_smtp_username");
		String smtpPassword = config.get("update_smtp_password");
		String smtpSenderEmail = config.get("update_smtp_sender_email");
		String smtpRecieverEmail = config.get("update_smtp_receiver_email");
		String startBCAutomaticMsgSubject = config.get("update_start_automatic_msg_subject");
		String startBCAutomaticMsg = config.get("update_start_automatic_msg");
		String endBCAutomaticMsgSubject = config.get("update_end_automatic_msg_subject");
		String endBCAutomaticMsg = config.get("update_end_automatic_msg");
		String oS = config.get("server_context");
		boolean isChallengeSupported = Boolean.valueOf(config.get("challenge_supported"));
		boolean enableAccessChallenge = Boolean.valueOf(config.get("enable_access_challenge"));
		boolean result = false;
		WebDriverWait wt = new WebDriverWait(driver, 5);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Mode : " + mode);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Server name  : " + serverName);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Validation")));
		Configuration_Console_Home_Page.Validation_Tab.click();
		Thread.sleep(3000);
		findAndActOnValidationServer(driver, serverName, "edit");
		/*
		 * if(Validation_Server_Config_Page.Delegation_Module_Edit_Link.
		 * isDisplayed()) {
		 * if(driver.findElement(By.linkText(serverName)).isDisplayed())
		 * driver.findElement(By.linkText(serverName)).click(); else return; }
		 * else return;
		 */
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate port number");
		if (port != null) {
			Validation_Server_Config_Page.Port_TextBox.clear();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "port number: " + port);
			Validation_Server_Config_Page.Port_TextBox.sendKeys(port);
		}
		// Commenting thread pool size as this is no longer exposed to UI.
		// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
		// "Trying to populate thread pool size");
		// if (threadPoolSize != null) {
		// Validation_Server_Config_Page.ThreadPoolSize_TextBox.clear();
		// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
		// "Thread pool size : " + threadPoolSize);
		// Validation_Server_Config_Page.ThreadPoolSize_TextBox.sendKeys(threadPoolSize);
		// }
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to check business continuity mode");
		if (!mode.equalsIgnoreCase("upo")) {
			if (bc != null) {
				switch (bc.toLowerCase()) {
				case "enabled":
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to set to enable");
					Validation_Server_Config_Page.BusinessContinuity_Enabled_RadioButton.click();
					break;
				case "disabled":
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to set to disable");
					Validation_Server_Config_Page.BusinessContinuity_Disabled_RadioButton.click();
					break;
				case "auto":
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to set to automatic");
					Validation_Server_Config_Page.BusinessContinuity_Automatic_RadioButton.click();
					try {
						if (Validation_Server_Config_Page.Configure_BC_Link.isDisplayed())
							Validation_Server_Config_Page.Configure_BC_Link.click();
					} catch (Exception ne) {
						break;
					}
					driver.switchTo().frame(0);
					wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.Switching_Time_SelectBox));
					if (switchTime != null) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "setting for switch time");
						Select dropdown = new Select(Validation_Server_Config_Page.Switching_Time_SelectBox);
						List<WebElement> options = dropdown.getOptions();
						for (WebElement option : options) {
							if ((option.getText()).equalsIgnoreCase(switchTime.toLowerCase())) {
								logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing switching time to : " + switchTime.toUpperCase());
								option.click();
								break;
							}
						}
					}
					if (emailNotification) {
						Validation_Server_Config_Page.Email_Notification_Enable_RadioButton.click();
						if (smtpHostName != null) {
							Validation_Server_Config_Page.SMTP_HostName_input.clear();
							Validation_Server_Config_Page.SMTP_HostName_input.sendKeys(smtpHostName);
						}
						if (smtpPort != null) {
							Validation_Server_Config_Page.SMTP_Port_input.clear();
							Validation_Server_Config_Page.SMTP_Port_input.sendKeys(smtpPort);
						}
						if (enableSSL)
							Validation_Server_Config_Page.SSL_Enable_Yes_RadioButton.click();
						else
							Validation_Server_Config_Page.SSL_Enable_No_RadioButton.click();
						if (smtpUserName != null) {
							Validation_Server_Config_Page.SMTP_UserName_input.clear();
							Validation_Server_Config_Page.SMTP_UserName_input.sendKeys(smtpUserName);
						}
						if (smtpPassword != null) {
							Validation_Server_Config_Page.SMTP_Password_input.clear();
							Validation_Server_Config_Page.SMTP_Password_input.sendKeys(smtpPassword);
						}
						if (smtpSenderEmail != null) {
							Validation_Server_Config_Page.SMTP_From_Address_input.clear();
							Validation_Server_Config_Page.SMTP_From_Address_input.sendKeys(smtpSenderEmail);
						}
						if (smtpRecieverEmail != null) {
							Validation_Server_Config_Page.SMTP_To_Address_input.clear();
							Validation_Server_Config_Page.SMTP_To_Address_input.sendKeys(smtpRecieverEmail);
						}
						if (startBCAutomaticMsgSubject != null) {
							Validation_Server_Config_Page.SMTP_BC_Automatic_StartMsgSubject.clear();
							Validation_Server_Config_Page.SMTP_BC_Automatic_StartMsgSubject.sendKeys(startBCAutomaticMsgSubject);
						}
						if (startBCAutomaticMsg != null) {
							Validation_Server_Config_Page.SMTP_BC_Automatic_StartMsg.clear();
							Validation_Server_Config_Page.SMTP_BC_Automatic_StartMsg.sendKeys(startBCAutomaticMsg);
						}
						if (endBCAutomaticMsgSubject != null) {
							Validation_Server_Config_Page.SMTP_BC_Automatic_EndMsgSubject.clear();
							Validation_Server_Config_Page.SMTP_BC_Automatic_EndMsgSubject.sendKeys(endBCAutomaticMsgSubject);
						}
						if (endBCAutomaticMsg != null) {
							Validation_Server_Config_Page.SMTP_BC_Automatic_EndMsg.clear();
							Validation_Server_Config_Page.SMTP_BC_Automatic_EndMsg.sendKeys(endBCAutomaticMsg);
						}
					} else
						Validation_Server_Config_Page.Email_Notification_Disable_RadioButton.click();
					Validation_Server_Config_Page.SMTP_Save_Button.click();
					if (!Validation_Server_Config_Page.Message_on_page.getText().contains(AutomaticBCSuccessMessage))
						return;
					Validation_Server_Config_Page.SMTP_Close_button.click();
					driver.switchTo().defaultContent();
					break;
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate log level");
		if (loggingLevel != null) {
			Select dropdown = new Select(Validation_Server_Config_Page.Logging_Level_SelectBox);
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).equalsIgnoreCase(loggingLevel.toLowerCase())) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing logging level to : " + loggingLevel.toUpperCase());
					option.click();
					break;
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate log rotation level");
		if (loggingRotLevel != null) {
			Select dropdown = new Select(Validation_Server_Config_Page.Logging_Rotation_Level_SelectBox);
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).equalsIgnoreCase(loggingRotLevel.toLowerCase())) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing log rotation level to : " + loggingRotLevel.toUpperCase());
					option.click();
					break;
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate no of files to keep");
		if (noOfFilesToKeep != null) {
			Select dropdown = new Select(Validation_Server_Config_Page.NumberOf_Files_To_Keep_SelectBox);
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).equalsIgnoreCase(noOfFilesToKeep.toLowerCase())) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing number of files to keep : " + noOfFilesToKeep.toUpperCase());
					option.click();
					break;
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to change sys log radio button");
		if (enableSyslog != null) {
			if (enableSyslog.equalsIgnoreCase("yes"))
				Validation_Server_Config_Page.Enable_SysLog_Yes_RadioButton.click();
			else if (enableSyslog.equalsIgnoreCase("no"))
				Validation_Server_Config_Page.Enable_SysLog_No_RadioButton.click();
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking the statuc of access challenge checkbox");
		if (vendor != null && (isChallengeSupported)) {
			if (enableAccessChallenge) {
				if (!Boolean.valueOf(Validation_Server_Config_Page.Enable_challenge_Checkbox.getAttribute("checked"))) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enableAccessChallenge is " + enableAccessChallenge + ". Challenge checkbox is not CHECKED, so enabling");
					Validation_Server_Config_Page.Enable_challenge_Checkbox.click();
				}
			} else {
				if (sHelper.isElementPresent(driver, Validation_Server_Config_Page.Enable_challenge_Checkbox)) {
					if (Boolean.valueOf(Validation_Server_Config_Page.Enable_challenge_Checkbox.getAttribute("checked"))) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enableAccessChallenge is " + enableAccessChallenge + ". Challenge checkbox is CHECKED, so disabling");
						Validation_Server_Config_Page.Enable_challenge_Checkbox.click();
					}
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Challenge checkbox is not available");
				}
			}
		} else if (vendor != null && (!isChallengeSupported)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Ignoring challenge support checkbox as it is not supported by the application template");
		} else {
			if (enableAccessChallenge) {
				if (!Boolean.valueOf(Validation_Server_Config_Page.Enable_challenge_Checkbox.getAttribute("checked"))) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enableAccessChallenge is " + enableAccessChallenge + ". Challenge checkbox is not CHECKED, so enabling");
					Validation_Server_Config_Page.Enable_challenge_Checkbox.click();
				}
			} else {
				if (sHelper.isElementPresent(driver, Validation_Server_Config_Page.Enable_challenge_Checkbox)) {
					if (Boolean.valueOf(Validation_Server_Config_Page.Enable_challenge_Checkbox.getAttribute("checked"))) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enableAccessChallenge is " + enableAccessChallenge + ". Challenge checkbox is CHECKED, so disabling");
						Validation_Server_Config_Page.Enable_challenge_Checkbox.click();
					}
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Challenge checkbox is not available");
				}
			}
		}
		if (radiusSharedSecret != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate radius shared secret password");
			Validation_Server_Config_Page.RadiusSharedSecret_TextBox.clear();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "radius shared secret : " + radiusSharedSecret);
			Validation_Server_Config_Page.RadiusSharedSecret_TextBox.sendKeys(radiusSharedSecret);
		}
		if (radiusConfirmSharedSecret != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate confirm radius shared secret password");
			Validation_Server_Config_Page.Confirm_RadiusSharedSecret_TextBox.clear();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "radius confirm shared secret : " + radiusConfirmSharedSecret);
			Validation_Server_Config_Page.Confirm_RadiusSharedSecret_TextBox.sendKeys(radiusConfirmSharedSecret);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "changing password encoding value");
		if (passEncoding != null) {
			if (oS.contains("window")) {
				Select dropdown = new Select(Validation_Server_Config_Page.Password_Encoding_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Password encoding option : " + option.getText());
					if ((option.getText()).equalsIgnoreCase(passEncoding.toLowerCase())) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "changing password encoding to " + passEncoding.toUpperCase());
						option.click();
						break;
					}
				}
			} else {
				Validation_Server_Config_Page.Password_Encoding_SelectBox.clear();
				Validation_Server_Config_Page.Password_Encoding_SelectBox.sendKeys(passEncoding);
			}
		}
		// if (mode.equalsIgnoreCase("uo") || mode.equalsIgnoreCase("upo")) {
		// if (useLDAPUserName) {
		// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
		// "User LDAP Username field available");
		// if
		// (!Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.isSelected())
		// {
		// Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.click();
		// }
		// } else {
		// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
		// "User LDAP Username field not available");
		// if
		// (Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.isSelected())
		// {
		// Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.click();
		// }
		// }
		// if
		// (Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.isSelected())
		// {
		// if (userStore != null) {
		// Select dropdown = new
		// Select(Validation_Server_Config_Page.UserStore_SelectBox);
		// List<WebElement> options = dropdown.getOptions();
		// for (WebElement option : options) {
		// if ((option.getText()).equalsIgnoreCase(userStore.toLowerCase())) {
		// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
		// "Changing userStore value to " + userStore.toUpperCase());
		// option.click();
		// break;
		// }
		// }
		// }
		// }
		// }
		if (mode != null) {
			if (mode.equalsIgnoreCase("uo") || mode.equalsIgnoreCase("upo")) {
				if (useLDAPUserName) {
					if (!Boolean.valueOf(Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.getAttribute("checked"))) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "User recides in user store is NOT CHECKED. So enabling the option.");
						Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.click();
						Thread.sleep(1000);
					}
					if (userUserStoreOOB) {
						Validation_Server_Config_Page.Use_UserStore_Data_For_OOB_CheckBox.click();
					}
				}
			} else {
				if (userUserStoreOOB) {
					Validation_Server_Config_Page.Use_UserStore_Data_For_OOB_CheckBox.click();
				}
			}
		}
		if (Boolean.valueOf(Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.getAttribute("checked"))) {
			if (userStore != null) {
				Select dropdown = new Select(Validation_Server_Config_Page.UserStore_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).equalsIgnoreCase(userStore.toLowerCase())) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing userStore value to " + userStore.toUpperCase());
						option.click();
						break;
					}
				}
			}
		}
		if (pushTimeOut != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting push timeout");
			Validation_Server_Config_Page.TextBox_Push_TimeOut.clear();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "push time out: " + pushTimeOut);
			Validation_Server_Config_Page.TextBox_Push_TimeOut.sendKeys(pushTimeOut);
		}
		if (pushRemoteServiceName != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting push remote service name");
			Validation_Server_Config_Page.TextBox_Push_RemoteAccessServiceURL.clear();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "push remote service name : " + pushRemoteServiceName);
			Validation_Server_Config_Page.TextBox_Push_RemoteAccessServiceURL.sendKeys(pushRemoteServiceName);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on submit button");
		//Validation_Server_Config_Page.Submit_Button.click();
		driver.findElement(By.name("submitButton")).sendKeys(Keys.RETURN);
		String actualMessage = Validation_Server_Config_Page.Message_on_page.getText();
		result = (actualMessage.equalsIgnoreCase(validationSuccessMessageOnDelegation));
		Assert.assertTrue(result, "Updating the server " + serverName + " failed. Actual Message: " + actualMessage + ". Expected message: " + validationSuccessMessageOnDelegation);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Update status : " + Validation_Server_Config_Page.Message_on_page.getText());
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "***************************");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking for the updated elements");
		CheckUpdatedValidationServerValues(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "****************");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking done!");
	}

	public void CheckUpdatedValidationServerValues(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		String mode = config.get("mode");
		String serverName = config.get("validation_server_name");
		// boolean vipAccessPushStatus =
		// Boolean.valueOf(config.get("update_enable_push"));
		String pushTimeOut = config.get("update_push_timeout");
		String pushRemoteServiceName = config.get("update_remote_service_name");
		String bc = config.get("update_bc_mode");
		String port = config.get("update_server_port");
		String loggingLevel = config.get("update_log_level");
		String loggingRotLevel = config.get("update_log_rot_level");
		String noOfFilesToKeep = config.get("update_no_of_files_to_keep");
		String enableSyslog = config.get("update_enable_syslog");
		String passEncoding = config.get("update_pass_encoding");
		String threadPoolSize = config.get("update_thread_pool_size");
		String newPIN = config.get("update_new_pin");
		String newPINReenter = config.get("update_renenter_new_pin");
		String pinResetMsg = config.get("update_pin_reset_msg");
		boolean userPINReset = Boolean.valueOf(config.get("update_user_pin_reset"));
		String oS = config.get("server_context");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "server name: " + serverName);
		// WebDriverWait wt = new WebDriverWait(driver, 5);
		findAndActOnValidationServer(driver, serverName, "edit");
		if (port != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "port text in the box: " + Validation_Server_Config_Page.Port_TextBox.getAttribute("value"));
			Assert.assertEquals(port, (Validation_Server_Config_Page.Port_TextBox.getAttribute("value")));
		}
		// Commenting as thread pool size is no longer exposed to the UI
		// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
		// "Trying to thread pool size");
		// if (threadPoolSize != null) {
		// Assert.assertEquals(Validation_Server_Config_Page.ThreadPoolSize_TextBox.getAttribute("value"),
		// threadPoolSize);
		// }
		if (mode != null) {
			if (!mode.equalsIgnoreCase("upo")) {
				if (bc != null) {
					switch (bc) {
					case "enabled":
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to set to enable");
						Assert.assertEquals(Validation_Server_Config_Page.BusinessContinuity_Enabled_RadioButton.getAttribute("checked"), "true");
						break;
					case "disabled":
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to set to disable");
						Assert.assertEquals(Validation_Server_Config_Page.BusinessContinuity_Disabled_RadioButton.getAttribute("checked"), "true");
						break;
					case "auto":
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to set to automatic");
						Assert.assertEquals(Validation_Server_Config_Page.BusinessContinuity_Automatic_RadioButton.getAttribute("checked"), "true");
						break;
					}
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "loggin level  check");
		if (loggingLevel != null) {
			Select dropdown = new Select(Validation_Server_Config_Page.Logging_Level_SelectBox);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "log level present : " + dropdown.getFirstSelectedOption().getText().toLowerCase());
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "logginglevel from json : " + loggingLevel);
			Assert.assertEquals(dropdown.getFirstSelectedOption().getText().toLowerCase(), loggingLevel);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "log rotation level check");
		if (loggingRotLevel != null) {
			Select dropdown = new Select(Validation_Server_Config_Page.Logging_Rotation_Level_SelectBox);
			Assert.assertEquals(dropdown.getFirstSelectedOption().getText().toLowerCase(), loggingRotLevel);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "no of files to keep check");
		if (noOfFilesToKeep != null) {
			Select dropdown = new Select(Validation_Server_Config_Page.NumberOf_Files_To_Keep_SelectBox);
			Assert.assertEquals(dropdown.getFirstSelectedOption().getText().toLowerCase(), noOfFilesToKeep);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enable sys log radio button check");
		if (enableSyslog != null) {
			if (enableSyslog.equalsIgnoreCase("yes"))
				Assert.assertEquals(Validation_Server_Config_Page.Enable_SysLog_Yes_RadioButton.getAttribute("checked"), "true");
			else if (enableSyslog.equalsIgnoreCase("no"))
				Assert.assertEquals(Validation_Server_Config_Page.Enable_SysLog_No_RadioButton.getAttribute("checked"), "true");
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "password encoding check");
		if (passEncoding != null) {
			if (oS.contains("window")) {
				Select dropdown = new Select(Validation_Server_Config_Page.Password_Encoding_SelectBox);
				Assert.assertEquals(dropdown.getFirstSelectedOption().getAttribute("value"), passEncoding);
			} else {
				Assert.assertEquals(Validation_Server_Config_Page.Password_Encoding_SelectBox.getAttribute("value"), passEncoding);
			}
		}
		/*
		 * if (mode.equalsIgnoreCase("uo")) { if (useLDAPUserName) {
		 * logger.info("Thread-"+Thread.currentThread().getId()+": "+
		 * "check if User LDAP Username field is checked");
		 * Assert.assertEquals(Validation_Server_Config_Page.
		 * Use_LDAP_UserName_CheckBox.getAttribute("value"), true); } }
		 */
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "vip push access check");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "push time out check");
		if (pushTimeOut != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting push timeout");
			Assert.assertEquals(Validation_Server_Config_Page.TextBox_Push_TimeOut.getAttribute("value"), pushTimeOut);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "push remote service name check");
		if (pushRemoteServiceName != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking push remote service name");
			Assert.assertEquals(Validation_Server_Config_Page.TextBox_Push_RemoteAccessServiceURL.getAttribute("value"), pushRemoteServiceName);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on cancel button");
		Validation_Server_Config_Page.Cancel_Button.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void updateValidationServerRadiusToLDAPMapping(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		Radius_To_LDAP_Mapping_Frame = PageFactory.initElements(driver, RadiusToLDAPMappingConfigurationPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String serverName = config.get("validation_server_name");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		findAndActOnValidationServer(driver, serverName, "edit");
		setRadiusToLdapMappingInValidationServer(config, driver);
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on submit button");
		driver.findElement(By.name("submitButton")).sendKeys(Keys.RETURN);
		//Validation_Server_Config_Page.Submit_Button.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicked on submit button");
		Thread.sleep(2000);
		WebDriverWait wt = new WebDriverWait(driver, 30);
		wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.Message_on_page));
		String actualMessage = Validation_Server_Config_Page.Message_on_page.getText();
		Assert.assertTrue(actualMessage.contains("success"));
	}

	public void CheckUpdatedValdationServerradiusToLDAPMappingValues(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		Radius_To_LDAP_Mapping_Frame = PageFactory.initElements(driver, RadiusToLDAPMappingConfigurationPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String serverName = config.get("validation_server_name");
		WebDriverWait wt = new WebDriverWait(driver, 45);
		String radiusMapAttribute = config.get("radius_map_attribute");
		String vendorId = config.get("vendor_id");
		String vendorAttributeType = config.get("vendor_attribute_type");
		String vendorAttributeId = config.get("vendor_attribute_id");
		String ldapRadiusVendorOther = config.get("ldap_radius_vendor_other");
		String ldapMappingAttribute = config.get("ldap_mapping_attribute");
		boolean includeSecondaryQuery = Boolean.valueOf(config.get("include_secondary_query"));
		String testUserName = config.get("test_user_name");
		String secondaryFilter = config.get("secondary_filter");
		String secondaryBaseDN = config.get("secondary_basedn");
		String searchAttribute = config.get("search_attribute");
		String enableRadiusToLDAPMapping = config.get("enable-radius-ldap-mapping");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		findAndActOnValidationServer(driver, serverName, "edit");
		if (enableRadiusToLDAPMapping.contains("true")) {
			// Thread.sleep(2000);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking Enable Radius to LDAP Mapping checkbox");
			// Assert.assertEquals(
			// Validation_Server_Config_Page.Enable_Radius_To_LDAP_Mapping_Checkbox
			// .isSelected(), true);
			wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.SelectBox_Radius_Mapping_Attribute));
			if (radiusMapAttribute != null) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking radius mapping attribute");
				Select sel = new Select(Validation_Server_Config_Page.SelectBox_Radius_Mapping_Attribute);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking  " + radiusMapAttribute + " from radius Mapping Attribute drop down list");
				Assert.assertEquals(sel.getFirstSelectedOption().getText().toLowerCase(), radiusMapAttribute.toLowerCase());
			}
			if ((radiusMapAttribute.contains("Vendor") && vendorId != null) && (vendorId.equalsIgnoreCase("Cisco") || vendorId.equalsIgnoreCase("Juniper"))) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "As per the data vendor ID should be cisco or Juniper");
				// logger.info("Thread-"+Thread.currentThread().getId()+": "+"Clicking on the link Customize_Vendor_Specific_Attributes");
				// Validation_Server_Config_Page.Link_Customize_Vendor_Specific_Attributes
				// .click();
				Thread.sleep(100);
				Select sel1 = new Select(Validation_Server_Config_Page.SelectBox_VendorID);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking " + vendorId + " from VendorID list");
				Assert.assertEquals(sel1.getFirstSelectedOption().getText().toLowerCase(), vendorId.toLowerCase());
				if (vendorAttributeId != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking attribute ID as" + vendorAttributeId);
					Assert.assertEquals(Validation_Server_Config_Page.TextBox_AttributeID.getAttribute("value"), vendorAttributeId);
				}
				if (vendorAttributeType != null) {
					Select sel2 = new Select(Validation_Server_Config_Page.SelectBox_Radius_Mapping_Attribute_Type);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking " + vendorAttributeType + " from Attribute Type dropdown list");
					Assert.assertEquals(sel2.getFirstSelectedOption().getText().toLowerCase(), vendorAttributeType.toLowerCase());
				}
			} else if (radiusMapAttribute.contains("Vendor") && vendorId.equalsIgnoreCase("Other")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "As per the data vendor ID should be other");
				// logger.info("Thread-"+Thread.currentThread().getId()+": "+"Clicking on the link Customize_Vendor_Specific_Attributes");
				// Validation_Server_Config_Page.Link_Customize_Vendor_Specific_Attributes
				// .click();
				Thread.sleep(100);
				if (vendorId != null) {
					Select sel1 = new Select(Validation_Server_Config_Page.SelectBox_VendorID);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking " + vendorId + " from VendorID list");
					Assert.assertEquals(sel1.getFirstSelectedOption().getText().toLowerCase(), vendorId.toLowerCase());
				}
				if (ldapRadiusVendorOther != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking vendor specific ID to " + ldapRadiusVendorOther);
					Assert.assertEquals(Validation_Server_Config_Page.TextBox_VendorIDOther.getAttribute("value"), ldapRadiusVendorOther);
				}
				if (vendorAttributeId != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking vendor attribute ID to " + vendorAttributeId);
					Assert.assertEquals(Validation_Server_Config_Page.TextBox_AttributeID.getAttribute("value"), vendorAttributeId);
				}
				if (vendorAttributeType != null) {
					Select sel2 = new Select(Validation_Server_Config_Page.SelectBox_AttributeType);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking " + vendorAttributeType + " from Attribute Type dropdown list");
					Assert.assertEquals(sel2.getFirstSelectedOption().getText().toLowerCase(), vendorAttributeType.toLowerCase());
				}
			} else {
				if (vendorAttributeType != null) {
					Select sel2 = new Select(Validation_Server_Config_Page.SelectBox_AttributeType);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking " + vendorAttributeType + " from Attribute Type dropdown list");
					Assert.assertEquals(sel2.getFirstSelectedOption().getText().toLowerCase(), vendorAttributeType.toLowerCase());
				}
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Edit new link");
			List<WebElement> lst = Validation_Server_Config_Page.Link_Edit_Radius_Mapping_Attribute;
			// int size = lst.size();
			// for (int i = 0; i < size; i++) {
			// logger.info("Thread-" + Thread.currentThread().getId() + ": " +
			// "Deleting existing radius to LDAP mapping");
			lst.get(0).click();
			// }
			// Validation_Server_Config_Page.Link_Edit_Radius_Mapping_Attribute.click();
			Thread.sleep(500);
			String childid = driver.getWindowHandle();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to Radius to LDAP Mapping Attribute Frame");
			driver.switchTo().window(childid);
			wt.until(ExpectedConditions.visibilityOf(Radius_To_LDAP_Mapping_Frame.Button_Save));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switched to Radius to LDAP Mapping Attribute Frame");
			if (includeSecondaryQuery) {
				if (searchAttribute != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking search Attribute to " + searchAttribute);
					Assert.assertEquals(Radius_To_LDAP_Mapping_Frame.Search_Attribute_textbox.getAttribute("value"), searchAttribute);
				}
				if (secondaryBaseDN != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking secondary BaseDN to " + secondaryBaseDN);
					Assert.assertEquals(Radius_To_LDAP_Mapping_Frame.Secondary_base_DN_Textbox.getAttribute("value"), secondaryBaseDN);
				}
				if (secondaryFilter != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking secondary Filter to " + secondaryFilter);
					Assert.assertEquals(Radius_To_LDAP_Mapping_Frame.Secondary_filter_ID_textbox.getAttribute("value"), secondaryFilter);
				}
				if (ldapMappingAttribute != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking group LDAP attribute Name as " + ldapMappingAttribute);
					Assert.assertEquals(Radius_To_LDAP_Mapping_Frame.TextBox_LDAPMappingAttribute_Group.getAttribute("value"), ldapMappingAttribute);
				}
			}
			if ((!includeSecondaryQuery) && ldapMappingAttribute != null) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Chekcing LDAP attribute Name as " + ldapMappingAttribute);
				// Assert.assertEquals(Radius_To_LDAP_Mapping_Frame.TextBox_LDAPMappingAttribute.getAttribute("value"),
				// ldapMappingAttribute);
			}
			if (testUserName != null) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking test User Name to " + testUserName);
				Assert.assertEquals(Radius_To_LDAP_Mapping_Frame.Test_UserID_textbox.getAttribute("value"), testUserName);
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking on cancel button");
			Radius_To_LDAP_Mapping_Frame.Button_Cancel.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to validation server configuration page");
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			Validation_Server_Config_Page.Cancel_Button.click();
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void DuplicateValdationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		Duplicate_Validation_Server_Page = PageFactory.initElements(driver, DuplicateValidationServerPage.class);
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String serverName = config.get("validation_server_name");
		WebDriverWait wt = new WebDriverWait(driver, 20);
		String SuccessMessage = "Start the server when required";
		String portNumber = config.get("duplicate_port_number");
		String radiusSharedSecret = config.get("duplicate_radius_secret");
		String confirmRadiusSharedSecret = config.get("duplicate_confirm_radius_secret");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Validation")));
		Configuration_Console_Home_Page.Validation_Tab.click();
		wt.until(ExpectedConditions.elementToBeClickable(Validation_Server_Home_Page.Add_Server_Button));
		this.DeleteValidaitonServer(driver, serverName + "-copy");
		findAndActOnValidationServer(driver, serverName, "duplicate");
		driver.switchTo().activeElement();
		wt.until(ExpectedConditions.visibilityOf(Duplicate_Validation_Server_Page.Radius_Shared_Password_TextBox));
		if (portNumber != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enter port number : " + portNumber);
			Duplicate_Validation_Server_Page.port_TextBox.clear();
			Duplicate_Validation_Server_Page.port_TextBox.sendKeys(portNumber);
		}
		if (radiusSharedSecret != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enter radius shared secret : " + radiusSharedSecret);
			Duplicate_Validation_Server_Page.Radius_Shared_Password_TextBox.clear();
			Duplicate_Validation_Server_Page.Radius_Shared_Password_TextBox.sendKeys(radiusSharedSecret);
		}
		if (confirmRadiusSharedSecret != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enter confirm radius shared secret : " + confirmRadiusSharedSecret);
			Duplicate_Validation_Server_Page.Confirm_Radius_Shared_Password_TextBox.clear();
			Duplicate_Validation_Server_Page.Confirm_Radius_Shared_Password_TextBox.sendKeys(confirmRadiusSharedSecret);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking on Save button");
		Duplicate_Validation_Server_Page.Duplicate_Save_Button.click();
		driver.switchTo().defaultContent();
		wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.Message_on_page));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + Validation_Server_Config_Page.Message_on_page.getText());
		Assert.assertTrue(Validation_Server_Config_Page.Message_on_page.getText().contains(SuccessMessage), "validation server creation failed with name-" + serverName);
	}

	public void ConfigureConsoleAuthentication(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		boolean result = false;
		WebDriverWait wt = new WebDriverWait(driver, 15);
		final String userStoreName = config.get("userstore_name");
		final String baseDN = config.get("console_auth_base_dn");
		final String userFilter = config.get("console_auth_user_filter");
		final String groupFilter = config.get("console_auth_group_fliter");
		final String testUserName = config.get("test_user_name");
		final String testSuccessMessage = "Test connection is successful.";
		final String saveSuccessMessage = "successfully.";
		final String testName = config.get("test_name");
		Console_Auth_Config_Page = PageFactory.initElements(driver, ConsoleAuthenticationConfigurationPage.class);
		UserStore_Main_Page = PageFactory.initElements(driver, UserStoreMainPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String saveMessage = null;
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "*** Test description : " + testName + " ***");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("User Store")));
		Configuration_Console_Home_Page.UserStore_Tab.click();
		UserStore_Main_Page.Console_Authentication_Tab.click();
		if (sHelper.isElementPresent(driver, Console_Auth_Config_Page.Edit_Button)) {
			Console_Auth_Config_Page.Edit_Button.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Console Authentication is already configured");
		} else {
			Console_Auth_Config_Page.Enable_Console_Authentication_Yes_RadioButton.click();
			Select dropdown = new Select(Console_Auth_Config_Page.UserStore_Name_Selection_Box);
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).equalsIgnoreCase(userStoreName.toLowerCase())) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing the userStore to " + userStoreName);
					option.click();
					break;
				}
			}
		}
		Thread.sleep(1000);
		if (baseDN != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "entering base dn :" + baseDN);
			Console_Auth_Config_Page.BaseDN_TextBox.clear();
			Console_Auth_Config_Page.BaseDN_TextBox.sendKeys(baseDN);
		}
		if (userFilter != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "entering user Filter :" + userFilter);
			Console_Auth_Config_Page.UserFilter_TextBox.clear();
			Console_Auth_Config_Page.UserFilter_TextBox.sendKeys(userFilter);
		}
		if (groupFilter != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "entering group Filter :" + groupFilter);
			Console_Auth_Config_Page.GroupFilter_TextBox.clear();
			Console_Auth_Config_Page.GroupFilter_TextBox.sendKeys(groupFilter);
		}
		if (testUserName != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "entering test Use rName :" + testUserName);
			Console_Auth_Config_Page.TestUser_TextBox.clear();
			Console_Auth_Config_Page.TestUser_TextBox.sendKeys(testUserName);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking test button");
		Console_Auth_Config_Page.Test_Button.click();
		Thread.sleep(1000);
		// String a = Console_Auth_Config_Page.Test_Message.getText();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Test actual message: " + Console_Auth_Config_Page.Test_Message.getText());
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Test expected message: " + testSuccessMessage);
		if (Console_Auth_Config_Page.Test_Message.getText().equalsIgnoreCase(testSuccessMessage)) {
			result = true;
		} else {
			result = false;
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking save button");
		Console_Auth_Config_Page.Save_Button.click();
		Thread.sleep(1000);
		saveMessage = Console_Auth_Config_Page.Save_Message.getText();
		if (saveMessage.contains(saveSuccessMessage) && (result)) {
			Assert.assertTrue(true);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Actual message was:" + Console_Auth_Config_Page.Save_Message.getText());
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Console Authentication successfully configured");
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Expected message:" + saveSuccessMessage + ". Actual Message:" + Console_Auth_Config_Page.Save_Message.getText());
			logger.error("Thread-" + Thread.currentThread().getId() + ": " + "Failed to configure Console Authentication");
			Assert.assertTrue(false, saveMessage);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void ConfigureConsoleAuthenticationLoginFlow(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String login_protocol = config.get("login_protocol");
		String login_port = config.get("login_port");
		String server = config.get("eg_server_host");
		String loginURL = sHelper.MakeURL(login_protocol, server, login_port);
		Configuration_Console_Login_Page = PageFactory.initElements(driver, ConfigurationConsoleLoginPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String adminName = config.get("test_user_name");
		String adminPassword = config.get("test_user_name_password");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(loginURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.UserName_TextBox)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Invoking Configuration Console login flow");
			Configuration_Console_Login_Page.UserName_TextBox.sendKeys(adminName);
			Configuration_Console_Login_Page.Password_TextBox.sendKeys(adminPassword);
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Login_Auth_Type_SelectBox)) {
				Select dropdown = new Select(Configuration_Console_Login_Page.Login_Auth_Type_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).equalsIgnoreCase("User Store")) {
						option.click();
						break;
					}
				}
			}
			Configuration_Console_Login_Page.Submit_Button.click();
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button)) {
				Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button.click();
			}
		} else if (sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Already logged in. Invoking signout.");
			Configuration_Console_Home_Page.SignOut_Link.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Invoking Configuration Console login flow");
			Configuration_Console_Login_Page.UserName_TextBox.sendKeys(adminName);
			Configuration_Console_Login_Page.Password_TextBox.sendKeys(adminPassword);
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Login_Auth_Type_SelectBox)) {
				Select dropdown = new Select(Configuration_Console_Login_Page.Login_Auth_Type_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).equalsIgnoreCase("User Store")) {
						option.click();
						break;
					}
				}
			}
			Configuration_Console_Login_Page.Submit_Button.click();
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button)) {
				Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button.click();
			}
		}
		String loginName = Configuration_Console_Home_Page.Login_Name_Text.getText();
		String[] loginNames = loginName.split(" ");
		String resultName = "";
		for (String name : loginNames) {
			if ((!name.equalsIgnoreCase("Sign")) && (!name.equalsIgnoreCase("Out")))
				resultName += name + " ";
		}
		resultName.trim();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "login name displayed: " + resultName);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Username was : " + adminName);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Password was : " + adminPassword);
		Assert.assertTrue(resultName.contains(adminName) && (sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link)), "Login name and test user name doesnot match");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void LoginToSSP(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		// WebDriver dr2 = null;
		// String hostName = config.get("ssl_hostname");
		String userName = config.get("ssp_username");
		String password = config.get("ssp_password");
		String securityCode = config.get("ssp_securitycode");
		String server = config.get("eg_server_host");
		String url;
		url = "https://" + server + ":8233/vipssp";
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " SSP IDP URL : " + url);
		Self_ServicePortal_LoginPage = PageFactory.initElements(driver, SelfServicePortalLoginPage.class);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.navigate().to(url);
		WebDriverWait wt1 = new WebDriverWait(driver, 120);
		Thread.sleep(5000);
		// wt1.until(ExpectedConditions.elementToBeClickable(Self_ServicePortal_LoginPage.SignIn_Button))
		// ;
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending user name : " + userName);
		driver.findElement(By.name("username")).sendKeys(userName);
		// Self_ServicePortal_LoginPage.UserName_TextBox.sendKeys(userName);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending password  : " + password);
		Self_ServicePortal_LoginPage.Password_TextBox.sendKeys(password);
		Self_ServicePortal_LoginPage.SignIn_Button.click();
		Thread.sleep(3000);
		wt1.until(ExpectedConditions.elementToBeClickable(Self_ServicePortal_LoginPage.Continue_Button));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending security code : " + securityCode);
		Self_ServicePortal_LoginPage.SecurityCode_TextBox.sendKeys(securityCode);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking continue button");
		Self_ServicePortal_LoginPage.Continue_Button.click();
		Thread.sleep(5000);
		Assert.assertTrue(sHelper.isElementPresent(driver, Self_ServicePortal_LoginPage.SignOut_Link));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " Test case status :" + (sHelper.isElementPresent(driver, Self_ServicePortal_LoginPage.SignOut_Link) ? "Pass" : "Fail"));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void LoginToSSPSAMLSuccessCheck(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		// WebDriver dr2 = null;
		// String hostName = config.get("ssl_hostname");
		String userName = config.get("ssp_username");
		String password = config.get("ssp_password");
		String server = config.get("eg_server_host");
		String url;
		url = "https://" + server + ":8233/vipssp";
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " SSP IDP URL : " + url);
		Self_ServicePortal_LoginPage = PageFactory.initElements(driver, SelfServicePortalLoginPage.class);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.navigate().to(url);
		WebDriverWait wt1 = new WebDriverWait(driver, 120);
		Thread.sleep(5000);
		// wt1.until(ExpectedConditions.elementToBeClickable(Self_ServicePortal_LoginPage.SignIn_Button))
		// ;
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending user name : " + userName);
		driver.findElement(By.name("username")).sendKeys(userName);
		// Self_ServicePortal_LoginPage.UserName_TextBox.sendKeys(userName);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending password  : " + password);
		Self_ServicePortal_LoginPage.Password_TextBox.sendKeys(password);
		Self_ServicePortal_LoginPage.SignIn_Button.click();
		Thread.sleep(3000);
		Assert.assertTrue(sHelper.isElementPresent(driver, Self_ServicePortal_LoginPage.SignOut_Link));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " Test case status :" + (sHelper.isElementPresent(driver, Self_ServicePortal_LoginPage.SignOut_Link) ? "Pass" : "Fail"));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void resetLDAPPasswordViaSSP(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		TestBed tb = new TestBed();
		try {
			config.put("user_name", config.get("ssp_username"));
			config.put("user_ldap_password", config.get("ssp_password"));
			tb.resetPassword(config);
			tb.prepareForPasswordManagement(config);
			// WebDriver dr2 = null;
			// String hostName = config.get("ssl_hostname");
			String userName = config.get("ssp_username");
			String password = config.get("ssp_password");
			// String securityCode = "880967";
			String securityCode = config.get("ssp_securitycode");
			String server = config.get("eg_server_host");
			String newPassword = config.get("new_password");
			String confirmPassword = config.get("confirm_password");
			String url;
			String passwordChangeSuccessMessage = "You have successfully changed your password. Sign in to continue to VIP Self Service Portal.";
			url = "https://" + server + ":8233/vipssp";
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + " SSP IDP URL : " + url);
			Self_ServicePortal_LoginPage = PageFactory.initElements(driver, SelfServicePortalLoginPage.class);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.navigate().to(url);
			WebDriverWait wt = new WebDriverWait(driver, 120);
			// wt1.until(ExpectedConditions.elementToBeClickable(Self_ServicePortal_LoginPage.SignIn_Button))
			// ;
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending user name : " + userName);
			driver.findElement(By.name("username")).sendKeys(userName);
			// Self_ServicePortal_LoginPage.UserName_TextBox.sendKeys(userName);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending password  : " + password);
			Self_ServicePortal_LoginPage.Password_TextBox.sendKeys(password);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Sign In Button");
			Self_ServicePortal_LoginPage.SignIn_Button.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Waiting to see Received Password Reset Yes or No message");
			String parentHandle = driver.getWindowHandle();
			Self_ServicePortal_LoginPage.Password_Reset_Yes_Button.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicked on Yes button to proceed with password");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Waiting to get IA script popup");
			Thread.sleep(5000);
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle); // switch focus of
			}
			Assert.assertTrue(sHelper.isElementPresent(driver, Self_ServicePortal_LoginPage.Confirm_Your_Identity_SecurityCode_TextBox));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Received JS Confirm Identity popup box");
			Self_ServicePortal_LoginPage.Confirm_Your_Identity_SecurityCode_TextBox.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Sending " + securityCode + " to security code box");
			Thread.sleep(4000);
			Self_ServicePortal_LoginPage.Confirm_Your_Identity_SecurityCode_TextBox.sendKeys(securityCode);
			Thread.sleep(1000);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on continue button");
			Self_ServicePortal_LoginPage.Confirm_Your_Identiy_Continue_Button.click();
			Thread.sleep(1000);
			driver.switchTo().window(parentHandle);
			if (newPassword != null) {
				Self_ServicePortal_LoginPage.Password_Change_NewPassword_TextBox.sendKeys(newPassword);
				Self_ServicePortal_LoginPage.Password_Change_ConfirmPassword_TextBox.sendKeys(confirmPassword);
			} else {
				long newPasswordExtention = new Date().getTime();
				newPassword = config.get("ssp_password") + String.valueOf(newPasswordExtention);
				confirmPassword = newPassword;
				Self_ServicePortal_LoginPage.Password_Change_NewPassword_TextBox.sendKeys(newPassword);
				Self_ServicePortal_LoginPage.Password_Change_ConfirmPassword_TextBox.sendKeys(confirmPassword);
			}
			Self_ServicePortal_LoginPage.Password_Change_Continue_Button.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Received the message: " + Self_ServicePortal_LoginPage.Password_Change_Status_Message.getText());
			Assert.assertTrue(Self_ServicePortal_LoginPage.Password_Change_Status_Message.getText().contains(passwordChangeSuccessMessage), "Unexpected message received "
					+ Self_ServicePortal_LoginPage.Password_Change_Status_Message.getText());
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "SSP Password Reset was successful, Trying login with new Password " + newPassword);
			config.put("ssp_password", newPassword);
			LoginToSSPSAMLSuccessCheck(config, driver);
		} catch (Exception e) {
			throw e;
		} finally {
			tb.resetPassword(config);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void loginToSSPwithOutSSL(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		// WebDriver dr2 = null;
		// String hostName = config.get("ssl_hostname");
		String userName = config.get("ssp_username");
		String password = config.get("ssp_password");
		String securityCode = config.get("ssp_securitycode");
		String server = config.get("eg_server_host");
		String url;
		url = "http://" + server + ":8233/vipssp";
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " SSP IDP URL : " + url);
		Self_ServicePortal_LoginPage = PageFactory.initElements(driver, SelfServicePortalLoginPage.class);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.navigate().to(url);
		WebDriverWait wt1 = new WebDriverWait(driver, 120);
		Thread.sleep(5000);
		// wt1.until(ExpectedConditions.elementToBeClickable(Self_ServicePortal_LoginPage.SignIn_Button))
		// ;
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending user name : " + userName);
		driver.findElement(By.name("username")).sendKeys(userName);
		// Self_ServicePortal_LoginPage.UserName_TextBox.sendKeys(userName);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending password  : " + password);
		Self_ServicePortal_LoginPage.Password_TextBox.sendKeys(password);
		Self_ServicePortal_LoginPage.SignIn_Button.click();
		Thread.sleep(3000);
		wt1.until(ExpectedConditions.elementToBeClickable(Self_ServicePortal_LoginPage.Continue_Button));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending security code : " + securityCode);
		Self_ServicePortal_LoginPage.SecurityCode_TextBox.sendKeys(securityCode);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking continue button");
		Self_ServicePortal_LoginPage.Continue_Button.click();
		Thread.sleep(5000);
		Assert.assertTrue(sHelper.isElementPresent(driver, Self_ServicePortal_LoginPage.SignOut_Link));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " Test case status :" + (sHelper.isElementPresent(driver, Self_ServicePortal_LoginPage.SignOut_Link) ? "Pass" : "Fail"));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void LoginToVIPMGR(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		// WebDriver dr2 = null;
		// String hostName = config.get("ssl_hostname");
		String userName = config.get("vip_username");
		String password = config.get("vip_password");
		String server = config.get("eg_server_host");
		String url = "https://" + server + ":8234/vipmgr";
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Manager IDP URL : " + url);
		Vip_Mgr_IDPPortal_LoginPage = PageFactory.initElements(driver, VipmgrIDPPortalLoginPage.class);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.navigate().to(url);
		Thread.sleep(5000);
		// wt1.until(ExpectedConditions.elementToBeClickable(Self_ServicePortal_LoginPage.SignIn_Button))
		// ;
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending user name ");
		driver.findElement(By.name("username")).sendKeys(userName);
		// Self_ServicePortal_LoginPage.UserName_TextBox.sendKeys(userName);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending password ");
		Vip_Mgr_IDPPortal_LoginPage.Password_TextBox.sendKeys(password);
		Vip_Mgr_IDPPortal_LoginPage.SignIn_Button.click();
		Thread.sleep(4000);
		Assert.assertTrue(sHelper.isElementPresent(driver, Vip_Mgr_IDPPortal_LoginPage.SecurityCode_TextBox));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " Test case status :" + (sHelper.isElementPresent(driver, Vip_Mgr_IDPPortal_LoginPage.SecurityCode_TextBox) ? "Pass" : "Fail"));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void loginToVIPMGRWithoutSSL(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		// WebDriver dr2 = null;
		// String hostName = config.get("ssl_hostname");
		String userName = config.get("vip_username");
		String password = config.get("vip_password");
		String server = config.get("eg_server_host");
		String url = "http://" + server + ":8234/vipmgr";
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "VIP Manager IDP URL : " + url);
		Vip_Mgr_IDPPortal_LoginPage = PageFactory.initElements(driver, VipmgrIDPPortalLoginPage.class);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.navigate().to(url);
		Thread.sleep(5000);
		// wt1.until(ExpectedConditions.elementToBeClickable(Self_ServicePortal_LoginPage.SignIn_Button))
		// ;
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending user name ");
		driver.findElement(By.name("username")).sendKeys(userName);
		// Self_ServicePortal_LoginPage.UserName_TextBox.sendKeys(userName);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "sending password ");
		Vip_Mgr_IDPPortal_LoginPage.Password_TextBox.sendKeys(password);
		Vip_Mgr_IDPPortal_LoginPage.SignIn_Button.click();
		Thread.sleep(4000);
		Assert.assertTrue(sHelper.isElementPresent(driver, Vip_Mgr_IDPPortal_LoginPage.SecurityCode_TextBox));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " Test case status :" + (sHelper.isElementPresent(driver, Vip_Mgr_IDPPortal_LoginPage.SecurityCode_TextBox) ? "Pass" : "Fail"));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void UpdateSettings(Map<String, String> config, WebDriver driver) throws Exception {
		Import_Settings_Page = PageFactory.initElements(driver, ImportSettingsPage.class);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String sUsername = config.get("login_username");
		String sPassword = config.get("login_password");
		String buildNumber = "9.6.1"; // config.get("build_no");
		boolean isCancel = Boolean.valueOf(config.get("is_cancel"));
		String testDesc = config.get("test_description");
		Update_Settings_Page = PageFactory.initElements(driver, UpdateSettings.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		Configuration_Console_Login_Page = PageFactory.initElements(driver, ConfigurationConsoleLoginPage.class);
		int counter = 0;
		WebDriverWait wt = new WebDriverWait(driver, 90);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Test description: " + testDesc);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Setting tab");
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Settings_Tab.click();
		Update_Settings_Page.Update_Settings_Link.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking check update link");
		Update_Settings_Page.Check_Update_Link.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "switching to new window");
		driver.switchTo().frame(0);
		wt.until(ExpectedConditions.visibilityOf(Update_Settings_Page.Download_button));
		Assert.assertTrue(sHelper.isElementPresent(driver, Update_Settings_Page.Download_button), "Download button is not present");
		if (!isCancel) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking download button");
			Update_Settings_Page.Download_button.click();
			wt.until(ExpectedConditions.visibilityOf(Update_Settings_Page.Agreement_CheckBox));
			Assert.assertTrue(sHelper.isElementPresent(driver, Update_Settings_Page.Agreement_CheckBox), "Agreement checkbox is not present");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking Accept License Agreement checkbox ");
			Update_Settings_Page.Agreement_CheckBox.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicked Accept License Agreement checkbox ");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking proceed button");
			Thread.sleep(2000);
			Update_Settings_Page.Proceed_Button.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicked it");
			Thread.sleep(200000);
			 for (int i = 0; i <= 10; i++) {
				if (!sHelper.isElementPresent(driver, Update_Settings_Page.Status_Message_TextLabel)) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Refreshing the page. Tries : " + i);
					driver.get(driver.getCurrentUrl());
					driver.findElement(By.id("errorTitleText")).sendKeys(Keys.F5);
				} else
					break;
			}
			wt.until(ExpectedConditions.visibilityOf(Update_Settings_Page.Status_Message_TextLabel));
			Assert.assertTrue(sHelper.isElementPresent(driver, Update_Settings_Page.Status_Message_TextLabel), "Upgrade status text is not present");
			while (counter <= 8) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Upgrade Status : " + Update_Settings_Page.Status_Message_TextLabel.getText());
				if (Update_Settings_Page.Status_Message_TextLabel.getText().contains("Successfully")) {
					Thread.sleep(2000);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking refresh button");
					Update_Settings_Page.Refresh_Link.click();
					break;
				} else {
					Thread.sleep(30000);
					counter++;
				}
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Waiting for user name textbox ");
			wt.until(ExpectedConditions.visibilityOf(Configuration_Console_Login_Page.UserName_TextBox));
			if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.UserName_TextBox)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "======Login =======");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Sending username : " + sUsername);
				Configuration_Console_Login_Page.UserName_TextBox.sendKeys(sUsername);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Sending password : " + sPassword);
				Configuration_Console_Login_Page.Password_TextBox.sendKeys(sPassword);
				if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Login_Auth_Type_SelectBox)) {
					Select dropdown = new Select(Configuration_Console_Login_Page.Login_Auth_Type_SelectBox);
					List<WebElement> options = dropdown.getOptions();
					for (WebElement option : options) {
						if ((option.getText()).equalsIgnoreCase("Local Administrator")) {
							option.click();
							break;
						}
					}
				} //
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking submit button");
				Configuration_Console_Login_Page.Submit_Button.click();
				if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button)) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking confirm yes button.");
					Configuration_Console_Login_Page.Confirm_SignIn_Yes_Button.click();
				}
				if (sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link)) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking the EG Version . Input version : " + buildNumber + " | EG Version : "
							+ Configuration_Console_Home_Page.Version_Label.getText());
					Assert.assertTrue(Configuration_Console_Home_Page.Version_Label.getText().contains(buildNumber));
				} else {
					Assert.assertTrue(false, "Sign out link not found. Not logged in.");
				}
			} else {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "User Name text box not found. Login failure.");
				Assert.assertTrue(false, "User Name text box not found. Login failure.");
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void SystemSettingsEdit(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		System_Setting_Page = PageFactory.initElements(driver, SystemSettingsPage.class);
		Settings_Home_Page = PageFactory.initElements(driver, SettingsHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String sName = config.get("sync_cluster_name");
		String successMessage = "saved successfully";
		WebDriverWait wt = new WebDriverWait(driver, 30);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Setting tab");
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Settings_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on System Setting tab");
		Settings_Home_Page.System_Settings_Tab.click();
		wt.until(ExpectedConditions.visibilityOf(System_Setting_Page.Edit_Button));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Editing button tab");
		System_Setting_Page.Edit_Button.click();
		wt.until(ExpectedConditions.visibilityOf(System_Setting_Page.Name_TextBox));
		System_Setting_Page.Name_TextBox.clear();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Sending name: " + sName);
		System_Setting_Page.Name_TextBox.sendKeys(sName);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Save button");
		System_Setting_Page.Save_Button.click();
		Assert.assertTrue(System_Setting_Page.Save_Message.getText().contains(successMessage), "Update failed. Actual message is : " + System_Setting_Page.Save_Message.getText());
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void SystemSettingsCheck(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		System_Setting_Page = PageFactory.initElements(driver, SystemSettingsPage.class);
		Settings_Home_Page = PageFactory.initElements(driver, SettingsHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String sName = config.get("sync_cluster_name");
		WebDriverWait wt = new WebDriverWait(driver, 30);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Setting tab");
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Settings_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on System Setting tab");
		Settings_Home_Page.System_Settings_Tab.click();
		wt.until(ExpectedConditions.visibilityOf(System_Setting_Page.Edit_Button));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Editing button tab");
		System_Setting_Page.Edit_Button.click();
		wt.until(ExpectedConditions.visibilityOf(System_Setting_Page.Name_TextBox));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking the name");
		Assert.assertTrue(System_Setting_Page.Name_TextBox.getAttribute("value").toString().contains(sName), "Check failed. Actual name: "
				+ System_Setting_Page.Name_TextBox.getAttribute("value").toString() + "Expected name: " + sName);
		System_Setting_Page.Cancel_Button.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void SysLogConfiguration(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		Syslog_Configuration_Page = PageFactory.initElements(driver, SyslogConfigurationPage.class);
		Logs_Main_Page = PageFactory.initElements(driver, LogsMainPage.class);
		String facilityName = config.get("facility_name");
		String hostName1 = config.get("host_name_1");
		String port1 = config.get("port_1");
		String hostName2 = config.get("host_name_2");
		String port2 = config.get("port_2");
		String hostName3 = config.get("host_name_3");
		String port3 = config.get("port_3");
		String successMessage = "successfully";
		boolean flag = true, isEditFlow = false;
		int counter = 0, innerCounterForKeyRemoved = 0;
		int listSize = 0, inputDataSize = 0;
		List<WebElement> list;
		HashMap<String, String> inputData = new HashMap<String, String>();
		inputData.put(hostName1, port1);
		inputData.put(hostName2, port2);
		inputData.put(hostName3, port3);
		WebDriverWait wt = new WebDriverWait(driver, 45);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logs")));
		Configuration_Console_Home_Page.Logs_Tab.click();
		wt.until(ExpectedConditions.visibilityOf(Logs_Main_Page.Tab_SyslogConfiguration));
		Logs_Main_Page.Tab_SyslogConfiguration.click();
		for (Map.Entry m2 : inputData.entrySet())
			if (m2.getKey() != null)
				counter++;
		if (sHelper.isElementPresent(driver, Syslog_Configuration_Page.Button_Edit)) {
			Syslog_Configuration_Page.Button_Edit.click();
			Syslog_Configuration_Page.TextBox_Facility.clear();
			Syslog_Configuration_Page.TextBox_Facility.sendKeys(facilityName);
			isEditFlow = true;
		} else if (sHelper.isElementPresent(driver, Syslog_Configuration_Page.Button_Save)) {
			Syslog_Configuration_Page.TextBox_Facility.clear();
			Syslog_Configuration_Page.TextBox_Facility.sendKeys(facilityName);
		}
		loop: while (flag) {
			list = Syslog_Configuration_Page.SSlListElement();
			innerLoop: for (WebElement li : list) {
				listSize = list.size();
				inputDataSize = counter;
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "List size: " + listSize + "  input data size : " + inputDataSize);
				if (isEditFlow && listSize > inputDataSize)
					while (listSize - inputDataSize != 0) {
						Thread.sleep(1000);
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking minus button");
						li.findElement(By.className("minusBtn")).click();
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicked minus button");
						inputDataSize++;
						continue loop;
					}
				if (listSize < inputDataSize) {
					listSize++;
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking plus button");
					li.findElement(By.className("plusBtn")).click();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicked plus button");
					continue loop;
				}
				for (Map.Entry m : inputData.entrySet()) {
					{
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Entering the values :" + m.getKey());
						if (m.getKey() != null) {
							li.findElement(By.xpath("div/input")).clear();
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Host name  :" + m.getKey().toString());
							li.findElement(By.xpath("div/input")).sendKeys(m.getKey().toString());
							li.findElement(By.xpath("div[2]/input")).clear();
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Host port  :" + m.getValue().toString());
							li.findElement(By.xpath("div[2]/input")).sendKeys(m.getValue().toString());
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Removing hostname : " + m.getKey());
							inputData.remove(m.getKey());
							// ----for debugging purpose----
							// for (Map.Entry m1 : inputData.entrySet())
							// if (m1.getKey() != null)
							// logger.info("Thread-"+Thread.currentThread().getId()+": "+"Inner loop. Hostname : "
							// +
							// m1.getKey());
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "removed the hostname");
							innerCounterForKeyRemoved++;
							continue innerLoop;
						} else if (innerCounterForKeyRemoved == inputDataSize) {
							flag = false;
							break;
						}
					}
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking save button");
		Syslog_Configuration_Page.Button_Save.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Status: " + Syslog_Configuration_Page.MessageElement.getText());
		Assert.assertTrue(Syslog_Configuration_Page.MessageElement.getText().contains(successMessage), "failed to configure sys log.");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void verify_Legal_Notice_FooterLink(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Add_VIP_Certificate_Page = PageFactory.initElements(driver, AddVIPCertificatePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		Footer_Links_Details_Page = PageFactory.initElements(driver, FooterLinksDetailsPage.class);
		String parentHandle = "";
		String legalNoticeText = "Legal Notices";
		WebDriverWait wt = new WebDriverWait(driver, 20);
		parentHandle = driver.getWindowHandle();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking for visibility of Legal notice link");
		if (sHelper.isElementPresent(driver, Configuration_Console_Home_Page.LegalNotice_Link)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking legal notice link");
			Configuration_Console_Home_Page.LegalNotice_Link.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to legal notice window");
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle); // switch focus of
				// WebDriver to the
				// next found window
				// handle (that's
				// the newly opened
				// window)
			}
			wt.until(ExpectedConditions.visibilityOf(Footer_Links_Details_Page.Legal_Notice_Header_Data_TextLabel));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Text in the page: " + Footer_Links_Details_Page.Legal_Notice_Header_Data_TextLabel.getText());
			Assert.assertTrue(Footer_Links_Details_Page.Legal_Notice_Header_Data_TextLabel.getText().contains(legalNoticeText), "Legal notice data not found");
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Closing the newly opened window");
		driver.close(); // close newly opened window when done with it
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to main window");
		driver.switchTo().window(parentHandle);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void Verify_Repository_FooterLink(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Add_VIP_Certificate_Page = PageFactory.initElements(driver, AddVIPCertificatePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		Footer_Links_Details_Page = PageFactory.initElements(driver, FooterLinksDetailsPage.class);
		String parentHandle = "";
		String repositoryText = "Repository";
		WebDriverWait wt = new WebDriverWait(driver, 20);
		parentHandle = driver.getWindowHandle();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking for visibility of Respository link");
		if (sHelper.isElementPresent(driver, Configuration_Console_Home_Page.Repository_Link)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking legal notice link");
			Configuration_Console_Home_Page.Repository_Link.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to repository window");
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle); // switch focus of
				// WebDriver to the
				// next found window
				// handle (that's
				// the newly opened
				// window)
			}
			wt.until(ExpectedConditions.visibilityOf(Footer_Links_Details_Page.Repository_Header_Data_TextLabel));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Text in the page: " + Footer_Links_Details_Page.Repository_Header_Data_TextLabel.getText());
			Assert.assertTrue(Footer_Links_Details_Page.Repository_Header_Data_TextLabel.getText().contains(repositoryText), "Legal notice data not found");
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Closing the newly opened window");
		driver.close(); // close newly opened window when done with it
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to main window");
		driver.switchTo().window(parentHandle);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void Verify_Privacy_FooterLink(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Add_VIP_Certificate_Page = PageFactory.initElements(driver, AddVIPCertificatePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		Footer_Links_Details_Page = PageFactory.initElements(driver, FooterLinksDetailsPage.class);
		String parentHandle = "";
		String privacyText = "Privacy";
		WebDriverWait wt = new WebDriverWait(driver, 20);
		parentHandle = driver.getWindowHandle();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking for visibility of privacy link");
		if (sHelper.isElementPresent(driver, Configuration_Console_Home_Page.Privacy_Link)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking Privacy Link");
			Configuration_Console_Home_Page.Privacy_Link.click();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to Privacy window");
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle); // switch focus of
				// WebDriver to the
				// next found window
				// handle (that's
				// the newly opened
				// window)
			}
			wt.until(ExpectedConditions.visibilityOf(Footer_Links_Details_Page.Privacy_Link));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Text in the page: " + Footer_Links_Details_Page.Privacy_Link.getText());
			Assert.assertTrue(Footer_Links_Details_Page.Privacy_Link.getText().contains(privacyText), "Legal notice data not found");
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Closing the newly opened window");
		driver.close(); // close newly opened window when done with it
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to main window");
		driver.switchTo().window(parentHandle);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void Verify_HelpLink_In_Login_Page(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String login_protocol = config.get("login_protocol");
		String login_port = config.get("login_port");
		String server = config.get("eg_server_host");
		boolean isHTTPS = Boolean.valueOf(config.get("is_https_console"));
		String parentHandle = "", firstLinktext = "Signing In to VIP Enterprise Gateway Configuration Console";
		int counter = 0;
		int maxRetry = 3;
		String loginURL;
		if (isHTTPS) {
			loginURL = "https://" + server + ":8232/";
		} else {
			loginURL = sHelper.MakeURL(login_protocol, server, login_port);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Login url is : " + loginURL);
		Configuration_Console_Login_Page = PageFactory.initElements(driver, ConfigurationConsoleLoginPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link))
			Configuration_Console_Home_Page.SignOut_Link.click();
		else {
			driver.get(loginURL);
			while (counter <= maxRetry) {
				if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.UserName_TextBox) || sHelper.isElementPresent(driver, Configuration_Console_Home_Page.SignOut_Link))
					break;
				else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Refreshing the page. Tries : " + (counter + 1));
					counter++;
					driver.get(driver.getCurrentUrl());
				}
				if (counter == maxRetry) {
					loginURL = "https://" + server + ":8232/";
					driver.get(loginURL);
				}
			}
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		if (sHelper.isElementPresent(driver, Configuration_Console_Login_Page.UserName_TextBox)) {
			parentHandle = driver.getWindowHandle();
			Configuration_Console_Login_Page.Help_link.click();
			for (String winHandle : driver.getWindowHandles()) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "switched to new window");
				driver.switchTo().window(winHandle); // switch focus of
				// WebDriver to the
				// next found window
				// handle (that's
				// the newly opened
				// window)
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "moving to main  frame ");
			Thread.sleep(2500);
			driver.switchTo().frame(1);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "moving to left side mini navigation bar frame");
			driver.switchTo().frame("minibar_navpane");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "moving to settings menu frame");
			driver.switchTo().frame("navpane");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "moving to settings menu links frame");
			driver.switchTo().frame("tocIFrame");
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Text present in the first link in left menu : " + driver.findElement(By.id("I_1")).getText());
			Assert.assertTrue(driver.findElement(By.id("I_1")).getText().toString().contains(firstLinktext), "First link in the left menu not found or contains different text name");
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Closing the newly opened window");
		driver.close(); // close newly opened window when done with it
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to main window");
		driver.switchTo().window(parentHandle);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void CheckAndConfigureValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Map<String, String> configStatus;
		// String mode = config.get("mode").toLowerCase();
		String serverName = config.get("validation_server_name");
		String valServerHost = config.get("validation_server_host");
		configStatus = rClient.PerformRemoteAction("CheckConfigurationStatus", config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "config status is " + configStatus);
		String valServerStatus = configStatus.get(serverName.toLowerCase());
		if (valServerStatus != null && valServerStatus.equalsIgnoreCase("ready")) {
			Assert.assertTrue(true, "Validation Server " + serverName + " has already been configured in server " + valServerHost);
			StartValidationServer(config, driver);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Validation Server " + serverName + " has already been configured in server " + valServerHost);
		} else {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "validation server does not exist, so invoking validaiton server configuration");
			createValidationServer(config, driver);
			StartValidationServer(config, driver);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void CheckAndCreateValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Map<String, String> configStatus;
		// String mode = config.get("mode").toLowerCase();
		String serverName = config.get("validation_server_name");
		String valServerHost = config.get("validation_server_host");
		configStatus = rClient.PerformRemoteAction("CheckConfigurationStatus", config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "config status is " + configStatus);
		String valServerStatus = configStatus.get(serverName.toLowerCase());
		if (valServerStatus != null && !valServerStatus.equalsIgnoreCase("ready")) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "validation server does not exist, so invoking validaiton server configuration in " + valServerHost);
			createValidationServer(config, driver);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void changeAuthenticationURLtoQA(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Map<String, String> configStatus;
		config.put("vip_service_url", "userservices-auth.vip.symclab.com");
		configStatus = rClient.PerformRemoteAction("ChangeAuthenticationURL", config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "config status is " + configStatus);
		Assert.assertEquals("done", configStatus.get("remote_action_status"));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void findAndActOnValidationServer(WebDriver driver, String validationServerName, String action) throws Exception {
		// This method will handle, start, start all, restart, restart all (low
		// prio), edit (till go to edit page", delete, duplicate the validation
		// server
		logger.info("Thread-" + Thread.currentThread().getId() + ": + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		logger.info("Thread-" + Thread.currentThread().getId() + ": Initiating Validation Server " + action.toUpperCase() + " action.");
		WebDriverWait wt = new WebDriverWait(driver, 15);
		boolean pagination = false;
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Validation")));
		Configuration_Console_Home_Page.Validation_Tab.click();
		wt.until(ExpectedConditions.visibilityOf(Validation_Server_Home_Page.Add_Server_Button));
		List<WebElement> listOfServers = null;
		String valServerName;
		int noOfRows = 0;
		boolean flag = false;
		String state = Validation_Server_Home_Page.Pagination_Table_End_Page.getAttribute("class");
		listOfServers = Validation_Server_Home_Page.ValidationServersList_Table;
		noOfRows = listOfServers.size();
		logger.info("Thread-" + Thread.currentThread().getId() + ": Reached to validation home page. Total Servers are: " + (noOfRows - 1));
		if (state.contains("disabled") || noOfRows == 1) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": Pagination table is NOT available");
			pagination = false;
		} else {
			pagination = true;
		}
		for (int j = 1; j <= 30; j++) {
			if (pagination) {
				Validation_Server_Home_Page.PageNo_TextBox.clear();
				Validation_Server_Home_Page.PageNo_TextBox.sendKeys(Integer.toString(j));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Navigating to validation server page " + Integer.toString(j));
				Validation_Server_Home_Page.PageNo_TextBox.sendKeys(Keys.RETURN);
			}
			listOfServers = Validation_Server_Home_Page.ValidationServersList_Table;
			noOfRows = listOfServers.size();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Landed to " + j + " page. Total Servers are: " + (noOfRows - 1));
			if ((noOfRows - 1) == 0) {
				break;
			}
			for (int i = 2; i <= noOfRows; i++) {
				if (pagination) {
					Validation_Server_Home_Page.PageNo_TextBox.clear();
					Validation_Server_Home_Page.PageNo_TextBox.sendKeys(Integer.toString(j));
					Validation_Server_Home_Page.PageNo_TextBox.sendKeys(Keys.RETURN);
				}
				Thread.sleep(1000);
				valServerName = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + i + "]/td[1]//a")).getAttribute("title");
				action = action.toLowerCase();
				if (!(action.equals("startall") || action.equals("restartall"))) {
					if (valServerName != null) {
						if (validationServerName.trim().equalsIgnoreCase(valServerName.trim())) {
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Initiating action on validation server " + validationServerName + " on Page " + j + " ");
							actOnValidationServer(i, driver, valServerName, action);
							flag = true;
							break;
						}
					}
				} else {
					String actualAction;
					if (action.equalsIgnoreCase("startall")) {
						actualAction = "start";
					} else {
						actualAction = "restart";
					}
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Initiating action to validation server of index " + i + " on Page " + j + " ");
					actOnValidationServer(i, driver, valServerName, actualAction);
				}
			}
			if (flag) {
				break;
			}
			if (!pagination) {
				break;
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void actOnValidationServer(int index, WebDriver driver, String serverName, String action) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 45);
		action = action.toLowerCase();
		String expMessage = null;
		boolean waitRequirement = true;
		try {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Invoking action " + action.toUpperCase() + " on validation server");
			String status = driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + index + "]/td[4]/div/div")).getAttribute("class");
			if (action.equals("restart")) {
				String restartIcon = ".//*[@id='restart_" + serverName + "']/img";
				expMessage = serverName + " was restarted successfully.";
				if (sHelper.isElementPresent(driver, By.xpath(restartIcon))) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Restarting the validation server " + serverName);
					driver.findElement(By.xpath(restartIcon)).click();
				} else {
					logger.error("Thread-" + Thread.currentThread().getId() + ": " + "No restart icon is displayed.");
					// Assert.assertTrue(false, "No Restart icon is displayed");
					waitRequirement = false;
				}
			} else if (action.equals("startorrestart")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Current Status of the Server is: " + status.toUpperCase());
				String restartIcon = ".//*[@id='restart_" + serverName + "']/img";
				if (status.equalsIgnoreCase("slider off")) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Server is stopeped, so starting the server");
					expMessage = serverName + " was started successfully.";
					driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + index + "]/td[4]/div/div")).click();
				} else if (sHelper.isElementPresent(driver, By.xpath(restartIcon))) {
					expMessage = serverName + " was restarted successfully.";
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Restarting the validation server " + serverName);
					driver.findElement(By.xpath(restartIcon)).click();
				}
			} else if (action.equals("start") && status.equalsIgnoreCase("slider on")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Validation Server " + serverName + " already in started state");
				waitRequirement = false;
			} else if (action.equals("start") && status.equalsIgnoreCase("slider off")) {
				expMessage = serverName + " was started successfully.";
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Starting the validation server " + serverName);
				driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + index + "]/td[4]/div/div")).click();
			} else if (action.equals("stop") && status.equalsIgnoreCase("slider off")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Validation Server " + serverName + " already in stopped state");
				waitRequirement = false;
			} else if (action.equals("stop") && status.equalsIgnoreCase("slider on")) {
				expMessage = serverName + " was stopped successfully.";
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Stopping the validation server " + serverName);
				driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + index + "]/td[4]/div/div")).click();
			} else if (action.equals("delete")) {
				expMessage = serverName + " has been deleted successfully";
				WebElement deleteLink = driver.findElement(By.xpath(".//*[@id='delete_" + serverName + "&forward=server']"));
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Deleting the server " + serverName);
				if (isAlertPresent(driver)) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Unexpected alert found");
					Alert alert = driver.switchTo().alert();
					alert.accept();
				}
				deleteLink.click();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Waiting for the alert message");
				// int t = 1;
				// while (driver.switchTo().alert() == null && t < 10) {
				// logger.info("Thread-" + Thread.currentThread().getId() + ": "
				// +
				// "Rechecking for the alert message");
				// Thread.sleep(1000);
				// t = t + 1;
				// }
				Alert alert = wt.until(ExpectedConditions.alertIsPresent());
				// Alert alert = driver.switchTo().alert();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Recieved alert" + alert.getText());
				alert.accept();
			} else if (action.equals("edit")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Edit button");
				driver.findElement(By.linkText(serverName)).click();
				waitRequirement = false;
			} else if (action.equals("duplicate")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Duplicate button");
				driver.findElement(By.xpath("//table[@id='list_valid']/descendant::tr[" + index + "]/td[5]/a[text()='Duplicate']")).click();
				waitRequirement = false;
			}
			if (waitRequirement) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Waiting to get the status message .");
				wt.until(ExpectedConditions.visibilityOf(Validation_Server_Home_Page.Action_Message));
				String outMessage = Validation_Server_Home_Page.Action_Message.getText();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Validation server status message was: " + outMessage);
				Assert.assertTrue(outMessage.contains(expMessage), "Expected Message " + expMessage + ". Actual: " + outMessage);
			}
		} catch (WebDriverException we) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Unexpected alert found. Accepting the alert");
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void enablePasswordManagement(WebDriver driver, Map<String, String> config) {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 40);
		UserStore_Main_Page = PageFactory.initElements(driver, UserStoreMainPage.class);
		Password_Management_tab = PageFactory.initElements(driver, PasswordManagementTabInUserStoreEditPage.class);
		UserStore_Edit_Home_Page = PageFactory.initElements(driver, EditUserStoreHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String name = config.get("userstore_name");
		final String successMessage = "Password Management settings updated successfully.";
		String listPath = "//div[@class='divRowTableBody']/descendant::li";
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("User Store")));
		Configuration_Console_Home_Page.UserStore_Tab.click();
		logger.info("Getting list of user stores");
		List<WebElement> userStoreList = UserStore_Main_Page.UserstoreList;
		int numberOfUserstores = userStoreList.size();
		for (int i = 1; i <= numberOfUserstores; i++) {
			String userStoreName = driver.findElement(By.xpath(listPath + "[" + i + "]/div[2]/div[1]/a")).getText();
			if (userStoreName.equalsIgnoreCase(name)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Found the user store:" + name);
				driver.findElement(By.xpath(listPath + "[" + i + "]/div[4]/a[text()='Edit']")).click();
				//driver.findElement(By.xpath("//*[@id='dragIconTD_7']/div[4]/a[1]")).click();//Kesav
				break;
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on password management tab");
		UserStore_Edit_Home_Page.PasswordManagement_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Edit button");
		Password_Management_tab.Edit_Button.click();
		String value = Password_Management_tab.Enable_Checkbox.getAttribute("value");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Password management option is selected is:" + value);
		if (value.equalsIgnoreCase("false")) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Checking password management option");
			Password_Management_tab.Enable_Checkbox.click();
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Submit button");
		Password_Management_tab.Submit_Button.click();
		// // no success message to assert here Kesav
		wt.until(ExpectedConditions.visibilityOf(UserStore_Edit_Home_Page.SubmitMessage_WebElement));
		String message = UserStore_Edit_Home_Page.SubmitMessage_WebElement.getText();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Received the message: " + message);
		Assert.assertEquals(successMessage, message);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void verifyProductVersion(WebDriver driver, Map<String, String> config) {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String[] buildNoSplitted = config.get("build_no").split("\\.");
		// eg 9.5.0
		String roundedBuildNo = buildNoSplitted[0] + "." + buildNoSplitted[1] + "." + buildNoSplitted[2];
		Config_Summary_Page = PageFactory.initElements(driver, ConfigurationSummaryPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		WebDriverWait wt = new WebDriverWait(driver, 15);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Home_Tab.click();
		String productDetails = Config_Summary_Page.ProductDetails_ReadOnlyField.getText();
		Assert.assertTrue(productDetails.contains(roundedBuildNo), "String expected: " + roundedBuildNo + " does not contain in String: " + productDetails);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void verifyOSPlatform(WebDriver driver, Map<String, String> config) {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String serverContext = config.get("server_context");
		String osPlatfrom = null;
		Config_Summary_Page = PageFactory.initElements(driver, ConfigurationSummaryPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		WebDriverWait wt = new WebDriverWait(driver, 15);
		if (serverContext.contains("windows")) {
			osPlatfrom = "Windows";
		} else if (serverContext.contains("rhel")) {
			osPlatfrom = "Linux";
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Home_Tab.click();
		String productDetails = Config_Summary_Page.ProductDetails_ReadOnlyField.getText();
		Assert.assertTrue(productDetails.contains(osPlatfrom), "String expected: " + osPlatfrom + " does not contain in String: " + productDetails);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void verifyCopyRightInformation(WebDriver driver, Map<String, String> config) {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String yearInString = String.valueOf(year);
		String expectedCopyRightInfo = yearInString + " Symantec Corporation";
		Config_Summary_Page = PageFactory.initElements(driver, ConfigurationSummaryPage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		WebDriverWait wt = new WebDriverWait(driver, 15);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
		Configuration_Console_Home_Page.Home_Tab.click();
		String actualCopyRightInfo = Config_Summary_Page.CopyRight_ReadOnlyField.getText();
		Assert.assertTrue(actualCopyRightInfo.contains(expectedCopyRightInfo), "Version expected: " + expectedCopyRightInfo + ". Actual: " + actualCopyRightInfo);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void configureOOBAttributesInUserStore(WebDriver driver, Map<String, String> config) {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		WebDriverWait wt = new WebDriverWait(driver, 40);
		final boolean enableMobile = Boolean.valueOf(config.get("enable_mobile"));
		final boolean enablePhone = Boolean.valueOf(config.get("enable_phone"));
		final boolean enableEmail = Boolean.valueOf(config.get("enable_email"));
		final String mobileAttributes = config.get("mobile_attributes");
		final String phoneAttributes = config.get("phone_attributes");
		final String emailAttributes = config.get("email_attributes");
		UserStore_Main_Page = PageFactory.initElements(driver, UserStoreMainPage.class);
		Password_Management_tab = PageFactory.initElements(driver, PasswordManagementTabInUserStoreEditPage.class);
		UserStore_Edit_Home_Page = PageFactory.initElements(driver, EditUserStoreHomePage.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		String name = config.get("userstore_name");
		final String successMessage = "User Store settings updated successfully";
		String listPath = "//div[@class='divRowTableBody']/descendant::li";
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("User Store")));
		Configuration_Console_Home_Page.UserStore_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Getting list of user stores");
		List<WebElement> userStoreList = UserStore_Main_Page.UserstoreList;
		int numberOfUserstores = userStoreList.size();
		for (int i = 1; i <= numberOfUserstores; i++) {
			String userStoreName = driver.findElement(By.xpath(listPath + "[" + i + "]/div[2]/div[1]/a")).getText();
			if (userStoreName.equalsIgnoreCase(name)) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Found the user store:" + name);
				driver.findElement(By.xpath(listPath + "[" + i + "]/div[4]/a[text()='Edit']")).click();
				break;
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Search Criteria tab");
		UserStore_Edit_Home_Page.SearchCriteria_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Edit button");
		UserStore_Edit_Home_Page.Edit_Search_Criteria_Button.click();
		// Configuring email attributes
		if (enableEmail) {
			String emailChecked = UserStore_Edit_Home_Page.Enable_Email_OOB.getAttribute("value");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Email option is set to " + emailChecked);
			if (emailChecked.equalsIgnoreCase("false")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enabling email option");
				UserStore_Edit_Home_Page.Enable_Email_OOB.click();
			}
			if (emailAttributes != null) {
				UserStore_Edit_Home_Page.TextBox_Email.clear();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting email attributes as " + emailAttributes);
				UserStore_Edit_Home_Page.TextBox_Email.sendKeys(emailAttributes);
			}
		}
		// Configuring phone attributes
		if (enablePhone) {
			String PhoneChecked = UserStore_Edit_Home_Page.Enable_Phone_OOB.getAttribute("value");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Phone option is set to " + PhoneChecked);
			if (PhoneChecked.equalsIgnoreCase("false")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enabling Phone option");
				UserStore_Edit_Home_Page.Enable_Phone_OOB.click();
			}
			if (phoneAttributes != null) {
				UserStore_Edit_Home_Page.TextBox_Phone.clear();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting Phone attributes as " + phoneAttributes);
				UserStore_Edit_Home_Page.TextBox_Phone.sendKeys(phoneAttributes);
			}
		}
		// Configuring Mobile attributes
		if (enableMobile) {
			String MobileChecked = UserStore_Edit_Home_Page.Enable_Mobile_OOB.getAttribute("value");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Mobile option is set to " + MobileChecked);
			if (MobileChecked.equalsIgnoreCase("false")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enabling Mobile option");
				UserStore_Edit_Home_Page.Enable_Mobile_OOB.click();
			}
			if (mobileAttributes != null) {
				UserStore_Edit_Home_Page.TextBox_Mobile.clear();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting Mobile attributes as " + mobileAttributes);
				UserStore_Edit_Home_Page.TextBox_Mobile.sendKeys(mobileAttributes);
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Save button");
		UserStore_Edit_Home_Page.Save_Search_Criteria_Button.click();
		// no success message to assert here Kesav
		/*String message = UserStore_Edit_Home_Page.SubmitMessage_WebElement.getText();
		Assert.assertTrue(message.contains(successMessage), "Expected Message: " + successMessage + ". Actual:" + message);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());*/
	}

	public void updateValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		String serverName = config.get("validation_server_name");
		String pushTimeOut = config.get("push_timeout");
		String pushRemoteServiceName = config.get("remote_service_name");
		String bc = config.get("bc_mode");
		String port = config.get("server_port");
		String loggingLevel = config.get("log_level");
		String radiusSharedSecret = config.get("validation_server_shared_secret");
		String radiusConfirmSharedSecret = config.get("confirm_rad_shared");
		boolean isChallengeSupported = Boolean.valueOf(config.get("challenge_supported"));
		// String expectedMessage =
		// "Validation server created with server name " + serverName;
		String vendor = config.get("vendor");
		String applicationName = config.get("application_name");
		boolean enableAccessChallenge = Boolean.valueOf(config.get("enable_access_challenge"));
		WebDriverWait wt = new WebDriverWait(driver, 20);
		String mode = config.get("mode").toLowerCase();
		String loggingRotLevel = config.get("log_rot_level");
		String noOfFilesToKeep = config.get("no_of_files_to_keep");
		String enableSyslog = config.get("enable_syslog");
		String passEncoding = config.get("pass_encoding");
		String userStore = config.get("userstore_name");
		String validationSuccessMessageOnDelegation = "Validation Server " + serverName + " was updated successfully.";
		String oS = config.get("server_context");
		boolean result = false;
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Mode : " + mode);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Server name  : " + serverName);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Validation")));
		Configuration_Console_Home_Page.Validation_Tab.click();
		Thread.sleep(3000);
		findAndActOnValidationServer(driver, serverName, "edit");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate port number");
		if (port != null) {
			Validation_Server_Config_Page.Port_TextBox.clear();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "port number: " + port);
			Validation_Server_Config_Page.Port_TextBox.sendKeys(port);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to check business continuity mode");
		if (!mode.equalsIgnoreCase("upo")) {
			if (bc != null) {
				switch (bc.toLowerCase()) {
				case "enabled":
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to set to enable");
					Validation_Server_Config_Page.BusinessContinuity_Enabled_RadioButton.click();
					break;
				case "disabled":
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to set to disable");
					Validation_Server_Config_Page.BusinessContinuity_Disabled_RadioButton.click();
					break;
				case "auto":
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to set to automatic");
					Validation_Server_Config_Page.BusinessContinuity_Automatic_RadioButton.click();
					break;
				default:
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to set to disable");
					Validation_Server_Config_Page.BusinessContinuity_Disabled_RadioButton.click();
					break;
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate log level");
		if (loggingLevel != null) {
			Select dropdown = new Select(Validation_Server_Config_Page.Logging_Level_SelectBox);
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).equalsIgnoreCase(loggingLevel.toLowerCase())) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing logging level to : " + loggingLevel.toUpperCase());
					option.click();
					break;
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate log rotation level");
		if (loggingRotLevel != null) {
			Select dropdown = new Select(Validation_Server_Config_Page.Logging_Rotation_Level_SelectBox);
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).equalsIgnoreCase(loggingRotLevel.toLowerCase())) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing log rotation level to : " + loggingRotLevel.toUpperCase());
					option.click();
					break;
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate no of files to keep");
		if (noOfFilesToKeep != null) {
			Select dropdown = new Select(Validation_Server_Config_Page.NumberOf_Files_To_Keep_SelectBox);
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).equalsIgnoreCase(noOfFilesToKeep.toLowerCase())) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing number of files to keep : " + noOfFilesToKeep.toUpperCase());
					option.click();
					break;
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to change sys log radio button");
		if (enableSyslog != null) {
			if (enableSyslog.equalsIgnoreCase("yes"))
				Validation_Server_Config_Page.Enable_SysLog_Yes_RadioButton.click();
			else if (enableSyslog.equalsIgnoreCase("no"))
				Validation_Server_Config_Page.Enable_SysLog_No_RadioButton.click();
		}
		if (radiusSharedSecret != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate radius shared secret password");
			Validation_Server_Config_Page.RadiusSharedSecret_TextBox.clear();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "radius shared secret : " + radiusSharedSecret);
			Validation_Server_Config_Page.RadiusSharedSecret_TextBox.sendKeys(radiusSharedSecret);
		}
		if (radiusConfirmSharedSecret != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Trying to populate confirm radius shared secret password");
			Validation_Server_Config_Page.Confirm_RadiusSharedSecret_TextBox.clear();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "radius confirm shared secret : " + radiusConfirmSharedSecret);
			Validation_Server_Config_Page.Confirm_RadiusSharedSecret_TextBox.sendKeys(radiusConfirmSharedSecret);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "changing password encoding value");
		/*
		 * if (passEncoding != null) { Select dropdown = new
		 * Select(Validation_Server_Config_Page .Password_Encoding_SelectBox);
		 * List<WebElement> options = dropdown.getOptions(); for (WebElement
		 * option : options) {
		 * logger.info("Thread-"+Thread.currentThread().getId()+": "+
		 * "Password encoding option : " + option.getText()); if
		 * ((option.getText()).equalsIgnoreCase(passEncoding .toLowerCase())) {
		 * logger.info("Thread-"+Thread.currentThread().getId()+": "+
		 * "changing password encoding to " + passEncoding.toUpperCase());
		 * option.click(); break; } } }
		 */
		if (vendor != null && (isChallengeSupported)) {
			if (enableAccessChallenge) {
				if (!Boolean.valueOf(Validation_Server_Config_Page.Enable_challenge_Checkbox.getAttribute("checked"))) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enableAccessChallenge is " + enableAccessChallenge + ". Challenge checkbox is not CHECKED, so enabling");
					Validation_Server_Config_Page.Enable_challenge_Checkbox.click();
				}
			} else {
				if (sHelper.isElementPresent(driver, Validation_Server_Config_Page.Enable_challenge_Checkbox)) {
					if (Boolean.valueOf(Validation_Server_Config_Page.Enable_challenge_Checkbox.getAttribute("checked"))) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enableAccessChallenge is " + enableAccessChallenge + ". Challenge checkbox is CHECKED, so disabling");
						Validation_Server_Config_Page.Enable_challenge_Checkbox.click();
					}
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Challenge checkbox is not available");
				}
			}
		} else if (vendor != null && (!isChallengeSupported)) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Ignoring challenge support checkbox as it is not supported by the application template");
		} else {
			if (enableAccessChallenge) {
				if (!Boolean.valueOf(Validation_Server_Config_Page.Enable_challenge_Checkbox.getAttribute("checked"))) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enableAccessChallenge is " + enableAccessChallenge + ". Challenge checkbox is not CHECKED, so enabling");
					Validation_Server_Config_Page.Enable_challenge_Checkbox.click();
				}
			} else {
				if (sHelper.isElementPresent(driver, Validation_Server_Config_Page.Enable_challenge_Checkbox)) {
					if (Boolean.valueOf(Validation_Server_Config_Page.Enable_challenge_Checkbox.getAttribute("checked"))) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "enableAccessChallenge is " + enableAccessChallenge + ". Challenge checkbox is CHECKED, so disabling");
						Validation_Server_Config_Page.Enable_challenge_Checkbox.click();
					}
				} else {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Challenge checkbox is not available");
				}
			}
		}
		setUseUserStoreAndEnableOOBOptionInValidationServer(config, driver);
		setSpecificUserstoreInValidationServer(config, driver);
		if (passEncoding != null) {
			if (oS.contains("window")) {
				Select dropdown = new Select(Validation_Server_Config_Page.Password_Encoding_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Password encoding option : " + option.getText());
					if ((option.getText()).equalsIgnoreCase(passEncoding.toLowerCase())) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "changing password encoding to " + passEncoding.toUpperCase());
						option.click();
						break;
					}
				}
			} else {
				Validation_Server_Config_Page.Password_Encoding_SelectBox.clear();
				Validation_Server_Config_Page.Password_Encoding_SelectBox.sendKeys(passEncoding);
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting VIP Access push option by selecting Yes radio button");
		if (pushTimeOut != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting push timeout");
			Validation_Server_Config_Page.TextBox_Push_TimeOut.clear();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "push time out: " + pushTimeOut);
			Validation_Server_Config_Page.TextBox_Push_TimeOut.sendKeys(pushTimeOut);
		}
		if (pushRemoteServiceName != null) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting push remote service name");
			Validation_Server_Config_Page.TextBox_Push_RemoteAccessServiceURL.clear();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "push remote service name : " + pushRemoteServiceName);
			Validation_Server_Config_Page.TextBox_Push_RemoteAccessServiceURL.sendKeys(pushRemoteServiceName);
		}
		setDelegationInValidationServer(config, driver);
		setRadiusToLdapMappingInValidationServer(config, driver);
		// :TODO Need to remove set specific userstore - Added as a workaroind
		// to incident 3929614
		setSpecificUserstoreInValidationServer(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on submit button");
		//Validation_Server_Config_Page.Submit_Button.click();
		driver.findElement(By.name("submitButton")).sendKeys(Keys.RETURN);
		String actualMessage = Validation_Server_Config_Page.Message_on_page.getText();
		result = (actualMessage.equalsIgnoreCase(validationSuccessMessageOnDelegation));
		Assert.assertTrue(result, "Updating the server " + serverName + " failed. Actual Message: " + actualMessage + ". Expected message: " + validationSuccessMessageOnDelegation);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Update status : " + Validation_Server_Config_Page.Message_on_page.getText());
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "***************************");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking for the updated elements");
		CheckUpdatedValidationServerValues(config, driver);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "****************");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "checking done!");
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void setDelegationInValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		String mode = config.get("mode").toLowerCase();
		boolean delegation = Boolean.valueOf(config.get("delegation_status"));
		String delegationServer = config.get("delegation_host");
		String radiusSharedSecret = config.get("validation_server_shared_secret");
		WebDriverWait wt = new WebDriverWait(driver, 20);
		String valServerHost = config.get("validation_server_host");
		if (delegation) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Delegation should be configured, configuring delegation details");
			Validation_Server_Config_Page.Enable_Delegation_CheckBox.click();
			wt.until(ExpectedConditions.visibilityOf(Validation_Server_Config_Page.Delegation_HostName_TextBox));
			Select localIPDropDown = new Select(Validation_Server_Config_Page.Delegation_LocalIP_SelectBox);
			List<WebElement> optionslocalIPDropDown = localIPDropDown.getOptions();
			for (WebElement option2 : optionslocalIPDropDown) {
				logger.info("Setting local IP as " + valServerHost);
				logger.info("Got IP " + option2.getText() + " from drop down list ");
				if (option2.getText().equalsIgnoreCase(valServerHost)) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing logging level to " + valServerHost);
					option2.click();
					break;
				}
			}
			Validation_Server_Config_Page.Delegation_HostName_TextBox.click();
			Validation_Server_Config_Page.Delegation_HostName_TextBox.sendKeys(delegationServer);
			Validation_Server_Config_Page.Delegatin_Port_TextBox.clear();
			if (mode.equalsIgnoreCase("uo")) {
				Validation_Server_Config_Page.Delegatin_Port_TextBox.sendKeys("1820");
			} else if (mode.contains("ulo")) {
				Validation_Server_Config_Page.Delegatin_Port_TextBox.sendKeys("1822");
			} else if (mode.equalsIgnoreCase("upo")) {
				Validation_Server_Config_Page.Delegatin_Port_TextBox.sendKeys("1824");
			} else if (mode.contains("uol")) {
				Validation_Server_Config_Page.Delegatin_Port_TextBox.sendKeys("1823");
			}
			Validation_Server_Config_Page.Delegation_Radius_Shared_Secret_TextBox.sendKeys(radiusSharedSecret);
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void setRadiusToLdapMappingInValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		WebDriverWait wt = new WebDriverWait(driver, 60);
		String radiusMapAttribute = config.get("radius_map_attribute");
		String vendorId = config.get("vendor_id");
		String vendorAttributeType = config.get("vendor_attribute_type");
		String vendorAttributeId = config.get("vendor_attribute_id");
		String ldapRadiusVendorOther = config.get("ldap_radius_vendor_other");
		String ldapMappingAttribute = config.get("ldap_mapping_attribute");
		boolean includeSecondaryQuery = Boolean.valueOf(config.get("include_secondary_query"));
		String testUserName = config.get("test_user_name");
		String secondaryFilter = config.get("secondary_filter");
		String secondaryBaseDN = config.get("secondary_basedn");
		String searchAttribute = config.get("search_attribute");
		boolean enableRadiusToLDAPMapping = Boolean.valueOf(config.get("enable-radius-ldap-mapping"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		Radius_To_LDAP_Mapping_Frame = PageFactory.initElements(driver, RadiusToLDAPMappingConfigurationPage.class);
		Validation_Server_Home_Page = PageFactory.initElements(driver, ValidationServerHomePage.class);
		String mode = config.get("mode").toLowerCase();
		if (enableRadiusToLDAPMapping) {
			if (mode.equalsIgnoreCase("uo") || mode.equalsIgnoreCase("upo")) {
				if (!Boolean.valueOf(Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.getAttribute("checked"))) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "User recides in user store is NOT CHECKED. So enabling the option.");
					Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.click();
					Thread.sleep(1000);
				}
			}
			boolean isDeleteFlow = false;
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Initiating Radius to LDAP Mapping configuration");
			String value = Validation_Server_Config_Page.Enable_Radius_To_LDAP_Mapping_Checkbox.getAttribute("value");
			if (value.equalsIgnoreCase("true")) {
				List<WebElement> lst = Validation_Server_Config_Page.Link_Delete_Radius_Mapping_Attribute;
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Radius LDAP mappign lists are "+lst);
				int size = lst.size();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Radius LDAP mappign list size is "+size);
				for (int i = 0; i < size; i++) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Deleting existing radius to LDAP mapping");
					lst.get(i).click();
					isDeleteFlow = true;
				}
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Deleted existing LDAP mappings");
				if (sHelper.isElementPresent(driver, Validation_Server_Config_Page.Link_Remove_Vendor_Specific_Attributes)) {
					int removelinkcnt = Validation_Server_Config_Page.Links_Remove_Vendor_Specific_Attributes.size();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Remove Link count is "+removelinkcnt);
					if (removelinkcnt > 0) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Removing existing vendor specific attributes");
						Validation_Server_Config_Page.Link_Remove_Vendor_Specific_Attributes.click();
						Thread.sleep(500);
					}
				}
				if (!isDeleteFlow) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting Enable Radius to LDAP Mapping checkbox1");
					Validation_Server_Config_Page.Enable_Radius_To_LDAP_Mapping_Checkbox.click();
					Thread.sleep(500);
				}
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting Enable Radius to LDAP Mapping checkbox");
			if (!isDeleteFlow) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enable radius to LDAP mapping is not checked, so enabling");
				Validation_Server_Config_Page.Enable_Radius_To_LDAP_Mapping_Checkbox.click();
				Thread.sleep(500);
			}
			if (radiusMapAttribute != null) {
				Select sel = new Select(Validation_Server_Config_Page.SelectBox_Radius_Mapping_Attribute);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting " + radiusMapAttribute + " from radius Mapping Attribute drop down list");
				sel.selectByVisibleText(radiusMapAttribute);
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "check for radius attribute as Vendor. If yes, check for cisco or juniper");
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "radius attribute : " + radiusMapAttribute);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "vendor id: " + vendorId);
			if ((radiusMapAttribute.contains("Vendor") && vendorId != null) && (vendorId.equalsIgnoreCase("Cisco") || vendorId.equalsIgnoreCase("Juniper"))) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "As per the data vendor ID should be cisco or Juniper");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on the link Customize_Vendor_Specific_Attributes");
				Validation_Server_Config_Page.Link_Customize_Vendor_Specific_Attributes.click();
				Thread.sleep(100);
				Select sel1 = new Select(Validation_Server_Config_Page.SelectBox_VendorID);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting " + vendorId + " from VendorID list");
				sel1.selectByValue(vendorId);
				if (vendorAttributeId != null) {
					Validation_Server_Config_Page.TextBox_AttributeID.clear();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting attribute ID as" + vendorAttributeId);
					Validation_Server_Config_Page.TextBox_AttributeID.sendKeys(vendorAttributeId);
				}
				if (vendorAttributeType != null) {
					Select sel2 = new Select(Validation_Server_Config_Page.SelectBox_AttributeType);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting " + vendorAttributeType + " from Attribute Type dropdown list");
					sel2.selectByValue(vendorAttributeType.toLowerCase());
				}
			} else if (radiusMapAttribute.contains("Vendor") && vendorId.equalsIgnoreCase("Other")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "radius map attribute is  vendor but ID is Other");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "As per the data vendor ID should be other");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on the link Customize_Vendor_Specific_Attributes");
				Validation_Server_Config_Page.Link_Customize_Vendor_Specific_Attributes.click();
				Thread.sleep(100);
				Select sel1 = new Select(Validation_Server_Config_Page.SelectBox_VendorID);
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting " + vendorId + " from VendorID list");
				sel1.selectByValue(vendorId);
				if (ldapRadiusVendorOther != null) {
					Validation_Server_Config_Page.TextBox_VendorIDOther.clear();
					Validation_Server_Config_Page.TextBox_VendorIDOther.sendKeys(ldapRadiusVendorOther);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting vendor specific ID to " + ldapRadiusVendorOther);
				}
				if (vendorAttributeId != null) {
					Validation_Server_Config_Page.TextBox_AttributeID.clear();
					Validation_Server_Config_Page.TextBox_AttributeID.sendKeys(vendorAttributeId);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting vendor attribute ID to " + vendorAttributeId);
				}
				if (vendorAttributeType != null) {
					Select sel2 = new Select(Validation_Server_Config_Page.SelectBox_AttributeType);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting " + vendorAttributeType + " from Attribute Type dropdown list");
					sel2.selectByValue(vendorAttributeType.toLowerCase());
				}
			} else {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "radius map attribute is not vendor");
				if (vendorAttributeType != null) {
					Select sel2 = new Select(Validation_Server_Config_Page.SelectBox_AttributeType);
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Selecting " + vendorAttributeType + " from Attribute Type dropdown list");
					sel2.selectByValue(vendorAttributeType.toLowerCase());
				}
			}
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Add new link");
			Validation_Server_Config_Page.Link_AddNew_Radius_Mapping_Attribute.click();
			Thread.sleep(500);
			String childid = driver.getWindowHandle();
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to Radius to LDAP Mapping Attribute Frame");
			driver.switchTo().window(childid);
			wt.until(ExpectedConditions.visibilityOf(Radius_To_LDAP_Mapping_Frame.TextBox_LDAPMappingAttribute));
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switched to Radius to LDAP Mapping Attribute Frame");
			if (config.get("ldap_mapping_user_store") != null) {
				Select dropdown = new Select(Radius_To_LDAP_Mapping_Frame.SelectBox_UserStoreName);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).equalsIgnoreCase(config.get("ldap_mapping_user_store").toLowerCase())) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Changing User store mapping " + config.get("ldap_mapping_user_store").toUpperCase());
						option.click();
						break;
					}
				}
			}
			if (includeSecondaryQuery) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "clicking on include secondary query yes radio button");
				List<WebElement> oRadioButton = Radius_To_LDAP_Mapping_Frame.Get_Radio_elements();
				oRadioButton.get(0).click();
				Thread.sleep(1000);
				// wt.until(ExpectedConditions.visibilityOf(Radius_To_LDAP_Mapping_Frame.Search_Attribute_textbox));
				if (ldapMappingAttribute != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting LDAP Mapping Attribute");
					// Thread.sleep(500);
					// wt.until(ExpectedConditions.visibilityOf(Radius_To_LDAP_Mapping_Frame.TextBox_LDAPMappingAttribute_Group));
					Radius_To_LDAP_Mapping_Frame.TextBox_LDAPMappingAttribute_Group.clear();
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting LDAP attribute Name as " + ldapMappingAttribute);
					Radius_To_LDAP_Mapping_Frame.TextBox_LDAPMappingAttribute_Group.sendKeys(ldapMappingAttribute);
				}
				if (searchAttribute != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting search attribute: " + searchAttribute);
					Radius_To_LDAP_Mapping_Frame.Search_Attribute_textbox.clear();
					Radius_To_LDAP_Mapping_Frame.Search_Attribute_textbox.sendKeys(searchAttribute);
				}
				if (secondaryBaseDN != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting secondaryBaseDN : " + secondaryBaseDN);
					Radius_To_LDAP_Mapping_Frame.Secondary_base_DN_Textbox.clear();
					Radius_To_LDAP_Mapping_Frame.Secondary_base_DN_Textbox.sendKeys(secondaryBaseDN);
				}
				if (secondaryFilter != null) {
					logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting secondaryFilter : " + secondaryFilter);
					Radius_To_LDAP_Mapping_Frame.Secondary_filter_ID_textbox.clear();
					Radius_To_LDAP_Mapping_Frame.Secondary_filter_ID_textbox.sendKeys(secondaryFilter);
				}
			}
			if ((!includeSecondaryQuery) && ldapMappingAttribute != null) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting LDAP Mapping Attribute");
				Thread.sleep(500);
				wt.until(ExpectedConditions.visibilityOf(Radius_To_LDAP_Mapping_Frame.TextBox_LDAPMappingAttribute));
				// Radius_To_LDAP_Mapping_Frame.TextBox_LDAPMappingAttribute
				// .clear();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting LDAP attribute Name as " + ldapMappingAttribute);
				Radius_To_LDAP_Mapping_Frame.TextBox_LDAPMappingAttribute.clear();
				Radius_To_LDAP_Mapping_Frame.TextBox_LDAPMappingAttribute.sendKeys(ldapMappingAttribute);
			}
			if (testUserName != null) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting testUserName : " + testUserName);
				Radius_To_LDAP_Mapping_Frame.Test_UserID_textbox.clear();
				Radius_To_LDAP_Mapping_Frame.Test_UserID_textbox.sendKeys(testUserName);
			}
			Thread.sleep(500);
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on test button");
			Radius_To_LDAP_Mapping_Frame.Button_Test.click();
			wt.until(ExpectedConditions.visibilityOf(Radius_To_LDAP_Mapping_Frame.Message_Element));
			if (Radius_To_LDAP_Mapping_Frame.Message_Element.getText().contains("The RADIUS response")) {
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Recieved the message starting with:The RADIUS response");
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on SAVE button");
				Radius_To_LDAP_Mapping_Frame.Button_Save.click();
				logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Switching to validation server configuration page");
				Thread.sleep(500);
				driver.switchTo().defaultContent();
			} else if (Radius_To_LDAP_Mapping_Frame.Message_Element.getText().contains("User validation query failed")) {
				logger.error("Thread-" + Thread.currentThread().getId() + ": " + "Radius to LDAP mapping configuration test failed");
				Assert.assertTrue(false, "Radius to LDAP mapping configuration test failed. Actual status message is : " + Radius_To_LDAP_Mapping_Frame.Message_Element.getText());
			} else {
				logger.error("Thread-" + Thread.currentThread().getId() + ": " + "Received configuration error");
				Assert.assertTrue(false, "Radius to LDAP mapping configuration test failed. Actual status message is : " + Radius_To_LDAP_Mapping_Frame.Message_Element.getText());
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void setSpecificUserstoreInValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String userStore = config.get("userstore_name");
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		if (Boolean.valueOf(Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.getAttribute("checked"))) {
			if (userStore != null) {
				Select dropdown = new Select(Validation_Server_Config_Page.UserStore_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).equalsIgnoreCase(userStore.toLowerCase())) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting specific userstore as " + userStore);
						option.click();
						break;
					}
				}
			} else {
				Select dropdown = new Select(Validation_Server_Config_Page.UserStore_SelectBox);
				List<WebElement> options = dropdown.getOptions();
				for (WebElement option : options) {
					if ((option.getText()).equalsIgnoreCase("all")) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Setting specific userstore settings as ALL");
						option.click();
						break;
					}
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void setUseUserStoreAndEnableOOBOptionInValidationServer(Map<String, String> config, WebDriver driver) throws Exception {
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		boolean useLDAPUserName = Boolean.valueOf(config.get("use_ldap_username"));
		boolean userUserStoreOOB = Boolean.valueOf(config.get("use_userstore_oob"));
		String mode = config.get("mode");
		boolean supportForChallenge = false;
		Validation_Server_Config_Page = PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		if (Boolean.valueOf(config.get("challenge_supported")) || Boolean.valueOf(config.get("enable_access_challenge"))) {
			supportForChallenge = true;
		}
		if (mode != null) {
			if (mode.equalsIgnoreCase("uo") || mode.equalsIgnoreCase("upo")) {
				if (useLDAPUserName) {
					if (!Boolean.valueOf(Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.getAttribute("checked"))) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "User recides in user store is NOT CHECKED. So enabling the option.");
						Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.click();
						Thread.sleep(1000);
					}
					if (supportForChallenge) {
						if (userUserStoreOOB) {
							if (!Boolean.valueOf(Validation_Server_Config_Page.Use_UserStore_Data_For_OOB_CheckBox.getAttribute("checked"))) {
								logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enable User store data for OOB option is NOT CHECKED. So ENABLING the option.");
								Validation_Server_Config_Page.Use_UserStore_Data_For_OOB_CheckBox.click();
							}
						} else {
							if (Boolean.valueOf(Validation_Server_Config_Page.Use_UserStore_Data_For_OOB_CheckBox.getAttribute("checked"))) {
								logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enable User store data for OOB option is CHECKED. So DISABLING the option.");
								Validation_Server_Config_Page.Use_UserStore_Data_For_OOB_CheckBox.click();
							}
						}
					}
				} else {
					if (Boolean.valueOf(Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.getAttribute("checked"))) {
						logger.info("Thread-" + Thread.currentThread().getId() + ": " + "User recides in user store is CHECKED. So disabling the option.");
						Validation_Server_Config_Page.User_Resides_In_Userstore_CheckBox.click();
						Thread.sleep(1000);
					}
				}
			} else {
				if (supportForChallenge) {
					if (userUserStoreOOB) {
						if (!Boolean.valueOf(Validation_Server_Config_Page.Use_UserStore_Data_For_OOB_CheckBox.getAttribute("checked"))) {
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enable User store data for OOB option is NOT CHECKED. So ENABLING the option.");
							Validation_Server_Config_Page.Use_UserStore_Data_For_OOB_CheckBox.click();
						}
					} else {
						if (Boolean.valueOf(Validation_Server_Config_Page.Use_UserStore_Data_For_OOB_CheckBox.getAttribute("checked"))) {
							logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Enable User store data for OOB option is CHECKED. So DISABLING the option.");
							Validation_Server_Config_Page.Use_UserStore_Data_For_OOB_CheckBox.click();
						}
					}
				}
			}
		}
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " - Exit: " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}
	
	//Kesav
	
	public void HealthCheckSettings(Map<String, String> config, WebDriver driver) throws Exception {
		Import_Settings_Page = PageFactory.initElements(driver, ImportSettingsPage.class);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + " + Enter: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		String sUsername = config.get("login_username");
		String sPassword = config.get("login_password");
		String buildNumber = "9.6.1"; // config.get("build_no");
		boolean isCancel = Boolean.valueOf(config.get("is_cancel"));
		String testDesc = config.get("test_description");
		Update_Settings_Page = PageFactory.initElements(driver, UpdateSettings.class);
		Configuration_Console_Home_Page = PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		Configuration_Console_Login_Page = PageFactory.initElements(driver, ConfigurationConsoleLoginPage.class);
		//int counter = 0;
		WebDriverWait wt = new WebDriverWait(driver, 90);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Test description: " + testDesc);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Setting tab");
		wt.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Settings")));
		Configuration_Console_Home_Page.Settings_Tab.click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Health Check Settings tab");
		driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[8]/a")).click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking on Health Check Settings Yes Radio Button");
		driver.findElement(By.xpath("//*[@id='select']")).click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking Save button on Health Check SettingsPage");
		driver.findElement(By.xpath("//*[@id='show']/div[3]/div/input")).click();
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Clicking Save button on Health Check SettingsPage");
		wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='errors-inpage']/div/div[1]"))));
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Start Helath Check Services");
		driver.findElement(By.xpath("//*[@id='myonoffswitch']/div")).click();
		
	}

	
	
}
