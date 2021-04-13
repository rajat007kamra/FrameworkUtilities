package manyExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class practice 
{
	WebDriver driver = null;
	
	@Test(priority=1)
	public void firefoxTest() throws InterruptedException
	{
		driver = new FirefoxDriver();
		String URL = "http://10.120.0.138:8080/NAXTEST/?login";
		driver.get(URL);
		
		driver.findElement(By.id("x-auto-8-input")).sendKeys("le");
		driver.findElement(By.id("x-auto-9-input")).sendKeys("test");
		Thread.sleep(3000);
	}

	@Test(priority=2)
	public void IETest() throws InterruptedException
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.ie.driver", projectPath+"/envVariables/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		String URL = "http://10.120.0.138:8080/NAXTEST/?login";
		driver.get(URL);
		
		driver.findElement(By.name("userName")).sendKeys("le");
		Thread.sleep(3000);
	}
}
