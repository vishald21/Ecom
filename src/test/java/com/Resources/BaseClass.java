package com.Resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public Properties pro;
	public WebDriver driver;
//	public String password1=pro.getProperty("password");
  // @BeforeMethod
	public  WebDriver initiliseDriver() throws IOException   
	{
		 pro=new Properties();
		 String path=System.getProperty("user.dir")+"./Configuration/Config.properties";
		//File path=new File("/FrameWork02/src/main/java/resources/configProperties/config.properties");    
		 FileInputStream file1=new FileInputStream(path);	
		 pro.load(file1); 
	     //String Browsername="chrome";
	     String Browsername=pro.getProperty("browser");
	     if(Browsername.equalsIgnoreCase("Chrome"))
	{
	
	     WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	
	     }else if(Browsername.equalsIgnoreCase("edge"))
	     {
		
		     WebDriverManager.edgedriver().setup();
		     driver=new EdgeDriver();
		
		         }else if(Browsername.equalsIgnoreCase("firefox"))
		         {
			
			        WebDriverManager.firefoxdriver().setup();
			        driver=new FirefoxDriver();
			
			       }

    else if(Browsername.equalsIgnoreCase("IE"))
    {

       WebDriverManager.iedriver().setup();
       driver=new InternetExplorerDriver();

      }

        //driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
public String takesScreenshot(String testName,WebDriver driver) throws IOException
{		
		File s=(File)((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String d = System.getProperty("user.dir")+"\\Screenshot\\"+testName+".png";
		FileUtils.copyFile(s, new File(d));
		return d;	
}
	    @AfterMethod
		public  void closedriver() 
	    {
			driver.quit();;
			
			
	 }

}
