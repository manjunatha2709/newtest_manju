package com.symantec.vip.automation;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SelfServiceIDPTests extends TestBase{
	
	@Parameters({"browser"})
	@Test
	public void SSPLogin() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("SSP Login Test");
	}
}
