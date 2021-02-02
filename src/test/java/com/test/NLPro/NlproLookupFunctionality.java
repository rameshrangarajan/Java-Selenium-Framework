package com.test.NLPro;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.FP.ExcelDataConfig;
import com.FP.global.*;

public class NlproLookupFunctionality extends NlproPageFactory {
	
	public static String excelPath1 = "G:\\Java-Selenium-Framework\\src\\main\\java\\com\\FP\\data\\DataNew.xlsx";
	ExcelDataConfig excel = new ExcelDataConfig(excelPath1);
	
	@Test(description = "Tests Simple Google Functionality" , groups = { "Test" }) 
	  public void testGoogle1() throws InterruptedException,AWTException {
	  
	  log("Starting test...."); log("Logging in....");
	  open(GoogleURL).get(googleurl);
	  
	  
	  try {
		  
		  NLProTest().testGoogleSite(excel.getData(0, 1, 0), excel.getData(0, 1, 1));
		  //NLProTest().testGoogleSite("Selenium", "Selenium WebDriver");
	  
	  } catch (Exception e) { 
		  e.printStackTrace(); } log("Test Completed...."); 
	  
	  }
	
	
	@Test(description = "The test case verifies organization folder selection functionality for NLPRO Lookup page", groups = { "Regression" })
	public void verifyOrganizationFolderSelectionInLookupFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyOrganizationFolderSelectionInLookupFunctionality(excel.getData(11, 1, 2), excel.getData(11, 1, 3), 
					excel.getData(11, 1, 4)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies extension folder selection functionality for NLPRO Lookup page", groups = { "Sanity" })
	public void verifyExtensionFolderSelectionInLookupFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyExtensionFolderSelectionInLookupFunctionality(excel.getData(11, 1, 7), excel.getData(11, 1, 8), 
					excel.getData(11, 1, 9)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies organization folder selection using the Enter key functionality for NLPRO Lookup page", groups = { "Sanity" })
	public void verifyOrganizationFolderSelectionUsingEnterKeyInLookupFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyOrganizationFolderSelectionUsingEnterKeyInLookupFunctionality(excel.getData(11, 1, 2), excel.getData(11, 1, 3),
					excel.getData(11, 1, 4)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies extension folder selection using the Enter key functionality for NLPRO Lookup page", groups = { "Sanity" })
	public void verifyExtensionFolderSelectionUsingEnterKeyInLookupFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyExtensionFolderSelectionUsingEnterKeyInLookupFunctionality(excel.getData(11, 1, 7), excel.getData(11, 1, 8), 
					excel.getData(11, 1, 9)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies lookup search functionality for NLPRO Lookup page", groups = { "Sanity" })
	public void verifyLookupFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyLookupFunctionality(excel.getData(11, 1, 0)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies lookup search functionality using the Enter key for NLPRO Lookup page", groups = { "Sanity" })
	public void verifyLookupFunctionalityUsingEnterKey() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyLookupUsingEnterKeyFunctionality(excel.getData(11, 1, 0)));
			
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
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			NLProTest().downLoadFileInLookup();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
	}
	
	@Test(description = "The test case verifies download file using Enter key functionality for NLPRO Lookup page", groups = { "Sanity" })
	public void verifyDownloadFileUsingEnterKeyFromLookupFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			NLProTest().downLoadFileUsingEnterKeyInLookup();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
	}
	
	@Test(description = "The test case verifies the error message for search during unselected folder for NLPRO Lookup page", groups = { "Sanity" })
	public void verifySearchWithoutFolderSelectedInLookupFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyErrorMessageForUnselectedFolderDuringSearchFunctionality(excel.getData(11, 1, 1)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
	}
	
	@Test(description = "The test case verifies the error message for search using the Enter key during unselected folder for NLPRO Lookup page", groups = { "Sanity" })
	public void verifySearchWithoutFolderSelectedUsingEnterKeyInLookupFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyErrorMessageForUnselectedFolderDuringSearchUsingEnterKeyFunctionality(excel.getData(11, 1, 1)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
	}
	
	@Test(description = "The test case verifies the dismissal of the error popup for unselected folder functionality for NLPRO Lookup page", groups = { "Sanity" })
	public void verifyDismissErrorMessagePopupInLookupFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyDismissErrorMessagePopupForUnselectedFolderDuringSearchFunctionality());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
	}
	
		
	@Test(description = "The test case verifies error message for no search results functionality for NLPRO Lookup page", groups = { "Sanity" })
	public void verifyErrorMessageForNoSearchResultsInLookupFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyNoSearchResultsInLookupFunctionality(excel.getData(11, 1, 5), excel.getData(11, 1, 6)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies error message for no search results using the Enter key functionality for NLPRO Lookup page", groups = { "Sanity" })
	public void verifyErrorMessageForNoSearchResultsUsingEnterKeyInLookupFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyNoSearchResultsUsingEnterKeyInLookupFunctionality(excel.getData(11, 1, 5), excel.getData(11, 1, 6)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the tool tip text of all controls in NLPRO Lookup page", groups = { "Sanity" })
	public void verifyTooltipTextForLookupFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyTooltipTextForLookupPageControls(excel.getData(11, 1, 10), excel.getData(11, 1, 11),
					excel.getData(11, 1, 12)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the placeholder text for the Lookup search bar for NLPRO Lookup page", groups = { "Sanity" })
	public void verifyPlaceholderTextForLookupSearch() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyLookupSearchBarPlaceholderText(excel.getData(11, 1, 14)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the list of taxonomy folders for the NLPRO Lookup page", groups = { "Sanity" })
	public void verifyAllTaxonomyFoldersInLookup() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProLookupLocalURL).get(nlprolookuplocalurl);

		
		try {
			assertTrue(NLProTest().verifyTaxonomyFolders());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test
	public void testMethod() {
		
		System.out.println("Hello World");
	}
}
