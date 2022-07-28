package com.vikasbank.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vikasbank.pom.AddCustomerPage;
import com.vikasbank.pom.HomePage;
import com.vikasbank.pom.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		logger.info("username is provided");
		lp.setpassword(password);
		logger.info("password is provided");
		lp.loginbutton();
		logger.info("login successful");
		HomePage hp = new HomePage(driver);
		hp.NewCustomer();
		
		driver.navigate().refresh();
		
		hp.NewCustomer();              
		logger.info("Adding new customer data!");
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.EnterCustomerName("nil");
		addcust.SelectGender("s");
		addcust.EnterDOB("01022003");
		addcust.EnterAddress("abcd");
		addcust.EnterCity("HYD");
		addcust.EnterState("MH");
		addcust.EnterPIN("234643");
		addcust.EnterTeleNo("988322345");
		String emailid = randomstring()+"@gmail.com";
		addcust.EnterEmail(emailid);
		addcust.setPassword("abcdef");
		addcust.submitbtnAddcustomer();
		
		boolean b = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(b==true)
		{
			String customerID = driver.findElement(By.xpath("//table[@id='customer']//tbody//tr[4]//td[2]")).getText();
			System.out.println("Customer Id generated Successfully"+ customerID);
			logger.info("New Customer ID "+ customerID);
			logger.info("Customer is added successfully");
			js = (JavascriptExecutor)driver;
			WebElement table = driver.findElement(By.xpath("//table[@id='regmsg']"));
			js.executeScript("arguments[0].scrollIntoView(true);",table);
			//js.executeScript("window.scrollBy(0,400);");
			captureScreenshot(driver, "addNewCustomerPage"+customerID);
			logger.info("Screenshot is captured");
			Assert.assertTrue(true);
			logger.info("Test case is passed:"+"addNewCustomer");
		}
		
		else
		{
			captureScreenshot(driver, "addNewCustomerPage");
			logger.info("Test case is failed"+"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	
}
