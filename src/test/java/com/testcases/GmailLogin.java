package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;

public class GmailLogin extends TestBase{
	
	@Test
	public void validateLogin(){
		
		type("email","dharmiksameer");
		click("nextBtn");
		Assert.fail();
		//Assert.assertTrue(isElementPresent("Compose"));
		
	}

	/*@Test
	public void method1(){
		Assert.fail();
	}*/
}
