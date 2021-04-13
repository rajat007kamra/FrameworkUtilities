package com.qanonTesting.docsMenu;

import java.awt.AWTException;
import java.util.Arrays;
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

import com.qanonTesting.login.tests.Login1;
import com.qanonTesting.utilities.*;

public class DocsProducts
{
	public static long t1, t2, t3;
	
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try 
		{
			CreateExcelFile.createWorkbook();
			CommonMethods1.indicatorStartEnd("START", "DOCS: PRODUCTS-PROCESSES");
			Login1.verify_Login(CommonValues.txtUsername1, CommonValues.txtPassword1);
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 1)
	public static void navigateTo_DocsProductsPage() throws Exception
	{		
		try 
		{
			CommonMethods1.indicatorStartEnd("START", "DOCS: PRODUCTS-PROCESSES");
			Thread.sleep(5000);
			//Searching page and navigating to it
//			CommonMethods1.searchPage("REPORTS", "", "REPORTS PAGE SEARCHED");
			CommonMethods1.searchDocsPageNew("PRODUCTS", CommonValues.adminModule, "", "DOCS: PRODUCTS PAGE SEARCHED");
			CommonMethods1.closeExistingTab(CommonValues.docsModule);
			//Capture time when Securities page clicked
			t1 = new Date().getTime();
			CreateLogs.writeLogs("TIME WHEN HIT ENTER TO NAVIGATE ON 'DOCS: PRODUCTS' PAGE:- " +t1 +" milliseconds");
					
			DeclareVariables.wait1 = new WebDriverWait(DeclareVariables.driver1, 90);
			DeclareVariables.footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-DOQZ']//*[text()='PRODUCTS']//ancestor::span";
			if(FunctionLibraries1.isElementPresent(By.xpath(DeclareVariables.footerRowXPath)))
			{
				DeclareVariables.footerRow = DeclareVariables.wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeclareVariables.footerRowXPath))); 
				DeclareVariables.footerPageName = DeclareVariables.footerRow.getText();
				System.out.println("FOOTER ROW TEXT FOUND ::- " +DeclareVariables.footerPageName);
				Assert.assertEquals("PRODUCTS", DeclareVariables.footerPageName);
				//Capture time when Securities page opened and verified
				t2 = new Date().getTime();
				CreateLogs.writeLogs("TIME WHEN 'DOCS: PRODUCTS' PAGE OPENED AND VERIFIED:- " +t2 +" milliseconds");
//				CreateLogs.writeLogs("SYSTEM IS AT 'PRODUCTS' PAGE!!!");
				
				t3 = (t2-t1);
				DeclareVariables.timeTaken = t3 +" milliseconds";
				
				//Actual time to open Securities page
				CreateLogs.writeLogs("ACTUAL TIME TAKEN BY SYSTEM IN OPENING OF 'DOCS: PRODUCTS' PAGE:- " +DeclareVariables.timeTaken);
			
				//Call take screenshot function
				CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_DocsProductsPage_"+System.currentTimeMillis() +".png");
				
				//Print Result in Excel File
				DeclareVariables.passResultMessage = "SYSTEM IS AT 'DOCS: PRODUCTS' PAGE!!!";
				WriteTestResult.addRowInBasicSheet("navigateTo_DocsProductsPage", "PASS", DeclareVariables.timeTaken, CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.docsModule, CommonValues.txtUsername1, DeclareVariables.passResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY DOCS: PRODUCTS SCREEN", "DOCS: PRODUCTS SCREEN OPEN", "DOCS: PRODUCTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
			
				/* 
				 * 
				 * Code for Performance Report
				 *  
				 */
				DeclareVariables.openScreenCounting = DeclareVariables.openScreenCounting+1;
//				System.out.println("OPEN SCREEN" +DeclareVariables.openScreenCounting);
				String noOfAction = Integer.toString(DeclareVariables.openScreenCounting);
				System.out.println(noOfAction);
				DeclareVariables.openDocsProductsTime = (double) (t2-t1)/1000;				
				if(DeclareVariables.openDocsProductsTime <0)
				{
					DeclareVariables.openDocsProductsTime = 0.00;
				}
				else
				{
					
				}
				CreateLogs.writeLogs("DOCS PAGE OPEN TIME ::- " +DeclareVariables.openDocsProductsTime);
			}
			else
			{
				//Call take screenshot function
				CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_DocsProductsPage_"+System.currentTimeMillis() +".png");
				DeclareVariables.failResultMessage = "'DOCS: PRODUCTS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Print Result in Excel File
				WriteTestResult.addRowInBasicSheet("navigateTo_DocsProductsPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.docsModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY DOCS: PRODUCTS SCREEN", "DOCS: PRODUCTS SCREEN NOT FOUND", "DOCS: PRODUCTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
//				Assert.fail(DeclareVariables.failResultMessage);				
				
				/*
				 * Code for Performance Report
				 */
				DeclareVariables.openScreenCounting = DeclareVariables.openScreenCounting+1;
//				System.out.println("OPEN SCREEN" +DeclareVariables.openScreenCounting);
				String noOfAction = Integer.toString(DeclareVariables.openScreenCounting);
				System.out.println(noOfAction);
				DeclareVariables.openDocsProductsTime = (double) (t2-t1)/1000;
				
				double[] nums = {DeclareVariables.openFeedTime, DeclareVariables.openTeamsTime, DeclareVariables.openEntityTime, DeclareVariables.openProductsTime, DeclareVariables.openSecurityTermsTime, DeclareVariables.openSampleTime, DeclareVariables.openSecuritiesTime, DeclareVariables.openReportsTime, DeclareVariables.openIssuersTime, DeclareVariables.openDocsProductsTime};
				Arrays.sort(nums);
		        
				String minValue = String.format("%.2f", nums[0]);
				String maxValue = String.format("%.2f", nums[nums.length-1]);
				String meanValue = String.format("%.2f", (nums[0] + nums[nums.length-1])/2);
				
				//Calling percentile methods for values
			    DeclareVariables.percentile90 = Percentile.findPercentile(minValue, maxValue, 90);
			    DeclareVariables.percentile95 = Percentile.findPercentile(minValue, maxValue, 95);
				
				WriteTestResult.addRowInPerformanceSheet("OPEN SCREEN", noOfAction, minValue, maxValue, meanValue, DeclareVariables.percentile90, DeclareVariables.percentile95);
			}
		}
		catch(Exception ex)
		{
			//Call take screenshot function
			CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_DocsProductsPage_"+System.currentTimeMillis() +".png");
			DeclareVariables.failResultMessage = "'DOCS: PRODUCTS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("navigateTo_DocsProductsPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.docsModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY DOCS: PRODUCTS SCREEN", "DOCS: PRODUCTS SCREEN NOT FOUND", "DOCS: PRODUCTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 2)
	public static void findRecords_DocsProductsPage() throws Exception
	{
		try
		{
			Thread.sleep(1500);
            String footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-DOQZ']//div[@class='VZ-WGT-BDY-DECK']//div[@class='GRID-WGT vert-flex-cnt cnt-flex-start']//div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el GRIDWGT-OUTER-CNT-WITH-LFT-DRWR']//div[@class='GRIDWGT-INNER']//div[@class='GRID-WGT-TOTALS-OUTER']//div[@class='GRID-TOTALS-WGT']//div[@class='GRID-MSG-WGT']//div[@class='GRID-MSG-WGT-ITEMS-OUTER']//div//div[@class='gwt-Label']";
            List<WebElement> valueF= DeclareVariables.driver1.findElements(By.xpath(footerRowXPath));
            for(int i=0;i<valueF.size();i++){
            	DeclareVariables.pageCount = valueF.get(i).getText();
            	CreateLogs.writeLogs("RECORDS COUNT OF 'DOCS: PRODUCTS' PAGE ::- " +DeclareVariables.pageCount);
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
	    		CreateLogs.writeLogs("ACTUAL NUMBER OF RECORDS DISPLAYING IN 'DOCS: PRODUCTS' PAGE ::- " +rowCount);
	    		CommonMethods1.closePopUp();
	    		//Call take screenshot function
		        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "findRecords_DocsProductsPage_"+System.currentTimeMillis() +".png");
		    	//Print Result in Excel File
	    		DeclareVariables.passResultMessage = rowCount +" - RECORDS FOUND IN 'DOCS: PRODUCTS' PAGE!!!";
	    		WriteTestResult.addRowInBasicSheet("findRecords_DocsProductsPage", "PASS", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.docsModule, CommonValues.txtUsername1, DeclareVariables.passResultMessage);
	    		WriteTestResult.addRowInDetailsSheet("DOCS: PRODUCTS RECORDS", "FIND RECORDS - " +rowCount, "DOCS: PRODUCTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.passResultMessage);
	    	}
	    	else
			{
	    		//Call take screenshot function
		        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "findRecords_DocsProductsPage_"+System.currentTimeMillis() +".png");
		        CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Print Result in Excel File
	    		DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'DOCS: PRODUCTS' PAGE OR ELEMENT LOCATOR NOT MATCHED!!!";
	    		WriteTestResult.addRowInBasicSheet("findRecords_DocsProductsPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.docsModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);				
	    		WriteTestResult.addRowInDetailsSheet("DOCS: PRODUCTS RECORDS", "RECORD COUNT NOT FOUND", "DOCS: PRODUCTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.failResultMessage);
			}
		}
		catch(Exception ex)
		{
			//Call take screenshot function
	        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "findRecords_DocsProductsPage_"+System.currentTimeMillis() +".png");
	        DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'PRODUCTS' PAGE OR ELEMENT LOCATOR NOT MATCHED!!!";
	        CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File
    		WriteTestResult.addRowInBasicSheet("findRecords_DocsProductsPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.docsModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);				
    		WriteTestResult.addRowInDetailsSheet("DOCS: PRODUCTS RECORDS", "RECORD COUNT NOT FOUND", "DOCS: PRODUCTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.failResultMessage);
    		CreateLogs.writeLogs(ex.getMessage());
		}
		CommonMethods1.indicatorStartEnd("END", "DOCS: PRODUCTS-PROCESSES");
	}
	
	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
//		CommonMethods1.refreshPage();
//		Thread.sleep(5000);
		CommonMethods1.indicatorStartEnd("END", "DOCS: PRODUCTS-PROCESSES");
//		DeclareVariables.driver1.close();
//		DeclareVariables.driver1.quit();
	}
}
