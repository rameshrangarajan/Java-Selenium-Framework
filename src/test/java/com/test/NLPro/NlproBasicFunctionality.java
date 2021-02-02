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

public class NlproBasicFunctionality extends NlproPageFactory {

	
	public static String excelPath1 = "G:\\Java-Selenium-Framework\\src\\main\\java\\com\\FP\\data\\DataNew.xlsx";
	
	//public static String excelPath1 = "G:\\DataNew.xlsx";
	//public static String excelPath1 = "";
	ExcelDataConfig excel = new ExcelDataConfig(excelPath1);
	
	
	  @Test(description = "Tests Simple Google Functionality" , groups = { "Test" }) 
	  public void testGoogle() throws InterruptedException,AWTException {
	  
	  log("Starting test...."); log("Logging in....");
	  open(GoogleURL).get(googleurl);
	  
	  
	  try {
		  
		  NLProTest().testGoogleSite(excel.getData(0, 1, 0), excel.getData(0, 1, 1));
		  //NLProTest().testGoogleSite("Selenium", "Selenium WebDriver");
	  
	  } catch (Exception e) { 
		  e.printStackTrace(); } log("Test Completed...."); 
	  
	  }
	 
	
	@Test(description = "The test case verifies upload text file functionality for NLPRO Scan page", groups = { "Regression" })
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
	
	@Test(description = "The test case verifies error message for invalid file during upload text file functionality for NLPRO Scan page", groups = { "Regression" })
	public void verifyErrorMessageForInvalidFileTypeForUploadTextFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			assertTrue(NLProTest().verifyErrorMessageForInvalidFileDuringTextFileUpload(excel.getData(3, 1, 1), excel.getData(3, 1, 2)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies upload HTML file functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyUploadHtmlFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().uploadingHTMLFile(excel.getData(3, 1, 1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies error message for invalid file during upload html file functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyErrorMessageForInvalidFileTypeForUploadHtmlFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			assertTrue(NLProTest().verifyErrorMessageForInvalidFileDuringHtmlFileUpload(excel.getData(3, 1, 0), excel.getData(3, 1, 3)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies ORGANIZATION entity on-the-fly training using template functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyOnTheFlyTrainUsingTemplateFromTextFileFunctionalityInScanScreen1() throws InterruptedException,AWTException {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			assertTrue(NLProTest().verifyTrainOrganizationUsingTemplateForTextFileInScanScreen(excel.getData(3, 1, 0), excel.getData(3, 1, 4),
					excel.getData(3, 1, 5), excel.getData(3, 1, 6), excel.getData(3, 1, 7)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
	}
	
	@Test(description = "The test case verifies LOCATION entity on-the-fly training using template functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyOnTheFlyTrainUsingTemplateFromTextFileFunctionalityInScanScreen2() throws InterruptedException,AWTException {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			assertTrue(NLProTest().verifyTrainLocationUsingTemplateForTextFileInScanScreen(excel.getData(3, 1, 8), excel.getData(3, 1, 9),
					excel.getData(3, 1, 5), excel.getData(3, 1, 10), excel.getData(3, 1, 11)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
	}
	
	/*@Test(description = "The test case verifies PERSON entity on-the-fly training using template functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyOnTheFlyTrainUsingTemplateFromTextFileFunctionalityInScanScreen3() throws InterruptedException,AWTException {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			assertTrue(NLProTest().verifyTrainPersonUsingTemplateForTextFileInScanScreen(excel.getData(3, 1, 8), excel.getData(3, 1, 9),
					excel.getData(3, 1, 5), excel.getData(3, 1, 10), excel.getData(3, 1, 11)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
	}*/
	
	@Test(description = "The test case verifies LOCATION entity on-the-fly training using multiple occurrence functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyOnTheFlyTrainForLocationUsingMultipleOccurrenceFromTextFileFunctionalityInScanScreen() throws InterruptedException,AWTException {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			assertTrue(NLProTest().verifyTrainLocationUsingMultipleOccurrenceForTextFileInScanScreen(excel.getData(3, 1, 12), excel.getData(3, 1, 13),
					excel.getData(3, 1, 14), excel.getData(3, 1, 15)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
	}
	
	@Test(description = "The test case verifies PERSON entity on-the-fly training using multiple occurrence functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyOnTheFlyTrainForPersonUsingMultipleOccurrenceFromTextFileFunctionalityInScanScreen() throws InterruptedException,AWTException {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			assertTrue(NLProTest().verifyTrainPersonUsingMultipleOccurrenceForTextFileInScanScreen(excel.getData(3, 1, 16), excel.getData(3, 1, 13),
					excel.getData(3, 1, 17), excel.getData(3, 1, 18)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
	}
	
	@Test(description = "The test case verifies ORGANIZATION entity on-the-fly training using multiple occurrence functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyOnTheFlyTrainForOrganizationUsingMultipleOccurrenceFromTextFileFunctionalityInScanScreen() throws InterruptedException,AWTException {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			assertTrue(NLProTest().verifyTrainOrganizationUsingMultipleOccurrenceForTextFileInScanScreen(excel.getData(3, 1, 19), excel.getData(3, 1, 13),
					excel.getData(3, 1, 20), excel.getData(3, 1, 21)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
	}
	
	@Test(description = "The test case verifies PERSON entity on-the-fly training using single occurrence functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyOnTheFlyTrainForPersonUsingSingleOccurrenceFromTextFileFunctionalityInScanScreen() throws InterruptedException,AWTException {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			assertTrue(NLProTest().verifyTrainPersonUsingSingleOccurrenceForTextFileInScanScreen(excel.getData(3, 1, 22), excel.getData(3, 1, 13),
					excel.getData(3, 1, 23), excel.getData(3, 1, 24)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
	}
	
	@Test(description = "The test case verifies LOCATION entity on-the-fly training using single occurrence functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyOnTheFlyTrainForLocationUsingSingleOccurrenceFromTextFileFunctionalityInScanScreen() throws InterruptedException,AWTException {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			assertTrue(NLProTest().verifyTrainLocationUsingSingleOccurrenceForTextFileInScanScreen(excel.getData(3, 1, 25), excel.getData(3, 1, 13),
					excel.getData(3, 1, 26), excel.getData(3, 1, 27)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
	}
	
	@Test(description = "The test case verifies ORGANIZATION entity on-the-fly training using single occurrence functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyOnTheFlyTrainForOrganizationUsingSingleOccurrenceFromTextFileFunctionalityInScanScreen() throws InterruptedException,AWTException {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			assertTrue(NLProTest().verifyTrainOrganizationUsingSingleOccurrenceForTextFileInScanScreen(excel.getData(3, 1, 28), excel.getData(3, 1, 13),
					excel.getData(3, 1, 29), excel.getData(3, 1, 30)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
	}
	
	@Test(description = "The test case verifies add to PERSON taxonomy functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyAddToPersonTaxonomyFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			//NLProTest().uploadingTextFile(excel.getData(3, 1, 0));
			assertTrue(NLProTest().performAddToPersonTaxonomyAndVerify(excel.getData(4, 1, 0), excel.getData(4, 1, 0)));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
	}
	
	@Test(description = "The test case verifies that entity already exists in PERSON TAXONOMY functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyErrorMessageForEntityAlreadyExistingInPersonTaxonomyFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			//NLProTest().uploadingTextFile(excel.getData(3, 1, 0));
			assertTrue(NLProTest().getErrorMessageForEntityAlreadyExistinginPersonTaxonomy(excel.getData(7, 1, 24), excel.getData(7, 1, 21)));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
	}
	
	@Test(description = "The test case verifies add to LOCATION taxonomy functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyAddToLocationTaxonomyFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			//NLProTest().uploadingTextFile(excel.getData(3, 1, 0));
			assertTrue(NLProTest().performAddToLocationTaxonomyAndVerify(excel.getData(4, 1, 1), excel.getData(4, 1, 1)));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
	}
	
	@Test(description = "The test case verifies that entity already exists in LOCATION TAXONOMY functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyErrorMessageForEntityAlreadyExistingInLocationTaxonomyFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			//NLProTest().uploadingTextFile(excel.getData(3, 1, 0));
			assertTrue(NLProTest().getErrorMessageForEntityAlreadyExistinginLocationTaxonomy(excel.getData(7, 1, 23), excel.getData(7, 1, 21)));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
	}
	
	@Test(description = "The test case verifies add to ORGANIZATION taxonomy functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyAddToOrganizationTaxonomyFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			//NLProTest().uploadingTextFile(excel.getData(3, 1, 0));
			assertTrue(NLProTest().performAddToOrganizationTaxonomyAndVerify(excel.getData(4, 1, 2), excel.getData(4, 1, 2)));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
	}
	
	@Test(description = "The test case verifies that entity already exists in ORGANIZATION TAXONOMY functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyErrorMessageForEntityAlreadyExistingInOrganizationTaxonomyFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			//NLProTest().uploadingTextFile(excel.getData(3, 1, 0));
			assertTrue(NLProTest().getErrorMessageForEntityAlreadyExistinginOrganizationTaxonomy(excel.getData(7, 1, 22), excel.getData(7, 1, 21)));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
	}
	
	
	@Test(description = "The test case verifies retrieving Twitter feed by hashtag value for NLPRO Scan page", groups = { "Sanity" })
	public void verifyTwitterFeedByHashtagFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().getTwitterFeedByHashtag(excel.getData(5, 1, 0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
	}

	@Test(description = "The test case verifies retrieving Twitter feed by multiple hashtag values for NLPRO Scan page", groups = { "Sanity" })
	public void verifyTwitterFeedByMultipleHashtagFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().getTwitterFeedByHashtag(excel.getData(5, 1, 1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
	}
	
	@Test(description = "The test case verifies retrieving Twitter feed for invalid hashtag values for NLPRO Scan page", groups = { "Sanity" })
	public void verifyTwitterFeedForInvalidHashtagFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().twitterFeedInvalidHashtag(excel.getData(5, 1, 2));
			boolean result = NLProTest().getInvalidHashtagErrorMessage(excel.getData(5, 1, 3));
			assertTrue(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
	}
	
	@Test(description = "The test case verifies retrieving Twitter feed for blank hashtag values for NLPRO Scan page", groups = { "Sanity" })
	public void verifyTwitterFeedForBlankHashtagFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().getTwitterFeedByHashtag("");
			boolean result = NLProTest().getTwitterPopupLabel(excel.getData(5, 1, 4));
			assertTrue(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
		
	}
	
	@Test(description = "The test case verifies retrieving Twitter feed for hashtag values by pressing Enter key for NLPRO Scan page", groups = { "Sanity" })
	public void verifyTwitterFeedByHashtagUsingEnterKeyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().getTwitterFeedByHashtagUsingEnterKey(excel.getData(5, 1, 0));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
		
	}
	
	@Test(description = "The test case verifies cancelling the retrieving Twitter feed functionality for NLPRO Scan page", groups = { "Sanity" })
	public void verifyCancelGetTwitterFeedFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().cancelGetTwitterFeed();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
		
	}
	
	@Test(description = "The test case verifies retrieving Twitter feed by username value for NLPRO Scan page", groups = { "Sanity" })
	public void verifyTwitterFeedByUsernameFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().getTwitterFeedByUsername(excel.getData(6, 1, 0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
	}
	
	@Test(description = "The test case verifies retrieving Twitter feed by multiple username values for NLPRO Scan page", groups = { "Sanity" })
	public void verifyTwitterFeedByMultipleUsernameFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().getTwitterFeedByUsername(excel.getData(6, 1, 1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
	}
	
	@Test(description = "The test case verifies retrieving Twitter feed for invalid username values for NLPRO Scan page", groups = { "Sanity" })
	public void verifyTwitterFeedForInvalidUsernameFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().twitterFeedInvalidUsername(excel.getData(6, 1, 2));
			boolean result = NLProTest().getInvalidUsernameErrorMessage(excel.getData(6, 1, 3));
			assertTrue(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		
		
	}
	
	@Test(description = "The test case verifies retrieving Twitter feed for blank username values for NLPRO Scan page", groups = { "Sanity" })
	public void verifyTwitterFeedForBlankUsernameFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().getTwitterFeedByUsername("");
			boolean result = NLProTest().getTwitterPopupLabel(excel.getData(6, 1, 4));
			assertTrue(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies retrieving Twitter feed for username values by pressing Enter key for NLPRO Scan page", groups = { "Sanity" })
	public void verifyTwitterFeedByUsernameUsingEnterKeyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().getTwitterFeedByUsernameUsingEnterKey(excel.getData(6, 1, 0));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies retrieving Twitter feed for username and hashtag values for NLPRO Scan page", groups = { "Sanity" })
	public void verifyTwitterFeedByUsernameAndHashtagFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			NLProTest().getTwitterFeedByUsernameAndHashtag(excel.getData(5, 1, 0), excel.getData(6, 1, 0));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the entered person text exists in taxonomy for NLPRO Scan page", groups = { "Sanity" })
	public void verifyPersonInTaxonomyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().scanForPersonEntityInTaxonomyOrStanford(excel.getData(7, 1, 0), excel.getData(7, 1, 0)));
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the entered text does not exist in PERSON taxonomy for NLPRO Scan page", groups = { "Sanity" })
	public void verifyPersonNotInTaxonomyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().scanForPersonEntityNotInTaxonomy(excel.getData(7, 1, 1)));
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the entered text gets tagged as PERSON by STANFORD for NLPRO Scan page", groups = { "Sanity" })
	public void verifyPersonFromStanfordFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().scanForPersonEntityInTaxonomyOrStanford(excel.getData(7, 1, 2),excel.getData(7, 1, 2)));
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the entered location text exists in taxonomy for NLPRO Scan page", groups = { "Sanity" })
	public void verifyLocationInTaxonomyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().scanForLocationEntityInTaxonomyOrStanford(excel.getData(7, 1, 3), excel.getData(7, 1, 3)));
			
									
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the entered text does not exist in LOCATION taxonomy for NLPRO Scan page", groups = { "Sanity" })
	public void verifyLocationNotInTaxonomyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().scanForLocationEntityNotInTaxonomy(excel.getData(7, 1, 4)));
			
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the entered text gets tagged as LOCATION by STANFORD for NLPRO Scan page", groups = { "Sanity" })
	public void verifyLocationFromStanfordFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			
			assertTrue(NLProTest().scanForLocationEntityInTaxonomyOrStanford(excel.getData(7, 1, 5), excel.getData(7, 1, 5)));
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the entered organization text exists in taxonomy for NLPRO Scan page", groups = { "Sanity" })
	public void verifyOrganizationInTaxonomyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			
			assertTrue(NLProTest().scanForOrganizationEntityInTaxonomyOrStanford(excel.getData(7, 1, 6), excel.getData(7, 1, 6)));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the entered text does not exist in ORGANIZATION taxonomy for NLPRO Scan page", groups = { "Sanity" })
	public void verifyOrganizationNotInTaxonomyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			
			assertTrue(NLProTest().scanForOrganizationEntityNotInTaxonomy(excel.getData(7, 1, 7)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the entered text gets tagged as ORGANIZATION by STANFORD for NLPRO Scan page", groups = { "Sanity" })
	public void verifyOrganizationFromStanfordFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			
			assertTrue(NLProTest().scanForOrganizationEntityInTaxonomyOrStanford(excel.getData(7, 1, 8), excel.getData(7, 1, 8)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the appropriate error message appears after doing a scan when editor area is empty in NLPRO Scan page", groups = { "Sanity" })
	public void verifyErrorMessageForScanForEmptyEditorAreaFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performScanForEmptyEditorAreaAndRetrieveErrorMessage(excel.getData(7, 1, 9)));
								
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the appropriate error message appears after doing a scan through the settings popup when editor area is empty in NLPRO Scan page", groups = { "Sanity" })
	public void verifyErrorMessageForScanThroughSettingsPopupForEmptyEditorAreaFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performScanThroughSettingsPopupForEmptyEditorAreaAndRetrieveErrorMessage(excel.getData(7, 1, 9)));
								
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the scan can be cancelled through the settings popup in NLPRO Scan page", groups = { "Sanity" })
	public void verifyCancelScanThroughSettingsPopupFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().cancelScanThroughScanModelSettingsPopup());
								
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the entered text gets marked after doing a spellcheck in NLPRO Scan page", groups = { "Sanity" })
	public void verifySpellcheckFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			NLProTest().performSpellcheck(excel.getData(8, 1, 0));
			
			boolean result = NLProTest().getSpellcheckedWord();
			
			assertTrue(result);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the entered text does not get marked after doing a spellcheck in NLPRO Scan page", groups = { "Sanity" })
	public void verifyNotSpellcheckedFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			NLProTest().performSpellcheck(excel.getData(8, 1, 1));
			
			boolean result = NLProTest().getUnSpellcheckedWord();
			
			assertTrue(result);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the specified suggestions appear after doing a spellcheck in NLPRO Scan page", groups = { "Sanity" })
	public void verifySpellcheckSuggestionsFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			NLProTest().performSpellcheckAndRightClickOnSpellcheckedWord(excel.getData(8, 1, 0));
			
			assertTrue(NLProTest().getFirstSuggestionData(excel.getData(8, 1, 2)));
			assertTrue(NLProTest().getSecondSuggestionData(excel.getData(8, 1, 3)));
			assertTrue(NLProTest().getThirdSuggestionData(excel.getData(8, 1, 4)));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the specified word can be added to dictionary after doing a spellcheck in NLPRO Scan page", groups = { "Sanity" })
	public void verifySpellcheckAddToDictionaryFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			NLProTest().performSpellcheckAndAddToDictionary(excel.getData(8, 1, 5));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the specified word can be ignored or unmarked after doing a spellcheck in NLPRO Scan page", groups = { "Sanity" })
	public void verifySpellcheckIgnoreAllFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			NLProTest().performSpellcheckAndIgnoreAll(excel.getData(8, 1, 6));
			assertTrue(NLProTest().getUnSpellcheckedWord());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the first suggestion is clickable and appears unmarked after doing a spellcheck in NLPRO Scan page", groups = { "Sanity" })
	public void verifySpellcheckSelectSuggestionFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			NLProTest().performSpellcheckAndRightClickOnSpellcheckedWord(excel.getData(8, 1, 0));
			NLProTest().clickFirstSuggestion();
			assertTrue(NLProTest().getUnSpellcheckedWord());
						
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the appropriate error message appears after doing a spellcheck when editor area is empty in NLPRO Scan page", groups = { "Sanity" })
	public void verifyErrorMessageForSpellcheckForEmptyEditorAreaFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performSpellCheckForEmptyEditorAreaAndRetrieveErrorMessage(excel.getData(8, 1, 7)));
								
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that the add to dictionary can be declined after doing a spellcheck in NLPRO Scan page", groups = { "Sanity" })
	public void verifyDeclineAddToDictionaryFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			NLProTest().performSpellcheckAndDeclineAddToDictionary(excel.getData(8, 1, 5));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page , after doing a spellcheck for empty editor area , the error popup can be dismissed by pressing the Escape key", groups = { "Sanity" })
	public void verifyDismissingErrorPopupForSpellcheckUsingEscapeKeyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			NLProTest().dismissErrorPopupForSpellcheckUsingEscapeKey();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page , after doing a spellcheck for empty editor area , the error popup can be dismissed by pressing the Enter key", groups = { "Sanity" })
	public void verifyDismissingErrorPopupForSpellcheckUsingEnterKeyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			NLProTest().dismissErrorPopupForSpellcheckUsingEnterKey();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page , after doing a spellcheck the confirmation for add to dictionary can be declined by pressing the Enter key", groups = { "Sanity" })
	public void verifyDecliningAddToDictionaryForSpellcheckUsingEnterKeyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			NLProTest().performSpellcheckAndDeclineAddToDictionaryUsingEnterKey(excel.getData(8, 1, 5));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page , after doing a fragment, the entered data does get fragmented", groups = { "Sanity" })
	public void verifyFragmentationFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performFragmentAndGetFragmentedElements(excel.getData(9, 1, 0)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page , after doing a fragment, the entered data does not get fragmented", groups = { "Sanity" })
	public void verifyNoFragmentationFunctionality1()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performFragmentAndVerifyUnFragmentedElements(excel.getData(9, 1, 7)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page , after doing a fragment, the entered data does not get fragmented", groups = { "Sanity" })
	public void verifyNoFragmentationFunctionality2()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performFragmentAndVerifyUnFragmentedElements(excel.getData(9, 1, 8)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page , after doing a fragment, the entered data does not get fragmented", groups = { "Sanity" })
	public void verifyNoFragmentationFunctionality3()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performFragmentAndVerifyUnFragmentedElements(excel.getData(9, 1, 9)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page when editor area is empty, after doing a fragment, the appropriate error message appears", groups = { "Sanity" })
	public void verifyErrorMessageForEmptyEditorDuringFragmentationFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performFragmentForEmptyEditorAreaAndRetrieveErrorMessage(excel.getData(9, 1, 1)));
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page , Renewal Clause extraction works", groups = { "Sanity" })
	public void verifyRenewalClauseExtractionFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			
			assertTrue(NLProTest().performRenewalClauseExtractionAndVerify(excel.getData(9, 1, 2),excel.getData(9, 1, 2)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page , Termination Clause extraction works", groups = { "Sanity" })
	public void verifyTerminationClauseExtractionFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performTerminationClauseExtractionAndVerify(excel.getData(9, 1, 3),excel.getData(9, 1, 3)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page , Refresh functionality works", groups = { "Sanity" })
	public void verifyRefreshFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performRefreshAndVerify(excel.getData(7, 1, 10),""));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page , the text entered is not a Renewal Clause", groups = { "Sanity" })
	public void verifyNoRenewalClauseExtractionFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performNoRenewalClauseExtractionAndVerify(excel.getData(9, 1, 5)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies that in NLPRO Scan page , the text entered is not a Termination Clause", groups = { "Sanity" })
	public void verifyNoTerminationClauseExtractionFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performNoTerminationClauseExtractionAndVerify(excel.getData(9, 1, 6)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	/*@AfterGroups(groups = { "Regression", "Sanity" }, alwaysRun = false)
	public void tearDown() {
		log("Logging out....");
		FoodPandaLoginLogout().foodPandaLogout();
	}*/

	@Test(description = "The test case verifies that in NLPRO Scan page , the spellcheck functionality can be invoked using the Enter key", groups = { "Sanity" })
	public void verifySpellcheckUsingEnterKeyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifySpellcheckUsingEnterKey(excel.getData(8, 1, 0)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	/*@Test(description = "The test case verifies that in NLPRO Scan page , the Twitter feed functionality can be invoked using the Enter key", groups = { "Sanity" })
	public void verifyInvokingTwitterFeedUsingEnterKeyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifySpellcheckUsingEnterKey(excel.getData(8, 1, 0)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}*/
	
	@Test(description = "The test case verifies that in NLPRO Scan page , after doing a fragment using the Enter key, the entered data does get fragmented", groups = { "Sanity" })
	public void verifyFragmentationUsingEnterKeyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().performFragmentUsingEnterKeyAndGetFragmentedElements(excel.getData(9, 1, 0)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the tool tip text of all controls in NLPRO Scan page", groups = { "Sanity" })
	public void verifyTooltipTextFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyTooltipTextForNamedEntityScanPageControls(excel.getData(7, 1, 11), excel.getData(7, 1, 12),
					excel.getData(7, 1, 13), excel.getData(7, 1, 14), excel.getData(7, 1, 15), excel.getData(7, 1, 16),
					excel.getData(7, 1, 17), excel.getData(7, 1, 18), excel.getData(7, 1, 19)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the sub menu of Scan header menu and traversal to Phrases Scan page", groups = { "Sanity" })
	public void verifyHoverOverScanHeaderAndTraversalToPhrasesScanFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyHoverOverScanAndClickOnPhrasesSubMenu(excel.getData(12, 1, 6)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the sub menu of Train header menu and traversal to Phrases Train page", groups = { "Sanity" })
	public void verifyHoverOverTrainHeaderAndTraversalToPhrasesTrainFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyHoverOverTrainAndClickOnPhrasesSubMenu(excel.getData(13, 1, 5)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the traversal to Templates page", groups = { "Sanity" })
	public void verifyTraversalToTemplateScreenFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyTraversalToTemplate(excel.getData(10, 1, 26)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the traversal to Lookup page", groups = { "Sanity" })
	public void verifyTraversalToLookupScreenFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyTraversalToLookup(excel.getData(11, 1, 13)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the untagging functionality in Named Entity Scan page", groups = { "Sanity" })
	public void verifyUntagFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyUntaggedText(excel.getData(7, 1, 20)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test
	public void testMethod() {
		
		System.out.println("Hello World");
	}
}
