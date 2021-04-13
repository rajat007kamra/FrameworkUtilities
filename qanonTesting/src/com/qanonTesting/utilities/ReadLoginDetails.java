package com.qanonTesting.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadLoginDetails 
{
	public static String user_name1()
	{
		File file = new File(CommonValues.loginFile);
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String user_name1 = prop.getProperty("userName1");
//		CreateLogs.writeLogs("USERNAME IS ::- " +user_name);
		
		return user_name1;
	}
	
	public static String user_name2()
	{
		File file = new File(CommonValues.loginFile);
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String user_name2 = prop.getProperty("userName2");
//		CreateLogs.writeLogs("USERNAME IS ::- " +user_name);
		
		return user_name2;
	}
	
	public static String user_name3()
	{
		File file = new File(CommonValues.loginFile);
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String user_name3 = prop.getProperty("userName3");
//		CreateLogs.writeLogs("USERNAME IS ::- " +user_name);
		
		return user_name3;
	}
	
	public static String user_password1()
	{
		File file = new File(CommonValues.loginFile);
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String user_password1 = prop.getProperty("password1");
//		CreateLogs.writeLogs("PASSWORD IS ::- " +user_password);
		return user_password1;
	}
	
	public static String user_password2()
	{
		File file = new File(CommonValues.loginFile);
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String user_password2 = prop.getProperty("password2");
//		CreateLogs.writeLogs("PASSWORD IS ::- " +user_password);
		return user_password2;
	}
	
	public static String user_password3()
	{
		File file = new File(CommonValues.loginFile);
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String user_password3 = prop.getProperty("password3");
//		CreateLogs.writeLogs("PASSWORD IS ::- " +user_password);
		return user_password3;
	}
	
	
	/* Method email_Id and body_Message is used in Teams Page for sending email for verfication */
	public static String email_Id()
	{
		File file = new File(CommonValues.loginFile);
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String email_Id = prop.getProperty("email_Id");
//		CreateLogs.writeLogs("PASSWORD IS ::- " +user_password);
		return email_Id;
	}
	
	public static String body_Message()
	{
		File file = new File(CommonValues.loginFile);
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String body_Message = prop.getProperty("body_Message");
//		CreateLogs.writeLogs("PASSWORD IS ::- " +user_password);
		return body_Message;
	}
}