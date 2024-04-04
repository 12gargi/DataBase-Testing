package schemaTesting;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import source.BaseTest;

public class SchemaTests extends BaseTest {
				
				@Test(priority=1)
				public void test_TablePresenceInDatabase() throws SQLException {
					
	            Statement stmt = con.createStatement();
	            rs = stmt.executeQuery("show tables");
	           
	            
				}
				
				@Test(priority=2)
				public void test_CheckNnumberofcolumnsinatable() throws SQLException 
				{
					
		          Statement stmt = con.createStatement();
		          rs = stmt.executeQuery("SELECT count(*) AS NumberOfColumns FROM information_schema.columns WHERE table_name ='customers'");

				}

	            
				@Test(priority=3)
				public void test_CheckColumnNamesInATable() throws SQLException 
				{
					
		          Statement stmt = con.createStatement();
		          rs = stmt.executeQuery("SELECT Column_name FROM information_schema.columns WHERE table_name='customers'");

				}

				@Test(priority=4)
				public void test_CheckDataTypeOfColumnsInTable() throws SQLException 
				{
					
		          Statement stmt = con.createStatement();
	            rs = stmt.executeQuery("SELECT column_name, data_type FROM information_schema.columns WHERE table_name='customers'");
				}


				@Test(priority=5)
				public void test_checkSizeOfTheColumnsInATable() throws SQLException 
				{
					
		          Statement stmt = con.createStatement();
	            rs = stmt.executeQuery("SELECT column_name, column_type FROM information_schema.columns WHERE table_name='customers'");
				}

				@Test(priority=6)
				public void test_CheckNullsFieldInATable() throws SQLException 
				{
					
		          Statement stmt = con.createStatement();
	            rs = stmt.executeQuery("SELECT column_name, is_nullable FROM information_schema.columns WHERE table_name='customers'");
				}
	            
				@Test(priority=7)
				public void test_CheckColumnKeysInATable() throws SQLException 
				{
					
		          Statement stmt = con.createStatement();
	            rs = stmt.executeQuery("SELECT column_name, column_key FROM information_schema.columns WHERE table_name='customers'");
	            
				}
	            

}
