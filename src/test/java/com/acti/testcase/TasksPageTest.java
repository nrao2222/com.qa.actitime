package com.acti.testcase;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acti.utils.Helper;

public class TasksPageTest extends BaseTest {

	@Test(dataProvider = "actiData")
	public void testCreateCustomer(String username, String password) throws InterruptedException
	{
		//loginpage/taskspage/entertimepage/ - global variables is BaseTest class
		
		logger = report.createTest("Creating New Customer");
		loginpage.enterusername(username);
		logger.info("Entered username");
		loginpage.enterPassword(password);
		logger.info("Entered password");
		loginpage.clickLogin();
		logger.info("Clicked Login button");
		Thread.sleep(2000);
		entertimepage.clickTaskMenu();	
		logger.info("Clicked Task Menu");
		taskspage.clickAddNew();
		logger.info("Clicked AddNew button");
		taskspage.clickOptionNewCustomer();
		logger.info("Clicked Option New Customer");
		taskspage.enterCustomerName("Dummy Customer");
		logger.info("Entered CUstomer Name");
		taskspage.enterCustomerDescription("Testing Create Customer feature");
		logger.info("Entered Customer Description");
		taskspage.clickCreateCustomer();
		logger.info("Clicked Create Customer");
		Thread.sleep(2000);
		String msg = taskspage.validateSuccessMessage();
		System.out.println("*****" +msg);
		Assert.assertTrue(msg.contains("created"));
		logger.pass("Customer created successfully");
		Helper.sleep();
		entertimepage.clickLogout();
		logger.info("Logged out of the application");
	}
	
	
	@Test(dataProvider = "actiData")
	public void testDeleteCustomer(String username, String password) throws InterruptedException
	{
		logger = report.createTest("Deleting a Customer");
		loginpage.enterusername(username);
		logger.info("Entered Username");
		loginpage.enterPassword(password);
		logger.info("Entered password");
		loginpage.clickLogin();
		logger.info("Clicked Login button");
		Thread.sleep(2000);
		entertimepage.clickTaskMenu();
		logger.info("Clicked Task Menu");
		Thread.sleep(2000);
		taskspage.enterStartTyping("Dummy Customer");
		logger.info("Typed customer name to delete");
		Thread.sleep(2000);
		taskspage.clickSearchedCustomer();
		logger.info("Clicked on customer name to delete");
		Thread.sleep(2000);
		taskspage.clickButtonCustomer();
		logger.info("Clicked button for customer info");
		Thread.sleep(2000);
		taskspage.clickButtonActions();
		logger.info("Clicked Actions button");
		Thread.sleep(2000);
		taskspage.clickDeleteCustomer();
		logger.info("Clicked on delete customer");
		Thread.sleep(3000);
		//taskspage.clickCancelDelete();
		//logger.info("Clicked Cancel delete customer");
		
		taskspage.clickDeleteConfirm();
		logger.info("Clicked on Confirm delete");
		//Thread.sleep(2000);	
		String msg = taskspage.validateSuccessMessage();
		System.out.println("===========" +msg + "==============");
		Assert.assertTrue(msg.contains("deleted"));
		logger.pass("Customer deleted successfully");
		Helper.sleep();
		entertimepage.clickLogout();
		logger.info("Logged out of the application");
	}
	
}
