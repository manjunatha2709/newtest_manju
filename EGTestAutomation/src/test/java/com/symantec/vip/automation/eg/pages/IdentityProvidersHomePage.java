package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class IdentityProvidersHomePage extends Page{
	
	@FindBy(how = How.LINK_TEXT, using = "Self Service Portal IdP")
	public WebElement Self_Service_Portal_IdP_Tab;
	
	@FindBy(how = How.LINK_TEXT, using = "VIP Manager IdP")
	public WebElement VIP_Manager_IdP_Tab;
	
	public IdentityProvidersHomePage(WebDriver webDriver) {
		super(webDriver);
	}
	

}

