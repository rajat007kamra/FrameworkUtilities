package com.qanonTesting.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeclareVariables 
{	
	public static WebDriver driver1 = null;
	public static WebDriver driver2 = null;
	public static WebDriverWait wait1 = null;
	public static WebDriverWait wait2 = null;
	
	public static String projectPath = System.getProperty("user.dir");
	
	public static WebElement searchPageName = null;
	public static WebElement footerRow = null;
	public static WebElement addNewIcon = null;
	
	public static String verifyText = null;
	public static String footerRowXPath = null;
	public static String footerPageName = null;
	public static String pageCountXPath = null;
	public static String pageCount = null;
	public static String addDetailsXPath = null;
	
	public static String savePopUpMsg = null;
	public static String submitPopUpMsg = null;
	
	public static String onlyMessage = null;
	public static String passResultMessage = null;
	public static String failResultMessage = null;
	
	public static String timeTaken = null;
	
	/* Feeds page variables */
	public static double openFeedTime;
	public static double addFeedRowTime;
	public static double submitFeedTime;
	
	/* Samples page variables */
	public static double openSampleTime;
	
	/* Reports page variables */
	public static double openReportsTime;
	public static double addReportRowTime;
	public static double submitReportsTime;
	public static double saveReportsTime;
	
	/* Docs: Products page variables */
	public static double openDocsProductsTime;
	
	/* Entities page variables */
	public static double openEntityTime;
	
	/* Issuers page variables */
	public static double openIssuersTime;
	
	/* Products and related pages variables */
	public static double addProductEditRowTime;
	public static double openProductsTime;
	
	/* Securities page variables */
	public static double openSecuritiesTime;
	
	/* Security Terms page variables */
	public static double openSecurityTermsTime;
	
	/* Teams page variables */
	public static double openTeamsTime;
	public static double reviseTeamTime;
	public static double submitTeamsTime;
	public static String table1row1column1XPath = null;
	public static String table1row1column1Status = null;
	
	/* Variables for calculate performance */
	public static int loginCounter = 0;
	public static int loginCounting;
	
	public static int openScreenCount = 0;
	public static int openScreenCounting;
	
	public static int addRowCount = 0;
	public static int addRowCounting;
	
	public static int saveBtnCount = 0;
	public static int saveBtnCounting;
	
	public static int submitBtnCount = 0;
	public static int submitBtnCounting;
	
	public static int reviseBtnCount = 0;
	public static int reviseBtnCounting;
	
	/* Variables used for finding Percentile*/
	public static String percentile90 = null;
	public static String percentile95 = null;
}

	/*
	 * ZOOM Code
	 */
//		String zoomOutJS = "document.body.style.zoom='75%'";
//		JavascriptExecutor jso = (JavascriptExecutor) DeclareVariables.driver;
//		jso.executeScript(zoomOutJS);

	/*
	 * For Information/Guidance
	 */
//	LOGIN - login page
//	OPEN SCREEN - Feeds, Teams, Entities, Products, SecurityTerms, Samples, Reports, Issuers, DocsProducts, SecurityTerms
//	REVISE - teams
//	ADD ROW - product_edit, reports, feeds
//	SAVE - reports, feeds
//	SUBMIT - teams, reports, feed
