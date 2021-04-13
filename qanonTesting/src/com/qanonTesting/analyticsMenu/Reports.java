package com.qanonTesting.analyticsMenu;

import java.awt.AWTException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qanonTesting.login.tests.Login1;
import com.qanonTesting.utilities.*;

public class Reports 
{	
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try {
			CreateExcelFile.createWorkbook();
			CommonMethods1.indicatorStartEnd("START", "REPORTS-ANALYTICS");
			Login1.verify_Login(CommonValues.txtUsername1, CommonValues.txtPassword1);
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 1)
	public static void navigateTo_ReportsPage() throws Exception
	{
		try 
		{
			CommonMethods1.indicatorStartEnd("START", "REPORTS-ANALYTICS");
			Thread.sleep(5000);
			//Searching page and navigating to it
//			CommonMethods1.searchPage("REPORTS","", "REPORTS PAGE SEARCHED");
			CommonMethods1.searchPageNew("REPORTS", CommonValues.processesModule, "", "REPORTS PAGE SEARCHED");
			CommonMethods1.closeExistingTab(CommonValues.analyticsModule);
			CommonMethods1.resetPage(CommonValues.analyticsModule);
			CommonMethods1.closeExistingTab(CommonValues.analyticsModule);

			//Capture time when Login button clicked
			long t1 = new Date().getTime();
			CreateLogs.writeLogs("TIME WHEN HIT ENTER TO NAVIGATE ON 'REPORTS' PAGE:- " +t1 +" milliseconds");
					
			DeclareVariables.wait1 = new WebDriverWait(DeclareVariables.driver1, 90);
			DeclareVariables.footerRowXPath = "//*[text()='REPORTS']//ancestor::span";
			
			if(FunctionLibraries1.isElementPresent(By.xpath(DeclareVariables.footerRowXPath)))
			{
				DeclareVariables.footerRow = DeclareVariables.wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeclareVariables.footerRowXPath)));	
				String footerText = DeclareVariables.footerRow.getText();
				
				Assert.assertEquals("REPORTS", footerText);
				
				//Capture time when Login button clicked
				long t2 = new Date().getTime();
				CreateLogs.writeLogs("TIME WHEN 'REPORTS' PAGE OPENED AND VERIFIED:- " +t2 +" milliseconds");
//				CreateLogs.writeLogs("SYSTEM IS AT 'REPORTS' PAGE!!!");
				
				long t3 = (t2-t1);
				//System.out.println("T3 Time ::- " +t3);				
				DeclareVariables.timeTaken = t3 + " milliseconds";
				
				//Actual time to open Securities page 		  
				CreateLogs.writeLogs("ACTUAL TIME TAKEN BY SYSTEM IN OPENING OF 'REPORTS' PAGE:- " +DeclareVariables.timeTaken);
				
				//Call take screenshot function
				CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_ReportsPage_"+System.currentTimeMillis() +".png");
				//Write Test Result in Excel
				DeclareVariables.passResultMessage = "SYSTEM IS AT 'REPORTS' PAGE!!!";
				WriteTestResult.addRowInBasicSheet("navigateTo_ReportsPage", "PASS", DeclareVariables.timeTaken, CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.analyticsModule, CommonValues.txtUsername1, DeclareVariables.passResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY REPORTS SCREEN", "REPORTS SCREEN OPEN", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
			
				/*
				 * Code for Performance Report
				 */
				
				DeclareVariables.openScreenCounting = DeclareVariables.openScreenCounting+1;
				System.out.println("OPEN SCREEN " +DeclareVariables.openScreenCounting);
				String noOfAction = Integer.toString(DeclareVariables.openScreenCounting);
				System.out.println(noOfAction);
				DeclareVariables.openReportsTime = (double) (t2-t1)/1000;
				if(DeclareVariables.openReportsTime <0)
				{
					DeclareVariables.openReportsTime = 0.00;
				}
				else
				{
					
				}
			}
			else
			{
				DeclareVariables.failResultMessage = "'REPORTS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
				//Call take screenshot function
				CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_Reports_"+System.currentTimeMillis() +".png");
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Write Test Result in Excel
				WriteTestResult.addRowInBasicSheet("navigateTo_ReportsPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.analyticsModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY REPORTS SCREEN", "REPORTS SCREEN NOT FOUND", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
			}
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
			DeclareVariables.failResultMessage = "'REPORTS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
			//Call take screenshot function
			CommonMethods1.takeSnapShot(DeclareVariables.driver1, "navigateTo_Reports_"+System.currentTimeMillis() +".png");
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Write Test Result in Excel
			WriteTestResult.addRowInBasicSheet("navigateTo_ReportsPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.analyticsModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY REPORTS SCREEN", "REPORTS SCREEN NOT FOUND", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
		}
	}

	@Test(priority = 2)
	public static void findRecords_ReportsPage() throws Exception
	{
		try 
		{
			Thread.sleep(1500);
            String footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-WIZ']//div[@class='GRID-MSG-WGT-ITEMS-OUTER']";
            List<WebElement> valueF= DeclareVariables.driver1.findElements(By.xpath(footerRowXPath));
            for(int i=0;i<valueF.size();i++){
            	DeclareVariables.pageCount = valueF.get(i).getText();
            	CreateLogs.writeLogs("RECORDS COUNT OF 'REPORTS' PAGE ::- " +DeclareVariables.pageCount);
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
	    		CreateLogs.writeLogs("ACTUAL NUMBER OF RECORDS DISPLAYING IN 'REPORTS' PAGE ::- " +rowCount);
	    		CommonMethods1.closePopUp();
		    	
	    		//Call take screenshot function
		        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "findRecords_ReportsPage_"+System.currentTimeMillis() +".png");
		    	//Print Result in Excel File
		        DeclareVariables.passResultMessage = rowCount +" - RECORDS FOUND IN 'REPORTS' PAGE!!!";
		        WriteTestResult.addRowInBasicSheet("findRecords_ReportsPage", "PASS", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.analyticsModule, CommonValues.txtUsername1, DeclareVariables.passResultMessage);
		        WriteTestResult.addRowInDetailsSheet("REPORTS RECORDS", "FIND RECORDS - " +rowCount, "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.passResultMessage);
	    	}
	    	else
			{
	    		DeclareVariables.failResultMessage = "RECORDS COUND NOT FOUND ON 'REPORTS' PAGE OR RECORDS COUND NOT FOUND!!!";
	    		//Call take screenshot function
		        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "findRecords_ReportsPage_"+System.currentTimeMillis() +".png");
		        CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Print Result in Excel File
		        WriteTestResult.addRowInBasicSheet("findRecords_ReportsPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.analyticsModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
		        WriteTestResult.addRowInDetailsSheet("REPORTS RECORDS", "RECORD COUNT NOT FOUND", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.failResultMessage);
			}
		}
		catch(Exception ex)
		{
			DeclareVariables.failResultMessage = "RECORDS COUND NOT FOUND ON 'REPORTS' PAGE OR RECORDS COUND NOT FOUND!!!";
			//Call take screenshot function
	        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "findRecords_ReportsPage_"+System.currentTimeMillis() +".png");
	        CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File	    		
	        WriteTestResult.addRowInBasicSheet("findRecords_ReportsPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.analyticsModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
	        WriteTestResult.addRowInDetailsSheet("REPORTS RECORDS", "RECORD COUNT NOT FOUND", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.failResultMessage);
	        CreateLogs.writeLogs(ex.getMessage());
		} 
	}
	
	@Test(priority = 3)
	public static void generateReport_ReportsPage() throws Exception
	{
		try 
		{
			CommonMethods1.resetPage(CommonValues.analyticsModule);
			Thread.sleep(5000);
			String addReportBtn = "//*[@title='ADD NEW REPORTS']";
			WebElement addNewReport = FunctionLibraries1.locator("xpath", addReportBtn);	////*[@title='ADD NEW REPORTS']
			if(addNewReport!= null)
			{
				FunctionLibraries1.clickButton("xpath", addReportBtn, "ADD NEW REPORTS");
				Thread.sleep(5000);
				long t1 = new Date().getTime();
//				Thread.sleep(2000);
				String saveXPath = "//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-SAVE']";
				boolean saveBtn= FunctionLibraries1.locator("xpath", saveXPath).isEnabled();
				if(saveBtn==true)
				{
					long t2 = new Date().getTime();
					DeclareVariables.timeTaken = (t2-t1) + " milliseconds";
					DeclareVariables.onlyMessage = "NEW ROW ADDED SUCCESSFULLY AFTER 'ADD NEW REPORTS' ICON CLICKED!!!";
					WriteTestResult.addRowInDetailsSheet("ADD REPORT ROW", "ADD ROW", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.onlyMessage);
				
					/*
					 * Code for Performance Report
					 */
					DeclareVariables.addRowCounting = DeclareVariables.addRowCounting+1;
//					System.out.println("ADD ROW " +DeclareVariables.addRowCounting);
					String noOfAction = Integer.toString(DeclareVariables.addRowCounting);
					System.out.println(noOfAction);
					DeclareVariables.addReportRowTime = (double) (t2-t1)/1000;
					
					double[] nums = {DeclareVariables.addFeedRowTime, DeclareVariables.addProductEditRowTime, DeclareVariables.addReportRowTime};
					Arrays.sort(nums);
			        
					String minValue = String.format("%.2f", nums[0]);
					String maxValue = String.format("%.2f", nums[nums.length-1]);
					String meanValue = String.format("%.2f", (nums[0] + nums[nums.length-1])/2);
					
					//Calling percentile methods for values
				    DeclareVariables.percentile90 = Percentile.findPercentile(minValue, maxValue, 90);
				    DeclareVariables.percentile95 = Percentile.findPercentile(minValue, maxValue, 95);

					WriteTestResult.addRowInPerformanceSheet("ADD ROW", noOfAction, minValue, maxValue, meanValue, DeclareVariables.percentile90, DeclareVariables.percentile95);
				}
				else{
					
				}
			}
			else
			{
				WriteTestResult.addRowInDetailsSheet("ADD REPORT ROW", "ADD NEW REPORT NOT FOUND", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", "ADD NEW REPORTS ICON NOT FOUND");
			}
			
			//Thread.sleep(5000);
			String templateXPath = "//input[@placeholder='TEMPLATE']";			
			if(FunctionLibraries1.isElementPresent(By.xpath(templateXPath)))
			{
				WebElement templateName = DeclareVariables.driver1.findElement(By.xpath(templateXPath));
				templateName.clear();	Thread.sleep(4000);
				templateName.sendKeys(CommonValues.reportsTemplateName);		Thread.sleep(5000);
				templateName.sendKeys(Keys.TAB);				
				WriteTestResult.addRowInDetailsSheet("CREATE REPORT TEMPLATE", "SET TEMPLATE FIELD - 'PRODUCT TEST'", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", "");
			}
			else
			{
				WriteTestResult.addRowInDetailsSheet("CREATE REPORT TEMPLATE", "SET TEMPLATE FIELD - 'PRODUCT TEST'", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", "TEMPLATE FIELD NOT FOUND");
			}			
			
//			Thread.sleep(5000);
			String saveXPath = "//div[@class='WIZ-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-SAVE'][@title='SAVE']"; 
//					"//div[@class='WIZ-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-SAVE']//div[@class='WORKBAR-WGT-TRG-ICON mz-icons']";
			if(FunctionLibraries1.isElementPresent(By.xpath(saveXPath)))
			{
				FunctionLibraries1.clickButton("xpath", saveXPath, "SAVE");
				long t1 = new Date().getTime();
		        Thread.sleep(3000);
		        WebElement savePopUp = FunctionLibraries1.locator("xpath", "//div[@class='cmplt-noti-dlg-lbl cmplt-noti-update-dlg-lbl inln-blck v-mid-algn']");
		        DeclareVariables.savePopUpMsg = savePopUp.getText();
		        System.out.println(DeclareVariables.savePopUpMsg);
		        long t2 = new Date().getTime();
		        
		        DeclareVariables.timeTaken = (t2-t1)-2000 + " milliseconds";
		        DeclareVariables.passResultMessage = "REPORT INITIATED SUCCESSFULLY AND 'SAVED!' MESSAGE APPEARED!!!";
		        CreateLogs.writeLogs(DeclareVariables.passResultMessage);
		        if((DeclareVariables.savePopUpMsg).equals("SAVED!"))
		        {
		        	WriteTestResult.addRowInDetailsSheet("SAVE REPORT", "SAVE REPORTS", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
		        
		        	/*
					 * Code for Performance Report
					 */
					DeclareVariables.saveBtnCounting = DeclareVariables.saveBtnCounting+1;
//					System.out.println("SAVE " +DeclareVariables.saveBtnCounting);
					String noOfAction = Integer.toString(DeclareVariables.saveBtnCounting);
					System.out.println(noOfAction);
					DeclareVariables.saveReportsTime = (double) ((t2-t1)-2000)/1000;
					
					double[] nums = {CommonMethods1.saveFeedTime, DeclareVariables.saveReportsTime};
					Arrays.sort(nums);
			        
					String minValue = String.format("%.2f", nums[0]);
					String maxValue = String.format("%.2f", nums[nums.length-1]);
					String meanValue = String.format("%.2f", (nums[0] + nums[nums.length-1])/2);
					
					//Calling percentile methods for values
				    DeclareVariables.percentile90 = Percentile.findPercentile(minValue, maxValue, 90);
				    DeclareVariables.percentile95 = Percentile.findPercentile(minValue, maxValue, 95);

					WriteTestResult.addRowInPerformanceSheet("SAVE", noOfAction, minValue, maxValue, meanValue, DeclareVariables.percentile90, DeclareVariables.percentile95);
				}
		        else
		        {
		        	DeclareVariables.passResultMessage = "REPORT INITIATED SUCCESSFULLY AND BUT 'SAVED!' MESSAGE NOT FOUND!!!";
		        	WriteTestResult.addRowInDetailsSheet("CREATE REPORT", "SAVE REPORTS", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
		        	
		        	/*
					 * Code for Performance Report
					 */
					DeclareVariables.saveBtnCounting = DeclareVariables.saveBtnCounting+1;
					System.out.println("SAVE " +DeclareVariables.saveBtnCounting);
					String noOfAction = Integer.toString(DeclareVariables.saveBtnCounting);
					System.out.println(noOfAction);
					DeclareVariables.saveReportsTime = (double) ((t2-t1)-2000)/1000;
					
					double[] nums = {CommonMethods1.saveFeedTime, DeclareVariables.saveReportsTime};
					Arrays.sort(nums);
			        
					String minValue = String.format("%.2f", nums[0]);
					String maxValue = String.format("%.2f", nums[nums.length-1]);
					String meanValue = String.format("%.2f", (nums[0] + nums[nums.length-1])/2);
					
					//Calling percentile methods for values
				    DeclareVariables.percentile90 = Percentile.findPercentile(minValue, maxValue, 90);
				    DeclareVariables.percentile95 = Percentile.findPercentile(minValue, maxValue, 95);

					WriteTestResult.addRowInPerformanceSheet("SAVE", noOfAction, minValue, maxValue, meanValue, DeclareVariables.percentile90, DeclareVariables.percentile95);
				}
	        }
	        else
	        {
	        	WriteTestResult.addRowInDetailsSheet("CREATE REPORT", "SAVE REPORTS", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", "SAVE ICON NOT FOUND");
	        }
			
			Thread.sleep(3000);
			//Close Report Generate Form
			FunctionLibraries1.locator("xpath", "//div[@class='REALM REALM-WIZ']//div[@class='HOR-FLEX-EL FLY-CLOSE-TRG FLY-TOP-TRG material-icons TRG-BASE trg-base'][@title='CLOSE']").click();
			Thread.sleep(2000);
			CommonMethods1.resetPage(CommonValues.analyticsModule);
			Thread.sleep(3000);
			//Select First Row to submit
			FunctionLibraries1.locator("xpath", "//div[@class='REALM REALM-WIZ']//div[@class='GRID-WGT-BODY-OUTER']//div[@class='GRID-WGT-TBLS']//table//tr[1]//td[1]//div").click();
			Thread.sleep(3000);
			
			String submitDisabledXPath = "//div[@class='WIZ-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-SUBMIT TRG-BASE-DISABLED']//div[@class='WORKBAR-WGT-TRG-ICON mz-icons']";
			String submitEnabledXPath = "//div[@class='WIZ-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-SUBMIT']//div[@class='WORKBAR-WGT-TRG-ICON mz-icons']";
			if(DeclareVariables.driver1.findElements(By.xpath(submitDisabledXPath)).size()>0)
			{
				DeclareVariables.failResultMessage = "SYSTEM UNABLED TO CLICK 'SUBMIT' ICON AS IT IS DISABLED(i.e. READ-ONLY)!!!";
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("CREATE REPORT", "SUBMIT REPORTS", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
			}
			else if(DeclareVariables.driver1.findElements(By.xpath(submitEnabledXPath)).size()>0)
			{
				FunctionLibraries1.clickButton("xpath", submitEnabledXPath, "SUBMIT");
				long t11 = new Date().getTime();
				Thread.sleep(3000);
				WebElement submitPopUp = FunctionLibraries1.locator("xpath", "//div[@class='cmplt-noti-dlg-lbl cmplt-noti-update-dlg-lbl inln-blck v-mid-algn']");
		        DeclareVariables.submitPopUpMsg = submitPopUp.getText();
		        System.out.println(DeclareVariables.submitPopUpMsg);
		        long t12 = new Date().getTime();
		        
		        long t13 = (t12-t11);
		        DeclareVariables.timeTaken = t13 + " milliseconds";
//		        System.out.println("AFTER SUBMIT BUTTON CLICKED MESSAGE FOUND ::- " +submitPopUpMsg);
		        if((DeclareVariables.submitPopUpMsg).equals("SUBMITTED!"))
        		{
		        	//Call take screenshot function
			        Thread.sleep(2000);
			        CommonMethods1.takeSnapShot(DeclareVariables.driver1, "FeedsPage_SubmitReport_"+System.currentTimeMillis() +".png");
			        DeclareVariables.passResultMessage = "REPORTS STATUS CHANGE TO PENDING SUCCESSFULLY AND 'SUBMITTED!' MESSAGE APPEARED!!!";
			        CreateLogs.writeLogs(DeclareVariables.passResultMessage);
			        //Print Result in Excel File
			        WriteTestResult.addRowInBasicSheet("generateReport_ReportsPage", "PASS", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.analyticsModule, CommonValues.txtUsername1, DeclareVariables.passResultMessage);
					WriteTestResult.addRowInDetailsSheet("SUBMIT REPORT", "SUBMIT REPORTS", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
					Thread.sleep(3000);
					CommonMethods1.closePopUp();
					
					/* 
					 * 
					 * Code for Performance Report
					 *  
					 */
					DeclareVariables.submitBtnCounting = DeclareVariables.submitBtnCounting+1;
					System.out.println("SUBMIT " +DeclareVariables.submitBtnCounting);
					String noOfAction = Integer.toString(DeclareVariables.submitBtnCounting);
					System.out.println(noOfAction);
					DeclareVariables.submitReportsTime = (double) (t12-t11)/1000;
					
					double[] nums = {DeclareVariables.submitFeedTime, DeclareVariables.submitTeamsTime, DeclareVariables.submitReportsTime};
					Arrays.sort(nums);
			        
					String minValue = String.format("%.2f", nums[0]);
					String maxValue = String.format("%.2f", nums[nums.length-1]);
					String meanValue = String.format("%.2f", (nums[0] + nums[nums.length-1])/2);
					
					//Calling percentile methods for values
				    DeclareVariables.percentile90 = Percentile.findPercentile(minValue, maxValue, 90);
				    DeclareVariables.percentile95 = Percentile.findPercentile(minValue, maxValue, 95);

					WriteTestResult.addRowInPerformanceSheet("SUBMIT", noOfAction, minValue, maxValue, meanValue, DeclareVariables.percentile90, DeclareVariables.percentile95);
				}
		        else
		        {
		        	DeclareVariables.passResultMessage = "REPORTS STATUS CHANGE TO PENDING SUCCESSFULLY BUT 'SUBMITTED!' MESSAGE NOT FOUND!!!";
		        	WriteTestResult.addRowInDetailsSheet("SUBMIT REPORT", "SUBMIT REPORTS", "REPORTS", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", "", DeclareVariables.passResultMessage);
		        	/* 
					 * 
					 * Code for Performance Report
					 *  
					 */
					DeclareVariables.submitBtnCounting = DeclareVariables.submitBtnCounting+1;
					System.out.println("SUBMIT " +DeclareVariables.submitBtnCounting);
					String noOfAction = Integer.toString(DeclareVariables.submitBtnCounting);
					System.out.println(noOfAction);
					DeclareVariables.submitReportsTime = (double) (t12-t11)/1000;
					
					double[] nums = {DeclareVariables.submitFeedTime, DeclareVariables.submitTeamsTime, DeclareVariables.submitReportsTime};
					Arrays.sort(nums);
			        
					String minValue = String.format("%.2f", nums[0]);
					String maxValue = String.format("%.2f", nums[nums.length-1]);
					String meanValue = String.format("%.2f", (nums[0] + nums[nums.length-1])/2);
					
					//Calling percentile methods for values
				    DeclareVariables.percentile90 = Percentile.findPercentile(minValue, maxValue, 90);
				    DeclareVariables.percentile95 = Percentile.findPercentile(minValue, maxValue, 95);

					WriteTestResult.addRowInPerformanceSheet("SUBMIT", noOfAction, minValue, maxValue, meanValue, DeclareVariables.percentile90, DeclareVariables.percentile95);
				}
	        }
		}
		catch(Exception ex)
		{
			CommonMethods1.takeSnapShot(DeclareVariables.driver1, "generateReport_ReportsPage_"+System.currentTimeMillis() +".png");
			DeclareVariables.failResultMessage = "TEMPLATE FIELD NOT FOUND ON 'REPORTS' PAGE OR ELEMENT LOCATOR NOT MATCHED";
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("generateReport_ReportsPage", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.analyticsModule, CommonValues.txtUsername1, DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
		CommonMethods1.refreshPage();
		Thread.sleep(5000);
		CommonMethods1.indicatorStartEnd("END", "REPORTS-ANALYTICS");
		DeclareVariables.driver1.close();
		DeclareVariables.driver1.quit();
	}
}
