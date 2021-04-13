package manyExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameSwitch {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = null;
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://selenium.googlecode.com/svn/trunk/docs/api/java/index.html");
		
		///////////////////////////////////////////////
		
		driver.switchTo().frame("classFrame");
		
		driver.findElement(By.linkText("org.openqa.selenium.android")).click();
		
		//////////////////////////////////////////////
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("packageListFrame");
		
		driver.findElement(By.linkText("org.openqa.selenium.android")).click();
		
		
		///////////////////////////////////////////////
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("packageFrame");
		
		driver.findElement(By.linkText("AndroidDriver")).click();
		

	}

}
//packageListFrame
//packageFrame
//classFrame