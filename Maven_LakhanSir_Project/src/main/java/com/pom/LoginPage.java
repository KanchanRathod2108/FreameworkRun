package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="user-name")
	
	private WebElement userName;  //encapsualtion
	
	@FindBy(id="password")
	
	private WebElement passWord; //encapsualtion
	
		
	@FindBy(id="login-button")  //encapsualtion

	private WebElement login;
	
	public LoginPage(WebDriver driver){ //constructor
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnUsernameTab(String username) {
		
		userName.sendKeys(username);
	}

	public void clickOnPasswordTab(String password) {
		
		passWord.sendKeys(password);
	}
	public void clickOnLoginTab() {
		login.click();
	}

}
