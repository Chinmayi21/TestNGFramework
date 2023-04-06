package com.training.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;

public class UserMenuTest extends BaseTest {

	WebDriver driver;
	LoginPage loginpage;
	UserMenuPage userpage;
	String url;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver("chrome");
		url = getUrl("url"); // getting url from the file
		driver.get(url); // launching the url
		loginpage = new LoginPage(driver);
		userpage = new UserMenuPage(driver);
	}

	@AfterMethod
	public void afterMethod(Method method) throws IOException {
		String testCase = method.getName();
		System.out.println(testCase);
		takeScreenshot(driver, testCase);
	    driver.close();
	}

	@Test
	public void userMenuDD() {
		loginpage.username("chinmayi@tek.com");
		loginpage.password("Chimmu@21");
		loginpage.login();
		userpage.userMenuDD();
	}

	@Test
	public void actionsOnProfile() throws InterruptedException {
		loginpage.username("chinmayi@tek.com");
		loginpage.password("Chimmu@21");
		loginpage.login();
		userpage.userMenuDD();
		userpage.myProfile();

		userpage.editBtn();
		userpage.switchFrame();
		userpage.AboutTab();
		userpage.clrLastname();
		userpage.enterLastname("Mahishi");
		userpage.saveBtn();

		userpage.clickPostLink();
		userpage.switchToFrame();
		userpage.postOnWall();
		userpage.Share();

		Thread.sleep(3000);
		userpage.clickFileLink();
		userpage.clickUpload();
		userpage.chooseFile();
		userpage.shareFile(); 
		
		Thread.sleep(3000);
		userpage.Hover();
		userpage.uploadPhoto();
		userpage.switchToFramePic();
		userpage.uploadPic();
		userpage.savePic();
		Thread.sleep(3000);
		userpage.crop1();
		userpage.crop2();
		userpage.savePhoto();
		
	}

	@Test
	public void actiononMySettings() throws InterruptedException {
		loginpage.username("chinmayi@tek.com");
		loginpage.password("Chimmu@21");
		loginpage.login();
		userpage.userMenuDD();
		userpage.mySettings();
		
		userpage.clkPersonalLink();
		userpage.clkLoignHis();
		userpage.downloadLoginHistory(); 
		
		userpage.clkDisplayandLayout();
		userpage.clkCustomizeTab();
		userpage.customAppDD();
		userpage.selReport();
		userpage.addBtn();
		userpage.saveTab();
		userpage.validateTab("Reports");
		userpage.validateinSalesChatter();
		userpage.closePopup();
		userpage.validateinMarketing(); 
		
		userpage.clkEmail();
		userpage.clkEmailSettings();
		userpage.enterName("test");
		userpage.enterEmail("hello@test.com");
		userpage.clkAutomaticBcc();
		userpage.saveEmailSettings(); 

		userpage.clkCalenderAndReminder();
		userpage.clkActivityReminder();
		userpage.openTestReminder();//check and go to new window
		Thread.sleep(2000);
		userpage.validatePopUp();
	}
	
	@Test
	public void devConsole() {
		loginpage.username("chinmayi@tek.com");
		loginpage.password("Chimmu@21");
		loginpage.login();
		userpage.userMenuDD();
		userpage.DevConsole();
		userpage.closeDevConsole();
		validate("Home Page ~ Salesforce - Developer Edition");
	}

	@Test
	public void logout() throws InterruptedException {
		loginpage.username("chinmayi@tek.com");
		loginpage.password("Chimmu@21");
		loginpage.login();
		userpage.userMenuDD();
		userpage.logout();
		Thread.sleep(2000);
		validate("Login | Salesforce");
	}


}
