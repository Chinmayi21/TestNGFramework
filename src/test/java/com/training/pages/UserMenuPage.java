package com.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class UserMenuPage extends BasePage {

	public UserMenuPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "userNav")
	WebElement usermenu;

	@FindBy(xpath = "//a[text() = 'Developer Console']")
	WebElement devcon;

	@FindBy(xpath = "//a[text()='My Profile']")
	WebElement myprofile;

	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	WebElement editbtn;

	@FindBy(id = "contactInfoContentId")
	WebElement tabFrame;

	@FindBy(id = "aboutTab")
	WebElement aboutTab;

	@FindBy(id = "lastName")
	WebElement lastname;

	@FindBy(xpath = "//input[@class='zen-btn zen-primaryBtn zen-pas']")
	WebElement save;

	@FindBy(id = "publisherAttachTextPost")
	WebElement postlink;

	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement textFrame;

	@FindBy(xpath = "//body[contains(text(),'Share')]")
	WebElement write;

	@FindBy(xpath = "//input[@title='Share']")
	WebElement shareBtn;

	@FindBy(id = "publisherAttachContentPost")
	WebElement filelink;

	@FindBy(id = "chatterUploadFileAction")
	WebElement upload;

	@FindBy(id = "chatterFile")
	WebElement choose;

	@FindBy(id = "publishersharebutton")
	WebElement shareFile;

	@FindBy(id = "displayBadge")
	WebElement hover;

	@FindBy(id = "uploadLink")
	WebElement uploadPic;

	@FindBy(id = "uploadPhotoContentId")
	WebElement photoFrame;

	@FindBy(xpath = "//input[@class='fileInput']")
	WebElement choosePic;

	@FindBy(id = "j_id0:uploadFileForm:uploadBtn")
	WebElement savePic;

	@FindBy(xpath = "//div[@class='imgCrop_handle imgCrop_handleSE']")
	WebElement cropPt1;

	@FindBy(xpath = "//div[@class='imgCrop_handle imgCrop_handleNE']")
	WebElement cropPt2;

	@FindBy(id = "j_id0:j_id7:save")
	WebElement savePhoto;

	@FindBy(xpath = "//a[text() = 'My Settings']")
	WebElement mysettings;

	@FindBy(id = "PersonalInfo_font")
	WebElement personalLink;

	@FindBy(id = "LoginHistory_font")
	WebElement loginhis;

	@FindBy(xpath = "//a[contains(text(),'Download login history')]")
	WebElement downloadHis;

	@FindBy(id = "DisplayAndLayout_font")
	WebElement displayAndLayout;

	@FindBy(id = "CustomizeTabs_font")
	WebElement customizeTabs;

	@FindBy(id = "p4")
	WebElement customApp;

	@FindBy(xpath = "//option[@value='report']")
	WebElement report;

	@FindBy(id = "duel_select_0_right")
	WebElement add;

	@FindBy(name = "save")
	WebElement saveTab;

	@FindBy(id = "tsid-arrow")
	WebElement pageDD;

	@FindBy(id = "tabBar")
	List<WebElement> tabs; // To get list of elements, use List

	@FindBy(xpath = "//a[text()='Salesforce Chatter']")
	WebElement saleschatterDD;

	@FindBy(xpath = "//a[text()='Marketing']")
	WebElement marketingDD;

	@FindBy(id = "tryLexDialogX")
	WebElement popup;

	@FindBy(id = "EmailSetup_font")
	WebElement email;

	@FindBy(id = "EmailSettings_font")
	WebElement emailSettings;

	@FindBy(id = "sender_name")
	WebElement name;

	@FindBy(id = "sender_email")
	WebElement emailid;

	@FindBy(id = "auto_bcc1")
	WebElement radioBtn;

	@FindBy(name = "save")
	WebElement saveEmail;

	@FindBy(id = "CalendarAndReminders_font")
	WebElement calandrem;

	@FindBy(id = "Reminders_font")
	WebElement activityRem;

	@FindBy(id = "testbtn")
	WebElement testRem;

	@FindBy(xpath = "//span[text() ='Start Time: ']")
	WebElement remTab;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;
	
	public void userMenuDD() {
		usermenu.click();
	}

	public void userMenuDDList() {

	}

	public void DevConsole() {
		devcon.click();
	}

	public void closeDevConsole() {
		String homeWindow = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		driver.close();
		driver.switchTo().window(homeWindow);
	}

	public void myProfile() {
		myprofile.click();
	}

	public void editBtn() throws InterruptedException {
		// waitforElement(10, myprofile);
		Thread.sleep(3000);
		editbtn.click();
	}

	public void switchFrame() {
		driver.switchTo().frame(tabFrame);
	}

	public void AboutTab() {
		aboutTab.click();
	}

	public void clrLastname() {
		lastname.clear();
	}

	public void enterLastname(String lname) {
		lastname.sendKeys(lname);
	}

	public void saveBtn() {
		save.click();
	}

	public void clickPostLink() {
		postlink.click();
	}

	public void switchToFrame() {
		driver.switchTo().frame(textFrame);
	}

	public void postOnWall() {
		write.sendKeys("This is in TestNG Framework !");
	}

	public void Share() {
		driver.switchTo().parentFrame();
		shareBtn.click();
	}

	public void clickFileLink() {
		filelink.click();
	}

	public void clickUpload() {
		upload.click();
	}

	public void chooseFile() {
		choose.sendKeys("/Users/chinmayimahishi/Desktop/Testing.pages");
	}

	public void shareFile() {
		shareFile.click();
	}

	public void Hover() {
		Actions action = new Actions(driver);
		action.moveToElement(hover).build().perform();
	}

	public void uploadPhoto() {
		waitforElement(10, uploadPic);
		uploadPic.click();
	}

	public void switchToFramePic() {
		driver.switchTo().frame(photoFrame);
	}

	public void uploadPic() throws InterruptedException {
		choosePic.sendKeys("/Users/chinmayimahishi/Desktop/Test Case/blue-columbine-flower.jpg");
	}

	public void savePic() throws InterruptedException {
		savePic.click();
	}

	public void crop1() {
		Actions action = new Actions(driver);
		action.clickAndHold(cropPt1).moveByOffset(20, 40).build().perform();
	}

	public void crop2() {
		Actions action = new Actions(driver);
		action.clickAndHold(cropPt2).moveByOffset(20, 40).build().perform();
	}

	public void savePhoto() {
		savePhoto.click();
	}

	public void mySettings() {
		mysettings.click();
	}

	public void clkPersonalLink() {
		waitforElement(10, personalLink);
		personalLink.click();
	}

	public void clkLoignHis() {
		loginhis.click();
	}

	public void downloadLoginHistory() {
		downloadHis.click();
	}

	public void clkDisplayandLayout() {
		waitforElement(10, displayAndLayout);
		displayAndLayout.click();
	}

	public void clkCustomizeTab() {
		customizeTabs.click();
	}

	public void customAppDD() {
		Select dropdown = new Select(customApp);
		dropdown.selectByVisibleText("Salesforce Chatter");
	}

	public void selReport() {
		report.click();
	}

	public void addBtn() {
		add.click();
	}

	public void saveTab() throws InterruptedException {
		saveTab.click();
	}

	public void validateTab(String tabName) {
		pageDD.click();
		for (WebElement tabname : tabs) {
			System.out.println(tabname.getText());
			if (tabname.getText().contains(tabName)) {
				System.out.println(tabname.getText() + " is found in Sales");
			} else
				System.out.println("Not Found in Sales page!");
		}
	}

	public void validateinSalesChatter() {
		pageDD.click();
		waitforElement(10, saleschatterDD);
		saleschatterDD.click();
		for (WebElement tabname : tabs) {
			System.out.println(tabname.getText());
			if (tabname.getText().contains("Reports")) {
				System.out.println("Report tab is found in SalesForceChatter ");
			} else
				System.out.println("Not Found in SalesForceChatter page!");
		}
	}

	public void validateinMarketing() {
		pageDD.click();
		waitforElement(10, marketingDD);
		marketingDD.click();
		for (WebElement tabname : tabs) {
			System.out.println(tabname.getText());
			if (tabname.getText().contains("Reports")) {
				System.out.println("Report tab is found in Marketing");
			} else
				System.out.println("Not Found in Marketing page!");
		}
	}

	public void closePopup() {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		waitforElement(10, popup);
		popup.click();
	}

	public void clkEmail() {
		waitforElement(10, email);
		email.click();
	}

	public void clkEmailSettings() {
		emailSettings.click();
	}

	public void enterName(String Name) {
		waitforElement(10, name);
		name.clear();
		name.sendKeys(Name);
	}

	public void enterEmail(String emailId) {
		emailid.clear();
		emailid.sendKeys(emailId);
	}

	public void clkAutomaticBcc() {
		radioBtn.click();
	}

	public void saveEmailSettings() {
		saveEmail.click();
		driver.switchTo().alert().accept();
	}

	public void clkCalenderAndReminder() {
		waitforElement(10, calandrem);
		calandrem.click();
	}

	public void clkActivityReminder() {
		waitforElement(10, activityRem);
		activityRem.click();
	}

	public void openTestReminder() throws InterruptedException {
		Thread.sleep(2000);
		waitforElement(10, testRem);
		testRem.click();
	}

	public void validatePopUp() {
		for(String handle: driver.getWindowHandles() ) {
			driver.switchTo().window(handle);
		}
		String Expectedmsg = "Start Time:";
		String ActualMsg = remTab.getText();

		Assert.assertEquals(ActualMsg, Expectedmsg);
	}

	public void logout() {
		logout.click();
	}

}
