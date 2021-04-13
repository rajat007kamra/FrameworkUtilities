package manyExamples;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Wait
{
	@Test
	public void ImplicitWait()
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='fk-top-search-box']")).sendKeys("Philips");
		driver.findElement(By.xpath(".//*[@id='fk-header-search-form']/div/div/div[2]/input[1]")).click();
		
		driver.quit();
		driver.close();
	}

	@Test
	public void ExplicitWait()
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://wikipedia.org/wiki/Main_Page");

		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='searchInput']")));

		driver.findElement(By.xpath(".//*[@id='searchInput']")).sendKeys("Selenium");
		driver.findElement(By.xpath(".//*[@id='searchButton']")).click();
		driver.quit();
	}
}