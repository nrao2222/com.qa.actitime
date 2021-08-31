package com.acti.testcase;

import org.testng.annotations.Test;

import com.acti.base.DriverScript;
import com.acti.pages.EnterTimePage;
import com.acti.pages.LoginPage;

public class LoginTest extends DriverScript{
	
	@Test
	public void testLoginFunction()
	{
		initApplication();
		LoginPage loginpage = new LoginPage();
		loginpage.enterusername("admin");
		loginpage.enterPassword("manager");
		loginpage.clickLogin();
		EnterTimePage entertimepage = new EnterTimePage();
		String actual = entertimepage.verifyUserLoggedIn();
		System.out.println("Actual user logged in: " +actual);
		Assert.
		
		entertimepage.clickLogout();
		quitApplication();
		
	}
	

}
