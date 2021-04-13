package manyExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SwitchWindow 
{
	@Test
	public void abcTest()
	{
		// Create a new instance of the Firefox driver
	 
		WebDriver driver = new FirefoxDriver();

		// Put an Implicit wait, this means that any search for elements on the page could take the time the implicit wait 
		// is set for before throwing exception

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the URL

		driver.get("http://toolsqa.com/automation-practice-switch-windows/");

		// Store and Print the name of the First window on the console

		String handle= driver.getWindowHandle();

		System.out.println(handle);

		// Click on the Button "New Message Window"

		driver.findElement(By.xpath(".//*[@id='content']/p[3]/button")).click();

		// Store and Print the name of all the windows open

		//Set handles = driver.getWindowHandles();

		//System.out.println(handles);

		// Pass a window handle to the other window

		for (String handle1 : driver.getWindowHandles())
		{
			System.out.println(handle1);

			driver.switchTo().window(handle1);
			driver.manage().window().maximize();

    	}

		// Closing Pop Up window

		//driver.close();

		// Close Original window

		//driver.quit();
	}
}
