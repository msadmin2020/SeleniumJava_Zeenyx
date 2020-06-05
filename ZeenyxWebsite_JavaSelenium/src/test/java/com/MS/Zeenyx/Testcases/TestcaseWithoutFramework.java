package com.MS.Zeenyx.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestcaseWithoutFramework {
	
	@Test
	public static void ZeennyxInfoAboutATTestcase_JavaSele() throws Exception {

		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();

		// Navigate to naukri website
		driver.get("https://www.zeenyx.com/");

		System.out.println("Zeenyx Website is displayed!");

		// Maximize the window
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		 //Company from menu item
       
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'FEATURES')]"))).perform();

        //News and Interest menu item
        driver.findElement(By.linkText("AscentialTest")).click();


        //About Ascential test
        driver.findElement(By.xpath("//a[contains(text(),'about how AscentialTest increases software')]")).click();

        String sText = driver.findElement(By.xpath("//div[@id='TopContent']")).getText();

    	System.out.println(sText);

		Thread.sleep(3000);
		
		System.out.println("Zeennyx Info About AT Testcase is passed!!!!");

		//driver.quit();

	}

}
