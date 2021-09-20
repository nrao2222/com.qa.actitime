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
	//@FindBy(id="container_tasks") WebElement menuTask;
	@FindBy(xpath="//div[@id='container_tasks']") WebElement menuTask;
	//@FindBy(xpath="//a[@class='content selected tasks']") WebElement menuTask;
	
//****************************** Page Initialization **********************************//
	public EnterTimePage()
	{
		PageFactory.initElements(driver, this);
	}
	
//****************************** Page Actions **********************************//
	public void clickLogout() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println("+++++++++In clickLogout()+++++++");
		linkLogout.click();
	}
	
	public String verifyUserLoggedIn()
	{
		return textuserLoggedin.getText();
	}
	
	public void clickTaskMenu()
	{
		menuTask.click();
	}
}