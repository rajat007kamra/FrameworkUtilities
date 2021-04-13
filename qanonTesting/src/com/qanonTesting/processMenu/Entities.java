package com.qanonTesting.processMenu;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qanonTesting.login.tests.Login2;
import com.qanonTesting.utilities.*;

public class Entities 
{
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try 
		{			
			CreateExcelFile.createWorkbook();
			CommonMethods2.indicatorStartEnd("START", "ENTITIES-PROCESSES");
			Login2.verify_Login(CommonValues.txtUsername2, CommonValues.txtPassword2);	
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 1)
	public static void navigateTo_EntitiesPage() throws Exception
	{
		try 
		{
			CommonMethods2.indicatorStartEnd("START", "ENTITIES-PROCESSES");
//			Thread.sleep(5000);
			//Searching page and navigating to it
//			CommonMethods2.searchPage("ENTITIES", "", "ENTITIES PAGE SEARCHED");
			CommonMethods2.searchPageNew("ENTITIES", CommonValues.processesModule, "", "ENTITIES PAGE SEARCHED");
			CommonMethods2.closeExistingTab(CommonValues.processesModule);
			CommonMethods2.resetPage(CommonValues.processesModule);
			CommonMethods2.closeExistingTab(CommonValues.processesModule);
			
			//Capture time when Securities page clicked
			long t1 = new Date().getTime();
			CreateLogs.writeLogs("TIME WHEN HIT ENTER TO NAVIGATE ON 'ENTITIES' PAGE:- " +t1 +" milliseconds");
					
			DeclareVariables.wait2 = new WebDriverWait(DeclareVariables.driver2, 90);
			DeclareVariables.footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']//*[text()='ENTITIES']//ancestor::span"; 
			
			if(DeclareVariables.driver2.findElements(By.xpath(DeclareVariables.footerRowXPath)).size()>0)
			{
				DeclareVariables.footerRow = DeclareVariables.wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeclareVariables.footerRowXPath))); 
				DeclareVariables.footerPageName = DeclareVariables.footerRow.getText();
				System.out.println("FOOTER MESSAGE FOUND ::= " +DeclareVariables.footerPageName);
				Assert.assertEquals("ENTITIES", DeclareVariables.footerPageName);
				//Capture time when Securities page opened and verified
				long t2 = new Date().getTime();
				CreateLogs.writeLogs("TIME WHEN 'ENTITIES' PAGE OPENED AND VERIFIED:- " +t2 +" milliseconds");
//				CreateLogs.writeLogs("SYSTEM IS AT 'ENTITIES' PAGE!!!");
				
				DeclareVariables.timeTaken = (t2-t1) +" milliseconds";
				
				//Actual time to open Securities page
				CreateLogs.writeLogs("ACTUAL TIME TAKEN BY SYSTEM IN OPENING OF 'ENTITIES' PAGE:- " +DeclareVariables.timeTaken);
			
				//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_EntitiesPage_"+System.currentTimeMillis() +".png");
				
				//Print Result in Excel File
				DeclareVariables.passResultMessage = "SYSTEM IS AT 'ENTITIES' PAGE!!!";
				WriteTestResult.addRowInBasicSheet("navigateTo_EntitiesPage", "PASS", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY ENTITIES SCREEN", "ENTITIES SCREEN OPEN", "ENTITIES", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
			
				/*
				 * Code for Performance Report
				 */
				
				DeclareVariables.openScreenCounting = DeclareVariables.openScreenCounting+1;
//				System.out.println("OPEN SCREEN " +DeclareVariables.openScreenCounting);
				String noOfAction = Integer.toString(DeclareVariables.openScreenCounting);
				System.out.println(noOfAction);
				DeclareVariables.openEntityTime = (double) (t2-t1)/1000;
				if(DeclareVariables.openEntityTime <0)
				{
					DeclareVariables.openEntityTime = 0.00;
				}
				else
				{
					
				}
			}
			else
			{
				//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_EntitiesPage_"+System.currentTimeMillis() +".png");
				DeclareVariables.failResultMessage = "'ENTITIES' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Print Result in Excel File
				WriteTestResult.addRowInBasicSheet("navigateTo_EntitiesPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY ENTITIES SCREEN", "ENTITIES SCREEN NOT FOUND", "ENTITIES", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
//				Assert.fail(DeclareVariables.failResultMessage);				
			}
		}
		catch(Exception ex)
		{
			//Call take screenshot function
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_EntitiesPage_"+System.currentTimeMillis() +".png");
			DeclareVariables.failResultMessage = "'ENTITIES' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("navigateTo_EntitiesPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY ENTITIES SCREEN", "ENTITIES SCREEN NOT FOUND", "ENTITIES", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
//			Assert.fail(DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 2)
	public static void findRecords_EntitiesPage() throws Exception
	{
		try
		{
			Thread.sleep(1500);
            String footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']//div[@class='VZ-WGT-BDY-DECK']//div[@class='GRID-WGT vert-flex-cnt']//div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']//div[@class='GRIDWGT-INNER']//div[@class='GRID-WGT-TOTALS-OUTER']//div[@class='GRID-TOTALS-WGT']//div[@class='GRID-MSG-WGT']//div[@class='GRID-MSG-WGT-ITEMS-OUTER']//div//div[@class='gwt-Label']";
            List<WebElement> valueF= DeclareVariables.driver2.findElements(By.xpath(footerRowXPath));
            for(int i=0;i<valueF.size();i++){
            	DeclareVariables.pageCount = valueF.get(i).getText();
            	CreateLogs.writeLogs("RECORDS COUNT OF 'ENTITIES' PAGE ::- " +DeclareVariables.pageCount);
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
	    		CreateLogs.writeLogs("ACTUAL NUMBER OF RECORDS DISPLAYING IN 'ENTITIES' PAGE::- " +rowCount);
	    		CommonMethods2.closePopUp();
	    		//Call take screenshot function
		        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_EntitiesPage_"+System.currentTimeMillis() +".png");
		    	//Print Result in Excel File
	    		DeclareVariables.passResultMessage = rowCount +" - RECORDS FOUND IN 'ENTITIES' PAGE!!!";
	    		WriteTestResult.addRowInBasicSheet("findRecords_EntitiesPage", "PASS", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
	    		WriteTestResult.addRowInDetailsSheet("ENTITIES RECORDS", "FIND RECORDS - " +rowCount, "ENTITIES", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.passResultMessage);
	    	}
	    	else
			{
	    		//Call take screenshot function
		        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_EntitiesPage_"+System.currentTimeMillis() +".png");
		        CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Print Result in Excel File
	    		DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'ENTITIES' PAGE OR ELEMENT LOCATOR NOT MATCHED!!!";
	    		WriteTestResult.addRowInBasicSheet("findRecords_EntitiesPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);				
	    		WriteTestResult.addRowInDetailsSheet("ENTITIES RECORDS", "RECORD COUNT NOT FOUND", "ENTITIES", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
//	    		Assert.fail(DeclareVariables.failResultMessage);				
			}
		}
		catch(Exception ex)
		{
			//Call take screenshot function
	        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_EntitiesPage_"+System.currentTimeMillis() +".png");
	        DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'ENTITIES' PAGE OR ELEMENT LOCATOR NOT MATCHED!!!";
	        CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File
    		WriteTestResult.addRowInBasicSheet("findRecords_EntitiesPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);				
    		WriteTestResult.addRowInDetailsSheet("ENTITIES RECORDS", "RECORD COUNT NOT FOUND", "ENTITIES", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
//    		Assert.fail(DeclareVariables.failResultMessage);
    		CreateLogs.writeLogs(ex.getMessage());
		}
		CommonMethods2.indicatorStartEnd("END", "ENTITIES-PROCESSES");
	}
	
	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
		CommonMethods2.refreshPage();
		Thread.sleep(5000);
		CommonMethods2.indicatorStartEnd("END", "ENTITIES-PROCESSES");
		DeclareVariables.driver2.close();
		DeclareVariables.driver2.quit();
	}
}
