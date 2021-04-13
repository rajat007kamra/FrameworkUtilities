package readWriteInExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.CommonFunctions;
import utilities.DeclareVariable;
import utilities.FunctionLibraries;

public class MatchInputOutput {

	String filePath = "/TestingFiles/Testing Purpose- automated testing_17may18.xlsx";   //"/testData/Automated Updated Format- automated testing.xlsx";
	File file = new File(CommonFunctions.projectPath +filePath);  //Format- automated testing.xlsx

	@BeforeClass
	public void startApp() throws InterruptedException
	{
		CommonFunctions.logCreation();
		FunctionLibraries.openBrowser("chrome");
        CommonFunctions.maxWindowSize();
        CommonFunctions.loginApplication();
	}
	@Test(priority=1)
	public void ExecuteExcelData()
	{
		try
		{
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook cccWorkbook = new XSSFWorkbook(inputStream);
			XSSFSheet  cccSheet = cccWorkbook.getSheet("Sheet1");
			DecimalFormat df = new DecimalFormat("#0.00");
			
			int rowCount = cccSheet.getLastRowNum()-cccSheet.getFirstRowNum();
			CommonFunctions.log.info("Total Number of Records Found in Excel ::- " +cccSheet.getLastRowNum());
			for (int i = 1; i < rowCount+1; i++)
			{
				XSSFRow row = cccSheet.getRow(i); 
				CommonFunctions.log.info("*****Record No. - " +i +" Testing Start*****");
			    for (int j = 1; j <= 32; j++)
			    {
			    	DataFormatter dataFormatter = new DataFormatter();
			    	XSSFCell cell3 = cccSheet.getRow(i).getCell(j);
			    	if(j==1) //State Id input
			    	{
			    		FunctionLibraries.selectDDValue("StateId", dataFormatter.formatCellValue(row.getCell(j)), "State Id");
			    	}
			    	if(j==2) //Zip +4 input
			    	{
			    		FunctionLibraries.enterText("xpath", "//*[@id='zipPlus4Id']/div/input", dataFormatter.formatCellValue(row.getCell(j)), "9 Digit ZIP Code");
			    	}
			    	if(j==3) //Registration Date input
			    	{
			    		FunctionLibraries.enterText("xpath","//*[@id='registrationId']/div[1]/input", dataFormatter.formatCellValue(row.getCell(j)), "Registration date");
			    	}
			    	if(j==4) //Totaled Date input
			    	{
			    		FunctionLibraries.enterText("xpath", "//*[@id='totaledId']/div[1]/input", dataFormatter.formatCellValue(row.getCell(j)), "Totaled date");
			    	}
			    	if(j==5) //Vehicle Value input
			    	{
			    		FunctionLibraries.enterText("id", "vehicleValue", dataFormatter.formatCellValue(row.getCell(j)), "Vehicle Value");
			    	}
			    	if(j==6) //Vehicle Verification Number(VIN) input
			    	{
			    		FunctionLibraries.enterText("id", "VIN", dataFormatter.formatCellValue(row.getCell(j)), "VIN");
			    	}
			    	if(j==7) //Vehicle Type DropdownList input
			    	{
			    		FunctionLibraries.selectDDValue("vehicleTypeId", dataFormatter.formatCellValue(row.getCell(j)), "Vehicle Type");
			    	}
			    	if(j==8) //Vehicle Make By DropdownList input
			    	{
			    		FunctionLibraries.selectDDValue("vehicleMakeId", dataFormatter.formatCellValue(row.getCell(j)), "Vehicle Make");
			    	}
			    	if(j==9) //Vehicle Model DropdownList input
			    	{
			    		FunctionLibraries.selectDDValue("vehicleModelId", dataFormatter.formatCellValue(row.getCell(j)), "Vehicle Model");
			    	}
			    	if(j==10) //Vehicle Year DropdownList input
			    	{
			    		FunctionLibraries.selectDDValue("vehicleYearId", dataFormatter.formatCellValue(row.getCell(j)), "Vehicle Year");
			    	}
			    	if(j==11) //Vehicle Model Trim DropdownList input
			    	{
			    		FunctionLibraries.selectDDValue("vehicleTrimId", dataFormatter.formatCellValue(row.getCell(j)), "Vehicle Trim");
			    		CommonFunctions.driver.findElement(By.linkText("Additional Information")).click();
			    	}
			    	if(j==12) //Vehicle Weight input
			    	{
			    		FunctionLibraries.enterText("id", "vehicleWeight", dataFormatter.formatCellValue(row.getCell(j)), "Weight");
			    	}
			    	if(j==13)
			    	{
				    	DeclareVariable.excelGrandTotal = dataFormatter.formatCellValue(cell3);
				    	DeclareVariable.dubGrandTotal = Double.valueOf(DeclareVariable.excelGrandTotal).doubleValue();
				    	CommonFunctions.log.info("Excel Grand Total is == " +df.format(DeclareVariable.dubGrandTotal));
			    	}
			    	if(j==14)
			    	{
			    		DeclareVariable.excelTotalSalesTax = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubTotalSalesTax = Double.valueOf(DeclareVariable.excelTotalSalesTax).doubleValue();
				    	CommonFunctions.log.info("Excel Sales Tax Total is == " +df.format(DeclareVariable.dubTotalSalesTax));
			    	}
			    	if(j==15)
			    	{
			    		DeclareVariable.excelSalesTax = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubSalesTax = Double.valueOf(DeclareVariable.excelSalesTax).doubleValue();
				    	CommonFunctions.log.info("Excel Sales Tax is == " +df.format(DeclareVariable.dubSalesTax));
			    	}
			    	if(j==16)
			    	{
			    		DeclareVariable.excelLocationRate = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubLocationRate = Double.valueOf(DeclareVariable.excelLocationRate).doubleValue();
				    	CommonFunctions.log.info("Excel Location Rate is == " +df.format(DeclareVariable.dubLocationRate));
			    	}
			    	if(j==17)
			    	{
			    		DeclareVariable.excelAdditionalSalesUseTax = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubAdditionalSalesUseTax = Double.valueOf(DeclareVariable.excelAdditionalSalesUseTax).doubleValue();
				    	CommonFunctions.log.info("Excel Additional Sales/Use Tax is == " +df.format(DeclareVariable.dubAdditionalSalesUseTax));
			    	}
			    	if(j==18)
			    	{
			    		DeclareVariable.excelTotalOtherFeeTax = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubTotalOtherFeeTax = Double.valueOf(DeclareVariable.excelTotalOtherFeeTax).doubleValue();
				    	CommonFunctions.log.info("Excel Total Other Fee & Taxes is == " +df.format(DeclareVariable.dubTotalOtherFeeTax));
			    	}
			    	if(j==19)
			    	{
			    		DeclareVariable.excelTotalRTA = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubTotalRTA = Double.valueOf(DeclareVariable.excelTotalRTA).doubleValue();
				    	CommonFunctions.log.info("Excel Sales Tax Total is == " +df.format(DeclareVariable.dubTotalRTA));
			    	}
			    	if(j==20)
			    	{
			    		DeclareVariable.excelTitleFeeTotal = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubTitleFeeTotal = Double.valueOf(DeclareVariable.excelTitleFeeTotal).doubleValue();
				    	CommonFunctions.log.info("Excel Title Fee Total is == " +df.format(DeclareVariable.dubTitleFeeTotal));
			    	}
			    	if(j==21)
			    	{
			    		DeclareVariable.excelEmergencyMedicalServices = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubEmergencyMedicalServices = Double.valueOf(DeclareVariable.excelEmergencyMedicalServices).doubleValue();
				    	CommonFunctions.log.info("Excel Emergency Medical Services is == " +df.format(DeclareVariable.dubEmergencyMedicalServices));
			    	}
			    	if(j==22)
			    	{
			    		DeclareVariable.excelTitleFilingFee = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubTitleFilingFee = Double.valueOf(DeclareVariable.excelTitleFilingFee).doubleValue();
				    	CommonFunctions.log.info("Excel Title Filing Fee is == " +df.format(DeclareVariable.dubTitleFilingFee));
			    	}
			    	if(j==23)
			    	{
			    		DeclareVariable.excelApplicationFee = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubApplicationFee = Double.valueOf(DeclareVariable.excelApplicationFee).doubleValue();
				    	CommonFunctions.log.info("Excel Application Fee is == " +df.format(DeclareVariable.dubApplicationFee));
			    	}
			    	if(j==24)
			    	{
			    		DeclareVariable.excelTotalRegistrationFees = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubTotalRegistrationFees = Double.valueOf(DeclareVariable.excelTotalRegistrationFees).doubleValue();
				    	CommonFunctions.log.info("Excel Total Registration Fees is == " +df.format(DeclareVariable.dubTotalRegistrationFees));
			    	}
			    	if(j==25)
			    	{
			    		DeclareVariable.excelRegistrationFilingFee = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubRegistrationFilingFee = Double.valueOf(DeclareVariable.excelRegistrationFilingFee).doubleValue();
				    	CommonFunctions.log.info("Excel Registration Filing Fee  is == " +df.format(DeclareVariable.dubRegistrationFilingFee));
			    	}
			    	if(j==26)
			    	{
			    		DeclareVariable.excelVehicleTypeFee = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubVehicleTypeFee = Double.valueOf(DeclareVariable.excelVehicleTypeFee).doubleValue();
				    	CommonFunctions.log.info("Excel Vehicle Type Fee is == " +df.format(DeclareVariable.dubVehicleTypeFee));
			    	}
			    	if(j==27)
			    	{
			    		DeclareVariable.excelLicensePlateTechnologyFee = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubLicensePlateTechnologyFee = Double.valueOf(DeclareVariable.excelLicensePlateTechnologyFee).doubleValue();
				    	CommonFunctions.log.info("Excel License Plate Technology Fee is == " +df.format(DeclareVariable.dubLicensePlateTechnologyFee));
			    	}
			    	if(j==28)
			    	{
			    		DeclareVariable.excelLicenseServiceFee = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dublLicenseServiceFee = Double.valueOf(DeclareVariable.excelLicenseServiceFee).doubleValue();
				    	CommonFunctions.log.info("Excel License Service Fee is == " +df.format(DeclareVariable.dublLicenseServiceFee));
			    	}
			    	if(j==29)
			    	{
			    		DeclareVariable.excelVehicleWeightFee = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubVehicleWeightFee = Double.valueOf(DeclareVariable.excelVehicleWeightFee).doubleValue();
				    	CommonFunctions.log.info("Excel Vehicle Weight Fee is == " +df.format(DeclareVariable.dubVehicleWeightFee));
			    	}
			    	if(j==30)
			    	{
			    		DeclareVariable.excelLicenseFeeByWeight = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubLicenseFeeByWeight = Double.valueOf(DeclareVariable.excelLicenseFeeByWeight).doubleValue();
				    	CommonFunctions.log.info("Excel License Fee By Weight is == " +df.format(DeclareVariable.dubLicenseFeeByWeight));
			    	}
			    	if(j==31)
			    	{
			    		DeclareVariable.excelMonthlyDeclaredGrossWeight = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubMonthlyDeclaredGrossWeight = Double.valueOf(DeclareVariable.excelMonthlyDeclaredGrossWeight).doubleValue();
				    	CommonFunctions.log.info("Excel Monthly Declared Gross Weight is == " +df.format(DeclareVariable.dubMonthlyDeclaredGrossWeight));
			    	}
			    	if(j==32)
			    	{
			    		DeclareVariable.excelFreightProjectFee = dataFormatter.formatCellValue(cell3);
			    		DeclareVariable.dubFreightProjectFee = Double.valueOf(DeclareVariable.excelFreightProjectFee).doubleValue();
				    	CommonFunctions.log.info("Excel Freight Project Fee is == " +df.format(DeclareVariable.dubFreightProjectFee));
			    	}
			    	System.out.print(cell3+ "|| ");
			    }
			    System.out.println();
			    
			    Thread.sleep(2000);
			    FunctionLibraries.clickButton("id", "submitButton", "Get Tax and Fee Calculation");
				//CommonFunctions.driver.findElement(By.id("submitButton")).click();
				
				Thread.sleep(2000);
				DeclareVariable.errorMessage = CommonFunctions.driver.findElement(By.id("errormsg")).getText();
				DeclareVariable.modalHeading = FunctionLibraries.locator("id", "myModalLabel").getText();
				try {
						if(DeclareVariable.modalHeading.equals("Summary of Fees"))
						{
							OnlineApplicationOutput.cccApplicationOutput();
							inputStream.close();
							
							updateExcel(cccWorkbook,i);
						    
						    Thread.sleep(2000);
							FunctionLibraries.clickButton("xpath", "//*[@id='resultsmodal']/div/div/div[3]/button", "Modal PopUp Close");
							CommonFunctions.log.info("*****Record Number -" +i+" Test Finished*****");
							CommonFunctions.log.info("\n");
							
							Thread.sleep(2000);
							CommonFunctions.driver.navigate().refresh();
							Thread.sleep(4000);
						}
						else {
							CommonFunctions.log.info(DeclareVariable.errorMessage);
							CommonFunctions.log.info("Test This Record Manually");
							CommonFunctions.log.info("*****Record Number -" +i+" Test Finished*****");
							CommonFunctions.log.info("\n");
							CommonFunctions.driver.navigate().refresh();
							Thread.sleep(4000);
						}
				}
				catch(Throwable ex)
				{
					CommonFunctions.log.info(DeclareVariable.errorMessage);
				}
			} 
			cccWorkbook.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void updateExcel(XSSFWorkbook Workbook, int i) throws IOException
	{
		//Try to writing in File Here
	    FileOutputStream out = new FileOutputStream(file);
	    
	    //Create XSSFFont object from the workbook 
		//XSSFFont myFont = Workbook.createFont();
	    
		//Get access to XSSFCellStyle 
        XSSFCellStyle mystyle = Workbook.createCellStyle();
		
		if(DeclareVariable.dubGrandTotal == DeclareVariable.labelSummaryFee && DeclareVariable.dubTotalSalesTax == DeclareVariable.labelTotalSalesFeesDataValue && 
				DeclareVariable.dubSalesTax == DeclareVariable.labelSaleTax && DeclareVariable.dubLocationRate == DeclareVariable.labelLocationRate && 
				DeclareVariable.dubAdditionalSalesUseTax == DeclareVariable.labelAdditionalSalesTax && DeclareVariable.dubTotalOtherFeeTax == DeclareVariable.labelOtherTaxesAndFees && 
				DeclareVariable.dubTotalRTA == DeclareVariable.labelTotalRTA && DeclareVariable.dubTitleFeeTotal == DeclareVariable.labelTitleFeesTotal && 
				DeclareVariable.dubTitleFilingFee == DeclareVariable.labelTitleFilingFee && DeclareVariable.dubApplicationFee == DeclareVariable.labelApplicationFee && 
				DeclareVariable.dubEmergencyMedicalServices == DeclareVariable.labelEmergencyMedicalServices && DeclareVariable.dubTotalRegistrationFees == DeclareVariable.labelRegistrationFeeTotal && 
				DeclareVariable.dubRegistrationFilingFee == DeclareVariable.labelRegFillingFee && DeclareVariable.dubVehicleTypeFee == DeclareVariable.labelVehicleTypeFee && 
				DeclareVariable.dubLicensePlateTechnologyFee == DeclareVariable.labelLicensePlateTechnologyFee && DeclareVariable.dublLicenseServiceFee == DeclareVariable.labelLicenseServiceFee && 
				DeclareVariable.dubVehicleWeightFee == DeclareVariable.labelVehicleWeightFee && DeclareVariable.dubLicenseFeeByWeight == DeclareVariable.labelLicenseFeeByWeight && 
				DeclareVariable.dubMonthlyDeclaredGrossWeight == DeclareVariable.labelMonthlyDeclaredGrossWeightLicenseFees && DeclareVariable.dubFreightProjectFee == DeclareVariable.labelFreightProjectFee)
		{
			//CommonFunctions.log.info("From 2nd Class :: " +DeclareVariable.excelGrandTotal);
			XSSFRow passRow = Workbook.getSheet("Sheet1").getRow(i);
		    //CommonFunctions.log.info(passRow.getCell(0).getStringCellValue());
		    XSSFCell passCell = passRow.createCell(0);
		    mystyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		    mystyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		    passCell.setCellValue("PASS");
		    passCell.setCellStyle(mystyle);
			    
		    Workbook.write(out);
		    out.close();
		}
		else
		{
			XSSFRow failRow = Workbook.getSheet("Sheet1").getRow(i);
			XSSFCell failCell = failRow.createCell(0);
			mystyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		    mystyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		    failCell.setCellValue("FAIL");
		    failCell.setCellStyle(mystyle);
			
			Workbook.write(out);
			out.close();
		}
	}
}