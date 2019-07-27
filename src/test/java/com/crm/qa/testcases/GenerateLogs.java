package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenerateLogs {

	public static void main(String[] args) {
		
		Logger log = Logger.getLogger(GenerateLogs.class);
		
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		log.info("launchingbrowser");
		driver.get("https://www.google.com");
		log.info("google url has been launched");
		String title =driver.getTitle();
		System.out.println("title value is:"+ title);
		if (title.equals("Google")) {
			System.out.println("Correct title is Google");
			log.info("Correct tilte is Google and test case is passed");			
		}
		else {
			System.out.println("Correct title is not Google");
			log.info("Correct tilte is not Google and test case is failed");
		}
		
	}

}
