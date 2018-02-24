package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageActions{
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id=GlobalLocators.email)
	WebElement email;
	
	@FindBy(xpath=GlobalLocators.nextBtn)
	WebElement nextBtn;
	
	@FindBy(xpath=GlobalLocators.password)
	WebElement password;
	
	@FindBy(xpath=GlobalLocators.signinBtn)
	WebElement signinBtn;
	
	@FindBy(xpath="//*[@id='logo']/div/svg")
	WebElement imageLogo;
	
	public void doLogin(){
		email.sendKeys("dharmiksameer");
		nextBtn.click();
		password.sendKeys("test1234");
		signinBtn.click();
	}
	
	
	public boolean isLogoPresent(){
		
		return isElementPresent(By.xpath("//*[@id='headingText']"));
		
	}
	
	
	//driver.findElement(By.xpath(""));
	
	
}
