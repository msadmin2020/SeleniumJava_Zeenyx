package com.MS.Zeenyx.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ZeenyxMainPage {
	
	WebDriver driver;

	public ZeenyxMainPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	// Contact Link
	@FindBy(xpath = "//ul[@class='navbar-nav ml-auto']//a[contains(text(),'Contact')]")
	WebElement Lnk_Contact;

	// First name text field
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement Txt_FirstName;

	// Last name text field
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement Txt_LastName;
	
	// Email text field
	@FindBy(xpath = "//input[@placeholder='Email Address']")
	WebElement Txt_Email;

	// Subject dropdown
	@FindBy(xpath = "//select[@name='input_3']")
	WebElement Dropdown_Subject;	
	
	// Message Textfield
	@FindBy(xpath = "//textarea[@placeholder='Message']")
	WebElement Txt_Message;

	

	public void RequestInfo(String sTxt_FirstName, String sTxt_LastName, String sTxt_Email, String sDropdown_Subject, String sTxt_Message) throws InterruptedException {
		
		Lnk_Contact.click();
		
		// Firstname text field
		Txt_FirstName.sendKeys(sTxt_FirstName);

		// Lastname text field
		Txt_LastName.sendKeys(sTxt_LastName);

		
		// Email text field
		Txt_Email.sendKeys(sTxt_Email);

				
		// Select the subject from dropdown
		Dropdown_Subject.click();
		Select Subject=new Select(Dropdown_Subject);
	    Subject.selectByVisibleText(sDropdown_Subject);
	    
	    // Message text field
	    Txt_Message.sendKeys(sTxt_Message);	

		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
					 
	}


}
