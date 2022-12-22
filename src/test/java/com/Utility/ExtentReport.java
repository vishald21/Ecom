package com.Utility;
import com.Resources.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReport extends BaseClass
{
static ExtentReports extentReport;
	
	public static ExtentReports getExtentReport()
	{
		
		String extentReportpath = System.getProperty("user.dir")+"\\Report\\Report.html";
		
		ExtentSparkReporter report=new ExtentSparkReporter("Report");
		
		report.config().setReportName("EcomReport");
		report.config().setDocumentTitle("TestResult");
	
	     extentReport=new ExtentReports();
	     extentReport.attachReporter(report);
	     extentReport.setSystemInfo("operatingSystem","window10");
	     extentReport.setSystemInfo("tested by","Dinesh");
		return extentReport;
	}
}