package com.MS.Zeenyx.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.MS.Zeenyx.Pages.BaseClass;
import com.MS.Zeenyx.Pages.InfoAboutATPage;
import com.MS.Zeenyx.Pages.ZeenyxMainPage;

public class InfoAboutATZeennyxTestcase extends BaseClass {
	
	@Test
	public void InfoAboutAT_ZeenyxTestcase() throws InterruptedException 
	{
		logger=report.createTest("Info content of AT tool - Testcase");
		
		// Step1(Navigate to Info about AT page)
		logger.info("Navigating to Info about AT page");	
		ZeenyxMainPage oZeenyxMainPage = PageFactory.initElements(driver, ZeenyxMainPage.class);
		logger.info("Starting Application");
		oZeenyxMainPage.NavigateToInfoAboutATPage();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.pass("Info about AT page opened successfully");
		
		// Step2(Getting details contents about AT)
		InfoAboutATPage oInfoAboutATPage =PageFactory.initElements(driver, InfoAboutATPage.class);		
		logger.info("Getting content of AT info");		
		oInfoAboutATPage.GetInfoContentsOfAT();		
		logger.info("Contents of AT ptinted succesfully");
		System.out.println("Contents of AT ptinted succesfully");
				
		System.out.println("Testcase by vidya");

	}
}
