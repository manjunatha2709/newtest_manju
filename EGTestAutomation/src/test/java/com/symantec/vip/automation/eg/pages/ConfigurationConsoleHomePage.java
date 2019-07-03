package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfigurationConsoleHomePage extends Page {
	@FindBy(how = How.LINK_TEXT, using = "Home")
	public WebElement Home_Tab;
	@FindBy(how = How.LINK_TEXT, using = "User Store")
	public WebElement UserStore_Tab;
	@FindBy(how = How.LINK_TEXT, using = "Settings")
	public WebElement Settings_Tab;
	@FindBy(how = How.LINK_TEXT, using = "Identity Providers")
	public WebElement Identity_Providers_Tab;
	@FindBy(how = How.LINK_TEXT, using = "Validation")
	public WebElement Validation_Tab;
	@FindBy(how = How.LINK_TEXT, using = "Logs")
	public WebElement Logs_Tab;
	@FindBy(how = How.LINK_TEXT, using = "Sign Out")
	public WebElement SignOut_Link;
	@FindBy(how = How.XPATH, using = "//div[@id='headerLinks']")
	public WebElement Login_Name_Text;
	@FindBy(how = How.ID, using = "version")
	public WebElement Version_Label;
	@FindBy(how = How.LINK_TEXT, using = "Legal Notice")
	public WebElement LegalNotice_Link;
	@FindBy(how = How.LINK_TEXT, using = "Privacy")
	public WebElement Privacy_Link;
	@FindBy(how = How.LINK_TEXT, using = "Repository")
	public WebElement Repository_Link;

	public ConfigurationConsoleHomePage(WebDriver webDriver) {
		super(webDriver);
	}

	public ValidationServerHomePage NavigateToValidationHomePage() {
		Validation_Tab.click();
		if (driver.getTitle().contains("RADIUS Validation Server")) {
			return PageFactory.initElements(driver, ValidationServerHomePage.class);
		} else {
			throw new NoSuchWindowException("A page with title 'RADIUS Validation Server' not found");
		}
	}
	// a[@href='https://manager.vip.symantec.com']
}
