package com.qanonTesting.processMenu;

import java.awt.AWTException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qanonTesting.utilities.*;

public class SecurityTerms 
{
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try {
			CommonMethods2.indicatorStartEnd("START", "SECURITY TERMS-PROCESSES");
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 1)
	public static void navigateTo_SecurityTermsPage() throws Exception
	{
		try 
		{
			CommonMethods2.indicatorStartEnd("START", "SECURITY TERMS-PROCESSES");
			Thread.sleep(5000);
			//Searching page and navigating to it
//			CommonMethods2.searchPage("SECURITY TERMS", "", "SECURITY TERMS PAGE SEARCHED");
			CommonMethods2.searchPageNew("SECURITY TERMS", CommonValues.processesModule, "", "SECURITY TERMS PAGE SEARCHED");
			CommonMethods2.closeExistingTab(CommonValues.processesModule);			
			CommonMethods2.resetPage(CommonValues.processesModule);
			CommonMethods2.closeExistingTab(CommonValues.processesModule);
			
			//Capture time when Securities Terms page clicked
			long t1 = new Date().getTime();
			CreateLogs.writeLogs("TIME WHEN HIT ENTER TO NAVIGATE ON 'SECURITY TERMS' PAGE:- " +t1 +" milliseconds");
					
			DeclareVariables.wait2 = new WebDriverWait(DeclareVariables.driver2, 90);
			DeclareVariables.footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']//*[text()='SECURITY TERMS']//ancestor::span";
			
			if(FunctionLibraries2.isElementPresent(By.xpath(DeclareVariables.footerRowXPath)))
			{
				DeclareVariables.footerRow = FunctionLibraries2.locator("xpath", DeclareVariables.footerRowXPath);
				DeclareVariables.footerPageName = DeclareVariables.footerRow.getText();
				
				Assert.assertEquals("SECURITY TERMS", DeclareVariables.footerPageName);
				//Capture time when Securities Terms page opened and verified
				long t2 = new Date().getTime();
				CreateLogs.writeLogs("TIME WHEN 'SECURITY TERMS' PAGE OPENED AND VERFIED:- " +t2 +" milliseconds");
				CreateLogs.writeLogs("SYSTEM IS AT 'SECURITY TERMS' PAGE!!!");
				
				long t3 = (t2-t1);
				DeclareVariables.timeTaken = t3 +" milliseconds";
				//Actual time to open Securities Terms page
				CreateLogs.writeLogs("ACTUAL TIME TAKEN BY SYSTEM IN OPENING OF 'SECURITY TERMS' PAGE:- " + DeclareVariables.timeTaken);
				
				//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_SecurityTerms_"+System.currentTimeMillis() +".png");
				
				//Print Result in Excel File
				DeclareVariables.passResultMessage = "SYSTEM IS AT 'SECURITY TERMS' PAGE!!!";
				WriteTestResult.addRowInBasicSheet("navigateTo_SecurityTermsPage", "PASS", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY SECURITY TERMS SCREEN", "SECURITY TERMS SCREEN OPEN", "SECURITY TERMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
			
				/*
				 * Code for Performance Report
				 */
				
				DeclareVariables.openScreenCounting = DeclareVariables.openScreenCounting+1;
//				System.out.println("OPEN SCREEN " +DeclareVariables.openScreenCounting);
				String noOfAction = Integer.toString(DeclareVariables.openScreenCounting);
				System.out.println(noOfAction);
				DeclareVariables.openSecurityTermsTime = (double) (t2-t1)/1000;
				if(DeclareVariables.openSecurityTermsTime <0)
				{
					DeclareVariables.openSecurityTermsTime = 0.00;
				}
				else
				{
					
				}
			}
			else
			{
				DeclareVariables.failResultMessage = "'SECURITY TERMS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
				//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_SecurityTerms_"+System.currentTimeMillis() +".png");
				//Print Result in Excel File
				WriteTestResult.addRowInBasicSheet("navigateTo_SecurityTermsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY SECURITY TERMS SCREEN", "SECURITY TERMS SCREEN NOT FOUND", "SECURITY TERMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
			}
		}
		catch(Exception ex)
		{			
			DeclareVariables.failResultMessage = "'SECURITY TERMS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
			//Call take screenshot function
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_SecurityTerms_"+System.currentTimeMillis() +".png");
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("navigateTo_SecurityTermsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY SECURITY TERMS SCREEN", "SECURITY TERMS SCREEN NOT FOUND", "SECURITY TERMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 2)
	public static void findRecords_SecurityTermsPage() throws Exception
	{
		try 
		{
			Thread.sleep(1500);
            String footerRowXPath="//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']//div[@class='VZ-WGT-BDY-DECK']//div[@class='GRID-WGT vert-flex-cnt']//div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']//div[@class='GRIDWGT-INNER']//div[@class='GRID-WGT-TOTALS-OUTER']//div[@class='GRID-TOTALS-WGT']//div[@class='GRID-MSG-WGT']//div[@class='GRID-MSG-WGT-ITEMS-OUTER']//div//div[@class='gwt-Label']";

            List<WebElement> valueF= DeclareVariables.driver2.findElements(By.xpath(footerRowXPath));
            for(int i=0;i<valueF.size();i++){
            	DeclareVariables.pageCount = valueF.get(i).getText();
            	CreateLogs.writeLogs("RECORDS COUNT OF 'SECURITIES TERMS' PAGE ::- " +DeclareVariables.pageCount);
            }
            
            String abc = null;
		    String[] arrSplit = DeclareVariables.pageCount.split(" ");
		    for (int i = 0; i < 1; i++)
		    {
		    	abc = arrSplit[0];
		    } 
		    	    	
		    //Removing Comma from count
		    String regex = "(?<=[\\d])(,)(?=[\\d])";
		    Pattern p = Pattern.compile(regex);
		    String str = abc;
		    Matcher m = p.matcher(str);
		    str = m.replaceAll("");
//		    System.out.println("STR ::- " +str);
		    
			int rowCount = Integer.parseInt(str);    	
	    	if(rowCount >= 0)
	    	{
	    		CreateLogs.writeLogs("ACTUAL NUMBER OF RECORDS DISPLAYING IN 'SECURITY TERMS' PAGE::- " +rowCount);
	    		CommonMethods2.closePopUp();
		    	
	    		//Call take screenshot function
		        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_SecurityTermsPage_"+System.currentTimeMillis() +".png");
		        
		    	//Print Result in Excel File
		        DeclareVariables.passResultMessage = rowCount+" - RECORDS FOUND IN 'SECURITY TERMS' PAGE!!!";
		        WriteTestResult.addRowInBasicSheet("findRecords_SecurityTermsPage", "PASS", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
		        WriteTestResult.addRowInDetailsSheet("SECURITY TERMS RECORDS", "FIND RECORDS - " +rowCount, "SECURITY TERMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.passResultMessage);
	    	}
	    	else
			{
	    		DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'SECURITY TERMS' PAGE OR ELEMENT LOCATOR NOT MATCHED";
	    		CreateLogs.writeLogs(DeclareVariables.failResultMessage);
	    		//Call take screenshot function
		        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_SecurityTermsPage_"+System.currentTimeMillis() +".png");
				//Print Result in Excel File
		        WriteTestResult.addRowInBasicSheet("findRecords_SecurityTermsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
		        WriteTestResult.addRowInDetailsSheet("SECURITY TERMS RECORDS", "RECORD COUNT NOT FOUND", "SECURITY TERMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);			
			}
		}
		catch(Exception ex)
		{
			DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'SECURITY TERMS' PAGE OR ELEMENT LOCATOR NOT MATCHED";
    		CreateLogs.writeLogs(DeclareVariables.failResultMessage);
    		//Call take screenshot function
	        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_SecurityTermsPage_"+System.currentTimeMillis() +".png");
			//Print Result in Excel File
	        WriteTestResult.addRowInBasicSheet("findRecords_SecurityTermsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
	        WriteTestResult.addRowInDetailsSheet("SECURITY TERMS RECORDS", "RECORD COUNT NOT FOUND", "SECURITY TERMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
	        CreateLogs.writeLogs(ex.getMessage());
		}
		CommonMethods2.indicatorStartEnd("END", "SECURITY TERMS-PROCESSES");
	}
	
	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
		CommonMethods2.refreshPage();
		Thread.sleep(5000);
		CommonMethods2.indicatorStartEnd("END", "SECURITY TERMS-PROCESSES");
		DeclareVariables.driver2.close();
		DeclareVariables.driver2.quit();
	}
}