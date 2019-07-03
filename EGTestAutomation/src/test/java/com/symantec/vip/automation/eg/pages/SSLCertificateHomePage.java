package com.symantec.vip.automation.eg.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class SSLCertificateHomePage extends Page {
	
	@FindBy(how = How.ID, using = "certForm_keystores_addAlias_label_ssl")
	public WebElement Button_AddSSLCerificate;
	
	@FindBy(how = How.XPATH, using = "//table[@id='list_valid']/descendant::tr")
	public List<WebElement> CertificatesList_Table;
	
	@FindBy(how = How.XPATH, using = "//table[@id='list_valid']")
	public WebElement Certificate_Table;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement MessageElement;
	
	@FindBy(how = How.XPATH, using = "//input[@class='ui-pg-input' and @type='text']")
	public WebElement PageNo_TextBox;
	
	@FindBy(how = How.XPATH, using = "//div[@id='list_valid_toppager']/descendant::table[2]/descendant::td[6]")
	public WebElement Pagination_Table;
	
	public SSLCertificateHomePage(WebDriver webDriver) {
		super(webDriver);
	}
}

