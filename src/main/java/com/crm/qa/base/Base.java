package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Base {

	static WebDriver driver;
	static Properties prop;
	
	
	public Base() {			
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
}

	

	

