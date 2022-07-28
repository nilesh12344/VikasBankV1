package com.vikasbank.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver ldriver;
	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath="//a[text()='New Customer']")
	private WebElement newcust;
	
	@FindBy (xpath="//a[text()='Edit Customer']")
	private WebElement editcust;
	
	@FindBy (xpath="//a[text()='Delete Customer']")
	private WebElement delcust;
	
	@FindBy (xpath="//a[text()='New Account']")
	private WebElement newacc;
	
	@FindBy (xpath="//a[text()='Edit Account']")
	private WebElement editacc;
	
	@FindBy (xpath="//a[text()='Mini Statement']")
	private WebElement ministat;
	
	
	
	@FindBy (xpath="//a[text()='Customised Statement']")
	private WebElement customstat;
	
	@FindBy (xpath="//a[text()='Log out']")
	private WebElement logout;
	
	public void NewCustomer()
	{
		newcust.click();
	}
	public void EditCustomer()
	{
		editcust.click();
	}
	public void DeleteCustomer()
	{
		delcust.click();
	}
	public void NewAccount()
	{
		newacc.click();
	}
	public void EditAccount()
	{
		editacc.click();
	}
	public void MiniStatement()
	{
		ministat.click();
	}
	public void CustomisedStatement()
	{
		customstat.click();
	}
	public void LogOut()
	{
		logout.click();
	}
}

