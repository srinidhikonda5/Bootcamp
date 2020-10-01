package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartPage {

	public ViewCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-view-products/div/table/tbody/tr[2]/td[11]/img")
	WebElement AddToCartButton;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-view-cart/body/div/table/tbody/tr[3]/td[12]/button")
	WebElement RemoveButton;
	
	
	public void AddToCart()
	{
		AddToCartButton.click();
	}
	
	public void Delete()
	{
		RemoveButton.click();
	}
	
	
}



