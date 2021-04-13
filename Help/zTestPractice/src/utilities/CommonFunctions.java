package utilities;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CommonFunctions {

	public static WebDriver driver = null;
	public static String projectPath = System.getProperty("user.dir");
	public static Logger log = Logger.getLogger(CommonFunctions.class);
	public static DesiredCapabilities cap = null;
	public static String applicationUrl = "https://taxesandfees.innodata.com:8443/CCCTaxCalculator/login";

	// Method for Generating Logs
	public static void logCreation() {
		long systime= System.currentTimeMillis();
		String logFileName = "Log_" + systime;
		System.setProperty("logFile", logFileName);
		//PropertyConfigurator.configure("Log4j.properties");
		DOMConfigurator.configure(projectPath+"/xmls/log4j.xml");
	}
	//Method to maximize the Browser Window Size
	public static void maxWindowSize() {
		driver.manage().window().maximize();
	}
	//Method to login Application
	public static void loginApplication() throws InterruptedException
	{
		try {
			driver.get("https://taxesandfees.innodata.com:8443/CCCTaxCalculator/login");
	        driver.findElement(By.id("username")).sendKeys("testuser");
	        driver.findElement(By.id("password")).sendKeys("drive_well");
	        Wait();
	        driver.findElement(By.xpath("//*[@id='main']/div/div/div/div[2]/form/div/div[3]/button")).click();
			Wait(); Wait();
			String pageTitle = CommonFunctions.driver.getTitle();
			//System.out.println("Title Found ::- " +pageTitle);
			if(pageTitle.equals("Innodata Vehicle tax app")) {
				log.info("loginApplication() Test Passed! As Application Logged in Successfully");
				Wait();
			}			
		}
		catch(Throwable ex)
		{
			log.info("Login Failed");
		}
	}
	// Method to Close Browser
	public static void closeBrowser() {
		log.info("Closing Browser - " + CommonFunctions.driver.getTitle());
		CommonFunctions.driver.close();
		CommonFunctions.driver.quit();
	}
	// Method for Waiting Time
	public static void Wait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace(); }
	}
	//Method to get Output result from Application
	public static double commonLabelText(String elementIdText, String elementName)
	{
		DecimalFormat df = new DecimalFormat("#0.00");
		String labelText = "0.00";
		double outputValue = 0.00;
		try {			
			WebElement isElementPresent = CommonFunctions.driver.findElement(By.id(elementIdText));	
			if(isElementPresent != null)
			{	
				labelText = isElementPresent.getText();
				outputValue = Double.valueOf(labelText).doubleValue();
				log.info(elementName +" = " +outputValue);
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			} 
		}
		catch(Throwable ex)
		{
			//System.out.println(ex);
			log.info(elementName +" = " +labelText);
			//log.info(elementName +" Not found");
		}
		return outputValue;
	}
}
