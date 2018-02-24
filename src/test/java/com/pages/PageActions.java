package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class PageActions {
	
	public WebDriver driver;
	
	public PageActions(WebDriver driver){
		this.driver=driver;
		
	}
	
	
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[2][2];
		
		return data;
	}
	
public boolean isElementPresent(By by){
		
		try{
			
			driver.findElement(by);
			return true;
		}
		catch(Throwable e){
			return false;
		}
	}
	

}
