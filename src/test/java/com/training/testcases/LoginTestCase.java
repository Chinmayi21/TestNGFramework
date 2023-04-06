package com.training.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCase extends BaseTest {

	LoginPage loginpage;
	WebDriver driver;
	String url;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver("chrome");
		url = getUrl("url");	// getting url from the file
		driver.get(url); // launching the url
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
	}
	
	@AfterMethod
	public void afterMethod(Method method) throws IOException  {
		System.out.println("Test name: " + method. getName () );
		String sTestCase = method.getName ();
		takeScreenshot (driver, sTestCase);
		driver.close();
	}

	@Test
	public void clrPwdfield() {
		loginpage.username("chinmayi@tek.com");
		loginpage.clearPwd();
		loginpage.login();
		loginpage.enterPwdMsg("Please enter your password.");
	}
	
	@Test
	public void validLogin() {
		loginpage.username("chinmayi@tek.com");
		loginpage.password("Chimmu@21");
		loginpage.login();
		validate("Home Page ~ Salesforce - Developer Edition");
	}
	
	@Test
	public void rememberMe() throws InterruptedException {
		loginpage.username("chinmayi@tek.com");
		loginpage.password("Chimmu@21");
		loginpage.rememberMe();
		loginpage.login();
		loginpage.usernameDropDown();
		loginpage.logout();
		loginpage.validateUsrname("chinmayi@tek.com");
	}
	
	@Test
	public void forgotPassword() {
		loginpage.forgotpwd();
		loginpage.forgotpwdpage();
		loginpage.continueBtn();
		validate("Check Your Email | Salesforce");
	}
	
	@Test
	public void invalidLogin() {
		loginpage.username("123");
		loginpage.password("22131");
		loginpage.login();
		loginpage.loginErrorMsg();
	}
}
