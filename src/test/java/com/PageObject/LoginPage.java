package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"Email\"]")
	WebElement emailfield;
	
	@FindBy(xpath="//*[@id=\"Password\"]")
	WebElement passwordfield;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement Loginbutton;
	public WebElement getEmailfield()
	{
		return emailfield;
	}

	public WebElement getPasswordfield()
	{
		return passwordfield;
	}

	public WebElement getLoginbutton() 
	{
		return Loginbutton;
	}
	
	 
	
}
