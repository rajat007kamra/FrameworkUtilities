package manyExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class parallelclass 
{
	WebDriver driver = null;
	
	@Test
	public void chrome() throws InterruptedException
	{
		Thread.sleep(2000);		
		System.setProperty("webdriver.chrome.driver", "C:/Users/PPJ/workspace/testproject/envVariables/chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	@AfterTest
	public void quit()
	{
		driver.close();
	}
}
