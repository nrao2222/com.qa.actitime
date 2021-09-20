package com.acti.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import com.acti.base.DriverScript;

/*
 * Tester: Gaya
 * Date Created: 8/2/2021
 * Verified By: Shan
 * Verified Date: 8/2/2021
 */

public class LoginPage extends DriverScript {
	
//**************************** Page Elements **************************************//
	
	@FindBy(id="username") WebElement textboxusername;
	@FindBy(name="pwd") WebElement textboxpassword;
	@FindBy(xpath="//div[text()='Login ']") WebElement buttonLogin;
	@FindBy(xpath="//span[@class='errormsg']") WebElement textErrorLoginMessage;
	
	
//****************************** Page Initialization **********************************//
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

//******************************* Page Actions **************************************//
	public void enterusername( String username)
	{
		textboxusername.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		textboxpassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		buttonLogin.click();
	}
	
	public String verifyErrorMessage()
	{
		return textErrorLoginMessage.getText();
	}
}
