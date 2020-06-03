package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver; // make it public so that it can be used in child class also
	public static Properties prop;

	public TestBase() { // create the constructor of the class 
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip); // used to load the properties file
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	catch (IOException e){
		e.printStackTrace();
	}
	}
	
	public static void initialization() {
		String browserName= prop.getProperty("browser"); // to read the property of browser from config.properties file
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\eclipse-workspace\\FreeCRMTest\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\eclipse-workspace\\FreeCRMTest\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
		
		
	}
	
	
	
}
