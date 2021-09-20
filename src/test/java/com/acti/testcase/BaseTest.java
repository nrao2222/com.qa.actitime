package com.acti.testcase;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import com.acti.base.DriverScript;
import com.acti.pages.EnterTimePage;
import com.acti.pages.LoginPage;
import com.acti.pages.TasksPage;
import com.acti.utils.ExcelReader;
import com.acti.utils.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest extends DriverScript{

	LoginPage loginpage;
	EnterTimePage entertimepage;
	TasksPage taskspage;
	public static ExtentHtmlReporter extent;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void setUpReport()
	{
		extent = new ExtentHtmlReporter("./atreports/index.html+" +System.currentTimeMillis());
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	
	@AfterSuite
	public void fulshReport()
	{
		report.flush();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		loginpage = new LoginPage();
		entertimepage = new EnterTimePage();
		taskspage = new TasksPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			logger.fail("Test Failed",  MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		quitApplication();
	}
	
	@DataProvider(name="actiData")
	public Object[][] testData()
	{
		
		System.out.println("In testData (@DataProvider)");
		//read from xls file using user-created ExcelUtil class
		ExcelReader excel = new ExcelReader("./attestdata/actidata.xlsx");
		//reading xls by index: sheet[2]
		int row = excel.getRowCount(0);
		Object[][] data = new Object[row][2];  // we know it is a 2d array with 2 columns
		
		for(int i = 0; i < row; i++ )
		{
			data[i][0] = excel.getCellData(0, i, 0);
			//System.out.println("%%%%%row data is: " +data[i][0]);
			data[i][1] = excel.getCellData(0, i, 1);
			//System.out.println("%%%%%Col data is: " +data[i][1]);
			
		}
		
		return data;
	}
}
