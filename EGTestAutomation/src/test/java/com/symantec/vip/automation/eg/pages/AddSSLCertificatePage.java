package com.symantec.vip.automation.eg.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddSSLCertificatePage extends Page{
	
	@FindBy(how = How.XPATH, using = ".//*[@type='radio' and @value='upload']")
	public WebElement RadioButton_ImportSSLCerificate;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='radio' and @value='manual']")
	public WebElement RadioButton_CreateSSLCerificate;
	
		
	@FindBy(how = How.NAME, using = "sslCertFile")
	public WebElement BrowseButton_SSLCertFileName;
	
	@FindBy(how = How.NAME, using = "sslCertPassword")
	public WebElement TextBox_Password;
	
	@FindBy(how = How.NAME, using = "key.alias")
	public WebElement AliasName_TextBox;
	
	@FindBy(how = How.NAME, using = "bckbtn")
	public WebElement Button_cancel;
	
	@FindBy(how = How.XPATH, using = ".//*[@type='submit' and @value='Submit']")
	public WebElement Button_Submit;
	
	
	public AddSSLCertificatePage(WebDriver webDriver) {
		super(webDriver);
	}
}

