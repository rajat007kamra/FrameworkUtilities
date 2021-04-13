package com.qanonTesting.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
//import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.xml.DOMConfigurator;

public class FunctionLibraries1 
{
//	public static Logger log = Logger.getLogger(FunctionLibraries1.class.getName());
	// Method for Generating Logs
	public static void logCreation()
	{
		long systime= System.currentTimeMillis();
		String logFileName= "Log_" + systime;
		System.setProperty("logFile", logFileName);		
		//DOMConfigurator.configure(System.getProperty("user.dir")+"/xmls/log4j.xml");
//		PropertyConfigurator.configure("Log4j.properties");
	}
	
	// Method to Open Browser Window
	public static void openBrowser(String browserName)
	{
		CreateLogs.writeLogs("OPENING BROWSER '" +browserName +"'");
		browserName = browserName.toLowerCase();
		
		if(browserName.equals("firefox"))
		{
			DeclareVariables.driver1 = new FirefoxDriver();
			DeclareVariables.driver1.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", DeclareVariables.projectPath+"\\drivers\\IEDriverServer.exe");			
			DeclareVariables.driver1 = new InternetExplorerDriver();
		}
		else if(browserName.equals("chrome"))		
		{
			System.setProperty("webdriver.chrome.driver", CommonValues.chromeDriverPath);
			DeclareVariables.driver1 = new ChromeDriver();
			
			SessionId sessionid = ((ChromeDriver) DeclareVariables.driver1).getSessionId();
			CreateLogs.writeLogs("CHROME SESSION ID FOR " +CommonValues.txtUsername1 +" USER IS ::- " +sessionid);
		}
		else
		{
			CreateLogs.writeLogs("BROWSER NAME USED :- " +browserName);
			CreateLogs.writeLogs("NO CORRECT BROWSER");
		}
	}
	
	// Method to Open Application/Project URL
	public static void openUrl(String url)
	{
		DeclareVariables.driver1.get(url);
		CreateLogs.writeLogs("OPENING APPLICATION URL:- " +url);
	}
	
	// Method to type text in Text-box
	public static void enterText(String locatorType, String locatorValue, String elementText)
	{
		WebElement element = null;	
		try
		{
			if(locatorType.equals("id"))
			{
				element = (new WebDriverWait(DeclareVariables.driver1, 90)).until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
				element.sendKeys(elementText);
			}
			else if(locatorType.equals("name"))
			{
				element = DeclareVariables.driver1.findElement(By.name(locatorValue));
				element.sendKeys(elementText);
			}
			else if(locatorType.equals("xpath"))
			{
				element = (new WebDriverWait(DeclareVariables.driver1, 90)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
				element.sendKeys(elementText);
			}
			else if(locatorType.equals("css"))
			{
				element = DeclareVariables.driver1.findElement(By.cssSelector(locatorValue));
				element.sendKeys(elementText);
			}
			else if(locatorType.equals("className"))
			{
				element = DeclareVariables.driver1.findElement(By.className(locatorValue));
				element.sendKeys(elementText);
			}
			else if(locatorType.equals("tagName"))
			{
				element = DeclareVariables.driver1.findElement(By.tagName(locatorValue));
				element.sendKeys(elementText);
			}
			else if(locatorType.equals("linktext"))
			{
				element = DeclareVariables.driver1.findElement(By.linkText(locatorValue));
				element.sendKeys(elementText);
			}
			else if(locatorType.equals("partiallinktext"))
			{
				element = DeclareVariables.driver1.findElement(By.partialLinkText(locatorValue));
				element.sendKeys(elementText);
			}
			else
			{
				element=null;
			}
		}
		catch(Throwable t)
		{			
			System.out.println(t);
			element=null;
		}
		//return element;
	}

	// Method to click on Button
	public static void clickButton(String locatorType, String locatorValue, String btnName)
	{
		WebElement mybutton= FunctionLibraries1.locator(locatorType, locatorValue);
		mybutton.click();
		CreateLogs.writeLogs("SYSTEM SUCCESSFULLY CLICKED ON '" +btnName+ "' BUTTON!!!");
	}
	
	// Method for finding Elements on page
	public static WebElement locator(String locatorType, String locatorValue)
	{			
		WebElement myElement=null;
		try
		{
			if(locatorType.equals("id"))
			{
				myElement = (new WebDriverWait(DeclareVariables.driver1, 90)).until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			}
			else if(locatorType.equals("name"))
			{
				myElement = (new WebDriverWait(DeclareVariables.driver1, 90)).until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			}
			else if(locatorType.equals("xpath"))
			{
				myElement = (new WebDriverWait(DeclareVariables.driver1, 90)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			}
			else if(locatorType.equals("css"))
			{
				myElement = (new WebDriverWait(DeclareVariables.driver1, 90)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			}
			else if(locatorType.equals("className"))
			{
				myElement = (new WebDriverWait(DeclareVariables.driver1, 90)).until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			}
			else if(locatorType.equals("tagName"))
			{
				myElement = (new WebDriverWait(DeclareVariables.driver1, 90)).until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
			}
			else if(locatorType.equals("linkText"))
			{
				myElement = (new WebDriverWait(DeclareVariables.driver1, 90)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			}
			else if(locatorType.equals("partialLinkText"))
			{
				myElement = (new WebDriverWait(DeclareVariables.driver1, 90)).until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			}
			else
			{
				myElement=null;
			}
		}
		catch(Throwable t)
		{
			System.out.println(t);
			myElement=null;
		}
		
		return myElement;
	}

	//Method to verify the presence of Element on page
	public static Boolean isElementPresent(By by)
	{
		try
		{
			DeclareVariables.wait1 = new WebDriverWait(DeclareVariables.driver1, 90);
			DeclareVariables.driver1.findElement(by);
			return true;
		}
		catch(NoSuchElementException ex)
		{
			return false;
		}
	}
}