package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.WebDriverGenerics;

public class HotelsPage extends WebDriverGenerics
{
	WebDriver pageDriver;
	
	public HotelsPage(WebDriver d) {
		this.pageDriver=d;
	}
	
	@FindBy(id = "search_key")
	WebElement _enterLocation;
	
	@FindBy(xpath = "//div[@class='suggestions-box']/div[1]")
	WebElement _suggestionFirstRow;
	
	@FindBy(id = "search_hotel")
	WebElement _searchButton;
	
	public void SearchHotels(String location) 
	{
		enterText(_enterLocation, location);
		click(_suggestionFirstRow);
		click(_searchButton);
	}

}
