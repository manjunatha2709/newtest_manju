package com.symantec.vip.automation.eg.pages;

import java.util.List;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ValidationServerHomePage extends Page {
	@FindBy(how = How.XPATH, using = ".//*[@type='button' and @value='Add Server']")
	@CacheLookup
	public WebElement Add_Server_Button;
	@FindBy(how = How.XPATH, using = "//table[@id='list_valid']/descendant::tr")
	public List<WebElement> ValidationServersList_Table;
	// TODO
	@FindBy(how = How.XPATH, using = "//div[@id='list_valid_toppager']/descendant::table[2]/descendant::td[6]")
	public WebElement Pagination_Table;
	@FindBy(how = How.XPATH, using = ".//*[@id='next_t_list_valid_toppager']")
	public WebElement Pagination_Table_End_Page;
	@FindBy(how = How.XPATH, using = "//input[@class='ui-pg-input' and @type='text']")
	public WebElement PageNo_TextBox;
	@FindBy(how = How.XPATH, using = ".//*[@id='errors-inpage']/div/div")
	public WebElement Action_Message;
	@FindBy(how = How.LINK_TEXT, using = "view")
	public WebElement View_link;

	public ValidationServerHomePage(WebDriver webDriver) {
		super(webDriver);
	}

	public ValidationServerConfigurationPage NavigateToValidationServerConfigurationPage() {
		Add_Server_Button.click();
		String title = "Add RADIUS Validation Server";
		if (driver.getTitle().contains(title)) {
			return PageFactory.initElements(driver, ValidationServerConfigurationPage.class);
		} else {
			throw new NoSuchWindowException("A page with title 'Add RADIUS Validation Server' not found");
		}
	}
}
