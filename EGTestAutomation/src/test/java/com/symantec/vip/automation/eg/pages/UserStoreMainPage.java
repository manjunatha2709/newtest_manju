package com.symantec.vip.automation.eg.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class UserStoreMainPage extends Page {

	@FindBy(how = How.XPATH, using = ".//*[@id='cssmenu']/ul/li[2]/a")
	public WebElement LDAPSync_Tab;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='cssmenu']/ul/li[4]/a")
	public WebElement Console_Authentication_Tab;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='cssmenu']/ul/li[3]/a")
	public WebElement VIP_Administrator_Configuration_Tab;
	
	@FindBy(how = How.XPATH, using = "//div[@class='divRowTableBody']/descendant::li")
	public List<WebElement> UserstoreList;
	
	public UserStoreMainPage(WebDriver webDriver) {
		super(webDriver);
	}

}
