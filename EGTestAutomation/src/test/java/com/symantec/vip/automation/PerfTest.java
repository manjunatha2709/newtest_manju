package com.symantec.vip.automation;import org.testng.annotations.Test;import com.symantec.vip.automation.eg.radius.RadiusTestHelper;import com.symantec.vip.automation.utils.TestDriverHelper;import com.symantec.vip.soapclient.WSThread;public class PerfTest {	SeleniumTestHelper sTestHelper = new SeleniumTestHelper();	TestDriverHelper tdh = new TestDriverHelper();	RadiusTestHelper radiusTestHelper = new RadiusTestHelper();	@Test	public void GenerateBuldTempOTP() throws Exception {		final int totalUserCount = 120000;		final int transactionPerSecond = 20;		final String expirationDate = "02-12-2017 10:20:56";		String userPrefix = "perfuser";		try {			for (int j = 0; j < totalUserCount; j++) {				WSThread wThread = new WSThread();				wThread.generateTempOTP(userPrefix + j, "123456", "qa", expirationDate);				Thread t = new Thread(wThread);				t.setName("WS" + Thread.currentThread().getName());				t.start();				if (j % transactionPerSecond == 0) {					System.out.println("Sleeping for 1 second");					Thread.sleep(1000);				}			}		} catch (Exception e) {			e.printStackTrace();			System.exit(-1);		}	}}