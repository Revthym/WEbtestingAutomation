package com.SignUp.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SignUp.Utilities.CommonUtilities;

public class YahooPO extends CommonUtilities{
	
	WebDriver ldriver;
	public  YahooPO(WebDriver rdriver)
	{
		ldriver = rdriver;
    	PageFactory.initElements(rdriver,this);
	}

	@FindBy(id = "usernamereg-firstName")
	WebElement FirstName;
	
	@FindBy(id = "usernamereg-lastName")
	WebElement LastName;
	
	@FindBy(id = "usernamereg-userId")
	WebElement UserId;
	
	@FindBy(id = "usernamereg-password")
	WebElement Password;
	
	@FindBy(id = "usernamereg-birthYear")
	WebElement BirthYear;
	
	@FindBy(id = "reg-submit-button")
	WebElement Submit;
	
	@FindBy(name = "shortCountryCode")
	WebElement CountryCode;
	
	@FindBy(id = "usernamereg-phone")
	WebElement Phone;
	
	@FindBy(id = "reg-submit-button")
	WebElement Submit1;
	
	public void signup() throws InterruptedException
	{
		Textbox(FirstName,"Revathy");
		Textbox(LastName,"Srinivasan");
		Textbox(UserId,"rvthy22");
		Textbox(Password,"Yashvi11*");
		Textbox(BirthYear,"1989");
		click(Submit);
		wait();
		DropDown(CountryCode,"91");
		Textbox(Phone , "6381977301");
		click(Submit1);
	}
}
