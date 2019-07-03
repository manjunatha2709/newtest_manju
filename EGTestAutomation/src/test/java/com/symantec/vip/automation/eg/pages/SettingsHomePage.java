package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class SettingsHomePage extends Page {
	
	@FindBy(how = How.LINK_TEXT, using = "HTTP Proxy Settings")
	@CacheLookup
	public WebElement HTTP_Proxy_Settings_Tab;
	
	@FindBy(how = How.LINK_TEXT, using = "Console Settings")
	@CacheLookup
	public WebElement Console_Settings_Tab;
	
	@FindBy(how = How.LINK_TEXT, using = "System Settings")
	@CacheLookup
	public WebElement System_Settings_Tab;
	
	@FindBy(how = How.LINK_TEXT, using = "Trusted CA Certificate")
	@CacheLookup
	public WebElement Trusted_CA_Certificate_Tab;
	
	@FindBy(how = How.LINK_TEXT, using = "SSL Certificate")
	@CacheLookup
	public WebElement SSL_Certificate_Tab;
	
	@FindBy(how = How.LINK_TEXT, using = "Update Settings")
	@CacheLookup
	public WebElement Product_Update_Settings_Tab;
	
	@FindBy(how = How.LINK_TEXT, using = "VIP Certificate")
	@CacheLookup
	public WebElement VIP_Certificate_Tab;
	
	public SettingsHomePage(WebDriver webDriver) {
		super(webDriver);
	}
	

}