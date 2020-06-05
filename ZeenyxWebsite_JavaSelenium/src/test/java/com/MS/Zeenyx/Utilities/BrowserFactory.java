package com.MS.Zeenyx.Utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {	
	//***************************************APP STATE ONSTART***************************************
		public static WebDriver OnStart(WebDriver driver, String BrowserName, String AppURL) {

			if (BrowserName.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if (BrowserName.equals("Firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} 
			else if (BrowserName.equals("IE")) 
			{
				System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			else 
			{
				System.out.println("We do not support this browser");
			}

			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(AppURL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			return driver;
		}	
	//***************************************APP STATE ONFINISH***************************************
		public static void OnFinish(WebDriver driver)
		{
			//driver.close();
			driver.quit();
		}		
		
	}


