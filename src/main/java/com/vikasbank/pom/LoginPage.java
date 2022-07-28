package com.vikasbank.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy (xpath="//input[@name='uid']")
	private WebElement username;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath="//input[@name='btnLogin']")
	private WebElement loginButton;
	
	@FindBy (xpath="//input[@name='btnReset']")
	private WebElement Reset;
	
	@FindBy (xpath="//a[text()='Log out']")
	private WebElement logout;
	
	public void setusername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setpassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void loginbutton()
	{
		loginButton.click();
	}
	public void resetbutton()
	{
		Reset.click();
	}
	public void LogOut()
	{
		logout.click();
	}
	
}
