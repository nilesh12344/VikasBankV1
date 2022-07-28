package com.vikasbank.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vikasbank.pom.HomePage;
import com.vikasbank.pom.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TC_HomePage_002 extends BaseClass {

	@Test
	public void testCurrentURL()
	{
		lp = new LoginPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.loginbutton();
		logger.info("Login successfully");
		String currentURL  =driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "https://demo.guru99.com/v4/manager/Managerhomepage.php");
		logger.info("Homepage opened successfully");
		logger.info("2nd test case is passed");
	}
	
	@Test(priority=4 , dependsOnMethods = "testCurrentURL")
	public void testTitle()
	{
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
		logger.info("Testing homepage elements");
		logger.info("3rd test case is passed");
	}
	
	@Test(priority=3, dependsOnMethods = "testCurrentURL")
	public void test3()
	{
		Boolean b = driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed();
		Assert.assertTrue(b);
		logger.info("Logout button tested successfully");
		logger.info("4th test case is passed");
	}
	
}
