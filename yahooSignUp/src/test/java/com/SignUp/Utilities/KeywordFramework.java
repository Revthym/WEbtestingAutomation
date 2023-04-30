package com.SignUp.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class KeywordFramework {
	static WebDriver driver;
	
	
	public static void LaunchBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
	}
	
    public static void Launchurl(String url) throws IOException
    {
    	try {
    	driver.get(url);}
    	catch(NoSuchElementException e)
    	{
    		System.out.println(e);
    		Screenshot();
    	}
    }
    public static void TextboxbyXpath(String id, String value) throws IOException
    { 
    	try {
    	driver.findElement(By.xpath(id)).sendKeys(value);}
    catch(NoSuchElementException e)
    {
    	System.out.println(e);
    	Screenshot();
    }
    }
    public static void TextboxbyName(String id, String value) throws IOException
    {
    	try {
    	driver.findElement(By.name(id)).sendKeys(value);}
    	catch (NoSuchElementException e) {
    		Screenshot();
    		System.out.println(e);
    	}
    }
    public static void TextboxbyId(String id, String value) throws IOException
    {
    	try {
    	driver.findElement(By.id(id)).sendKeys(value);}
    	catch(NoSuchElementException e) {
    		Screenshot();
    		System.out.println(e);
    	}
    }
  /*  public static void TextboxbyId(String id, int value) throws IOException
    {
    	try {
    	driver.findElement(By.id(id)).sendKeys(value);}
    	catch(NoSuchElementException e) {
    		Screenshot();
    		System.out.println(e);
    	}
    }*/
    public static void TextboxbyLinkText(String id, String value) throws IOException
    {
    	try {
    		driver.findElement(By.linkText(id)).sendKeys(value);}
    	catch(NoSuchElementException e) {
    		Screenshot();
    		System.out.println(e);
    	}
    }
    public static void ButtonbyXpath(String id) throws IOException
    {;
    	try {
    	driver.findElement(By.xpath(id)).click();}
    	catch(NoSuchElementException e) {
    		Screenshot();
    		System.out.println(e);
    		
    	}
    }
    public static void ButtonbyName(String id) throws IOException
    {
    	try {
    	driver.findElement(By.name(id)).click();}
    	catch(NoSuchElementException e) {
    		Screenshot();
    		System.out.println(e);
    	}
    }
    public static void ButtonbyId(String id) throws IOException
    {
    	try {
    	driver.findElement(By.id(id)).click();}
    	catch(NoSuchElementException e) {
    		Screenshot();
    		System.out.println(e);
    	}
    }
    public static void DropDown(String id,String value) throws IOException
    {
    	try {
    		WebElement wB = driver.findElement(By.name(id));
    		Select dD = new Select(wB);
    		List<WebElement>dw = dD.getOptions();
    		int a = dw.size();
    		dD.selectByIndex(a-135);
    	}
    		
    		//dD.selectByVisibleText(value);
    	catch(NoSuchElementException e) {
    		Screenshot();
    		System.out.println(e);
    	}
    	
    		
    	}
    public static void CheckboxesByxpath(String id)
    {
    	driver.findElement(By.xpath(id)).click();
    }
    public static void CheckboxesByid(String id)
    {
    	driver.findElement(By.id(id)).click();
    }
    public static void Screenshot() throws IOException 
    {
    
    	File srcfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileHandler.copy(srcfile, new File("C:\\Users\\srevy\\OneDrive\\YahooTestCase\\WrongPhno "+".png"));
    
    }
   public static void Frames(String id)
   {
	 //  KeywordFramework.driver.switchTo().frame(KeywordFramework.driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[2]/div/div/div/div/div/div/div/div[1]/div/div/div/iframe")));
	   KeywordFramework.driver.switchTo().frame(KeywordFramework.driver.findElement(By.xpath(id)));
   }
   public static void Recaptcha(String id)
   {
	   //KeywordFramework.driver.findElement(By.id("recaptcha-anchor")).click();
	   KeywordFramework.driver.findElement(By.id(id)).click();
   }
   public static void Menuclass(String id)
   {
	   try {
			 KeywordFramework.driver.findElement(By.xpath(id)).click();}
	   catch(NoSuchElementException e) {
				System.out.println(e);}
	   }
   
 
public static void waits()
  {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
}
