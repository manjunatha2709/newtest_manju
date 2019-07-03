package com.symantec.vip.automation.eg.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddTunnelReceiverPage extends Page {
	@FindBy(how = How.NAME, using = "tunnelName")
	@CacheLookup
	public WebElement TextBox_TunnelName;
	@FindBy(how = How.NAME, using = "tcpPort")
	@CacheLookup
	public WebElement TextBox_TCPPort;
	@FindBy(how = How.XPATH, using = "//input[@value='Submit' and @type='submit']")
	public WebElement Button_Submit;
	@FindBy(how = How.XPATH, using = "//input[@value='yes' and @type='radio' and @name='ssl']")
	public WebElement Enable_SSL_RadioButton;
	@FindBy(how = How.ID, using = "add_str_save_logLevel")
	public WebElement Logging_Level_SelectBox;
	@FindBy(how = How.NAME, using = "logRotationInterval")
	public WebElement Logging_Rotation_Level_SelectBox;
	@FindBy(how = How.NAME, using = "numFileToKeep")
	public WebElement NumberOf_Files_To_Keep_SelectBox;

	public List<WebElement> SSlListElement() {
		WebElement ul = driver.findElement(By.id("sslDiv"));
		List<WebElement> lis = ul.findElements(By.tagName("li"));
		return lis;
	}

	public AddTunnelReceiverPage(WebDriver webDriver) {
		super(webDriver);
	}
}
