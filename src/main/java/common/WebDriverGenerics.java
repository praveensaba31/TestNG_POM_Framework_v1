package common;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class WebDriverGenerics {

	public WebDriver driver;
	public SoftAssert sa=null;
	public static HashMap<String, String> hMap= new HashMap<String, String>();
	
	public WebDriver launchBrowser(String browserName, String AppURL)
	{
		
		if(browserName.equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else
		{
			Logger.logError("Check the Browser name - Invalid Browser");
		}

		//Logger.logMessage(browserName + " Browser Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(AppURL);
		return driver;
	}
	
	
	public String getTitle()
	{
		String title=driver.getTitle();
		Logger.logMessage("Actual Title is :: " +title);
		return title;
	}
	
	public String getCurrentUrl()
	{
		String url=driver.getCurrentUrl();
		return url;
	}
	public String getPageSource()
	{
		String source=driver.getPageSource();
		return source;

	}
	public void back()
	{
		driver.navigate().back();
	}
	public void forward()
	{
		driver.navigate().forward();
	}
	public void refresh()
	{
		driver.navigate().refresh();
	}
	public void close()
	{
		driver.close();
	}
	public void quit()
	{
		driver.quit();
	}
	public void selectByIndex(WebElement ele,int index)
	{
		Select st=new Select(ele);
		st.selectByIndex(index);
	}
	public void selectByValue(WebElement ele,String value)
	{
		Select st=new Select(ele);
		st.selectByValue(value);
	}
	public void selectByVisibleText(WebElement ele,String VisibleText)
	{
		Select st=new Select(ele);
		st.selectByVisibleText(VisibleText);
	}
	public String getFirstSelectedOption(WebElement ele)
	{
		Select st=new Select(ele);
		String defaultOption=st.getFirstSelectedOption().getText();
		return defaultOption;
	}

	public void click(WebElement ele) 
	{
		ele.click();
	}

	public void enterText(WebElement ele, String enterTextValue)
	{
		ele.sendKeys(enterTextValue);
	}

	public void acceptAlert() 
	{
		Alert at = driver.switchTo().alert();
		at.accept();
	}
	
	public void validateString(String actual,String expected )
	{
		if(actual.equals(expected))
		{
			Logger.logMessage("Actual and Expected value matched");
		}else 
		{
			Logger.logError("Values not matched  --> " + "Actual :: "+ actual + " Expected ::" +expected);
			sa.fail("Actual :: "+ actual + " Expected ::" +expected);
		}
	}

	public void validatenumber(int actual,int expected )
	{
		if(actual==expected)
		{
			Logger.logMessage("Actual and Expected value matched");
		}else 
		{
			Logger.logError("Values not matched  --> " + "Actual :: "+ actual + " Expected ::" +expected);
			sa.fail("Actual :: "+ actual + " Expected ::" +expected);
		}
	}

	public void assertFail() 
	{
		sa.fail();
	}
	public void assertall()
	{
		sa.assertAll();
	}
}
