package com.MS.Zeenyx.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThirtyDaysTrialRequestPage {
	
	WebDriver driver;

		public ThirtyDaysTrialRequestPage(WebDriver ldriver) {
			this.driver = ldriver;
		}

		// Firstname text field
		@FindBy(xpath = "//input[@id='FirstName']")
		WebElement Txt_FirstName;

		// Lastname text field
		@FindBy(xpath = "//input[@id='LastName']")
		WebElement Txt_LastName;

		// Company name text field
		@FindBy(xpath = "//input[@id='CompanyName']")
		WebElement Txt_CompanyName;
		
		// Email text field
		@FindBy(xpath = "//input[@id='Email']")
		WebElement Txt_Email;

		// Confirm email text field
		@FindBy(xpath = "//input[@id='ConfirmEmail']")
		WebElement Txt_ConfirmEmail;	
		
		// Request Textfield
		@FindBy(xpath = "//textarea[@id='Request']")
		WebElement Txt_Request;

		// NewsLetterRegister Check box
		@FindBy(xpath = "//*[@id='MenuBar1']/li[5]/a")
		WebElement Chk_NewsLetterRegister;

		public void AddDetailsTo30DaysTrialRequestPage(String sTxt_FirstName, String sTxt_LastName, String sTxt_CompanyName, 
				String sTxt_Email, String sTxt_ConfirmEmail, String sTxt_Request) throws InterruptedException {
			// Firstname text field
			Txt_FirstName.sendKeys(sTxt_FirstName);

			// Lastname text field
			Txt_LastName.sendKeys(sTxt_LastName);

			// Company name text field
			Txt_CompanyName.sendKeys(sTxt_CompanyName);

			// Email text field
			Txt_Email.sendKeys(sTxt_Email);

			// Confirm email text field
			Txt_ConfirmEmail.sendKeys(sTxt_ConfirmEmail);
						
			// Request Textfield
			Txt_Request.sendKeys(sTxt_Request);

			// NewsLetterRegister Check box
			Chk_NewsLetterRegister.click();

			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
						 
		}

}
