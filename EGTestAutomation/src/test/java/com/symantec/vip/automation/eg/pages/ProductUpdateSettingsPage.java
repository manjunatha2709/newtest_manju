package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ProductUpdateSettingsPage extends Page{

	@FindBy(how = How.XPATH, using = "//input[@value='Automatic' and @type='radio']")
	@CacheLookup
	public WebElement CheckForUpdates_Automatic_RadioButton;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Manual' and @type='radio']")
	@CacheLookup
	public WebElement CheckForUpdates_Manual_RadioButton;

	@FindBy(how = How.XPATH, using = "//input[@value='Save' and @type='Submit']")
	@CacheLookup
	public WebElement Save_Button;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Edit' and @type='Submit']")
	@CacheLookup
	public WebElement Edit_Button;

	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/table/tbody/tr/td[2]")
	@CacheLookup
	public WebElement Save_Message;

	public ProductUpdateSettingsPage(WebDriver webDriver) {
		super(webDriver);
	}

}