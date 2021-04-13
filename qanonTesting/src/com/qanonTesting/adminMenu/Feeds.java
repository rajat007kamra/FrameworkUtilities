package com.qanonTesting.adminMenu;

import java.awt.AWTException;
import java.io.IOException;
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

import com.qanonTesting.login.tests.Login2;
import com.qanonTesting.utilities.*;

public class Feeds 
{
	public static long t11, t12;	
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try 
		{
			CommonMethods2.indicatorStartEnd("START", "FEEDS-ADMIN");
			CommonMethods2.openApplication();
			Login2.verify_Login(CommonValues.txtUsername2, CommonValues.txtPassword2);
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority=1)
	public static void navigateTo_FeedsPage() throws Exception
	{
		try
		{
			CommonMethods2.indicatorStartEnd("START", "FEEDS-ADMIN");
//			Thread.sleep(20000);
			//Searching page and navigating to it
			CommonMethods2.searchPage("FEEDS", "", "FEEDS PAGE SEARCHED");
//			CommonMethods2.searchPageNew("FEEDS", "PROCESSES", "", "FEEDS PAGE SEARCHED");
			CommonMethods2.closeExistingTab(CommonValues.adminModule);
			CommonMethods2.resetPage(CommonValues.adminModule);
			CommonMethods2.closeExistingTab(CommonValues.adminModule);
			
			//Capture time when Login button clicked
			long t1 = new Date().getTime();
			CreateLogs.writeLogs("TIME WHEN HIT ENTER TO NAVIGATE ON 'FEEDS' PAGE:- " +t1 +" milliseconds");
			
			DeclareVariables.wait2 = new WebDriverWait(DeclareVariables.driver2, 90);
			DeclareVariables.footerRowXPath = "//*[text()='FEEDS']//ancestor::span";
			
			if(FunctionLibraries2.isElementPresent(By.xpath(DeclareVariables.footerRowXPath)))
			{
				DeclareVariables.footerRow = DeclareVariables.wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeclareVariables.footerRowXPath)));	
				DeclareVariables.footerPageName = DeclareVariables.footerRow.getText();
				
				Assert.assertEquals("FEEDS", DeclareVariables.footerPageName);
				
				//Capture time when Login button clicked
				long t2 = new Date().getTime();
				CreateLogs.writeLogs("TIME WHEN 'FEEDS' PAGE OPENED AND VERIFIED:- " +t2 +" milliseconds");
//				CreateLogs.writeLogs("SYSTEM IS AT 'FEEDS' PAGE!!!");
				
				DeclareVariables.timeTaken = (t2-t1) + " milliseconds";
				
				//Actual time to open Securities page 		  
				CreateLogs.writeLogs("ACTUAL TIME TAKEN BY SYSTEM IN OPENING OF 'FEEDS' PAGE:- " +DeclareVariables.timeTaken);
				
				//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_FeedsPage_"+System.currentTimeMillis() +".png");				
				//Print Result in Excel File
				DeclareVariables.passResultMessage = "SYSTEM IS AT 'FEEDS' PAGE!!!";
				WriteTestResult.addRowInBasicSheet("navigateTo_FeedsPage", "PASS", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY FEEDS SCREEN", "FEEDS SCREEN OPEN", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
				
				/*
				 * Code for Performance Report
				 */
				
				DeclareVariables.openScreenCounting = DeclareVariables.openScreenCount+1;
//				System.out.println("OPEN SCREEN " +DeclareVariables.openScreenCounting);
				String noOfAction = Integer.toString(DeclareVariables.openScreenCounting);
				System.out.println(noOfAction);
				DeclareVariables.openFeedTime = (double) (t2-t1)/1000;
				if(DeclareVariables.openFeedTime <0)
				{
					DeclareVariables.openFeedTime = 0.00;
				}
				else
				{
					
				}
			}
			else
			{
				DeclareVariables.failResultMessage = "'FEEDS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_FeedsPage_"+System.currentTimeMillis() +".png");
				//Print Result in Excel File
				WriteTestResult.addRowInBasicSheet("navigateTo_FeedsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY FEEDS SCREEN", "FEEDS SCREEN NOT FOUND", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
			}
		}
		catch(Exception ex)
		{
			DeclareVariables.failResultMessage = "'FEEDS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Call take screenshot function
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_FeedsPage_"+System.currentTimeMillis() +".png");
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("navigateTo_FeedsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY FEEDS SCREEN", "FEEDS SCREEN NOT FOUND", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority=2)
	public static void findRecords_FeedsPage() throws Exception
	{
		try 
		{
			Thread.sleep(1500);
            String xpathF = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-QONCIERGE']//div[@class='GRID-MSG-WGT-ITEMS-OUTER'][1]";
            List<WebElement> valueF= DeclareVariables.driver2.findElements(By.xpath(xpathF));
            for(int i=0;i<valueF.size();i++){
            	DeclareVariables.pageCount = valueF.get(i).getText();
                CreateLogs.writeLogs("RECORDS COUNT OF 'FEEDS' PAGE ::- " +DeclareVariables.pageCount);
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
	    		CreateLogs.writeLogs("ACTUAL NUMBER OF RECORDS DISPLAYING  IN 'FEEDS' PAGE ::- " +rowCount);
	    		CommonMethods2.closePopUp();
	    		//Call take screenshot function
		        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_FeedsPage_"+System.currentTimeMillis() +".png");
		    	//Print Result in Excel File
	    		DeclareVariables.passResultMessage = rowCount+" - RECORDS FOUND IN 'FEEDS' PAGE!!!";
				WriteTestResult.addRowInBasicSheet("findRecords_FeedsPage", "PASS", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
				WriteTestResult.addRowInDetailsSheet("FEEDS RECORDS", "FIND RECORDS - " +rowCount, "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.passResultMessage);
	    	}
	    	else
			{
	    		DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'FEEDS' PAGE OR RECORDS COUNT NOT MATCHED!!!";
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);	    		
	    		//Call take screenshot function
		        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_FeedsPage_"+System.currentTimeMillis() +".png");
		        //Print Result in Excel File
				WriteTestResult.addRowInBasicSheet("findRecords_FeedsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("FEEDS RECORDS", "RECORD COUNT NOT FOUND", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
			}
		}
		catch(Exception ex)
		{
			DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'FEEDS' PAGE OR RECORDS COUNT NOT MATCHED!!!";
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);	    		
    		//Call take screenshot function
	        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_FeedsPage_"+System.currentTimeMillis() +".png");
	        //Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("findRecords_FeedsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("FEEDS RECORDS", "RECORD COUNT NOT FOUND", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
		
	@Test(priority=3)
	public static void uploadFeed_AndVerify() throws InterruptedException, IOException
	{
		try 
		{
			CommonMethods2.resetPage(CommonValues.adminModule);
			Thread.sleep(5000);
			WebElement addNewFeed = FunctionLibraries2.locator("xpath", "//*[@title='ADD NEW FEEDS']");
			if(addNewFeed!= null)
			{
				FunctionLibraries2.clickButton("xpath", "//*[@title='ADD NEW FEEDS']", "ADD NEW FEEDS");
				long t1 = new Date().getTime();
				
				String saveXPath = "//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-SAVE']";
				boolean saveBtn= FunctionLibraries2.locator("xpath", saveXPath).isEnabled();
				if(saveBtn==true)
				{
//					System.out.print(saveBtn);
					long t2 = new Date().getTime();
					DeclareVariables.timeTaken = (t2-t1) + " milliseconds";
					DeclareVariables.onlyMessage = "NEW ROW ADDED SUCCESSFULLY AFTER 'ADD NEW FEEDS' ICON CLICKED!!!";
					WriteTestResult.addRowInDetailsSheet("ADD FEED ROW", "ADD ROW", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.onlyMessage);
				
					/*
					 * Code for Performance Report
					 */
					DeclareVariables.addRowCounting = DeclareVariables.addRowCount+1;
//					System.out.println("ADD ROW " +DeclareVariables.addRowCounting);
					String noOfAction = Integer.toString(DeclareVariables.addRowCounting);
					System.out.println(noOfAction);
					DeclareVariables.addFeedRowTime = (double) (t2-t1)/1000;
				}
				else
				{
					
				}
			}
			else
			{
				WriteTestResult.addRowInDetailsSheet("ADD FEED ROW", "ADD NEW FEEDS NOT FOUND", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "ADD NEW FEEDS ICON NOT FOUND");
			}
			
			//Call Fill Profile Details method
			fillProfileDetails();
			
			//Click upload attachment
			CommonMethods2.clickUploadAttachment();						
	        
	        //Capture time when UPLOAD ATTACHMENT button clicked
			CreateLogs.writeLogs("TIME WHEN HIT 'UPLOAD ATTACHMENT' BUTTON ON 'FEEDS' PAGE:- ");// +t1 +" milliseconds");
	        
	        Thread.sleep(2000);
	        WebElement abc = FunctionLibraries2.locator("css", "div.fileupload-wgt > input");
	        abc.sendKeys(CommonValues.feedFilePath);
	        
	        
	        CommonMethods2.uploadFileWithRobot(CommonValues.feedFilePath);
			CreateLogs.writeLogs("FEED FILE UPLOAD TIME TAKEN :- ");// +t2 +" milliseconds");

			Thread.sleep(5000);
			String submitXPath = "//div[@class='QONCIERGE-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-SUBMIT']//div[@class='WORKBAR-WGT-TRG-ICON mz-icons']";
			if(DeclareVariables.driver2.findElement(By.xpath(submitXPath)) != null)
			{
				FunctionLibraries2.clickButton("xpath", submitXPath, "SUBMIT");
				t11 = new Date().getTime();
				WebElement submitPopUp = FunctionLibraries2.locator("xpath", "//div[@class='cmplt-noti-dlg-lbl cmplt-noti-update-dlg-lbl inln-blck v-mid-algn']");
		        String submitPopUpMsg = submitPopUp.getText();
		        t12 = new Date().getTime();
		        
		        DeclareVariables.timeTaken = ((t12-t11)-1500) + " milliseconds";
//		        System.out.println("AFTER SUBMIT BUTTON CLICKED MESSAGE FOUND ::- " +submitPopUpMsg);
		        if(submitPopUpMsg.equals("SUBMITTED!"))
        		{
		        	//Call take screenshot function
			        Thread.sleep(2000);
			        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "FeedsPage_forFileUpload_"+System.currentTimeMillis() +".png");
			        DeclareVariables.passResultMessage = "FEEDS COMPLETED SUCCESSFULLY AND 'SUBMITTED!' MESSAGE APPEARED!!!";
			        CreateLogs.writeLogs(DeclareVariables.passResultMessage);
			        //Print Result in Excel File
					WriteTestResult.addRowInBasicSheet("uploadFeed_AndVerify", "PASS", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
					WriteTestResult.addRowInDetailsSheet("SUBMIT FEED", "SUBMIT BUTTON", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
		        
					/*
					 * Code for Performance Report
					 */
					DeclareVariables.submitBtnCounting = DeclareVariables.submitBtnCount+1;
//					System.out.println("SUBMIT " +DeclareVariables.submitBtnCounting);
					String noOfAction = Integer.toString(DeclareVariables.submitBtnCounting);
					System.out.println(noOfAction);
					DeclareVariables.submitFeedTime = (double) ((t12-t11)-1500)/1000;
        		}
		        else
		        {
		        	DeclareVariables.passResultMessage = "FEEDS COMPLETED SUCCESSFULLY BUT 'SUBMITTED!' MESSAGE NOT FOUND";
			        CreateLogs.writeLogs(DeclareVariables.passResultMessage);
		        	WriteTestResult.addRowInDetailsSheet("SUBMIT FEED", "SUBMIT BUTTON", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.passResultMessage);

		        	/*
					 * Code for Performance Report
					 */
					DeclareVariables.submitBtnCounting = DeclareVariables.submitBtnCounting+1;
//					System.out.println("SUBMIT " +DeclareVariables.submitBtnCounting);
					String noOfAction = Integer.toString(DeclareVariables.submitBtnCounting);
					System.out.println(noOfAction);
					DeclareVariables.submitFeedTime = (double) ((t12-t11)-1500)/1000;					
		        }
	        }
	        else
	        {
	        	DeclareVariables.failResultMessage = "EITHER FEEDS NOT COMPLETED OR SUBMIT BUTTON NOT FOUND OR SUBMITTED MESSAGE NOT FOUND";
				//Print Result in Excel File
				WriteTestResult.addRowInBasicSheet("uploadFeed_AndVerify", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
//				Assert.fail(DeclareVariables.failResultMessage);
				
				/*
				 * Code for Performance Report
				 */
				DeclareVariables.submitBtnCounting = DeclareVariables.submitBtnCounting+1;
				System.out.println("SUBMIT " +DeclareVariables.submitBtnCounting);
				String noOfAction = Integer.toString(DeclareVariables.submitBtnCounting);
				System.out.println(noOfAction);
				DeclareVariables.submitFeedTime = (double) ((t12-t11)-1500)/1000;
	        }
//			CommonMethods2.closePopUp();
		}
		catch(Exception ex)
		{
			DeclareVariables.failResultMessage = "EITHER FEEDS NOT COMPLETED OR SUBMIT BUTTON NOT FOUND OR SUBMITTED MESSAGE NOT FOUND";
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("uploadFeed_AndVerify", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
//			Assert.fail(DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	//Fill PROFILE fields values
	public static void fillProfileDetails() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		WebElement interfaceType = FunctionLibraries2.locator("xpath", "//div[@class='REALM-BDY-RGHT REALM-BDY-EL REALM-BDY-RGHT-QONCIERGE HAS-TRANS-300']//input[@placeholder='INTERFACE TYPE']");
		if(interfaceType!= null)
		{
			interfaceType.clear();	Thread.sleep(2000);
			interfaceType.sendKeys(CommonValues.feedInterfaceTypeValue);		Thread.sleep(3000);
			interfaceType.sendKeys(Keys.TAB);
			WriteTestResult.addRowInDetailsSheet("LOAD FILE INTERFACE", "SET INTERFACE TYPE FIELD - 'INTEGRATION'", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "");
		}
		else
		{
			WriteTestResult.addRowInDetailsSheet("LOAD FILE INTERFACE", "SET INTERFACE TYPE FIELD - 'INTEGRATION'", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "INTERFACE TYPE FIELD NOT FOUND");
		}			
		
//		Thread.sleep(2000);
		WebElement delimitedField = FunctionLibraries2.locator("xpath", "//div[@class='REALM-BDY-RGHT REALM-BDY-EL REALM-BDY-RGHT-QONCIERGE HAS-TRANS-300']//input[@placeholder='FORMAT']");
		if(delimitedField!= null)
		{
			delimitedField.clear();		Thread.sleep(2000);
			delimitedField.sendKeys(CommonValues.feedDelimitedFieldValue);	Thread.sleep(2000);
			delimitedField.sendKeys(Keys.TAB);
			WriteTestResult.addRowInDetailsSheet("LOAD FILE FORMAT", "SET FORMAT FIELD - 'DELIMITED'", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "");
		}
		else
		{
			WriteTestResult.addRowInDetailsSheet("LOAD FILE FORMAT", "SET FORMAT FIELD - 'DELIMITED'", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "FORMAT FIELD NOT FOUND");
		}
		
//		Thread.sleep(2000);
		WebElement directionField = FunctionLibraries2.locator("xpath", "//div[@class='REALM-BDY-RGHT REALM-BDY-EL REALM-BDY-RGHT-QONCIERGE HAS-TRANS-300']//input[@placeholder='DIRECTION']");
		if(directionField!= null)
		{
			directionField.clear();		Thread.sleep(2000);
			directionField.sendKeys(CommonValues.feedDirectionFieldValue);		Thread.sleep(2000);
			directionField.sendKeys(Keys.TAB);
			WriteTestResult.addRowInDetailsSheet("LOAD FILE DIRECTION", "SET DIRECTION FIELD - 'INBOUND'", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "");
		}
		else
		{
			WriteTestResult.addRowInDetailsSheet("LOAD FILE DIRECTION", "SET DIRECTION FIELD - 'INBOUND'", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "DIRECTION FIELD NOT FOUND");
		}			
		
//		Thread.sleep(2000);			
		//Adding Feeds(New) Summary
		String processFieldXPath = "//div[@class='REALM-BDY-RGHT REALM-BDY-EL REALM-BDY-RGHT-QONCIERGE HAS-TRANS-300']//div[@class='EZ-WGT-SUPER-SCT-BDY-INNER NO-WRAP']//div[1]//div[2]//div[1]//div[1]//div[5]//div[1]//input[1]";
		WebElement processField = FunctionLibraries2.locator("xpath", processFieldXPath);
		if(processField!= null)
		{
			processField.clear();	Thread.sleep(2000);
			processField.sendKeys(CommonValues.feedProcessFieldValue);		Thread.sleep(3000);
			CreateLogs.writeLogs("SELECTED VALUE FOR PROCESS ::- EMPLOYEE");
			processField.sendKeys(Keys.TAB);
			WriteTestResult.addRowInDetailsSheet("LOAD FILE PROCESS", "SET PROCESS FIELD - 'EMPLOYEE'", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "");
		}
		else
		{
			WriteTestResult.addRowInDetailsSheet("LOAD FILE PROCESS", "SET PROCESS FIELD - 'EMPLOYEE'", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "PROCESS FIELD NOT FOUND");
		}
		
		String systemFieldXPath = "//div[@class='REALM-BDY-RGHT REALM-BDY-EL REALM-BDY-RGHT-QONCIERGE HAS-TRANS-300']//div[@class='EZ-WGT-SUPER-SCT-BDY-OUTER OVFLW-HDN HAS-TRANS-300']//div[2]//div[2]//div[1]//div[2]//div[5]//div[1]//input[1]";
		WebElement systemField = FunctionLibraries2.locator("xpath", systemFieldXPath);
		if(systemField!= null)
		{
			systemField.clear();	Thread.sleep(2000);
			systemField.sendKeys(CommonValues.feedSystemFieldValue);	Thread.sleep(3000);
			CreateLogs.writeLogs("SELECTED VALUE FOR SYSTEM ::- HR");
			systemField.sendKeys(Keys.TAB);
			WriteTestResult.addRowInDetailsSheet("LOAD FILE SYSTEM", "SET SYSTEM FIELD - 'HR'", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "");
		}
		else
		{
			WriteTestResult.addRowInDetailsSheet("LOAD FILE SYSTEM", "SET SYSTEM FIELD - 'HR'", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "HR FIELD NOT FOUND");
		}
		
		String anteMappingXPath = "//div[@class='REALM-BDY-RGHT REALM-BDY-EL REALM-BDY-RGHT-QONCIERGE HAS-TRANS-300']//div[@class='EZ-WGT-SUPER-SCT-BDY-OUTER OVFLW-HDN HAS-TRANS-300']//div[2]//div[2]//div[1]//div[3]//div[5]//div[1]//input[1]";
		WebElement anteMappingField = FunctionLibraries2.locator("xpath", anteMappingXPath);
		if(anteMappingField!= null)
		{
			anteMappingField.clear();	Thread.sleep(2000);
			anteMappingField.sendKeys(CommonValues.feedAnteMappingField);		Thread.sleep(3000);
			CreateLogs.writeLogs("SELECTED VALUE FOR ANTECEDENT-MAPPING ::- EMP TEST 105 EMPLOYEE COMPLETED");
			anteMappingField.sendKeys(Keys.TAB);
			anteMappingField.sendKeys(Keys.TAB);
			WriteTestResult.addRowInDetailsSheet("LOAD FILE MAPPING", "SET ANTECEDENT-MAPPING FIELD - 'EMP TEST 105 EMPLOYEE COMPLETED'", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "");
		}
		else
		{
			WriteTestResult.addRowInDetailsSheet("LOAD FILE MAPPING", "SET ANTECEDENT-MAPPING FIELD - 'EMP TEST 105 EMPLOYEE COMPLETED'", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "ANTECEDENT-MAPPING FIELD NOT FOUND");
		}
	}
	
	@Test(priority=4)
	public static void WithdrawalFeed_AndVerify() throws InterruptedException, IOException
	{
		try
		{
			Thread.sleep(2000);
			CommonMethods2.searchAdminRecord(CommonValues.searchFeedsStatusValue, "", CommonValues.searchFeedFileNameValue, "");
//			Thread.sleep(2000);
			String firstRowXPath = "//div[@class='REALM REALM-QONCIERGE']//div[@class='GRID-WGT-BODY-OUTER']//div[@class='GRID-WGT-TBLS']//table//tr[1]//td[1]//div";
			FunctionLibraries2.clickButton("xpath", firstRowXPath, "FIRST ROW");
//			Thread.sleep(2000);
			String feedNameXPath = "//div[@class='QONCIERGE-C4 C4 HAS-TRANS-300 OVFLW-HDN']//div[@class='EZ-CAPTION-WGT-CPTN BOR-BOX']";
			String feedName = FunctionLibraries2.locator("xpath", feedNameXPath).getAttribute("title");
			CreateLogs.writeLogs("SELECTED RECORD TITLE IS ::- " +feedName);
//			Thread.sleep(2000);
			CommonMethods2.searchAdminRecord("COMPLETED", feedName, "EmployeeWorkday_QANON-B65_062519.csv", "");
//			Thread.sleep(2000);
			String withdrawEnabledXPath = "//div[@class='QONCIERGE-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-WITHDRAW'][@title='WITHDRAW']";
			String withdrawDisabledXPath = "//div[@class='QONCIERGE-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-WITHDRAW TRG-BASE-DISABLED'][@title='WITHDRAW']";
			if(DeclareVariables.driver2.findElements(By.xpath(withdrawEnabledXPath)).size()>0)
			{
				FunctionLibraries2.clickButton("xpath", withdrawEnabledXPath, "WITHDRAW");
				Thread.sleep(3000);
				String submitXPathEnabled = "//div[@class='QONCIERGE-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-SUBMIT'][@title='SUBMIT']";
				String submitXPathDisabled = "//div[@class='QONCIERGE-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-SUBMIT TRG-BASE-DISABLED'][@title='SUBMIT']";
//				boolean submitBtn= FunctionLibraries2.locator("xpath", submitXPath).isEnabled();
//				if(submitBtn==true)
//				{
				if(DeclareVariables.driver2.findElements(By.xpath(submitXPathEnabled)).size()>0)
				{
				
					DeclareVariables.passResultMessage = "TEST PASSED! BECAUSE SUBMIT BUTTON BECOMES ENABLED AFTER 'WITHDRAW' ICON CLICKED!!!";
					//Print Result in Excel File
					WriteTestResult.addRowInBasicSheet("WithdrawalFeed_AndVerify", "PASS", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
					WriteTestResult.addRowInDetailsSheet("WITHDRAW FEED", "WITHDRAW BUTTON", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.passResultMessage);
					CreateLogs.writeLogs(DeclareVariables.passResultMessage);
				}
				else if(DeclareVariables.driver2.findElements(By.xpath(submitXPathDisabled)).size()>0)
				{
					DeclareVariables.failResultMessage = "TEST FAILED! AS SUBMIT BUTTON IS DISABLED AFTER 'WITHDRAW' ICON CLICKED. PLEASE CHECK!!!";
					//Print Result in Excel File
					WriteTestResult.addRowInBasicSheet("WithdrawalFeed_AndVerify", "FAIL", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
					WriteTestResult.addRowInDetailsSheet("WITHDRAW FEED", "WITHDRAW BUTTON", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
					CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				}
				else
				{
					DeclareVariables.failResultMessage = "TEST FAILED! AS SUBMIT BUTTON IS DISABLED AFTER 'WITHDRAW' ICON CLICKED. PLEASE CHECK!!!";
					//Print Result in Excel File
					WriteTestResult.addRowInBasicSheet("WithdrawalFeed_AndVerify", "FAIL", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
					WriteTestResult.addRowInDetailsSheet("WITHDRAW FEED", "WITHDRAW BUTTON", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
					CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				}
			}
			else if(DeclareVariables.driver2.findElements(By.xpath(withdrawDisabledXPath)).size()>0)
			{
				DeclareVariables.failResultMessage = "TEST FAILED! AS WITHDRAW BUTTON IS DISABLED. PLEASE CHECK.";
				//Print Result in Excel File
				WriteTestResult.addRowInBasicSheet("WithdrawalFeed_AndVerify", "FAIL", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("WITHDRAW FEED", "WITHDRAW BUTTON", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			}
			else {
				
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			DeclareVariables.failResultMessage = "TEST FAILED! AS WITHDRAW BUTTON IS DISABLED OR WITHDRAW UNAVAILABLE. PLEASE CHECK.";
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("WithdrawalFeed_AndVerify", "FAIL", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.adminModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("WITHDRAW FEED", "WITHDRAW BUTTON", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
		}
		CommonMethods2.indicatorStartEnd("END", "FEEDS-ADMIN");
	}
	
	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
		CommonMethods2.refreshPage();
		Thread.sleep(5000);
		CommonMethods2.indicatorStartEnd("END", "FEEDS-ADMIN");
		DeclareVariables.driver2.close();
		DeclareVariables.driver2.quit();
	}
}