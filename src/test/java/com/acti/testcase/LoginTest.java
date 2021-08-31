package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.acti.base.DriverScript;
import com.acti.pages.EnterTimePage;
import com.acti.pages.LoginPage;

public class LoginTest extends DriverScript{
	
	LoginPage loginpage;
	EnterTimePage entertimepage;
	
	@BeforeMethod
	public void setUP()
	{
		initApplication();
		loginpage = new LoginPage();
		entertimepage = new EnterTimePage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		quitApplication();
	}
	
	@Test
	public void testLoginFunctionValidUser()
	{
		loginpage.enterusername("admin");
		loginpage.enterPassword("manager");
		loginpage.clickLogin();
		String actual = entertimepage.verifyUserLoggedIn();
		System.out.println("Actual user logged in: " +actual);
		Assert.assertEquals(actual, "John Doe");	
		entertimepage.clickLogout();		
	}
	
	@Test
	public void testValidFunctionInvalidUser()
	{
		loginpage.enterusername("admin");
		loginpage.enterPassword("damanager");
		loginpage.clickLogin();
		String errormsg = loginpage.verifyErrorMessage();
		Assert.assertTrue(errormsg.contains("Username or Password is invalid."));		
	}

}
