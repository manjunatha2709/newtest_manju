package com.symantec.vip.automation.eg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FooterLinksDetailsPage extends Page {
	@FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div[1]/h1")
	public WebElement Legal_Notice_Header_Data_TextLabel;
	@FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div[1]/div[1]/h1")
	public WebElement Repository_Header_Data_TextLabel;
	@FindBy(how = How.LINK_TEXT, using = "Privacy")
	public WebElement Privacy_Link;

	public FooterLinksDetailsPage(WebDriver webDriver) {
		super(webDriver);
	}
}
