package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.Test;

import com.acti.base.DriverScript;
import com.acti.utils.Helper;

public class TasksPage extends DriverScript{

//******************************** Page Elements ***********************************//
	
	//@FindBy(xpath="//div[text()='Add New']") WebElement buttonAddNew;
	//copied full xpath and it worked ::()
	@FindBy(xpath="/html/body/div[18]/div[1]/div[1]/div[1]/div[1]/div[3]/div/div[2]") WebElement buttonAddNew;
	@FindBy(xpath = "//div[@class='item createNewCustomer']") WebElement optionCreateNewCustomer;
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]") WebElement textboxCustomerName;
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']") WebElement textareaCustomerDescription;
	@FindBy(xpath = "//div[text()='Create Customer']") WebElement buttonCreateCustomer;
	@FindBy(xpath="//span[@class='innerHtml']") WebElement textSuccessMessage;
	@FindBy(xpath = "//input[@placeholder='Start typing name ...']") WebElement textboxStartTyping;
	//@FindBy(xpath = "//div[@class='node customerNode editable selected']") WebElement nodeSearchResult;
	@FindBy(xpath="(//span[@class='highlightToken'])[1]") WebElement nodeSearchResult;
	//@FindBy(xpath="(//div[@class='editButton'])[18]") WebElement buttonCustomer;
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[@class='editButton']") WebElement buttonCustomer;
	
	@FindBy(xpath="(//div[@class='action'])[1]") WebElement buttonActions;
	//@FindBy(xpath="(//div[@class='deleteButton'])[2]") WebElement buttonDeleteCustomer;
	//@FindBy(xpath="(//div[text()='Delete'])[2]") WebElement buttonDeleteCustomer;
	@FindBy(xpath="(//div[@class='deleteButton'])[1]") WebElement buttonDeleteCustomer;
	
	//@FindBy(xpath="//span[text()='Delete permanently']") WebElement buttonConfirmDeleteCustomer;
	@FindBy(xpath="//span[text()='Delete permanently']") WebElement buttonConfirmDeleteCustomer;
	//@FindBy(xpath="(//div[@class='cancelBtn greyButton'])[1]") WebElement buttonCancelDelete;
	@FindBy(xpath="/html/body/div[18]/div[2]/div[1]/div[5]/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div/div/div[5]/div[2]") WebElement buttonCancelDelete;
	//@FindBy(xpath="/html/body/div[13]/div/div/span[1]") WebElement textSuccessDeleteMsg;
	@FindBy(xpath="//span[contains(text(), 'deleted')]") WebElement textSuccessDeleteMsg;
	
//****************************** Page Initialization **********************************//
	public TasksPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
//******************************** Page Actions *************************************//
	
	public void clickAddNew()
	{
		buttonAddNew.click();
		Helper.sleep();
	}
	
	public void clickOptionNewCustomer()
	{
		optionCreateNewCustomer.click();
	}
	
	public void enterCustomerName(String customername)
	{
		textboxCustomerName.sendKeys(customername);
	}
	
	public void enterCustomerDescription(String customerdesciption )
	{
		textareaCustomerDescription.sendKeys(customerdesciption);
	}
	
	public void clickCreateCustomer()
	{
		buttonCreateCustomer.click();
	}
	
	public String validateSuccessMessage()
	{
		//System.out.println("++++++++++In validateSuccessMessage()++++++++++++++");
		Helper.sleep();
		return textSuccessMessage.getText();
	}
	
	public String validateDeleteSuccessMessage()
	{
		//System.out.println("++++++++++In validateDeleteSuccessMessage()++++++++++++++");
		Helper.sleep();
		return textSuccessDeleteMsg.getText();
	}
	
	public void enterStartTyping(String customername)
	{
		textboxStartTyping.sendKeys(customername);
		
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		Helper.sleep();
		
	}
	
	public void clickSearchedCustomer()
	{
		nodeSearchResult.click();
		
	}
	
	public void clickButtonCustomer()
	{
		try {
			System.out.println("*******In clickButtonCustomer()******");
			buttonCustomer.click();
		} catch ( Exception e) {
			e.printStackTrace();
			System.out.println("+++++++++Couldn't click on the Customer Button++++++++");
		}	
		Helper.sleep();
	}
	
	public void clickButtonActions() throws InterruptedException
	{
		try {
			System.out.println("+++++++In clickButtonActions()++++++");
			buttonActions.click();
		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("++++++++++Unable to click buttonActions+++++");
		}
		System.out.println("+++++++Exiting clickButtonActions()++++++");
		Helper.sleep();
	}
	
	public void clickDeleteCustomer() throws InterruptedException
	{
		try {
			//System.out.println("+++++++++++++In clickDeleteCUstomer() ++++++++");
			buttonDeleteCustomer.click();
		} catch (Exception e) {
			//System.out.println("++++++ Couldnt click Delete button +++++++++++");
			e.printStackTrace();
		}
		//System.out.println("+++++++++Exiting clickDeleteButton()+++++++++");
		Helper.sleep();
		
		//buttonDeleteCustomer.click();
		//Helper.sleep();
		
		
	}
	
	public void clickDeleteConfirm() throws InterruptedException
	{
		
		 try{
			 //System.out.println("+++++++++++In clickDeleteConfirm() ++++++++++++++");
			 buttonConfirmDeleteCustomer.click();
		 }
		 catch (Exception e) {
			 //System.out.println("++++++ Couldnt click COnfirm Delete button +++++++++++");
			 e.printStackTrace();
		 }
		 //System.out.println("+++++++++++++Exiting clickDeleteConfirm()++++++++");
		 Helper.sleep();
	}
	
	public void clickCancelDelete()
	{
		buttonCancelDelete.click();
	}
}
