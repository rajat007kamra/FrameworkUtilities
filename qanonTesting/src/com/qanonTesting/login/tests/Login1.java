package com.qanonTesting.login.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qanonTesting.utilities.*;

public class Login1 
{  
	public static double loginTime;
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try 
		{
			CommonMethods1.openApplication();
			CommonMethods1.indicatorStartEnd("START", "LOGIN");
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 1)
	public static void verify_Login(String uName, String uPwd) throws Exception 
	{
		verifyLogin("excel", uName, uPwd);
	}

//	@Test(priority = 1)
//	public static void verify_Login() throws Exception 
//	{
//		verifyLogin("excel", CommonValues.txtUsername1, CommonValues.txtPassword1);
//	}
	
	public static void verifyLogin(String displayResult, String username, String password) throws Exception
	{
		try 
		{
			//Enter login credentials
			FunctionLibraries1.enterText("xpath", "/html/body/div[2]/div/div/div/div[4]/div/div/div[1]/input", username);
			Thread.sleep(2000);
			FunctionLibraries1.enterText("xpath", "/html/body/div[2]/div/div/div/div[4]/div/div/div[2]/input", password);
			Thread.sleep(3000);
			DeclareVariables.driver1.manage().window().maximize();
			//Click on LOGIN button
			WebElement loginBtn = FunctionLibraries1.locator("xpath", "//*[contains(text(),'LOGIN')]");
			if(loginBtn!= null)
			{
				FunctionLibraries1.clickButton("xpath", "//*[contains(text(),'LOGIN')]", "LOGIN");
				long t1 = new Date().getTime();
				if(displayResult.equals("excel"))
				{
					WebElement submitBtn = FunctionLibraries1.locator("xpath", "//*[contains(text(),'SUBMIT')]");
					if(submitBtn!= null)
					{
						long t2 = new Date().getTime();
						long t3 = (t2-t1);
						DeclareVariables.timeTaken = t3 +" milliseconds";
						DeclareVariables.onlyMessage = "LOGIN BUTTON SUCCESSFULLY CLICKED AND SUBMIT BUTTON APPEARED!!!";
						WriteTestResult.addRowInDetailsSheet("VERIFY LOGIN BUTTON-1", "LOGIN BUTTON CLICKED", "LOGIN", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername1, "", DeclareVariables.timeTaken, DeclareVariables.onlyMessage);
					}
					else
					{
						
					}
				}
				else
				{
					
				}				
			}
			else
			{
				WriteTestResult.addRowInDetailsSheet("VERIFY LOGIN BUTTON-1", "LOGIN BUTTON NOT FOUND", "LOGIN", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, username, "", "", "LOGIN BUTTON NOT FOUND");
			}

			Thread.sleep(5000);
			String subTanentXPath = "//div[@class='MODAL-GROUP-ITEM MODAL-GROUP-ITEM-FIELD']//input[@placeholder='SUBTENANT']";
			WebElement submitBtn = FunctionLibraries1.locator("xpath", subTanentXPath);
			if(submitBtn!= null)
			{
				Thread.sleep(2000);
				FunctionLibraries1.locator("xpath", subTanentXPath).click();
				Thread.sleep(2000);
				FunctionLibraries1.locator("xpath", subTanentXPath).clear();
				Thread.sleep(2000);
				FunctionLibraries1.locator("xpath", subTanentXPath).sendKeys(CommonValues.applicationName);
				CreateLogs.writeLogs("SELECTED SUB TANENT IS ::- " +CommonValues.applicationName);
				Thread.sleep(2000);
				FunctionLibraries1.locator("xpath", subTanentXPath).sendKeys(Keys.TAB);			
				Thread.sleep(2000);
				FunctionLibraries1.clickButton("xpath", "//*[contains(text(),'SUBMIT')]", "SUBMIT");
				//Capture time when Submit button clicked
				long t11 = new Date().getTime();
				CreateLogs.writeLogs("TIME WHEN 'SUBMIT' BUTTON CLICKED ON LOGIN PAGE:- " +t11 +" milliseconds");
				if(displayResult.equals("excel"))
				{
					DeclareVariables.onlyMessage = "SUBMIT BUTTON SUCCESSFULLY CLICKED ON LOGIN PAGE";
					WriteTestResult.addRowInDetailsSheet("VERIFY SUBMIT BUTTON-1", "SUBMIT BUTTON CLICKED", "LOGIN", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, username, "", "", DeclareVariables.onlyMessage);
				}
				else
				{
					
				}
				
				Thread.sleep(3000);
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				DeclareVariables.driver1.manage().window().maximize();
				CreateLogs.writeLogs("ESCAPE KEY PRESSED SUCCESSFULLY!!!");
				
				DeclareVariables.wait1 = new WebDriverWait(DeclareVariables.driver1, 90);
				String docsPageXPath = "//*[text()='ALL DOCUMENTS']//ancestor::span";
				if(DeclareVariables.driver1.findElements(By.xpath(docsPageXPath)).size()>0)
				{
					Thread.sleep(10000);
				}
				else {
					
				}
				
				Thread.sleep(5000);
				if(CommonMethods1.verifyHomePage().trim().equals(CommonValues.applicationName))
				{
					long t12 = new Date().getTime();
					CreateLogs.writeLogs("TIME WHEN APPLICATION LOGGED IN SUCCESSFULLY:- " +t12 +" milliseconds");
					
					long t13 = (t12-t11);
					DeclareVariables.timeTaken = (t13-5000) +" milliseconds";
					
					CommonMethods1.takeSnapShot(DeclareVariables.driver1, "verifyLogin_"+System.currentTimeMillis() +".png");
					DeclareVariables.passResultMessage = "TEST PASSED! USER LOGGED IN SUCCESSFULLY!!!";
					CreateLogs.writeLogs(DeclareVariables.passResultMessage);
					if(displayResult.equals("excel"))
					{
						//Print Result in Excel File
						WriteTestResult.addRowInBasicSheet("login-1", "PASS", DeclareVariables.timeTaken, CommonValues.dateTime, CommonValues.environmentName, CommonValues.subTenantName, "LOGIN", username, DeclareVariables.passResultMessage);
						WriteTestResult.addRowInDetailsSheet("VERIFY HOME PAGE-1", "HOME PAGE VISIBLE", "LOGIN", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, username, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
					
						/* 
						 * 
						 * Code for Performance Report
						 *  
						 */
						DeclareVariables.loginCounting = DeclareVariables.loginCounting+1;
						String noOfAction = Integer.toString(DeclareVariables.loginCounting);
//						System.out.println(noOfAction);
						loginTime = (double) (t13-5000)/1000;
						
						double[] nums = {Login2.loginTime, Login1.loginTime};
						Arrays.sort(nums);
						
						String minValue = String.format("%.2f", nums[0]);
						String maxValue = String.format("%.2f", nums[nums.length-1]);
						String meanValue = String.format("%.2f", (nums[0] + nums[nums.length-1])/2);
						
						//Calling percentile methods for values
					    DeclareVariables.percentile90 = Percentile.findPercentile(minValue, maxValue, 90);
					    DeclareVariables.percentile95 = Percentile.findPercentile(minValue, maxValue, 95);
						
					    WriteTestResult.addRowInPerformanceSheet("LOGIN", noOfAction, minValue, maxValue, meanValue, DeclareVariables.percentile90, DeclareVariables.percentile95);
					}
					else
					{
						
					}
				}
				else
				{
					CreateLogs.writeLogs("HOME PAGE HEADER(" +CommonValues.subTenantName+") NOT FOUND AFTER LOGING. PLEASE CHECK!!!");
				}
			}
			else
			{
				WriteTestResult.addRowInDetailsSheet("VERIFY SUBMIT BUTTON-1", "SUBMIT BUTTON NOT FOUND", "LOGIN", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, username, "", "", "SUBMIT BUTTON NOT FOUND");
			}
			  
			Thread.sleep(2000);
			long t21 = new Date().getTime();
			String dashboardVerifyTextPath = "/html/body/div[2]/div/div[2]/div/div[1]/div/div/div/div[5]/div[2]/div/div";			
			if(FunctionLibraries1.isElementPresent(By.xpath(dashboardVerifyTextPath)))
			{
				CreateLogs.writeLogs("SYSTEM IS AT NOTIFICATION WINDOW");
				DeclareVariables.verifyText = FunctionLibraries1.locator("xpath", dashboardVerifyTextPath).getText();										
				CreateLogs.writeLogs("VALUE FOUND ON NOTIFICATION WINDOW IS:-  " +DeclareVariables.verifyText);
				Assert.assertEquals(DeclareVariables.verifyText, " APPROVALS");
				
				//Capture time when found text after login for successful Login verification
				long t22 = new Date().getTime();
				CreateLogs.writeLogs("TIME WHEN APPLICATION LOGGED IN SUCCESSFULLY:- " +t22 +" milliseconds");
				
				DeclareVariables.timeTaken = (t22-t21) +" milliseconds";
//				System.out.println("T3 TIME ::- " +DeclareVariables.timeTaken);

				CreateLogs.writeLogs("ACTUAL TIME TAKEN BY SYSTEM IN LOGIN APPLICATION IS:- " +DeclareVariables.timeTaken);
				
				if(displayResult.equals("excel"))
				{
					CommonMethods1.takeSnapShot(DeclareVariables.driver1, "verifyLogin_"+System.currentTimeMillis() +".png");
					DeclareVariables.passResultMessage = "TEST PASSED! USER LOGGED IN SUCCESSFULLY!!!";
					//Print Result in Excel File
					WriteTestResult.addRowInBasicSheet("LOGIN-1", "PASS", DeclareVariables.timeTaken, CommonValues.dateTime, CommonValues.environmentName, CommonValues.subTenantName, CommonValues.loginModule, username, DeclareVariables.passResultMessage);
					WriteTestResult.addRowInDetailsSheet("VERIFY NOTIFICATION-1", "NOTIFICATIONS WINDOW VISIBLE", "LOGIN", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, username, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
				}
				else
				{
					
				}
			}
			else
			{
				
			}
//			CommonMethods1.closePopUp();
			//Go to INTRANET page
			CommonMethods1.goToIntranetPage();
		}
		catch(Exception ex)
		{
			CommonMethods1.takeSnapShot(DeclareVariables.driver1, "verifyLogin.png");
			//Print Result in Excel File
			DeclareVariables.failResultMessage = "TEST FAILED SYSTEM UNABLED TO LOGGED IN. PLEASE CHECK SCREENSHOT IN OUTPUT FOLDER!!!";
			WriteTestResult.addRowInBasicSheet("login-1", "FAIL", "", CommonValues.dateTime, CommonValues.environmentName, CommonValues.subTenantName, CommonValues.loginModule, username, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY LOGIN-1", "SYSTEM UNABLE TO LOGGED IN", "LOGIN", CommonMethods1.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, username, "", "", DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
//	@Test(priority = 2, enabled=false)
//	public static void verify_Logout() throws InterruptedException, AWTException 
//	{
//		try {
//			Thread.sleep(5000);
//			FunctionLibraries.clickButton("xpath", "//*[@title='LOGOUT']", "LOGOUT");
//			//Capture time when Logout button clicked
//			long t1 = new Date().getTime();
//			CreateLogs.writeLogs("Time when 'Logout' button clicked:- " +t1 +" milliseconds");
//			Thread.sleep(40000);
//
//			WebElement loginBtn = FunctionLibraries.locator("xpath", "//*[contains(text(),'LOGIN')]");
//			if(loginBtn!= null)
//			{
//				CommonMethods1.takeSnapShot(DeclareVariables.driver1, "verify_Logout.png");
//				DeclareVariables.passResultMessage = "TEST PASSED! USER LOGGED OUT SUCCESSFULLY!!!";
//				CreateLogs.writeLogs(DeclareVariables.passResultMessage);
//				//Print Result in Excel File
//				WriteTestResult.addRowInBasicSheet("logout", "PASS", "", CommonMethods1.GetCurrentTimeStamp(), DeclareVariables.environmentName, DeclareVariables.subTenantName, "LOGIN", username, DeclareVariables.passResultMessage);
//				WriteTestResult.addRowInDetailsSheet("VERIFY LOGOUT", "LOGIN PAGE OPEN", "LOGIN", CommonMethods1.GetCurrentTimeStamp(), DeclareVariables.environmentName, DeclareVariables.tenantName, DeclareVariables.subTenantName, ReadLoginDetails.user_name(), "", "", DeclareVariables.passResultMessage);
//			}
//			else
//			{
//				CommonMethods1.takeSnapShot(DeclareVariables.driver1, "verify_Logout.png");
//				DeclareVariables.failResultMessage = "TEST FAILED! SYSTEM UNABLE TO LOGGED OUT.!!!";
//				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
//				//Print Result in Excel File
//				WriteTestResult.addRowInBasicSheet("logout", "FAIL", "", CommonMethods1.GetCurrentTimeStamp(), DeclareVariables.environmentName, DeclareVariables.subTenantName, "LOGIN", username, DeclareVariables.failResultMessage);
//				WriteTestResult.addRowInDetailsSheet("VERIFY LOGOUT", "LOGIN PAGE NOT FOUND", "LOGIN", CommonMethods1.GetCurrentTimeStamp(), DeclareVariables.environmentName, DeclareVariables.tenantName, DeclareVariables.subTenantName, ReadLoginDetails.user_name(), "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
//				Assert.fail(DeclareVariables.failResultMessage);
//			}
//		}
//		catch(Exception ex)
//		{
//			CreateLogs.writeLogs(ex.getMessage());
//		}
//	}
	
	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
//		Thread.sleep(5000);
		CommonMethods1.indicatorStartEnd("END", "LOGIN");
//		DeclareVariables.driver1.close();
//		DeclareVariables.driver1.quit();
	}
}