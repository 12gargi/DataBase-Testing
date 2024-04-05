package source;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class BaseTest {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public Connection con;
	public Statement stmt;
	public ResultSet rs;
	public CallableStatement cstmt;
	public ResultSet rs1;
	public ResultSet rs2;


	@BeforeTest
	public void beforeTestMethod() {
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "Reports" + File.separator + "Framework");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Database Testing Report");
		sparkReporter.config().setReportName("Framework test");
	}
	
	@BeforeClass
    public void setup() throws SQLException {
    	String url = "jdbc:mysql://google/classicmodels?cloudSqlInstance=your-project-id:your-region:your-instance-id&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=root&password=root";
        con = DriverManager.getConnection(url);
    }
	
	
	@BeforeMethod
	public void beforeMethodMethod( Method testmethod) {
		logger = extent.createTest(testmethod.getName());
		
	}
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test case failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test case failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test case skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Test case pass", ExtentColor.GREEN));
		}
		
	}

    

    @AfterClass
    public void tearDown() throws SQLException {
        if (con != null) {
            con.close();
        }
        
    }
    
    @AfterTest
	public void afterTest() {
		extent.flush();
		
	}
}
