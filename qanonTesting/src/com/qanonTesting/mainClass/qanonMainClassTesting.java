package com.qanonTesting.mainClass;

import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import com.qanonTesting.utilities.*;

public class qanonMainClassTesting 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		JFrame frame = null;
		try 
		{
			CreateLogs.createNewLogFile();
			CreateExcelFile.createWorkbook();
			
			CreateLogs.writeLogs("************AUTOMATION STARTS************");
			CreateLogs.writeLogs("AUTOMATION START DATE & TIME ::- " +CommonMethods1.GetCurrentTimeStamp() +"\n");
			long t1 = new Date().getTime();			
			
			TestListenerAdapter tla = new TestListenerAdapter();
			System.out.println(tla);
			TestNG testng = new TestNG();
			List<String> suites = Lists.newArrayList();
			suites.add(CommonValues.testngFile);
			testng.setTestSuites(suites);
			testng.run();
			CreateLogs.writeLogs("\n");
			CreateLogs.writeLogs("AUTOMATION END DATE & TIME ::- " +CommonMethods1.GetCurrentTimeStamp() +"\n");
			CreateLogs.writeLogs("************AUTOMATION FINISHED************");
			long t2 = new Date().getTime();
			
			DeclareVariables.timeTaken = (t2-t1) +" miliseconds";
			
			Thread.sleep(3000);
			ColorScheme.colorExcel();
			Thread.sleep(3000);
			RemoveDuplicate.consolidateExcel("Performance");
			Thread.sleep(3000);
			RemoveDuplicate.consolidateExcel("Basic");
			Thread.sleep(3000);
			RemoveDuplicate.consolidateExcel("Details");
			Thread.sleep(3000);
			CreateExcelFile.renameExcelResultFile();
			Thread.sleep(3000);
			CreateLogs.renameLogFile();
			Thread.sleep(2000);
			JOptionPane.showMessageDialog(frame, "ALL TEST SCRIPTS SUCCESSFULLY EXECUTED. PLEASE CHECK RESULTS IN OUTPUT FOLDER!!! " + DeclareVariables.timeTaken);
		}
		catch(Exception ex)
		{
			CreateLogs.writeLogs(ex.getMessage());
		}
	}

}
