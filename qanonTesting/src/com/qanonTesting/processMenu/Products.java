package com.qanonTesting.processMenu;

import java.awt.AWTException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Products 
{
	public static long t1, t2;
	
	@BeforeClass
	public static void setup() throws InterruptedException, AWTException
	{
		try 
		{
			CreateExcelFile.createWorkbook();
			CommonMethods2.indicatorStartEnd("START", "PRODUCTS-PROCESSES");
			Login2.verify_Login(CommonValues.txtUsername2, CommonValues.txtPassword2);
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 1)
	public static void navigateTo_ProductsPage() throws Exception
	{
		try 
		{
			CommonMethods2.indicatorStartEnd("START", "PRODUCTS-PROCESSES");
//			Thread.sleep(5000);
			//Searching page and navigating to it
//			CommonMethods2.searchPage("PRODUCTS", "", "PRODUCTS PAGE SEARCHED");
			CommonMethods2.searchPageNew("PRODUCTS", CommonValues.processesModule, "", "PRODUCTS PAGE SEARCHED");
			CommonMethods2.closeExistingTab(CommonValues.processesModule);
			CommonMethods2.resetPage(CommonValues.processesModule);
			CommonMethods2.closeExistingTab(CommonValues.processesModule);
			
			//Capture time when Securities page clicked
			long t1 = new Date().getTime();
			CreateLogs.writeLogs("TIME WHEN HIT ENTER TO NAVIGATE ON 'PRODUCTS' PAGE:- " +t1 +" milliseconds");
					
			DeclareVariables.wait2 = new WebDriverWait(DeclareVariables.driver2, 90);
			DeclareVariables.footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']//*[text()='PRODUCTS']//ancestor::span";
			
			if(FunctionLibraries2.isElementPresent(By.xpath(DeclareVariables.footerRowXPath)))
			{
				DeclareVariables.footerRow = DeclareVariables.wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DeclareVariables.footerRowXPath))); 
				DeclareVariables.footerPageName = DeclareVariables.footerRow.getText();
				
				Assert.assertEquals("PRODUCTS", DeclareVariables.footerPageName);
				//Capture time when Securities page opened and verified
				long t2 = new Date().getTime();
				CreateLogs.writeLogs("TIME WHEN 'PRODUCTS' PAGE OPENED AND VERIFIED:- " +t2 +" milliseconds");
//				CreateLogs.writeLogs("SYSTEM IS AT 'PRODUCTS' PAGE!!!");
				
				long t3 = (t2-t1);
				DeclareVariables.timeTaken = t3 +" milliseconds";
				
				//Actual time to open Securities page
				CreateLogs.writeLogs("ACTUAL TIME TAKEN BY SYSTEM IN OPENING OF 'PRODUCTS' PAGE:- " +DeclareVariables.timeTaken);
			
				//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_ProductsPage_"+System.currentTimeMillis() +".png");
				
				//Print Result in Excel File
				DeclareVariables.passResultMessage = "SYSTEM IS AT 'PRODUCTS' PAGE!!!";
				WriteTestResult.addRowInBasicSheet("navigateTo_ProductsPage", "PASS", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY PRODUCTS SCREEN", "PRODUCTS SCREEN OPEN", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
			
				/* 
				 * 
				 * Code for Performance Report
				 *  
				 */
				DeclareVariables.openScreenCounting = DeclareVariables.openScreenCounting+1;
//				System.out.println("OPEN SCREEN" +DeclareVariables.openScreenCounting);
				String noOfAction = Integer.toString(DeclareVariables.openScreenCounting);
				System.out.println(noOfAction);
				DeclareVariables.openProductsTime = (double) (t2-t1)/1000;
				if(DeclareVariables.openProductsTime <0)
				{
					DeclareVariables.openProductsTime = 0.00;
				}
				else
				{
					
				}
			}
			else
			{
				//Call take screenshot function
				CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_ProductsPage_"+System.currentTimeMillis() +".png");
				DeclareVariables.failResultMessage = "'PRODUCTS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
				CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Print Result in Excel File
				WriteTestResult.addRowInBasicSheet("navigateTo_ProductsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
				WriteTestResult.addRowInDetailsSheet("VERIFY PRODUCTS SCREEN", "PRODUCTS SCREEN NOT FOUND", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
//				Assert.fail(DeclareVariables.failResultMessage);				
			}
		}
		catch(Exception ex)
		{
			//Call take screenshot function
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_ProductsPage_"+System.currentTimeMillis() +".png");
			DeclareVariables.failResultMessage = "'PRODUCTS' PAGE NOT FOUND OR PAGE NAME NOT MATCHED!!!";
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("navigateTo_ProductsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY PRODUCTS SCREEN", "PRODUCTS SCREEN NOT FOUND", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
//			Assert.fail(DeclareVariables.failResultMessage);
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 2)
	public static void findRecords_ProductsPage() throws Exception
	{
		try
		{
			Thread.sleep(1500);
            String footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']//div[@class='VZ-WGT-BDY-DECK']//div[@class='GRID-WGT vert-flex-cnt']//div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']//div[@class='GRIDWGT-INNER']//div[@class='GRID-WGT-TOTALS-OUTER']//div[@class='GRID-TOTALS-WGT']//div[@class='GRID-MSG-WGT']//div[@class='GRID-MSG-WGT-ITEMS-OUTER']//div//div[@class='gwt-Label']";
            List<WebElement> valueF= DeclareVariables.driver2.findElements(By.xpath(footerRowXPath));
            for(int i=0;i<valueF.size();i++){
            	DeclareVariables.pageCount = valueF.get(i).getText();
            	CreateLogs.writeLogs("RECORDS COUNT OF 'PRODUCTS' PAGE ::- " +DeclareVariables.pageCount);
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
	    		CreateLogs.writeLogs("ACTUAL NUMBER OF RECORDS DISPLAYING IN 'PRODUCTS' PAGE ::- " +rowCount);
	    		CommonMethods2.closePopUp();
	    		//Call take screenshot function
		        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_ProductsPage_"+System.currentTimeMillis() +".png");
		    	//Print Result in Excel File
	    		DeclareVariables.passResultMessage = rowCount +" - RECORDS FOUND IN 'PRODUCTS' PAGE!!!";
	    		WriteTestResult.addRowInBasicSheet("findRecords_ProductsPage", "PASS", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
	    		WriteTestResult.addRowInDetailsSheet("PRODUCTS RECORDS", "FIND RECORDS - " +rowCount, "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.passResultMessage);
	    	}
	    	else
			{
	    		//Call take screenshot function
		        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_ProductsPage_"+System.currentTimeMillis() +".png");
		        CreateLogs.writeLogs(DeclareVariables.failResultMessage);
				//Print Result in Excel File
	    		DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'PRODUCTS' PAGE OR ELEMENT LOCATOR NOT MATCHED!!!";
	    		WriteTestResult.addRowInBasicSheet("findRecords_ProductsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);				
	    		WriteTestResult.addRowInDetailsSheet("PRODUCTS RECORDS", "RECORD COUNT NOT FOUND", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);		
			}
		}
		catch(Exception ex)
		{
			//Call take screenshot function
	        CommonMethods2.takeSnapShot(DeclareVariables.driver2, "findRecords_ProductsPage_"+System.currentTimeMillis() +".png");
	        DeclareVariables.failResultMessage = "RECORDS COUNT NOT FOUND ON 'PRODUCTS' PAGE OR ELEMENT LOCATOR NOT MATCHED!!!";
	        CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File
    		WriteTestResult.addRowInBasicSheet("findRecords_ProductsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);				
    		WriteTestResult.addRowInDetailsSheet("PRODUCTS RECORDS", "RECORD COUNT NOT FOUND", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
    		CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	@Test(priority = 3)
	public static void verifyEditAccess_ProductsPage()throws Exception
	{
		DeclareVariables.driver2.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
		String Product_VZone_Xpath = "//div[@class='VZ-TAB-DSPLY VZ-TAB-DSPLY-PRIZE'][contains(text(),'PRODUCTS')]";
		if(FunctionLibraries2.isElementPresent(By.xpath(Product_VZone_Xpath)))
		{
			CreateLogs.writeLogs("SYSTEM IS AT PRODUCTS PAGE!!!");
			WriteTestResult.addRowInDetailsSheet("EDIT PRODUCTS", "SELECT PRODUCTS TAB", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "PRODUCTS TAB SUCCESSFULLY SELECTED");
		}
		else
		{
			CreateLogs.writeLogs("EITHER PRODUCTS PAGE NOT FOUND OR LOCATOR NOT FOUND. REFER SCREENSHOT!!!");
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "ProductsPage_Records_"+System.currentTimeMillis() +".png");
		}
		
//		Thread.sleep(3000);
		String Plus_Button_Xpath = "//*[@title='ADD NEW PRODUCT']";
		WebElement plusBtn = FunctionLibraries2.locator("xpath", Plus_Button_Xpath);
		if(plusBtn!= null)
		{
			FunctionLibraries2.clickButton("xpath", Plus_Button_Xpath, "'+' ADD NEW PRODUCT");
			long t1 = new Date().getTime();
			
			String saveXPath = "//div[@class='PRIZE-C2 C2 HAS-TRANS-300']//div[@class='WORKBAR-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow WORKBAR-WGT-TRG-SAVE']//div[@class='WORKBAR-WGT-TRG-ICON mz-icons']";
			boolean saveBtn= FunctionLibraries2.locator("xpath", saveXPath).isEnabled();
			if(saveBtn==true)
			{
//				System.out.print(saveBtn);
				long t2 = new Date().getTime();
				DeclareVariables.timeTaken = (t2-t1) + " milliseconds";
				DeclareVariables.onlyMessage = "NEW ROW ADDED SUCCESSFULLY AFTER 'ADD NEW PRODUCT' ICON CLICKED!!!";
				WriteTestResult.addRowInDetailsSheet("EDIT PRODUCTS", "ADD ROW", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.onlyMessage);
			
				/* 
				 * 
				 * Code for Performance Report
				 *  
				 */
				DeclareVariables.addRowCounting = DeclareVariables.addRowCounting+1;
//				System.out.println("ADD ROW " +DeclareVariables.addRowCounting);
				String noOfAction = Integer.toString(DeclareVariables.addRowCounting);
				System.out.println(noOfAction);
				DeclareVariables.addProductEditRowTime = (double) (t2-t1)/1000;
			}
			else
			{
				
			}
		}
		else
		{
			WriteTestResult.addRowInDetailsSheet("EDIT PRODUCTS", "ADD ICON", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "ADD ICON NOT FOUND");
		}
		
		Thread.sleep(3000);
		String New_Form_Xpath="//div[@class='STND-PAD-HDR-MAIN STND-PAD-HDR-MAIN-BTM-BOR rel-pos']";
		if(FunctionLibraries2.isElementPresent(By.xpath(New_Form_Xpath)))
		{
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "validateEditAccess_ProductsPage_"+System.currentTimeMillis() +".png");
			DeclareVariables.passResultMessage = "USER HAS EDIT ACCESS AND TEST PASSED!!!";
			CreateLogs.writeLogs(DeclareVariables.passResultMessage);
			WriteTestResult.addRowInBasicSheet("verifyEditAccess_ProductsPage", "PASS", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
			WriteTestResult.addRowInDetailsSheet("EDIT PRODUCTS", "NEW FORM", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.passResultMessage);
		}		
		else
		{
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "validateEditAccess_ProductsPage_"+System.currentTimeMillis() +".png");
			DeclareVariables.failResultMessage = "USER SHOULD HAVE EDIT ACCESS AND TEST FAILED!!!";
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			WriteTestResult.addRowInBasicSheet("verifyEditAccess_ProductsPage", "FAIL", "", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("EDIT PRODUCTS", "NEW FORM", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", DeclareVariables.failResultMessage);
		}
		FunctionLibraries2.clickButton("xpath", "//div[@class='HOR-FLEX-EL FLY-CLOSE-TRG FLY-TOP-TRG material-icons TRG-BASE trg-base'][@title='CLOSE']", "CLOSE");
	}
	
	@Test(priority=4)
	public static void verifyMainSearch_ProductsPage() throws Exception
	{
		CommonMethods2.resetPage(CommonValues.processesModule);
		Thread.sleep(5000);
		String Product_State_Xpath = "//body/div[@class='ROOT-PANEL']/div[@class='CONTENTDECK']/div[@class='DECKLAYER-PARENT']/div[@class='REALM REALM-PRIZE']/div[@class='REALM-BDY REALM-BDY-PRIZE']/div[@class='REALM-BDY-CNT REALM-BDY-EL REALM-BDY-CNT-PRIZE HAS-TRANS-300']/div[@class='PRIZE-B3 B3']/div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']/div[@class='VZ-WGT-BDY-DECK']/div[@class='GRID-WGT vert-flex-cnt']/div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']/div[@class='GRIDWGT-INNER']/div[@class='GRID-WGT-HEAD-OUTER']/div[@class='GRID-WGT-HEAD-INNER']/div[@class='GRID-WGT-HDRS-OUTER']/table[@class='GRID-WGT-HDRS']/tbody/tr/td[1]/div[1]/input[1]";
		WebElement productState = FunctionLibraries2.locator("xpath", Product_State_Xpath);
		if(productState!= null)
		{
			FunctionLibraries2.locator("xpath", Product_State_Xpath).clear();
//			Thread.sleep(2000);
			FunctionLibraries2.locator("xpath", Product_State_Xpath).sendKeys(CommonValues.productsSearchStatusValue);
			Thread.sleep(2000);
			FunctionLibraries2.locator("xpath", Product_State_Xpath).sendKeys(Keys.ENTER);
			WriteTestResult.addRowInDetailsSheet("SEARCH PRODUCTS", "SELECT STATE FIELD - ACTIVE", CommonValues.productsSearchStatusValue, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "STATE FIELD VALUE SELECTED SUCCESSFULLY");
		}
		else
		{
			WriteTestResult.addRowInDetailsSheet("SEARCH PRODUCTS", "SELECT STATE FIELD - ACTIVE", CommonValues.productsSearchStatusValue, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "STATE FIELD NOT FOUND");
		}
		
		Thread.sleep(2000);
		//Finding first value from given list on page for Global search 
		List<WebElement> listOfElements = DeclareVariables.driver2.findElements(By.xpath("//tr[@class='GRID-WGT-ROW GRID-WGT-ROW-DFLT GRID-WGT-ROW-ACTIVE']//td[2]"));
//		System.out.println(listOfElements.get(0).getText());
		String Value = listOfElements.get(0).getText();
		
		String zoomInJS = "document.body.style.zoom='90%'";
		JavascriptExecutor js = (JavascriptExecutor) DeclareVariables.driver2;  
		js.executeScript(zoomInJS);
		Thread.sleep(4000);
		
		//Enter value in Global Search Textbox and press enter
		WebElement globalSearchBox = FunctionLibraries2.locator("xpath", "//div[@class='REALM REALM-PRIZE']//div[@class='REALM-HD-CNT REALM-HD-EL REALM-HD-CNT-PRIZE']//div[@class='PRIZE-B1 B1']//input[@class='SRCH-WGT-ENTRYFLD SRCH-WGT-ENTRYFLD-top-cptn']");
		if(globalSearchBox!= null)
		{
			globalSearchBox.click();	Thread.sleep(2000);
			globalSearchBox.clear();	Thread.sleep(2000);
			globalSearchBox.sendKeys(Value.trim());		Thread.sleep(2000);
//			System.out.println(Value.trim());
			globalSearchBox.sendKeys(Keys.TAB);
			t1 = new Date().getTime();
			WriteTestResult.addRowInDetailsSheet("SEARCH PRODUCTS", "GLOBAL SEARCH CLICKED", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "CURSOR IS IN GLOBAL SEARCH TEXTBOX");
		}
		else
		{
			WriteTestResult.addRowInDetailsSheet("SEARCH PRODUCTS", "GLOBAL SEARCH CLICKED", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", "", "GLOBAL SEARCH TEXTBOX NOT FOUND");
		}
		
		Thread.sleep(3000);
		String Matched_Product = DeclareVariables.driver2.findElement(By.xpath("//div[@class='REALM REALM-PRIZE']//div[@class='GRID-WGT-BODY-OUTER']//div[@class='GRID-WGT-TBLS']//table//tr[1]//td[2]//div")).getText();
//		System.out.println(Matched_Product);
		if(Matched_Product.trim().contains(Value.trim()))
		{
			t2 = new Date().getTime();
			DeclareVariables.timeTaken = (t2-t1) + " milliseconds";
			//Call take screenshot function
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "SEARCH_MAIN_PASSED_"+System.currentTimeMillis() +".png");			
			DeclareVariables.passResultMessage = "TEST PASSED! GLOBAL SEARCH OF PRODUCT IS SUCCESSFUL!!!";
			CreateLogs.writeLogs(DeclareVariables.passResultMessage);
			CreateLogs.writeLogs("Value Found ::- " +Value);
			CreateLogs.writeLogs("Value Matched ::- " +Matched_Product);
			WriteTestResult.addRowInBasicSheet("verifyMainSearch_ProductsPage", "PASS", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.passResultMessage);
			WriteTestResult.addRowInDetailsSheet("SEARCH PRODUCTS", "GLOBAL SEARCH", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
		}
		else
		{
			//Call take screenshot function
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "SEARCH_MAIN_FAILED_"+System.currentTimeMillis() +".png");
			DeclareVariables.failResultMessage = "TEST FAILED! AS GLOBAL SEARCH OF PRODUCT IS NOT SUCCESSFUL!!!";
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			CreateLogs.writeLogs("Value Found ::- " +Value);
			CreateLogs.writeLogs("Value Matched ::- " +Matched_Product);
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("verifyMainSearch_ProductsPage", "FAIL", DeclareVariables.timeTaken, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.subTenantName, CommonValues.processesModule, CommonValues.txtUsername2, DeclareVariables.failResultMessage);			
			WriteTestResult.addRowInDetailsSheet("SEARCH PRODUCTS", "GLOBAL SEARCH", "PRODUCTS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, CommonValues.txtUsername2, "", DeclareVariables.timeTaken, DeclareVariables.failResultMessage);
//			Assert.fail(DeclareVariables.failResultMessage);
		}	
		CommonMethods2.indicatorStartEnd("END", "PRODUCTS-PROCESSES");
	}
	
	@AfterClass
	public static void closeApplication() throws InterruptedException
	{
		CommonMethods2.refreshPage();
		Thread.sleep(2000);
		CommonMethods2.indicatorStartEnd("END", "PRODUCTS-PROCESSES");
		DeclareVariables.driver2.close();
		DeclareVariables.driver2.quit();
	}
}