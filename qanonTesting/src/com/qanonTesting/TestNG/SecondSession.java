package com.qanonTesting.TestNG;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qanonTesting.adminMenu.*;
import com.qanonTesting.login.tests.Login2;
import com.qanonTesting.processMenu.*;
import com.qanonTesting.utilities.*;

public class SecondSession 
{
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try 
		{
//			CreateExcelFile.createWorkbook();
			CommonMethods2.openApplication();
			Login2.verify_Login(CommonValues.txtUsername2, CommonValues.txtPassword2);
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test
	public static void secondSession() throws Exception
	{
		/* 'FEEDS' Page Methods */
		Feeds.navigateTo_FeedsPage();
		Feeds.findRecords_FeedsPage();
		Feeds.uploadFeed_AndVerify();
		Feeds.WithdrawalFeed_AndVerify();

		/* 'TEAMS' Page Methods */
		Teams.navigateTo_TeamsPage();
		Teams.findRecords_TeamsPage();
		Teams.verifyReviseButton_TeamsPage();
		Teams.verifySubmitButton_TeamsPage();
		Teams.verifyEmail_TeamsPage();
		
		/* 'ENTITIES' Page Methods */
		Entities.navigateTo_EntitiesPage();
		Entities.findRecords_EntitiesPage();
		
		/* 'SECURITY TERMS' Page Methods */
		SecurityTerms.navigateTo_SecurityTermsPage();
		SecurityTerms.findRecords_SecurityTermsPage();
		
		/* 'PRODUCTS' Page Methods */
		Products.navigateTo_ProductsPage();
		Products.findRecords_ProductsPage();
		Products.verifyEditAccess_ProductsPage();
		Products.verifyMainSearch_ProductsPage();
	}
	
	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
		CommonMethods2.refreshPage();
		Thread.sleep(3000);
		DeclareVariables.driver2.close();
		DeclareVariables.driver2.quit();
	}
}
