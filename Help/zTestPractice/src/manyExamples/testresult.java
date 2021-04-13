package manyExamples;

import java.io.*;

//import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class testresult 
{
	WebDriver driver = null;
	String FilePath = "C:\\Users\\PPJ\\workspace\\testproject\\testData\\testdata.xls";
	
	@Test
	public void exceldata() throws InterruptedException 
	{
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();  
       
        WebElement username = driver.findElement(By.id("email"));        
        WebElement password = driver.findElement(By.id("pass"));
 
        try 
        {
        	FileInputStream file = new FileInputStream(new File(FilePath));
        	HSSFWorkbook workbook = new HSSFWorkbook(file);
        	HSSFSheet sheet = workbook.getSheetAt(0);

        	Cell resultCell= sheet.getRow(1).getCell(3);
        	Cell resultcell1=sheet.getRow(2).getCell(3);
        	Cell resultcell2=sheet.getRow(3).getCell(3);
        	String usernamevalue = sheet.getRow(1).getCell(2).getStringCellValue();
        	String passwordvalue = sheet.getRow(2).getCell(2).getStringCellValue();
        	username.sendKeys(usernamevalue);
        	password.sendKeys(passwordvalue);

        	//driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        	
        	String usernametext=  username.getAttribute("value");
        	System.out.println(usernametext);        	
        	String passwordtext= password.getAttribute("value");
        	System.out.println(passwordtext);
        	
        	if(usernametext.equals(usernamevalue))
        	{
                System.out.println("username is successful.");
                resultCell.setCellValue("PASS");
        	} else{
                System.out.println("username is not successful.");
                resultCell.setCellValue("FAIL");
        	}
        	if(passwordvalue.equals("abcdefg"))
        	{
        		System.out.println("password is successful.");
        		resultcell1.setCellValue("PASS");
        	} else{
        		System.out.println("password is not successful.");
        		resultcell1.setCellValue("FAIL");
        	}
        	String abc = "123";
        	if(abc.equals("abcdefg"))
        	{
        		System.out.println("text matched.");
        		resultcell2.setCellValue("PASS");
        	} else{
        		System.out.println("text not matched.");
        		resultcell2.setCellValue("FAIL");
        	}
        	file.close();

        	FileOutputStream outFile =new FileOutputStream(new File(FilePath));
        	workbook.write(outFile);
        	outFile.close();

        } catch (FileNotFoundException e) {
        		e.printStackTrace();
        	} catch (IOException e) {
        			e.printStackTrace();
        	}
        driver.findElement(By.id("u_0_v")).click();
        Thread.sleep(2000);
	}
	
	@AfterClass
	public void quit()
	{
		driver.close();
		// OJj73}mJ***
		// 36561
	}
}