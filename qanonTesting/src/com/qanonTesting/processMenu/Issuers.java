package com.qanonTesting.processMenu;

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
import org.testng.annotations.*;

import com.qanonTesting.login.tests.Login1;
import com.qanonTesting.utilities.*;

public class Issuers 
{
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try
		{
			CreateExcelFile.createWorkbook();
			CommonMethods1.indicatorStartEnd("START", "ISSUERS-PROCESSES");
			Login1.verify_Login(CommonValues.txtUsername1, CommonValues.txtPassword1);
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 1)
	public static void navigateTo_IssuersPage() throws Exception
	{
		try 
		{
			CommonMethods1.indicatorStartEnd("START", "ISSUERS-PROCESSES");
			Thread.sleep(5000);
			//Searching page and navigating to it
//			CommonMethods1.searchPage("ISSUERS", "", "ISSUERS PAGE SEARCHED");
			CommonMethods1.searchPageNew("ISSUERS", CommonValues.analyticsModule, "", "ISSUERS PAGE SEARCHED");
			CommonMethods1.closeExistingTab(CommonValues.processesModule);
			CommonMethods1.expandRightMenu(CommonValues.processesModule);
			CommonMethods1.resetPage(CommonValues.processesModule);
			CommonMethods1.closeExistingTab(CommonValues.processesModule);
			
			//Capture time when 'ISSUERS' page clicked
			long t1 = new Date().getTime();
			CreateLogs.writeLogs("TIME WHEN HIT ENTER TO NAVIGATE ON 'ISSUERS' PAGE:- " +t1 +" milliseconds");
			
			DeclareVariables.wait1 = new WebDriverWait(DeclareVariables.driver1, 90);
			DeclareVariables.footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']//*[text()='ISSUERS']//ancestor::span";
			
			if(FunctionLibraries1.isElementPresent(By.xpath(DeclareVariables.footerRowXPath)))
			{
				DeclareVariables.footerRow = DeclareVariables.wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeclareVariables.footerRowXPath)));
				DeclareVariables.footerPageName = DeclareVariables.footerRow.getText();
				
				Assert.assertEquals("ISSUERS", DeclareVariables.footerPageName);
				//Capture time when 'ISSUERS' page opened and verified
				long t2 = new Date().getTime();
				CreateLogs.writeLogs("TIME WHEN 'ISSUERS' PAGE OPENED AND VERIFIED:- " +t2 +" milliseconds");
//				CreateLogs.writeLogs("SYSTEM IS AT 'ISSUERS' PAGE!!!");
				
				long t3 = (t2-t1);
				DeclareVariables.timeTaken = t3 +" milliseconds";
				
				//Actual time to open ISSUERS page
				CreateLogs.writeLogs("ACTUAL TIME TAKEN BY SYSTEM IN OPENING OF 'ISSUERS' PAGE:- " +DeclareVariables.timeTaken);
				//Call take screenshot function
		        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_IssuersPage_"+System.currentTimeMillis() +".png");
				//Print Result in Excel File
		        DeclareVariables.passResultMessage = "SYSTEM IS AT 'ISSUERS' PAGE!!!";
		        WriteTestResult.addRowInBasicSheet("navigateTo_IssuersPage", "PASS", DeclareVariables.timeTaken, CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername1, DeclareVariables.passResultMessage);
		        WriteTestResult.addRowInDetailsSheet("VERIFY ISSUERS SCREEN", "ISSUERS SCREEN OPEN", "ISSUERS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
			
		        /*
				 * Code for Performance Report
				 */
				
				DeclareVariables.openScreenCounting = DeclareVariables.openScreenCounting+1;
				System.out.println("OPEN SCREEN " +DeclareVariables.openScreenCounting);
				String noOfAction = Integer.toString(DeclareVariables.openScreenCounting);
				System.out.println(noOfAction);
				DeclareVariables.openIssuersTime = (double) (t2-t1)/1000;
				if(DeclareVariables.openIssuersTime <0)
				{
					DeclareVariables.openIssuersTime = 0.00;
				}
				else
				{
					
				}
				double[] nums = {DeclareVariables.openFeedTime, DeclareVariables.openTeamsTime, DeclareVariables.openEntityTime, DeclareVariables.openProductsTime, DeclareVariables.openSecurityTermsTime, DeclareVariables.openSampleTime, DeclareVariables.openDocsProductsTime, DeclareVariables.openSecuritiesTime, DeclareVariables.openReportsTime, DeclareVariables.openIssuersTime};
				Arrays.sort(nums);
		        
				String minValue = String.format("%.2f", nums[0]);
				String maxValue = String.format("%.2f", nums[nums.length-1]);
				String meanValue = String.format("%.2f", (nums[0] + nums[nums.length-1])/2);
				
				//Calling percentile methods for values
			    DeclareVariables.percentile90 = Percentile.findPercentile(minValue, maxValue, 90);
			    DeclareVariables.percentile95 = Percentile.findPercentile(minValue, maxValue, 95);
				
				WriteTestResult.addRowInPerformanceSheet("OPEN SCREEN", noOfAction, minValue, maxValue, meanValue, DeclareVariables.percentile90, DeclareVariables.percentile95);
			}
			else
			{
				DeclareVariables.failResultMessage = "'ISSUERS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
				//Call take screenshot function
				CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_IssuersPage_"+System.currentTimeMillis() +".png");
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Print Result in Excel File				
				WriteTestResult.addRowInBasicSheet("navigateTo_IssuersPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY ISSUERS SCREEN", "ISSUERS SCREEN NOT FOUND", "ISSUERS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
			}
		}
		catch(Exception ex)
		{
			DeclareVariables.failResultMessage = "'ISSUERS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
			//Call take screenshot function
			CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_IssuersPage_"+System.currentTimeMillis() +".png");
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File				
			WriteTestResult.addRowInBasicSheet("navigateTo_IssuersPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY ISSUERS SCREEN", "ISSUERS SCREEN NOT FOUND", "ISSUERS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 2)
	public static void findRecords_IssuersPage() throws Exception
	{
		try 
		{
			Thread.sleep(1500);
            String footerRowXPath ="//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']//div[@class='VZ-WGT-BDY-DECK']//div[@class='GRID-WGT vert-flex-cnt']//div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']//div[@class='GRIDWGT-INNER']//div[@class='GRID-WGT-TOTALS-OUTER']//div[@class='GRID-TOTALS-WGT']//div[@class='GRID-MSG-WGT']//div[@class='GRID-MSG-WGT-ITEMS-OUTER']//div//div[@class='gwt-Label']";
            List<WebElement> valueF= DeclareVariables.driver1.findElements(By.xpath(footerRowXPath));
            for(int i=0;i<valueF.size();i++){
            	DeclareVariables.pageCount = valueF.get(i).getText();
            	CreateLogs.writeLogs("RECORDS COUNT OF 'ISSUERS' PAGE ::- " +DeclareVariables.pageCount);
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
	    		CreateLogs.writeLogs("ACTUAL NUMBERS OF RECORDS DISPLAYING IN 'ISSUERS' PAGE ::- " +rowCount);
	    		CommonMethods1.closePopUp();
	    		//Call take screenshot function
		        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "IssuersPage_Records_"+System.currentTimeMillis() +".png");
		    	//Print Result in Excel File
	    		DeclareVariables.passResultMessage = rowCount+" - RECORDS FOUND IN 'ISSUERS' page!!!";
	    		WriteTestResult.addRowInBasicSheet("findRecords_IssuersPage", "PASS", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername1, DeclareVariables.passResultMessage);
	    		WriteTestResult.addRowInDetailsSheet("ISSUERS RECORDS", "FIND ISSUERS - " +rowCount, "ISSUERS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.passResultMessage);
	    	}
	    	else
			{
	    		DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'ISSUERS' PAGE OR ELEMENT LOCATOR NOT MATCHED";
	    		//Call take screenshot function
		        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "IssuersPage_Records_"+System.currentTimeMillis() +".png");
		        CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Print Result in Excel File
		        WriteTestResult.addRowInBasicSheet("findRecords_IssuersPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
		        WriteTestResult.addRowInDetailsSheet("ISSUERS RECORDS", "RECORD COUNT NOT FOUND", "ISSUERS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.failResultMessage);
			}
		}
		catch(Exception ex)
		{
			DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'ISSUERS' PAGE OR ELEMENT LOCATOR NOT MATCHED";
    		//Call take screenshot function
	        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "IssuersPage_Records_"+System.currentTimeMillis() +".png");
	        CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File
	        WriteTestResult.addRowInBasicSheet("findRecords_IssuersPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
	        WriteTestResult.addRowInDetailsSheet("ISSUERS RECORDS", "RECORD COUNT NOT FOUND", "ISSUERS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.failResultMessage);
	        CreateLogs.writeLogs(ex.getMessage());
		}
		CommonMethods1.indicatorStartEnd("END", "ISSUERS-PROCESSES");
	}
	
	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
		CommonMethods1.refreshPage();
		Thread.sleep(5000);
		CommonMethods1.indicatorStartEnd("END", "ISSUERS-PROCESSES");
		DeclareVariables.driver1.close();
		DeclareVariables.driver1.quit();
	}
}
