package com.MS.Zeenyx.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MS.Zeenyx.Pages.BaseClass;
import com.MS.Zeenyx.Pages.ThirtyDaysTrialRequestPage;
import com.MS.Zeenyx.Pages.ZeenyxMainPage;
import com.MS.Zeenyx.Utilities.ExcelDataProvider;

public class TrialReqForATZeennyxTestcase extends BaseClass {
	
	@DataProvider(name="ReadData")
	public Object[][] GetDetails()
	{
		Object data[][]=null;
		try {
			data = ExcelDataProvider.ReadData("Sheet2");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider="ReadData")
	public void TrialReqForAT_ZeennyxTestcase(String sTxt_FirstName, String sTxt_LastName, String sTxt_CompanyName, 
			String sTxt_Email,String sTxt_ConfirmEmail, String sTxt_Request) throws InterruptedException 
	{
		logger=report.createTest("30 Trial Re qFor AT Zeennyx - Testcase");
		
		// Step1(Navigate to Info request page)
		logger.info("Navigate to Info request page");	
		ZeenyxMainPage oZeenyxMainPage = PageFactory.initElements(driver, ZeenyxMainPage.class);
		logger.info("Starting Application");
		oZeenyxMainPage.NavigateTo30DaysTrialDataPage();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.pass("30 days trial request page opened successfully");
		
		// Step2(Adding details to 30 days trial request page)
		ThirtyDaysTrialRequestPage oThirtyDaysTrialRequestPage =PageFactory.initElements(driver, ThirtyDaysTrialRequestPage.class);		
		logger.info("Adding details to 30 days trial request page");		
		oThirtyDaysTrialRequestPage.AddDetailsTo30DaysTrialRequestPage(sTxt_FirstName, sTxt_LastName, sTxt_CompanyName,
			sTxt_Email, sTxt_ConfirmEmail, sTxt_Request);		
		logger.info("Details are added to  30 days trial request page");
		System.out.println("Details are added to  30 days trial request page");
				
		System.out.println("Testcase by vidya");

	}

}
