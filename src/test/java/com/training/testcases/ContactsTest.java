package com.training.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.ContactsPage;
import com.training.pages.LoginPage;

public class ContactsTest extends BaseTest {

	WebDriver driver;
	String URL;
	String username;
	String pwd;
	LoginPage loginpage;
	ContactsPage contactspage;
	// String lastName = RandomStringUtils.randomAlphabetic(8);
	String viewName = RandomStringUtils.randomAlphabetic(5);

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver("chrome");
		URL = getUrl("url");
		driver.get(URL);
		username = getUsername("username");
		pwd = getPassword("password");
		loginpage = new LoginPage(driver);
		contactspage = new ContactsPage(driver);
	}

	@AfterMethod
	public void Teardown(Method method) throws IOException {
		String testcase = method.getName();
		System.out.println(testcase);
		takeScreenshot(driver, testcase);
		driver.close();
	}

	@Test
	public void createNewContact() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		contactspage.clickContactsTab();
		Thread.sleep(2000);
		popup();
		contactspage.clickNew();
		contactspage.enterLastName("qwerty");
		// contactspage.clickSearchIcon();
		contactspage.enterAccName("Pyramid");
		contactspage.clickSave();
		contactspage.validateNewContact();

	}

	@Test
	public void createNewView() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		contactspage.clickContactsTab();
		Thread.sleep(2000);
		popup();
		contactspage.clickCreateNewView();
		contactspage.enterViewName(viewName);
		contactspage.enterViewUniqueName();
		contactspage.clickSave();
		contactspage.validateContactView(viewName);
	}

	@Test
	public void checkRecentlyCreatedContact() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		contactspage.clickContactsTab();
		Thread.sleep(2000);
		popup();
		contactspage.selectRecentlyCreated();
		contactspage.validateRecentlyCreated("qwerty");
	}

	@Test
	public void checkMyContacts() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		contactspage.clickContactsTab();
		Thread.sleep(2000);
		popup();
		contactspage.contactViewDD();

	}

	@Test
	public void viewContact() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		contactspage.clickContactsTab();
		Thread.sleep(2000);
		popup();
		contactspage.selectRecentlyViewed();
		contactspage.clickGo();
		contactspage.selectContact();
	}

	@Test
	public void contactNewView() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		contactspage.clickContactsTab();
		Thread.sleep(2000);
		popup();
		contactspage.clickCreateNewView();
		contactspage.enterViewUniqueName();
		contactspage.enterViewUnique("EFGH");
		contactspage.clickSave();
		contactspage.validateErrorMsg();
	}
	
	@Test
	public void testCancelBtn() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		contactspage.clickContactsTab();
		Thread.sleep(2000);
		popup();
		contactspage.clickCreateNewView();
		contactspage.enterViewName("ABCD");
		contactspage.enterViewUniqueName();
		contactspage.enterViewUnique("EFGH");
		contactspage.clickCancel();
		validate("Contacts: Home ~ Salesforce - Developer Edition");
	}
	
	@Test
	public void saveAndNew() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		contactspage.clickContactsTab();
		Thread.sleep(2000);
		popup();
		contactspage.clickNew();
		contactspage.enterLastName("Indian");
		contactspage.enterAccName("Burlington Textiles Corp of America");
		contactspage.clickSaveAndNew();
	}
	
	
	
	
	
	
	
}
