package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.training.base.BasePage;

public class LoginPage extends BasePage {

// We need driver to find the elements
	public LoginPage(WebDriver driver) {
		super(driver); // We are passing the driver to the base page
	}

	// 1. Find all the elements related to login page
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "Login")
	WebElement loginbutton;

	@FindBy(name = "rememberUn")
	WebElement checkbox;

	@FindBy(id = "userNav")
	WebElement option;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;

	@FindBy(id = "forgot_password_link")
	WebElement link;

	@FindBy(id = "un")
	WebElement forgotname;

	@FindBy(id = "continue")
	WebElement continuebtn;

	@FindBy(id ="idcard-identity")
	WebElement logoutusername;
	
	@FindBy(id = "error")
	WebElement error;
	
	@FindBy(id= "//title[text() ='Login | Salesforce']")
	WebElement titleName;
	
	// 2. Write the methods for all the elements
	public void username(String userName) {
		username.sendKeys(userName);
	}

	public void password(String Pwd) {
		password.sendKeys(Pwd);
	}

	public void clearPwd() {
		password.clear();
	}

	public void login() {
		loginbutton.click();
	}

	public void rememberMe() {
		checkbox.click();
	}

	public void usernameDropDown() {
		option.click();
	}

	public void logout() {
		logout.click();
	}

	public void forgotpwd() {
		link.click();
	}

	public void forgotpwdpage() {
		forgotname.sendKeys("chinmayi@tek.com");
	}

	public void continueBtn() {
		continuebtn.click();
	}

	public void enterPwdMsg(String expectedMsg) {
		String errorMsg = error.getText();
		Assert.assertEquals(errorMsg, expectedMsg);
	}

	public void validateUsrname(String expectedMsg) throws InterruptedException {
		Thread.sleep(3000);
		String ActualMsg = logoutusername.getText();
		//waitforElement(10,logoutusername);
		Assert.assertEquals(ActualMsg, expectedMsg);
	}

	public void loginErrorMsg() {
		String ExpectedMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		waitforElement(10,error);
		String ActualMsg = error.getText();

		Assert.assertEquals(ActualMsg, ExpectedMsg);
	}
}
