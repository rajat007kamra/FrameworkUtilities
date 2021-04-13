package manyExamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testingTestNG 
{
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("1. BeforeClass");
		System.out.println("\n");
	}
	
	@BeforeTest
    public void beforetest()
	{
		System.out.println("2. BeforeTest");
		System.out.println("\n");
    }
	
	@BeforeMethod
	public void beforemethod()
	{
		System.out.print("3. BeforeMethod");
	}
	
	@Test
	public void toBeforeMethod()
	{
		System.out.println("\n" +"4. Test-1");
	}
	
	@Test
	public void toBeforeTest()
	{
		System.out.println("\n" +"5. Test-2");
	}
	
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("6. AfterMethod");
		System.out.println("\n");
	}
	
	@AfterTest
	public void aftertest()
	{
		System.out.println("7. AfterTest");
		System.out.println("\n");
	}
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("8. AfterClass");
		System.out.println("\n");
	}
	
	@BeforeSuite
	public void beforesuit()
	{
		System.out.println("9. BeforeSuit");
		System.out.println("\n");
	}
	
	@BeforeGroups
	public void beforegroups()
	{
		System.out.println("10. BeforeGroups");
		System.out.println("\n");
	}
	
	@AfterGroups
	public void aftergroups()
	{
		System.out.println("11. AfterGroups");
		System.out.println("\n");
	}
	
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("12. AfterClass");
		System.out.println("\n");
	}
}