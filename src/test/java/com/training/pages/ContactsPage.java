package com.training.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class ContactsPage extends BasePage {

	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Contacts']")
	WebElement contactsTab;

	@FindBy(name = "new")
	WebElement clicknew;

	@FindBy(id = "name_lastcon2")
	WebElement lastname;

	@FindBy(id = "con4_lkwgt")
	WebElement searchAccName;

	@FindBy(id = "con4")
	WebElement accName;

	@FindBy(name = "save")
	WebElement saveBtn;

	@FindBy(xpath = "//h2[text()='Contact Detail']")
	WebElement validateElement;

	@FindBy(xpath = "//a[text()='Create New View']")
	WebElement createNewView;

	@FindBy(id = "fname")
	WebElement viewname;

	@FindBy(id = "devname")
	WebElement uniqueName;

	@FindBy(xpath = "//option[@selected = 'selected']")
	WebElement validateView;

	@FindBy(id = "hotlist_mode")
	WebElement contactDD;

	@FindBy(xpath = "//table[@class ='list']//tr[2]/th/a")
	WebElement validateRecentContact;

	@FindBy(id = "fcf")
	WebElement viewDD;

	@FindBy(name = "go")
	WebElement go;

	@FindBy(name = "fcf")
	WebElement contactsView;

	@FindBy(xpath = "//table[@class = 'x-grid3-row-table']//tr[1]/td[4]/div[@id = '003Dm00000590vk_FULL_NAME']")
	WebElement selectContact;

	@FindBy(xpath = "//table//div[text()=' You must enter a value']")
	WebElement errorMsg;

	@FindBy(name = "cancel")
	WebElement cancel;

	@FindBy(name = "save_new")
	WebElement saveandnew;
	
	public void clickContactsTab() {
		contactsTab.click();
	}

	public void clickNew() {
		clicknew.click();
	}

	public void enterLastName(String lname) {
		lastname.sendKeys(lname);
	}

	public void clickSearchIcon() {
		searchAccName.click();
	}

	public void enterAccName(String accname) {
		accName.sendKeys(accname);
	}

	public void clickSave() {
		saveBtn.click();
	}

	public void validateNewContact() {
		String actual = validateElement.getText();
		String expected = "Contact Detail";
		Assert.assertEquals(actual, expected);
	}

	public void clickCreateNewView() {
		createNewView.click();
	}

	public void enterViewName(String viewName) {
		viewname.sendKeys(viewName);
	}

	public void enterViewUniqueName() {
		uniqueName.click();
	}

	public void enterViewUnique(String name) {
		uniqueName.clear();
		uniqueName.sendKeys(name);
	}

	public void validateContactView(String viewName) {
		String actual = validateView.getText();
		String expected = viewName;
		Assert.assertEquals(actual, expected);
	}

	public void selectRecentlyCreated() {
		Select dd = new Select(contactDD);
		dd.selectByValue("2");
	}

	public void validateRecentlyCreated(String lastname) {
		String expected = lastname;
		String actual = validateRecentContact.getText();
		Assert.assertEquals(actual, expected);
	}

	public void selectViewDropDown() {
		Select dropdown = new Select(viewDD);
		dropdown.selectByVisibleText("My Contacts");
	}

	public void clickGo() {
		go.click();
	}

	public void contactViewDD() {
		Select option = new Select(contactsView);
		option.selectByVisibleText("My Contacts");
	}

	public void selectRecentlyViewed() {
		Select option = new Select(contactsView);
		option.selectByVisibleText("Recently Viewed Contacts");
	}

	public void selectContact() {
		selectContact.click();
	}

	public void validateErrorMsg() {
		String actualMsg = errorMsg.getText();
		String expectedMsg = "Error: You must enter a value";
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	public void clickCancel() {
		cancel.click();
	}
	
	public void clickSaveAndNew() {
		saveandnew.click();
	}

}