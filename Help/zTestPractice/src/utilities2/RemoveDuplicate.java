package com.qanonTesting.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class RemoveDuplicate 
{
	public static String filePath1 = "C:\\Users\\Public\\" +CommonValues.folderName+ "\\Outputs\\reports\\TestResultFormat.xlsx";
	public static String filePathW = "C:\\Users\\Public\\" +CommonValues.folderName+ "\\Outputs\\reports";
	
	public static void readExcel(String filePath, String fileName, String sheetName, String sheetType) throws IOException{

		//Create an object of File class to open xlsx file
		File file = new File(filePath+"\\"+fileName);

		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		Workbook DupWorkbook = null;

		//Find the file extension by splitting file name in substring  and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		//Check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx")){

			//If it is xlsx file then create object of XSSFWorkbook class
			DupWorkbook = new XSSFWorkbook(inputStream);
		}

		//Check condition if the file is xls file
		else if(fileExtensionName.equals(".xls")){

			//If it is xls file then create object of HSSFWorkbook class
			DupWorkbook = new HSSFWorkbook(inputStream);
		}

		//Read sheet inside the workbook by its name
		Sheet SheetObject = DupWorkbook.getSheet(sheetName);

		//Find number of rows in excel file
		int rowCount = SheetObject.getLastRowNum()-SheetObject.getFirstRowNum();

		//Create a loop over all the rows of excel file to read it
		List<String> listActivity = new ArrayList<String> ();
		List<String> listActivityCount = new ArrayList<String> ();

		for (int i = 0; i < rowCount+1; i++) {

			Row row = SheetObject.getRow(i);

			//Create a loop to print cell values in a row
			int k=0;
			int l=0;

			for (int j = 0; j < 2; j++) {
				
				//Print Excel data in console
//				System.out.print(row.getCell(j).getStringCellValue()+"|| ");			
				if (j==0)
				{
					listActivity.add(k,row.getCell(j).getStringCellValue());
					//            	System.out.println(Arrays.toString(Activity));
					k=k+1;
				}
				if (j==1)
				{
					listActivityCount.add(l,row.getCell(j).getStringCellValue());
					l=l+1;
				}
			}
			System.out.println();
		} 

		Collections.reverse(listActivity);
		Collections.reverse(listActivityCount);
//		System.out.println(listActivity);
//		System.out.println(listActivityCount);
		List<String> listRow = new ArrayList<String> ();
		for(int i = 0; i < listActivity.size(); i++) {  
			int r=0;
			for(int j = i + 1; j < listActivity.size(); j++) {  
				if(listActivity.get(i) == listActivity.get(j)) 
				{
//					System.out.println(listActivity.get(j));  
					//System.out.println(listActivityCount.get(j));
					//System.out.println(listActivityCount.get(i));
//					System.out.println(i);
					listRow.add(r,Integer.toString(i));
					break;
				}
			}
		}
		  
//		System.out.println(listRow);
		int TotalRowToDelete=listRow.size();
		String[] valueToWrite = {"Mr. E","Noida"};
		
		RemoveDuplicate objExcelFile = new RemoveDuplicate();
		for (int c=0;c<TotalRowToDelete;c++)
		{
			int ValDel=	Integer.parseInt(listRow.get(c));
			if(sheetType == "Basic")
			{
				objExcelFile.writeExcel(filePathW, "TestResultFormat.xlsx", "Basic", valueToWrite, ValDel);
				objExcelFile.deleteRow("Basic", filePath1, ValDel);	
			}
			else if(sheetType == "Details")
			{
				objExcelFile.writeExcel(filePathW, "TestResultFormat.xlsx", "Details", valueToWrite, ValDel);
				objExcelFile.deleteRow("Details", filePath1, ValDel);
			}
			else if(sheetType == "Performance")
			{
				objExcelFile.writeExcel(filePathW, "TestResultFormat.xlsx", "Performance", valueToWrite, ValDel);
				objExcelFile.deleteRow("Performance", filePath1, ValDel);
			}
			else {
				
			}
		}
		inputStream.close();
	}

	//Method to write result
	public void writeExcel(String filePath,String fileName,String sheetName,String[] dataToWrite,int ValDel) throws IOException{

		//Create an object of File class to open xlsx file
		File file = new File(filePath+"\\"+fileName);

		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		Workbook ExcelWorkBook = null;

		//Find the file extension by splitting  file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		//Check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx")){

			//If it is xlsx file then create object of XSSFWorkbook class
			ExcelWorkBook = new XSSFWorkbook(inputStream);
		}

		//Check condition if the file is xls file
		else if(fileExtensionName.equals(".xls"))
		{
			//If it is xls file then create object of XSSFWorkbook class
			ExcelWorkBook = new HSSFWorkbook(inputStream);
		}    

		//Read excel sheet by sheet name
		Sheet sheet = ExcelWorkBook.getSheet(sheetName);

		//Get the current count of rows in excel file
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		sheet.removeRow(sheet.getRow(ValDel));

		//Create a new row and append it at last of sheet
		Row newRow = sheet.createRow(rowCount+1);

		//Close input stream
		inputStream.close();

		//Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);

		//write data in the excel file
		ExcelWorkBook.write(outputStream);

		//close output stream
		outputStream.close();
	}

	//Method to delete duplicate row
	public boolean deleteRow(String sheetName, String excelPath, int rowNo) throws IOException {

		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;

		try {
			FileInputStream file = new FileInputStream(new File(excelPath));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				return false;
			}
			int lastRowNum = sheet.getLastRowNum();
			if (rowNo >= 0 && rowNo < lastRowNum) {
				sheet.shiftRows(rowNo + 1, lastRowNum, -1);
			}
			if (rowNo == lastRowNum) {
				XSSFRow removingRow=sheet.getRow(rowNo);
				if(removingRow != null) {
					sheet.removeRow(removingRow);
				}
			}
			file.close();
			FileOutputStream outFile = new FileOutputStream(new File(excelPath));
			workbook.write(outFile);
			outFile.close();


		} catch(Exception e) {
			throw e;
		} finally {
			if(workbook != null)
				workbook.close();
		}
		return false;
	}

	//Main function is calling readExcel function to read data from excel file
	public static void consolidateExcel(String typeParameter) throws IOException
	{
		//Call read file method of the class to read data
		readExcel(filePathW, "TestResultFormat.xlsx", typeParameter, typeParameter);
	}

//	@Test
//	//Main function is calling readExcel function to read data from excel file
//	public static void removeDuplicatePractice() throws IOException, InterruptedException
//	{
//		//Call read file method of the class to read data
//		readExcel(filePathW, "TestResultFormat.xlsx", typeParameter, typeParameter);
//		readExcel(filePathW, "TestResultFormat.xlsx", "Basic", "Basic");
//		Thread.sleep(3000);
//		readExcel(filePathW, "TestResultFormat.xlsx", "Details", "Details");
//		Thread.sleep(3000);
//		readExcel(filePathW, "TestResultFormat.xlsx", "Performance", "Performance");
//	}
}
