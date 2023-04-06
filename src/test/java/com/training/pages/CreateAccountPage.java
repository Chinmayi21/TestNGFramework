package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class CreateAccountPage extends BasePage {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Account_Tab")
	WebElement accountTab;

	@FindBy(name = "new")
	WebElement newAccount;

	@FindBy(id = "acc2")
	WebElement accName;

	@FindBy(xpath = "//select[@id='acc6']")
	WebElement accType;

	@FindBy(id = "00NDm000005yDt0")
	WebElement custPri;

	@FindBy(name = "save")
	WebElement save;

	@FindBy(xpath = "//h2[text() = 'Account Detail']")
	WebElement pageElement;

	@FindBy(name = "delete")
	WebElement delete;

	@FindBy(xpath = "//a[text()='Create New View']")
	WebElement newView;

	@FindBy(id = "fname")
	WebElement viewName;

	@FindBy(id = "devname")
	WebElement viewUniquename;

	@FindBy(xpath = "//a[text()='Delete']")
	WebElement deleteView;

	@FindBy(id = "fcf")
	WebElement accViewName;

	@FindBy(xpath = "//a[text()='Edit']")
	WebElement edit;

	@FindBy(id = "fcol1")
	WebElement filterByField;

	@FindBy(id = "fop1")
	WebElement contains;

	@FindBy(id = "fval1")
	WebElement value;

	@FindBy(xpath = "//a[text()='Merge Accounts']")
	WebElement mergeAccount;

	@FindBy(id = "srch")
	WebElement searchAcc;

	@FindBy(name = "srchbutton")
	WebElement findAcc;

	@FindBy(id = "cid0")
	WebElement acc1Chk;

	@FindBy(id = "cid1")
	WebElement acc2Chk;

	@FindBy(id = "cid2")
	WebElement acc3Chk;

	@FindBy(name = "goNext")
	WebElement next;

	@FindBy(xpath = "//div[@class = 'pbTopButtons']//input[@name='save']")
	WebElement merge;

	@FindBy(xpath = "//a[contains(text(),'Accounts with last activity')]")
	WebElement accwithAct;

	@FindBy(id = "ext-gen148")
	WebElement dateField;

	@FindBy(xpath = "//div[text()='Created Date']")
	WebElement selcreatedDate;

	@FindBy(id = "ext-gen152")
	WebElement fromIcon;

	@FindBy(xpath = "//table[@id = 'ext-comp-1112']/tbody/tr[2]/td[2]//button")
	WebElement todayFrom;

	@FindBy(id = "ext-gen49")
	WebElement saveReport;

	@FindBy(id = "saveReportDlg_reportNameField")
	WebElement reportName;

	@FindBy(id = "saveReportDlg_DeveloperName")
	WebElement reportUnique;

	@FindBy(xpath = "//table[@id = 'dlgSaveAndRun']/tbody/tr[2]/td[2]//button")
	WebElement saveandrun;
	
	@FindBy(name = "delrep")
	WebElement deleteReport;

	public void clkAccount() {
		accountTab.click();
	}

	public void createNewAccount() {
		newAccount.click();
	}

	public void accountName(String AccName) {
		accName.sendKeys(AccName);
	}

	public void accTypeDD() {
		Select dropdown = new Select(accType);
		dropdown.selectByValue("Technology Partner");
	}

	public void selCustomerPriority() {
		Select dropdown = new Select(custPri);
		dropdown.selectByValue("High");
	}

	public void validateAccCreation(String expected) {
		String actual = "Account Detail";
		Assert.assertEquals(actual, expected);
	}

	public void deleteAccount() {
		delete.click();
		driver.switchTo().alert().accept();
	}

	public void clkCreateNewView() {
		newView.click();
	}

	public void enterViewName(String viewname) {
		viewName.sendKeys(viewname);
	}

	public void clkViewUniqueName() {
		viewUniquename.click();
	}

	public void clearViewUniqueName() {
		viewUniquename.clear();
	}

	public void enterViewUniqueName(String viewuniquename) {
		viewUniquename.sendKeys(viewuniquename);
	}

	public void save() {
		save.click();
	}

	public void deleteView() {
		waitforElement(10, deleteView);
		deleteView.click();
		driver.switchTo().alert().accept();
	}

	public void selectView(String viewName) {
		Select dropdown = new Select(accViewName);
		dropdown.selectByVisibleText(viewName);
	}

	public void clkEdit() {
		edit.click();
	}

	public void clearViewName() {
		viewName.clear();
	}

	public void filterFieldAccountName(String fieldName) {
		Select accName = new Select(filterByField);
		accName.selectByVisibleText(fieldName);
	}

	public void filterOperatorField(String operatorValue) {
		Select operator = new Select(contains);
		operator.selectByVisibleText(operatorValue);
	}

	public void enterValue(String value) {
		this.value.sendKeys(value);
	}

	public void clkMergeAccounts() {
		mergeAccount.click();
	}

	public void selectAcc(String accountName) {
		searchAcc.sendKeys(accountName);
	}

	public void clkfindAccount() {
		findAcc.click();
	}

	public void clkAccount1() {
		acc1Chk.click();
	}

	public void clkAccount2() {
		acc2Chk.click();
	}

	public void clkAccount3() {
		acc3Chk.click();
	}

	public void clickNext() {
		next.click();
	}

	public void merge() {
		merge.click();
		driver.switchTo().alert().accept();
	}

	public void clkAccountsWithActivity() {
		accwithAct.click();
	}

	public void clkDateField() {
		dateField.click();
	}

	public void selectCreatedDate() {
		selcreatedDate.click();
	}

	public void selectFromIcon() {
		fromIcon.click();
	}

	public void selectFromDate() throws InterruptedException {
		 waitforElement(10, todayFrom);
		//Thread.sleep(5000);
		todayFrom.click();
	}

	public void saveReport() {
		saveReport.click();
	}

	public void enterReportName(String ReportName) {
		waitforElement(10, reportName);
		reportName.sendKeys(ReportName);
	}

	public void enterReportUniqueName(String UniqueName) {
		reportUnique.click();
		reportUnique.clear();
		reportUnique.sendKeys(UniqueName);
	}

	public void saveAndRunReport() {
		waitforElement(10, saveandrun);
		saveandrun.click();
	}
	
	public void deleteReport() {
		waitforElement(10, deleteReport);
		deleteReport.click();
		driver.switchTo().alert().accept();
	}


}
