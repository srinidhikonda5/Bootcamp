package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartLoginPage {

	public CartLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-login/div/div/form/div[1]/input")
	WebElement usernameText;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-login/div/div/form/div[2]/input")
	WebElement userPassText;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-login/div/div/form/button")
	WebElement loginButton;
	
	public void LoginUser(String username, String password)
	{
		usernameText.sendKeys(username);
		userPassText.sendKeys(password);
	}
	
	public void Submit()
	{
		loginButton.click();
	}
	
	
}


