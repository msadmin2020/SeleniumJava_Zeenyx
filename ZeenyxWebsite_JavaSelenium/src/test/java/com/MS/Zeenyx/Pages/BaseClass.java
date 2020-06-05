package com.MS.Zeenyx.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

import com.MS.Zeenyx.Utilities.BrowserFactory;
import com.MS.Zeenyx.Utilities.ConfigDataProvider;
import com.MS.Zeenyx.Utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	//Global variables
		public WebDriver driver;
	    //public ExcelDataProvider excel;
		public ConfigDataProvider config;
		public ExtentReports report;
		public ExtentTest logger;
		
		//**************Fetching data from config file and excel**********************************
		@BeforeSuite
		public void SetUpSuite()
		{
			
			Reporter.log("Setting up reports and test is getting ready", true);
			
			//excel=new ExcelDataProvider();
			config=new ConfigDataProvider();
			
			//**********To get report**********************************************************************************************
			//ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ZeenyxWebsite"+Helper.GetCurrentDateTime()+".html"));
			ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ZeenyxWebsite.html"));
			report=new ExtentReports();
			report.attachReporter(extent);
			
			report.setSystemInfo("Hostname", "LocalHost");
			report.setSystemInfo("System", "MSDES13");
			report.setSystemInfo("OS", "Windows10");
			report.setSystemInfo("Tester", "Vidya");
			report.setSystemInfo("Browser", "Firefox");
			report.setSystemInfo("Environment", "QA");
			
			
			Reporter.log("Setting done- Test can be started", true);
			
		}
		
		//***************************************APP STATE ONSTART***************************************
		@BeforeClass
		public void AppOnStart()
		{
	        driver=BrowserFactory.OnStart(driver, config.GetBrowser(), config.GetStagingURL());
		}

		//***************************************APP STATE ONFINISH***************************************
		@AfterClass
		public void AppOnFinish()
		{
			BrowserFactory.OnFinish(driver);
		}
		
		//*******************Capture Snapshot if testcase is Failure or success***********************************
		@AfterMethod
		public void CaptureSnapshot(ITestResult result) throws IOException
		{
			Reporter.log("Test is about to end", true);
			
			if(result.getStatus()==ITestResult.SUCCESS)
			{
				//Helper.CaptureScrrenshot(driver);//Capture Snapshot 
				
				//*****Attaching snapshot to the report*********************************************************************************
				logger.pass("Test passed " , MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScrrenshot(driver)).build());
			} 
			else if(result.getStatus()==ITestResult.FAILURE)
			{
				//*****Attaching snapshot to the report*********************************************************************************
				logger.fail("Test failed " , MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScrrenshot(driver)).build());
			}
			
			report.flush();
			
			Reporter.log("Test Completed >>>> Reports Generated", true);
			
			Helper.SendMailandAttachReport();
			}

}
