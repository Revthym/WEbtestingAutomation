package com.SignUp.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
		File src = new File("./ConfigurationFiles/config.properties");
		try{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is"+ e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("URL");
		return url;
	}
	
	public String getChromePath()
	{
		String Chromepath = pro.getProperty("chromepath");
		return Chromepath;
	}
	public String getFireFoxPath()
	{
		String FirefoxPath = pro.getProperty("firefoxpath");
		return FirefoxPath;
	}
}
