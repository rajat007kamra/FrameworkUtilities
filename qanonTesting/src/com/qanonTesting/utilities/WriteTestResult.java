package com.qanonTesting.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteTestResult 
{	
	//Method to update 'Basic' Sheet in "TestResultFormat.xlsx"
	public static void addRowInBasicSheet(String basicTestName, String testResult, String time, String dateTime, String environment, String subTenant, String process, String userId, String comments) throws IOException
	{
		if(testResult=="PASS")
		{
			//Create an array with the data in the same order in which you expect to be filled in excel file
	        String[] valueToWrite = {basicTestName, testResult, time, dateTime, environment, subTenant, process, userId, comments};

	        //Create an object of current class
	        WriteTestResult objExcelFile = new WriteTestResult();

	        //Write the file using file name, sheet name and the data to be filled
	        objExcelFile.writeExcel(CommonValues.testResultFilePath, "TestResultFormat.xlsx", "Basic", valueToWrite);
		}
		else if(testResult=="FAIL")
		{
			//Create an array with the data in the same order in which you expect to be filled in excel file
			String[] valueToWrite = {basicTestName, testResult, time, dateTime, environment, subTenant, process, userId, comments};

	        //Create an object of current class
	        WriteTestResult objExcelFile = new WriteTestResult();

	        //Write the file using file name, sheet name and the data to be filled
	        objExcelFile.writeExcel(CommonValues.testResultFilePath, "TestResultFormat.xlsx", "Basic", valueToWrite);
		}
		else
		{
			CreateLogs.writeLogs("Test Result value should be either PASS/FAIL(in upper case)");
		}
	}
	
	//Method to update 'Details' Sheet in "TestResultFormat.xlsx"
	public static void addRowInDetailsSheet(String testName, String action, String testDetails, String dateTime, String environment, String tenant, String subTenant, String userId, String rowDetails, String responseTime, String notes) throws IOException
	{
		//Create an array with the data in the same order in which you expect to be filled in excel file
        String[] valueToWrite = {testName, action, testDetails, dateTime, environment, tenant, subTenant, userId, rowDetails, responseTime, notes};

        //Create an object of current class
        WriteTestResult objExcelFile = new WriteTestResult();

        //Write the file using file name, sheet name and the data to be filled
        objExcelFile.writeExcel(CommonValues.testResultFilePath, "TestResultFormat.xlsx", "Details", valueToWrite);
	}
	
	//Method to update 'Performance' Sheet in "TestResultFormat.xlsx"
	public static void addRowInPerformanceSheet(String activityName, String count, String minTime, String maxTime, String meanTime, String nintyPValue, String nintyFivePValue) throws IOException
	{
		//Create an array with the data in the same order in which you expect to be filled in excel file
        String[] valueToWrite = {activityName, count, minTime, maxTime, meanTime, nintyPValue, nintyFivePValue};

        //Create an object of current class
        WriteTestResult objExcelFile = new WriteTestResult();

        //Write the file using file name, sheet name and the data to be filled
        objExcelFile.writeExcel(CommonValues.testResultFilePath, "TestResultFormat.xlsx", "Performance", valueToWrite);
	}
	
	//Method which creating rows and columns in Excel sheets for writing new values in them
	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite) throws IOException
	{
        //Create an object of File class to open xlsx file
        File file = new File(filePath + "\\" + fileName);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = null;

        //Find the file extension by splitting  file name in substring and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file
        if(fileExtensionName.equals(".xlsx"))
        {
        	//If it is xlsx file then create object of XSSFWorkbook class
        	workbook = new XSSFWorkbook(inputStream);
        }
        //Check condition if the file is xls file
        else if(fileExtensionName.equals(".xls"))
        {
            //If it is xls file then create object of XSSFWorkbook class
        	workbook = new HSSFWorkbook(inputStream);
        }
        
        //Read excel sheet by sheet name
        Sheet sheet = workbook.getSheet(sheetName);
        
        //Get the current count of rows in excel file
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        
        //Get the first row from the sheet
        Row row = sheet.getRow(0);

        //Create a new row and append it at last of sheet
        Row newRow = sheet.createRow(rowCount+1);

        //Create a loop over the cell of newly created Row
        for(int j = 0; j < row.getLastCellNum(); j++)
        {
        	//Fill data in row
        	Cell cell = newRow.createCell(j);
        	cell.setCellValue(dataToWrite[j]);
        }

        //Close input stream
        inputStream.close();

        //Create an object of FileOutputStream class to create write data in excel file
        FileOutputStream outputStream = new FileOutputStream(file);

        //write data in the excel file
        workbook.write(outputStream);

        //close output stream
        outputStream.close();
	}
}