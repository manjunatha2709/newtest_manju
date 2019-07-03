package com.symantec.vip.automation.eg.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ConfigurationConsoleLoginPage extends Page {
	@FindBy(how = How.NAME, using = "userName")
	public WebElement UserName_TextBox;
	@FindBy(how = How.NAME, using = "password")
	public WebElement Password_TextBox;
	@FindBy(how = How.XPATH, using = "//input[@id='signin']")
	public WebElement Submit_Button;
	@FindBy(how = How.NAME, using = "btnYes")
	public WebElement Confirm_SignIn_Yes_Button;
	@FindBy(how = How.ID, using = "loginAuthType")
	public WebElement Login_Auth_Type_SelectBox;
	@FindBy(how = How.XPATH, using = ".//*[@ID='error-text']")
	public WebElement Error_Message;
	@FindBy(how = How.LINK_TEXT, using = "Help")
	public WebElement Help_link;

	public ConfigurationConsoleLoginPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void Login_Action(String sUsername, String sPassword) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		UserName_TextBox.sendKeys(sUsername);
		Password_TextBox.sendKeys(sPassword);
		if (isElementPresent(driver, Login_Auth_Type_SelectBox)) {
			Select dropdown = new Select(Login_Auth_Type_SelectBox);
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).equalsIgnoreCase("Local Administrator")) {
					option.click();
					break;
				}
			}
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Submit_Button.click();
	}

	public ConfigurationConsoleHomePage LoginAndNavigateToConfigConsoleHomePage(String sUsername, String sPassword) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		UserName_TextBox.sendKeys(sUsername);
		Password_TextBox.sendKeys(sPassword);
		if (isElementPresent(driver, Login_Auth_Type_SelectBox)) {
			Select dropdown = new Select(Login_Auth_Type_SelectBox);
			List<WebElement> options = dropdown.getOptions();
			for (WebElement option : options) {
				if ((option.getText()).equalsIgnoreCase("Local Administrator")) {
					option.click();
					break;
				}
			}
		}
		Submit_Button.click();
		if (isElementPresent(driver, Confirm_SignIn_Yes_Button)) {
			Confirm_SignIn_Yes_Button.click();
		}
		if (driver.getTitle().contains("Home")) {
			return PageFactory.initElements(driver, ConfigurationConsoleHomePage.class);
		} else {
			throw new NoSuchWindowException("Config console login failed, Get title does not contain 'Home'");
		}
	}

	private boolean isElementPresent(WebDriver driver, WebElement we) {
		boolean result = false;
		try {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			if (we.isDisplayed()) {
				result = true;
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			} else {
				result = false;
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			return false;
		}
		return result;
	}
}
