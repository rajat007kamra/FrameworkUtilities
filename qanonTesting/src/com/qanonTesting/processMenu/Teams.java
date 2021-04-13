package com.qanonTesting.processMenu;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qanonTesting.login.tests.Login2;
import com.qanonTesting.utilities.*;

public class Teams 
{
	public static String submitIconXPath = "//div[@class='PRIZE-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-SUBMIT'][@title='SUBMIT']";
	
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try 
		{ 
			CreateExcelFile.createWorkbook();
			CommonMethods2.indicatorStartEnd("START", "TEAMS-PROCESSES");
			Login2.verify_Login(CommonValues.txtUsername2, CommonValues.txtPassword2);
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 1)
	public static void navigateTo_TeamsPage() throws Exception
	{
		try
		{
			CommonMethods2.indicatorStartEnd("START", "TEAMS-PROCESSES");
//			Thread.sleep(5000);
			//Searching page and navigating to it
//			CommonMethods2.searchPage("TEAMS", "", "TEAMS PAGE SEARCHED");
			CommonMethods2.searchPageNew("TEAMS", "ADMIN", "", "TEAMS PAGE SEARCHED");
			CommonMethods2.closeExistingTab(CommonValues.processesModule);
			CommonMethods2.resetPage(CommonValues.processesModule);
			
			//Capture time when Teams page clicked
			long t1 = new Date().getTime();
			CreateLogs.writeLogs("TIME WHEN HIT ENTER TO NAVIGATE ON 'TEAMS' PAGE:- " +t1 +" milliseconds");
					
//			DeclareVariables.wait2 = new Webdriver1Wait(DeclareVariables.driver2, 90);
			DeclareVariables.footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']//*[text()='TEAMS']//ancestor::span";
			
			if(FunctionLibraries2.isElementPresent(By.xpath(DeclareVariables.footerRowXPath)))
			{
				DeclareVariables.footerRow = DeclareVariables.wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeclareVariables.footerRowXPath)));	
				DeclareVariables.footerPageName = DeclareVariables.footerRow.getText();
				
				Assert.assertEquals("TEAMS", DeclareVariables.footerPageName);
				//Capture time when Securities page opened and verified
				long t2 = new Date().getTime();
				CreateLogs.writeLogs("TIME WHEN 'TEAMS' PAGE OPENED AND VERIFIED:- " +t2 +" milliseconds");
				CreateLogs.writeLogs("SYSTEM IS AT 'TEAMS' PAGE!!!");
				
				DeclareVariables.timeTaken = (t2-t1) +" milliseconds";
				
				//Actual time to open Teams page 		  
				CreateLogs.writeLogs("ACTUAL TIME TAKEN BY SYSTEM IN OPENING OF 'TEAMS' PAGE:- " +DeclareVariables.timeTaken);
				
				//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_TeamsPage_"+System.currentTimeMillis() +".png");
				
				//Print Result in Excel File
				DeclareVariables.passResultMessage = "SYSTEM IS AT 'TEAMS' PAGE!!!";
				WriteTestResult.addRowInBasicSheet("navigateTo_TeamsPage", "PASS", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY TEAMS SCREEN", "TEAMS SCREEN OPEN", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
			
				/* 
				 * 
				 * Code for Performance Report
				 *  
				 */
				
				DeclareVariables.openScreenCounting = DeclareVariables.openScreenCounting+1;
				System.out.println("OPEN SCREEN " +DeclareVariables.openScreenCounting);
				String noOfAction = Integer.toString(DeclareVariables.openScreenCounting);
				System.out.println(noOfAction);
				DeclareVariables.openTeamsTime = (double) (t2-t1)/1000;
				if(DeclareVariables.openTeamsTime <0)
				{
					DeclareVariables.openTeamsTime = 0.00;
				}
				else
				{
					
				}
			}
			else
			{
				//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_TeamsPage_"+System.currentTimeMillis() +".png");
				//Print Result in Excel File
				DeclareVariables.failResultMessage = "'TEAMS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
				WriteTestResult.addRowInBasicSheet("navigateTo_TeamsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY TEAMS SCREEN", "TEAMS SCREEN NOT FOUND", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);		
			}
		}
		catch(Exception ex)
		{
			//Call take screenshot function
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_TeamsPage_"+System.currentTimeMillis() +".png");
			//Print Result in Excel File
			DeclareVariables.failResultMessage = "'TEAMS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
			WriteTestResult.addRowInBasicSheet("navigateTo_TeamsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY TEAMS SCREEN", "TEAMS SCREEN NOT FOUND", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 2)
	public static void findRecords_TeamsPage() throws Exception
	{
		try 
		{
			Thread.sleep(1500);
            String footerRowXPath="//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']//div[@class='VZ-WGT-BDY-DECK']//div[@class='GRID-WGT vert-flex-cnt']//div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']//div[@class='GRIDWGT-INNER']//div[@class='GRID-WGT-TOTALS-OUTER']//div[@class='GRID-TOTALS-WGT']//div[@class='GRID-MSG-WGT']//div[@class='GRID-MSG-WGT-ITEMS-OUTER']//div//div[@class='gwt-Label']";
            List<WebElement> valueF= DeclareVariables.driver2.findElements(By.xpath(footerRowXPath));
            for(int i=0;i<valueF.size();i++){
            	DeclareVariables.pageCount = valueF.get(i).getText();
            	CreateLogs.writeLogs("RECORDS COUNT OF 'TEAMS' PAGE ::- " +DeclareVariables.pageCount);
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
	    		CreateLogs.writeLogs("ACTUAL NUMBER OF RECORDS DISPLAYING IN 'TEAMS' PAGE::- " +rowCount);
	    		CommonMethods2.closePopUp();
		    	
	    		//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_TeamsPage_"+System.currentTimeMillis() +".png");				
		    	//Print Result in Excel File
				DeclareVariables.passResultMessage = rowCount +" - RECORDS FOUND IN 'TEAMS' PAGE!!!";
				WriteTestResult.addRowInBasicSheet("findRecords_TeamsPage", "PASS", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
				WriteTestResult.addRowInDetailsSheet("TEAMS RECORDS", "FIND RECORDS - " +rowCount, "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.passResultMessage);
	    	}
	    	else
			{
	    		//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_TeamsPage_"+System.currentTimeMillis() +".png");				
		    	//Print Result in Excel File
				DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'TEAMS' PAGE OR ELEMENT LOCATOR NOT MATCHED";
				WriteTestResult.addRowInBasicSheet("findRecords_TeamsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("TEAMS RECORDS", "RECORD COUNT NOT FOUND", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
			}
		}
		catch(Exception ex)
		{			
			//Call take screenshot function
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_TeamsPage_"+System.currentTimeMillis() +".png");				
	    	//Print Result in Excel File
			DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'TEAMS' PAGE OR ELEMENT LOCATOR NOT MATCHED";
			WriteTestResult.addRowInBasicSheet("findRecords_TeamsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("TEAMS RECORDS", "RECORD COUNT NOT FOUND", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 3)
	public static void verifyReviseButton_TeamsPage() throws Exception
	{
		try 
		{			
			CommonMethods2.closeExistingTab(CommonValues.processesModule);
			CommonMethods2.resetPage(CommonValues.processesModule);
			Thread.sleep(5000);
			CommonMethods2.searchProcessRecord(CommonValues.teamsSearchStateValue1, CommonValues.teamsSearchTeamValue, "", "");
			Thread.sleep(3000);
			DeclareVariables.table1row1column1XPath = "//div[@class='REALM REALM-PRIZE']//div[@class='GRID-WGT-BODY-OUTER']//div[@class='GRID-WGT-TBLS']//table//tr[1]//td[1]//div";
			if(FunctionLibraries2.isElementPresent(By.xpath(DeclareVariables.table1row1column1XPath)))
			{
//				Thread.sleep(2000); 
				DeclareVariables.table1row1column1Status = FunctionLibraries2.locator("xpath", DeclareVariables.table1row1column1XPath).getText();				
				CreateLogs.writeLogs("INITIALLY RECORD STATUS FOUND ::- " +DeclareVariables.table1row1column1Status);
				if(DeclareVariables.table1row1column1Status.equals("ACTIVE"))
				{
					FunctionLibraries2.locator("xpath", DeclareVariables.table1row1column1XPath).click();
					WriteTestResult.addRowInDetailsSheet("VERIFY TEAMS ROW", "ROW SELECTED", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "FIRST ROW", "", "FIRST ROW SELECTED");
				}
				else
				{
					CommonMethods2.searchProcessRecord(CommonValues.teamsSearchStateValue2, CommonValues.teamsSearchTeamValue, "", "");
					FunctionLibraries2.locator("xpath", DeclareVariables.table1row1column1XPath).click();
					WriteTestResult.addRowInDetailsSheet("VERIFY TEAMS ROW", "ROW SELECTED", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "FIRST ROW", "", "FIRST ROW SELECTED");
					FunctionLibraries2.clickButton("xpath", submitIconXPath, "SUBMIT");
					Thread.sleep(3000);
					CommonMethods2.searchProcessRecord(CommonValues.teamsSearchStateValue1, CommonValues.teamsSearchTeamValue, "", "");
					Thread.sleep(3000);
					FunctionLibraries2.locator("xpath", DeclareVariables.table1row1column1XPath).click();
				}
			}
			else
			{
				CreateLogs.writeLogs("NO RECORD FOUND IN TABLE OR UNABLE TO LOCATE ELEMENT");
			}
	
			Thread.sleep(3000);
			String rightMenuXPath = "//div[@class='REALM-HD-RGHT REALM-HD-EL REALM-HD-RGHT-PRIZE']//div[@class='shuffle-trg TRG-BASE trg-base material-icons abs-pos shuffle-trg-rght tent-thm-trg shuffle-trg-ACTIVE shuffle-trg-active TRG-BASE-ACTIVE trg-base-active']";
			if(FunctionLibraries2.isElementPresent(By.xpath(rightMenuXPath)))
			{
				String rightMenu = FunctionLibraries2.locator("xpath", rightMenuXPath).getAttribute("title");
				System.out.println("RIGHT MENU TITLE = " +rightMenu);
				Assert.assertEquals(rightMenu, "EXPAND");
				FunctionLibraries2.clickButton("xpath", rightMenu, "RIGHT MENU");
			}
			else
			{
				
			}
			Thread.sleep(3000);
			String reviseIconXPath = "//div[@class='PRIZE-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-REVISE'][@title='REVISE']";
			if(FunctionLibraries2.isElementPresent(By.xpath(reviseIconXPath)))
			{
				WebElement reviseIcon = FunctionLibraries2.locator("xpath", reviseIconXPath);
				Thread.sleep(2000);
				Boolean isEnabledReviseIcon = reviseIcon.isEnabled();
				if(isEnabledReviseIcon.equals(true))
				{
					reviseIcon.click();		//Revise Icon Clicked
					//Capture time when REVISE button clicked
					long t1 = new Date().getTime();
					CreateLogs.writeLogs("TIME WHEN 'REVISE' BUTTON CLICKED ON TEAMS PAGE:- " +t1 +" milliseconds");
					
//					Thread.sleep(2000);
					String submitXPath = "//div[@class='PRIZE-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-SUBMIT']//div[@class='WORKBAR-WGT-TRG-ICON mz-icons']";
					boolean submitBtn = FunctionLibraries2.locator("xpath", submitXPath).isEnabled();
					if(submitBtn==true)
					{
						long t2 = new Date().getTime();
						DeclareVariables.timeTaken = (t2-t1) + " millisecondss";
						
						DeclareVariables.passResultMessage = "TEST PASSSED! REVISE ICON/BUTTON CLICKED SUCCESSFULLY AND WORKING FINE";
						CreateLogs.writeLogs(DeclareVariables.passResultMessage);
						DeclareVariables.onlyMessage = "REVISE CLICKED FOR SELECTED FIRST ROW AND 'SUBMIT' ICON ENABLED SUCCESSFULLY";
						WriteTestResult.addRowInDetailsSheet("VERIFY TEAMS REVISE", "REVISE CLICKED", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "FIRST ROW", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
						WriteTestResult.addRowInBasicSheet("verifyReviseButton_TeamsPage", "PASS", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
						
						/* 
						 * 
						 * Code for Performance Report
						 *  
						 */
						
						DeclareVariables.reviseBtnCounting = DeclareVariables.reviseBtnCount+1;
//						System.out.println("REVISE " +DeclareVariables.reviseBtnCounting);
						String noOfAction = Integer.toString(DeclareVariables.reviseBtnCounting);
						System.out.println(noOfAction);
						DeclareVariables.reviseTeamTime = (double) (t2-t1)/1000;
						WriteTestResult.addRowInPerformanceSheet("REVISE", noOfAction, Double.toString(DeclareVariables.reviseTeamTime), Double.toString(DeclareVariables.reviseTeamTime), Double.toString(DeclareVariables.reviseTeamTime), Double.toString(DeclareVariables.reviseTeamTime), Double.toString(DeclareVariables.reviseTeamTime));
					}
					else
					{
						
					}
				}
				else
				{
					DeclareVariables.failResultMessage = "EITHER RECORD NOT FOUND OR REVISE' ICON/BUTTON NOT FOUND FOR '"+CommonValues.teamsSearchTeamValue+"' ON 'TEAMS' PAGE OR IT IS DISABLED. PLEASE CHECK!!!";
					//Call take screenshot function
					CommonMethods2.takeSnapShot(DeclareVariables.driver2, "verifyReviseButton_TeamsPage_"+System.currentTimeMillis() +".png");
					CreateLogs.writeLogs(DeclareVariables.failResultMessage);
					//Print Result in Excel File					
					WriteTestResult.addRowInBasicSheet("verifyReviseButton_TeamsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
				}
			}
			else
			{
				DeclareVariables.failResultMessage = "EITHER RECORD NOT FOUND OR REVISE' ICON/BUTTON NOT FOUND FOR '"+CommonValues.teamsSearchTeamValue+"'  ON 'TEAMS' PAGE OR IT IS DISABLED. PLEASE CHECK!!!";
				//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "verifyReviseButton_TeamsPage_"+System.currentTimeMillis() +".png");
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Print Result in Excel File				
				WriteTestResult.addRowInBasicSheet("verifyReviseButton_TeamsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
			}
		}
		catch(Exception ex)
		{
			DeclareVariables.failResultMessage = "EITHER RECORD NOT FOUND OR REVISE' ICON/BUTTON NOT FOUND FOR '"+CommonValues.teamsSearchTeamValue+"'  ON 'TEAMS' PAGE OR IT IS DISABLED. PLEASE CHECK!!!";
			//Call take screenshot function
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "verifyReviseButton_TeamsPage_"+System.currentTimeMillis() +".png");
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File				
			WriteTestResult.addRowInBasicSheet("verifyReviseButton_TeamsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 4)
	public static void verifySubmitButton_TeamsPage() throws Exception
	{
		try 
		{
			DeclareVariables.table1row1column1XPath = "//div[@class='REALM REALM-PRIZE']//div[@class='GRID-WGT-BODY-OUTER']//div[@class='GRID-WGT-TBLS']//table//tr[1]//td[1]//div";
			Thread.sleep(3000);
			if(FunctionLibraries2.isElementPresent(By.xpath(submitIconXPath)))
			{
				WebElement submitIcon = FunctionLibraries2.locator("xpath", submitIconXPath);
				Boolean isEnabledSubmitIcon = submitIcon.isEnabled();
				if(isEnabledSubmitIcon.equals(true))
				{
					submitIcon.click();
					long t11 = new Date().getTime();
					CreateLogs.writeLogs("TIME WHEN 'SUBMIT' BUTTON CLICKED ON TEAMS PAGE:- " +t11 +" milliseconds");
//					Thread.sleep(3000);
					WebElement submitPopUp = FunctionLibraries2.locator("xpath", "//div[@class='cmplt-noti-dlg-lbl cmplt-noti-update-dlg-lbl inln-blck v-mid-algn']");
			        String submitPopUpMsg = submitPopUp.getText();
			        long t12 = new Date().getTime();
			        CreateLogs.writeLogs("TIME WHEN 'SUBMIT' POPUP APPEARED:- " +t12 +" milliseconds");
			        
			        DeclareVariables.timeTaken = (t12-t11) + " milliseconds";
//			        System.out.println("AFTER SUBMIT BUTTON CLICKED MESSAGE FOUND ::- " +submitPopUpMsg);
			        if(submitPopUpMsg.equals("SUBMITTED!"))
	        		{
			        	DeclareVariables.passResultMessage = "TEST PASSED! SUBMIT ICON/BUTTON CLICKED SUCCESSFULLY AND WORKING FINE";
			        	CreateLogs.writeLogs(DeclareVariables.passResultMessage);
//						DeclareVariables.onlyMessage = "SUBMIT CLICKED FOR SELECTED 'OPERATING TESTING' RECORD AND 'SUBMITTED!' MESSAGE APPEARED";
			        	WriteTestResult.addRowInDetailsSheet("VERIFY TEAMS SUBMIT", "SUBMIT CLICKED", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "FIRST ROW", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
			        	WriteTestResult.addRowInBasicSheet("verifySubmitButton_TeamsPage", "PASS", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
						
						Thread.sleep(2000);
						CommonMethods2.closePopUp();
						
						/* 
						 * 
						 * Code for Performance Report
						 *  
						 */
						DeclareVariables.submitBtnCounting = DeclareVariables.submitBtnCounting+1;
						System.out.println("SUBMIT " +DeclareVariables.submitBtnCounting);
						String noOfAction = Integer.toString(DeclareVariables.submitBtnCounting);
//						System.out.println(noOfAction);
						DeclareVariables.submitTeamsTime = (double) (t12-t11)/1000;
	        		}
			        else
			        {
			        	DeclareVariables.onlyMessage = "SUBMIT CLICKED FOR SELECTED 'OPERATING TESTING' RECORD BUT 'SUBMITTED!' MESSAGE NOT FOUND";
			        	WriteTestResult.addRowInDetailsSheet("VERIFY TEAMS SUBMIT", "SUBMIT CLICKED", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.onlyMessage);
			        }			
				}
				else
				{
					DeclareVariables.failResultMessage = "SUBMIT ICON/BUTTON NOT FOUND OR IT IS DISABLED. PLEASE CHECK!!!";
					//Call take screenshot function
					CommonMethods2.takeSnapShot(DeclareVariables.driver2, "verifySubmitButton_TeamsPage_"+System.currentTimeMillis() +".png");
					CreateLogs.writeLogs(DeclareVariables.failResultMessage);
					//Print Result in Excel File
					WriteTestResult.addRowInBasicSheet("verifySubmitButton_TeamsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
//					Assert.fail(DeclareVariables.failResultMessage);
				}
			}
		}
		catch(Exception ex)
		{
			DeclareVariables.failResultMessage = "SUBMIT ICON/BUTTON NOT FOUND OR IT IS DISABLED. PLEASE CHECK!!!";
			//Call take screenshot function
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "verifySubmitButton_TeamsPage_"+System.currentTimeMillis() +".png");
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("verifySubmitButton_TeamsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
//			Assert.fail(DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	//Method to verify Email
	@Test(priority = 5)
	public static void verifyEmail_TeamsPage() throws InterruptedException, IOException
	{
		try
		{
			String workflowXPath = "//div[@class='PRIZE-C4 C4 HAS-TRANS-300 OVFLW-HDN']//div[@class='EZ-WGT-FLEX-SCT EZ-WGT-FLEX-SCT-TRACKERS EZ-WGT-FLEX-SCT-TRACKERS-MAIN EZ-WGT-FLEX-SCT-TRANS']//div//div[@class='EZ-WGT-SPR-SCT-HDR-DSPL EZ-WGT-ITEM-EL EZ-WGT-SPR-SCT-HDR-DSPL-MAIN cursor-pntr']";
			if(DeclareVariables.driver2.findElements(By.xpath(workflowXPath)).size()>0)
			{
				FunctionLibraries2.clickButton("xpath", workflowXPath, "WORKFLOW LIST");
			}
			else
			{
				CreateLogs.writeLogs("'WORKFLOW' LIST NOT FOUND");
			}
			
			String actionsXPath = "//div[@class='PRIZE-C4 C4 HAS-TRANS-300 OVFLW-HDN']//div[@class='EZ-WGT-HOLDER abs-pos']//div[@class='EZ-WGT EZ-WGT-MAIN abs-pos']//div[@class='EZ-WGT-FLEX-OUTER-WRP EZ-WGT-FLEX-OUTER-WRP-MAIN realm-dominant-bg realm-dominant-clr']//div[@class='EZ-WGT-FLEX-SCT EZ-WGT-FLEX-SCT-TRACKERS EZ-WGT-FLEX-SCT-TRACKERS-MAIN EZ-WGT-FLEX-SCT-TRANS']//div//span[@class='ez-wgt-wide-itm-lbl ez-wgt-wide-itm-el cursor-pntr'][contains(text(),'ACTIONS')]";	
			if(DeclareVariables.driver2.findElements(By.xpath(actionsXPath)).size()>0)
			{
				FunctionLibraries2.clickButton("xpath", actionsXPath, "ACTIONS LIST");
//				Thread.sleep(3000);
				String headerTextXPath = "//div[@class='STND-PAD-HDR STND-PAD-HDR-ACTIONWGT-SCTHDR STND-PAD-ITEM-EL'][@title='ALL EMAILS']";
				String headerText = FunctionLibraries2.locator("xpath", headerTextXPath).getAttribute("title");
				Assert.assertEquals(headerText, "ALL EMAILS");
				
				String addEmailIconXPath = "//div[@class='REALM REALM-PRIZE']//div[@class='HOR-FLEX-EL FLY-ADD-TRG FLY-TOP-TRG material-icons TRG-BASE trg-base'][@title='ADD NEW ACTIVITY']";
				FunctionLibraries2.clickButton("xpath", addEmailIconXPath, "ADD NEW ACTIVITY");
				
//				Thread.sleep(3000);
				String toMailIdXpath = "//div[@class='REALM REALM-PRIZE']//div[@class='ACTIONWGT-EMAIL-VIEWER']//div[@class='ACTIONWGT-VIEWER-FIELDS']//div[1]//input[1]"; 
				FunctionLibraries2.enterText("xpath", toMailIdXpath, CommonValues.toEmailId);
				
//				Thread.sleep(2000);
				String bodyMailIdXpath = "//div[@class='REALM REALM-PRIZE']//textarea[@class='ACTIONWGT-ITEM-TEXTAREA stnd-gry-input-bg']"; 
				FunctionLibraries2.enterText("xpath", bodyMailIdXpath, CommonValues.mailBodyMsg);
				
//				Thread.sleep(3000);
				String sendEmailIconXPath = "//div[@class='REALM REALM-PRIZE']//div[@class='HOR-FLEX-CNT FLY-TOOL-BAR']//div[@class='HOR-FLEX-EL FLY-SUBMIT-TRG FLY-TOP-TRG material-icons TRG-BASE trg-base'][@title='SEND EMAIL']";
				FunctionLibraries2.clickButton("xpath", sendEmailIconXPath, "SEND EMAIL");
				long t1 = new Date().getTime();

				String saveTextXPath = "//div[@class='INLN-BLCK v-mid-algn']//div[@class='cmplt-noti-dlg-lbl cmplt-noti-dlg-lbl-top']";
				Thread.sleep(2000);
				WebElement savePopUp = DeclareVariables.driver2.findElement(By.xpath(saveTextXPath));
		        if(savePopUp!=null)
		        {
//		        	Thread.sleep(1500);
		        	DeclareVariables.savePopUpMsg = savePopUp.getText();
		        	CreateLogs.writeLogs("EMAIL POP UP MESSAGE FOUND ::- " +DeclareVariables.savePopUpMsg);
		        	if((DeclareVariables.savePopUpMsg).equals("EMAIL SENT"))
		            {
		        		long t2 = new Date().getTime();
		        		DeclareVariables.timeTaken = (t2-t1) +" milliseconds";
		        		DeclareVariables.passResultMessage = "EMAIL SENT SUCCESSFULLY AND 'EMAIL SENT' MESSAGE FOUND!!!";
		        		CreateLogs.writeLogs(DeclareVariables.passResultMessage);
		        		WriteTestResult.addRowInBasicSheet("verifyEmail_TeamsPage", "PASS", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
		            	WriteTestResult.addRowInDetailsSheet("SEND EMAIL - TEAMS PAGE", "EMAIL", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
		            }
		            else
		            {
		            	DeclareVariables.passResultMessage = "EMAIL SENT SUCCESSFULLY AND 'EMAIL SENT' MESSAGE NOT FOUND!!!";
		            	CreateLogs.writeLogs(DeclareVariables.passResultMessage);
		            	WriteTestResult.addRowInBasicSheet("verifyEmail_TeamsPage", "PASS", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
		            	WriteTestResult.addRowInDetailsSheet("SEND EMAIL - TEAMS PAGE", "EMAIL", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.passResultMessage);
		            }
		        }
		        else
		        {
		        	DeclareVariables.failResultMessage = "EMAIL SENT POP UP NOT FOUND";
		        	CreateLogs.writeLogs(DeclareVariables.failResultMessage);
		        	WriteTestResult.addRowInBasicSheet("verifyEmail_TeamsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
		        	WriteTestResult.addRowInDetailsSheet("SEND EMAIL - TEAMS PAGE", "EMAIL", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
		        }
			}
			else {
				DeclareVariables.failResultMessage = "TEST FAILED! BECAUSE 'ACTIONS' OPTION NOT FOUND";
	        	CreateLogs.writeLogs(DeclareVariables.failResultMessage);
	        	WriteTestResult.addRowInBasicSheet("verifyEmail_TeamsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
	        	WriteTestResult.addRowInDetailsSheet("SEND EMAIL - TEAMS PAGE", "EMAIL", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			DeclareVariables.failResultMessage = "TEST FAILED! BECAUSE EITHER 'WORKFLOW' LIST NOT FOUND OR COLLAPSED";
        	CreateLogs.writeLogs(DeclareVariables.failResultMessage);
        	WriteTestResult.addRowInBasicSheet("verifyEmail_TeamsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
        	WriteTestResult.addRowInDetailsSheet("SEND EMAIL - TEAMS PAGE", "EMAIL", "TEAMS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
		}
		CommonMethods2.indicatorStartEnd("END", "TEAMS-PROCESSES");
	}
	
	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
		CommonMethods2.refreshPage();
		Thread.sleep(5000);
		CommonMethods2.indicatorStartEnd("END", "TEAMS-PROCESSES");
		DeclareVariables.driver2.close();
		DeclareVariables.driver2.quit();
	}
}