package usingParameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WithParameter 

{

	@Test
	
	@Parameters({"author","searchKey"})
	
	public void testParameterWithXML(@Optional("abc") String author, @Optional("abc") String searchKey) throws InterruptedException
	{
		
		        
		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver", "D:/Arun Kapoor/Selenis Files/envVariables/chromedriver.exe");	
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://google.com");
			
				
		WebElement searchText = driver.findElement(By.id("lst-ib"));
		
        searchText.sendKeys(searchKey);

        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);

        System.out.println("Thread will sleep now");

        Thread.sleep(3000);
		
        System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+searchKey);

       

        Assert.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
		
	}
}
