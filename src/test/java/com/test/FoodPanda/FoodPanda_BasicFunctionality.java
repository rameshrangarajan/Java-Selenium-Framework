package com.test.FoodPanda;

import java.awt.AWTException;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.FP.ExcelDataConfig;
import com.FP.data.FoodPanda_BaseData;
import com.FP.global.*;

public class FoodPanda_BasicFunctionality extends FoodPandaPageFactory {

	//public static String excelPath1 = "D:\\NLPro\\Automation\\src\\main\\java\\com\\FP\\data\\Data.xlsx";
	public static String excelPath1 = "D:\\Framework_New\\Framework\\Framework\\src\\main\\java\\com\\FP\\data\\Data.xlsx";
	ExcelDataConfig excel = new ExcelDataConfig(excelPath1);


	@Test(description = "The test case verifies basic functionality for FoodPanda page", groups = { "Regression" } )
	public void verifyBasicFunctionality() throws InterruptedException,
			AWTException {
		log("Starting test....");
		log("Logging in....");
		open(FoodPandaLoginURL).get(url);
		FoodPandaLoginLogout().foodPandaLogin(excel.getData(0, 1, 0),
				excel.getData(0, 1, 1));

		try {
			FoodPandaTest().enteringAddressdetails(excel.getData(1, 1, 0),
					excel.getData(1, 1, 1));
			FoodPandaTest().clickingShowrestaurantButton();
			FoodPandaTest().selectingFirstRestaurant();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}

	@Test(description = "The test case verifies test functionality for FoodPanda page", groups = { "Regression" } )
	public void verifyTestFunctionality() throws InterruptedException,
			AWTException {

		log("Starting test....");
		log("Logging in....");
		open(FoodPandaLoginURL).get(url);

		FoodPandaLoginLogout().foodPandaLogin(excel.getData(0, 1, 0),
				excel.getData(0, 1, 1));

		try {
			FoodPandaTest().enteringAddressdetails(excel.getData(2, 1, 0),
					excel.getData(2, 1, 1));
			FoodPandaTest().clickingShowrestaurantButton();
			FoodPandaTest().selectingFirstRestaurant();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies upload text file functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyUploadTextFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			NLProTest().uploadingTextFile(excel.getData(3, 1, 0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	
	
	@Test(description = "The test case verifies download file functionality for NLPRO Lookup page", groups = { "Sanity" })
	public void verifyDownloadFileFromLookupFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			NLProTest().downLoadFileInLookup();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
	}

	@AfterGroups(groups = { "Regression", "Sanity" }, alwaysRun = false)
	public void tearDown() {
		log("Logging out....");
		FoodPandaLoginLogout().foodPandaLogout();
	}

}
