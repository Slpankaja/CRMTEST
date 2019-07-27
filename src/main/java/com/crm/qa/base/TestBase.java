package com.crm.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	 public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver e_driver;
	 public static WebEventListener eventListener;
	 
	
	
	public  TestBase(){		  
		  try {
			  prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Pankaja SL\\eclipse-workspace-NaveenAutomationlabs\\CRMTEST\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");			
			prop.load(ip);
		  } catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	 }
	
	public static void intialization() {
		String browsername=prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
			
			driver = new ChromeDriver();	
			
			
		}else if (browsername.equals("FF")) {
			System.getProperty("webdriver.gecko.driver",".//driver//geckodriver.exe");
			driver = new FirefoxDriver();			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		//now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener  = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		// to change time load wait directly we can take from Util class itself 
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
