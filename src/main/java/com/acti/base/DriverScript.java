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

/*
 * Title: DriverScript
 * Description:
 * Developed By: nrao2222
 * Date: 7/30/2021
 * Approved By: Shantosh Kumar
 * Approved Date: 7/31/2021
 */

public class DriverScript {

	public static WebDriver driver;
	public static Properties prop;

	public DriverScript() {
		try {
			File src = new File("./atconfig/config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("UNable to read properties file.Please check again. " + e.getMessage());
		}
	}

	// Remove @Test after init testing your code
	public void initApplication() {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./atbrowsers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./atbrowsers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./atbrowsers/msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String url = prop.getProperty("devurl");
		driver.get(url);

	}

}
