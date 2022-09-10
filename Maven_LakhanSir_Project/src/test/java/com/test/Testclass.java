package com.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.Base;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.utility.Utility;

public class Testclass extends Base { // Inheritance 
	
	WebDriver driver;
	LoginPage pageLogin;
	
	@BeforeClass
	
	@Parameters("browser")//cross browsing in framework is done with the help of parameter anotation
	
	public void lunchBrowser(String browser) throws InterruptedException {
		
		if(browser.equals("chrome")) 
		
		{
		 driver =Base.openChromeBrowser();
		}
		
		else if(browser.equals("edge"))
		{
			
			driver =Base.openEdgeBrowser();
		}
		
		
		 driver.get("https://www.saucedemo.com/");
		 
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
	}
	@BeforeMethod
	
	public void verifyLoginPage() throws InterruptedException, EncryptedDocumentException, IOException {
		
		LoginPage pageLogin = new LoginPage(driver);
		
		String username = Utility.getDataFromDataSheet(1, 1);
		pageLogin.clickOnUsernameTab(username);
		
		
		String password=Utility.getDataFromDataSheet(2, 1);
		pageLogin.clickOnPasswordTab(password);
		
		
		pageLogin.clickOnLoginTab();
		
		Thread.sleep(2000);
		
	}
	
	@Test
	
	public void verifyAddToCartTab() throws InterruptedException { //Testcase
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAddToCartTab();
		String Url=driver.getCurrentUrl();
		
		Assert.assertEquals(Url, "https://www.saucedemo.com/inventory.html");
		Thread.sleep(2000);
	   }
	
	@AfterMethod
	
		public void verifySignOut(ITestResult result) throws IOException { //signout from page
			
		//if(ITestResult.FAILURE==result.getStatus()) //if testcase fail then screenshot will be taken .
		if(ITestResult.SUCCESS==result.getStatus())  //if testcase pass then only screenshot will be taken.
		{
		
			Utility.getScreenshot(driver);
	}
			driver.close();
			
		}
	
}

