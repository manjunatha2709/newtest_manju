package com.symantec.vip.automation.eg.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class TunnelServerHomePage extends Page {
	
	@FindBy(how = How.XPATH, using = ".//*[@type='button' and @value='Add Server']")
	public WebElement Button_AddServer;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='radio' and @value='FORWARDER']")
	public WebElement RadioButton_TunnelForwarder;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='radio' and @value='RECEIVER']")
	public WebElement RadioButton_TunnelReceiver;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Continue']")
	public WebElement Button_Continue;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement MessageElement;
	
	@FindBy(how = How.XPATH, using = "//table[@id='list_valid']/descendant::tr")
	public List<WebElement> TunnelServersList_Table;
	
	@FindBy(how = How.XPATH, using = "//div[@id='list_valid_toppager']/descendant::table[2]/descendant::td[6]")
	public WebElement Pagination_Table;
	
	@FindBy(how = How.XPATH, using = "//input[@class='ui-pg-input' and @type='text']")
	public WebElement PageNo_TextBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement Action_Message;
//	
//	@FindBy(how = How.XPATH, using = "//div[@id='list_valid_toppager']/descendant::table[2]/descendant::td[6]")
//	@CacheLookup
//	public WebElement Pagination_Table;
//	
//	@FindBy(how = How.XPATH, using = "//input[@class='ui-pg-input' and @type='text']")
//	@CacheLookup
//	public WebElement PageNo_TextBox;
//	
//	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
//	public WebElement Action_Message;
	
	public TunnelServerHomePage(WebDriver webDriver) {
		super(webDriver);
	}
}

