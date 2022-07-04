package com.sourcepro.Login;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sourcepro.init.Common;
import com.sourcepro.init.SeleniumInit;
import com.sourcepro.utility.TestData;

public class LoginIndex extends SeleniumInit{

	
	@Test(description = "Do Login")
	public void login() throws IOException, AWTException{

		int numOfFailure=0;
		int step=1;

		logStep(step++,"Open URL : "+testUrl);	
		
		//Parameters
		String ConnectionString, LoginEmail, Password, SelectCompany, SelectLocation;

		logStep(step++,"Do login with valid email and password.");
		
		//For Data Driven
		File f = new File("UploadData/Sigin.xlsx");
		String SiginExcel = f.getAbsolutePath();
				
//		ArrayList<String> ConnectionStringExcel = TestData.getColumnData(SiginExcel, "Sigin", "ConnectionString");
		ArrayList<String> EmailExcel = TestData.getColumnData(SiginExcel, "Sigin", "Email");
		ArrayList<String> PasswordExcel = TestData.getColumnData(SiginExcel, "Sigin", "Password");
		ArrayList<String> SelectCompanyExcel = TestData.getColumnData(SiginExcel, "Sigin", "SelectCompany");
		ArrayList<String> SelectLocationExcel = TestData.getColumnData(SiginExcel, "Sigin", "SelectLocation");
		
		String str = "Server=PC43\\\\SQLEXPRESS,Database=NH1QCCybAdmin280422,uid=sa,pwd=,Max Pool Size=1000,Connection TimeOut= 3000,";
		
		ConnectionString = str.replace(",", ";");
		LoginEmail = EmailExcel.get(0);
		Password = PasswordExcel.get(0);
		SelectCompany = SelectCompanyExcel.get(0);
		SelectLocation = SelectLocationExcel.get(0);
		
		logStep(step++,"Do login with valid username and password.");
		loginVerification = loginIndexPage.doLogin(ConnectionString, LoginEmail, Password);
		
		log("Entered Connection String: "+ConnectionString);
		TestData.setValueConfig("uploadConfig.properties","ConnectionString", ConnectionString);
		
		log("Entered Email: "+LoginEmail);
		TestData.setValueConfig("uploadConfig.properties","Email", LoginEmail);
		
		log("Entered Password: "+Password);
		TestData.setValueConfig("uploadConfig.properties","Password", Password);
		
		logStep(step++,"Select Company.");
		loginVerification = loginIndexPage.selectCompanyDropDown(SelectCompany);
		log("Selected Company: "+SelectCompany);

		logStep(step++,"Select Location.");
		loginVerification = loginIndexPage.selectLocationDropDown(SelectLocation);
		log("Selected Location: "+SelectLocation);
		
		logStep(step++,"Click on right arrow icon.");
		loginVerification = loginIndexPage.clickRightArrow();
		
		
		
		
		Common.pause(10);


//		if(loginVerification.verifyloginurl()) 
//		{
//			logStatus(1,"User Logged in succesfully.");
//		}
//		else{
//			logStatus(2,"User did not logged in.");
//			numOfFailure++;
//		}

		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		} 

	}
	
	@Test
	public void logout() throws IOException{
		
		int numOfFailure=0;
		int step=1;
		 
		logStep(step++,"Click on drop down and click on logout.");
		loginVerification=loginIndexPage.logout();

		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		} 
		
	}

}
