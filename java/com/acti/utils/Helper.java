package com.acti.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenShot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = "C:\\Users\\nandu\\git\\com.qa.actitime\\atreports\\screenshots\\screen.png";
		
		try 
		{
			FileHandler.copy(src, new File(screenshotpath));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return screenshotpath;
	
	}
	
	public static void sleep()
	{
		try{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
