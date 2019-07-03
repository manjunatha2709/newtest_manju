package com.symantec.vip.automation.eg.pages;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class VIPUserSettingsTabInUserStoreEditPage extends Page{
	
	@FindBy(how = How.XPATH, using = ".//*[@id='staticMappingFirst']/div/div[4]/a")
	public WebElement Add_New_UserAttributes_Link;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='mappingPage']/div[3]/div/div[3]/a")
	public WebElement Add_New_UserGroupMapping_Link;

	@FindBy(how = How.XPATH, using = ".//*[@class='newField plusBtn' and @type='button']")
	public WebElement Plus_Button;
	
	@FindBy(how = How.XPATH, using = ".//*[@name='sbtbtn' and @value='Submit']")
	public WebElement Submit_Button;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='staticMappingFirst']/div/div[4]/input")
	public WebElement Edit_Button;
	
	@FindBy(how = How.NAME, using = "store.firstName")
	public WebElement FirstName_Attribute_TextBox;
	
	@FindBy(how = How.NAME, using = "store.lastName")
	public WebElement LastName_Attribute_TextBox;
	
	@FindBy(how = How.NAME, using = "store.emailAddress")
	public WebElement Email_Attribute_TextBox;
	
	@FindBy(how = How.NAME, using = "store.employeeId")
	public WebElement EmployeeID_TextBox;
	
	@FindBy(how = How.NAME, using = "store.department")
	public WebElement Department_TextBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='dropdownArea']")
	public WebElement UserAttributes_SelectBox;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='m1']")
	@CacheLookup
	public WebElement UserGroupMapping_Delete_Link;
	
	public VIPUserSettingsTabInUserStoreEditPage(WebDriver webDriver) {
		super(webDriver);
	}
	//User Store settings updated successfully. On the configuration Summary page, verify the status of the services. Then, navigate to the relevant pages and restart the required services to make the changes take effect.
	public void SpecifyAllFiveUserAttribute_Action(String firstNameAttribute, String lastNameAttribute, String emailAttribute, String emplIDAttribute, String departmentAttribute ) {		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		selectValueFromDropDownList("First Name");
		FirstName_Attribute_TextBox.sendKeys(firstNameAttribute);
		
		Plus_Button.click();
		selectValueFromDropDownList("Last Name");
		LastName_Attribute_TextBox.sendKeys(lastNameAttribute);
		
		Plus_Button.click();
		selectValueFromDropDownList("Email Address");
		Email_Attribute_TextBox.sendKeys(emailAttribute);
		
		Plus_Button.click();
		selectValueFromDropDownList("Employee ID");
		EmployeeID_TextBox.sendKeys(emplIDAttribute);
		
		Plus_Button.click();
		selectValueFromDropDownList("Department");
		Department_TextBox.sendKeys(departmentAttribute);
		
	}
	
	private void selectValueFromDropDownList(String optionToSelect) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select dropdown = new Select(UserAttributes_SelectBox);
		List<WebElement> options = dropdown.getOptions();
		for (WebElement option : options) {
			if ((option.getText()).equalsIgnoreCase(optionToSelect)) {
				option.click();
				break;
			}
		}
	}

}
