package com.qanonTesting.TestNG;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qanonTesting.adminMenu.*;
import com.qanonTesting.analyticsMenu.*;
import com.qanonTesting.docsMenu.DocsProducts;
import com.qanonTesting.login.tests.*;
import com.qanonTesting.processMenu.*;
import com.qanonTesting.utilities.*;

public class FirstSession 
{
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try 
		{
//			CreateExcelFile.createWorkbook();
//			Thread.sleep(400000);
			CommonMethods1.openApplication();
			Login1.verify_Login(CommonValues.txtUsername1, CommonValues.txtPassword1);
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test
	public static void firstSession() throws Exception
	{
		Thread.sleep(5000);
		/* 'SAMPLES' Page Methods */
		Samples.navigateTo_SamplesPage();
		Samples.findRecords_SamplesPage();
		
		/* 'DOCS PRODUCTS' Page Methods */
		DocsProducts.navigateTo_DocsProductsPage();
		DocsProducts.findRecords_DocsProductsPage();
		
		/* 'SECURITIES' Page Methods */
		Securities.navigateTo_SecuritiesPage();
		Securities.findRecords_SecuritiesPage();
		
		/* 'REPORTS' Page Methods */
		Reports.navigateTo_ReportsPage();
		Reports.findRecords_ReportsPage();
		Reports.generateReport_ReportsPage();
		
		/* 'ISSUERS' Page Methods */
		Issuers.navigateTo_IssuersPage();
		Issuers.findRecords_IssuersPage();
//
//		/* 'DOCS PRODUCTS' Page Methods */
//		DocsProducts.navigateTo_DocsProductsPage();
//		DocsProducts.findRecords_DocsProductsPage();
	}
	
	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
		CommonMethods1.refreshPage();
		Thread.sleep(5000);
		DeclareVariables.driver1.close();
		DeclareVariables.driver1.quit();
	}
}
