package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.TestBase;

public class TestUtil extends TestBase{
	
	public static String fileName;

	
public static void captureScreenshot(){
		
		Date d = new Date();
		String s = d.toString();
		fileName = s.replaceAll(":", "_").replaceAll(" ", "_");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\Screenshot\\" + fileName + ".jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
