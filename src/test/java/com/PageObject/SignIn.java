package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn
{


	WebDriver driver;
	public  SignIn(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]")
	WebElement accountList;
	
	
 
	@FindBy(xpath="//*[@id=\"ap_email\"]")
	WebElement phonfield;
	

	@FindBy(xpath="//input[@id='continue']")
	WebElement continuebutton;
	
	public WebElement getAccountList()
	{
		return accountList;
	}


	public WebElement getPhonfield() 
	{
		return phonfield;
	}


	public WebElement getContinuebutton() 
	{
		return continuebutton;
	}
	

}
