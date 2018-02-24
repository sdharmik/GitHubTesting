package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginValidation {
	
	public WebDriver driver;
	public LoginPage login;
	
	@BeforeClass
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://www.gmail.com");
	}
	
	@Test
	public void verifyLogo(){
		login = new LoginPage(driver);
		Assert.assertTrue(login.isLogoPresent());
		
	}

}
