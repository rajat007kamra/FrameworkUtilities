package manyExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GoogleSearch
{
	WebDriver driver = null;
	
	@Test
	public void clickLinkTest() throws InterruptedException
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://google.com/");
		
		driver.findElement(By.id("lst-ib")).sendKeys("Testing");
		
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		
		//driver.findElement(By.name("btnG")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("Software testing - Wikipedia, the free encyclopedia")).click();
	}
	
}