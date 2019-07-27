package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// how to define PageFactory ---OR(Object Repository) File
	
	// here we are defining only page elements Pgae Object repositories / page libraries 
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	// how to intialize the webelements with the help of Page Factory 
	//solotion we will create constructor of a class
	// PageFactory is a class & initElemnets is a method
	//IQ: How u will intialize PageFactory
	
	//Intializing the Page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	// now we define different actions 
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	
	
	
	
	
	
	
	
	
}
