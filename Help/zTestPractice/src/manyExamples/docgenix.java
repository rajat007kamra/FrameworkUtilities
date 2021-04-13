package manyExamples;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class docgenix 
{
	WebDriver driver = null;
	Logger Log = Logger.getLogger(docgenix.class.getName());
	
	@BeforeClass
	public void init()
	{
		driver = new FirefoxDriver();
		PropertyConfigurator.configure("Log4j.properties");		
		Log.info("New Browser Opened");
		
		driver.manage().window().maximize();
		Log.info("Browser Window Maximized");
	}
	
	@Test(priority=1)
	public void openApp()
	{
		driver.get("https://analytics.docgenix.com/testanalytics/welcome");
		Log.info("Application Opened");
		
		//String exactuRL = "https://analytics.docgenix.com/testanalytics/Welcome";
		
	//	String GetURL = driver.getCurrentUrl();
	//	Assert.assertEquals(exactuRL, GetURL);
	//	Log.info("Test Case Pass");
	}

	@Test(priority=2)
	public void Login() throws InterruptedException
	{
		driver.findElement(By.name("userId")).sendKeys("test1");
		Log.info("User Id Entered");
		
		driver.findElement(By.name("password1")).sendKeys("12345678");
		Log.info("Password Entered");
		
		driver.findElement(By.id("loginBtn")).click();
		Log.info("Login Button Clicked");
		
		Thread.sleep(5000);
	}
	
	@Test(priority=3)
	public void hoverMouse() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		WebElement subMenu = driver.findElement(By.cssSelector(".fa.fa-chevron-down"));
		actions.moveToElement(subMenu).build().perform();
		Log.info("Mouse Hover on Logout Menu");
		
		Thread.sleep(5000);
		subMenu.click();
		
		Log.info("Clicked on Logout Menu Option");
		Thread.sleep(5000);
		
		//driver.findElement(By.name("favouritestbl_length")).click();
	}
	
	@Test(priority=4)
	public void countRowsandColumns() throws InterruptedException
	{
		int rowCount = driver.findElements(By.xpath(".//*[@id='favouritestbl']/tbody/tr")).size();
		System.out.println("Total Number of Rows are :-     " +rowCount);
		Log.info("Total Number of Rows are :-     " +rowCount);
		
		int columnCount = driver.findElements(By.xpath(".//*[@id='favouritestbl']/thead/tr/th")).size();
		System.out.println("Total Number of Columns are :-     " +columnCount);
		Log.info("Total Number of Columns are :-     " +columnCount);
		
		
		Select dropdown = new Select(driver.findElement(By.name("favouritestbl_length")));
		dropdown.selectByValue("50");
		Thread.sleep(8000);
		//System.out.println(dropdown.getFirstSelectedOption());
	}
	
	/*
	@Test(priority=5)
	public void Logout() throws InterruptedException
	{
		hoverMouse();
		Actions actions1 = new Actions(driver);
		WebElement changePwd = driver.findElement(By.partialLinkText("ange"));
		actions1.moveToElement(changePwd);
		actions1.build().perform();
		Log.info("Mouse Hover on Change Password Option");		
		Thread.sleep(5000);
		
		
		
		Actions actions2 = new Actions(driver);
		WebElement logout = driver.findElement(By.partialLinkText("ogo"));
		actions2.moveToElement(logout);
		actions2.build().perform();		
		//actions1.moveToElement(driver.findElement(By.linkText("Logout"))).build().perform();
		Log.info("Mouse Hover on LogOut Option");		
		Thread.sleep(5000);		
		logout.click();
		Log.info("Logout Button Clicked");
	}
	*/
	
	@Test(priority=5)
	public void AdminPanel() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.navigate().to("https://analytics.docgenix.com/testanalytics/admin");
		
		Thread.sleep(2000);
		driver.findElement(By.id("alertTab")).click();
		
		Thread.sleep(3000);
		
		//Find the date time picker control		 
        WebElement dateBox = driver.findElement(By.id("datepickerFromAlert")); 
        //Fill date as mm/dd/yyyy as 09/25/2013 
        dateBox.sendKeys("20160113");
	}
	
	/*
	@AfterClass
	public void end() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}*/
}