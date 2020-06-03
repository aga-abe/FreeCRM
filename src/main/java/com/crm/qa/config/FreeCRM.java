package com.crm.qa.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FreeCRM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\QA Automation Testing\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://classic.freecrm.com/index.html");
		driver.findElement(By.xpath("//input[@name=\"username\"")).sendKeys("nidhisanan");
		driver.findElement(By.xpath("//input[@name=\"password\"")).sendKeys("Uttamnidhi@2013%");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		

	}

}
