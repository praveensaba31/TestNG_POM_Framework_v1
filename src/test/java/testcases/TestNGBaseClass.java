   package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import common.ExcelConfig;
import common.WebDriverGenerics;
import pages.HireBusPage;
import pages.HomePage;
import pages.HotelsPage;
import reports.ExtentReport;

public class TestNGBaseClass extends WebDriverGenerics{
	
	public ExcelConfig _excel=null;
 
	public HomePage homePage =null;
	public HotelsPage hotelsPage =null;
	public HireBusPage hireBusPage=null;
	
	@BeforeSuite
	public void BeforeSuite() 
	{
		ExtentReport.startReport("Web_Automation");
	}
	
	@BeforeTest
	public void start() 
	{
		WebDriver driver =launchBrowser("Chrome", "https://www.redbus.in/");
		
		homePage = PageFactory.initElements(driver, HomePage.class);
		hotelsPage =PageFactory.initElements(driver, HotelsPage.class);
		hireBusPage= PageFactory.initElements(driver, HireBusPage.class);
		/*
		 * homePage =new HomePage(driver); 
		 * hotelsPage = new HotelsPage(driver);
		 * hireBusPage = new HireBusPage(driver);
		 */
	}
	
	@BeforeMethod
	public void BeforeMethod() 
	{
		sa= new SoftAssert();
		hMap.clear();
	}
	
	@AfterTest
	public void end() 
	{
		close();
	}
	
	@AfterSuite
	public void afterSuite() 
	{
		ExtentReport.endReport();
	}
	
}
