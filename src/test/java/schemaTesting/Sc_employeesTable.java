package schemaTesting;

import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import source.BaseTest;

public class Sc_employeesTable extends BaseTest  {

				
					
					@Test(priority=1)
					public void test_CheckNnumberofcolumnsinaemployeestable() throws SQLException 
					{
						
			          Statement stmt = con.createStatement();
			          rs = stmt.executeQuery("SELECT count(*) AS NumberOfColumns FROM information_schema.columns WHERE table_name ='employees'");

					}

		            
					@Test(priority=2)
					public void test_CheckColumnNamesInAemployeesTable() throws SQLException 
					{
						
			          Statement stmt = con.createStatement();
			          rs = stmt.executeQuery("SELECT Column_name FROM information_schema.columns WHERE table_name='employees'");

					}

					@Test(priority=3)
					public void test_CheckDataTypeOfColumnsInemployeesTable() throws SQLException 
					{
						
			          Statement stmt = con.createStatement();
		            rs = stmt.executeQuery("SELECT column_name, data_type FROM information_schema.columns WHERE table_name='employees'");
					}


					@Test(priority=4)
					public void test_checkSizeOfTheColumnsInAemployeesTable() throws SQLException 
					{
						
			          Statement stmt = con.createStatement();
		            rs = stmt.executeQuery("SELECT column_name, column_type FROM information_schema.columns WHERE table_name='employees'");
					}

					@Test(priority=5)
					public void test_CheckNullsFieldInAemployeesTable() throws SQLException 
					{
						
			          Statement stmt = con.createStatement();
		            rs = stmt.executeQuery("SELECT column_name, is_nullable FROM information_schema.columns WHERE table_name='employees'");
					}
		            
					@Test(priority=6)
					public void test_CheckColumnKeysInAemployeesTable() throws SQLException 
					{
						
			          Statement stmt = con.createStatement();
		            rs = stmt.executeQuery("SELECT column_name, column_key FROM information_schema.columns WHERE table_name='employees'");
		            
					}
		            

	}


