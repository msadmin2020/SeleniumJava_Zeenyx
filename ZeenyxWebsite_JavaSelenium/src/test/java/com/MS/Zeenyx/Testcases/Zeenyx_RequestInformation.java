package com.MS.Zeenyx.Testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.MS.Zeenyx.Pages.BaseClass;
import com.MS.Zeenyx.Pages.ZeenyxMainPage;
import com.MS.Zeenyx.Utilities.ExcelDataProvider;


public class Zeenyx_RequestInformation extends BaseClass {

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
	public void ZeenyxTestcase(String sTxt_FirstName, String sTxt_LastName, String sTxt_Email, String sDropdown_Subject, String sTxt_Message) throws InterruptedException {
		logger = report.createTest("Zeenyx request tool information - Testcase");

		ZeenyxMainPage Infodetails= PageFactory.initElements(driver, ZeenyxMainPage.class);
		logger.info("Starting Application");
		Infodetails.RequestInfo(sTxt_FirstName, sTxt_LastName, sTxt_Email, sDropdown_Subject, sTxt_Message);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Details are added to request tool information.");
		System.out.println("Details are added to request tool information.");

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	}

}
