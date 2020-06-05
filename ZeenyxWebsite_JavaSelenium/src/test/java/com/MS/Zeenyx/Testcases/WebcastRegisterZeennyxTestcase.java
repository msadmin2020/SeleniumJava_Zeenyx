package com.MS.Zeenyx.Testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.MS.Zeenyx.Pages.BaseClass;
import com.MS.Zeenyx.Pages.WebcastSignupPage;
import com.MS.Zeenyx.Pages.ZeenyxMainPage;
import com.MS.Zeenyx.Utilities.ExcelDataProvider;

public class WebcastRegisterZeennyxTestcase extends BaseClass {

	@DataProvider(name = "ReadData")
	public Object[][] GetDetails() {
		Object data[][] = null;
		try {
			data = ExcelDataProvider.ReadData("Sheet3");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Test(dataProvider = "ReadData")
	public void  WebcastRegister_ZeenyxTestcase(String sTxt_FirstName, String sTxt_LastName, String sTxt_CompanyName,
			String sTxt_Email, String sTxt_ConfirmEmail, String sTxt_Request) throws InterruptedException {
		logger = report.createTest("Register for Webcast page Zeennyx - Testcase");

		// Step1(Navigate to Register for Webcast page)
		logger.info("Navigate to Register for Webcast page");
		ZeenyxMainPage oZeenyxMainPage = PageFactory.initElements(driver, ZeenyxMainPage.class);
		logger.info("Starting Application");
		oZeenyxMainPage.NavigateToRegisterForWebcast();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.pass("Register for Webcast page opened successfully");

		// Step2(Adding details to Webcast page)
		WebcastSignupPage oWebcastSignupPage = PageFactory.initElements(driver, WebcastSignupPage.class);
		logger.info("Adding details to Webcast page");
		oWebcastSignupPage.AddDetailsToWebcastSignupPage(sTxt_FirstName, sTxt_LastName, sTxt_CompanyName, sTxt_Email,
				sTxt_ConfirmEmail, sTxt_Request);
		logger.info("Details are added to Webcast page");
		System.out.println("Details are added to Webcast page");

		System.out.println("Testcase by vidya");

	}

}
