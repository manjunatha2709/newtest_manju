package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LDAPDirectorySyncronizationConfigurationPage extends Page {
	@FindBy(how = How.XPATH, using = ".//*[@name='select' and @value='yes' and @type='radio']")
	@CacheLookup
	public WebElement Enable_LDAPSync_Yes_RadioButton;
	@FindBy(how = How.XPATH, using = ".//*[@value='Edit' and @type='submit']")
	@CacheLookup
	public WebElement LDAPSync_Edit_Button;
	@FindBy(how = How.XPATH, using = ".//*[@type='checkbox' and @value='us_all']")
	@CacheLookup
	public WebElement Enable_UserSync_Root_CheckBox;
	@FindBy(how = How.XPATH, using = ".//*[@type='checkbox' and @value='admin']")
	@CacheLookup
	public WebElement Enable_AdminSync_Root_CheckBox;
	@FindBy(how = How.XPATH, using = ".//*[@type='Submit' and @value='Save Changes']")
	@CacheLookup
	public WebElement Save_Changes_Button;
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement Save_Changes_Message;
	@FindBy(how = How.XPATH, using = ".//*[@id='myonoffswitch']/div")
	public WebElement Service_StartStop_Slider;

	public LDAPDirectorySyncronizationConfigurationPage(WebDriver webDriver) {
		super(webDriver);
	}
}
