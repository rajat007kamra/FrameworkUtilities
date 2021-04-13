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
import org.testng.annotations.*;

import com.qanonTesting.login.tests.Login1;
import com.qanonTesting.utilities.*;

public class Securities 
{
	public static long t1, t2;
	
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try {
			CreateExcelFile.createWorkbook();
			CommonMethods1.indicatorStartEnd("START", "SECURITIES-PROCESSES");
			Login1.verify_Login(CommonValues.txtUsername1, CommonValues.txtPassword1);		
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 1)
	public static void navigateTo_SecuritiesPage() throws Exception
	{
		try 
		{
			CommonMethods1.indicatorStartEnd("START", "SECURITIES-PROCESSES");
			Thread.sleep(5000);
			//Searching page and navigating to it
//			CommonMethods1.searchPage("SECURITIES", "", "SECURITIES PAGE SEARCHED");
			CommonMethods1.searchPageNew("SECURITIES", CommonValues.docsModule, "", "SECURITIES PAGE SEARCHED");
			CommonMethods1.closeExistingTab(CommonValues.processesModule);
			CommonMethods1.expandRightMenu(CommonValues.processesModule);
			CommonMethods1.resetPage(CommonValues.processesModule);
			CommonMethods1.closeExistingTab(CommonValues.processesModule);
			
			//Capture time when Securities page clicked
			t1 = new Date().getTime();
			CreateLogs.writeLogs("TIME WHEN HIT ENTER TO NAVIGATE ON 'SECURITIES' PAGE:- " +t1 +" milliseconds");
					
			DeclareVariables.wait1 = new WebDriverWait(DeclareVariables.driver1, 90);
			DeclareVariables.footerRowXPath = "//*[text()='SECURITIES']//ancestor::span";
			
			if(FunctionLibraries1.isElementPresent(By.xpath(DeclareVariables.footerRowXPath)))
			{
				DeclareVariables.footerRow = DeclareVariables.wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeclareVariables.footerRowXPath))); 
				DeclareVariables.footerPageName = DeclareVariables.footerRow.getText();
				
				Assert.assertEquals("SECURITIES", DeclareVariables.footerPageName);
				//Capture time when Securities page opened and verified
				t2 = new Date().getTime();
				CreateLogs.writeLogs("TIME WHEN 'SECURITIES' PAGE OPENED AND VERIFIED:- " +t2 +" milliseconds");
//				CreateLogs.writeLogs("SYSTEM IS AT 'SECURITIES' PAGE!!!");
				
				DeclareVariables.timeTaken = (t2-t1) +" milliseconds";
				
				//Actual time to open Securities page 		  
				CreateLogs.writeLogs("ACTUAL TIME TAKEN BY SYSTEM IN OPENING OF 'SECURITIES' PAGE:- " +DeclareVariables.timeTaken);
			
				//Call take screenshot function
				CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_SecuritiesPage_"+System.currentTimeMillis() +".png");
				
				//Print Result in Excel File
				DeclareVariables.passResultMessage = "SYSTEM IS AT 'SECURITIES' PAGE!!!";
				WriteTestResult.addRowInBasicSheet("navigateTo_SecuritiesPage", "PASS", DeclareVariables.timeTaken, CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername1, DeclareVariables.passResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY SECURITIES SCREEN", "SECURITIES SCREEN OPEN", "SECURITIES", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
			
				/* 
				 * 
				 * Code for Performance Report
				 *  
				 */
				
				DeclareVariables.openScreenCounting = DeclareVariables.openScreenCounting+1;
//				System.out.println("OPEN SCREEN " +DeclareVariables.openScreenCounting);
				String noOfAction = Integer.toString(DeclareVariables.openScreenCounting);
				System.out.println(noOfAction);
				DeclareVariables.openSecuritiesTime = (double) (t2-t1)/1000;
				if(DeclareVariables.openSecuritiesTime <0)
				{
					DeclareVariables.openSecuritiesTime = 0.00;
				}
				else
				{
					
				}
			}
			else
			{
				DeclareVariables.failResultMessage = "'SECURITIES' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
				//Call take screenshot function
				CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_SecuritiesPage_"+System.currentTimeMillis() +".png");
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Print Result in Excel File
				WriteTestResult.addRowInBasicSheet("navigateTo_SecuritiesPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY SECURITIES SCREEN", "SECURITIES SCREEN NOT FOUND", "SECURITIES", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
//				Assert.fail(DeclareVariables.failResultMessage);				
				
				/* 
				 * 
				 * Code for Performance Report
				 *  
				 */
				
				DeclareVariables.openScreenCounting = DeclareVariables.openScreenCounting+1;
//				System.out.println("OPEN SCREEN " +DeclareVariables.openScreenCounting);
				String noOfAction = Integer.toString(DeclareVariables.openScreenCounting);
				System.out.println(noOfAction);
				DeclareVariables.openSecuritiesTime = (double) (t2-t1)/1000;
			}
		}
		catch(Exception ex)
		{			
			DeclareVariables.failResultMessage = "'SECURITIES' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
			//Call take screenshot function
			CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_SecuritiesPage_"+System.currentTimeMillis() +".png");
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("navigateTo_SecuritiesPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY SECURITIES SCREEN ", "SECURITIES SCREEN NOT FOUND", "SECURITIES", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 2)
	public static void findRecords_SecuritiesPage() throws Exception
	{
		try
		{
			Thread.sleep(1500);
            String footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']//div[@class='VZ-WGT-BDY-DECK']//div[@class='GRID-WGT vert-flex-cnt']//div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']//div[@class='GRIDWGT-INNER']//div[@class='GRID-WGT-TOTALS-OUTER']//div[@class='GRID-TOTALS-WGT']//div[@class='GRID-MSG-WGT']//div[@class='GRID-MSG-WGT-ITEMS-OUTER']//div//div[@class='gwt-Label']";
            List<WebElement> valueF= DeclareVariables.driver1.findElements(By.xpath(footerRowXPath));
            for(int i=0;i<valueF.size();i++){
            	DeclareVariables.pageCount = valueF.get(i).getText();
            	CreateLogs.writeLogs("RECORDS COUNT OF 'SECURITIES' PAGE ::- " +DeclareVariables.pageCount);
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
	    		CreateLogs.writeLogs("ACTUAL NUMBER OF RECORDS DISPLAYING IN 'SECURITIES' PAGE::- " +rowCount);
	    		CommonMethods1.closePopUp();
		    	
	    		//Call take screenshot function
		        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "findRecords_SecuritiesPage_"+System.currentTimeMillis() +".png");
		    	//Print Result in Excel File
		        DeclareVariables.passResultMessage = rowCount +" - RECORDS FOUND IN 'SECURITIES' PAGE!!!";
		        WriteTestResult.addRowInBasicSheet("findRecords_SecuritiesPage", "PASS", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername1, DeclareVariables.passResultMessage);
		        WriteTestResult.addRowInDetailsSheet("SECURITIES RECORDS", "FIND RECORDS - " +rowCount, "SECURITIES", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.passResultMessage);
	    	}
	    	else
			{
	    		DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'SECURITIES' PAGE OR ELEMENT LOCATOR NOT MATCHED";
	    		CreateLogs.writeLogs(DeclareVariables.failResultMessage);
	    		//Call take screenshot function
		        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "findRecords_SecuritiesPage_"+System.currentTimeMillis() +".png");
				//Print Result in Excel File
		        WriteTestResult.addRowInBasicSheet("findRecords_SecuritiesPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
		        WriteTestResult.addRowInDetailsSheet("SECURITIES RECORDS", "RECORD COUNT NOT FOUND", "SECURITIES", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.failResultMessage);		
			}
		}
		catch(Exception ex)
		{
			DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'SECURITIES' PAGE OR ELEMENT LOCATOR NOT MATCHED";
    		CreateLogs.writeLogs(DeclareVariables.failResultMessage);
    		//Call take screenshot function
	        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "findRecords_SecuritiesPage_"+System.currentTimeMillis() +".png");
			//Print Result in Excel File
	        WriteTestResult.addRowInBasicSheet("findRecords_SecuritiesPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
	        WriteTestResult.addRowInDetailsSheet("SECURITIES RECORDS", "RECORD COUNT NOT FOUND", "SECURITIES", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.failResultMessage);
	        CreateLogs.writeLogs(ex.getMessage());
		}
		CommonMethods1.indicatorStartEnd("END", "SECURITIES-PROCESSES");
	}
	
	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
		CommonMethods1.refreshPage();
		Thread.sleep(5000);
		CommonMethods1.indicatorStartEnd("END", "SECURITIES-PROCESSES");
		DeclareVariables.driver1.close();
		DeclareVariables.driver1.quit();
	}
}