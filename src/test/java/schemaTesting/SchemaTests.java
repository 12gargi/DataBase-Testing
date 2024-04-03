package schemaTesting;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SchemaTests {
	
	           
		    Connection con =null;
			ResultSet rs;
			CallableStatement cstmt;

			    @BeforeClass
				void setup() throws SQLException
				{
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","root");
				}
				
				
				@AfterClass
				void tearDown() throws SQLException
				{
					con.close();
					
				}
				
				
				@Test(priority=1)
				void test_TablePresenceInDatabase() throws SQLException {
					
	            Statement stmt = con.createStatement();
	            rs = stmt.executeQuery("show tables");
	            
				}
				
				@Test(priority=2)
				void test_CheckNnumberofcolumnsinatable() throws SQLException 
				{
					
		          Statement stmt = con.createStatement();
		          rs = stmt.executeQuery("SELECT count(*) AS NumberOfColumns FROM information_schema.columns WHERE table_name ='customers'");

				}

	            
				@Test(priority=3)
				void test_CheckColumnNamesInATable() throws SQLException 
				{
					
		          Statement stmt = con.createStatement();
		          rs = stmt.executeQuery("SELECT Column_name FROM information_schema.columns WHERE table_name='customers'");

				}

				@Test(priority=4)
				void test_CheckDataTypeOfColumnsInTable() throws SQLException 
				{
					
		          Statement stmt = con.createStatement();
	            rs = stmt.executeQuery("SELECT column_name, data_type FROM information_schema.columns WHERE table_name='customers'");
				}


				@Test(priority=5)
				void test_checkSizeOfTheColumnsInATable() throws SQLException 
				{
					
		          Statement stmt = con.createStatement();
	            rs = stmt.executeQuery("SELECT column_name, column_type FROM information_schema.columns WHERE table_name='customers'");
				}

				@Test(priority=6)
				void test_CheckNullsFieldInATable() throws SQLException 
				{
					
		          Statement stmt = con.createStatement();
	            rs = stmt.executeQuery("SELECT column_name, is_nullable FROM information_schema.columns WHERE table_name='customers'");
				}
	            
				@Test(priority=7)
				void test_CheckColumnKeysInATable() throws SQLException 
				{
					
		          Statement stmt = con.createStatement();
	            rs = stmt.executeQuery("SELECT column_name, column_key FROM information_schema.columns WHERE table_name='customers'");
	            
				}
	            

}
