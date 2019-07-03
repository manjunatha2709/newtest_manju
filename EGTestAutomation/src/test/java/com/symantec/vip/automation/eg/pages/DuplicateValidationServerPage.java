package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DuplicateValidationServerPage extends Page{
		
	@FindBy(how = How.ID, using = "serverNameId")
	public WebElement ServerName_TextBox;
	
	@FindBy(how = How.ID, using = "portId")
	public WebElement port_TextBox;
	
	@FindBy(how = How.ID, using = "radiusSecretId")
	public WebElement Radius_Shared_Password_TextBox;
	
	@FindBy(how = How.ID, using = "radiusConfirmSecretId")
	public WebElement Confirm_Radius_Shared_Password_TextBox;
	
	@FindBy(how = How.XPATH, using = "html/body/div[3]/div[3]/div/button[1]")
	public WebElement Duplicate_Cancel_Button;
	
	@FindBy(how = How.XPATH, using = "html/body/div[3]/div[3]/div/button[2]")
	public WebElement Duplicate_Save_Button;
	
	public DuplicateValidationServerPage(WebDriver webDriver) {
		super(webDriver);
	}

}
