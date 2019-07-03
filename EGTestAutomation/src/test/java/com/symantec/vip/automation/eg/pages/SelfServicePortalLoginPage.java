package com.symantec.vip.automation.eg.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelfServicePortalLoginPage extends Page {
	@FindBy(how = How.NAME, using = "username")
	public WebElement UserName_TextBox;
	@FindBy(how = How.NAME, using = "password")
	public WebElement Password_TextBox;
	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Sign In']")
	public WebElement SignIn_Button;
	@FindBy(how = How.XPATH, using = ".//*[@type='text' and @name='securityCode']")
	public WebElement SecurityCode_TextBox;
	@FindBy(how = How.ID, using = "continueConfirmIdentityButton")
	public WebElement Continue_Button;
	@FindBy(how = How.XPATH, using = ".//*[@id='error-text']/span/strong")
	public WebElement Error_Message;
	@FindBy(how = How.LINK_TEXT, using = "Sign Out")
	public WebElement SignOut_Link;
	@FindBy(how = How.ID, using = "firstOTP")
	public WebElement VIPMGR_SecurityCode_TextBox;
	//
	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Yes']")
	public WebElement Password_Reset_Yes_Button;
	//
	@FindBy(how = How.XPATH, using = ".//*[@type='button' and @value='No']")
	public WebElement Password_Reset_No_Button;
	//
	@FindBy(how = How.ID, using = "vipSubmitOTP")
	public WebElement Confirm_Your_Identiy_Continue_Button;
	//
	@FindBy(how = How.ID, using = "vipCancelsubmitOTP")
	public WebElement Confirm_Your_Identity_Cancel_Button;
	//
	@FindBy(how = How.ID, using = "otpInput")
	public WebElement Confirm_Your_Identity_SecurityCode_TextBox;
	//
	@FindBy(how = How.ID, using = "newPwd")
	public WebElement Password_Change_NewPassword_TextBox;
	//
	@FindBy(how = How.ID, using = "confirmNewPwd")
	public WebElement Password_Change_ConfirmPassword_TextBox;
	//
	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Continue']")
	public WebElement Password_Change_Continue_Button;
	//
	@FindBy(how = How.XPATH, using = ".//*[@id='error-text']/span/strong/span/strong")
	public WebElement Password_Change_Status_Message;

	public SelfServicePortalLoginPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void Login_Action(String sUsername, String sPassword) {
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		UserName_TextBox.sendKeys(sUsername);
		Password_TextBox.sendKeys(sPassword);
		SignIn_Button.click();
	}
}