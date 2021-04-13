package com.qanonTesting.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qanonTesting.login.tests.Login2;

public class CommonMethods2 
{	
	public static double saveFeedTime;
	//Method for @BeforeClass given in all pages
	public static void beforeClassTests() throws Exception
	{
		try {
			CommonMethods2.openApplication();
			Login2.verifyLogin("notExcel", "", "");
		} catch (InterruptedException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Method for Login Application
	public static void openApplication() throws InterruptedException, AWTException
	{
		FunctionLibraries2.logCreation();
		FunctionLibraries2.openBrowser("chrome");
		FunctionLibraries2.openUrl(CommonValues.appUrl);
	}
		
	//Method to display messages for Page start and end 
	public static void indicatorStartEnd(String indicator, String pageName)
	{
		if(indicator=="START")
		{
			CreateLogs.writeLogs("**********************************************************************");
			CreateLogs.writeLogs("                 " +pageName+" PAGE TEST START                        ");
			CreateLogs.writeLogs("**********************************************************************");
		}
		else
		{
			CreateLogs.writeLogs("**********************************************************************");
			CreateLogs.writeLogs("                 " +pageName+" PAGE TEST END                          ");
			CreateLogs.writeLogs("**********************************************************************");
		}
	}	
	
	//Go to INTRANET Menu
	public static void goToIntranetPage()
	{
		String intranetXPath = "//div[@class='A2 DOQZ-A2 HAS-TRANS-400']//div[@class='REALM-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow REALM-WGT-TRG-FOLIOS-ICO'][@title='INTRANET']";
		String adminIntranetXPath = "//div[@class='A2 QONCIERGE-A2 HAS-TRANS-400']//div[@class='REALM-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow REALM-WGT-TRG-FOLIOS-ICO'][@title='INTRANET']";
		String processIntranetXPath = "//div[@class='A2 PRIZE-A2 HAS-TRANS-400']//div[@class='REALM-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow REALM-WGT-TRG-FOLIOS-ICO'][@title='INTRANET']";
		String analyticIntranetXPath = "//div[@class='A2 WIZ-A2 HAS-TRANS-300']//div[@class='REALM-WGT-TRG realm-dominant-bg realm-dominant-clr TRG-BASE trg-base waves-effect waves-yellow REALM-WGT-TRG-FOLIOS-ICO'][@title='INTRANET']";
		
		if(FunctionLibraries2.isElementPresent(By.xpath(intranetXPath)))
		{
			FunctionLibraries2.locator("xpath", intranetXPath).click();
		}
		else if(FunctionLibraries2.isElementPresent(By.xpath(adminIntranetXPath)))
		{
			FunctionLibraries2.locator("xpath", adminIntranetXPath).click();
		}
		else if(FunctionLibraries2.isElementPresent(By.xpath(processIntranetXPath)))
		{
			FunctionLibraries2.locator("xpath", processIntranetXPath).click();
		}
		else if(FunctionLibraries2.isElementPresent(By.xpath(analyticIntranetXPath)))
		{
			FunctionLibraries2.locator("xpath", analyticIntranetXPath).click();
		}
		else
		{
			
		}
	}
	
	//Method to close existing Tab
	public static void closeExistingTab(String moduleName)
	{
		try 
		{
			String docsCloseXTab = "//div[@class='REALM-BDY-CNT REALM-BDY-EL REALM-BDY-CNT-DOQZ HAS-TRANS-300 REALM-BDY-CNT-RGT-EJECTED']//div[@class='VZ-TAB VZ-TAB-DOQZ realm-dominant-clr realm-dominant-bg']//div[@class='VZ-TAB-CLOSE material-icons TRG-BASE trg-base'][@title='CLOSE TAB']";
			String adminCloseXTab = "//div[@class='REALM-BDY-CNT REALM-BDY-EL REALM-BDY-CNT-QONCIERGE HAS-TRANS-300']//div[@class='VZ-TAB VZ-TAB-QONCIERGE realm-dominant-clr realm-dominant-bg']//div[@class='VZ-TAB-CLOSE material-icons TRG-BASE trg-base'][@title='CLOSE TAB']";
			String processCloseXTab = "//div[@class='REALM-BDY-CNT REALM-BDY-EL REALM-BDY-CNT-PRIZE HAS-TRANS-300']//div[@class='VZ-TAB VZ-TAB-PRIZE realm-dominant-clr realm-dominant-bg']//div[@class='VZ-TAB-CLOSE material-icons TRG-BASE trg-base'][@title='CLOSE TAB']";
			String analyticCloseXTab = "//div[@class='REALM-BDY-CNT REALM-BDY-EL REALM-BDY-CNT-WIZ HAS-TRANS-300']//div[@class='VZ-TAB VZ-TAB-WIZ realm-dominant-clr realm-dominant-bg']//div[@class='VZ-TAB-CLOSE material-icons TRG-BASE trg-base'][@title='CLOSE TAB']";
					
			Thread.sleep(3000);
			if(moduleName.equals(CommonValues.docsModule))
			{
				if(FunctionLibraries2.isElementPresent(By.xpath(docsCloseXTab)))
				{
					DeclareVariables.driver2.findElement(By.xpath(docsCloseXTab)).click();
				}
				else {
					
				}
			}
			else if(moduleName.equals(CommonValues.adminModule))
			{
				if(FunctionLibraries2.isElementPresent(By.xpath(adminCloseXTab)))
				{
					DeclareVariables.driver2.findElement(By.xpath(adminCloseXTab)).click();
				}
				else {
					
				}
			}
			else if(moduleName.equals(CommonValues.processesModule))
			{
				if(FunctionLibraries2.isElementPresent(By.xpath(processCloseXTab)))
				{
					DeclareVariables.driver2.findElement(By.xpath(processCloseXTab)).click();
				}
				else {
					
				}
			}
			else if(moduleName.equals(CommonValues.analyticsModule))
			{
				if(FunctionLibraries2.isElementPresent(By.xpath(analyticCloseXTab)))
				{
					DeclareVariables.driver2.findElement(By.xpath(analyticCloseXTab)).click();
				}
				else {
					
				}
			}
			else
			{
				//Write some code here
			}			
			Thread.sleep(1500);
		}
		catch (Exception e) {
			// TODO: handle exception
			CreateLogs.writeLogs(e.getMessage());
		}
	}
	
	//Method to Reset the page
	public static void resetPage(String moduleName) throws InterruptedException
	{
		Thread.sleep(2000);
		String resetPagePath = "//div[@class='reset-trg TRG-BASE trg-base hor-flex-el realm-dominant-bg realm-dominant-clr lft-aux-trg']//div[@class='REALM-WGT-TRG-ICON material-icons'][contains(text(),'grid_off')]";
		String resetAdminPages = "//div[@class='A3 QONCIERGE-A3 HAS-TRANS-400 OVFLW-HDN']//div[@class='REALM-WGT-TRG-ICON material-icons'][contains(text(),'grid_off')]";
		String resetProcessPages = "//div[@class='A3 PRIZE-A3 HAS-TRANS-400 OVFLW-HDN']//div[@class='REALM-WGT-TRG-ICON material-icons'][contains(text(),'grid_off')]";
		String resetAnalyticsPages = "//div[@class='A3 WIZ-A3 HAS-TRANS-400 OVFLW-HDN']//div[@class='REALM-WGT-TRG-ICON material-icons'][contains(text(),'grid_off')]";
		
		if(moduleName.equals(CommonValues.adminModule))
		{
			FunctionLibraries2.locator("xpath", resetAdminPages).click();
//			Thread.sleep(2000);
			String Yes_Button_Xpath = "//div[@class='CONFIRMATION-CNT DOMINANT-BG-PRIZE CONFIRMATION-CNT-BLOCK']//div[@class='CONFIRMATION-BTN CONFIRMATION-BTN-YES']//div[@class='gwt-Label'][contains(text(),'YES')]";
			FunctionLibraries2.locator("xpath", Yes_Button_Xpath).click();
			Thread.sleep(2000);
		}
		else if(moduleName.equals(CommonValues.processesModule))
		{
			FunctionLibraries2.locator("xpath", resetProcessPages).click();
			Thread.sleep(2000);
			String Yes_Button_Xpath = "//div[@class='CONFIRMATION-CNT DOMINANT-BG-PRIZE CONFIRMATION-CNT-BLOCK']//div[@class='CONFIRMATION-BTN CONFIRMATION-BTN-YES']//div[@class='gwt-Label'][contains(text(),'YES')]";
			FunctionLibraries2.locator("xpath", Yes_Button_Xpath).click();
			Thread.sleep(2000);
		}
		else if(moduleName.equals(CommonValues.analyticsModule))
		{
			FunctionLibraries2.locator("xpath", resetAnalyticsPages).click();
//			Thread.sleep(2000);
			String Yes_Button_Xpath = "//div[@class='CONFIRMATION-CNT DOMINANT-BG-PRIZE CONFIRMATION-CNT-BLOCK']//div[@class='CONFIRMATION-BTN CONFIRMATION-BTN-YES']//div[@class='gwt-Label'][contains(text(),'YES')]";
			FunctionLibraries2.locator("xpath", Yes_Button_Xpath).click();
			Thread.sleep(2000);
		}
		else
		{
			FunctionLibraries2.locator("xpath", resetPagePath).click();
//			Thread.sleep(2000);
			String Yes_Button_Xpath = "//div[contains(text(),'YES')]";
			FunctionLibraries2.locator("xpath", Yes_Button_Xpath).click();
			Thread.sleep(2000);
		}
		closePopUp();
	}
	
	//Method to Search page in application
	public static void searchPage(String pageName, String time, String message) throws InterruptedException
	{
		try
		{
			CommonMethods2.closePopUp();	//Close pop up if exists/opened
			//Searching Page by its name
			DeclareVariables.searchPageName = FunctionLibraries2.locator("xpath", "//div[@class='FOLIOS-A4 A4 HAS-TRANS-400 OVFLW-HDN']//input[@placeholder='NAVIGATE']");
			DeclareVariables.searchPageName.clear();	Thread.sleep(2000);
			DeclareVariables.searchPageName.sendKeys(pageName);	Thread.sleep(2000);
			DeclareVariables.searchPageName.sendKeys(Keys.ENTER);
			WriteTestResult.addRowInDetailsSheet(pageName +" SCREEN", "ENTER SCREEN", pageName, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, ReadLoginDetails.user_name1(), "", time, message);
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	//Method to close existing open Tab and Notification window if exists
	public static void closeTabAndNotification(String moduleName)
	{
		CommonMethods2.closeExistingTab(moduleName);	//Close existing opened Tab if exists
		CommonMethods2.closePopUp();	//Close pop up if exists/opened
	}
	
	//Method to search Admin, Process, Analytics pages in application
	public static void searchPageNew(String pageName, String moduleName, String responsetime, String message) throws InterruptedException
	{
		try
		{
			CommonMethods2.closePopUp();	//Close pop up if exists/opened
			Thread.sleep(2000);			
			String inranetSearch = "//div[@class='FOLIOS-A4 A4 HAS-TRANS-400 OVFLW-HDN']//input[@placeholder='NAVIGATE']";
			String docsSearch = "//div[@class='DOQZ-A4 A4 HAS-TRANS-400 OVFLW-HDN']//input[@placeholder='NAVIGATE']";
			String adminSearch = "//div[@class='QONCIERGE-A4 A4 HAS-TRANS-400 OVFLW-HDN']//input[@placeholder='NAVIGATE']";
			String processSearch = "//div[@class='PRIZE-A4 A4 HAS-TRANS-400 OVFLW-HDN']//input[@placeholder='NAVIGATE']";
			String analyticSearch = "//div[@class='WIZ-A4 A4 HAS-TRANS-400 OVFLW-HDN']//input[@placeholder='NAVIGATE']";
			
			if(moduleName.equals(CommonValues.intranetModule))
			{
				verifyIsPageExists(inranetSearch, pageName, moduleName);
			}
			else if(moduleName.equals(CommonValues.docsModule))
			{
				verifyIsPageExists(docsSearch, pageName, moduleName);
			}
			else if(moduleName.equals(CommonValues.adminModule))
			{
				verifyIsPageExists(adminSearch, pageName, moduleName);
			}
			else if(moduleName.equals(CommonValues.processesModule))
			{
				verifyIsPageExists(processSearch, pageName, moduleName);
			}
			else if(moduleName.equals(CommonValues.analyticsModule))
			{
				verifyIsPageExists(analyticSearch, pageName, moduleName);
			}
			else
			{
				
			}			
			WriteTestResult.addRowInDetailsSheet(pageName +" SCREEN", "ENTER SCREEN", pageName, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, ReadLoginDetails.user_name1(), "", responsetime, message);
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}
	
	//Method to verify whether page exists or not
	public static void verifyIsPageExists(String searchPath, String nameOfPage, String nameOfModule) throws Exception
	{
		//Searching Page by its name
		DeclareVariables.searchPageName = FunctionLibraries2.locator("xpath", searchPath);
		DeclareVariables.searchPageName.clear();	Thread.sleep(2000);
		DeclareVariables.searchPageName.sendKeys(nameOfPage);	Thread.sleep(2000);
		
		String searchListXPath = "//div[@class='suggestPopupMiddleCenterInner suggestPopupContent']";
		if(FunctionLibraries2.isElementPresent(By.xpath(searchListXPath)))
		{
			if(nameOfModule.equals(CommonValues.docsModule))
			{
				DeclareVariables.searchPageName.sendKeys(Keys.DOWN);
				DeclareVariables.searchPageName.sendKeys(Keys.DOWN);
				Thread.sleep(2000);
				DeclareVariables.searchPageName.sendKeys(Keys.ENTER);
			}
			else
			{
				DeclareVariables.searchPageName.sendKeys(Keys.ENTER);
			}
		}
		else
		{
			//Call take screenshot function
			CommonMethods2.takeSnapShot(DeclareVariables.driver2, "navigateTo_"+nameOfPage+"_Page_"+System.currentTimeMillis() +".png");
			DeclareVariables.failResultMessage = "'" +nameOfPage +"' PAGE NOT EXISTS FOR '" +ReadLoginDetails.user_name1() +"'";
			CreateLogs.writeLogs(DeclareVariables.failResultMessage);
			//Print Result in Excel File
			WriteTestResult.addRowInBasicSheet("", "FAIL", "", CommonValues.dateTime, CommonValues.environmentName, CommonValues.subTenantName, nameOfModule, ReadLoginDetails.user_name1(), DeclareVariables.failResultMessage);
			WriteTestResult.addRowInDetailsSheet("VERIFY "+nameOfPage, nameOfPage +" SCREEN OPEN", nameOfPage, CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, ReadLoginDetails.user_name1(), "", "", DeclareVariables.failResultMessage);
		}
	}	
	
	//Method to refresh the page or DOM
	public static void refreshPage()
	{
		try {
			Thread.sleep(3000);
			DeclareVariables.driver2.navigate().refresh();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Method to click on INTRANET menu option
	public static void clickIntranet() throws InterruptedException
	{
		//Go to INTRANET page
		String intranetMenuXPath1 = "/html/body/div[2]/div/div[2]/div/div[3]/div[1]/div[2]/div/div[1]/div[2]";
		String intranetMenuXPath2 = "/html/body/div[2]/div/div/div/div[3]/div[1]/div[2]/div/div[1]/div[2]";
		
		DeclareVariables.wait2 = new WebDriverWait(DeclareVariables.driver2, 60);

		if(FunctionLibraries2.isElementPresent(By.xpath(intranetMenuXPath1)))
		{
			WebElement intranetMenu = DeclareVariables.wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(intranetMenuXPath1)));
			intranetMenu.click();
			CreateLogs.writeLogs("SYSTEM CLICKED ON INTRANET MENU SUCCESSFULLY");
			
//			Thread.sleep(2000);
			WebElement closeDashboard = FunctionLibraries2.locator("xpath", "/html/body/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]");
			String iconText = closeDashboard.getAttribute("title");
			//CreateLogs.writeLogs("POP UP ICON TEXT FOUND ::- " +iconText);
			if(iconText.equals("CLOSE"))
			{
				closeDashboard.click();
			}
			else
			{
				CreateLogs.writeLogs("SYSTEM IS ON INTRANET PAGE BUT POPUP STILL OPEN");
			}
		}
		else if(FunctionLibraries2.isElementPresent(By.xpath(intranetMenuXPath2)))
		{
			WebElement intranetMenu = DeclareVariables.wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(intranetMenuXPath2)));
			intranetMenu.click();
			CreateLogs.writeLogs("System clicked on INTRANET Menu successfully");
		}
		else
		{
			CreateLogs.writeLogs("INTRANET Menu Not Found!!!");
		}
	}
	
	//File upload by Robot Class
    public static void uploadFileWithRobot(String filePath) throws Exception 
    {
        StringSelection stringSelection = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
 
        Robot robot = null;
 
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
 
        robot.delay(150);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
//        Thread.sleep(3000);
        String checkPopUpTopXPath = "//div[@class='cmplt-noti-dlg-lbl cmplt-noti-dlg-lbl-top']";
		String checkPopUpTopText = FunctionLibraries2.locator("xpath", checkPopUpTopXPath).getText();
		System.out.println(checkPopUpTopText);
		
		String checkPopUpBottomXPath = "//div[@class='cmplt-noti-dlg-lbl cmplt-noti-dlg-lbl-bottom']";
		String checkPopUpBottomText = FunctionLibraries2.locator("xpath", checkPopUpBottomXPath).getText();
		System.out.println(checkPopUpBottomText);

		long t1 = new Date().getTime();
//		System.out.println("FIRST TOP TIME ::- " +t1);
		
        String saveTextXPath = "//div[@class='cmplt-noti-dlg-lbl cmplt-noti-update-dlg-lbl inln-blck v-mid-algn']";      
        WebElement savePopUp = FunctionLibraries2.locator("xpath", saveTextXPath);
        if(savePopUp!=null)
        {
//        	Thread.sleep(1500);
        	DeclareVariables.savePopUpMsg = savePopUp.getText();
        	CreateLogs.writeLogs("SAVE POP UP MESSAGE FOUND ::- " +DeclareVariables.savePopUpMsg);
        }
        else
        {
        	if(FunctionLibraries2.isElementPresent(By.xpath("//div[@class='HOR-FLEX-EL FLY-CLOSE-TRG FLY-TOP-TRG material-icons TRG-BASE trg-base'][@title='CLOSE']")))
        	{
        		DeclareVariables.driver2.findElement(By.xpath("//div[@class='HOR-FLEX-EL FLY-CLOSE-TRG FLY-TOP-TRG material-icons TRG-BASE trg-base'][@title='CLOSE']")).click();
        		CreateLogs.writeLogs("SAVE POP UP NOT FOUND");
        	}
        	else
        	{
        		
        	}
        }
        long t2 = new Date().getTime();

        DeclareVariables.timeTaken = ((t2-t1)-3000) + " miliseconds";
        DeclareVariables.passResultMessage = "FEED INITIATED SUCCESSFULLY AND 'SAVED!' MESSAGE APPEARED!!!";
        CreateLogs.writeLogs(DeclareVariables.passResultMessage);
        if((DeclareVariables.savePopUpMsg).equals("SAVED!"))
        {
//        	System.out.println("FINAL TIME ::- " +DeclareVariables.timeTaken);
        	WriteTestResult.addRowInDetailsSheet("SAVE FEED", "SAVE FEED", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, ReadLoginDetails.user_name1(), "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
        
        	/* 
			 * 
			 * Code for Performance Report
			 * 
			 */
			DeclareVariables.saveBtnCounting = DeclareVariables.saveBtnCount+1;
			System.out.println("SAVE " +DeclareVariables.saveBtnCounting);
			String noOfAction = Integer.toString(DeclareVariables.saveBtnCounting);
			System.out.println(noOfAction);
			saveFeedTime = (double) ((t2-t1)-3000)/1000;
        }
        else
        {
        	DeclareVariables.passResultMessage = "FEED INITIATED SUCCESSFULLY AND BUT 'SAVED!' MESSAGE NOT FOUND!!!";
        	WriteTestResult.addRowInDetailsSheet("SAVE FEED", "SAVE FEED", "FEEDS", CommonMethods2.GetCurrentTimeStamp(), CommonValues.environmentName, CommonValues.tenantName, CommonValues.subTenantName, ReadLoginDetails.user_name1(), "", DeclareVariables.timeTaken, DeclareVariables.passResultMessage);
        }
    }
	
    //Method to close Pop Up
    public static void closePopUp()
    {
    	try
    	{
    		String notificWindowXPath = "//div[@class='NOTIFDASH-WGT']//div[@class='NOTIFDASH-WGT-INNER']//div[2][@title='CLOSE']";
    		if(FunctionLibraries2.isElementPresent(By.xpath(notificWindowXPath)))
	    	{
	    		//Thread.sleep(5000);
				WebElement closeDashboard = FunctionLibraries2.locator("xpath", notificWindowXPath);
				String iconText = closeDashboard.getAttribute("title");
				//CreateLogs.writeLogs("POP UP ICON TEXT FOUND ::- " +iconText);
				if(iconText.equals("CLOSE"))
				{
					closeDashboard.click();
				}
				else
				{
					String closeProcessNotification = "//div[@class='PRIZE-A5 A5 HAS-TRANS-400 OVFLW-HDN']//div[@class='material-icons REALM-DOMINANT-CLR NOTIF-WGT-TRG NOTIF-WGT-TRG-RFRH TRG-BASE trg-base'][contains(text(),'refresh')]";
					String closeAnalyticNotification = "//div[@class='WIZ-A5 A5 HAS-TRANS-400 OVFLW-HDN']//div[@class='material-icons REALM-DOMINANT-CLR NOTIF-WGT-TRG NOTIF-WGT-TRG-RFRH TRG-BASE trg-base'][contains(text(),'refresh')]";
					String closeAdminNotification = "//div[@class='QONCIERGE-A5 A5 HAS-TRANS-400 OVFLW-HDN']//div[@class='material-icons REALM-DOMINANT-CLR NOTIF-WGT-TRG NOTIF-WGT-TRG-RFRH TRG-BASE trg-base'][contains(text(),'refresh')]";
					
					if(FunctionLibraries2.isElementPresent(By.xpath(closeProcessNotification)))
					{
						DeclareVariables.driver2.findElement(By.xpath(closeProcessNotification)).click();
					}
					else if(FunctionLibraries2.isElementPresent(By.xpath(closeAnalyticNotification)))
					{
						DeclareVariables.driver2.findElement(By.xpath(closeAnalyticNotification)).click();
					}
					else if(FunctionLibraries2.isElementPresent(By.xpath(closeAdminNotification)))
					{
						DeclareVariables.driver2.findElement(By.xpath(closeAdminNotification)).click();
					}
					else
					{
						//System.out.println("PREVIOUS TAB NOT FOUND SO NOT CLICKED!!!");
					}
				}
	    	}
    		else
    		{
    			
    		}
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		CreateLogs.writeLogs(e.getMessage());
		}
    }
    
	public static void windowHandler()
	{		
		// Store the current window handle 
		String winHandleBefore = DeclareVariables.driver2.getWindowHandle(); 
		// Perform the click operation that opens new window 
		// Switch to new window opened 
		for(String winHandle : DeclareVariables.driver2.getWindowHandles()) 
		{
			DeclareVariables.driver2.switchTo().window(winHandle);
			System.out.println("SYSTEM IS ON NEW WINDOW"); 
		}
		// Perform the actions on new window 
		// Close the new window, if that window no more required 
		DeclareVariables.driver2.close();
		  
		// Switch back to original browser (first window)
		DeclareVariables.driver2.switchTo().window(winHandleBefore);
		  
		// Continue with original browser (first window)
	}	
	
	//Method to wait for element
	public static void waitForElement(By by)
	{
		DeclareVariables.wait2 = new WebDriverWait(DeclareVariables.driver2, 90);	//90 means seconds
		DeclareVariables.wait2.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	//Method to take screenshot
	public static void takeSnapShot(WebDriver webdriver1, String errorImagefileName) throws Exception
	{
        //Convert web driver1 object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot)webdriver1);

        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile = new File(CommonValues.errorImageFilePath +errorImagefileName);

        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
	
	//Method to get current date and time
	public static String GetCurrentTimeStamp() 
	{
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");// dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
	
	//Method to search record on Processes Pages
	public static void searchAdminRecord(String status, String name, String fileName, String pageName) throws InterruptedException
	{
		String firstSearchText = null;			String secondSearchText = null;		String thirdSearchText = null;
		WebElement firstSearchTextBox = null; 	WebElement secondSearchTextBox = null; 	WebElement thirdSearchTextBox = null;
		
		String adminFirstSearchTextXPath = "//body/div[@class='ROOT-PANEL']/div[@class='CONTENTDECK']/div[@class='DECKLAYER-PARENT']/div[@class='REALM REALM-QONCIERGE']/div[@class='REALM-BDY REALM-BDY-QONCIERGE']/div[@class='REALM-BDY-CNT REALM-BDY-EL REALM-BDY-CNT-QONCIERGE HAS-TRANS-300']/div[@class='QONCIERGE-B3 B3']/div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-QONCIERGE']/div[@class='VZ-WGT-BDY-DECK']/div[@class='GRID-WGT vert-flex-cnt']/div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']/div[@class='GRIDWGT-INNER']/div[@class='GRID-WGT-HEAD-OUTER']/div[@class='GRID-WGT-HEAD-INNER']/div[@class='GRID-WGT-HDRS-OUTER']/table[@class='GRID-WGT-HDRS']/tbody/tr/td[1]/div[1]/input[1]";
		String adminSecondSearchTextXPath = "//body/div[@class='ROOT-PANEL']/div[@class='CONTENTDECK']/div[@class='DECKLAYER-PARENT']/div[@class='REALM REALM-QONCIERGE']/div[@class='REALM-BDY REALM-BDY-QONCIERGE']/div[@class='REALM-BDY-CNT REALM-BDY-EL REALM-BDY-CNT-QONCIERGE HAS-TRANS-300']/div[@class='QONCIERGE-B3 B3']/div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-QONCIERGE']/div[@class='VZ-WGT-BDY-DECK']/div[@class='GRID-WGT vert-flex-cnt']/div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']/div[@class='GRIDWGT-INNER']/div[@class='GRID-WGT-HEAD-OUTER']/div[@class='GRID-WGT-HEAD-INNER']/div[@class='GRID-WGT-HDRS-OUTER']/table[@class='GRID-WGT-HDRS']/tbody/tr/td[2]/div[1]/input[1]";
		String adminThirdSearchTextXPath = "//body/div[@class='ROOT-PANEL']/div[@class='CONTENTDECK']/div[@class='DECKLAYER-PARENT']/div[@class='REALM REALM-QONCIERGE']/div[@class='REALM-BDY REALM-BDY-QONCIERGE']/div[@class='REALM-BDY-CNT REALM-BDY-EL REALM-BDY-CNT-QONCIERGE HAS-TRANS-300']/div[@class='QONCIERGE-B3 B3']/div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-QONCIERGE']/div[@class='VZ-WGT-BDY-DECK']/div[@class='GRID-WGT vert-flex-cnt']/div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']/div[@class='GRIDWGT-INNER']/div[@class='GRID-WGT-HEAD-OUTER']/div[@class='GRID-WGT-HEAD-INNER']/div[@class='GRID-WGT-HDRS-OUTER']/table[@class='GRID-WGT-HDRS']/tbody/tr/td[3]/div[1]/input[1]";
		
		//Looking for Status textbox for search
		firstSearchText = status;
		firstSearchTextBox = FunctionLibraries2.locator("xpath", adminFirstSearchTextXPath);
		firstSearchTextBox.clear();		Thread.sleep(2000);
		firstSearchTextBox.sendKeys(firstSearchText);		Thread.sleep(2000);
		
		Thread.sleep(2000);
		//Looking for Feed/Name textbox for search
		secondSearchText = name;		
		secondSearchTextBox = FunctionLibraries2.locator("xpath", adminSecondSearchTextXPath);
		secondSearchTextBox.clear();		Thread.sleep(2000);
		secondSearchTextBox.sendKeys(secondSearchText);		Thread.sleep(2000);
				
		Thread.sleep(2000);
		//Looking for FileName/ParentName textbox for search
		thirdSearchText = fileName;		
		thirdSearchTextBox = FunctionLibraries2.locator("xpath", adminThirdSearchTextXPath);
		thirdSearchTextBox.clear();		Thread.sleep(2000);
		thirdSearchTextBox.sendKeys(thirdSearchText);		Thread.sleep(2000);
		thirdSearchTextBox.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
        String footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-QONCIERGE']//div[@class='VZ-WGT-BDY-DECK']//div[@class='GRID-WGT vert-flex-cnt']//div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']//div[@class='GRIDWGT-INNER']//div[@class='GRID-WGT-TOTALS-OUTER']//div[@class='GRID-TOTALS-WGT']//div[@class='GRID-MSG-WGT']//div[@class='GRID-MSG-WGT-ITEMS-OUTER']//div//div[@class='gwt-Label']";
        List<WebElement> valueF= DeclareVariables.driver2.findElements(By.xpath(footerRowXPath));
        for(int i=0;i<valueF.size();i++){
        	DeclareVariables.pageCount = valueF.get(i).getText();
//        	CreateLogs.writeLogs("RECORDS COUNT OF 'APPLICATIONS' PAGE ::- " +DeclareVariables.pageCount);
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
    		CreateLogs.writeLogs("ACTUAL NUMBERS OF RECORDS DISPLAYING IN " +pageName+" PAGE AFTER SEARCH ::- " +rowCount);
    		CommonMethods2.closePopUp();
    	}
    	else
		{
    		CreateLogs.writeLogs(firstSearchText +", and " +secondSearchText +", and " +thirdSearchText +" NOT FOUND IN " +pageName+" PAGE!!!");
		}
	}
	
	//Method to search record on Processes Page
	public static void searchProcessRecord(String status, String name, String fileName, String pageName) throws InterruptedException
	{
		String firstSearchText = null;			String secondSearchText = null;		String thirdSearchText = null;
		WebElement firstSearchTextBox = null; 	WebElement secondSearchTextBox = null; 	WebElement thirdSearchTextBox = null;

		String processFirstSearchTextboxXPath = "//body/div[@class='ROOT-PANEL']/div[@class='CONTENTDECK']/div[@class='DECKLAYER-PARENT']/div[@class='REALM REALM-PRIZE']/div[@class='REALM-BDY REALM-BDY-PRIZE']/div[@class='REALM-BDY-CNT REALM-BDY-EL REALM-BDY-CNT-PRIZE HAS-TRANS-300']/div[@class='PRIZE-B3 B3']/div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']/div[@class='VZ-WGT-BDY-DECK']/div[@class='GRID-WGT vert-flex-cnt']/div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']/div[@class='GRIDWGT-INNER']/div[@class='GRID-WGT-HEAD-OUTER']/div[@class='GRID-WGT-HEAD-INNER']/div[@class='GRID-WGT-HDRS-OUTER']/table[@class='GRID-WGT-HDRS']/tbody/tr/td[1]/div[1]/input[1]";
		String processSecondSearchTextboxXPath = "//body/div[@class='ROOT-PANEL']/div[@class='CONTENTDECK']/div[@class='DECKLAYER-PARENT']/div[@class='REALM REALM-PRIZE']/div[@class='REALM-BDY REALM-BDY-PRIZE']/div[@class='REALM-BDY-CNT REALM-BDY-EL REALM-BDY-CNT-PRIZE HAS-TRANS-300']/div[@class='PRIZE-B3 B3']/div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']/div[@class='VZ-WGT-BDY-DECK']/div[@class='GRID-WGT vert-flex-cnt']/div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']/div[@class='GRIDWGT-INNER']/div[@class='GRID-WGT-HEAD-OUTER']/div[@class='GRID-WGT-HEAD-INNER']/div[@class='GRID-WGT-HDRS-OUTER']/table[@class='GRID-WGT-HDRS']/tbody/tr/td[2]/div[1]/input[1]";
		String processThirdSearchTextboxXPath = "//body/div[@class='ROOT-PANEL']/div[@class='CONTENTDECK']/div[@class='DECKLAYER-PARENT']/div[@class='REALM REALM-PRIZE']/div[@class='REALM-BDY REALM-BDY-PRIZE']/div[@class='REALM-BDY-CNT REALM-BDY-EL REALM-BDY-CNT-PRIZE HAS-TRANS-300']/div[@class='PRIZE-B3 B3']/div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']/div[@class='VZ-WGT-BDY-DECK']/div[@class='GRID-WGT vert-flex-cnt']/div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']/div[@class='GRIDWGT-INNER']/div[@class='GRID-WGT-HEAD-OUTER']/div[@class='GRID-WGT-HEAD-INNER']/div[@class='GRID-WGT-HDRS-OUTER']/table[@class='GRID-WGT-HDRS']/tbody/tr/td[3]/div[1]/input[1]";
		
		//Looking for Status textbox for search
		firstSearchText = status;
		firstSearchTextBox = FunctionLibraries2.locator("xpath", processFirstSearchTextboxXPath);
		firstSearchTextBox.clear();		Thread.sleep(2000);
		firstSearchTextBox.sendKeys(firstSearchText);		Thread.sleep(2000);

		Thread.sleep(2000);
		//Looking for Feed/Name textbox for search
		secondSearchText = name;		
		secondSearchTextBox = FunctionLibraries2.locator("xpath", processSecondSearchTextboxXPath);
		secondSearchTextBox.clear();		Thread.sleep(2000);
		secondSearchTextBox.sendKeys(secondSearchText);		Thread.sleep(2000);
		
		Thread.sleep(2000);
		//Looking for FileName/ParentName textbox for search
		thirdSearchText = fileName;		
		thirdSearchTextBox = FunctionLibraries2.locator("xpath", processThirdSearchTextboxXPath);
		thirdSearchTextBox.clear();		Thread.sleep(2000);
		thirdSearchTextBox.sendKeys(thirdSearchText);		Thread.sleep(2000);
		thirdSearchTextBox.sendKeys(Keys.ENTER);

		Thread.sleep(5000);
        String footerRowXPath = "//div[@class='VZ-WGT-BDY-WRP VZ-WGT-BDY-WRP-PRIZE']//div[@class='VZ-WGT-BDY-DECK']//div[@class='GRID-WGT vert-flex-cnt']//div[@class='GRIDWGT-OUTER-CNT has-trans-300 GRIDWGT-OUTER-CNT-VZ vert-flex-el']//div[@class='GRIDWGT-INNER']//div[@class='GRID-WGT-TOTALS-OUTER']//div[@class='GRID-TOTALS-WGT']//div[@class='GRID-MSG-WGT']//div[@class='GRID-MSG-WGT-ITEMS-OUTER']//div//div[@class='gwt-Label']";
        List<WebElement> valueF= DeclareVariables.driver2.findElements(By.xpath(footerRowXPath));
        for(int i=0;i<valueF.size();i++){
        	DeclareVariables.pageCount = valueF.get(i).getText();
//	        	CreateLogs.writeLogs("RECORDS COUNT OF 'APPLICATIONS' PAGE ::- " +DeclareVariables.pageCount);
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
    		CreateLogs.writeLogs("ACTUAL NUMBERS OF RECORDS DISPLAYING IN " +pageName+" PAGE AFTER SEARCH ::- " +rowCount);
    		CommonMethods2.closePopUp();
    	}
    	else
		{
    		CreateLogs.writeLogs(firstSearchText +", and " +secondSearchText +", and " +thirdSearchText +" NOT FOUND IN " +pageName+" PAGE!!!");
		}
	}
	
	//Method to verify HOme Page after login
	public static String verifyHomePage() throws InterruptedException
	{
		String appNameText = null;
		String adminHeaderXPath = "//div[@class='USER-AVATAR INLN-BLCK V-MID-ALGN cursor-pntr USER-AVATAR-QONCIERGE']//span[@class='READONLYCELL-SUP'][contains(text(),'ASSET MANAGEMENT')]";
		String processesHeaderXPath = "//div[@class='USER-AVATAR INLN-BLCK V-MID-ALGN cursor-pntr USER-AVATAR-PRIZE']//span[@class='READONLYCELL-SUP'][contains(text(),'ASSET MANAGEMENT')]";
		String analyticsHeaderXPath = "//div[@class='USER-AVATAR INLN-BLCK V-MID-ALGN cursor-pntr USER-AVATAR-WIZ']//span[@class='READONLYCELL-SUP'][contains(text(),'ASSET MANAGEMENT')]";
		String internetHeaderXPath = "//div[@class='USER-AVATAR INLN-BLCK V-MID-ALGN cursor-pntr USER-AVATAR-FOLIOS']//span[@class='READONLYCELL-SUP'][contains(text(),'ASSET MANAGEMENT')]";
	
		if(DeclareVariables.driver2.findElements(By.xpath(adminHeaderXPath)).size()>0)
		{
			appNameText = FunctionLibraries2.locator("xpath", adminHeaderXPath).getText();
			CreateLogs.writeLogs("APP NAME TEXT ::- " +appNameText);
		}
		else if(DeclareVariables.driver2.findElements(By.xpath(processesHeaderXPath)).size()>0)
		{
			appNameText = FunctionLibraries2.locator("xpath", processesHeaderXPath).getText();
			CreateLogs.writeLogs("APP NAME TEXT ::- " +appNameText);
		}
		else if(DeclareVariables.driver2.findElements(By.xpath(analyticsHeaderXPath)).size()>0)
		{
			appNameText = FunctionLibraries2.locator("xpath", analyticsHeaderXPath).getText();
			CreateLogs.writeLogs("APP NAME TEXT ::- " +appNameText);
		}
		else if(DeclareVariables.driver2.findElements(By.xpath(internetHeaderXPath)).size()>0)
		{
			appNameText = FunctionLibraries2.locator("xpath", internetHeaderXPath).getText();
			CreateLogs.writeLogs("APP NAME TEXT ::- " +appNameText);
		}
		else
		{
			CreateLogs.writeLogs("LOGGED IN APPLICATION IS NOT " +CommonValues.applicationName +". PLEASE CHECK!!!");
		}
		return appNameText;
	}
}
