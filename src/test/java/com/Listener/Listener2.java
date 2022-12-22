package com.Listener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Resources.BaseClass;
import com.Utility.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

		public class Listener2 extends BaseClass implements ITestListener 
		{
			//public WebDriver  driver;
			WebDriver  driver=null;
		ExtentReports exReports = ExtentReport.getExtentReport();

			

			ExtentTest exTest;
			ThreadLocal<ExtentTest> extenttestThread = new ThreadLocal<ExtentTest>();
			
			
			public void onTestStart(ITestResult result) {
				
		String testName=result.getName();
				 exTest = exReports.createTest(testName+"Excecution Started");
				 extenttestThread.set(exTest);
			}

			public void onTestSuccess(ITestResult result) {
				// TODO Auto-generated method stub
				String testName=result.getName();
				//exTest.log(Status.PASS,testName+"got passed");
				extenttestThread.get().log(Status.PASS,testName+"got passed");
			}

			public void onTestFailure(ITestResult result) {
				// TODO Auto-generated method stub
				driver=null;
				String testMethod=result.getName();
				exTest.fail(result.getThrowable());
				//extenttestThread.get().fail(result.getThrowable());
				
				try {
						driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
				
				try {
					String screenshotFilepath=takesScreenshot(testMethod,driver);
					//extenttestThread.get().addScreenCaptureFromPath(screenshotFilepath,testMethod);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}

			public void onTestSkipped(ITestResult result) {
				// TODO Auto-generated method stub
				
			}

			public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
				// TODO Auto-generated method stub
				
			}

			public void onTestFailedWithTimeout(ITestResult result) {
				// TODO Auto-generated method stub
				
			}

			public void onStart(ITestContext context) {
				// TODO Auto-generated method stub
				
			}

			public void onFinish(ITestContext context) {
				// TODO Auto-generated method stub
				exReports.flush();
			}


	}


