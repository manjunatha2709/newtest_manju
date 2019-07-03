

package com.symantec.vip.automation.eg.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class VipmgrIDPPortalLoginPage extends Page {

	@FindBy(how = How.NAME, using = "username")
	public WebElement UserName_TextBox;

	@FindBy(how = How.NAME, using = "password")
	public WebElement Password_TextBox;

	@FindBy(how = How.ID, using = "loginButton")
	public WebElement SignIn_Button;


	
	@FindBy(how = How.ID, using = "continueConfirmIdentityButton")
	public WebElement Continue_Button;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='error-text']/span/strong")
	public WebElement Error_Message;
	
	@FindBy(how = How.LINK_TEXT, using = "Sign Out")
	public WebElement SignOut_Link;

	@FindBy(how = How.ID, using = "firstOTP")
	public WebElement SecurityCode_TextBox;

	public VipmgrIDPPortalLoginPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void Login_Action(String sUsername, String sPassword) {		
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		UserName_TextBox.sendKeys(sUsername);
		Password_TextBox.sendKeys(sPassword);
		SignIn_Button.click();
		
	}

}