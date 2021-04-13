package manyExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JIRA {
	WebDriver driver = null;	
	
	@BeforeClass
	public void init() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://dg2development.atlassian.net/login?");
	}
	
	@Test
	public void MouseHover() throws InterruptedException{
		Thread.sleep(3000);		// Explicit Wait
		// Mouse Hover
		Actions a1 = new Actions(driver);
		WebElement hover = driver.findElement(By.xpath("/html/body/div/header/nav/div/div[2]/ul/li/a"));
		a1.moveToElement(hover).click().build().perform();
		
		
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		Actions a2 = new Actions(driver);
		WebElement hoverDoc = driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[2]/a"));		
		a2.moveToElement(hoverDoc).build().perform();
	}

	@Test
	public void selectDropdown() throws InterruptedException	{
		driver.findElement(By.id("username")).sendKeys("AKapoor");
		driver.findElement(By.id("password")).sendKeys("Arun@725043");
		driver.findElement(By.id("login")).click();
		Thread.sleep(4000);		
		driver.navigate().to("https://dg2development.atlassian.net/secure/ConfigurePortalPages!default.jspa?view=search");		
		
		Thread.sleep(3000);      // Explicit Wait
		
		
		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 10);		 
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("share_type_selector")));
		System.out.println(element1);
		
		// Select dropdown value
		Select dropdown = new Select(driver.findElement(By.id("share_type_selector")));
		//dropdown.selectByIndex(1);		//dropdown.selectByValue("project");
		dropdown.selectByVisibleText("Project");		
	}
}