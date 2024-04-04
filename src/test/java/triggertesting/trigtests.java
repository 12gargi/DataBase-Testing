package triggertesting;


import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class trigtests extends BaseTest {

		
	    @Test(priority=1)
	    void test_TotalCapacityUpdate() throws SQLException {
	      
	            Statement stmt = con.createStatement();
	            stmt.executeUpdate("INSERT INTO WorkCenters(name, capacity) VALUES('World Machine', 100)");

	            ResultSet rs = stmt.executeQuery("SELECT totalCapacity FROM WorkCenterStats");
	            int totalCapacity = 0;
	            if (rs.next()) {
	                totalCapacity = rs.getInt("totalCapacity");
	            }
	            Assert.assertEquals(750, totalCapacity);

	   
	    }
	    
	    @Test(priority=2)
	    void test_TotalCapacityInsertion() throws SQLException
	    {

            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM WorkCenterStats");

            stmt.executeUpdate("INSERT INTO WorkCenters(name, capacity) VALUES('World Machine', 200)");

            // Retrieve the total capacity from WorkCenterStats
            ResultSet rs = stmt.executeQuery("SELECT totalCapacity FROM WorkCenterStats");
            int totalCapacity = 0;
            if (rs.next()) {
                totalCapacity = rs.getInt("totalCapacity");
            }

            Assert.assertEquals(200, totalCapacity);
	    }
	    
	    @Test(priority=3)
	    void test_TriggerExecutionOrder() throws SQLException
	    {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO WorkCenters(name, capacity) VALUES('World Machine', 200)");

            ResultSet rs = stmt.executeQuery("SELECT totalCapacity FROM WorkCenterStats");
            int totalCapacity = 0;
            if (rs.next()) {
                totalCapacity = rs.getInt("totalCapacity");
            }

            rs = stmt.executeQuery("SELECT capacity FROM WorkCenters WHERE name = 'World Machine'");
            int capacity = 0;
            if (rs.next()) {
                capacity = rs.getInt("capacity");
            }

            Assert.assertTrue(totalCapacity > 0);
            Assert.assertEquals(100, capacity);
	    }
	    
	    @Test(priority=4)
	    void test_TriggerBehaviorWithMultipleWorkCenters() throws SQLException
	    {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO WorkCenters(name, capacity) VALUES('WorkCenter1', 100)");
            stmt.executeUpdate("INSERT INTO WorkCenters(name, capacity) VALUES('WorkCenter2', 150)");

            ResultSet rs = stmt.executeQuery("SELECT totalCapacity FROM WorkCenterStats");
            int totalCapacity = 0;
            if (rs.next()) {
                totalCapacity = rs.getInt("totalCapacity");
            }

            Assert.assertEquals(650, totalCapacity);
	    }
	}

