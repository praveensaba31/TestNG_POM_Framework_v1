package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.ExcelConfig;
import common.Logger;

public class RegressionTestcase extends TestNGBaseClass
{
	
	@BeforeClass
	public void BeforeClass() throws Exception 
	{
		_excel = new ExcelConfig("./Testdata/WebApp_testData.xlsx", "RegressionTestData");
	}
	
	@Test(enabled = false)
	public void Testcase001_BookHotel() 
	{
		_excel.readTestData("TC001");
		
		System.out.println(_excel.testData);
		try 
		{
		homePage.clickHotel("Bala");
		hotelsPage.SearchHotels("Chennai");
		}
		catch (Exception e) 
		{
			Logger.logError("Exception occured :: "+ e.getMessage());
			assertFail();
		}
		finally
		{
			assertall();
		}	
	}
	

	@Test
	public void Testcase002_dummy() 
	{
		_excel.readTestData("TC002");
		try 
		{
			validateString("Bala", hMap.get("ExpectedTitle"));
			validateString("Chennai_1", hMap.get("Location"));
		}
		catch (Exception e) 
		{
			Logger.logError("Exception occured "+ e.getMessage());
		}
		finally
		{
			assertall();
		}	
	}

}
