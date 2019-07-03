package com.symantec.vip.automation;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import com.symantec.vip.automation.eg.testbed.ProductInstallation;
import com.symantec.vip.automation.restapi.RestClient;
import com.symantec.vip.automation.utils.AutomationProperties;
import com.symantec.vip.automation.utils.AutomationPropertiesHelper;
import com.symantec.vip.automation.utils.DataReader;
import com.symantec.vip.automation.utils.Helper;
import com.symantec.vip.automation.utils.SeleniumHelper;
import com.symantec.vip.automation.utils.TestDriverHelper;

public class TestBase {
	DataReader csvReader = new DataReader();
	protected static String gridHubUrl;
	protected static String baseUrl;
	protected Capabilities capabilities;
	protected String comhostName;
	Properties properties = AutomationProperties.getInstance().GetAutomationProperties();
	protected WebDriver driver;
	Helper helper = new Helper();
	protected Map<String, String> config;
	AutomationPropertiesHelper aph = new AutomationPropertiesHelper();
	SeleniumHelper sHelper = new SeleniumHelper();
	public static Logger logger = LoggerFactory.getLogger(TestBase.class);
	public static String buildNumber;
	public String browser;
	TestDriverHelper testDriverHelper = new TestDriverHelper();
	String env;

	@BeforeSuite
	public void initTestSuite() throws IOException {
		if ("".equals(gridHubUrl)) {
			gridHubUrl = null;
		}
		WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
	}

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext context) {
		for (ITestNGMethod method : context.getAllTestMethods()) {
			method.setRetryAnalyzer(new RetryAnalyzer());
		}
		config = new ConcurrentHashMap<String, String>();
		config = aph.GetCommonPropertiesAndLastStringAsKey("common.prop.");
	}

	@Parameters({ "os", "type" })
	@BeforeClass
	public void Product_Installation(String operatingSystem, String testType) throws Exception {
		String buildNumber;
		boolean isBuildInstalled = false;
		RestClient rClient = new RestClient();
		if (this.config == null) {
			config = new ConcurrentHashMap<String, String>();
		}
		config.putAll(aph.GetCommonPropertiesAndLastStringAsKey("common.prop."));
		config.put("update_to_version", "9.5.0.0130");
		// buildNumber = "9.8.0.0094";
		buildNumber = helper.getBuildNumberFromRemote();
		buildNumber = helper.getProperty("\\\\10.223.62.124\\build\\BuildList.txt", "LatestBuild");
		config.put("build_no", buildNumber);
	    String hostName = helper.getHostName(operatingSystem, testType);
		config.put("server_context", operatingSystem.toLowerCase());
		config.put("eg_server_host", hostName);
		config.put("validation_server_host", hostName);
		//rClient.PerformRemoteAction("UpdateEGVersion", config);
		config.putAll(testDriverHelper.getVIPServicesEnvironment(config));
		ProductInstallation prodInstall = new ProductInstallation();
		isBuildInstalled = prodInstall.InstallBuild(config);
		Assert.assertTrue(isBuildInstalled);
		if (!isBuildInstalled) {
			throw new RuntimeException("Installation failed");
		}
	}

	public String getBrowser() {
		return browser;
	}

	public void quitDriver() {
		logger.info("Dismissing the current driver for " + browser.toUpperCase());
		WebDriverFactory.dismissDriver(driver);
	}

	@Parameters({ "browser" })
	@BeforeMethod
	public void Create_Web_Driver(String browser) {
		int retryMax = 5;
		int retryCount = 0;
		boolean retry = false;
		do {
			try {
				this.browser = browser;
				capabilities = SeleniumHelper.getCapabilites(browser);
				driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
			} catch (UnreachableBrowserException e) {
				logger.info("Caught unreachableBrowserException, retrying(count" + retryCount + ")");
				retryCount++;
				if (retryCount <= retryMax) {
					retry = true;
				}
			}
		} while (retry);
	}
	
	@Parameters({ "browser" })
	@BeforeClass
	public void init_Web_Driver_for_Live_Update(String browser) {
		int retryMax = 5;
		int retryCount = 0;
		boolean retry = false;
		do {
			try {
				this.browser = browser;
				capabilities = SeleniumHelper.getCapabilites(browser);
				driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
			} catch (UnreachableBrowserException e) {
				logger.info("Caught unreachableBrowserException, retrying(count" + retryCount + ")");
				retryCount++;
				if (retryCount <= retryMax) {
					retry = true;
				}
			}
		} while (retry);
	}

	public void reinitWebDriver() {
		int retryMax = 10;
		int retryCount = 0;
		boolean retry;
		do {
			retry = false;
			try {
				logger.info("reinitiating the browser due to unreachable exception");
				quitDriver();
				capabilities = SeleniumHelper.getCapabilites(browser);
				driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
				logger.info("got the driver");
			} catch (UnreachableBrowserException e) {
				logger.info("Caught unreachableBrowserException, retrying(count" + retryCount + ")");
				retry = true;
			}
			retryCount++;
		} while ((retry) && (retryCount < retryMax));
	}

	@AfterSuite(alwaysRun = true)
	public void Cleanup_WebDrivers() {
		WebDriverFactory.dismissAll();
	}
}
