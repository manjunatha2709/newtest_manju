package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ViewLogsHomePage extends Page{

	@FindBy(how = How.LINK_TEXT, using = "Current Logs")
	public WebElement Tab_CurrentLogs;
	
	@FindBy(how = How.LINK_TEXT, using = "Archived Logs")
	public WebElement Tab_ArchivedLogs;
	
	public ViewLogsHomePage(WebDriver webDriver) {
		super(webDriver);
	}

}

