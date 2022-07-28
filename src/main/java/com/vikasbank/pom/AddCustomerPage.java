package com.vikasbank.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@onkeyup='validatecustomername();']")
	private WebElement custname;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement male;

	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement female;

	@FindBy(xpath = "//input[@type='date']")
	private WebElement DOB;

	@FindBy(xpath = "//textarea[@name='addr']")
	private WebElement address;
	 @FindBy (xpath = "//input[@name='city']") private WebElement city;
	 @FindBy (xpath = "//input[@name='state']") private WebElement state;
	 @FindBy (xpath = "//input[@name='pinno']") private WebElement PIN;
	 @FindBy (xpath = "//input[@name='telephoneno']") private WebElement teleno;
	 @FindBy (xpath = "//input[@name='emailid']") private WebElement EmailID;
	 @FindBy (xpath = "//input[@name='password']") private WebElement password;
	 @FindBy (xpath = "//input[@type='submit']") private WebElement submitbtn;
	 @FindBy (xpath = "//input[@type='reset']") private WebElement resetbtn;
	 
	
	public void EnterCustomerName(String s) {
		custname.sendKeys(s);
	}

	public void SelectGender(String s) {
		if (s.equals("m")) {
			male.click();
		} else if (s.equals("f")) {
			female.click();
		}
	}
		public void EnterDOB(String dob)
		{
			DOB.sendKeys(dob);
		}
		public void EnterAddress(String s)
		{
			address.sendKeys(s);
		}
		public void EnterCity(String s)
		{
			city.sendKeys(s);
		}
		public void EnterState(String s)
		{
			state.sendKeys(s);
		}
		public void EnterPIN(String s)
		{
			PIN.sendKeys(s);
		}
		public void EnterTeleNo(String s)
		{
			teleno.sendKeys(s);
		}
		public void EnterEmail(String s)
		{
			EmailID.sendKeys(s);
		}
		
		public void setPassword(String s)
		{
			password.sendKeys(s);
		}
		public void submitbtnAddcustomer()
		{
			submitbtn.click();
		}
		public void resetbtnAddCustomer()
		{
			resetbtn.click();
		}

}
