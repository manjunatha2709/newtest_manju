package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ViewLogsArchivedLogsPage extends Page {
	
	@FindBy(how = How.LINK_TEXT, using = "Download")
	@CacheLookup
	public WebElement Link_Download;
	
	public ViewLogsArchivedLogsPage(WebDriver webDriver) {
		super(webDriver);
	}

}

