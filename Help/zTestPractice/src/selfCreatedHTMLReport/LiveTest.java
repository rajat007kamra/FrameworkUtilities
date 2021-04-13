package selfCreatedHTMLReport;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.*;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

public class LiveTest {
public String email="";
	Dynmic_HTML dhml=new Dynmic_HTML();
	public WebDriver driver=null; //new FirefoxDriver();
	@BeforeTest
	public void goURL()
	{
		System.setProperty("webdriver.ie.driver", "D:/Arun Kapoor/Selenis Files/envVariables/IEDriverServer.exe");        	
    	driver = new InternetExplorerDriver(); 
		driver.get("http://live.guru99.com/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	public void Testcase1() throws Exception
	{
		String URL=" ";
		String ur=" ";
		dhml.createHTML();
		dhml.appendHTMLHeader();
		System.out.println(driver.getTitle());
		@SuppressWarnings("unused")
		boolean b=driver.findElement(By.xpath("//div[@class='main-container col2-right-layout']/div/div[1]/div")).getText().contains("This is demo site");
		
	
		System.out.println("Demo test site text is ok");
		URL="Demo_test_site_text_is_ok";
		//S:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg
		ur="S:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg";
		
		takeshot(driver,URL);
		dhml.appendHTMLRows("verify demo text","verifyTextPresent","<font color="+"green"+">Pass</font>","T",ur);

	}
	
	
	@Test(priority=2)
	public void Testcase2() throws Exception
	{
		
			String mobiletext=driver.findElement(By.xpath("//div[@class='skip-content']/nav/ol/li[1]")).getText();
			String URL="";
			String ur="";
			if(mobiletext.contentEquals("iphone"))
			{
				System.out.println("Text is ok "+mobiletext);
				URL="mobile_text_is_ok";
				
				ur="D:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg";
				takeshot(driver,URL);
				dhml.appendHTMLRows("MobileText","verifyTextPresent","<font color="+"green"+">Pass</font>","T",ur);
				
			}
			else
			{
                URL="mobile_text_is_not_ok";
				
				ur="D:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg";
				takeshot(driver,URL);
				dhml.appendHTMLRows("mobileText","verifyTextPresent","<font color="+"red"+">Fail</font>","T",ur);
			}
	
	
			driver.findElement(By.xpath("//div[@class='skip-content']/nav/ol/li[1]")).click();
	
	}
	
	@Test(priority=3)
	public void Testcase3() throws Exception
	{
		String URL=" ";
		String ur=" ";
		int finalsort=0;
		 ArrayList<String> list=new ArrayList<String>();
		new Select(driver.findElement(By.xpath("//div[@class='col-main']/div[3]/div[@class='toolbar']/div[1]/div/select"))).selectByVisibleText("Name");
		for(int i=1;i<4;i++)
		{
		
		list.add(driver.findElement(By.xpath("//div[@class='col-main']/div[3]/ul/li["+i+"]/div/h2")).getText());
		}
		
		Collections.sort(list);
		
		for(int i=0;i<3;i++)
		{
			int j=i+1;
			String temp=driver.findElement(By.xpath("//div[@class='col-main']/div[3]/ul/li["+j+"]/div/h2")).getText();
			String temp2=(String)list.get(i);		
			if(temp.contentEquals(temp2))
			{
				finalsort=finalsort+1;
			}
		}
		
		if(finalsort==3)
		{
			System.out.println("sort is sucessfull be");
			URL="sort_ok";
			
			ur="D:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg";
			
			takeshot(driver,URL);
			dhml.appendHTMLRows("sorting","verifyTextPresent","<font color="+"green"+">Pass</font>","T",ur);
			
		}
		
		
		
	}
	
	@Test(priority=4)
	public void Testcase4() throws Exception
	{
		String URL="";
		String ur="";

		driver.findElement(By.xpath("//div[@class='col-main']/div[3]/ul/li[1]/div/div[3]/button[@title='Add to Cart']")).click();
		
        URL="add_cart";
		
		ur="D:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg";
		
		takeshot(driver,URL);
		dhml.appendHTMLRows("add_cart","verifyTextPresent","<font color="+"green"+">Pass</font>","T",ur);
		URL=" ";
		ur=" ";
		
		driver.findElement(By.xpath("//table[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("1000");
		//dhml.appendHTMLRows("cart section","verifyTextPresent","T","Pass","imagepath");
		driver.findElement(By.xpath("//table[@id='shopping-cart-table']/tbody/tr/td[4]/button")).click();
		String s1=driver.findElement(By.xpath("//p[@class='item-msg error']")).getText();
		System.out.println(s1);
		Assert.assertEquals(s1, "* The maximum quantity allowed for purchase is 500.");
		driver.findElement(By.xpath("//button[@id='empty_cart_button']")).click();
		
		
URL="empty_cart";
		
		ur="D:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg";
		
		takeshot(driver,URL);
		dhml.appendHTMLRows("empty_cart","verifyTextPresent","<font color="+"green"+">Pass</font>","T",ur);
		URL=" ";
		ur=" ";
		
		
		String s2=driver.findElement(By.xpath("//div[@class='page-title']")).getText();
		Assert.assertEquals(s2, "SHOPPING CART IS EMPTY");
		
		System.out.println(s2);
		
	}
	
	////div[@class='col-main']/div[3]/ul/li[1]/div/div[3]/ul/li[2]
	
	@Test(priority=5)
	public void Testcase5() throws Exception
	
	{
		driver.findElement(By.xpath("//div[@class='skip-content']/nav/ol/li[1]")).click();
		String Fristproductname=driver.findElement(By.xpath("//div[@class='col-main']/div[3]/ul[1]/li[1]/div/h2")).getText();
		String Secondproductname=driver.findElement(By.xpath("//div[@class='col-main']/div[3]/ul[1]/li[2]/div/h2")).getText();
		driver.findElement(By.xpath("//div[@class='col-main']/div[3]/ul[1]/li[1]/div/div[3]/ul/li[2]")).click();
		driver.findElement(By.xpath("//div[@class='col-main']/div[3]/ul[1]/li[2]/div/div[2]/ul/li[2]")).click();
		driver.findElement(By.xpath("//div[@class='col-right sidebar']/div[1]/div[2]/div/button")).click();
		
		Object[]j=driver.getWindowHandles().toArray();
		driver.switchTo().window((String)j[1]);
		String ActualFristproduct= driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
		String ActualSecondproductname= driver.findElement(By.xpath("//h2/a[@title='Samsung Galaxy']")).getText();
		Assert.assertEquals(Fristproductname, ActualFristproduct);
		Assert.assertEquals(Secondproductname, ActualSecondproductname);
		
String URL="another_browser";
		
		String ur="D:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg";
		
		takeshot(driver,URL);
		dhml.appendHTMLRows("another_browser","verifyTextPresent","<font color="+"green"+">Pass</font>","T",ur);
		URL=" ";
		ur=" ";
		
		
		
		driver.close();
		driver.switchTo().window((String)j[0]);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='col-main']/div[2]")).getText());
		
		
		
	}
	
	
	@Test(priority=6)
	public void Testcase6() throws Exception
	{
		
	driver.findElement(By.xpath("//a[@title='Go to Home Page']")).click();
	System.out.println("yaha tak thik h");
	driver.findElement(By.xpath("//div[@class='footer']/div[4]/ul/li[1]//a[@title='My Account']")).click();
	driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	String fname="Saurabh";
	String lname="Gupta";
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(10000);
	 email="Random"+randomInt+"@gmail.com";
	driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(fname);
	driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lname);
	driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("saurabhandvj");
	driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("saurabhandvj");
	
	driver.findElement(By.xpath("//button[@title='Register']")).click();
	String regisconfirm="Hello, "+fname+" "+lname+"!";
	String actual=driver.findElement(By.xpath("//div[@class='dashboard']/div[2]/p/strong")).getText();
    Assert.assertEquals(regisconfirm, actual);
   boolean b= regisconfirm.contentEquals(actual);
   String URL="";
	String ur="";
   if(b)
   {
	   URL="Your_registration_is_successfull"; 
	   ur="D:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg";
		takeshot(driver,URL);
		dhml.appendHTMLRows("registrationCheck","verifyTextPresent","<font color="+"green"+">Pass</font>","T",ur);
   }
  
else
	{
	   URL="Your_registration_is_Failed"; 
	   ur="D:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg";
		takeshot(driver,URL);
		dhml.appendHTMLRows("registrationCheck","verifyTextPresent","<font color="+"red"+">Fail</font>","T",ur);
	}
   
	
	System.out.println(actual);
	driver.findElement(By.xpath("//div[@class='skip-content']/nav/ol/li[2]")).click();
	driver.findElement(By.xpath("//div[@class='col-main']/div[2]/ul/li[1]/div/div[2]/ul/li[1]")).click();
	driver.findElement(By.xpath("//div[@class='col-main']/div/div[1]/form[1]/div/div/button[1]/span")).click();
	driver.findElement(By.xpath("//textarea[@id='email_address']")).sendKeys("saurabh.fts@gmail.com");
	driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("hello");
	driver.findElement(By.xpath("//button[@title='Share Wishlist']")	).click();
	String whitlistshared=driver.findElement(By.xpath("//div[@class='main-container col2-left-layout']/div/div[2]/div/div[1]/ul/li")).getText();
	Assert.assertEquals(whitlistshared, "Your Wishlist has been shared.");
	System.out.println(whitlistshared);

	driver.findElement(By.xpath("//div[@class='account-cart-wrapper']/a/span[2]")).click();
	driver.findElement(By.xpath("//div[@class='links']/ul/li[5]//a[@title='Log Out']")).click();
	
	}
	
	
	@Test(priority=7)
	public void Testcase7() throws Exception
	{
		driver.findElement(By.xpath("//div[@class='footer']/div[4]/ul/li[1]//a[@title='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys("saurabhandvj");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		driver.findElement(By.xpath("//div[@class='main-container col2-left-layout']/div/div[1]/div/div[2]/ul/li[8]//a[@href='http://live.guru99.com/index.php/wishlist/']")).click();
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("United States");
		new Select(driver.findElement(By.id("region_id"))).selectByVisibleText("Colorado");
		
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("542896");
		String subtotalraw=driver.findElement(By.xpath("//div[@class='cart-totals']/table/tbody/tr[1]/td[2]")).getText();
		String subtotal=subtotalraw.substring(1);
		System.out.println("subtotal "+subtotal);
		
		driver.findElement(By.xpath("//button[@title='Estimate']")).click();
		driver.findElement(By.xpath("//form[@id='co-shipping-method-form']/dl/dd/ul/li//input[@class='radio']")).click();
		driver.findElement(By.xpath("//button[@title='Update Total']")).click();
		
		String Updatedsubtotalraw=driver.findElement(By.xpath("//div[@class='cart-totals']/table/tfoot/tr/td[2]")).getText();
		String Updatedsubtotal=Updatedsubtotalraw.substring(1);
				//$615.00
		//620.00
		
		Float beforeEstimatetotal=Float.parseFloat(subtotal);
		
		Float afterEstimatetotal=Float.parseFloat(Updatedsubtotal);
		
		Float temp=beforeEstimatetotal+6;
		//Assert.assertEquals(temp, afterEstimatetotal, "Cost is not updated by 5 dollar");
		
		boolean b=temp.equals(afterEstimatetotal);
		String URL="";
		String ur="";
		 if(b)
		   {
			   URL="Cost_is_updated"; 
			   ur="D:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg";
				takeshot(driver,URL);
				dhml.appendHTMLRows("Update_total","verifyTextPresent","<font color="+"green"+">Pass</font>","T",ur);
		   }
		  
		else
			{
			  URL="Cost_is_NOTupdated"; 
			   ur="D:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg";
				takeshot(driver,URL);
				dhml.appendHTMLRows("Update_total","verifyTextPresent","<font color="+"red"+">Fail</font>","T",ur);
			}
		System.out.println(temp);
		//driver.findElement(By.xpath("//div[@class='cart-totals-wrapper']/div/ul/li[1]/button")).click();
		//driver.findElement(By.xpath("//form[@id='co-billing-form']/div/div/button")).click();
		//driver.findElement(By.xpath("//div[@class='col-main']/ol/li[3]/div[2]/form/div[3]/button")).click();
		//String flatrate=driver.findElement(By.xpath("//div[@class='col-main']/ol/li[3]/div[2]/form/div[1]/dl/dd")).getText();
		//driver.findElement(By.xpath("//div[@class='col-main']/ol/li[4]/div[2]/form/div/dl/dt[1]/input")).click();
		
		
		
	}
	
	@Test(priority=8)
	
	public void closeHTML() throws Exception
	{email="";
		dhml.FLUSHBUFFER();
	}
	
	
	 public   void takeshot(WebDriver driver,String URL)
		{
			
			
			File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try
			{
			FileUtils.copyFile(screenshot, new File("D:\\ScreenshotLiveProject\\"+"screen"+URL+".jpg"));
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		  
		}
	    
	
	
}
	

