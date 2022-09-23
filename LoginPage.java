package com.demo.AutomationTDD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;
	
	By username = By.id("user-name");
	By pasasword = By.id("password");
	By loginBtn = By.id("login-button");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void setUserName(String user)
	{
		driver.findElement(username).sendKeys(user);
	}
	public void setPassword(String pass)
	{
		driver.findElement(pasasword).sendKeys(pass);
	}
	public void clickLogin()
	{
		driver.findElement(loginBtn).click();
	}
}