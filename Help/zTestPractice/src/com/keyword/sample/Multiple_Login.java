package com.keyword.sample;

import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.ss.usermodel.Sheet; 
import org.apache.poi.ss.usermodel.Workbook; 
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Multiple_Login 
{
	WebDriver driver = null;
	File file = new File("C:\\Users\\PPJ\\workspace\\KeywordDriven\\testData\\LoginData.xlsx");
	static String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void startApp() throws InterruptedException
	{
		System.setProperty("webdriver.ie.driver", projectPath+"/envVariables/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://10.120.0.138:8080/NAXIOSCO/?login");
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(4000);
	}
	
	@Test(priority=1)
	public void ExecuteTest() throws Exception
	{
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook guru99Workbook = new XSSFWorkbook(inputStream);

		Sheet  guru99Sheet = guru99Workbook.getSheet("Login");
	 
		int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
	 
	            for (int i = 1; i < rowCount+1; i++)
	            {	 
                        Row row = guru99Sheet.getRow(i); 
	        
                        for (int j = 0; j < row.getLastCellNum(); j++) 
                        {
	 
	                        System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	                        if(j==0)
	                        {
	                        
	                          driver.findElement(By.name("userName")).sendKeys(row.getCell(j).getStringCellValue());
	                        }
	                        if(j==1)
	                        {
	                        
	                          driver.findElement(By.name("password")).sendKeys(row.getCell(j).getStringCellValue());
	                        }
                        }                    
                        	driver.findElement(By.id("btnLogin")).click();
	                        String alert = driver.findElement(By.id("x-auto-14")).getText();
	                        System.out.println("After Login Text Found ::- " +alert);
	                        
				        System.out.println();
				        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\PPJ\\workspace\\KeywordDriven\\testData\\LoginData.xlsx"));
				      String temp=  guru99Workbook.getSheet("Login").getRow(i).getCell(0).getStringCellValue();
				      System.out.println("Temp Values ::- " +temp);
				      
				      if(alert.contentEquals("Welcome le") )
				      {
				        guru99Workbook.getSheet("Login").getRow(i).getCell(2).setCellValue("credential are valid");
				      //  guru99Workbook.getSheet("Login").getRow(i).getCell(2).setCellStyle(arg0);;
				        
					       guru99Workbook.write(out);
					       out.close();	
				      }
				      else
				      {
				    	  guru99Workbook.getSheet("Login").getRow(i).getCell(2).setCellValue("credential are NOT valid");
				    	  
					       guru99Workbook.write(out);
					       out.close();	
				      }
	            } 
			    inputStream.close();
			    //guru99Workbook.close();
	}
}
