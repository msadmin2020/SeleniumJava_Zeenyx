package com.MS.Zeenyx.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfoAboutATPage {

	WebDriver driver;

	public InfoAboutATPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	// About Ascential test
	@FindBy(xpath = "//a[contains(text(),'about how AscentialTest increases software')]")
	WebElement MItm_Ascentialtest;

	@FindBy(xpath = "//div[@id='TopContent']")
	WebElement Txt_InfoContentOfAT;

	public void GetInfoContentsOfAT() throws InterruptedException {
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MItm_Ascentialtest.click();

		String sText = Txt_InfoContentOfAT.getText();

		System.out.println(sText);

		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

}
