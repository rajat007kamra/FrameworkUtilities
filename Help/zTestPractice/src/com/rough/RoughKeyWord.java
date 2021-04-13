package com.rough;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class RoughKeyWord {
	static int rowCount =0;
	static int colCount=0;
	
	
	public static String[][] dataSet(String filePath,int sheetIndex) throws BiffException, IOException
	{
		//String masterSheetPath =System.getProperty("user.dir")+"/KeywordTestCase/MasterTestNameSheet.xls";
		String testCasePath =filePath;
		File fo = new File(testCasePath);		
		Workbook mstr_WB = Workbook.getWorkbook(fo);
		Sheet testcasepathSheet= mstr_WB.getSheet(sheetIndex);
				
		rowCount=testcasepathSheet.getRows();
		colCount=testcasepathSheet.getColumns();
		String[][] alltestCases= new String[rowCount-1][colCount];
		Cell celldata=null;
		System.out.println(rowCount +"  "+colCount);
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				celldata=testcasepathSheet.getCell(j,i);
				//System.out.print(celldata.getContents());
				alltestCases[i-1][j]=celldata.getContents();
				//System.out.print (" ");
			}
			
		}
		
		return alltestCases;
		
	}

	public static void keyExecution(String className, String methodname, Object... a)
	{
		 
		Class<?> params[] = new Class[a.length];
		
		 for(int i=0;i<a.length;i++)
		 {
			// System.out.println(java.util.Arrays.toString((Object[]) a)) ;
			//System.out.println(a[i] instanceof String);
			if(a[i] instanceof String) 
			{
				params[i] = String.class;
			}
		 }
		 
		 try {
			Class<?> cls = Class.forName(className);
			Object obj = cls.newInstance();
			Method mtd = cls.getDeclaredMethod(methodname, params);
			mtd.invoke(obj, a);
			
		} catch (ClassNotFoundException e) {
			System.out.println(" Class excp");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.err.format("Method invoked with wrong number of arguments%n");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
	
	
	
}
