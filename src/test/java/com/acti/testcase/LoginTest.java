package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	@Test
	public void testLoginFunctionValidUser() throws InterruptedException
	{
		logger = report.createTest("Login Functionality");
		
		loginpage.enterusername("admin"); // simulating the user input
		logger.info("Entered username");
		loginpage.enterPassword("manager");
		logger.info("Entered password");
		loginpage.clickLogin();
		logger.info("Clicked Login button");
		String actual = entertimepage.verifyUserLoggedIn();
		System.out.println("Actual user logged in: " +actual);
		Assert.assertEquals(actual, "John Doe");
		//Assert.assertEquals(actual, "Shantosh");
		logger.pass("User logged in successfully");
		entertimepage.clickLogout();	
		logger.info("Clicked Logout");
	}
	
	@Test
	public void testValidFunctionInvalidUser()
	{
		logger = report.createTest("Login with Invalid Credentials");
		
		loginpage.enterusername("admin");
		logger.info("Entered username");
		loginpage.enterPassword("damanager");
		logger.info("Entered password");
		loginpage.clickLogin();
		logger.info("Clicked Login button");
		String errormsg = loginpage.verifyErrorMessage();
		System.out.println("++++++" +errormsg +"+++++++++");
		Assert.assertTrue(errormsg.contains("Username or Password is invalid."));
		logger.pass("verified the error message");
	}
}
