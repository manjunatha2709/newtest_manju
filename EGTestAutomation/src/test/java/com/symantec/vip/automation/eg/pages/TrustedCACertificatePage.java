package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class TrustedCACertificatePage extends Page {

	@FindBy(how = How.XPATH, using = ".//*[@type='button' and @value='Add Certificate']")
	public WebElement Add_Certificate_Button;
	
	@FindBy(how = How.NAME, using = "certFile")
	public WebElement CA_Certificate_FilePath_Field;

	@FindBy(how = How.NAME, using = "addAlias")
	public WebElement Alias_TextBox;

	@FindBy(how = How.NAME, using = "method:back")
	public WebElement Cancel_Button;

	@FindBy(how = How.NAME, using = "method:doIt")
	public WebElement Submit_Button;
	
	@FindBy(how = How.NAME, using = "method:deployCAStore")
	public WebElement Save_Changes;

	@FindBy(how = How.XPATH, using = "//div[@class='errors']")
	public WebElement Submit_Message;
	

	public TrustedCACertificatePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public void AddCACertificate(String certPath, String alias) {
		CA_Certificate_FilePath_Field.sendKeys(certPath);
		Alias_TextBox.sendKeys(alias);
		Submit_Button.click();
	}

}
