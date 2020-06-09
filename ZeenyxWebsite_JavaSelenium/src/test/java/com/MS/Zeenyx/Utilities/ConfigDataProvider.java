package com.MS.Zeenyx.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
Properties pro;
	
	public ConfigDataProvider()
	{
		
		File src=new File("./Config/Config.properties");
		
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			pro=new Properties();
			
			pro.load(fis);
			
		} catch (Exception e) {
		
			System.out.println("Not able to load config file >>"+e.getMessage());
		}
	}

	public String GetExcelPath(String Excelpath)
	{
		return pro.getProperty("ExcelPath");
	}
	
	public String GetBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String GetURL()
	{
		return pro.getProperty("Url");
	}

}
