package com.training.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.CreateAccountPage;
import com.training.pages.LoginPage;

public class CreateAccountTest extends BaseTest {
	WebDriver driver;
	String Url;
	LoginPage loginpage;
	CreateAccountPage createaccountpage;
	String reportName = RandomStringUtils.randomAlphabetic(6);
	String reportUnique = RandomStringUtils.randomAlphabetic(4);
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver("Chrome");
		Url = getUrl("url");
		driver.get(Url);
		loginpage = new LoginPage(driver);
		createaccountpage = new CreateAccountPage(driver);
	}
	
	@AfterMethod
	public void afterMethod(Method method) throws IOException {
		String testcase = method.getName();
		System.out.println(testcase);
		takeScreenshot(driver, testcase);
		driver.close();
	}
	
	@Test
	public void createNewAccount() throws InterruptedException {
		loginpage.username("chinmayi@tek.com");
		loginpage.password("Chimmu@21");
		loginpage.login();
		createaccountpage.clkAccount();
		Thread.sleep(2000);	
		popup();
		createaccountpage.createNewAccount();
		createaccountpage.accountName("TestAccount");
		createaccountpage.accTypeDD();
		createaccountpage.selCustomerPriority();
		createaccountpage.save();
		createaccountpage.validateAccCreation("Account Detail");
		createaccountpage.deleteAccount();// to avoid multiple accounts
	}
	
	@Test
	public void createNewView() throws InterruptedException {
		loginpage.username("chinmayi@tek.com");
		loginpage.password("Chimmu@21");
		loginpage.login();
		
		createaccountpage.clkAccount();
		Thread.sleep(2000);
		popup();
		createaccountpage.clkCreateNewView();
		createaccountpage.enterViewName("TestUn1234");
		createaccountpage.clkViewUniqueName();
		createaccountpage.clearViewUniqueName();
		createaccountpage.enterViewUniqueName("TestUn_123");
		createaccountpage.save();
		validate("Accounts ~ Salesforce - Developer Edition");
		createaccountpage.deleteView();
		
	}
	
	@Test
	public void editView() throws InterruptedException {
		loginpage.username("chinmayi@tek.com");
		loginpage.password("Chimmu@21");
		loginpage.login();
		
		createaccountpage.clkAccount();
		Thread.sleep(2000);
		popup();
		createaccountpage.clkEdit();
		createaccountpage.clearViewName();
		createaccountpage.enterViewName("Hello123");
		createaccountpage.filterFieldAccountName("Account Name");
		createaccountpage.filterOperatorField("contains");
		createaccountpage.enterValue("a");
		createaccountpage.save();
		
	}
	
	@Test
	public void mergeAccount() throws InterruptedException {
		loginpage.username("chinmayi@tek.com");
		loginpage.password("Chimmu@21");
		loginpage.login();
		
		createaccountpage.clkAccount();
		Thread.sleep(2000);
		popup();
		createaccountpage.createNewAccount();
		createaccountpage.accountName("TestAccount1");
		createaccountpage.accTypeDD();
		createaccountpage.selCustomerPriority();
		createaccountpage.save();
		
		for(int i =2 ; i<=3; i++) {
		createaccountpage.clkAccount();
		createaccountpage.createNewAccount();
		createaccountpage.accountName("TestAccount" + i);
		createaccountpage.accTypeDD();
		createaccountpage.selCustomerPriority();
		createaccountpage.save();
		}
		
		createaccountpage.clkAccount();
		createaccountpage.clkMergeAccounts();
		createaccountpage.selectAcc("Test");
		createaccountpage.clkfindAccount();
		createaccountpage.clkAccount1();
		createaccountpage.clkAccount2();
		createaccountpage.clkAccount3();
		createaccountpage.clickNext();
		Thread.sleep(5000);
		createaccountpage.merge();
	
	}
	
	@Test
	public void createAccountReport() throws InterruptedException {
		loginpage.username("chinmayi@tek.com");
		loginpage.password("Chimmu@21");
		loginpage.login();
		
		createaccountpage.clkAccount();
		Thread.sleep(2000);
		popup();
		createaccountpage.clkAccountsWithActivity();
		createaccountpage.clkDateField();
		createaccountpage.selectCreatedDate();
		createaccountpage.selectFromIcon();
		createaccountpage.selectFromDate();
		createaccountpage.saveReport();
		createaccountpage.enterReportName(reportName);
		createaccountpage.enterReportUniqueName(reportUnique);
		Thread.sleep(3000);
		createaccountpage.saveAndRunReport();
		createaccountpage.deleteReport();
	}
}
