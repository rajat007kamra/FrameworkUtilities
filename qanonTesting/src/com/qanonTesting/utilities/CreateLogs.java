package com.qanonTesting.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateLogs 
{
	//Method to create Log File
	public static void createNewLogFile() throws IOException, InterruptedException
	{
		File file = new File(CommonValues.logFileName);
		//if file doesn't exists, then create it
		if (!file.exists()) 
		{
			file.createNewFile();
		}
		else if (file.exists()) 
		{
			file.delete();
//			Thread.sleep(2000);
			file.createNewFile();
		}
		else
		{
			CreateLogs.writeLogs("System Unable to Create Log File");
		}
	}
	
	//Method for writing logs messages in Log File
	public static void writeLogs(String content)
	{
		BufferedWriter bw = null;
		FileWriter fw = null;
		try 
		{
			File file = new File(CommonValues.logFileName);

			fw = new FileWriter(file.getAbsoluteFile(), true);	// true = append file
			bw = new BufferedWriter(fw);
			bw.write("\n");
			bw.write(CommonMethods1.GetCurrentTimeStamp() +" - " +content);
			System.out.println(CommonMethods1.GetCurrentTimeStamp() +" - " +content);
		} catch (IOException e) {

			e.printStackTrace();
		}
		finally 
		{
			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} 
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}
	}
	
	//Method to get current Date and Time
	public static String GetCurrentTimeStamp() 
	{
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");		// dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
	
	//Method for maintaining the previous logs by renaming previous file 
	public static void renameLogFile()
	{
		File f1 = new File(CommonValues.logFileName);
		//System.err.println(f1);
		
		String extensionRemoved = CommonValues.logFileName.split("\\.")[0];
		//System.out.println(extensionRemoved);
		
		File f2 = new File(extensionRemoved +"_" +CreateLogs.GetCurrentTimeStamp().replace(":","_").replace(".","_")+".txt");
		//System.out.println(f2);
		boolean b = f1.renameTo(f2);
		System.out.println(b);
		//System.out.println(b);
	}
}