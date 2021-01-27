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

public class NlproPhrasesScanFunctionality extends NlproPageFactory {
	
	public static String excelPath1 = "D:\\Framework_New\\Framework\\Framework\\src\\main\\java\\com\\FP\\data\\Data.xlsx";
	ExcelDataConfig excel = new ExcelDataConfig(excelPath1);
	
	@Test(description = "The test case verifies upload text file functionality for NLPRO Phrases Scan page", groups = { "Sanity" })
	public void verifyUploadTextFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProPhrasesScanLocalURL).get(nlprophrasesscanlocalurl);

		
		try {
			NLProTest().uploadingTextFile(excel.getData(3, 1, 0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies error message for invalid file during upload text file functionality for NLPRO Phrases Scan page", groups = { "Sanity" })
	public void verifyErrorMessageForInvalidFileTypeForUploadTextFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProPhrasesScanLocalURL).get(nlprophrasesscanlocalurl);

		
		try {
			assertTrue(NLProTest().verifyErrorMessageForInvalidFileDuringTextFileUpload(excel.getData(3, 1, 1), excel.getData(3, 1, 2)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies upload HTML file functionality for NLPRO Phrases Scan page", groups = { "Sanity" })
	public void verifyUploadHtmlFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProPhrasesScanLocalURL).get(nlprophrasesscanlocalurl);

		
		try {
			NLProTest().uploadingHTMLFile(excel.getData(3, 1, 1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies error message for invalid file during upload html file functionality for NLPRO Phrases Scan page", groups = { "Sanity" })
	public void verifyErrorMessageForInvalidFileTypeForUploadHtmlFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProPhrasesScanLocalURL).get(nlprophrasesscanlocalurl);

		
		try {
			assertTrue(NLProTest().verifyErrorMessageForInvalidFileDuringHtmlFileUpload(excel.getData(3, 1, 0), excel.getData(3, 1, 3)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies error message for empty editor area during scan functionality for NLPRO Phrases Scan page", groups = { "Sanity" })
	public void verifyErrorMessageForEmptyEditorAreaDuringScanFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProPhrasesScanLocalURL).get(nlprophrasesscanlocalurl);

		
		try {
			assertTrue(NLProTest().performPhrasesScanForEmptyEditorAreaAndRetrieveErrorMessage(excel.getData(12, 1, 0)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that in NLPRO Phrases Scan page , Refresh functionality works", groups = { "Sanity" })
	public void verifyRefreshFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProPhrasesScanLocalURL).get(nlprophrasesscanlocalurl);

		
		try {
			
			assertTrue(NLProTest().performRefreshAndVerify(excel.getData(12, 1, 1),""));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies error message for empty editor area during scan functionality for NLPRO Phrases Scan page", groups = { "Sanity" })
	public void verifyErrorMessageForEmptyEditorAreaDuringPhrasesTrainUsingEnterKeyFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProPhrasesScanLocalURL).get(nlprophrasesscanlocalurl);

		
		try {
			assertTrue(NLProTest().performPhrasesScanUsingEnterKeyForEmptyEditorAreaAndRetrieveErrorMessage(excel.getData(12, 1, 0)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that in NLPRO Phrases Scan page , Refresh functionality works", groups = { "Sanity" })
	public void verifyRefreshUsingEnterKeyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProPhrasesScanLocalURL).get(nlprophrasesscanlocalurl);

		
		try {
			
			assertTrue(NLProTest().performRefreshUsingEnterKeyForPhrasesScan(""));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the tool tip text of all controls in NLPRO Phrases Scan page", groups = { "Sanity" })
	public void verifyTooltipTextForPhrasesScanFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProPhrasesScanLocalURL).get(nlprophrasesscanlocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyTooltipTextForPhrasesScanPageControls(excel.getData(12, 1, 2), excel.getData(12, 1, 3),
					excel.getData(12, 1, 4), excel.getData(12, 1, 5)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}

}
