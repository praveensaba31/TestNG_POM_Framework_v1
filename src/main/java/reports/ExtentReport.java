package reports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	private static ExtentTest test;
	private static ExtentReports extent;

	public static void startReport(String ReportName)
	{
		extent = new ExtentReports("./ExtentReport/"+ReportName+".html", true);
	}
	
	public static void setTestName(String testCaseName, String testDescription ) 
	{
		test = extent.startTest(testCaseName, testDescription);
	}
	
	
	public static void testStepLogs(String msg, String status) 
	{
		if (status.toUpperCase().equalsIgnoreCase("PASS"))
		{
			test.log(LogStatus.PASS, msg);
		}
		else if (status.toUpperCase().equalsIgnoreCase("FAIL"))
		{
			test.log(LogStatus.FAIL, msg );
		}
		else if (status.toUpperCase().equals("INFO"))
		{
			test.log(LogStatus.INFO, msg);
		}
	}

	public static void endReport() 
	{
		extent.endTest(test);
		extent.flush();
	}
}
