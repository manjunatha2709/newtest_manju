package com.symantec.vip.automation.eg.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelfServicePortalIdPConfigurationPage extends Page {
	@FindBy(how = How.XPATH, using = ".//*[@id='myonoffswitch']/div")
	public WebElement Service_Status_Slider_Button;
	@FindBy(how = How.XPATH, using = ".//*[@name='select' and @value='yes' and @type='radio']")
	@CacheLookup
	public WebElement Enable_SSP_IDP_Yes_RadioButton;
	//
	@FindBy(how = How.ID, using = "id.oob")
	public WebElement Enable_Automatic_Distribution_Yes_RadioButton;
	//
	@FindBy(how = How.ID, using = "id.oob1")
	public WebElement Enable_Automatic_Distribution_No_RadioButton;
	//
	@FindBy(how = How.XPATH, using = ".//*[@name='host' and @type='text']")
	public WebElement Host_TextBox;
	@FindBy(how = How.XPATH, using = ".//*[@name='port' and @type='text']")
	public WebElement Port_TextBox;
	@FindBy(how = How.XPATH, using = ".//*[@type='text' and @name='frontendURL']")
	public WebElement LoadBalancer_TextBox;
	@FindBy(how = How.XPATH, using = ".//*[@type='button' and @value='Start Service']")
	public WebElement Start_Service_Button;
	@FindBy(how = How.XPATH, using = ".//*[@type='button' and @value='Apply Changes']")
	public WebElement Apply_Changes_Button;
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement Start_Service_Message;
	// VIP Manager successfully added.
	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Edit']")
	public WebElement Edit_Button;
	@FindBy(how = How.NAME, using = "edit")
	public WebElement Edit_Button1;
	@FindBy(how = How.XPATH, using = ".//*[@type='radio' and @value='yes' and @name='ssl']")
	public WebElement HTTPS_Enable_Yes_RadioButton;
	
	//
	@FindBy(how = How.XPATH, using = ".//*[@id='rdpasswordmgmtId']")
	public WebElement Enable_Password_Management;
	@FindBy(how = How.XPATH, using = ".//*[@id='rdpasswordmgmtId2']")
	public WebElement Disable_Password_Management;

	public List<WebElement> SSlListElement() {
		WebElement ul = driver.findElement(By.id("sslDiv"));
		List<WebElement> lis = ul.findElements(By.tagName("li"));
		return lis;
	}

	public SelfServicePortalIdPConfigurationPage(WebDriver webDriver) {
		super(webDriver);
	}
}
