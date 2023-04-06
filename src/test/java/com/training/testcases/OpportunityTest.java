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
import com.training.pages.LoginPage;
import com.training.pages.OpportunityPage;

public class OpportunityTest extends BaseTest {

	WebDriver driver;
	String url;
	LoginPage loginpage;
	OpportunityPage opportunity;
	String Username ;
	String Password;
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver("chrome");
		url = getUrl("url");
		driver.get(url);
		loginpage = new LoginPage(driver);
		opportunity = new OpportunityPage(driver);
		Username = getUsername("username");
		Password = getPassword("password");
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("test");
		
	}

	@AfterMethod
	public void afterMethod(Method method) throws IOException {
		String testcase = method.getName();
		System.out.println(testcase);
		takeScreenshot(driver, testcase);
		//driver.close();
	}

	@Test
	public void OppDropDown() throws InterruptedException {
		loginpage.username(Username);
		loginpage.password(Password);
		loginpage.login();
		Log.info("Opportunity Page");
		opportunity.clkOpportunitiesTab();
		Thread.sleep(2000);
		popup();
		opportunity.clkOpportunitiesDD();
		opportunity.OpportunitiesDropdown();
	}
	
	@Test
	public void createNewOpportunity() throws InterruptedException {
		loginpage.username(Username);
		loginpage.password(Password);
		loginpage.login();
		opportunity.clkOpportunitiesTab();
		Thread.sleep(2000);
		popup();
		
		opportunity.createNewOpportunity();
		opportunity.enterOppName();
		opportunity.clickSearchAccount();
		Thread.sleep(3000);
		opportunity.enterAccinSearch("Pyramid");
		opportunity.clickGo();
		opportunity.selectFromSearch();
		opportunity.selCloseDate();
		opportunity.clkStage();
		opportunity.selProspecting();
		opportunity.clkLeadSource();
		opportunity.selOther();
	/*	opportunity.searchPrimaryCampaignSource();
		opportunity.clickSearchCampaign("Test");
		opportunity.clickGo();
		opportunity.selectFromSearch(); */
		opportunity.enterPrimarySearchCampaign("Test Campaign");
	}
	
	@Test
	public void OpportunityPipeline() throws InterruptedException {
		loginpage.username(Username);
		loginpage.password(Password);
		loginpage.login();
		opportunity.clkOpportunitiesTab();
		Thread.sleep(2000);
		popup();
		opportunity.clkOpportunityPipeline();
		validate("Opportunity Pipeline ~ Salesforce - Developer Edition");
	}
	
	@Test
	public void StuckOpportunity() throws InterruptedException {
		loginpage.username(Username);
		loginpage.password(Password);
		loginpage.login();
		opportunity.clkOpportunitiesTab();
		Thread.sleep(2000);
		popup();
		opportunity.clkStuckOpportunities();
		validate("Stuck Opportunities ~ Salesforce - Developer Edition");
	}

	@Test
	public void QuarterlySummary() throws InterruptedException {
		loginpage.username(Username);
		loginpage.password(Password);
		loginpage.login();
		opportunity.clkOpportunitiesTab();
		Thread.sleep(2000);
		popup();
		Log.info("Testing for various combinations of quarterly summary");
		Log.info("Case 1");
		opportunity.clkIntervalDD();
		opportunity.chooseInterval("Next FQ");
		opportunity.clkIncludeDD();
		opportunity.chooseInclude("All Opportunities");
		opportunity.clickGo();
		opportunity.validateQuarterlySummary();

	}
}
