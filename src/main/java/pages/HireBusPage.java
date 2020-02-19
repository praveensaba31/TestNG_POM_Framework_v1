package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.Logger;
import common.WebDriverGenerics;

public class HireBusPage extends WebDriverGenerics {
	
	WebDriver pageDriver;
	
	public HireBusPage(WebDriver d) {
		
		this.pageDriver=d;
	}
	
	@FindBy(xpath = "//div[@id='widget_header1']/span")
	WebElement _travelingText ;
	
	public void validateTravelingText() 
	{
		String actualText= _travelingText.getText();
		
		Logger.logMessage(actualText);
	}

}
