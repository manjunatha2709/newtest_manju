package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ViewLogsCurrentLogsPage extends Page {
	
	@FindBy(how = How.LINK_TEXT, using = "Download")
	@CacheLookup
	public WebElement Link_Download;
	
	@FindBy(how = How.LINK_TEXT, using = "jettyServer.log")
	@CacheLookup
	public WebElement Link_JettyServerLog;
	
	@FindBy(how = How.LINK_TEXT, using = "startup.log")
	@CacheLookup
	public WebElement Link_StartupLog;
	
	@FindBy(how = How.LINK_TEXT, using = "vipegconsole.log")
	@CacheLookup
	public WebElement Link_ConsoleLog;
	
	public ViewLogsCurrentLogsPage(WebDriver webDriver) {
		super(webDriver);
	}

}