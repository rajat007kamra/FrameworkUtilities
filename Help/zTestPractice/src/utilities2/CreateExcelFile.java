package com.qanonTesting.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class CreateExcelFile 
{
	public static XSSFWorkbook workbook = null;
    
	@Test
	public static void createWorkbook() throws IOException, InterruptedException 
	{		
		workbook = new XSSFWorkbook();
		createBasicSheet();
		createDetailsSheet();
		createPerformanceSheet();
    }
	
	//Method to create sheet in "TestResultFormat.xlsx" workbook with name = 'Basic'
	public static void createBasicSheet() throws FileNotFoundException, IOException
	{
		XSSFSheet sheet = workbook.createSheet("Basic");
        
		CellStyle style = workbook.createCellStyle();	//Create style
	    Font font = workbook.createFont();	//Create font
	    font.setBold(true);	//Make font bold
	    style.setFont(font);	//set it to bold
	    
        Object[][] bookData = {
                {"BASIC TEST", "RESULT", "TIME TAKEN (in ms)", "DATE & TIME", "ENVIRONMENT", "SUBTENANT", "PROCESS", "USER ID", "NOTES"},
        };
 
        int rowCount = 0;
         
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(rowCount);
             
            int columnCount = -1;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                    cell.setCellStyle(style);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                    cell.setCellStyle(style);
                }
                else if (field instanceof Date) {
                    cell.setCellValue((Date) field);
                    cell.setCellStyle(style);
                }
            } 
        }         
         
        try (FileOutputStream outputStream = new FileOutputStream(CommonValues.testResultFilePath +"TestResultFormat.xlsx")) {
            workbook.write(outputStream);
        }
	}
	
	//Method to create sheet in "TestResultFormat.xlsx" workbook with name = 'Details'
	public static void createDetailsSheet() throws FileNotFoundException, IOException
	{
		XSSFSheet sheet = workbook.createSheet("Details");
        
		CellStyle style = workbook.createCellStyle();	//Create style
	    Font font = workbook.createFont();	//Create font
	    font.setBold(true);	//Make font bold
	    style.setFont(font);	//set it to bold
	    
        Object[][] bookData = {
        		{"TEST CASE", "ACTION", "TEST DETAILS", "DATE & TIME", "ENVIRONMENT", "TENANT", "SUBTENANT", "USER ID", "ROW DETAILS", "RESPONSE TIME", "NOTES"},
        };
 
        int rowCount = 0;
         
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(rowCount);
             
            int columnCount = -1;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                    cell.setCellStyle(style);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                    cell.setCellStyle(style);
                }
                else if (field instanceof Date) {
                    cell.setCellValue((Date) field);
                    cell.setCellStyle(style);
                }
            } 
        }         
         
        try (FileOutputStream outputStream = new FileOutputStream(CommonValues.testResultFilePath +"TestResultFormat.xlsx")) {
            workbook.write(outputStream);
        }
	}
	
	//Method to create sheet in "TestResultFormat.xlsx" workbook with name = 'Performance'
	public static void createPerformanceSheet() throws FileNotFoundException, IOException
	{
		XSSFSheet sheet = workbook.createSheet("Performance");
        
		CellStyle style = workbook.createCellStyle();	//Create style
	    Font font = workbook.createFont();	//Create font
	    font.setBold(true);	//Make font bold
	    style.setFont(font);	//set it to bold
	    
        Object[][] bookData = {
        		{"ACTIVITY", "COUNT", "MIN", "MAX", "MEAN", "90P", "95P"},
        };
 
        int rowCount = 0;
         
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(rowCount);
             
            int columnCount = -1;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                    cell.setCellStyle(style);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                    cell.setCellStyle(style);
                }
                else if (field instanceof Date) {
                    cell.setCellValue((Date) field);
                    cell.setCellStyle(style);
                }
            } 
        }         
         
        try (FileOutputStream outputStream = new FileOutputStream(CommonValues.testResultFilePath +"TestResultFormat.xlsx")) {
            workbook.write(outputStream);
        }
	}
	
	//Method to create Log File
	public static void createNewResultFile() throws IOException, InterruptedException
	{
		File excelFile = new File(CommonValues.testResultFilePath +"TestResultFormat.xlsx");
		//if file doesn't exists, then create it
		if (!excelFile.exists()) 
		{
			excelFile.createNewFile();
		}
		else if (excelFile.exists()) 
		{
			excelFile.delete();
			Thread.sleep(5000);
			excelFile.createNewFile();
		}
		else
		{
			CreateLogs.writeLogs("System Unable to Create Log File");
		}
	}
	
	//Method renaming file for maintaining the previous logs
	public static void renameExcelResultFile()
	{
		File f1 = new File(CommonValues.resultFilePath);

		String extensionRemoved = (CommonValues.resultFilePath).split("\\.")[0];
		//System.out.println(extensionRemoved);
		
		File f2 = new File(extensionRemoved +"_" +CreateLogs.GetCurrentTimeStamp().replace(":","_").replace(".","_")+".xlsx");
		//System.out.println(f2);
		boolean b = f1.renameTo(f2);
		System.out.println("RENAME RESULT - " +b);
	}
}
