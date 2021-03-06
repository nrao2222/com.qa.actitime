package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;
//import org.testng.annotations.*;

/*
 * Title: DriverScript
 * Description:
 * Developed By: nrao2222
 * Date: 7/30/2021
 * Approved By: Shantosh Kumar
 * Approved Date: 7/31/2021
 */

public class DriverScript {

	//these are public so as to make them available across different pkg'es in the project.
	// static as they are in a class but outside any method but dont' need to create an object
	public static WebDriver driver;
	public static Properties prop;
 
	public DriverScript() {
		try {
			File src = new File("./atconfig/config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to read properties file.Please check again. " + e.getMessage());
		}
	}

	// Remove @Test after unit testing your code
	//@Test(priority=1)
	public void initApplication() {
		String browser = prop.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./atbrowsers/chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./atbrowsers/geckodriver.exe");
			driver = new FirefoxDriver();
		} 
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./atbrowsers/msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String url = prop.getProperty("qaurl");
		//String url = prop.getProperty("devurl");
	
		System.out.println("%%%%%%Url to fetch is: " +url);
		driver.get(url);

	}
	
	//@Test(priority=2)
	public void quitApplication()
	{
		System.out.println("In quitApplication()");
		driver.close();
	}

}
