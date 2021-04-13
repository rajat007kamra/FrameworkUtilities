package linkRelated;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class NavigateLinks 
{
	private static WebDriver driver = null;
	
	 public static void main(String[] args) throws InterruptedException {
		 
		String homePage = "https://www.atlassian.com/legal/customer-agreement";
        String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.ie.driver", projectPath+"/envVariables/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        
        driver.manage().window().maximize();        
        driver.get(homePage);

	 List<WebElement> demovar=driver.findElements(By.tagName("a"));
	 System.out.println("Total No of Links:- " +demovar.size());

	 ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag

	    for (WebElement var : demovar) {
	        System.out.println(var.getText()); // used to get text present between the anchor tags
	        System.out.println(var.getAttribute("href"));
	        hrefs.add(var.getAttribute("href")); 
	        System.out.println("*************************************");
	    }

	    //Navigating to each link
	    int i=0;
	    for (String href : hrefs) {
	        driver.navigate().to(href);
	        System.out.println((++i)+": navigated to URL with href: "+href);
	        Thread.sleep(3000); // To check if the navigation is happening properly.
	        System.out.println("Navigated");
	    }
	 }
}
