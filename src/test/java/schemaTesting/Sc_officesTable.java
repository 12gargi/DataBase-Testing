package schemaTesting;

import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import source.BaseTest;

public class Sc_officesTable extends BaseTest {
	@Test(priority=1)
	public void test_TablePresenceInDatabase() throws SQLException {
		
    Statement stmt = con.createStatement();
    rs = stmt.executeQuery("show tables");
   
    
	}
	
	@Test(priority=2)
	public void test_CheckNnumberofcolumnsinAofficestable() throws SQLException 
	{
		
      Statement stmt = con.createStatement();
      rs = stmt.executeQuery("SELECT count(*) AS NumberOfColumns FROM information_schema.columns WHERE table_name ='offices'");

	}

    
	@Test(priority=3)
	public void test_CheckColumnNamesInAofficesTable() throws SQLException 
	{
		
      Statement stmt = con.createStatement();
      rs = stmt.executeQuery("SELECT Column_name FROM information_schema.columns WHERE table_name='offices'");

	}

	@Test(priority=4)
	public void test_CheckDataTypeOfColumnsInofficesTable() throws SQLException 
	{
		
      Statement stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT column_name, data_type FROM information_schema.columns WHERE table_name='offices'");
	}


	@Test(priority=5)
	public void test_checkSizeOfTheColumnsInAofficesTable() throws SQLException 
	{
		
      Statement stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT column_name, column_type FROM information_schema.columns WHERE table_name='offices'");
	}

	@Test(priority=6)
	public void test_CheckNullsFieldInAofficesTable() throws SQLException 
	{
		
      Statement stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT column_name, is_nullable FROM information_schema.columns WHERE table_name='offices'");
	}
    
	@Test(priority=7)
	public void test_CheckColumnKeysInAofficesTable() throws SQLException 
	{
		
      Statement stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT column_name, column_key FROM information_schema.columns WHERE table_name='offices'");
    
	}
    

}
