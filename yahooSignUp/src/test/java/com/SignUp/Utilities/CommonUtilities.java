package com.SignUp.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SignUp.TestCases.BaseClass;




public class CommonUtilities extends BaseClass{
	
	//Performing Single Click operation using the xpath locator.
	
	 public static void ClickingbyXpath(WebElement element)
	    {
	    	element.click();
	    }
	 public static void click(WebElement element)
	    {
	    	element.click();
	    }
	 
	 //Performing Single Click Operation using LinkText Locator
	 public static void LinkText(WebElement element) 
	 	{
		 element.click();
	 	}
	 
	 
	 public static void Navigation(WebElement element)
	  	{
		 WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(element));
			Actions act = new Actions(driver);
		//	System.out.println(element);
			act.moveToElement(element);
			act.perform();
	  	}
	 
	 //Handling drop downs using Select class
	 public static void DropDown(WebElement element, String Text)
	 {
		
		 
		 Select stat = new Select(element);
         stat.selectByVisibleText(Text);
	 }
	 
	 //Implicit wait
	 public static void waits()
     {
   	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     }
	 
	 //Explicit wait
	 public static void explicitwait(WebElement id)
	    {
	    	WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(id));
			//wait.until(ExpectedConditions.elementSelectionStateToBe(null, false));
	    }
	 
	 //Scrolling the page
	 public static void scroll() 
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
	 }
	 
	 //For taking screenshot
	 public static String Screenshot(WebDriver driver,String filename) throws IOException 
	    {
	         
	    	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  //  FileHandler.copy(srcfile, new File(System.getProperty("./ScreenShots"+tname+".png")));
		    String path = System.getProperty("user.dir")+"/Screenshots/" +filename +System.currentTimeMillis()+ ".png";
			File destination = new File(path);
			
			try {
				FileUtils.copyFile(src, destination);
				logger.info("Screenshot Captured");
			}catch(IOException e)
			{
				System.out.println("Capture failed"+ e.getMessage());
			}
			return path;
	    
	    }
	 public static void Textbox(WebElement element, String value)
	 {
		 element.sendKeys(value);	  
	 }
	 
	 
	 //Clearing the text box and then entering the values
	 public static void TextboxbyIdClear(WebElement element, String value)
	   {
		   element.clear();
		   element.sendKeys(value);	  
		   element.click();
	   }
	 
	 public static void TextboxClear(WebElement element, String value)
	   {
		   element.clear();
		   element.sendKeys(value);	  
		   element.click();
	   }
	 
	 //Switching the window
	 public static void SwitchWindow()
	 {
		 Set<String>totalopenwindow = driver.getWindowHandles();
		   List<String>win = new ArrayList<String>(totalopenwindow);
		   driver.switchTo().window(win.get(0));
	 }
}
