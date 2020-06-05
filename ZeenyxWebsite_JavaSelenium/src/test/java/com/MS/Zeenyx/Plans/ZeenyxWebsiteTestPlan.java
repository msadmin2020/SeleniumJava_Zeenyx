package com.MS.Zeenyx.Plans;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MS.Zeenyx.Pages.BaseClass;
import com.MS.Zeenyx.Pages.BaseClass2;
import com.MS.Zeenyx.Pages.InfoAboutATPage;
import com.MS.Zeenyx.Pages.ThirtyDaysTrialRequestPage;
import com.MS.Zeenyx.Pages.WebcastSignupPage;
import com.MS.Zeenyx.Pages.ZeenyxInfoRequestPage;
import com.MS.Zeenyx.Pages.ZeenyxMainPage;
import com.MS.Zeenyx.Utilities.ExcelDataProvider;

public class ZeenyxWebsiteTestPlan extends BaseClass2 {
			
	@DataProvider(name="ReadData")
	public Object[][] GetDetails()
	{
		Object data[][]=null;
		try {
			data = ExcelDataProvider.ReadData("Sheet1");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider="ReadData")
	public void InfoRequest_ZeenyxTestcase(String sTxt_FirstName, String sTxt_LastName, String sTxt_CompanyName, String sTxt_Address1, 
			String sTxt_Address2, String sTxt_City, String sPop_State,String sTxt_Email, 
			String sTxt_ConfirmEmail, String sTxt_Request) throws InterruptedException 
	{
		logger=report.createTest("Info Request about AT tool - Testcase");
		
		// Step1(Navigate to Info request page)
		logger.info("navigating to Info request page");	
		ZeenyxMainPage oZeenyxMainPage = PageFactory.initElements(driver, ZeenyxMainPage.class);
		logger.info("Starting Application");
		oZeenyxMainPage.NavigateToInfoRequestPage();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.pass("Info request page opened successfully");
		
		// Step2(Adding details to Info request page)
		ZeenyxInfoRequestPage oZeenyxInfoRequestPage =PageFactory.initElements(driver, ZeenyxInfoRequestPage.class);		
		logger.info("Adding details to info request page");		
		oZeenyxInfoRequestPage.AddDetailsToInfoRequestPage(sTxt_FirstName, sTxt_LastName, sTxt_CompanyName, sTxt_Address1, sTxt_Address2, sTxt_City,
				sPop_State, sTxt_Email, sTxt_ConfirmEmail, sTxt_Request);		
		logger.info("Details are added to Info request page");
		System.out.println("Details are added to Info request page");
				
		System.out.println("Testcase by vidya");

	}
	
	
	

}
