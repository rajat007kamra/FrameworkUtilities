package readExcelUsing_KeyValue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBoxFormTest 
{
	String successMsg = null; String cpAgreementText = null; String cpDF2Text = null;
	WebDriver driver = null;
	File file = new File(projectPath +"/testData/TextBoxFormTest.xlsx");
	static String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void startApp() throws InterruptedException
	{
		System.setProperty("webdriver.ie.driver", projectPath+"/envVariables/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://10.120.0.138:8080/NAXIOSCO/?login");
	}
	@Test(priority=1)
	public void openCounterpartyPage() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.findElement(By.name("userName")).sendKeys("le");
		driver.findElement(By.name("password")).sendKeys("test");
		Thread.sleep(4000);
		driver.findElement(By.id("btnLogin")).click();
	}
	@Test(priority=2)
	public void closeNotifications() {
		try
		{	Thread.sleep(4000);
			driver.findElement(By.xpath("//html/body/div[9]/div[1]/div/div/div/div/table/tbody/tr/td/div")).click();
			System.out.println("Notification PopUp Closed Successfully");
			Thread.sleep(5000);
			driver.findElement(By.id("CreateCounterparty")).click();
			Thread.sleep(5000);
			
		} catch(Exception ex) {
			System.out.println("Notification PopUp Not Found or Login Failed or Page not found. Check Logs");
		}
	}
	@Test(priority=3)
	public void ExecuteTest()
	{
		try
		{
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook Workbook = new XSSFWorkbook(inputStream);
			XSSFSheet  Sheet = Workbook.getSheet("Sheet2");
			
			int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
			HashMap<String, Integer> mappingConfigMap = new HashMap<String,Integer>();
			
			for (int i = 1; i < rowCount+1; i++)
			{	 
				XSSFRow row = Sheet.getRow(i);
			    mappingConfigMap.put(row.getCell(0).getStringCellValue(), Integer.parseInt(row.getCell(1).getRawValue()));
			}
			
			XSSFSheet  Sheet1 = Workbook.getSheet("Sheet1");
			int rowCount1 = Sheet1.getLastRowNum()-Sheet1.getFirstRowNum();
			for (int i = 1; i < rowCount1+1; i++)
			{	 
				XSSFRow row = Sheet1.getRow(i);
				for (HashMap.Entry<String,Integer> entry : mappingConfigMap.entrySet()) {				
					driver.findElement(By.name(entry.getKey())).sendKeys(row.getCell(entry.getValue()).getStringCellValue());
					Thread.sleep(2000);
				}
				
			    driver.findElement(By.id("save")).click();
				Thread.sleep(2000);				
				expectedMessages();
			    Thread.sleep(4000);
				
			    driver.findElement(By.id("CreateCounterparty")).click();
			    Thread.sleep(4000);
			    inputStream.close();
			    updateExcel(Workbook,i);
			}
			Workbook.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void expectedMessages() throws InterruptedException
	{
		successMsg = driver.findElement(By.id("successMessageLabelContainer")).getText();
	    System.out.println("Successful Message Found ::- " +successMsg);
	    
	    String errorMsg = driver.findElement(By.id("errorLabelContainer")).getText();
	    System.out.println("Error Message Found ::- " +errorMsg);
	    
	    cpAgreementText = driver.findElement(By.id("addAgreement")).getText();
	    System.out.println("Agreement Found ::- " +cpAgreementText);
	    
	    cpDF2Text = driver.findElement(By.id("df2ProtocolData")).getText();
	    System.out.println("DF Protocol Message Found ::- " +cpDF2Text);
	    
	    Thread.sleep(4000);
	}
	
	public void updateExcel(XSSFWorkbook Workbook, int i) throws IOException
	{
		//Try to writing in File Here
	    FileOutputStream out = new FileOutputStream(file);
	    
	    String temp=  Workbook.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
	    System.out.println("Temp Values ::- " +temp);
	    
	    String greenMsg=  Workbook.getSheet("Sheet1").getRow(i).getCell(6).getStringCellValue();
	    //System.out.println("Success Message Found ::- " +greenMsg);
	    
	    String addMsg=  Workbook.getSheet("Sheet1").getRow(i).getCell(7).getStringCellValue();
	    //System.out.println("Agreement Button Text Found ::- " +addMsg);
	    
	    String df2Msg=  Workbook.getSheet("Sheet1").getRow(i).getCell(8).getStringCellValue();
	    //System.out.println("DF2 Button Text Found ::- " +df2Msg);
	  
	    /* Create XSSFFont object from the workbook */
		XSSFFont myfont = Workbook.createFont();
		 /* Get access to XSSFCellStyle */
        XSSFCellStyle mystyle = Workbook.createCellStyle();
        /* Also make the font color to RED */
		myfont.setColor(XSSFFont.COLOR_RED);
        /* attach the font to the style created earlier */
		mystyle.setFont(myfont);
		
		if(successMsg.contentEquals(greenMsg) && cpAgreementText.contentEquals(addMsg) && cpDF2Text.contentEquals(df2Msg))
		{
			XSSFRow passRow = Workbook.getSheet("Sheet1").getRow(i);
		    System.out.println("ARUN KAPOOR::- " +passRow.getCell(1).getStringCellValue());
		    XSSFCell passCell = passRow.createCell(0);
		    passCell.setCellValue("PASS");
		    
	       Workbook.write(out);
	       out.close();	
		} else {
			
			  XSSFRow failRow = Workbook.getSheet("Sheet1").getRow(i);
			  System.out.println("RAHUL JAIN::- " +failRow.getCell(1).getStringCellValue());
			  XSSFCell failCell = failRow.createCell(0);
			  failCell.setCellValue("FAIL");
			  failCell.setCellStyle(mystyle);
			  
			  Workbook.write(out);
			  out.close();
		  }
	}
}