package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionLibraries {
	// Method to Open Browser Window
	public static void openBrowser(String browserName) {
		// log.info(browserName);
		browserName = browserName.toLowerCase();

		if (browserName.equals("firefox")) {
			CommonFunctions.driver = new FirefoxDriver();
			CommonFunctions.maxWindowSize();
			CommonFunctions.driver.manage().timeouts()
					.implicitlyWait(60, TimeUnit.SECONDS);
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", CommonFunctions.projectPath
					+ "/envVariables/IEDriverServer.exe");
			CommonFunctions.driver = new InternetExplorerDriver();
			CommonFunctions.maxWindowSize();
			CommonFunctions.log
					.info("Internet Explorer (ie) Browser Opened Successfully");
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", CommonFunctions.projectPath
					+ "\\envVariables\\chromedriver.exe");
			CommonFunctions.driver = new ChromeDriver();
			CommonFunctions.maxWindowSize();
		} else {
			CommonFunctions.log.info("Broswer Name Used :- " + browserName);
			CommonFunctions.log.info("Browser Not Exists");
		}
	}

	// Method to Open Application/Project URL
	public static void openUrl(String url) {
		// log.info(url);
		CommonFunctions.driver.get(url);
		CommonFunctions.log.info("Start Opening Application");
	}

	// Method to type text in Text-box
	public static void enterText(String LocatorType, String LocatorId,
			String LocatorValue, String fieldName) {
		WebElement element = null;
		WebDriverWait wait;
		try {
			if (LocatorType.equals("id")) {
				wait = new WebDriverWait(CommonFunctions.driver, 60);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.id(LocatorId)));

				element = CommonFunctions.driver.findElement(By.id(LocatorId));
				element.sendKeys(LocatorValue);
			} else if (LocatorType.equals("name")) {
				wait = new WebDriverWait(CommonFunctions.driver, 60);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.name(LocatorId)));
				element = CommonFunctions.driver
						.findElement(By.name(LocatorId));
				element.sendKeys(LocatorValue);
			} else if (LocatorType.equals("xpath")) {
				element = CommonFunctions.driver.findElement(By
						.xpath(LocatorId));
				element.sendKeys(LocatorValue);
			} else if (LocatorType.equals("css")) {
				element = CommonFunctions.driver.findElement(By
						.cssSelector(LocatorId));
				element.sendKeys(LocatorValue);
			} else if (LocatorType.equals("className")) {
				element = CommonFunctions.driver.findElement(By
						.className(LocatorId));
				element.sendKeys(LocatorValue);
			} else if (LocatorType.equals("tagName")) {
				element = CommonFunctions.driver.findElement(By
						.tagName(LocatorId));
				element.sendKeys(LocatorValue);
			} else if (LocatorType.equals("linktext")) {
				element = CommonFunctions.driver.findElement(By
						.linkText(LocatorId));
				element.sendKeys(LocatorValue);
			} else if (LocatorType.equals("partiallinktext")) {
				element = CommonFunctions.driver.findElement(By
						.partialLinkText(LocatorId));
				element.sendKeys(LocatorValue);
			}
		} catch (Throwable t) {
			System.out.println(fieldName +" Element Not found");
		}
		// return element;
	}

	// Method to click on Button
	public static void clickButton(String objIdentificationType,
			String objectIdentificationValue, String buttonName) {
		WebElement mybutton = FunctionLibraries.locator(objIdentificationType,
				objectIdentificationValue);
		mybutton.click();
		CommonFunctions.log.info(buttonName +" Button Clicked");
	}

	// Method for finding Elements on page
	public static WebElement locator(String objIdentificationType,
			String objectIdentificationValue) {
		WebElement myElement = null;
		try {
			if (objIdentificationType.equals("id")) {
				myElement = CommonFunctions.driver.findElement(By
						.id(objectIdentificationValue));	
			} else if (objIdentificationType.equals("name")) {
				myElement = CommonFunctions.driver.findElement(By
						.name(objectIdentificationValue));
			} else if (objIdentificationType.equals("xpath")) {
				myElement = CommonFunctions.driver.findElement(By
						.xpath(objectIdentificationValue));
			} else if (objIdentificationType.equals("css")) {
				myElement = CommonFunctions.driver.findElement(By
						.cssSelector(objectIdentificationValue));
			} else if (objIdentificationType.equals("className")) {
				myElement = CommonFunctions.driver.findElement(By
						.className(objectIdentificationValue));
			} else if (objIdentificationType.equals("tagName")) {
				myElement = CommonFunctions.driver.findElement(By
						.tagName(objectIdentificationValue));
			} else if (objIdentificationType.equals("linkText")) {
				myElement = CommonFunctions.driver.findElement(By
						.linkText(objectIdentificationValue));
			} else if (objIdentificationType.equals("partialLinkText")) {
				myElement = CommonFunctions.driver.findElement(By
						.partialLinkText(objectIdentificationValue));
			} 
		} catch (Throwable t) {
			CommonFunctions.log.info(t);
			myElement = null;
		}
		return myElement;
	}

	// Method to select Drop-down List value
	public static void selectDDValue(String locatorName, String locatorValue, String elementName)
	{
		try {
			CommonFunctions.driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			//Thread.sleep(5000);
    		CommonFunctions.driver.findElement(By.id(locatorName)).click();
    		//Thread.sleep(3000);
			new Select(CommonFunctions.driver.findElement(By.id(locatorName))).selectByVisibleText(locatorValue);
		}
		catch(Throwable ex)
		{
			CommonFunctions.log.info(elementName +" Element Not found");
		}
	}
	
	// Method to capture Error in application
		public static void captureScreenShot(WebDriver Idriver)
		{
			Calendar cal = new GregorianCalendar();
			  int month = cal.get(Calendar.MONTH);
			  int year = cal.get(Calendar.YEAR);
			  int sec =cal.get(Calendar.SECOND);
			  int min =cal.get(Calendar.MINUTE);
			  int date = cal.get(Calendar.DATE);
			  int day =cal.get(Calendar.HOUR_OF_DAY);
		      String ImageDest = "Error";
			// Take screenshot and store as a file format             
			 File src=((TakesScreenshot)Idriver).getScreenshotAs(OutputType.FILE);           
			try {
			// now copy the  screenshot to desired location using copyFile method
			FileUtils.copyFile(src, new File(CommonFunctions.projectPath+"/ErrorScreens/"+ImageDest+"__"+ year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+   ".jpeg"));
			//FileUtils.copyFile(src, new File(projectPath+"/ErrorScreens/"+System.currentTimeMillis()+".png"));                              
			} catch (IOException e)
			 
			{
			  System.out.println(e.getMessage());
			 }
		}
}