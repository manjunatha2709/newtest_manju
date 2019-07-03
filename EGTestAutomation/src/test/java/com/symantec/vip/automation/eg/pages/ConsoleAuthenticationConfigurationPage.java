package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ConsoleAuthenticationConfigurationPage extends Page {

	@FindBy(how = How.XPATH, using = ".//*[@name='select' and @value='yes' and @type='radio']")
	@CacheLookup
	public WebElement Enable_Console_Authentication_Yes_RadioButton;
	
	@FindBy(how = How.NAME, using = "userStoreIndex")
	@CacheLookup
	public WebElement UserStore_Name_Selection_Box;

	@FindBy(how = How.XPATH, using = ".//*[@name='directoryBaseDn' and @type='text']")
	@CacheLookup
	public WebElement BaseDN_TextBox;
	
	@FindBy(how = How.NAME, using = "userFilter")
	@CacheLookup
	public WebElement UserFilter_TextBox;
	
	@FindBy(how = How.NAME, using = "groupFilter")
	@CacheLookup
	public WebElement GroupFilter_TextBox;
	
	@FindBy(how = How.NAME, using = "testUserId")
	@CacheLookup
	public WebElement TestUser_TextBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='button' and @value='Test']")
	@CacheLookup
	public WebElement Test_Button;
	
	@FindBy(how = How.ID, using = "errorDiv")
	public WebElement Test_Message;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Save']")
	@CacheLookup
	public WebElement Save_Button;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement Save_Message;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Edit']")
	@CacheLookup
	public WebElement Edit_Button;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Delete']")
	@CacheLookup
	public WebElement Delete_Button;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Disable']")
	@CacheLookup
	public WebElement Disable_Button;
	
	public ConsoleAuthenticationConfigurationPage(WebDriver webDriver) {
		super(webDriver);
	}

}
