package common;

import org.testng.Reporter;

import reports.ExtentReport;

public class Logger {

	
	public static void logMessage(String msg) 
	{
		System.out.println(msg);
		Reporter.log(msg);
		ExtentReport.testStepLogs(msg, "PASS");
	}
	
	public static void logError(String msg) 
	{
		System.err.println(msg);
		Reporter.log(msg);
		ExtentReport.testStepLogs(msg, "FAIL");
	}
}
