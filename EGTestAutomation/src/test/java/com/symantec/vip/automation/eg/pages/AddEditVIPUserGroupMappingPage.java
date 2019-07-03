package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddEditVIPUserGroupMappingPage extends Page {

	
	@FindBy(how = How.NAME, using = "userGroupMapping.conditionsetName")
	public WebElement UserGroupMapping_Name_TextBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='conditionsetMembershipNameId']")
	public WebElement UserGroupMapping_Membership_AttributeName_TextBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='conditionsetGroupDnId_0']")
	public WebElement UserGroupMapping_Membership_GroupDN_TextBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='conditionsetUserGroupId']")
	public WebElement UserGroupMapping_VIPUserGroup_SelectBox;
	
	@FindBy(how = How.XPATH, using = "html/body/div[3]/div[3]/div/button[2]")
	public WebElement UserGroupMapping_Save_Button;
		
	
	
//	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Delete']")
//	@CacheLookup
//	public WebElement Delete_Button;
	
//	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Disable']")
//	@CacheLookup
//	public WebElement Disable_Button;
	
	public AddEditVIPUserGroupMappingPage(WebDriver webDriver) {
		super(webDriver);
	}

}
