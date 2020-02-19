package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.Logger;
import common.WebDriverGenerics;

public class HomePage extends WebDriverGenerics{

	WebDriver pageDriver;
	
	public HomePage(WebDriver d)
	{
		this.pageDriver=d;
	}
	
	//Page Elements
	@FindBy(id = "redBus Hotels") 
	WebElement _hotels;
	
	@FindBy(id = "redBus Bus Hire")
	WebElement _busHire;
	
	//Page Methods
	
	public void clickHotel(String expected) 
	{
		click(_hotels);		
		Logger.logMessage("Navigated to hotel page");
		validateString(getTitle(), expected);
	}
	
	
	public void clickBusHire() 
	{
		click(_busHire);
	}
	
	
	
	
	
	
}
