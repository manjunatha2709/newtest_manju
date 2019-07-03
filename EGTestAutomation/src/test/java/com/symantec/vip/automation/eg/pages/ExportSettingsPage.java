package com.symantec.vip.automation.eg.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ExportSettingsPage extends Page {
	
	@FindBy(how = How.CLASS_NAME, using = "errortext")
	public WebElement Error_label;
	
	@FindBy(how = How.LINK_TEXT, using = "Settings")
	public WebElement Tab_Settings;
	
	@FindBy(how = How.LINK_TEXT, using = "Export Settings")
	public WebElement Link_ExportSettings;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Export']")
	public WebElement Export_Button;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Next']")
	public WebElement Next_button;
	@FindBy(how = How.XPATH, using = "//input[@value='Back']")
	public WebElement Back_button;
	@FindBy(how = How.XPATH, using = "//input[@value='Cancel']")
	public WebElement Cancel_button;
	@FindBy(how = How.XPATH, using = "//input[@value='Download']")
	public WebElement Download_button;
	@FindBy(how = How.XPATH, using = "//input[@value='Finish']")
	public WebElement Finish_button;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Finish']")
	public WebElement Finish_buttona;
	
	@FindBy(how = How.NAME, using = "realPassword")
	public WebElement Password_InputField;
	@FindBy(how = How.ID, using = "confirmPass")
	public WebElement ConfirmPassword_InputField;
	
	public ExportSettingsPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public List<WebElement> Get_Webelements(int flag) {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(flag==1)
		    return driver.findElements(By.xpath("//img[@src=\'/vipegconsole/UI/images/export-bullet-icons.png\']"));
		else if(flag==2)
			return driver.findElements(By.xpath("//img[@src=\'/vipegconsole/UI/images/tick-icon.png\']"));
		else
			return driver.findElements(By.name("encrypt"));		
		

	}

}
