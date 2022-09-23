package com.demo.AutomationTDD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;

public class SwagLabsTest 
{
	WebDriver driver;
	LoginPage login;
	ExtentReports reports;
	ExtentTest test;
	@Before
	public void setUp()
	{
		reports = new ExtentReports(System.getProperty("user-dir")+"ExtentReportResults.html");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kunal Shah\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();  // opening the browser
		driver.get("https://www.saucedemo.com/"); // typing and redirecting to given url
		driver.manage().window().maximize(); // maximize the window
	}
	@Test
	public void testCaseLogin() throws InterruptedException
	{
		test = reports.startTest("SwagLabsTest Login");
		login = new LoginPage(driver);
		login.setUserName("standard_user");
		login.setPassword("secret_sauce");
		login.clickLogin();
		String data = driver.findElement(By.className("title")).getText();
		if(data.equals("PRODUCTS"))
		{
			test.log(LogStatus.PASS, "Navigated to Home Page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Case Failed. Login Failed");
		}
		//Assert.assertEquals("PRODUCTS",data);
	}
	@After
	public void deallocateSetUp()
	{
		reports.endTest(test);
		reports.flush();
		driver.close();
	}
}
