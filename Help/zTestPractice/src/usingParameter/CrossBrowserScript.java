package usingParameter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript 

{

	
	WebDriver driver=null;
	//String browser;
	//String browser="Chrome";
	@BeforeTest

    @Parameters("browser")

	public void setup(String browser) throws Exception
	{
        //Check if parameter passed from TestNG is 'firefox'

        if(browser.equalsIgnoreCase("Chrome"))
        {        	
        	System.setProperty("webdriver.chrome.driver", "D:/Arun Kapoor/Selenis Files/envVariables/chromedriver.exe");        	
        	driver = new ChromeDriver();           
        }
        else
        	System.out.println("failed");

        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	@Test

    public void testParameterWithXML() throws InterruptedException
	{
        driver.get("http://demo.guru99.com/V4/");

        //Find user name
        WebElement userName = driver.findElement(By.name("uid"));

        //Fill user name
        userName.sendKeys("vikash.bhardwaj236@gmail.com");

        //Find password
        WebElement password = driver.findElement(By.name("password"));

        //Fill password
        password.sendKeys("Innodata@123j");
	}
}
