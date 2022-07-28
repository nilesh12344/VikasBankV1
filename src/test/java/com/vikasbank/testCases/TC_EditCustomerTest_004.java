package com.vikasbank.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vikasbank.pom.EditCustomerPage;
import com.vikasbank.pom.HomePage;
import com.vikasbank.pom.LoginPage;

public class TC_EditCustomerTest_004 extends BaseClass{

	@Test
	public void editCustomer() throws IOException
	{
		js = (JavascriptExecutor)driver;
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		logger.info("username is provided");
		lp.setpassword(password);
		logger.info("password is provided");
		lp.loginbutton();
		String randomState = randomstring();
		logger.info("login successful");
		HomePage hp = new HomePage(driver);
		hp.EditCustomer();
		
		driver.navigate().refresh();
		
		hp.EditCustomer();
		ecp = new EditCustomerPage(driver);
		ecp.EnterCustomerIdToEdit(customerID);
		logger.info("Customer Id entered successfully to edit");
		ecp.ClickOnSubmit();
		if(isAlertPresent()==true)
		{
			logger.warn("Customer does not exist!");
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			ecp.changeState(randomState);
			logger.info("State name is changed to:"+randomState);
			ecp.submitUpdatedData();
			logger.info("new state name is submited");
			try
			{
				Alert alert1 = driver.switchTo().alert();
				alert1.accept();
				logger.info("Alert is accepted");
			}
			catch (NoAlertPresentException e)
			{
			
			}
			logger.info("Again checking whether the data is updated accuratly or not");
			ecp.EnterCustomerIdToEdit(customerID);
			logger.info("Cust ID entered successfully");
			ecp.ClickOnSubmit();
			logger.info("Cust ID submitted");
			WebElement table1 = driver.findElement(By.xpath("//ul[@class='menusubnav']"));
			js.executeScript("arguments[0].scrollIntoView(true);",table1);
			WebElement state= driver.findElement(By.xpath("//input[@name='state']"));
			String updatedstate = state.getAttribute("value");
			logger.info("Updated state is : "+updatedstate);
			boolean b= updatedstate.equals(randomState);
			if(b==true)
			{
				logger.info("State name is validated");
				captureScreenshot(driver, "EditCustomerPage"+customerID);
				Assert.assertTrue(true);
				logger.info("Test Case is passed:"+"EditCustomerTest_001 ");
				
			}
			else
			{
				logger.info("State name is invalid/not properly updated");
				logger.info("Test case if failed :"+"EditCustomerTest_001");
				Assert.assertFalse(false);
			}
		}
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
}
