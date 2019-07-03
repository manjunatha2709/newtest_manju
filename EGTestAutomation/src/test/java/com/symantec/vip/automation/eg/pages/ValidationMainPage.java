package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ValidationMainPage extends Page{

	@FindBy(how = How.LINK_TEXT, using = "RADIUS Validation Server")
	public WebElement Tab_RadiusValidationServer;
	
	@FindBy(how = How.LINK_TEXT, using = "Tunnel Server")
	public WebElement Tab_TunnelServer;

	
	public ValidationMainPage(WebDriver webDriver) {
		super(webDriver);
	}

}
