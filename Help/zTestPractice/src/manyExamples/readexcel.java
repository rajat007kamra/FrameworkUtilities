package manyExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class readexcel 
{
	WebDriver driver = null;
	
	@BeforeTest
	public void init()
	{
		driver = new FirefoxDriver();
		driver.get("https://www.google.co.in/");
	}
	
	@DataProvider(name="GetData")
	public Object[][] getData() throws FileNotFoundException
	{
		Object[][] arrayExcelData = null;
		String FilePath = System.getProperty("user.dir");
		System.out.println(FilePath);
		FileInputStream file = new FileInputStream(FilePath +"/testData/excel.xls");
		
		try 
		{
			Workbook book = Workbook.getWorkbook(file);
			Sheet sh = book.getSheet("Sheet1");
			
			int rowCount = sh.getRows();
			int colCount = sh.getColumns();
			
			System.out.println("No. of Rows :- " +rowCount);
			System.out.println("No. of Columns :- " +colCount);
			
			arrayExcelData = new String[rowCount-1][colCount];
			
			for(int i=1; i<rowCount; i++)
			{
				for(int j=0; j<colCount; j++)
				{
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}
			}			
		} 
		catch (BiffException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrayExcelData;
	}
	
	@Test(dataProvider="GetData")
	public void putData(String searchValue) throws InterruptedException
	{
		driver.findElement(By.id("lst-ib")).sendKeys(searchValue);
		driver.findElement(By.name("btnG")).click();
		Thread.sleep(3000);
		String ActualResult=  driver.findElement(By.xpath(".//*[@id='rso']/div/div[1]/div/div/div/div[1]/cite")).getText();
		String ExpectedResult = "www.seleniumhq.org/";
		
		if(ActualResult.equals(ExpectedResult))
		{
			System.out.println("Search Successfull");
		}
		else 
		{
			System.out.println("Search Failed");
		}
	}
	
	@AfterClass
	public void quit()
	{
		driver.close();
	}
}
