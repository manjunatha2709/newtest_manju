package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HelpPage extends Page{
	@FindBy(how = How.XPATH, using ="//a[@title='Signing In to VIP Enterprise Gateway Configuration Console']")
	public WebElement First_Link;  
	
	//@FindBy(how = How.ID, using = "I_1")
	//public WebElement First_Link;
	
	@FindBy(how = How.ID, using = "I_2")
	public WebElement Second_Link;
	
//	@FindBy(how = How.LINK_TEXT, using = "Viewing Home Page")
//	public WebElement Second_Link;
	
	@FindBy(how = How.LINK_TEXT, using = "Help")
	public WebElement Tab_Help;
	
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
	
	public HelpPage(WebDriver webDriver) {
		super(webDriver);
	}

}
