package com.SignUp.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.SignUp.Utilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static ReadConfig readconfig = new ReadConfig();
	 public static WebDriver driver;
	 public static String url = readconfig.getApplicationURL();
	 
	 public static ExtentReports extent;
	 public static ExtentTest logger;
	// public static Logger logger;
	 
		
       @BeforeSuite
		public static void SetupSuite()
		{
       	
       	ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/Yahoo_Report");
   		extent = new ExtentReports();
   		extent.attachReporter(reporter);
   		reporter.config().setReportName("Yahoo_Report");
   		reporter.config().setTheme(Theme.STANDARD);

   		
   		extent.setSystemInfo("Hostname", "LocalHost");
   		extent.setSystemInfo("OS", "Windows");
   		extent.setSystemInfo("Tester Name", "Revathy");
   		extent.setSystemInfo("Browser", "Chrome");
       	
           //logger = extent.createTest("AutomatingRecruitnxt Application for Updating Candidate Status");
	    	PropertyConfigurator.configure("log4j.properties");	
			
   		
   		//System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
	    	
	    	WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			//logger.info("Launched the Browser Succesfully");
			
			 driver.get(url);
			// logger.info("URL Launched");		  
		}
       
       @BeforeMethod
   	public void Setup() {
   		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           driver.get(url);
   		driver.manage().window().maximize();
   	}
       
     @AfterMethod
		public void teardownmethod(ITestResult result) throws IOException{
			if(result.getStatus() == ITestResult.FAILURE) {
			//	String Screenshotpath = MethodUtilities.Screenshot();
		
			//	logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(MethodUtilities.Screenshot()).build());
				logger.log(Status.FAIL, "Testcase failed is :" + " " + result.getName());
				logger.fail(result.getThrowable().getMessage());
				
				
			} else if(result.getStatus() == ITestResult.SKIP) {
				logger.log(Status.SKIP, "Testcase skipped is :"+ " " + result.getName());
			}else if(result.getStatus() == ITestResult.SUCCESS) {
				logger.log(Status.PASS, "Testcase passed is :"+ " " + result.getName());
				
			}
       }
     
   /*    @AfterMethod
       public void getResult(ITestResult result) {

           if(result.getStatus() == ITestResult.FAILURE) {
               logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " is Failed", ExtentColor.RED));
               logger.fail(result.getThrowable());
           }
           else if(result.getStatus() == ITestResult.SUCCESS) {
               logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" is Passed", ExtentColor.GREEN));
           }
           else {
               logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" is Failed", ExtentColor.ORANGE));
               logger.skip(result.getThrowable());
           }
       }*/
       
       
     @AfterMethod
   	public void close() {
   		extent.flush();
   	}
       
       
       @AfterSuite
   	public void quit() throws InterruptedException {
   		driver.findElement(By.id("fullNameHeader")).click();
   		driver.findElement(By.xpath("//a[@onclick=\"document.getElementById('logout_form').submit.click()\"]")).click();
   		Thread.sleep(3000);
   		driver.close();

   	}


}
