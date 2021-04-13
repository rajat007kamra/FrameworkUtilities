package linkRelated;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrokenLinks {
	private static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

    	String homePage = "https://www.google.co.in/?gfe_rd=cr&ei=pPp1Wdv5IfGK8Qf9u7BI";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        
        String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.ie.driver", projectPath+"/envVariables/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        
        driver.manage().window().maximize();
        
        driver.get(homePage);
        
       /* driver.findElement(By.name("userName")).sendKeys("le");
		driver.findElement(By.name("password")).sendKeys("test");
		driver.findElement(By.id("btnLogin")).click();*/
        Thread.sleep(10000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
            System.out.println(url);
        
            if(url == null || url.isEmpty()) {
        		System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            if(!url.startsWith(homePage)) {
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}