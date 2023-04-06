package com.training.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class OpportunityPage extends BasePage {

	public OpportunityPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@title='Opportunities Tab']")
	WebElement oppTab;

	@FindBy(id = "fcf")
	WebElement oppDropDown;

	@FindBy(name = "new")
	WebElement newOpp;

	@FindBy(id = "opp3")
	WebElement oppName;

	@FindBy(id = "opp4_lkwgt")
	WebElement searchglass;

	@FindBy(id = "lksrch")
	WebElement search;

	@FindBy(name = "go")
	WebElement go;

	@FindBy(id = "searchFrame")
	WebElement searchFrame;
	
	@FindBy(id = "resultsFrame")
	WebElement resultsFrame;

	@FindBy(xpath = "//table[@class = 'list']/tbody/tr[2]/th/a")
	WebElement selAcc;

	@FindBy(xpath = "//table[@class = 'detailList']/tbody/tr[2]/td[4]/div/span/span/a")
	WebElement selDate;

	@FindBy(id = "opp11")
	WebElement stageDD;

	@FindBy(xpath = "//option[@value ='Prospecting']")
	WebElement selProspecting;

	@FindBy(id = "opp6")
	WebElement leadsrc;

	@FindBy(xpath = "//option[@value ='Other']")
	WebElement selOther;

	@FindBy(id = "opp17_lkwgt")
	WebElement searchCampaign;

	@FindBy(id = "opp17")
	WebElement manuallyentervalue;

	@FindBy(name = "save")
	WebElement save;

	@FindBy(xpath = "//a[text()='Opportunity Pipeline']")
	WebElement oppPipeline;

	@FindBy(xpath = "//a[text()='Stuck Opportunities']")
	WebElement stuckOpp;

	@FindBy(id = "quarter_q")
	WebElement clickIntervalDD;

	@FindBy(id = "open")
	WebElement clickIncludeDD;

	@FindBy(xpath = "//option[text() = 'Current FQ']")
	WebElement currentFq;

	@FindBy(xpath = "//option[text() = 'Next FQ']")
	WebElement nextFq;

	@FindBy(xpath = "//select[@id = 'open']/option[text() = 'All Opportunities']")
	WebElement allOpp;

	@FindBy(xpath = "//option[text() = 'Open Opportunities']")
	WebElement openOpp;

	@FindBy(xpath = "//option[text() = 'Closed Opportunities']")
	WebElement closedOpp;

	@FindBy(id = "quarter_q")
	WebElement verifyrange;

	@FindBy(id = "open")
	WebElement verifyOppStatus;

	public void clkOpportunitiesTab() throws InterruptedException {
		oppTab.click();
	}

	public void clkOpportunitiesDD() {
		oppDropDown.click();
	}

	public void OpportunitiesDropdown() {
		Select sel = new Select(oppDropDown);
		String[] expectedList = { "All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities",
				"New Last Week", "New This Week", "Opportunity Pipeline", "Private", "Recently Viewed Opportunities",
				"Won" };

		for (WebElement we : sel.getOptions()) {
			boolean match = false;
			for (int i = 0; i < expectedList.length; i++) {
				if (we.getText().equals(expectedList[i])) {
					match = true;
				}
			}
			Assert.assertTrue(match);
		}
	}

	public void createNewOpportunity() {
		newOpp.click();
	}

	public void enterOppName() {
		waitforElement(10, oppName);
		oppName.sendKeys("Test Opportunity");
	}

	public void clickSearchAccount() {
		waitforElement(10, searchglass);
		searchglass.click();
	}

	public void enterAccinSearch(String AccName) {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		driver.switchTo().frame(searchFrame);
		// switch to frame
		search.sendKeys(AccName);
	}

	public void clickGo() {
		go.click();
	}

	public void selectFromSearch() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame(resultsFrame);
		selAcc.click();
	}

	public void selCloseDate() {
		selDate.click();
	}

	public void clkStage() {
		stageDD.click();
	}

	public void selProspecting() {
		selProspecting.click();
	}

	public void clkLeadSource() {
		leadsrc.click();
	}

	public void selOther() {
		selOther.click();
	}

	public void searchPrimaryCampaignSource() {
		searchCampaign.click();
	}

	public void clickSearchCampaign(String CampaignName) {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		search.sendKeys(CampaignName);
	}

	public void enterPrimarySearchCampaign(String CampaignName) {
		manuallyentervalue.sendKeys(CampaignName);
	}

	public void save() {
		save.click();
	}

	public void clkOpportunityPipeline() {
		oppPipeline.click();
	}

	public void clkStuckOpportunities() {
		stuckOpp.click();
	}

	public void clkIntervalDD() {
		clickIntervalDD.click();
	}

	public void clkIncludeDD() {
		clickIncludeDD.click();
	}

	public void chooseInterval(String intervalName) {
		if (intervalName == "Current FQ") {
			currentFq.click();
		}
		if (intervalName == "Next FQ") {
			nextFq.click();
		}
	}

	public void chooseInclude(String includeName) {
		if (includeName == "All Opportunities") {
			allOpp.click();
		}
		if (includeName == "Open Opportunities") {
			openOpp.click();
		}
		if (includeName == "Closed Opportunities") {
			closedOpp.click();
		}

	}

	public void validateQuarterlySummary() {
		if ((verifyrange.getText() == "Next FQ") && (verifyOppStatus.getText() == "All")) {
			System.out.println("Test case is passed");
		}

	}

	
}
