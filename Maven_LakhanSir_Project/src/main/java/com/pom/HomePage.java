package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	
	private WebElement addToCart;
	
	
	
	public HomePage(WebDriver driver){ //constructor
		PageFactory.initElements(driver, this);
		
	}
	
	 

	public void clickOnAddToCartTab() {
		addToCart.click();
	}
}
