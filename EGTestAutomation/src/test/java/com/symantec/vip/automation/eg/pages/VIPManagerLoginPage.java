package com.symantec.vip.automation.eg.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class VIPManagerLoginPage extends Page{

	@FindBy(how = How.NAME, using = "username")
	@CacheLookup
	public WebElement UserName_TextBox;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	public WebElement Password_TextBox;

	@FindBy(how = How.XPATH, using = ".//*[@id='loginButton']")
	@CacheLookup
	public WebElement SignIn_Button;

	@FindBy(how = How.XPATH, using = ".//*[@type='text' and @name='enteredOTP']")
	public WebElement SecurityCode_TextBox;
	
	@FindBy(how = How.ID, using = "continueButton")
	public WebElement Continue_Button;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='messagingComponent']/ul/li[2]")
	public WebElement Error_Message;

	public VIPManagerLoginPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void Login_Action(String sUsername, String sPassword) {		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		UserName_TextBox.sendKeys(sUsername);
		Password_TextBox.sendKeys(sPassword);
		SignIn_Button.click();
		
	}

}

