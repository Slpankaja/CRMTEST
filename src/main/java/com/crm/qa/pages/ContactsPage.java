package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactslabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement savebtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactslabel() {
		return contactslabel.isDisplayed();
	}
	
	public void selectContacts() {
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/div/label")).click();	
	}
	
	public void CreatenewContact(String ftname, String ltname) {
		//Select select = new Select(driver.findElement(By.xpath("//div[@name='channel_type']")));
			//select.selectByVisibleText(channels);	
			
			firstName.sendKeys(ftname);	
			lastName.sendKeys(ltname);
			savebtn.click();
	}
	
	
	
	
}
