package com.symantec.vip.automation.eg.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeleteUserStorePage extends Page {
	@FindBy(how = How.LINK_TEXT, using = "Delete")
	public List<WebElement> Delete_Button_List;
	@FindBy(how = How.LINK_TEXT, using = "Delete")
	public WebElement Delete_Button;
	@FindBy(how = How.NAME, using = "addbtn")
	@CacheLookup
	public WebElement Add_New_Button;
	@FindBy(how = How.XPATH, using = ".//*[@name='testButton' and @value='Test']")
	@CacheLookup
	public WebElement Test_Button;
	@FindBy(how = How.NAME, using = "sbtbtn")
	public WebElement Submit_Button;
	@FindBy(how = How.NAME, using = "bckbtn")
	public WebElement Back_Button;
	// @FindBy(how = How.XPATH, using = "//*[@id=\"errorDiv\"]")
	@FindBy(how = How.ID, using = "errorDiv")
	@CacheLookup
	public WebElement Test_Button_Message;
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement Save_Message;
	@FindBy(how = How.XPATH, using = "//a[@value='Edit']")
	@CacheLookup
	public WebElement Edit_Button_old;
	@FindBy(how = How.LINK_TEXT, using = "Edit")
	public WebElement Edit_Button;

	public List<WebElement> SSlListElement() {
		WebElement ul = driver.findElement(By.id("sortable"));
		List<WebElement> lis = ul.findElements(By.tagName("li"));
		return lis;
	}

	public DeleteUserStorePage(WebDriver webDriver) {
		super(webDriver);
	}
}
