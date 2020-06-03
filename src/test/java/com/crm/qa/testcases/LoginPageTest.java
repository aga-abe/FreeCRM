package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

     public class LoginPageTest extends TestBase{
	 LoginPage loginpage;
	 HomePage homepage;
		
	public LoginPageTest() { // create constructor of LoginPageTest
		super();            // call super keyword. Super class constructor will be called by using super Keyword. Here we are calling 
							//super class constructor
	}
		
		@BeforeMethod
		
		public void setUp() {
			initialization(); // calling the initialization method of parent class TestBase
			loginpage = new LoginPage(); // create the object of loginpage class and define LoginPage variable at the class level 
											//so that throughout the program we can use. loginpage object is created so that we can access all 
											//the methods of loginpage class
		}
		
		
			
			@Test (priority=1)
			
			public void loginPageTitleTest() {
				String title = loginpage.validateLoginPageTitle(); // by using loginpage object 
																	//we can call validateLoginPageTitle() from LoginPage.java class
				//System.out.println(title);
				Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
			}
	
			
            @Test(priority=2)
			
			public void CRMLogoImageTest() {
				boolean flag = loginpage.validateCRMImage();
				Assert.assertTrue(flag);
			}
			
           @Test(priority=3)
			
			public void loginTest() {
        	   homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
				
			}
			
			
			@AfterMethod
			
			public void tearDown() {
			driver.quit();
		}
			
		}
		
	