package com.qanonTesting.utilities;

public class CommonValues 
{
	/* 
	 * Application Values
	 */
	public static String folderName = "qanonTesting";
	public static String applicationName = "ASSET MANAGEMENT";
	public static String appUrl = "https://qanon-b.mezocliq.com/mezocliq/looqs.html";
	
	/*
	 * All Files Paths
	 */
	
	/* INPUT Folders Path */
	//Chrome driver file path
	public static String chromeDriverPath = "C:\\Users\\Public\\" +CommonValues.folderName+ "\\Inputs\\drivers\\chromedriver.exe";
	//testng.xml file path
	public static String testngFile = "C:\\Users\\Public\\" +CommonValues.folderName+ "\\Inputs\\xmls\\testng.xml";
	//FEED File path
	public static String feedFilePath = "C:\\Users\\Public\\" +CommonValues.folderName+ "\\Inputs\\feeds_Files\\EmployeeWorkday_QANON-B65_062519.csv";
	//User Credentials file path
	public static String loginFile = "C:\\Users\\Public\\" +CommonValues.folderName+ "\\login_details\\datafile.properties";
		
	/* OUTPUT Folders Path */
	//Log File Path
	public static String logFileName = "C:\\Users\\Public\\" +CommonValues.folderName+ "\\Outputs\\logFiles\\logs.txt";
	//Test Results folder path
	public static String testResultFilePath = "C:\\Users\\Public\\" +CommonValues.folderName+ "\\Outputs\\reports\\";
	//Errors Screens Folder Path
	public static String errorImageFilePath = "C:\\Users\\Public\\" +CommonValues.folderName+ "\\Outputs\\errorScreens\\";
	//Test Result Excel Sheet path
	public static String resultFilePath ="C:\\Users\\Public\\" +CommonValues.folderName+ "\\Outputs\\reports\\TestResultFormat.xlsx";
	
	/* 
	 * Values used in Feeds Class 
	 */	
	public static String txtUsername1 = ReadProperties.readInput("userName1");
	public static String txtPassword1 = ReadProperties.readInput("password1");
	
	public static String txtUsername2 = ReadProperties.readInput("userName2");
	public static String txtPassword2 = ReadProperties.readInput("password2");
	
	/* 
	 * Menu/Modules Name
	 */
	public static String loginModule = "LOGIN";
	public static String intranetModule = "INTRANET";
	public static String docsModule = "DOCS";
	public static String adminModule = "ADMIN";
	public static String processesModule = "PROCESSES";
	public static String analyticsModule = "ANALYTICS";
	
	//Result related variables
	public static String dateTime = CommonMethods1.GetCurrentTimeStamp();
	public static String environmentName = "QANON";
	public static String tenantName = "MEZOCLIQ";
	public static String subTenantName = "ASSET MANAGEMENT";	
	
	/* 
	 * Values used in Feeds Class 
	 */
	
	//Used in WithdrawalFeed_AndVerify() Method in Feeds Class
	public static String searchFeedsStatusValue = "COMPLETED";
	public static String searchFeedFileNameValue = "EmployeeWorkday_QANON-B65_062519.csv";
	
	//Used in uploadFeed_AndVerify() Method in Feeds Class
	public static String feedInterfaceTypeValue = "INTEGRATION";
	public static String feedDelimitedFieldValue = "DELIMITED";
	public static String feedDirectionFieldValue = "INBOUND";
	
	public static String feedProcessFieldValue = "EMPLOYEE";
	public static String feedSystemFieldValue = "HR";
	public static String feedAnteMappingField = "EMP TEST 105 EMPLOYEE COMPLETED";
	
	/* 
	 * Values used in Reports Class 
	 */
	
	//Used in generateReport_ReportsPage() Method in Reports Class
	public static String reportsTemplateName = "PRODUCT TEST";
	
	/* 
	 * Values used in Products Class 
	 */
	
	//Used in verifyMainSearch_ProductsPage() Method in Products_Global_Search Class
	public static String productsSearchStatusValue = "ACTIVE";
	
	/* 
	 * Values used in Teams Class 
	 */
	public static String teamsSearchStateValue1 = "ACTIVE";
	public static String teamsSearchStateValue2 = "REVISING";
	public static String teamsSearchTeamValue = "CUSTODY POSTION RECONCILIATION";
	public static String toEmailId = ReadProperties.readInput("email_Id");
	public static String mailBodyMsg = ReadProperties.readInput("body_Message");
}
