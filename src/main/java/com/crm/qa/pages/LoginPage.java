package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

    public class LoginPage extends TestBase {
    	
    	// in LoginPage we have to define object repository ie we have to define PageFactory
    	
    	//PageFactory - OR(Object Repository):
    	
    @FindBy(name = "username")
   WebElement username;
    
    @FindBy(name = "password")
    WebElement password;
    
//    @FindBy(xpath="//input[@type='submit']")
//   WebElement loginBtn;
    
    @FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
    WebElement loginBtn;
    
    
    @FindBy(xpath="//a[@href=\"https://register.freecrm.com/register/\"]")
    WebElement signUpLink;
    
    @FindBy(xpath="//img[contains(@class,\"img-responsive\")]")
    WebElement crmLogo;
    
    
    
    
    //How to initialze the elements with the help of PageFactory
    //For this create the constructor of the class
    //define PageFactory Class with initElements method

// Initializing the Page Objects:
    public LoginPage() {
    	PageFactory.initElements(driver, this);// "this" means it is pointing to current class object
    }
    
  // Actions:
    public String validateLoginPageTitle() {
    	return driver.getTitle();
    }
    
    public boolean validateCRMImage() {
    	return crmLogo.isDisplayed();
    	
    }

    public HomePage login (String un, String pwd) {
    	
    	username.sendKeys(un);
    	password.sendKeys(pwd);
    	loginBtn.click();
    	
    	return new HomePage();
    	
    }

    }
