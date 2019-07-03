package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AddTunnelForwarderPage extends Page {
	
	@FindBy(how = How.NAME, using = "tunnelName")
	@CacheLookup
	public WebElement TextBox_TunnelName;
	
	@FindBy(how = How.NAME, using = "UDPPort")
	@CacheLookup
	public WebElement TextBox_UDPPort;
	
	@FindBy(how = How.NAME, using = "hosts")
	@CacheLookup
	public WebElement TextBox_Host;
	
	@FindBy(how = How.NAME, using = "ports")
	@CacheLookup
	public WebElement TextBox_Port;
	
	@FindBy(how = How.NAME, using = "submitButton")
	@CacheLookup
	public WebElement Button_Submit;
	
	public AddTunnelForwarderPage(WebDriver webDriver) {
		super(webDriver);
	}

}