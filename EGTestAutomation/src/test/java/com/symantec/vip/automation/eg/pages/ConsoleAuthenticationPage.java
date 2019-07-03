package com.symantec.vip.automation.eg.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ConsoleAuthenticationPage extends Page{

	@FindBy(how = How.XPATH, using = ".//*[@name='select' and @value='yes' and @type='radio']")
	@CacheLookup
	public WebElement Enable_VIPAdministrator_Yes_RadioButton;
	
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
	
	@FindBy(how = How.XPATH, using = ".//*[@id='ui-id-2']")
	@CacheLookup
	public WebElement Synchronization_Tab;
	
	@FindBy(how = How.NAME, using = "firstNameAttribute")
	@CacheLookup
	public WebElement VIPAdminAttributes_FirstNameAttribute_TextBox;
	
	@FindBy(how = How.NAME, using = "lastNameAttribute")
	@CacheLookup
	public WebElement VIPAdminAttributes_LastNameAttribute_TextBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='button' and @value='Apply Changes']")
	@CacheLookup
	public WebElement VIPAdminAttributes_ApplyChanges_Button;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement VIPAdminAttributes_ApplyChanges_Message;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='ui-tabs-2']/div[2]/div/div[3]/div[1]/a")
	@CacheLookup
	public WebElement AddNewGroupMapping_Link;
	
	@FindBy(how = How.NAME, using = "userGroupMapping.conditionsetName")
	@CacheLookup
	public WebElement AdminGroupMapping_Name_TextBox;
	
	@FindBy(how = How.NAME, using = "userGroupMapping.conditionsetFullDn")
	@CacheLookup
	public WebElement AdminGroupMapping_ContainerDN_TextBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='conditionsetMembershipNameId']")
	@CacheLookup
	public WebElement AdminGroupMapping_Membership_AttributeName_TextBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='conditionsetGroupDnId_0']")
	@CacheLookup
	public WebElement AdminGroupMapping_Membership_GroupDN_TextBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='conditionsetUserGroupId']")
	public WebElement AdminGroupMapping_VIPAdministratorsGroup_SelectBox;
	
	@FindBy(how = How.XPATH, using = "html/body/div[3]/div[3]/div/button[2]")
	@CacheLookup
	public WebElement AdminGroupMapping_Save_Button;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement AdminGroupMapping_Save_Message;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='m1']")
	@CacheLookup
	public WebElement AdminGroupMapping_Delete_Link;
	
//	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Delete']")
//	@CacheLookup
//	public WebElement Delete_Button;
	
//	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Disable']")
//	@CacheLookup
//	public WebElement Disable_Button;
	
	public ConsoleAuthenticationPage(WebDriver webDriver) {
		super(webDriver);
	}

}
