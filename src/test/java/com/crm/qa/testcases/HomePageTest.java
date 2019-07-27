package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage ;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	
	public HomePageTest() {
		super();		
	}
	
	//test cases should be separated ---independet with each other 
	//before each test case ---launch browser and login
	// @test ---execute the test case
	// after each tets case -- close the browser 
	
	@BeforeMethod
	public void setup() {
		intialization();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		loginPage = new LoginPage(); 
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRM","Home Page title is not matched");
	}
	@Test(priority=2)
	public void verifyUserNameTest() {	
		//testutil.switchtoframe(); // here we are calling switchtoframe method from testutil bcz Username was exists inside the frame
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		//testutil.switchtoframe(); // contacts link is not insid ethe frame hence no use of frame 
		contactspage=homePage.clickonContactslink();
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
	
	
}
