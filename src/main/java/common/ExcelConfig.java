package common;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import reports.ExtentReport;

public class ExcelConfig {

	
	//Added by bala
	public String testID=null;
	public String testName=null;
	public String testDesc=null;
	public String testData=null;
	
	public XSSFSheet sh=null;


	public ExcelConfig(String workbookpath,String sheetname) throws Exception
	{
		File file=new File(workbookpath);
		FileInputStream fiStream=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fiStream);
		sh=wb.getSheet(sheetname);

	}
	public void readTestData(String testIDExpected)
	{
		for (int i=1;i<=sh.getLastRowNum();i++)
		{
			testID=sh.getRow(i).getCell(0).getStringCellValue();
			
			if(testID.equals(testIDExpected))
				{
				testName=sh.getRow(i).getCell(1).getStringCellValue();
				testDesc=sh.getRow(i).getCell(2).getStringCellValue();
				testData=sh.getRow(i).getCell(3).getStringCellValue();
				ExtentReport.setTestName(testName,testDesc);  //extend Report - Set TestcaseName in repot
				splitData(testData);
				
				break;
				}
		}

	}
	
	public void splitData(String data) 
	{
		
		for(int i =0; i< data.split("#").length;i++)
		{
			String keyValeString=data.split("#")[i];
			String key = keyValeString.split("=")[0];
			String value=keyValeString.split("=")[1];
			WebDriverGenerics.hMap.put(key, value);
		}
		
		Logger.logMessage("Test Data  :: "+WebDriverGenerics.hMap.entrySet());
		
	}

}
