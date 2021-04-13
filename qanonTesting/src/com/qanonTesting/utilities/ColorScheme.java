package com.qanonTesting.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ColorScheme {

    public void writeExcel(String filePath,String fileName,String sheetName) throws IOException{

        //Create an object of File class to open xlsx file
        File file = new File(filePath+"\\"+fileName);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        Workbook ColorWorkbook = null;

        //Find the file extension by splitting  file name in substring and getting only extension name
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file
        if(fileExtensionName.equals(".xlsx")){

        //If it is xlsx file then create object of XSSFWorkbook class
        ColorWorkbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file
        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of XSSFWorkbook class
            ColorWorkbook = new HSSFWorkbook(inputStream);

        }    

    //Read excel sheet by sheet name
    Sheet sheet = ColorWorkbook.getSheet(sheetName);    
    		
    //Get the current count of rows in excel file
    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

    //Create a loop over the cell of newly created Row
    for(int j = 1; j <= rowCount; j++)
    {
        //Fill data in row        
//       System.out.println(sheet.getRow(j).getCell(0).getStringCellValue());
       float f1 = Float.parseFloat(sheet.getRow(j).getCell(5).getStringCellValue());
//       System.out.println(f1);
       String firstcell = (sheet.getRow(j).getCell(0).getStringCellValue()).toString()  ;
       
//       System.out.println( sheet.getRow(j).getCell(1).getStringCellValue());
       if((firstcell.equals("LOGIN") || firstcell.equals("OPEN SCREEN") || firstcell.equals("ADD ROW") || firstcell.equals("REVISE") || firstcell.equals("SAVE") || firstcell.equals("SUBMIT")) && (Float.parseFloat(sheet.getRow(j).getCell(5).getStringCellValue())<2))
       {   	   
    	   CellStyle style = ColorWorkbook.createCellStyle(); 
    	   style.setFillForegroundColor(IndexedColors.GREEN.getIndex());  
           style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
           sheet.getRow(j).getCell(5).setCellStyle(style);
//           System.out.println("GREEN");
       }
       else if((firstcell.equals("LOGIN") || firstcell.equals("OPEN SCREEN") || firstcell.equals("ADD ROW") || firstcell.equals("REVISE") || firstcell.equals("SAVE") || firstcell.equals("SUBMIT")) && ((f1>2) && (f1<5)))
       {
    	   CellStyle style = ColorWorkbook.createCellStyle(); 
    	   style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());  
           style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
           sheet.getRow(j).getCell(5).setCellStyle(style);
//           System.out.println("YELLOW");
       }
       else if((firstcell.equals("LOGIN") || firstcell.equals("OPEN SCREEN") || firstcell.equals("ADD ROW") || firstcell.equals("REVISE") || firstcell.equals("SAVE") || firstcell.equals("SUBMIT")) && ((f1>5)))
       {
    	   CellStyle style = ColorWorkbook.createCellStyle(); 
    	   style.setFillForegroundColor(IndexedColors.RED.getIndex());  
           style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
           sheet.getRow(j).getCell(5).setCellStyle(style);
//           System.out.println("RED");
       }
       else
       {
    	   System.out.println("All Values are greater than 10");
       }
    }

    //Close input stream
    inputStream.close();

    //Create an object of FileOutputStream class to create write data in excel file
    FileOutputStream outputStream = new FileOutputStream(file);

    //write data in the excel file
    ColorWorkbook.write(outputStream);

    //close output stream
    outputStream.close();
    }
    
    @Test
    public static void colorExcel() throws IOException
    {        
        //Create an object of current class
        ColorScheme objExcelFile = new ColorScheme();

        //Write the file using file name, sheet name and the data to be filled
        objExcelFile.writeExcel("C:\\Users\\Public\\" +CommonValues.folderName+ "\\Outputs\\reports","TestResultFormat.xlsx","Performance");
    }
}