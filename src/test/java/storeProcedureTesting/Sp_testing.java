package storeProcedureTesting;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import org.testng.annotations.Test;

import baseTest.BaseTest;


public class Sp_testing extends BaseTest{

	
	@Test(priority=1)
	void test_storeProceduresExists() throws SQLException
	{
		stmt=con.createStatement();
		rs=stmt.executeQuery("SHOW PROCEDURE STATUS WHERE Name = 'SelectAllcustomer'");
		rs.next();
		Assert.assertEquals(rs.getString("Name"),"SelectAllcustomer");
	}
	
	@Test(priority=2)
	void test_selectAllCustomers() throws SQLException
	{
		cstmt = con.prepareCall("{call SelectAllcustomer}");
		rs1=cstmt.executeQuery();
		
		Statement stmt = con.createStatement();
		rs2=stmt.executeQuery("select * from customers;");
		
		Assert.assertEquals(compareResultSets(rs1,rs2),true);
	}
	
	public boolean compareResultSets(ResultSet resultset1,ResultSet resultset2) throws SQLException
	{
		while(resultset1.next())
		{
			resultset2.next();
			int count = resultset1.getMetaData().getColumnCount();
			for(int i=1;i<=count;i++)
			{
				if(!StringUtils.equals(resultset1.getString(i),resultset2.getString(i)))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	@Test(priority=3)
	void test_SelectAllCustomersByCityAndPin() throws SQLException
	{
		cstmt = con.prepareCall("{call SelectAllCustomerByCityAndPin(?,?)}");
		cstmt.setString(1,"Singapore");
		cstmt.setString(2,"079903");
		rs1=cstmt.executeQuery();
		
		Statement stmt = con.createStatement();
		rs2=stmt.executeQuery("select * from Customers where city = 'Singapore' and postalCode='079903';");
		
		Assert.assertEquals(compareResultSets(rs1,rs2),true);
	}
	
	@Test(priority=4)
	void test_get_order_by_cust() throws SQLException
	{
		cstmt=con.prepareCall("{call get_order_by_cust(?,?,?,?,?)}");
		cstmt.setString(1, "121");
		
		cstmt.registerOutParameter( 2, Types.INTEGER);
		cstmt.registerOutParameter( 3, Types.INTEGER);
		cstmt.registerOutParameter( 4, Types.INTEGER);
		cstmt.registerOutParameter( 5, Types.INTEGER);
		
		cstmt.executeQuery();
		
		int shipped=cstmt.getInt(2);
		System.out.println(shipped);
		int canceled=cstmt.getInt(3);
		int resolved=cstmt.getInt(4);
		int disputed=cstmt.getInt(5);
		
		//System.out.println(shipped + canceled + resolved + disputed);
		
		Statement stmt = con.createStatement();
		rs=stmt.executeQuery("select (SELECT count(*) as 'shipped' FROM orders WHERE customerNumber = 121 AND status = 'Shipped') as Shipped, (SELECT count(*) as 'canceled' FROM orders WHERE customerNumber = 121 AND status = 'Canceled') as Canceled, (SELECT count(*) as 'resolved' FROM orders WHERE customerNumber = 121 AND status = 'Resolved') as Resolved, (SELECT count(*) as 'disputed' FROM orders WHERE customerNumber = 121 AND status = 'Disputed') as Disputed;");
		
		rs.next();
		
		int exp_shipped=rs.getInt("shipped");
		int exp_canseled=rs.getInt("canceled");
		int exp_resolved=rs.getInt("resolved");
		int exp_disputed=rs.getInt("disputed");
		
		
		if(shipped==exp_shipped && canceled==exp_canseled && resolved == exp_resolved && disputed == exp_disputed)
			Assert.assertTrue(true);
		
		else
			Assert.assertTrue(false);
		
	}
	
	
	@Test(priority=5)
	void test_SetCustomerShipping() throws SQLException
	{
		cstmt=con.prepareCall("{CALL SetCustomerShipping(?,?)}");
		cstmt.setString(1, "141");
		cstmt.registerOutParameter( 2, Types.VARCHAR);
		
		
		cstmt.execute();
		
		String ShippingTime=cstmt.getString(2);
		
		Statement stmt = con.createStatement();
		rs=stmt.executeQuery("SELECT country, CASE WHEN country='USA' THEN '2-day Shipping' WHEN country = 'Canada' THEN '3-day Shipping' ELSE '5-day Shipping' END as ShippingTime FROM customers WHERE customerNumber =141;");
		
		rs.next();
		
		String exp_ShippingTime=rs.getString("ShippingTime");
		
		Assert.assertEquals(ShippingTime, exp_ShippingTime);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
