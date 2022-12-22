package com.TestJava;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.PageObject.LoginPage;
import com.PageObject.SignIn;
import com.Resources.BaseClass;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class TC_LoginPG extends BaseClass
{
	WebDriver driver;
	@Test
	public void loginpagetest() throws IOException, InterruptedException
	{
     driver=initiliseDriver();
  	 driver.get(pro.getProperty("baseurl"));
	 LoginPage lpage=new LoginPage(driver);
	 lpage.getEmailfield().sendKeys(pro.getProperty("email"));
	 lpage.getPasswordfield().sendKeys(pro.getProperty("password"));
     lpage.getLoginbutton().click();
	}
	@Test
	public void signInTest() throws IOException, InterruptedException
	{
     driver=initiliseDriver();
     driver.get(pro.getProperty("url"));
     SignIn si=new SignIn(driver);
    si.getAccountList().click();
    si.getPhonfield().sendKeys(pro.getProperty("phone"));
	 si.getContinuebutton().click();
	}

}
