package com.MS.Zeenyx.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ZeenyxMainPage {

	WebDriver driver;

	public ZeenyxMainPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//*[@id='MenuBar1']/li[5]/a")
	WebElement MItm_Contact;

	@FindBy(linkText = "Info Request")
	WebElement Itm_InfoRequest;

	public void NavigateToInfoRequestPage() throws InterruptedException {
		
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Contact from menu item
		Actions action = new Actions(driver);
		action.moveToElement(MItm_Contact).perform();

		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Info request menu item
		Itm_InfoRequest.click();
	}

	// Features from menu item
	@FindBy(xpath = "//a[contains(text(),'FEATURES')]")
	WebElement MItm_Features;

	// Ascential test item
	@FindBy(linkText = "AscentialTest")
	WebElement Itm_InfoAboutAT;

	public void NavigateToInfoAboutATPage() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		action.moveToElement(MItm_Features).perform();
		
		Itm_InfoAboutAT.click();

	}

	// Company from menu item
	@FindBy(xpath = "//a[contains(text(),'COMPANY')]")
	WebElement MItm_Company;

	// News and Interest menu item
	@FindBy(linkText = "News and Interest")
	WebElement Itm_NewsAndInterest;

	// 30 days trial link box
	@FindBy(xpath = "//div[@id='apDiv16']//a//img")
	WebElement Lnk_30DaysTrial;

	public void NavigateTo30DaysTrialDataPage() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Contact from menu item
		Actions action = new Actions(driver);
		action.moveToElement(MItm_Company).perform();

		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Info request menu item
		Itm_NewsAndInterest.click();
		
		Lnk_30DaysTrial.click();
	}

	// Webcast menu item
	@FindBy(xpath = "//a[contains(text(),'Webcast')]")
	WebElement Itm_Webcast;

	// Register for the next webcast
	@FindBy(xpath = "//div[@id='apDiv12']//a//img")
	WebElement Lnk_RegisterForWebcast;

	public void NavigateToRegisterForWebcast() throws InterruptedException {
		
		// Company from menu item
		Actions action = new Actions(driver);
		action.moveToElement(MItm_Company).perform();
		
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Webcast menu item
		Itm_Webcast.click();
		
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		// Register for the next webcast
		Lnk_RegisterForWebcast.click();

	}

}
