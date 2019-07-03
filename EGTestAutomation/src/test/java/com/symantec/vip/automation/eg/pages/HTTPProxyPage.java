package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HTTPProxyPage extends Page{
	
	@FindBy(how = How.NAME, using = "appBean.proxyHost1")
	@CacheLookup
	public WebElement Host_TextBox;
	
	@FindBy(how = How.NAME, using = "appBean.proxyPort1")
	@CacheLookup
	public WebElement Port_TextBox;
	
	@FindBy(how = How.NAME, using = "appBean.proxyUser1")
	@CacheLookup
	public WebElement UserName_TextBox;
	
	@FindBy(how = How.NAME, using = "appBean.proxyPassword1")
	@CacheLookup
	public WebElement Password_TextBox;
	
	@FindBy(how = How.NAME, using = "method:doIt")
	@CacheLookup
	public WebElement Submit_Button;
	
	@FindBy(how = How.XPATH, using = "//div[@class='errors']")
	@CacheLookup
	public WebElement Submit_Message;
	
	@FindBy(how = How.ID, using = "httpProxySettings_delbtn")
	@CacheLookup
	public WebElement Delete_Button;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Edit' and @type='button']")
	@CacheLookup
	public WebElement Edit_Button;
	
	public HTTPProxyPage(WebDriver webDriver) {
		super(webDriver);
	}

}
