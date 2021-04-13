package com.qanonTesting.adminMenu;

import java.awt.AWTException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qanonTesting.login.tests.Login1;
import com.qanonTesting.utilities.*;

public class Samples 
{
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try 
		{
			CommonMethods1.indicatorStartEnd("START", "SAMPLES-ADMIN");
			Login1.verify_Login(CommonValues.txtUsername1, CommonValues.txtPassword1);
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 1)
	public static void navigateTo_SamplesPage() throws Exception
	{
		try 
		{
			CommonMethods1.indicatorStartEnd("START", "SAMPLES-ADMIN");
			Thread.sleep(5000);
			//Searching page and navigating to it
			CommonMethods1.searchPage("SAMPLES", "", "SAMPLES PAGE SEARCHED");
//			CommonMethods1.searchPageNew("SAMPLES", CommonValues.processesModule, "", "SAMPLES PAGE SEARCHED");
			CommonMethods1.closeExistingTab(CommonValues.adminModule);
			CommonMethods1.resetPage(CommonValues.adminModule);
			CommonMethods1.closeExistingTab(CommonValues.adminModule);
			
			//Capture time when Login button clicked
			long t1 = new Date().getTime();
			CreateLogs.writeLogs("TIME WHEN HIT ENTER TO NAVIGATE ON 'SAMPLES' PAGE:- " +t1 +" milliseconds");
			
			DeclareVariables.wait1 = new WebDriverWait(DeclareVariables.driver1, 90);
			DeclareVariables.footerRowXPath = "//div[@class='REALM-BDY-CNT REALM-BDY-EL REALM-BDY-CNT-QONCIERGE HAS-TRANS-300']//*[text()='SAMPLES']//ancestor::span";
			
			if(FunctionLibraries1.isElementPresent(By.xpath(DeclareVariables.footerRowXPath)))
			{
				DeclareVariables.footerRow = DeclareVariables.wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeclareVariables.footerRowXPath)));	
				String footerText = DeclareVariables.footerRow.getText();
				
				Assert.assertEquals("SAMPLES", footerText);
				//Capture time when Login button clicked
				long t2 = new Date().getTime();		
				CreateLogs.writeLogs("TIME WHEN 'SAMPLES' PAGE OPENED AND VERIFIED:- " +t2 +" milliseconds");
//				CreateLogs.writeLogs("SYSTEM IS AT 'SAMPLES' page!!!");
				
				DeclareVariables.timeTaken = (t2-t1) + " milliseconds";
				
				//Actual time to open Securities page
				CreateLogs.writeLogs("ACTUAL TIME TAKEN BY SYSTEM IN OPENING OF 'SAMPLES' PAGE:- " +DeclareVariables.timeTaken);
				//Call take screenshot function
				CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_SamplesPage_"+System.currentTimeMillis() +".png");
				DeclareVariables.passResultMessage = "SYSTEM IS AT 'SAMPLES' PAGE!!!";
				//Print Result in Excel File
				WriteTestResult.addRowInBasicSheet("navigateTo_SamplesPage", "PASS", DeclareVariables.timeTaken, CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername1, DeclareVariables.passResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY SAMPLES SCREEN", "SAMPLES SCREEN OPEN", "SAMPLES", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
			
				/*
				 * Code for Performance Report
				 */
				DeclareVariables.openScreenCounting = DeclareVariables.openScreenCounting+1;
				System.out.println("OPEN SCREEN " +DeclareVariables.openScreenCounting);
				String noOfAction = Integer.toString(DeclareVariables.openScreenCounting);
				System.out.println(noOfAction);
				DeclareVariables.openSampleTime = (double) (t2-t1)/1000;
				if(DeclareVariables.openSampleTime <0)
				{
					DeclareVariables.openSampleTime = 0.00;
				}
				else
				{
					
				}
			}
			else
			{
				DeclareVariables.failResultMessage = "'SAMPLES' PAGE NOT FOUND OR PAGE NAME NOT MATCHED. PLEASE CHECK SCREENSHOT IN OUTPUT FOLDER!!!";
				//Call take screenshot function
				CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_SamplesPage_"+System.currentTimeMillis() +".png");
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Print Result in Excel File
				WriteTestResult.addRowInBasicSheet("navigateTo_SamplesPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY SAMPLES SCREEN", "SAMPLES SCREEN NOT FOUND", "SAMPLES", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
			}
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
			DeclareVariables.failResultMessage = "'SAMPLES' PAGE NOT FOUND OR PAGE NAME NOT MATCHED. PLEASE CHECK SCREENSHOT IN OUTPUT FOLDER!!!";
			//Call take screenshot function
			CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_SamplesPage_"+System.currentTimeMillis() +".png");
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("navigateTo_SamplesPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY SAMPLES SCREEN", "SAMPLES SCREEN NOT FOUND", "SAMPLES", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
		}
	}
	
	@Test(priority = 2)
	public static void findRecords_SamplesPage() throws Exception
	{
		try {
			Thread.sleep(2000);
            String footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-QONCIERGE']//div[@class='GRID-MSG-WGT-ITEMS-OUTER']";
            List<WebElement> valueF= DeclareVariables.driver1.findElements(By.xpath(footerRowXPath));
            for(int i=0;i<valueF.size();i++){
            	DeclareVariables.pageCount = valueF.get(i).getText();
            	CreateLogs.writeLogs("RECORDS COUNT OF 'SAMPLES' PAGE::- " +DeclareVariables.pageCount);
            }
            
            String abc = null;
		    String[] arrSplit = DeclareVariables.pageCount.split(" ");
		    for (int i = 0; i < 1; i++)
		    {
		    	abc = arrSplit[0];
		    } 
		    
		    //Removing comma from Count if exists
		    String regex = "(?<=[\\d])(,)(?=[\\d])";
		    Pattern p = Pattern.compile(regex);
		    String str = abc;
		    Matcher m = p.matcher(str);
		    str = m.replaceAll("");
		    
			int rowCount = Integer.parseInt(str);    	
	    	if(rowCount >= 0)
	    	{
	    		CreateLogs.writeLogs("ACTUAL NUMBER OF RECORDS DISPLAYING IN 'SAMPLES' PAGE ::- " +rowCount);
	    		CommonMethods1.closePopUp();
	    		//Call take screenshot function
	    		CommonMethods1.takeSnapShot(DeclareVariables.driver1, "findRecords_SamplesPage._"+System.currentTimeMillis() +".png");
		    	//Print Result in Excel File
	    		DeclareVariables.passResultMessage = rowCount+" - RECORDS FOUND IN 'SAMPLES' PAGE!!!";
	    		WriteTestResult.addRowInBasicSheet("findRecords_SamplesPage", "PASS", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername1, DeclareVariables.passResultMessage);
	    		WriteTestResult.addRowInDetailsSheet("SAMPLES RECORDS", "FIND RECORDS - " +rowCount, "SAMPLES", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.passResultMessage);
	    	}
	    	else
			{
	    		DeclareVariables.failResultMessage = "SYSTEM NOT ABLE TO FIND RECORDS IN 'SAMPLES' PAGE or RECORDS COUNT NOT FOUND!!!";
	    		//Call take screenshot function
		        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "findRecords_SamplesPage_"+System.currentTimeMillis() +".png");
		        CreateLogs.writeLogs(DeclareVariables.failResultMessage);
		        //Print Result in Excel File
		        WriteTestResult.addRowInBasicSheet("findRecords_SamplesPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
		        WriteTestResult.addRowInDetailsSheet("SAMPLES RECORDS", "RECORD COUNT NOT FOUND", "SAMPLES", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.failResultMessage);
			}
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
			DeclareVariables.failResultMessage = "SYSTEM NOT ABLE TO FIND RECORDS IN 'SAMPLES' PAGE or RECORDS COUNT NOT FOUND!!!";
    		//Call take screenshot function
	        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "findRecords_SamplesPage_"+System.currentTimeMillis() +".png");
	        CreateLogs.writeLogs(DeclareVariables.failResultMessage);
	        //Print Result in Excel File
	        WriteTestResult.addRowInBasicSheet("findRecords_SamplesPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
	        WriteTestResult.addRowInDetailsSheet("SAMPLE RECORDS", "RECORD COUNT NOT FOUND", "SAMPLES", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.failResultMessage);
		}
		CommonMethods1.indicatorStartEnd("END", "SAMPLES-ADMIN");
	}

	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
		CommonMethods1.refreshPage();
		Thread.sleep(5000);
		CommonMethods1.indicatorStartEnd("END", "SAMPLES-ADMIN");
		DeclareVariables.driver1.close();
		DeclareVariables.driver1.quit();
	}
}
