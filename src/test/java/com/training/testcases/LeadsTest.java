package com.training.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.logfile.Log;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;

public class LeadsTest extends BaseTest {

	WebDriver driver;
	String URL;
	LoginPage loginpage;
	LeadsPage leadspage;
	String username;
	String pwd;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver("chrome");
		URL = getUrl("url");
		driver.get(URL);
		loginpage = new LoginPage(driver);
		leadspage = new LeadsPage(driver);
		username = getUsername("username");
		pwd = getPassword("password");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Leads Test Cases");
	}

	@AfterMethod
	public void teardown(Method method) throws IOException {
		String testcase = method.getName();
		System.out.println(testcase);
		takeScreenshot(driver, testcase);
		// driver.close();
	}

	@Test
	public void LeadsTab() {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		leadspage.clickLeadsTab();
		loginpage.logout();
	}

	@Test
	public void leadsViewDropDown() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		leadspage.clickLeadsTab();
		Thread.sleep(2000);
		popup();
		leadspage.clickViewDropDown();
		leadspage.validateDD();
		loginpage.logout();

	}

	@Test
	public void functionalityOfGoBtn() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		leadspage.clickLeadsTab();
		Thread.sleep(2000);
		popup();
		leadspage.clickViewDropDown();
		leadspage.selTodaysLeads();
		loginpage.usernameDropDown();
		loginpage.logout();
		Log.info("Logging in again to check the functionality");
		Thread.sleep(2000);
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		leadspage.clickLeadsTab();
		leadspage.clickGo();
		leadspage.validateSelectedLeadsView();
		loginpage.logout();

	}

	@Test
	public void todaysLeads() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		leadspage.clickLeadsTab();
		Thread.sleep(2000);
		popup();
		leadspage.clickViewDropDown();
		leadspage.selTodaysLeads();
		leadspage.clickGo();
		leadspage.validateSelectedLeadsView();
		loginpage.usernameDropDown();
		loginpage.logout();

	}

	@Test
	public void testNewLead() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		leadspage.clickLeadsTab();
		Thread.sleep(2000);
		popup();
		leadspage.clickNew();
		leadspage.enterLastname("ABCD");
		leadspage.enterCompanyName("ABCD");
		leadspage.clickSave();
		leadspage.validateNewLead("ABCD");
		loginpage.logout();
	}
}
