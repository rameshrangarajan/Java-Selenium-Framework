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

public class NlproPhrasesTrainFunctionality extends NlproPageFactory {
	
	public static String excelPath1 = "D:\\Framework_New\\Framework\\Framework\\src\\main\\java\\com\\FP\\data\\Data.xlsx";
	ExcelDataConfig excel = new ExcelDataConfig(excelPath1);
	
	@Test(description = "The test case verifies upload text file functionality for NLPRO Phrases Train page", groups = { "Sanity" })
	public void verifyUploadTextFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProPhrasesTrainLocalURL).get(nlprophrasestrainlocalurl);

		
		try {
			NLProTest().uploadingTextFile(excel.getData(3, 1, 0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies error message for invalid file during upload text file functionality for NLPRO Phrases Train page", groups = { "Sanity" })
	public void verifyErrorMessageForInvalidFileTypeForUploadTextFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProPhrasesTrainLocalURL).get(nlprophrasestrainlocalurl);

		
		try {
			assertTrue(NLProTest().verifyErrorMessageForInvalidFileDuringTextFileUpload(excel.getData(3, 1, 1), excel.getData(3, 1, 2)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies error message for empty editor area during scan functionality for NLPRO Phrases Scan page", groups = { "Sanity" })
	public void verifyErrorMessageForEmptyEditorAreaDuringPhrasesTrainFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProPhrasesTrainLocalURL).get(nlprophrasestrainlocalurl);

		
		try {
			assertTrue(NLProTest().performPhrasesTrainForEmptyEditorAreaAndRetrieveErrorMessage(excel.getData(13, 1, 0)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that in NLPRO Phrases Train page , Refresh functionality works", groups = { "Sanity" })
	public void verifyRefreshFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProPhrasesTrainLocalURL).get(nlprophrasestrainlocalurl);

		
		try {
			
			assertTrue(NLProTest().performRefreshAndVerify(excel.getData(13, 1, 1),""));
			
			
			
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
		open(NLProPhrasesTrainLocalURL).get(nlprophrasestrainlocalurl);

		
		try {
			assertTrue(NLProTest().performPhrasesTrainUsingEnterKeyForEmptyEditorAreaAndRetrieveErrorMessage(excel.getData(13, 1, 0)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that in NLPRO Phrases Train page , Refresh functionality works", groups = { "Sanity" })
	public void verifyRefreshUsingEnterKeyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProPhrasesTrainLocalURL).get(nlprophrasestrainlocalurl);

		
		try {
			
			assertTrue(NLProTest().performRefreshUsingEnterKeyForPhrasesTrain(""));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the tool tip text of all controls in NLPRO Phrases Train page", groups = { "Sanity" })
	public void verifyTooltipTextForPhrasesTrainFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProPhrasesTrainLocalURL).get(nlprophrasestrainlocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyTooltipTextForPhrasesTrainPageControls(excel.getData(13, 1, 2), excel.getData(13, 1, 3),
					excel.getData(13, 1, 4)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}

}
