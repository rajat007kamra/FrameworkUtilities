package com.qanonTesting.processMenu;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qanonTesting.login.tests.*;
import com.qanonTesting.utilities.CommonMethods1;
import com.qanonTesting.utilities.CommonValues;
import com.qanonTesting.utilities.FunctionLibraries1;

public class Contracts 
{
	@Test
	public static void contractPage() throws Exception
	{
		CommonMethods1.openApplication();
		Login3.verify_Login("ARUN.KAPOOR", "Monitor@2020");
		
		
		CommonMethods1.searchPage("CONTRACTS", "", "CONTRACTS PAGE OPENED SUCCESSFULLY");
		Thread.sleep(10000);
		CommonMethods1.closeExistingTab(CommonValues.processesModule);
		
		Thread.sleep(15000);
		CommonMethods1.searchProcessRecord("", "", "", "BOT11A-4590022017", "CONTRACTS");
		
		Thread.sleep(15000);
		WebElement contractId = FunctionLibraries1.locator("xpath", "//div[@class='REALM-BDY-RGHT REALM-BDY-EL REALM-BDY-RGHT-PRIZE HAS-TRANS-300']//div[@class='EZ-WGT-FLEX-SCT EZ-WGT-FLEX-SCT-DETAILS EZ-WGT-FLEX-SCT-DETAILS-MAIN']//div[5]//div[5]//div[1]");
		contractId.click();
		Thread.sleep(5000);
		String contractValue = contractId.getAttribute("title");
		System.out.println("CONTRACT ID VALUE IS ::- " +contractValue);
	}
}
