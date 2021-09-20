package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acti.base.DriverScript;

/*
 * Tester: Kay
 * Date Created: 8/3/2021
 * Verified By: Shawn
 * Verified Date: 8/3/2021
 */


public class EnterTimePage extends DriverScript {

//**************************** Page Elements **************************************//
	
	@FindBy(id="logoutLink") WebElement linkLogout;
	@FindBy(xpath="//a[@class='userProfileLink username ']") WebElement textuserLoggedin;
	
//****************************** Page Initialization **********************************//
	public EnterTimePage()
	{
		PageFactory.initElements(driver, this);
	}
	
//****************************** Page Actions **********************************//
	public void clickLogout()
	{
		linkLogout.click();
	}
	
	public String verifyUserLoggedIn()
	{
		return textuserLoggedin.getText();
	}
}