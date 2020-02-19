 package assertsexample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	
	public static void main(String[] args) throws Exception {
		
		File file = new File(".\\src\\test\\java\\assertsexample\\ReadTestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh =wb.getSheet("Sheet1");
		
		String selectNameString="Select ";
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Select ");
				
		for(int i=1; i<=sh.getLastRowNum();i++)
		{
		String name= sh.getRow(i).getCell(0).getStringCellValue();
		
		if( i == sh.getLastRowNum())
		{
			sBuilder.append(name);
		}else {
		sBuilder.append(name).append(",");
		}
		//double age = sh.getRow(i).getCell(1).getNumericCellValue();
		//String mobileNumber = sh.getRow(i).getCell(2).getStringCellValue();
		
		//System.out.println(name + "-->" + age +"--->" +mobileNumber);
		
		}
		
		sBuilder.append(" from employee");
		
		System.out.println(sBuilder.toString());
	}
	
	public void readExcelData() throws Exception 
	{
		File file = new File(".\\src\\test\\java\\assertsexample\\ReadTestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		//.xlsx
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh =wb.getSheet("Sheet1");
				
		//.xls
		//HSSFWorkbook
		
		for(int i=1; i<=sh.getLastRowNum();i++)
		{
		String name= sh.getRow(i).getCell(0).getStringCellValue();
		double age = sh.getRow(i).getCell(1).getNumericCellValue();
		String mobileNumber = sh.getRow(i).getCell(2).getStringCellValue();
		
		System.out.println(name + "-->" + age +"--->" +mobileNumber);
		
		}
	
	}
}
