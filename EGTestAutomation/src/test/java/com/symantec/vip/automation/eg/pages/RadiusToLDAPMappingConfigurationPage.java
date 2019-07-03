package com.symantec.vip.automation.eg.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RadiusToLDAPMappingConfigurationPage extends Page {
	@FindBy(how = How.NAME, using = "userStoreName")
	public WebElement SelectBox_UserStoreName;
	@FindBy(how = How.NAME, using = "userCfgResultAttribute")
	public WebElement TextBox_LDAPMappingAttribute;
	@FindBy(how = How.XPATH, using = ".//*[@id='conditionsetGroupDnId_0']")
	public WebElement TextBox_Test_UserName;
	@FindBy(how = How.NAME, using = "testButton")
	public WebElement Button_Test;
	@FindBy(how = How.XPATH, using = "html/body/div[3]/div[3]/div/button[2]")
	public WebElement Button_Save;
	@FindBy(how = How.XPATH, using = "html/body/div[3]/div[3]/div/button[1]")
	public WebElement Button_Cancel;
	@FindBy(how = How.XPATH, using = ".//*[@id='errorDiv']")
	public WebElement Message_Element;
	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @id='id_enableGroupPolicySetting' and @value='true']")
	public WebElement Include_Secondary_Query_Yes_RadioButton;
	@FindBy(how = How.XPATH, using = "//input[@type='radio' and @name='enableGroupPolicySetting' and @value='false']")
	public WebElement Include_Secondary_Query_No_RadioButton;
	@FindBy(how = How.NAME, using = "groupCfgLdapAttribute")
	public WebElement Search_Attribute_textbox;
	@FindBy(how = How.NAME, using = "groupCfgBaseDn")
	public WebElement Secondary_base_DN_Textbox;
	@FindBy(how = How.NAME, using = "groupCfgFilter")
	public WebElement Secondary_filter_ID_textbox;
	@FindBy(how = How.ID, using = "testUserId")
	public WebElement Test_UserID_textbox;
	@FindBy(how = How.NAME, using = "groupCfgResultAttribute")
	public WebElement TextBox_LDAPMappingAttribute_Group;

	public List<WebElement> Get_Radio_elements() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver.findElements(By.name("enableGroupPolicySetting"));
	}

	public RadiusToLDAPMappingConfigurationPage(WebDriver webDriver) {
		super(webDriver);
	}
}
