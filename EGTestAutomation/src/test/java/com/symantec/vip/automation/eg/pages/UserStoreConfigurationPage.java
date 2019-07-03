package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserStoreConfigurationPage extends Page {
	@FindBy(how = How.NAME, using = "addbtn")
	@CacheLookup
	public WebElement Add_New_Button;
	@FindBy(how = How.ID, using = "sortable")
	@CacheLookup
	public WebElement UserStore_Sortable_Table;
	@FindBy(how = How.NAME, using = "store.storeName")
	@CacheLookup
	public WebElement Name_TextBox;
	@FindBy(how = How.NAME, using = "store.connName")
	@CacheLookup
	public WebElement Connection_TextBox;
	@FindBy(how = How.NAME, using = "store.directoryHost")
	@CacheLookup
	public WebElement Host_TextBox;
	@FindBy(how = How.NAME, using = "store.directoryPort")
	@CacheLookup
	public WebElement Port_TextBox;
	@FindBy(how = How.NAME, using = "store.directoryTimeout")
	@CacheLookup
	public WebElement Timeout_DropDownBox;
	@FindBy(how = How.NAME, using = "store.directorySslEnabled")
	@CacheLookup
	public WebElement EnableSSL_CheckBox;
	@FindBy(how = How.NAME, using = "store.directoryUserDn")
	@CacheLookup
	public WebElement UserDN_TextBox;
	@FindBy(how = How.NAME, using = "store.directoryPassword")
	@CacheLookup
	public WebElement UserDN_Password_TextBox;
	@FindBy(how = How.NAME, using = "store.directoryBaseDN")
	@CacheLookup
	public WebElement BaseDN_TextBox;
	@FindBy(how = How.NAME, using = "store.directoryFilter")
	@CacheLookup
	public WebElement UserFilter_TextBox;
	@FindBy(how = How.NAME, using = "store.checkBoxChecked")
	@CacheLookup
	public WebElement VIP_UserName_Attribute_CheckBox;
	@FindBy(how = How.NAME, using = "store.cloudAttribute")
	@CacheLookup
	public WebElement VIP_UserName_attribute_TextBox;
	@FindBy(how = How.NAME, using = "store.directoryTestUser")
	@CacheLookup
	public WebElement TestUser_TextBox;
	@FindBy(how = How.XPATH, using = ".//*[@name='testButton' and @value='Test']")
	@CacheLookup
	public WebElement Test_Button;
	@FindBy(how = How.NAME, using = "sbtbtn")
	@CacheLookup
	public WebElement Submit_Button;
	// @FindBy(how = How.XPATH, using = "//*[@id=\"errorDiv\"]")
	@FindBy(how = How.ID, using = "errorDiv")
	@CacheLookup
	public WebElement Test_Button_Message;
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement Save_Message;
	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Edit']")
	@CacheLookup
	public WebElement Edit_Button;

	// @FindBy(how = How.XPATH, using =
	// ".//*[@type='submit' and @value='Delete']")
	// @CacheLookup
	// public WebElement Delete_Button;
	// @FindBy(how = How.XPATH, using =
	// ".//*[@type='submit' and @value='Disable']")
	// @CacheLookup
	// public WebElement Disable_Button;
	public UserStoreConfigurationPage(WebDriver webDriver) {
		super(webDriver);
	}
}
