package com.training.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.ContactsPage;
import com.training.pages.LoginPage;
import com.training.pages.RandomScenarioPage;
import com.training.pages.UserMenuPage;

public class RandomScenarioTest extends BaseTest {
	WebDriver driver;
	String URL;
	String username;
	String pwd;
	LoginPage loginpage;
	RandomScenarioPage randompage;
	UserMenuPage usermenupage;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver("chrome");
		URL = getUrl("url");
		driver.get(URL);
		username = getUsername("username");
		pwd = getPassword("password");
		loginpage = new LoginPage(driver);
		randompage = new RandomScenarioPage(driver);
		usermenupage = new UserMenuPage(driver);
	}

	@AfterMethod
	public void Teardown(Method method) throws IOException {
		String testcase = method.getName();
		System.out.println(testcase);
		takeScreenshot(driver, testcase);
		// driver.close();
	}

	@Test
	public void verifyUserName() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		randompage.clickHometab();
		Thread.sleep(4000);
		popup();
		randompage.verifyUsername();
		randompage.clickUsernameLink();
		String s1 = driver.getTitle();
		usermenupage.userMenuDD();
		usermenupage.myProfile();
		String s2 = driver.getTitle();
		randompage.verifyBothPages(s1, s2);

	}

	@Test
	public void verifyEditedLastName() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		randompage.clickHometab();
		Thread.sleep(4000);
		popup();
		randompage.clickUsernameLink();
		usermenupage.editBtn();
		usermenupage.switchFrame();
		usermenupage.AboutTab();
		usermenupage.clrLastname();
		usermenupage.enterLastname("ABCD");
		usermenupage.saveBtn();
		//Revert back to previous name
		randompage.clickUsernameLink();
		usermenupage.editBtn();
		usermenupage.switchFrame();
		usermenupage.AboutTab();
		usermenupage.clrLastname();
		usermenupage.enterLastname("Mahishi");
		usermenupage.saveBtn();
	}

	@Test
	public void verifyTabCustomization() {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		randompage.clickPlus();
		randompage.clickCustomizeTab();
		randompage.selectTabToRemove("Orders");
		randompage.clickRemove();
		randompage.clickSave();
		usermenupage.validateTab("Orders");
		randompage.addTabAgain("Orders");
	}
	
	@Test
	public void blockingEvent() throws InterruptedException {
		loginpage.username(username);
		loginpage.password(pwd);
		loginpage.login();
		randompage.clickHometab();
		Thread.sleep(4000);
		popup();
		randompage.verifyDateandTime();
		randompage.clickonDateAndTime();
		randompage.clickOn8pmLink();
		Thread.sleep(2000);
		randompage.clickSubjectComboIcon();
		Thread.sleep(5000);
		randompage.clickOther(); 
	}
}
