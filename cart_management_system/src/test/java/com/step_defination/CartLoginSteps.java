package com.step_defination;

import org.testng.Assert;

import com.base_class.Library;
import com.pages.CartLoginPage;
import com.pages.ViewCartPage;
import com.selenium_reuseablefunction.SeleniumUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartLoginSteps extends Library{

	 CartLoginPage cartLoginPage;
	 
	 ViewCartPage viewCartPage;
	 
	 SeleniumUtility seleniumUtility;
	    
	@Given("To launch the browser and Navigate to the Url")
	public void to_launch_the_browser_and_Navigate_to_the_Url() {
		browserSetUp();
	    logger.info("Browser Launched");
	}

	@When("To Enter Username and Password")
	public void to_Enter_Username_and_Password() {
		cartLoginPage = new CartLoginPage(driver);
		cartLoginPage.LoginUser(properties.getProperty("username"),properties.getProperty("password"));   
	    logger.info("Entered Username and Password");
	}
	

	@Then("To Click the Submit button")
	public void to_Click_the_Submit_button() {
		cartLoginPage = new CartLoginPage(driver);	
		cartLoginPage.Submit();
		  logger.info("Login Successful");
	}

	@Then("If Login fails give warning message")
	public void if_Login_fails_give_warning_message() {
		Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:4200/login");
		logger.info("Login not Successful");
	}

	@Then("To Take the Screenshot and the Title")
	public void to_Take_the_Screenshot_and_the_Title() {
		seleniumUtility = new SeleniumUtility(driver);
		seleniumUtility.to_take_screenshot("LoginPage");
		seleniumUtility.getTitle();
		logger.info("Taken Screenshot Of Login Page And Title printed in console");
	}
	
	@Then("To Click the Add To Cart Button")
	public void to_Click_the_Add_To_Cart_Button() {
		viewCartPage = new ViewCartPage(driver);	
		viewCartPage.AddToCart();
		  logger.info("Added to Cart");
	}

	@Then("To Remove the Add From Cart")
	public void to_Remove_the_Add_From_Cart() {
		viewCartPage = new ViewCartPage(driver);	
		viewCartPage.Delete();
		  logger.info("Deleted Successfully");
	}
	@Then("Close the browser")
	public void close_the_browser() {
		tearDown();
		logger.info("Browser is Closed");
	}
}

