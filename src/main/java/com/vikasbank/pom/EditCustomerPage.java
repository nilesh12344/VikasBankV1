package com.vikasbank.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	WebDriver ldriver;
	public EditCustomerPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//input[@name='cusid']") private WebElement editcust;
	@FindBy (xpath = "//input[@name='AccSubmit']") private WebElement submit;
	@FindBy (xpath = "//input[@name='res']") private WebElement reset;

	@FindBy (xpath = "//input[@name='state']") private WebElement updateState;
	@FindBy (xpath = "//input[@type='submit']") private WebElement Update;
	
	
	public void EnterCustomerIdToEdit(String s)
	{
		editcust.sendKeys(s);
	}
	
	public void ClickOnSubmit()
	{
		submit.click();
	}
	public void ClickOnReset()
	{
		reset.click();
	}
	
	public void changeState(String s)
	{
		updateState.clear();
		updateState.sendKeys(s);
	}
	
	public void submitUpdatedData()
	{
		Update.click();
	}
	
}