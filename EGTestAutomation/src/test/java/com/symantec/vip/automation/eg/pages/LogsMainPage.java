package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LogsMainPage extends Page {

	@FindBy(how = How.LINK_TEXT, using = "View Logs")
	public WebElement Tab_ViewLogs;
	
	@FindBy(how = How.LINK_TEXT, using = "Syslog Configuration")
	public WebElement Tab_SyslogConfiguration;

	public LogsMainPage(WebDriver webDriver) {
		super(webDriver);
	}

}