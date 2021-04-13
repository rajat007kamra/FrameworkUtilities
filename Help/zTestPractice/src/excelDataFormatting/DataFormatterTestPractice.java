package excelDataFormatting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DataFormatterTestPractice 
{
	WebDriver driver = null;
	File file = new File( projectPath +"/TestingFiles/Testing Purpose- automated testing_17may18.xlsx");
	static String projectPath = System.getProperty("user.dir");
	
	@Test(priority=1)
	public void ExecuteTest() throws IOException
	{
		//CommonFunctions.logCreation();
		// Load the file
		FileInputStream fis=new FileInputStream(file);
		// load the workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// get the sheet which you want to modify or create
		XSSFSheet sh1 = wb.getSheetAt(0);
		// getRow specify which row we want to read and getCell which column
		int rowCount = sh1.getLastRowNum()-sh1.getFirstRowNum();

		for (int i = 1; i < rowCount+1; i++)
		{
			XSSFRow row = sh1.getRow(i);
			System.out.print("\n");
		    for (int j = 12; j < row.getLastCellNum(); j++)
		    {
		    	//System.out.println("Raw Value:"+sh1.getRow(i).getCell(j).getRawValue());
		    	DataFormatter dataFormatter = new DataFormatter();
		    	XSSFCell cell3 = sh1.getRow(i).getCell(j);
		    	//cell3.setCellType(CellType.STRING);

		    	String str = dataFormatter.formatCellValue(cell3);
		    	 System.out.print(str+ "|| str \t");
		    	//System.out.println("Cell Value: " +str+ "_" +i+ "|| ");
		    	//CommonFunctions.log.info("Cell Value: " +str+ "_" +i+ "|| ");
		    	
		    	
		    	double number = Double.parseDouble(str);
				System.out.println(number+ "|| number");
				System.out.println("\n");

		    	
		    }
		}
	}
}