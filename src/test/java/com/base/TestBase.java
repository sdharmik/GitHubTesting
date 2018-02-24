package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

import com.utilities.ExcelReader;



public class TestBase {

	/*
	 * WebDriver Congig, OR properties Log4j ExcelReading Cookeies DB
	 * connectivity, Click, Type,
	 * 
	 * 
	 */

	public static WebDriver driver;
	
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\data\\ExcelReadTest.xlsx");
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static FileInputStream fis = null;
	

	@BeforeSuite
	public void setup() {

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			OR = new Properties();
			try {
				OR.load(fis);
				log.debug("OR property file loaded successfully..!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Config = new Properties();
			try {
				Config.load(fis);
				log.debug("Config property file loaded successfully..!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (Config.getProperty("browser").equals("ff")) {

				driver = new FirefoxDriver();
				log.debug("Browser launched successfully");

			} else if (Config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", "");
				driver = new ChromeDriver();
			}

			else if (Config.getProperty("browser").equals("ie")) {

				System.setProperty("webdriver.ie.driver", "");
				driver = new InternetExplorerDriver();
			}
			driver.get(Config.getProperty("URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

	}
	
	public By getElementLocator(String locatorName){
		
		By by=null;
		
		String element=OR.getProperty(locatorName);
		
		//element=id;identifierId
		
		String lName=element.split(";")[0];
		String lValue=element.split(";")[1];
		
		if(lName.equalsIgnoreCase("xpath")){
			by=By.xpath(lValue);	
		}
		else if(lName.equalsIgnoreCase("css")){
			by=By.cssSelector(lValue);
		}
		else if(lName.equalsIgnoreCase("id")){
			by=By.id(lValue);
		}
		return by;
		/*switch(lName){
		
		case "xpath":
			by=By.xpath(lValue);
			break;
		case "css":
			by=By.cssSelector(lValue);
			break;
		case "id":
			by=By.id(lValue);
			break;
					
		}
		return by;
*/	}

	public void click(String btnName) {
		
		By by=getElementLocator(btnName);
		
		driver.findElement(by).click();
		
		//driver.findElement(By.css(""))

	}
	
	public boolean isElementPresent(String elementName){
		
		By by=getElementLocator(elementName);
		
		try{
			
			driver.findElement(by);
			return true;
		}
		catch(Throwable e){
			return false;
		}
	}
	
	public void type(String objName,String text) {
		
		By by=getElementLocator(objName);
		
		driver.findElement(by).sendKeys(text);
		

	}
	

}
