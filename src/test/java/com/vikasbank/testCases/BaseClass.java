package com.vikasbank.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;
import com.vikasbank.pom.EditCustomerPage;
import com.vikasbank.pom.HomePage;
import com.vikasbank.pom.LoginPage;
import com.vikasbank.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseURL =readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password =readconfig.getPassword();
	public String chromepath=readconfig.getChromepath();
	public String customerID=readconfig.getCustId();
	//Most imp to instantiate webdriver driver object which is available to 
	//all child classes to pass them to other classes as well
	public static WebDriver driver = null;
	public TakesScreenshot screenshot;
	public LoginPage lp;
	public HomePage hp;
	public EditCustomerPage ecp;
	public static Logger logger;
	public JavascriptExecutor js;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
	logger = Logger.getLogger("BaseClass");
	PropertyConfigurator.configure("log4j.properties");
	if(br.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver",chromepath);
	driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	logger.info("Chrome browser opened successfully");
	
	}
	//driver.manage().window().maximize();
	driver.navigate().to(baseURL);
	
	}
	
//	@BeforeClass
//	public void setup()
//	{
//	logger = Logger.getLogger("BaseClass");
//	PropertyConfigurator.configure("log4j.properties");
//	System.setProperty("webdriver.chrome.driver",chromepath);
//	driver= new ChromeDriver();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	logger.info("Chrome browser opened successfully");
//	driver.manage().window().maximize();
//	driver.navigate().to(baseURL);
//}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException
	{
		screenshot = ((TakesScreenshot)driver);
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File (".\\Screenshots\\screenshot"+tname+".png");
		Files.copy(src, dest);
		logger.info("Screenshot is taken");
	}
	@AfterClass
	public void teadDown()
	{
		driver.quit();
	}
	
	public String randomstring()
	{
		String generatedString= RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	public static String randomnumber()
	{
		String generatednumber= RandomStringUtils.randomNumeric(5);
		return generatednumber;
	}
}
