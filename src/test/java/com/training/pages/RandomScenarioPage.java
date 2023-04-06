package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class RandomScenarioPage extends BasePage{

	public RandomScenarioPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "home_Tab")
	WebElement homeTab;
	
	@FindBy(xpath = "//h1[@class = 'currentStatusUserName']")
	WebElement username;
	
	@FindBy(xpath = "//img[@class='allTabsArrow']")
	WebElement plusIcon;
	
	@FindBy(name = "customize")
	WebElement customize;
	
	@FindBy(id = "duel_select_1")
	WebElement selectedtabDD;
	
	@FindBy(xpath = "//img[@class='leftArrowIcon']")
	WebElement removeBtn;
	
	@FindBy(name = "save")
	WebElement save;
	
	@FindBy(id = "duel_select_0")
	WebElement availtabDD;
	
	@FindBy(xpath ="//img[@class='rightArrowIcon']")
	WebElement addBtn;
	
	@FindBy(xpath ="//td[@id = 'bodyCell']//span[@class='pageDescription']/a")
	WebElement dateandtime;
	
	@FindBy(id = "p:f:j_id25:j_id61:28:j_id64")
	WebElement timelink;
	
	@FindBy(xpath = "//img[@class='comboboxIcon']")
	WebElement subjectComboIcon;
	
	@FindBy(xpath = "//li/a[text()='Other']")
	WebElement selOther;
	
	public void clickHometab() {
		homeTab.click();
	}
	
	public void verifyUsername() {
		String actual =username.getText();
		String expected = "Chinmayi Mahishi";
		Assert.assertEquals(actual, expected);
	}
	
	public void clickUsernameLink() {
		username.click();
	}
	
	public void verifyBothPages(String s1, String s2) {
		Assert.assertEquals(s1, s2);
	}
	public void clickPlus() {
		plusIcon.click();
	}
	public void clickCustomizeTab() {
		waitforElement(10, customize);
		customize.click();
	}
	public void selectTabToRemove(String tabName) {
		waitforElement(10, selectedtabDD);
		Select option = new Select(selectedtabDD);
		option.selectByVisibleText(tabName);
	}
	public void clickRemove() {
		removeBtn.click();
	}
	public void clickSave() {
		save.click();
	}
	public void addTabAgain(String tabName) {
		plusIcon.click();
		waitforElement(10, customize);
		customize.click();
		waitforElement(10, availtabDD);
		Select option = new Select(availtabDD);
		option.selectByVisibleText(tabName);
		addBtn.click();
		save.click();
		
	}
	public void verifyDateandTime() {
		String value =dateandtime.getText();
		if(value != null) {
			System.out.println("Present");
		}
		else
			System.out.println("Date and time not present");
	}
	public void clickonDateAndTime() {
		waitforElement(10, dateandtime);
		dateandtime.click();
	}
	public void clickOn8pmLink() throws InterruptedException {
		Thread.sleep(2000);
		//waitforElement(10, timelink);
		timelink.click();
	}
	public void clickSubjectComboIcon() {
		subjectComboIcon.click();
	}
	public void clickOther() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		String childWindow = null;
		for(String handle: driver.getWindowHandles()) {
			childWindow= handle;
		driver.switchTo().window(handle);
		}
		selOther.click();
		
	}
}
