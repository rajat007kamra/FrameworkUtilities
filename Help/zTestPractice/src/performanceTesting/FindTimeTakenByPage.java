package performanceTesting;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindTimeTakenByPage 
{
	WebDriverWait wait;
	@Test
	public void OpenAgreement() throws InterruptedException
	{
		for(int i=1; i<=3; i++)
		{
			String projectPath = System.getProperty("user.dir");
			System.setProperty("webdriver.ie.driver", projectPath+"/envVariables/IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();
			driver.get("http://10.120.0.138:8080/NAXIOSCO/?login");
			
			wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName"))).sendKeys("le");
			
			wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("test");
			
			wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogin"))).click();
	
			wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'017358W')]")));
			
			Actions act = new Actions(driver);
			act.doubleClick(driver.findElement(By.xpath("//div[contains(text(),'017358W')]"))).build().perform();
			
			long t1 = new Date().getTime();
			System.out.println("Time when 'Agreement' details clicked:- " +t1/1000);
			
			wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'EQU')]")));
			
			String GridText = driver.findElement(By.xpath("//div[contains(text(),'EQU')]")).getText();		
			System.out.println("Exact Value found is:-  " +GridText);		
			Assert.assertEquals(GridText, "EQU");	
	
			long t2 = new Date().getTime();
			System.out.println("Time when 'Agreement' details opened and verified:- " +t2/1000);
			
			System.out.println("Actual Time Taken in loading 'Agreement Details' grid is:- " +((t2-t1)/1000) +"sec");
		}
	}
}
