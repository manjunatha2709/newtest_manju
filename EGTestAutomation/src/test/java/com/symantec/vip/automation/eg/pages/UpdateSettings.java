package com.symantec.vip.automation.eg.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UpdateSettings extends Page {
	
	@FindBy(how = How.CLASS_NAME, using = "errortext")
	public WebElement Error_label;
	
	
	
	@FindBy(how = How.LINK_TEXT, using = "Check for updates")
	public WebElement Check_Update_Link;
	
	@FindBy(how = How.LINK_TEXT, using = "Update Settings") 
	public WebElement Update_Settings_Link;
	
	@FindBy(how = How.LINK_TEXT, using = "refresh") 
	public WebElement Refresh_Link;
	
	@FindBy(how = How.NAME, using = "depbtn")
	public WebElement Edit_Button;	

	@FindBy(how = How.ID, using = "download")
	public WebElement Download_button;
	
	
	@FindBy(how = How.ID, using = "cancel")
	public WebElement Cancel_button;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Proceed')]")
	public WebElement Proceed_Button;
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='ui-id-1']/div/input[@id='chk_agreement']")
	public WebElement Agreement_CheckBox;
	
	@FindBy(how = How.ID, using = "version")
	public WebElement Version_Label;
	
	
	@FindBy(how = How.ID, using = "msgdiv1")
	public WebElement Status_Message_TextLabel;
	
	public UpdateSettings(WebDriver webDriver) {
		super(webDriver);
	}
		
	public List<WebElement> Get_Webelements() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		    return driver.findElements(By.name("choices"));
	
	}
}

