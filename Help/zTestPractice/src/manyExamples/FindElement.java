package manyExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class FindElement 
{
	WebDriver driver = null;
	WebDriverWait wait;

	 @Test
	 public void ExecuteTest() throws Exception
	 {
		 String projectPath = System.getProperty("user.dir");
	 
		 System.setProperty("webdriver.ie.driver", projectPath+"/envVariables/IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
		 
		 driver.get("http://52.210.135.199:8181/bsi-web/");

		 driver.findElement(By.id("userName")).sendKeys("sprakash");
		 driver.findElement(By.id("password")).sendKeys("Password1");		 
		 driver.findElement(By.xpath("//*[@id='userModel']/button")).click();
		 
		// driver.findElement(By.id("searchPopup")).click();
		 
		 wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchPopup"))).click();
		 
		 //driver.findElement(By.xpath("//*[@id='searchPopup']")).click();

	 }
}