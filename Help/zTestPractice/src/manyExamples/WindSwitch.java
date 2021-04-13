package manyExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindSwitch
{
	WebDriver driver = null;
	String ParentWindow = null;
	
	@BeforeClass
	public void init()
	{
		driver = new FirefoxDriver();
	}
	
	@Test(priority=1)
	public void ParentWindow() throws InterruptedException
	{
		driver.manage().window().maximize();
		
		driver.get("http://www.meetup.com/pdx-se/");
		
		driver.findElement(By.xpath(".//*[@id='join-or-connect']/div/div[1]/div[1]/div[2]/a")).click();
		
		// Store and Print the name of the First window on the console
		ParentWindow = driver.getWindowHandle();
		System.out.println("First Window Name is ::-  "   +ParentWindow);

        //Move onto New Opened Window
        for (String ChildWindow : driver.getWindowHandles())
        {
        	System.out.println("2nd window id is ::-  "    +ChildWindow);
        	driver.switchTo().window(ChildWindow);
        }
        driver.findElement(By.name("email")).sendKeys("mearun_kapoor@yahoo.co.in");
        
        Thread.sleep(3000);
        driver.findElement(By.linkText("Forgotten password?")).click();
	}
	
	/*         
        	driver.findElement(By.name("email")).sendKeys("mearun_kapoor@yahoo.co.in");
        
        	// Close the new window, if that window no more required
        	// driver.close();
        
        	// Switch back to original browser (first window)
        	//driver.switchTo().window(ParentWindow);
        
        	// Continue with original browser (first window)
        	// String HeadingText = driver.findElement(By.xpath(".//*[@id='welcome-message']")).getText();
        	// System.out.println("Parent Window Heading is ::-   "  +HeadingText);
        
	 */
	
	/*
	@Test(priority=3)
	public void SubChildWindow()
	{
		//Move onto another newly opened window
    	for (String SubChildWindow : driver.getWindowHandles())
    	{
    		System.out.println(SubChildWindow);
    		driver.switchTo().window(SubChildWindow);
    	}
    	
    	driver.findElement(By.id("identify_email")).sendKeys("mearun_kapoor@gmail.com");
    	
    	driver.switchTo().window(ParentWindow);
    	
    	driver.findElement(By.id("gh-topnav-join")).click();

    	//to close all browsers
    	//driver.quit();
	}*/
}
