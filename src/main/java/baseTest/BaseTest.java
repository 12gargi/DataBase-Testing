package baseTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	 

	public Connection con;
	public Statement stmt;
	public ResultSet rs;
	public CallableStatement cstmt;
	public ResultSet rs1;
	public ResultSet rs2;



    @BeforeClass
    public void setup() throws SQLException {
    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
    }

    @AfterClass
    public void tearDown() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
