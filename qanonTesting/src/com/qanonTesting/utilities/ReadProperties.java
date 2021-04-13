package com.qanonTesting.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;

public class ReadProperties 
{
	public static String variableValue = null;
	
	@Test
	public static String readInput(String variableName)
    {
		Properties prop = new Properties();
		try 
		{
			File file = new File(CommonValues.loginFile);
			  
			FileInputStream fileInput = null;
			try 
			{
				fileInput = new FileInputStream(file);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			
			//load properties file
			try 
			{
				prop.load(fileInput);
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}

			variableValue = prop.getProperty(variableName);
	    }
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		return variableValue;
	}
}