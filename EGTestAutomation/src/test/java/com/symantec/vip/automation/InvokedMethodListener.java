package com.symantec.vip.automation;

// ===== RetryAnalyzer =====
import org.apache.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class InvokedMethodListener implements IInvokedMethodListener {
	public static Logger logger = Logger.getLogger("VIP_EG_AUTOMATION");

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		RetryAnalyzer retryAnalyzer = (RetryAnalyzer) testResult.getMethod().getRetryAnalyzer();
		if (retryAnalyzer == null || retryAnalyzer.isFailed()) {
			return;
		}
		if (testResult.getStatus() == ITestResult.FAILURE) {
			logger.info("Thread-" + Thread.currentThread().getId() + ": " + "Retrying failed testcase");
			//TODO:TestBase.reinitWebDriver();
			testResult.setStatus(ITestResult.SUCCESS);
		}
	}
}