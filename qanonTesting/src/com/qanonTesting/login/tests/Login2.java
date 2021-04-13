package com.qanonTesting.login.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qanonTesting.utilities.*;

public class Login2 
{  
	public static double loginTime;
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try {
			CommonMethods2.openApplication();
			CommonMethods2.indicatorStartEnd("START", "LOGIN");
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
//		verifyLogin("excel",CommonValues.txtUsername2, CommonValues.txtPassword2);
//	}
	
	public static void verifyLogin(String displayResult, String username, String password) throws Exception
	{
		try 
		{
			Thread.sleep(4000);
			//Enter login credentials
			FunctionLibraries2.enterText("xpath", "/html/body/div[2]/div/div/div/div[4]/div/div/div[1]/input", username);
			Thread.sleep(2000);
			FunctionLibraries2.enterText("xpath", "/html/body/div[2]/div/div/div/div[4]/div/div/div[2]/input", password);
			//Click on LOGIN button
			WebElement loginBtn = FunctionLibraries2.locator("xpath", "//*[contains(text(),'LOGIN')]");
			if(loginBtn!= null)
			{
				FunctionLibraries2.clickButton("xpath", "//*[contains(text(),'LOGIN')]", CommonValues.loginModule);
				long t1 = new Date().getTime();
				if(displayResult.equals("excel"))
				{
					WebElement submitBtn = FunctionLibraries2.locator("xpath", "//*[contains(text(),'SUBMIT')]");
					if(submitBtn!= null)
					{
						long t2 = new Date().getTime();
						long t3 = (t2-t1);
						DeclareVariables.timeTaken = t3 +" milliseconds";
						DeclareVariables.onlyMessage = "LOGIN BUTTON SUCCESSFULLY CLICKED AND SUBMIT BUTTON APPEARED!!!";
						WriteTestResult.addRowInDetailsSheet("VERIFY LOGIN BUTTON-2", "LOGIN BUTTON CLICKED", CommonValues.loginModule, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.onlyMessage);
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
				WriteTestResult.addRowInDetailsSheet("VERIFY LOGIN BUTTON-2", "LOGIN BUTTON NOT FOUND", CommonValues.loginModule, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, username, "", "", "LOGIN BUTTON NOT FOUND");
			}

			Thread.sleep(5000);
			String subTanentXPath = "//div[@class='MODAL-GROUP-ITEM MODAL-GROUP-ITEM-FIELD']//input[@placeholder='SUBTENANT']";
			WebElement submitBtn = FunctionLibraries2.locator("xpath", subTanentXPath);
			if(submitBtn!= null)
			{		
				Thread.sleep(2000);
				FunctionLibraries2.locator("xpath", subTanentXPath).click();
				Thread.sleep(2000);
				FunctionLibraries2.locator("xpath", subTanentXPath).clear();
				Thread.sleep(2000);
				FunctionLibraries2.locator("xpath", subTanentXPath).sendKeys(CommonValues.applicationName);
				CreateLogs.writeLogs("SELECTED SUB TANENT IS ::- " +CommonValues.applicationName);
				Thread.sleep(2000);
				FunctionLibraries2.locator("xpath", subTanentXPath).sendKeys(Keys.TAB);			
				Thread.sleep(2000);
				FunctionLibraries2.clickButton("xpath", "//*[contains(text(),'SUBMIT')]", "SUBMIT");
				//Capture time when Submit button clicked
				long t11 = new Date().getTime();
				CreateLogs.writeLogs("TIME WHEN 'SUBMIT' BUTTON CLICKED ON LOGIN PAGE:- " +t11 +" milliseconds");
				if(displayResult.equals("excel"))
				{
					DeclareVariables.onlyMessage = "SUBMIT BUTTON SUCCESSFULLY CLICKED ON LOGIN PAGE";
					WriteTestResult.addRowInDetailsSheet("VERIFY SUBMIT BUTTON-2", "SUBMIT BUTTON CLICKED", CommonValues.loginModule, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, username, "", "", DeclareVariables.onlyMessage);
				}
				else
				{
					
				}
				
				Thread.sleep(5000);
				Robot r1 = new Robot();
				r1.keyPress(KeyEvent.VK_ESCAPE);
				r1.keyRelease(KeyEvent.VK_ESCAPE);
				DeclareVariables.driver2.manage().window().maximize();
				CreateLogs.writeLogs("ESCAPE KEY PRESSED SUCCESSFULLY!!!");
				
				DeclareVariables.wait2 = new WebDriverWait(DeclareVariables.driver2, 90);
				String docsPageXPath = "//*[text()='ALL DOCUMENTS']//ancestor::span";
				if(DeclareVariables.driver2.findElements(By.xpath(docsPageXPath)).size()>0)
				{
					Thread.sleep(10000);
				}
				else {
					
				}
				
				Thread.sleep(5000);
				if(CommonMethods2.verifyHomePage().trim().equals(CommonValues.applicationName))
				{
					long t12 = new Date().getTime();
					CreateLogs.writeLogs("TIME WHEN APPLICATION LOGGED IN SUCCESSFULLY:- " +t12 +" milliseconds");
					
					long t13 = (t12-t11);
					DeclareVariables.timeTaken = (t13-5000) +" milliseconds";
					
					CommonMethods2.takeSnapShot(DeclareVariables.driver2, "verifyLogin_"+System.currentTimeMillis() +".png");
					DeclareVariables.passResultMessage = "TEST PASSED! USER LOGGED IN SUCCESSFULLY!!!";
					CreateLogs.writeLogs(DeclareVariables.passResultMessage);
					if(displayResult.equals("excel"))
					{
						//Print Result in Excel File
						WriteTestResult.addRowInBasicSheet("login-2", "PASS", DeclareVariables.timeTaken, CommonValues.dateTime, CommonValues.environmentName, CommonValues.subTenantName, CommonValues.loginModule, username, DeclareVariables.passResultMessage);
						WriteTestResult.addRowInDetailsSheet("VERIFY HOME PAGE-2", "HOME PAGE VISIBLE", CommonValues.loginModule, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, username, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
					
						/* 
						 * 
						 * Code for Performance Report
						 *  
						 */
						DeclareVariables.loginCounting = DeclareVariables.loginCounter+1;
//						System.out.println("LOGIN " +DeclareVariables.loginCounting);
						String noOfAction = Integer.toString(DeclareVariables.loginCounting);
						System.out.println(noOfAction);
						loginTime = (double) (t13-5000)/1000;
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
				WriteTestResult.addRowInDetailsSheet("VERIFY SUBMIT BUTTON-2", "SUBMIT BUTTON NOT FOUND", CommonValues.loginModule, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, username, "", "", "SUBMIT BUTTON NOT FOUND");
			}
			  
			Thread.sleep(2000);
			long t21 = new Date().getTime();
			String dashboardVerifyTextPath = "/html/body/div[2]/div/div[2]/div/div[1]/div/div/div/div[5]/div[2]/div/div";			
			if(FunctionLibraries2.isElementPresent(By.xpath(dashboardVerifyTextPath)))
			{
				CreateLogs.writeLogs("SYSTEM IS AT NOTIFICATION WINDOW");
				DeclareVariables.verifyText = FunctionLibraries2.locator("xpath", dashboardVerifyTextPath).getText();										
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
					CommonMethods2.takeSnapShot(DeclareVariables.driver2, "verifyLogin_"+System.currentTimeMillis() +".png");
					DeclareVariables.passResultMessage = "TEST PASSED! USER LOGGED IN SUCCESSFULLY!!!";
					//Print Result in Excel File
					WriteTestResult.addRowInBasicSheet("LOGIN-2", "PASS", DeclareVariables.timeTaken, CommonValues.dateTime, CommonValues.environmentName, CommonValues.subTenantName, CommonValues.loginModule, username, DeclareVariables.passResultMessage);
					WriteTestResult.addRowInDetailsSheet("VERIFY NOTIFICATION-2", "NOTIFICATIONS WINDOW VISIBLE", CommonValues.loginModule, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, username, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
				}
				else
				{
					
				}
			}
			else
			{
				
			}
//			CommonMethods2.closePopUp();
			//Go to INTRANET page
			Thread.sleep(15000);
			CommonMethods2.goToIntranetPage();
		}
		catch(Exception ex)
		{
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "verifyLogin.png");
			CreateLogs.writeLogs(ex.getMessage());
			//Print Result in Excel File
			DeclareVariables.failResultMessage = "TEST FAILED SYSTEM UNABLED TO LOGGED IN. PLEASE CHECK SCREENSHOT IN OUTPUT FOLDER!!!";
			WriteTestResult.addRowInBasicSheet("login-2", "FAIL", "", CommonValues.dateTime, CommonValues.environmentName, CommonValues.subTenantName, CommonValues.loginModule, username, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY LOGIN-2", "SYSTEM UNABLE TO LOGGED IN", CommonValues.loginModule, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, username, "", "", DeclareVariables.failResultMessage);
		}
	}
	
//	@Test(priority = 2, enabled=false)
//	public static void verify_Logout() throws InterruptedException, AWTException 
//	{
//		try {
//			Thread.sleep(5000);
//			FunctionLibraries2.clickButton("xpath", "//*[@title='LOGOUT']", "LOGOUT");
//			//Capture time when Logout button clicked
//			long t1 = new Date().getTime();
//			CreateLogs.writeLogs("Time when 'Logout' button clicked:- " +t1 +" milliseconds");
//			Thread.sleep(40000);
//
//			WebElement loginBtn = FunctionLibraries2.locator("xpath", "//*[contains(text(),'LOGIN')]");
//			if(loginBtn!= null)
//			{
//				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "verify_Logout.png");
//				DeclareVariables.passResultMessage = "TEST PASSED! USER LOGGED OUT SUCCESSFULLY!!!";
//				CreateLogs.writeLogs(DeclareVariables.passResultMessage);
//				//Print Result in Excel File
//				WriteTestResult.addRowInBasicSheet("logout", "PASS", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.loginModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
//				WriteTestResult.addRowInDetailsSheet("VERIFY LOGOUT", "LOGIN PAGE OPEN", CommonValues.loginModule, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.passResultMessage);
//			}
//			else
//			{
//				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "verify_Logout.png");
//				DeclareVariables.failResultMessage = "TEST FAILED! SYSTEM UNABLE TO LOGGED OUT.!!!";
//				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
//				//Print Result in Excel File
//				WriteTestResult.addRowInBasicSheet("logout", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.loginModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
//				WriteTestResult.addRowInDetailsSheet("VERIFY LOGOUT", "LOGIN PAGE NOT FOUND", CommonValues.loginModule, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
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
		CommonMethods2.indicatorStartEnd("END", "LOGIN");
//		DeclareVariables.driver2.close();
//		DeclareVariables.driver2.quit();
	}
}