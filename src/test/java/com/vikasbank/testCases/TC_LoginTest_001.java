package com.vikasbank.testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.io.Files;
import com.vikasbank.pom.HomePage;
import com.vikasbank.pom.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	//Basic test case developed
	
	@Test
	public void LoginTest() throws IOException
	{
		lp = new LoginPage(driver);
		lp.setusername(username);
		logger.info("Username entered successfully");
		lp.setpassword(password);
		logger.info("Password entered successfully");
		lp.loginbutton();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		//Assert.assertEquals(url,"https://demo.guru99.com/v4/manager/Managerhomepage.php");
		if(url.equals("https://demo.guru99.com/v4/manager/Managerhomepage.php"))
		{
			Assert.assertTrue(true);
			logger.info("Login Successfully");
			logger.info("1st test case passed");
		}
		else
		{
			captureScreenshot(driver,"LoginTest");
			Assert.assertFalse(false);
			logger.info("Login Failed");
		}
		logger.info("Homepage opened successfully");
	}
	
	
}

