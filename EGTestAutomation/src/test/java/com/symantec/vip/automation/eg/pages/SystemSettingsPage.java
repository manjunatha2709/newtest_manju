package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SystemSettingsPage extends Page {
	@FindBy(how = How.NAME, using = "instanceId")
	public WebElement Name_TextBox;
	@FindBy(how = How.XPATH, using = "//input[@value='Edit' and @type='submit']")
	public WebElement Edit_Button;
	@FindBy(how = How.XPATH, using = "//input[@value='Cancel' and @type='submit']")
	public WebElement Cancel_Button;
	@FindBy(how = How.XPATH, using = "//input[@value='Save' and @type='submit']")
	public WebElement Save_Button;
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement Save_Message;

	public SystemSettingsPage(WebDriver webDriver) {
		super(webDriver);
	}
}