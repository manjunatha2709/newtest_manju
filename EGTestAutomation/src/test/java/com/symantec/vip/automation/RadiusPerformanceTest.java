package com.symantec.vip.automation;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.symantec.vip.automation.eg.radius.PerfTest;
import com.symantec.vip.automation.utils.TestDriverHelper;

public class RadiusPerformanceTest extends TestBase {
	SeleniumTestHelper sTestHelper = new SeleniumTestHelper();
	PerfTest radPerfTest = new PerfTest();
	TestDriverHelper tdh = new TestDriverHelper();

	@BeforeSuite
	public void generateTempOTP() throws Exception {
		tdh.setTempOTPForPerformanceTesting();
	}

	@BeforeMethod
	public void ConfigConsoleBasicLogin() throws Exception {
		sTestHelper.ConfigConsoleBasicLogin(config, driver);
	}

	@AfterTest
	public void generateHTMLReport() {
		try {
			radPerfTest.createHTML();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 0)
	public void AddVIPCertificate_FirstTime() throws Exception {
		HashMap<String, String> configuration = new HashMap<String, String>();
		configuration.putAll(config);
		configuration.put("selected_env", "qa");
		sTestHelper.AddVIPCertificate_FirstTime(configuration, driver);
		sTestHelper.changeAuthenticationURLtoQA(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "CeateUserStoreBasic", groups = { "performanceTests" }, dependsOnMethods = { "AddVIPCertificate_FirstTime" }, priority = 0)
	public void Create_Userstore_basic_scenarios(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.CreateUserStore(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "ValidationServerDataForPerfTest", groups = { "performanceTests" }, dependsOnMethods = { "Create_Userstore_basic_scenarios" })
	public void Create_Validation_Servers_for_performance_test(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		sTestHelper.createValidationServer(configuration, driver);
		sTestHelper.StartValidationServer(configuration, driver);
	}

	@Test(dataProviderClass = DataProvider.class, dataProvider = "ValidationPerformanceTestData", groups = { "performanceTests" }, dependsOnMethods = { "Create_Validation_Servers_for_performance_test" })
	public void Validation_Server_Performance_Tests(HashMap<String, String> configuration) throws Exception {
		configuration.putAll(config);
		logger.info("Thread-" + Thread.currentThread().getId() + ": " + "**********Configuration for this test is**********" + configuration);
		radPerfTest.InvokePerfTest(configuration);
	}
}
