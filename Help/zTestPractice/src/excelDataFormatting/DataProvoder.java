package excelDataFormatting;

import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvoder 
{	WebDriver driver = null;
	
	@Test(priority=1)
	public void firefoxTest() throws InterruptedException
	{
		System.setProperty("webdriver.ie.driver", "C:/Users/PPJ/workspace/ReadExcel/excelData/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		String URL = "http://10.120.0.138:8080/NAXTEST/?login";
		driver.get(URL);
	}	
	
	@DataProvider(name="getdata")
	public Object[][] readexcel() throws BiffException, IOException
	{
		Object[][] arrayExcelData = null;		
		FileInputStream file1 = new FileInputStream("C:/Users/PPJ/workspace/zTestingProject/TestingFiles/LoginData.xls");		
		Workbook wb = Workbook.getWorkbook(file1);		
		Sheet sh = wb.getSheet("Sheet1");		
		int rows = sh.getRows();
		System.out.println("Number of rows are :- "    +rows);		
		int cols = sh.getColumns();
		System.out.println("Number of rows are :- "    +cols);		
		arrayExcelData = new String[rows-1][cols];		
		for(int i=1; i<rows; i++)
		{			for(int j=0; j<cols; j++)
					{
						arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
					}
		}		
		return arrayExcelData;
	}
	
	@Test(dataProvider="getdata", priority=2)
	public void putdata(String uname, String pwd)
	{
		driver.findElement(By.id("x-auto-8-input")).sendKeys(uname);
		driver.findElement(By.id("x-auto-9-input")).sendKeys(pwd);
		
		
	}
}
