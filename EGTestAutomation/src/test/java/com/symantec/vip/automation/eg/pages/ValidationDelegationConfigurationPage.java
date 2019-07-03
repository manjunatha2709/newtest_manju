package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ValidationDelegationConfigurationPage extends Page {

	@FindBy(how = How.NAME, using = "hostNames")
	@CacheLookup
	public WebElement HostName_TextBox;
	
	@FindBy(how = How.NAME, using = "ports")
	@CacheLookup
	public WebElement Port_TextBox;
	
	@FindBy(how = How.NAME, using = "secrets")
	@CacheLookup
	public WebElement Radius_Shared_Secret_TextBox;
	
	@FindBy(how = How.NAME, using = "submitButton")
	@CacheLookup
	public WebElement Submit_Button;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='radio' and @value='AUTO']")
	@CacheLookup
	public WebElement BusinessContinuity_Automatic_RadioButton;
	

		
	public ValidationDelegationConfigurationPage(WebDriver webDriver) {
		super(webDriver);
	}

}