package manyExamples;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class log4jexample 
{
	WebDriver driver = null;	
	Logger log = Logger.getLogger(log4jexample.class.getName());
	
	@Test
	public void init()
	{
		driver = new FirefoxDriver();
		//DOMConfigurator.configure("Log4j.properties");
		PropertyConfigurator.configure("Log4j.properties");
		
		log.info("**********************************************************");
		log.info("Browser Opened");
	}
	
	@Test
	public void quit()
	{
		driver.close();
		log.info("Browser Closed");
	}

}