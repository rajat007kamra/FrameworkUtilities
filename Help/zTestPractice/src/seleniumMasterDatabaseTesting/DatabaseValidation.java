package seleniumMasterDatabaseTesting;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatabaseValidation 
{
	private WebDriver driver = null;
	  private Connection con = null;
	  private Statement stmt = null;
	  String baseUrl;

	  @Before
	  public void setUp() throws Exception {
	    // use firefox browser
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.testexample.com";
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  }

	  @Test
	  public void test() throws SQLException, ClassNotFoundException {
	    // Load Microsoft SQL Server JDBC driver.
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    // Prepare connection url.
	    String url = "jdbc:sqlserver://192.168.1.5:1433;DatabaseName=UserInfo";
	    // Get connection to DB.
	    con = DriverManager.getConnection(url, "sa", "12345678");
	    // Create statement object which would be used in writing DDL and DML
	    // SQL statement.
	    stmt = con.createStatement();
	    // Send SQL SELECT statements to the database via the
	    // Statement.executeQuery
	    // method which returns the requested information as rows of data in a
	    // ResultSet object.
	    // define query to read data
	    try 
	    {
	    	String query = "select * from userlogin";
	    	ResultSet result = stmt.executeQuery(query);
	    	if (result.next()) {
	        while (result.next()) {
	          // Fetch value of "username" and "password" from "result"
	          // object; this will return 2 existing users in the DB.

	         
	          String username = result.getString("username");
	          String password = result.getString("userpassword");
	          // print them on the console
	          System.out.println("username :" + username);
	          System.out.println("password: " + password);
	        }
	        result.close();
	      }
	    }

	    catch (SQLException ex) {
	      System.out.println(ex);
	    }
	    // Add a new user on the UI
	    String newtestusername = "newuser";
	    String newtestuserpassword = "newuser";
	    // navigate to the site
	    driver.get(baseUrl + "/register.php");
	    // set new user name "NewTestUser"
	    driver.findElement(By.id("userID")).sendKeys(newtestusername);
	    // set new user password for the new user "NewTestUser"
	    driver.findElement(By.id("password")).sendKeys(newtestuserpassword);
	    // click on Add User button
	    driver.findElement(By.id("AddUser")).click();
	    // verify the welcome message displayed
	    System.out.println("Is welcome message displayed: " + isElementPresent(By.xpath("//*[contains(.,'Welcome back ')]")));

	    // verify the new user in the database
	    // create a query
	    String newuserquery = "SELECT * From userlogin where username=?";
	    // create a statement
	    PreparedStatement stat = con.prepareStatement(newuserquery);
	    stat.setString(1, newtestusername);
	    try {
	      boolean hasResultSet = stat.execute();
	      if (hasResultSet) {
	        ResultSet result = stat.getResultSet();
	        // get new user name from the table

	        String newusername = result.getString("username");
	        // assert that new user name should be
	        assertEquals(newtestusername, newusername);
	      }
	    } catch (SQLException ex)

	    {
	      System.out.println(ex);
	    } finally {
	      con.close();
	    }

	  }

	  @After
	  public void tearDown() throws Exception 
	  {
	    // close the driver
	    driver.close();
	  }

	  private boolean isElementPresent(By by) 
	  {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
}