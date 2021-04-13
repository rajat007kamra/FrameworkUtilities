package manyExamples;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class testNGclass 
{
	WebDriver driver = null;
	
	@Test
	public void firefox()
	{
		driver = new FirefoxDriver();
	}
	/*
	@Test
	public void chrome() throws InterruptedException
	{
		Thread.sleep(2000);		
		System.setProperty("webdriver.chrome.driver", "C:/Users/PPJ/workspace/testproject/envVariables/chromedriver.exe");
		driver=new ChromeDriver();		
	}*/
	
	@Test
	public void ie() throws InterruptedException
	{	
		Thread.sleep(2000);
		System.setProperty("webdriver.ie.driver", "C:/Users/PPJ/workspace/testproject/envVariables/IEDriverServer.exe");
		driver=new InternetExplorerDriver();
	}
	
	@AfterClass
	public void quit()
	{
		driver.close();
	}
}
