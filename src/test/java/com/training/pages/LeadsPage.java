package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text() = 'Leads']")
	WebElement clkLeads;

	@FindBy(id = "fcf")
	WebElement clkViewdropdown;

	@FindBy(xpath = "//select[@id = 'fcf']/option[@value = '00BDm0000046OEK']" )
	WebElement todaysLeadsDropdown;
	
	@FindBy(name = "go")
	WebElement go;
	
	@FindBy(xpath = "//option[@selected = 'selected']")
	WebElement leadsdd;
	
	@FindBy(name = "new")
	WebElement newLead;
	
	@FindBy(id ="name_lastlea2")
	WebElement lastname;
	
	@FindBy(id = "lea3")
	WebElement companyname;
	
	@FindBy(name = "save")
	WebElement savebtn;
	
	@FindBy(xpath = "//h2[@class='topName']")
	WebElement validateName;
	
	
	
	
	public void clickLeadsTab() {
		clkLeads.click();
	}

	public void clickViewDropDown() {
		clkViewdropdown.click();
	}

	public void validateDD() {
		Select select = new Select(clkViewdropdown);
		String[] expectedList = { "All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads",
				"View - Custom 1", "View - Custom 2" };

		for (WebElement we : select.getOptions()) {
			boolean match = false;
			for (int i = 0; i < expectedList.length; i++) {
				if (we.getText().equals(expectedList[i])) {
					match = true;
				}
			}
			Assert.assertTrue(match);
		}
	}
	public void selTodaysLeads() {
		todaysLeadsDropdown.click();
	}
	public void clickGo() {
		go.click();
	}
	public void validateSelectedLeadsView() {
	String actual = leadsdd.getText();
	String expected = "Today's Leads";
	Assert.assertEquals(actual, expected);
	}
	public void clickNew() {
		newLead.click();
	}
	public void enterLastname(String lname) {
		lastname.sendKeys(lname);
	}
	public void enterCompanyName(String companyName) {
		companyname.sendKeys(companyName);
	}
	public void clickSave() {
		savebtn.click();
	}
	public void validateNewLead(String lname) {
		String actual = validateName.getText();
		String expected = lname;
		Assert.assertEquals(actual, expected);
	}
}
