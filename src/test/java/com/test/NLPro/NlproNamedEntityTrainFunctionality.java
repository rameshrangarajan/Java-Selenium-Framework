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

public class NlproNamedEntityTrainFunctionality extends NlproPageFactory {
	
	public static String excelPath1 = "D:\\Framework_New\\Framework\\Framework\\src\\main\\java\\com\\FP\\data\\Data.xlsx";
	ExcelDataConfig excel = new ExcelDataConfig(excelPath1);
	
	@Test(description = "The test case verifies upload text file functionality for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyUploadTextFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			NLProTest().uploadingTextFile(excel.getData(3, 1, 0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies error message for invalid file during upload text file functionality for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyErrorMessageForInvalidFileTypeForUploadTextFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().verifyErrorMessageForInvalidFileDuringTextFileUpload(excel.getData(3, 1, 1), excel.getData(3, 1, 2)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies error message for empty editor area during train functionality for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyErrorMessageForEmptyEditorAreaDuringTrainFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performTrainForEmptyEditorAreaAndRetrieveErrorMessage(excel.getData(16, 1, 0)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that in NLPRO named Entity Scan page , Refresh functionality works", groups = { "Sanity" })
	public void verifyRefreshFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			
			assertTrue(NLProTest().performRefreshForNamedEntityTrainAndVerify(excel.getData(16, 1, 1),""));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies error message for empty editor area during train functionality using Enter key for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyErrorMessageForEmptyEditorAreaDuringNamedEntityTrainUsingEnterKeyFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performNamedEntityTrainUsingEnterKeyForEmptyEditorAreaAndRetrieveErrorMessage(excel.getData(16, 1, 0)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that in NLPRO Named Entity Train page , Refresh functionality using Enter key works", groups = { "Sanity" })
	public void verifyRefreshUsingEnterKeyFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			
			assertTrue(NLProTest().performRefreshUsingEnterKeyForNamedEntityTrain(""));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}

	@Test(description = "The test case verifies Lucene search functionality for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyLuceneSearchFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performLuceneSearch(excel.getData(14, 1, 0), excel.getData(14, 1, 1), excel.getData(14, 1, 3)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the preceding and the following lines retrieved for Lucene search functionality for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyPrecedingAndFollowingSentencesForLuceneSearchFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performLuceneSearchAndVerifyAllSearchResults(excel.getData(14, 1, 0), excel.getData(14, 1, 6), excel.getData(14, 1, 7), excel.getData(14, 1, 3)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies Lucene search functionality using the Enter key for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyLuceneSearchFunctionalityUsingEnterKey() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performLuceneSearchUsingEnterKey(excel.getData(14, 1, 0), excel.getData(14, 1, 1), excel.getData(14, 1, 3)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies Lucene search functionality using keyboard keys only for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyLuceneSearchFunctionalityUsingKeyboardKeysOnly() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performLuceneSearchUsingKeyboardKeysOnly(excel.getData(14, 1, 1), excel.getData(14, 1, 3)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies a failed Lucene search functionality for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyErrorMessageForFailedLuceneSearchFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performFailedLuceneSearch(excel.getData(14, 1, 4), excel.getData(14, 1, 5)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies Lucene search copy to editor functionality for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyLuceneSearchCopyToEditorFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performLuceneSearchCopyToEditor(excel.getData(14, 1, 0), excel.getData(14, 1, 1)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the paceholder text for Lucene search bar for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyPlaceholderTextForLuceneSearchBar() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().verifyLuceneSearchBarPlaceholderText(excel.getData(14, 1, 8)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}

	@Test(description = "The test case verifies save as template functionality for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifySaveAsTemplateFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performSaveAsTemplateFromTrainPage(excel.getData(15, 1, 0), excel.getData(15, 1, 6), excel.getData(15, 1, 1)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies save as template using the Enter key functionality for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifySaveAsTemplateUsingEnterKeyFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performSaveAsTemplateFromTrainPageUsingEnterKey(excel.getData(15, 1, 0), excel.getData(15, 1, 1)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies save as template functionality for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifySaveAsTemplateForUploadedTextFileFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performSaveAsTemplateUsingUploadedFileFromTrainPage(excel.getData(15, 1, 7), excel.getData(15, 1, 8), excel.getData(15, 1, 9)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the Replace button is disabled functionality for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyReplaceButtonDisabledScenarioFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().verifyReplaceButtonInPhraseReplacementPopupIsDisabled(excel.getData(15, 1, 0), excel.getData(15, 1, 2), excel.getData(15, 1, 3)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the cancel functionality for the phrase replacement NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyReplacePhraseCancelFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performPhraseReplacementCancel(excel.getData(15, 1, 0)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the error message for empty editor area during phrase replace functionality for the phrase replacement NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyErrorMessageForEmptyEditorDuringReplacePhraseFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performSaveAsTemplateForEmptyEditorArea(excel.getData(15, 1, 4)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the error message when data in editor was not selected during phrase replace functionality for the phrase replacement NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyErrorMessageForUnselectedDataInEditorDuringReplacePhraseFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().performSaveAsTemplateForUnselectedDataInEditorArea(excel.getData(15, 1, 0), excel.getData(15, 1, 5)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the tool tip text of all controls in NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyTooltipTextForNamedEntityTrainFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyTooltipTextForNamedEntityTrainPageControls(excel.getData(16, 1, 2), excel.getData(16, 1, 3),
					excel.getData(16, 1, 4), excel.getData(16, 1, 5)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the error message for incomplete word during phrase replacement in NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyErrorMessageForIncompleteWordNamedEntityTrainFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyErrorMessageForIncompleteWordDuringPhraseReplacementInNamedEntityTrainPage(excel.getData(15, 1, 7), excel.getData(15, 1, 10),
					excel.getData(15, 1, 11)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the Replace button is disabled functionality for NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyReplaceButtonDisabledScenarioFunctionalityForUploadedFile() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProNamedEntityTrainLocalURL).get(nlpronamedentitytrainlocalurl);

		
		try {
			assertTrue(NLProTest().verifyReplaceButtonInPhraseReplacementPopupIsDisabledForUploadedFile(excel.getData(15, 1, 7), excel.getData(15, 1, 10), excel.getData(15, 1, 11)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "This test case verifies not on-the-fly training functionality for PERSON entity in the NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyNotOnTheFlyTrainFunctionalityForPersonInNamedEntityTrainScreen() throws InterruptedException,AWTException {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProNamedEntityTrainURL).get(nlpronamedentitytrainpurl);

		
		try {
			assertTrue(NLProTest().verifyNotOnTheFlyTrainingForPerson(excel.getData(16, 1, 6), excel.getData(16, 1, 7),
					excel.getData(16, 1, 8), excel.getData(16, 1, 8), excel.getData(16, 1, 9)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
	}
	
	@Test(description = "This test case verifies not on-the-fly training functionality for LOCATION entity in the NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyNotOnTheFlyTrainFunctionalityForLocationInNamedEntityTrainScreen() throws InterruptedException,AWTException {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProNamedEntityTrainURL).get(nlpronamedentitytrainpurl);

		
		try {
			assertTrue(NLProTest().verifyNotOnTheFlyTrainingForLocation(excel.getData(16, 1, 10), excel.getData(16, 1, 11),
					excel.getData(16, 1, 12), excel.getData(16, 1, 13), excel.getData(16, 1, 14)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
	}
	
	@Test(description = "This test case verifies not on-the-fly training functionality for LOCATION entity in the NLPRO Named Entity Train page", groups = { "Sanity" })
	public void verifyNotOnTheFlyTrainFunctionalityForOrganizationInNamedEntityTrainScreen() throws InterruptedException,AWTException {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProNamedEntityTrainURL).get(nlpronamedentitytrainpurl);

		
		try {
			assertTrue(NLProTest().verifyNotOnTheFlyTrainingForOrganization(excel.getData(16, 1, 15), excel.getData(16, 1, 16),
					excel.getData(16, 1, 17), excel.getData(16, 1, 17), excel.getData(16, 1, 18)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
	}
}
