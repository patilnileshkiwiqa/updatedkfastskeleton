package com.sourcepro.Login;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.sourcepro.init.AbstractPage;
import com.sourcepro.init.Common;


public class LoginIndexPage extends AbstractPage{

	public LoginIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
//Login
	
	@FindBy(xpath="//input[@formcontrolname='connStr']")
	WebElement ConnectionString;
	@FindBy(xpath="//input[@formcontrolname='userName']")
	WebElement emailID;
	@FindBy(xpath="//input[@formcontrolname='password']")
	WebElement passwordtxt;
	@FindBy(xpath="//button[text()='LOGIN']")
	WebElement loginBtn;

	public LoginVerification doLogin(String ConnectionStringvalue, String email, String password) throws AWTException
	{
		emailID.sendKeys(Keys.F2);
		Common.type(ConnectionString, ConnectionStringvalue);
		Common.clickableElement(emailID, driver);
		Common.type(emailID, email);
		Common.type(passwordtxt, password);
		Common.clickableElement(loginBtn, driver);
		Common.clickOn(driver, loginBtn);
		return new LoginVerification(driver);
	}


//Logout
	
	@FindBy(xpath="//select[@formcontrolname='companyId']")
	WebElement selectCompany;

	public LoginVerification selectCompanyDropDown(String value) {
	
		Common.clickableElement(selectCompany, driver);
		Common.selectFromComboByVisibleElement(selectCompany, value);
		return new LoginVerification(driver);
	}
	
	@FindBy(xpath="//select[@formcontrolname='companyLocationId']")
	WebElement selectLocation;
	
	public LoginVerification selectLocationDropDown(String value) {
		Common.clickableElement(selectLocation, driver);
		Common.selectFromComboByVisibleElement(selectLocation, value);
		return new LoginVerification(driver);
	}

	@FindBy(xpath="//button[@type='submit']")
	WebElement clickRightArrow;

	public LoginVerification clickRightArrow() {
		
		Common.clickableElement(clickRightArrow, driver);
		Common.clickOn(driver, clickRightArrow);
		return new LoginVerification(driver);
	}
	
	@FindBy(xpath="//div[@class='user-info text-right']")
	WebElement clickDropDownArrowLogout;
	@FindBy(xpath="//i[@class='icon-logout']")
	WebElement clickLogoutIcon;
	
	public LoginVerification logout() {
		
		Common.clickableElement(clickDropDownArrowLogout, driver);
		Common.clickOn(driver, clickDropDownArrowLogout);
		Common.clickableElement(clickLogoutIcon, driver);
		Common.clickOn(driver, clickLogoutIcon);
		return new LoginVerification(driver);
	}
	
	

}
