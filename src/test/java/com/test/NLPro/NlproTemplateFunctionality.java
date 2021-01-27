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

public class NlproTemplateFunctionality extends NlproPageFactory {
	
	public static String excelPath1 = "D:\\Framework_New\\Framework\\Framework\\src\\main\\java\\com\\FP\\data\\Data.xlsx";
	ExcelDataConfig excel = new ExcelDataConfig(excelPath1);
	
	@Test(description = "The test case verifies new person template creation functionality for NLPRO Template page", groups = { "Sanity" })
	public void verifyNewPersonTemplateCreationFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().getNewPersonTemplateCreatedValue(excel.getData(10, 1, 0), excel.getData(10, 1, 1)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}

	@Test(description = "The test case verifies new location template creation functionality for NLPRO Template page", groups = { "Sanity" })
	public void verifyNewLocationTemplateCreationFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().getNewLocationTemplateCreatedValue(excel.getData(10, 1, 2), excel.getData(10, 1, 3)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies new organization template creation functionality for NLPRO Template page", groups = { "Sanity" })
	public void verifyNewOrganizationTemplateCreationFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().getNewOrganizationTemplateCreatedValue(excel.getData(10, 1, 4), excel.getData(10, 1, 5)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that the template corpus is invalid for NLPRO Template page", groups = { "Sanity" })
	public void verifyInvalidTemplateCorpusFunctionality1() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyInvalidTemplateCorpus(excel.getData(10, 1, 7), excel.getData(10, 1, 6)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that the template corpus is invalid for NLPRO Template page", groups = { "Sanity" })
	public void verifyInvalidTemplateCorpusFunctionality2() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyInvalidTemplateCorpus(excel.getData(10, 1, 8), excel.getData(10, 1, 6)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that the template corpus is invalid for NLPRO Template page", groups = { "Sanity" })
	public void verifyInvalidTemplateCorpusFunctionality3() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyInvalidTemplateCorpus(excel.getData(10, 1, 9), excel.getData(10, 1, 6)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that the template corpus is invalid for NLPRO Template page", groups = { "Sanity" })
	public void verifyInvalidTemplateCorpusFunctionality4() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyInvalidTemplateCorpus(excel.getData(10, 1, 10), excel.getData(10, 1, 6)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that a person template matching the entered template name already exists in NLPRO Template page", groups = { "Sanity" })
	public void verifyAlreadyExistingPersonTemplateFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyAlreadyExistingPersonTemplateErrorMessage(excel.getData(10, 1, 0), excel.getData(10, 1, 27), excel.getData(10, 1, 11)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that a location template matching the entered template name already exists in NLPRO Template page", groups = { "Sanity" })
	public void verifyAlreadyExistingLocationTemplateFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyAlreadyExistingLocationTemplateErrorMessage(excel.getData(10, 1, 2), excel.getData(10, 1, 28), excel.getData(10, 1, 12)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies that a organization template matching the entered template name already exists in NLPRO Template page", groups = { "Sanity" })
	public void verifyAlreadyExistingOrganizationTemplateFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyAlreadyExistingOrganizationTemplateErrorMessage(excel.getData(10, 1, 4), excel.getData(10, 1, 29), excel.getData(10, 1, 13)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the error message for empty editor area during template creation in NLPRO Template page", groups = { "Sanity" })
	public void verifyEmptyEditorAreaErrorMessageDuringTemplateCreationFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyEmptyEditorAreaTemplateErrorMessage(excel.getData(10, 1, 14)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the confirmation message for unsaved corpus in NLPRO Template page", groups = { "Sanity" })
	public void verifyConfirmationMessageForUnsavedCorpusFunctionalityScenario1() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyUnsavedTemplateConfirmationMessageScenario1(excel.getData(10, 1, 0), excel.getData(10, 1, 15)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the confirmation message for unsaved corpus in NLPRO Template page", groups = { "Sanity" })
	public void verifyConfirmationMessageForUnsavedCorpusFunctionalityScenario2() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyUnsavedTemplateConfirmationMessageScenario2(excel.getData(10, 1, 0), excel.getData(10, 1, 16)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the confirmation message for unsaved corpus in NLPRO Template page", groups = { "Sanity" })
	public void verifyConfirmationMessageForUnsavedCorpusFunctionalityScenario3() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyUnsavedTemplateConfirmationMessageScenario3(excel.getData(10, 1, 15)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the confirmation message for unsaved corpus in NLPRO Template page", groups = { "Sanity" })
	public void verifyConfirmationMessageForUnsavedCorpusFunctionalityScenario4() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyUnsavedTemplateConfirmationMessageScenario4(excel.getData(10, 1, 16)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the affirmation of the confirmation for unsaved corpus in NLPRO Template page", groups = { "Sanity" })
	public void verifyAffirmatonForUnsavedCorpusFunctionalityScenario1() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyAffirmationForUnsavedTemplateScenario1(excel.getData(10, 1, 0)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}

	@Test(description = "The test case verifies the affirmation of the confirmation for unsaved corpus in NLPRO Template page", groups = { "Sanity" })
	public void verifyAffirmatonForUnsavedCorpusFunctionalityScenario2() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyAffirmationForUnsavedTemplateScenario2(excel.getData(10, 1, 0), excel.getData(10, 1, 17)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the affirmation of the confirmation for unsaved corpus in NLPRO Template page", groups = { "Sanity" })
	public void verifyAffirmatonForUnsavedCorpusFunctionalityScenario3() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyAffirmationForUnsavedTemplateScenario3());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}

	@Test(description = "The test case verifies the affirmation of the confirmation for unsaved corpus in NLPRO Template page", groups = { "Sanity" })
	public void verifyAffirmatonForUnsavedCorpusFunctionalityScenario4() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyAffirmationForUnsavedTemplateScenario4(excel.getData(10, 1, 17)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the decline of the confirmation for unsaved corpus in NLPRO Template page", groups = { "Sanity" })
	public void verifyDeclineForUnsavedCorpusFunctionalityScenario1() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(!NLProTest().verifyDeclineForUnsavedTemplateScenario1(excel.getData(10, 1, 0)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}

	@Test(description = "The test case verifies the decline of the confirmation for unsaved corpus in NLPRO Template page", groups = { "Sanity" })
	public void verifyDeclineForUnsavedCorpusFunctionalityScenario2() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyDeclineForUnsavedTemplateScenario2(excel.getData(10, 1, 0), excel.getData(10, 1, 18)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the decline of the confirmation for unsaved corpus in NLPRO Template page", groups = { "Sanity" })
	public void verifyDeclineForUnsavedCorpusFunctionalityScenario3() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(!NLProTest().verifyDeclineForUnsavedTemplateScenario3());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}

	@Test(description = "The test case verifies the decline of the confirmation for unsaved corpus in NLPRO Template page", groups = { "Sanity" })
	public void verifyDeclineForUnsavedCorpusFunctionalityScenario4() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyDeclineForUnsavedTemplateScenario4(excel.getData(10, 1, 18)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the creation of new template from existing template functionality in NLPRO Template page", groups = { "Sanity" })
	public void verifyNewTemplateCreationFromExistingTemplateFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().getNewTemplateCreatedFromExistingTemplate(excel.getData(10, 1, 19)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the functionality of saving the changes made to an existing template in NLPRO Template page", groups = { "Sanity" })
	public void verifySaveChangesForTemplateFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().getSavedChangesFromExistingTemplate(excel.getData(10, 1, 20)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the inline error message for invalid template name in NLPRO Template page", groups = { "Sanity" })
	public void verifyErrorMessageForBlankTemplateNameFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().getErrorMessageForBlankNameForTemplate(excel.getData(10, 1, 0), "    ", excel.getData(10, 1, 21)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the cancel functionality for new template creation in NLPRO Template page", groups = { "Sanity" })
	public void verifyCancelNewTemplateCreationFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyCancelNewTemplateCreation(excel.getData(10, 1, 0)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the close functionality for new template creation popup in NLPRO Template page", groups = { "Sanity" })
	public void verifyCloseNewTemplateCreationFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyCloseNewTemplateCreationPopup(excel.getData(10, 1, 0)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the create new template functionality for new template using the Enter key in NLPRO Template page", groups = { "Sanity" })
	public void verifyCreationOfNewTemplateUsingEnterKeyFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyCreateNewTemplateUsingEnterKey(excel.getData(10, 1, 0), excel.getData(10, 1, 23)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the functionality to select a template using the Down Arrow key in NLPRO Template page", groups = { "Sanity" })
	public void verifySelectionOfTemplateUsingDownArrowKeyFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifySelectionOfTemplateUsingDownArrowKey(excel.getData(10, 1, 24)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
	
	@Test(description = "The test case verifies the functionality to create a new template using only the keys of the keyboard in NLPRO Template page", groups = { "Sanity" })
	public void verifyCreationOfNewTemplateUsingOnlyKeyboardKeysFunctionality() throws InterruptedException,AWTException {

		log("Starting test....");
		log("Logging in....");
		//open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);
		open(NLProTemplateLocalURL).get(nlprotemplatelocalurl);

		
		try {
			assertTrue(NLProTest().verifyCreationOfNewTemplateUsingOnlyKeyboardKeys(excel.getData(10, 1, 25)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
		// open(FoodPandaLoginURL).quit();
		// FoodPandaLoginLogout().foodPandaLogout();

	}
}
