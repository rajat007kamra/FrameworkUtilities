package com.qanonTesting.utilities;

import java.text.DecimalFormat;

import org.testng.annotations.Test;

public class Percentile {
	
	public static String Percentile_Rank(double Total_Item, double[] Total_List, double percentile_90_95)
	{
//		System.out.println(Total_Item);
		double R;
		//double Percentile_90=90;
		R = (percentile_90_95/100)*(Total_Item+1);
//		System.out.println(R);
		int Preceeding_Index = (int)R;
		double Remainder_Value= R-Preceeding_Index;
//		System.out.println(Preceeding_Index);
//		System.out.println(Remainder_Value);
		double FirstValue=Total_List[Preceeding_Index-1];		
		double Percentile_Value;
		if (Total_List.length == Preceeding_Index)
		{
			Percentile_Value = Total_List[Preceeding_Index-1];
//			System.out.println("I am first");
		}
		else
		{
			double SecondValue = Total_List[Preceeding_Index];
			Percentile_Value = FirstValue+(Remainder_Value*(SecondValue-FirstValue));
		}
		
		DecimalFormat df = new DecimalFormat("####0.00");
		System.out.println((int)percentile_90_95+" P Value is "+df.format(Percentile_Value));
		
		String abc = df.format(Percentile_Value);
//		System.out.println("ABC means percentile_90_95 - " +abc);
		return abc;
	}

	public static String findPercentile(String minValue, String maxValue, double percentile)
	{
		double[] myList = {Double.parseDouble(minValue), Double.parseDouble(maxValue)};		
//		System.out.println(myList.length);
		// Print all the array elements
	      for (int i = 0; i < myList.length; i++) {
	         System.out.println(myList[i] + " ");
	      }
	 return Percentile_Rank(myList.length, myList, percentile);	
	}
	
	@Test(enabled=false)
	public static void abcd()
	{
		findPercentile(Double.toString(0.08), Double.toString(5.12), 90);
	}
}