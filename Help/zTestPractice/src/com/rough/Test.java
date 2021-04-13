package com.rough;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.read.biff.BiffException;

public class Test {

	public static void main(String[] args) throws BiffException, IOException {
		// TODO Auto-generated method stub

		String masterSheetPath =System.getProperty("user.dir")+"/KeywordTestCase/MasterTestNameSheet.xls";	
		String[][] mstrSheet= RoughKeyWord.dataSet(masterSheetPath, 0);
		for(int i =0;i<mstrSheet.length;i++){			
			//List<String> rowKeys=null;
			
				if(mstrSheet[i][1].equals("Y"))
				{
					String testCaseName = mstrSheet[i][0];
					System.out.println(testCaseName);
					//String[][] testSteps=RoughKeyWord.dataSet(masterSheetPath,testCaseName);
					String[][] testSteps=RoughKeyWord.dataSet(mstrSheet[i][2],0); // form 2nd column it will get the testcase path
					  Object[] paramListObject =null;	
					  String methodName=null;					 
					for(int p =0; p<testSteps.length;p++)
					{				
						 List<Object> rowKeys=new ArrayList<Object>();
						 String paramvls=null;
						  for(int q=2;q<testSteps[p].length-2;q++)
						  {
							  methodName=testSteps[p][1];							 
							  if((testSteps[p][q].length()>0)&!(testSteps[p][q].equals("null")))
							  {
								  paramvls=testSteps[p][q];								  
								  rowKeys.add(paramvls);
							  }
							  paramListObject = new String[rowKeys.size()];
							  paramListObject=rowKeys.toArray(paramListObject);
							  RoughKeyWord.keyExecution("com.utility.FunctionLibrary",methodName, paramListObject);
						  }
					}
				}
				else
				{
				}
				System.out.println("****Finished test case execution****  ");
			 
		}
		
	}

}
