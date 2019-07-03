package com.symantec.vip.automation.eg.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SyslogConfigurationPage extends Page {
	@FindBy(how = How.ID, using = "hostId_1")
	public WebElement TextBox_Host1;
	@FindBy(how = How.ID, using = "portId_1")
	public WebElement TextBox_Port1;
	@FindBy(how = How.NAME, using = "facility")
	public WebElement TextBox_Facility;
	@FindBy(how = How.XPATH, using = "//input[@value='Save' and @type='submit']")
	public WebElement Button_Save;
	@FindBy(how = How.XPATH, using = "//input[@value='Edit' and @type='submit']")
	public WebElement Button_Edit;
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement MessageElement;

	public List<WebElement> SSlListElement() {
		WebElement ul = driver.findElement(By.id("element_area"));
		List<WebElement> lis = ul.findElements(By.tagName("li"));
		return lis;
	}

	public SyslogConfigurationPage(WebDriver webDriver) {
		super(webDriver);
	}
}