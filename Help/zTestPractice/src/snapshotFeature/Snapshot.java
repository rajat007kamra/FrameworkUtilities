package snapshotFeature;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot; 
import org.openqa.selenium.WebDriver; 

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test; 
public class Snapshot {
 
@Test
public void TestJavaS1(){
 
 // Open Firefox
 WebDriver driver=null;
 String projectPath = System.getProperty("user.dir");
 
 System.setProperty("webdriver.ie.driver", projectPath+"/envVariables/IEDriverServer.exe");			
	driver = new InternetExplorerDriver();
 
// call method
// Snapshot.captureScreenShot(driver);
 
// Maximize the window
driver.manage().window().maximize();
//Snapshot.captureScreenShot(driver);
 
// Pass the url
driver.get("http://www.google.com");
Snapshot.captureScreenShot(driver);
 
  }
 
public static void captureScreenShot(WebDriver ldriver){
// Take screenshot and store as a file format             
 File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);           
try {
// now copy the  screenshot to desired location using copyFile method
 
FileUtils.copyFile(src, new File("C:/selenium/"+System.currentTimeMillis()+".png"));                              
} catch (IOException e)
 
{
  System.out.println(e.getMessage());
 }
  }
 
}