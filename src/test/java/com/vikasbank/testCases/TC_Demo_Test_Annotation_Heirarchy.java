//package com.vikasbank.testCases;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//import com.vikasbank.pom.HomePage;
//import com.vikasbank.pom.LoginPage;
//
//public class TC_Demo_Test_Annotation_Heirarchy extends BaseClass {
//	
//	
//
//	
//	@Test(priority=4)
//	public void testTitle()
//	{
//		
//		System.out.println("THIS IS TEST 1");
//		String title = driver.getTitle();
//		Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
//		
//	}
//	
//	@Test(priority=2)
//	public void testCurrentURL()
//	{
//		System.out.println("THIS IS TEST 2");
//		String currentURL  =driver.getCurrentUrl();
//		Assert.assertEquals(currentURL, "https://demo.guru99.com/v4/manager/Managerhomepage.php");
//	}
//	
//	@Test(priority=3)
//	public void test3()
//	{
//		System.out.println("THIS IS TEST 3");
//		Boolean b = driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed();
//		Assert.assertTrue(b);
//	}
//	
//}
