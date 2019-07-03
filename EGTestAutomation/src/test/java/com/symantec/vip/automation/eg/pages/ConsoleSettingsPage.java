package com.symantec.vip.automation.eg.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConsoleSettingsPage extends Page {
	@FindBy(how = How.NAME, using = "application.portRef.portNumber")
	@CacheLookup
	public WebElement Port_TextBox;
	@FindBy(how = How.NAME, using = "application.clientLogLevel")
	@CacheLookup
	public WebElement Logging_Level_SelectBox;
	@FindBy(how = How.NAME, using = "application.fileLogRotation")
	@CacheLookup
	public WebElement Log_Rotation_Interval_SelectBox;
	@FindBy(how = How.XPATH, using = "//input[@value='true' and @type='radio' and @name='application.sysLog']")
	@CacheLookup
	public WebElement Enable_Syslog_Yes_RadioButton;
	@FindBy(how = How.XPATH, using = "//input[@value='false' and @type='radio' and @name='application.sysLog']")
	@CacheLookup
	public WebElement Enable_Syslog_No_RadioButton;
	@FindBy(how = How.XPATH, using = "//input[@value='http' and @type='radio' and @name='appBean.portRef.protocol']")
	@CacheLookup
	public WebElement Protocol_Http_RadioButton;
	@FindBy(how = How.XPATH, using = "//input[@value='https' and @type='radio' and @name='appBean.portRef.protocol']")
	public WebElement Protocol_Https_RadioButton;
	@FindBy(how = How.ID, using = "console_depbtn")
	public WebElement Submit_Button;
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/table/tbody/tr/td[2]")
	public WebElement Submit_Message;

	public List<WebElement> SSlListElement() {
		WebElement ul = driver.findElement(By.id("sslDiv"));
		List<WebElement> lis = ul.findElements(By.tagName("li"));
		return lis;
	}

	public ConsoleSettingsPage(WebDriver webDriver) {
		super(webDriver);
	}
}
