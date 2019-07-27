package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'Pankaja SL')]")
	WebElement UserNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement ContactsNewLink;
	
	//Intializing  Page Objects;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyCorrectUsername() {
		return UserNameLabel.isDisplayed();
	}
	public ContactsPage clickonContactslink () {
		contactslink.click();
		return new ContactsPage();
		
	}
	
	public DealsPage verifyDealsPage () {
		dealLink.click();
		return new DealsPage();		
	} 
	public TasksPage clickonTaskLink() {
		taskLink.click();
		return new TasksPage();		
	} 
	
	public void clickonNewContactsLink() {
		ContactsNewLink.click();
	}
}
