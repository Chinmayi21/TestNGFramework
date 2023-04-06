package com.training.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.training.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	CommonUtilities common = new CommonUtilities();

	public WebDriver getDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}

	public String getUrl(String key) throws IOException {
		String getURL = common.getProperty(key);
		return getURL;
	}
	
	public void takeScreenshot(WebDriver driver, String testCaseName) throws IOException {
		TakesScreenshot screenshot = ((TakesScreenshot)driver); // typecasting the driver to screenshot

		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date currentDate = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentDate);
		
		String path = "/Users/chinmayimahishi/eclipse-ws/TestNGFramework/Screenshot/"+testCaseName+ timeStamp+".jpeg";
		
		File destFile = new File(path);
		
		FileUtils.copyFile(srcFile, destFile);
		
	}
	public void validate(String expected) {
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}
	
	public String getUsername(String key) throws IOException {
		String username = common.getProperty(key);
		return username;
	}
	
	public String getPassword(String key) throws IOException {
		String pwd = common.getProperty(key);
		return pwd;
	}
	public void popup() {
		// switch to popup window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		// click close on the pop up window
		WebElement popup = driver.findElement(By.id("tryLexDialogX"));
		popup.click();
	}
	
}
