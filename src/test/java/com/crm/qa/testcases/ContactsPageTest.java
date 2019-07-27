package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage ;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetName="Contacts";
	
	
	
	public ContactsPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		intialization();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		loginPage = new LoginPage(); 
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage =homePage.clickonContactslink();
	}
	
	@Test(priority=1)
	public void verifyContactsLinkTest() {
		contactspage.verifyContactslabel();
		Assert.assertTrue(contactspage.verifyContactslabel(),"Contacts Label missing for this Page");
	}
	
	@Test(priority=2)
	public void selectcontactlisttest() {
		contactspage.selectContacts();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = testutil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreatenewContact(String firstname, String lastname) {
		homePage.clickonNewContactsLink();
		contactspage.CreatenewContact("firstname", "lastname");
		
	}
	
	
	
	
	
	
	@AfterMethod
	public void teardown() {
	driver.quit();
	}
}
