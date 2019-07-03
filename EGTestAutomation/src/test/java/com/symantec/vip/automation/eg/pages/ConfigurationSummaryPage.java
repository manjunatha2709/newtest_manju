package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConfigurationSummaryPage extends Page {
	@FindBy(how = How.XPATH, using = ".//*[@id='version']")
	public WebElement ProductDetails_ReadOnlyField;
	@FindBy(how = How.XPATH, using = ".//*[@id='vipCert']")
	public WebElement Section_VIPCertificate;
	@FindBy(how = How.XPATH, using = ".//*[@id='userStore']")
	public WebElement Section_UserStore;
	@FindBy(how = How.XPATH, using = ".//*[@id='ldapSync']")
	public WebElement Section_LDAPSync;
	@FindBy(how = How.XPATH, using = ".//*[@id='tunnelServer']")
	public WebElement Section_TunnelServer;
	@FindBy(how = How.XPATH, using = ".//*[@id='sspIdp']")
	public WebElement Section_SelfServiceIDP;
	@FindBy(how = How.XPATH, using = ".//*[@id='vipIdp']")
	public WebElement Section_VIPIDP;
	@FindBy(how = How.XPATH, using = ".//*[@id='version']")
	public WebElement Link_ManageVIPCert;
	@FindBy(how = How.XPATH, using = ".//*[@id='footerLinks']/ul/li[4]")
	public WebElement CopyRight_ReadOnlyField;
	@FindBy(how = How.LINK_TEXT, using = "User Store")
	public WebElement UserStore_Tab;
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div[4]/div/div/div[1]/span[2]")
	public WebElement VIPCert_Subject_DN_ReadOnlyField;
	@FindBy(how = How.XPATH, using = "//input[@value='Add VIP Certificate']")
	public WebElement Button_AddVIPCertificate;

	public ConfigurationSummaryPage(WebDriver webDriver) {
		super(webDriver);
	}
}
