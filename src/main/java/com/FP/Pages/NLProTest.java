package com.FP.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.FP.global.GlobalCommonMethods;
import com.FP.global.TestStepType;

public class NLProTest extends NlproWebElementLocators {

	GlobalCommonMethods GM = new GlobalCommonMethods();

	public void uploadingTextFile(String fileName) {

		try {
			log("Upoading Text File", TestStepType.INNER_SUBSTEP);

			// uploadFile(NLPRO_Upload_Text_Locator, fileName);
			GetElementLocator(NLPRO_Upload_Text_Locator).sendKeys(fileName);
			//getDriver().findElement(By.id("loadTextFile")).sendKeys(fileName);
			//waitForElement(NLPRO_Upload_Text_Locator).sendKeys(fileName);

			//WebElement element = findElementM(NLPRO_Upload_Text_Locator);
			//Actions actions = new Actions(getDriver());
			//actions.moveToElement(element).build().perform();
			//element.sendKeys(fileName);

			// JavascriptExecutor jse = (JavascriptExecutor)getDriver();
			// String js = "document.getElementById('" +
			// NLPRO_Upload_Text_Locator + "').style.visibility = 'visible';";
			// jse.executeScript(js, element);
			// jse.executeScript("document.getElementById('loadTextFile').setAttribute('type', 'text');");
			// jse.executeScript("document.getElementById('" +
			// NLPRO_Upload_Text_Locator + "').style.display='block';");
			// WebElement element = waitForElement(NLPRO_Upload_Text_Locator);
			// WebElement element = findElementM(NLPRO_Upload_Text_Locator);
			// String js = "arguments[0].style.visibility='visible';";

			// ((JavascriptExecutor) getDriver()).executeScript(js, element);

			// WebElement element = waitForElement(locator);
			// action.moveToElement(element).sendKeys(fileName).build().perform();
			// element.clear();
			// element.sendKeys(fileName);
			// WebElement form =
			// waitForElement(NLPRO_Scan_Upload_Data_Form_locator);
			// form.submit();
			pause(3);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public boolean verifyErrorMessageForInvalidFileDuringTextFileUpload(String filename, String expectedText) {
		pause(3);
		uploadingTextFile(filename);
		return verifyTextMatching(expectedText, NLPRO_Named_Entity_Scan_Invalid_File_Upload_Error_Message_Locator);
	}

	public void uploadingHTMLFile(String fileName) {

		try {
			log("Upoading HTML File", TestStepType.INNER_SUBSTEP);

			// uploadFile(NLPRO_Upload_Text_Locator, fileName);
			GetElementLocator(NLPRO_Upload_HTML_Locator).sendKeys(fileName);
			
			pause(3);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
   public boolean verifyErrorMessageForInvalidFileDuringHtmlFileUpload(String filename, String expectedText) {
	   pause(3);
	   uploadingHTMLFile(filename);
		return verifyTextMatching(expectedText, NLPRO_Named_Entity_Scan_Invalid_File_Upload_Error_Message_Locator);
	}
   
   public boolean verifyTrainOrganizationUsingTemplateForTextFileInScanScreen(String filename, String templatename, String modelname, String texttotrain, String count) throws Exception {
	   
	   pause(3);
	   uploadingTextFile(filename);
	   getTextPosition(NLPRO_Scan_Text_Area_Locator, texttotrain);
		//doubleClick(NLPRO_Scan_Text_Area_Locator);
		//rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Train_Menu);
		clickAndWait(NLPRO_Train_Organization_Menu_Locator);
		SelectNew(NLPRO_On_The_Fly_Train_Select_Template_Name_Locator, templatename);
		SelectNew(NLPRO_On_The_Fly_Train_Select_Model_Name_Locator, modelname);
		clickAndWait(NLPRO_On_The_Fly_Train_Train_Button_Locator);
		
		clickAndWait(NLPRO_Scan_Settings_Button_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
		SelectNew(NLPRO_Scan_Model_Settings_Left_Side_Select_Locator, modelname);
		clickAndWait(NLPRO_Scan_Model_Settings_Left_To_Right_Button_locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
		clickAndWait(NLPRO_Organization_Accordion_Locator);
		return (verifyTextMatching(texttotrain,NLPRO_Organization_Accordion_Value_Locator) &&
				verifyTextMatching(count,NLPRO_Organization_Accordion_Value_Count_Locator));
		
   }
   
   public boolean verifyTrainLocationUsingTemplateForTextFileInScanScreen(String filename, String templatename, String modelname, String texttotrain, String count) throws Exception {
	   
	   pause(3);
	   uploadingTextFile(filename);
		//doubleClick(NLPRO_Scan_Text_Area_Locator);
		//rightClick(NLPRO_Scan_Text_Area_Locator);
	  // dragAndHighlightAndRightClick(NLPRO_Scan_Text_Area_Locator);
	   getTextPosition(NLPRO_Scan_Text_Area_Locator, texttotrain);
	   //rightClick(NLPRO_Scan_Text_Area_Locator);
	   pause(3);
		hoverClick(NLPRO_Hover_Train_Menu);
		clickAndWait(NLPRO_Train_Location_Menu_Locator);
		SelectNew(NLPRO_On_The_Fly_Train_Select_Template_Name_Locator, templatename);
		SelectNew(NLPRO_On_The_Fly_Train_Select_Model_Name_Locator, modelname);
		clickAndWait(NLPRO_On_The_Fly_Train_Train_Button_Locator);
		
		clickAndWait(NLPRO_Scan_Settings_Button_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
		SelectNew(NLPRO_Scan_Model_Settings_Left_Side_Select_Locator, modelname);
		clickAndWait(NLPRO_Scan_Model_Settings_Left_To_Right_Button_locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
		clickAndWait(NLPRO_Person_Accordion_Locator);
		
		return (verifyTextMatching(texttotrain,NLPRO_Location_Accordion_Value_Locator) &&
				verifyTextMatching(count,NLPRO_Location_Accordion_Value_Count_Locator));
		
   }
   
   public boolean verifyTrainPersonUsingTemplateForTextFileInScanScreen(String filename, String templatename, String modelname, String texttotrain, String count) {
	   
	   pause(3);
	   uploadingTextFile(filename);
		//doubleClick(NLPRO_Scan_Text_Area_Locator);
		//rightClick(NLPRO_Scan_Text_Area_Locator);
	   //dragAndHighlightAndRightClick(NLPRO_Scan_Text_Area_Locator);
	   rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Train_Menu);
		clickAndWait(NLPRO_Train_Person_Menu_Locator);
		SelectNew(NLPRO_On_The_Fly_Train_Select_Template_Name_Locator, templatename);
		SelectNew(NLPRO_On_The_Fly_Train_Select_Model_Name_Locator, modelname);
		clickAndWait(NLPRO_On_The_Fly_Train_Train_Button_Locator);
		
		clickAndWait(NLPRO_Scan_Settings_Button_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
		SelectNew(NLPRO_Scan_Model_Settings_Left_Side_Select_Locator, modelname);
		clickAndWait(NLPRO_Scan_Model_Settings_Left_To_Right_Button_locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
		clickAndWait(NLPRO_Person_Accordion_Locator);
		
		return (verifyTextMatching(texttotrain,NLPRO_Person_Accordion_value_Locator) &&
				verifyTextMatching(count,NLPRO_Person_Accordion_Value_Count_Locator));
		
   }
   
 public boolean verifyTrainLocationUsingMultipleOccurrenceForTextFileInScanScreen(String filename, String modelname, String texttotrain, String count) throws Exception {
	   
	   pause(3);
	   uploadingTextFile(filename);
		//doubleClick(NLPRO_Scan_Text_Area_Locator);
		//rightClick(NLPRO_Scan_Text_Area_Locator);
	   //dragAndHighlightAndRightClick(NLPRO_Scan_Text_Area_Locator);
	   getTextPosition(NLPRO_Scan_Text_Area_Locator,texttotrain);
	   //rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Train_Menu);
		clickAndWait(NLPRO_Train_Location_Menu_Locator);
		//SelectNew(NLPRO_On_The_Fly_Train_Select_Template_Name_Locator, templatename);
		clickAndWait(NLPRO_On_The_Fly_Training_All_Occurrences_Checkbox_Locator);
		SelectNew(NLPRO_On_The_Fly_Train_Select_Model_Name_Locator, modelname);
		clickAndWait(NLPRO_On_The_Fly_Train_Train_Button_Locator);
		
		clickAndWait(NLPRO_Scan_Settings_Button_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
		SelectNew(NLPRO_Scan_Model_Settings_Left_Side_Select_Locator, modelname);
		clickAndWait(NLPRO_Scan_Model_Settings_Left_To_Right_Button_locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
		clickAndWait(NLPRO_Location_Accordion_Locator);
		
		return (verifyTextMatching(texttotrain,NLPRO_Location_Accordion_Value_Locator) &&
				verifyTextMatching(count,NLPRO_Location_Accordion_Value_Count_Locator));
		
   }
 
 public boolean verifyTrainPersonUsingMultipleOccurrenceForTextFileInScanScreen(String filename, String modelname, String texttotrain, String count) throws Exception {
	   
	   pause(3);
	   uploadingTextFile(filename);
		//doubleClick(NLPRO_Scan_Text_Area_Locator);
		//rightClick(NLPRO_Scan_Text_Area_Locator);
	   //dragAndHighlightAndRightClick(NLPRO_Scan_Text_Area_Locator);
	   getTextPosition(NLPRO_Scan_Text_Area_Locator,texttotrain);
	   //rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Train_Menu);
		clickAndWait(NLPRO_Train_Person_Menu_Locator);
		//SelectNew(NLPRO_On_The_Fly_Train_Select_Template_Name_Locator, templatename);
		clickAndWait(NLPRO_On_The_Fly_Training_All_Occurrences_Checkbox_Locator);
		SelectNew(NLPRO_On_The_Fly_Train_Select_Model_Name_Locator, modelname);
		clickAndWait(NLPRO_On_The_Fly_Train_Train_Button_Locator);
		
		clickAndWait(NLPRO_Scan_Settings_Button_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
		SelectNew(NLPRO_Scan_Model_Settings_Left_Side_Select_Locator, modelname);
		clickAndWait(NLPRO_Scan_Model_Settings_Left_To_Right_Button_locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
		clickAndWait(NLPRO_Person_Accordion_Locator);
		
		return (verifyTextMatching(texttotrain,NLPRO_Person_Accordion_value_Locator_For_Apricot_Billiboy) &&
				verifyTextMatching(count,NLPRO_Person_Accordion_Value_Count_Locator_For_Apricot_Billiboy));
		
 }
 
 public boolean verifyTrainOrganizationUsingMultipleOccurrenceForTextFileInScanScreen(String filename, String modelname, String texttotrain, String count) throws Exception {
	   
	   pause(3);
	   uploadingTextFile(filename);
		//doubleClick(NLPRO_Scan_Text_Area_Locator);
		//rightClick(NLPRO_Scan_Text_Area_Locator);
	   //dragAndHighlightAndRightClick(NLPRO_Scan_Text_Area_Locator);
	   getTextPosition(NLPRO_Scan_Text_Area_Locator,texttotrain);
	   //rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Train_Menu);
		clickAndWait(NLPRO_Train_Organization_Menu_Locator);
		//SelectNew(NLPRO_On_The_Fly_Train_Select_Template_Name_Locator, templatename);
		clickAndWait(NLPRO_On_The_Fly_Training_All_Occurrences_Checkbox_Locator);
		SelectNew(NLPRO_On_The_Fly_Train_Select_Model_Name_Locator, modelname);
		clickAndWait(NLPRO_On_The_Fly_Train_Train_Button_Locator);
		
		clickAndWait(NLPRO_Scan_Settings_Button_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
		SelectNew(NLPRO_Scan_Model_Settings_Left_Side_Select_Locator, modelname);
		clickAndWait(NLPRO_Scan_Model_Settings_Left_To_Right_Button_locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
		clickAndWait(NLPRO_Organization_Accordion_Locator);
		
		return (verifyTextMatching(texttotrain,NLPRO_Organization_Accordion_Value_Locator) &&
				verifyTextMatching(count,NLPRO_Organization_Accordion_Value_Count_Locator));
		
}

 public boolean verifyTrainPersonUsingSingleOccurrenceForTextFileInScanScreen(String filename, String modelname, String texttotrain, String count) throws Exception {
	   
	   pause(3);
	   uploadingTextFile(filename);
		//doubleClick(NLPRO_Scan_Text_Area_Locator);
		//rightClick(NLPRO_Scan_Text_Area_Locator);
	   //dragAndHighlightAndRightClick(NLPRO_Scan_Text_Area_Locator);
	   getTextPosition(NLPRO_Scan_Text_Area_Locator,texttotrain);
	   //rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Train_Menu);
		clickAndWait(NLPRO_Train_Person_Menu_Locator);
		//SelectNew(NLPRO_On_The_Fly_Train_Select_Template_Name_Locator, templatename);
		//clickAndWait(NLPRO_On_The_Fly_Training_All_Occurrences_Checkbox_Locator);
		SelectNew(NLPRO_On_The_Fly_Train_Select_Model_Name_Locator, modelname);
		clickAndWait(NLPRO_On_The_Fly_Train_Train_Button_Locator);
		
		clickAndWait(NLPRO_Scan_Settings_Button_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
		SelectNew(NLPRO_Scan_Model_Settings_Left_Side_Select_Locator, modelname);
		clickAndWait(NLPRO_Scan_Model_Settings_Left_To_Right_Button_locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
		clickAndWait(NLPRO_Person_Accordion_Locator);
		
		return (verifyTextMatching(texttotrain,NLPRO_Person_Accordion_value_Locator) &&
				verifyTextMatching(count,NLPRO_Person_Accordion_Value_Count_Locator));
		
}
 
 public boolean verifyTrainLocationUsingSingleOccurrenceForTextFileInScanScreen(String filename, String modelname, String texttotrain, String count) throws Exception {
	   
	   pause(3);
	   uploadingTextFile(filename);
		//doubleClick(NLPRO_Scan_Text_Area_Locator);
		//rightClick(NLPRO_Scan_Text_Area_Locator);
	   //dragAndHighlightAndRightClick(NLPRO_Scan_Text_Area_Locator);
	   getTextPosition(NLPRO_Scan_Text_Area_Locator,texttotrain);
	   //rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Train_Menu);
		clickAndWait(NLPRO_Train_Location_Menu_Locator);
		//SelectNew(NLPRO_On_The_Fly_Train_Select_Template_Name_Locator, templatename);
		//clickAndWait(NLPRO_On_The_Fly_Training_All_Occurrences_Checkbox_Locator);
		SelectNew(NLPRO_On_The_Fly_Train_Select_Model_Name_Locator, modelname);
		clickAndWait(NLPRO_On_The_Fly_Train_Train_Button_Locator);
		
		clickAndWait(NLPRO_Scan_Settings_Button_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
		SelectNew(NLPRO_Scan_Model_Settings_Left_Side_Select_Locator, modelname);
		clickAndWait(NLPRO_Scan_Model_Settings_Left_To_Right_Button_locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
		clickAndWait(NLPRO_Location_Accordion_Locator);
		
		return (verifyTextMatching(texttotrain,NLPRO_Location_Accordion_Value_Locator) &&
				verifyTextMatching(count,NLPRO_Location_Accordion_Value_Count_Locator));
		
}
 
   public boolean verifyTrainOrganizationUsingSingleOccurrenceForTextFileInScanScreen(String filename, String modelname, String texttotrain, String count) throws Exception {
	   
	   pause(3);
	   uploadingTextFile(filename);
		//doubleClick(NLPRO_Scan_Text_Area_Locator);
		//rightClick(NLPRO_Scan_Text_Area_Locator);
	   //dragAndHighlightAndRightClick(NLPRO_Scan_Text_Area_Locator);
	   getTextPosition(NLPRO_Scan_Text_Area_Locator,texttotrain);
	   //rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Train_Menu);
		clickAndWait(NLPRO_Train_Organization_Menu_Locator);
		//SelectNew(NLPRO_On_The_Fly_Train_Select_Template_Name_Locator, templatename);
		//clickAndWait(NLPRO_On_The_Fly_Training_All_Occurrences_Checkbox_Locator);
		SelectNew(NLPRO_On_The_Fly_Train_Select_Model_Name_Locator, modelname);
		clickAndWait(NLPRO_On_The_Fly_Train_Train_Button_Locator);
		
		clickAndWait(NLPRO_Scan_Settings_Button_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
		SelectNew(NLPRO_Scan_Model_Settings_Left_Side_Select_Locator, modelname);
		clickAndWait(NLPRO_Scan_Model_Settings_Left_To_Right_Button_locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
		clickAndWait(NLPRO_Organization_Accordion_Locator);
		
		return (verifyTextMatching(texttotrain,NLPRO_Organization_Accordion_Value_Locator) &&
				verifyTextMatching(count,NLPRO_Organization_Accordion_Value_Count_Locator));
		
}
 
	public void highlightAndRightClickTextInScanEditor(String text) {
		try {
			log("Entering text into editor", TestStepType.INNER_SUBSTEP);
			type(NLPRO_Scan_Text_Area_Locator, text);
			doubleClick(NLPRO_Scan_Text_Area_Locator);
			rightClick(NLPRO_Scan_Text_Area_Locator);
			pause(3);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public boolean performAddToPersonTaxonomyAndVerify(String text, String expectedText) {

		type(NLPRO_Scan_Text_Area_Locator, text);
		doubleClick(NLPRO_Scan_Text_Area_Locator);
		rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Add_Menu);
		clickAndWait(NLPRO_Select_Person_Sub_Menu_Locator);
		clickAndWait(NLPRO_Affirm_Add_To_Taxonomy_Locator);
		return verifyTextMatching(expectedText, NLPRO_Person_Accordion_value_Locator);
	}

	public boolean performAddToLocationTaxonomyAndVerify(String text,
			String expectedText) {

		type(NLPRO_Scan_Text_Area_Locator, text);
		doubleClick(NLPRO_Scan_Text_Area_Locator);
		rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Add_Menu);
		clickAndWait(NLPRO_Select_Location_Sub_Menu_Locator);
		clickAndWait(NLPRO_Affirm_Add_To_Taxonomy_Locator);
		return verifyTextMatching(expectedText,
				NLPRO_Location_Accordion_Value_Locator);
	}

	public boolean performAddToOrganizationTaxonomyAndVerify(String text,
			String expectedText) {

		type(NLPRO_Scan_Text_Area_Locator, text);
		doubleClick(NLPRO_Scan_Text_Area_Locator);
		rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Add_Menu);
		clickAndWait(NLPRO_Select_Organization_Sub_Menu_Locator);
		clickAndWait(NLPRO_Affirm_Add_To_Taxonomy_Locator);
		return verifyTextMatching(expectedText,
				NLPRO_Organization_Accordion_Value_Locator);
	}

	public boolean getErrorMessageForEntityAlreadyExistinginOrganizationTaxonomy(String text, String expectedText) {
		
		type(NLPRO_Scan_Text_Area_Locator, text);
		dragAndHighlightAndRightClick1(NLPRO_Scan_Text_Area_Locator);
		//rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Add_Menu);
		clickAndWait(NLPRO_Select_Organization_Sub_Menu_Locator);
		clickAndWait(NLPRO_Affirm_Add_To_Taxonomy_Locator);
		return verifyTextMatching(expectedText, NLPRO_Scan_Error_Message_For_Entity_Already_Existing_In_Taxonomy_Locator);
	}
	
   public boolean getErrorMessageForEntityAlreadyExistinginLocationTaxonomy(String text, String expectedText) {
		
		type(NLPRO_Scan_Text_Area_Locator, text);
		dragAndHighlightAndRightClick1(NLPRO_Scan_Text_Area_Locator);
		//rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Add_Menu);
		clickAndWait(NLPRO_Select_Location_Sub_Menu_Locator);
		clickAndWait(NLPRO_Affirm_Add_To_Taxonomy_Locator);
		return verifyTextMatching(expectedText, NLPRO_Scan_Error_Message_For_Entity_Already_Existing_In_Taxonomy_Locator);
	}
   
   public boolean getErrorMessageForEntityAlreadyExistinginPersonTaxonomy(String text, String expectedText) {
		
		type(NLPRO_Scan_Text_Area_Locator, text);
		dragAndHighlightAndRightClick1(NLPRO_Scan_Text_Area_Locator);
		//rightClick(NLPRO_Scan_Text_Area_Locator);
		hoverClick(NLPRO_Hover_Add_Menu);
		clickAndWait(NLPRO_Select_Person_Sub_Menu_Locator);
		clickAndWait(NLPRO_Affirm_Add_To_Taxonomy_Locator);
		return verifyTextMatching(expectedText, NLPRO_Scan_Error_Message_For_Entity_Already_Existing_In_Taxonomy_Locator);
	}
	
	public void hoverOverMenu() {

		try {
			log("hovering over add menu", TestStepType.INNER_SUBSTEP);
			hoverClick(NLPRO_Hover_Add_Menu);

			pause(3);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void affirmAddToTaxonomy() {

		// getDriver().switchTo().alert();
		clickAndWait(NLPRO_Affirm_Add_To_Taxonomy_Locator);
	}

	public void downLoadFileInLookup() {

		clickAndWait(NLPRO_Lookup_Screen_Locator);

		clickAndWait(NLPRO_Lookup_Organization_Folder_Locator);

		clickAndWait(NLPRO_Lookup_Bank_Names_File_Locator);

	}

	public void downLoadFileUsingEnterKeyInLookup() throws AWTException,
			InterruptedException {

		for (int i = 0; i < 14; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressEnterKey();

		for (int j = 0; j < 6; j++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressEnterKey();

		Thread.sleep(3000);
	}

	public boolean verifySpellcheckUsingEnterKey(String text)
			throws AWTException, InterruptedException {

		type(NLPRO_Scan_Text_Area_Locator, text);

		for (int i = 0; i < 13; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressEnterKey();
		Thread.sleep(3000);
		return verifyElementIsDisplayed(NLPRO_Spellchecked_Word_In_Text_Area_Locator);

	}

	/*
	 * public boolean verifyTwitterFeedRetrievalUsingEnterKey(String text)
	 * throws AWTException, InterruptedException {
	 * 
	 * 
	 * 
	 * for (int i = 1; i < 10; i++) {
	 * 
	 * 
	 * pressTabKey(); Thread.sleep(1000); }
	 * 
	 * pressEnterKey(); Thread.sleep(3000); return
	 * verifyElementIsDisplayed(NLPRO_Spellchecked_Word_In_Text_Area_Locator);
	 * 
	 * }
	 */

	public void getTwitterFeedByHashtag(String text) {

		clickAndWait(NLPRO_Twitter_Feed_Locator);
		clickAndWait(NLPRO_Hashtag_Checkbox_Locator);
		type(NLPRO_Hashtag_Input_Field_Locator, text);
		clickAndWait(NLPRO_Get_Feeds_Button_Locator);
	}

	public void cancelGetTwitterFeed() {

		clickAndWait(NLPRO_Twitter_Feed_Locator);
		clickAndWait(NLPRO_Hashtag_Checkbox_Locator);
		clickAndWait(NLPRO_Twitter_Popup_Cancel_Button_Locator);
	}

	public void twitterFeedInvalidHashtag(String text) {

		clickAndWait(NLPRO_Twitter_Feed_Locator);
		clickAndWait(NLPRO_Hashtag_Checkbox_Locator);
		type(NLPRO_Hashtag_Input_Field_Locator, text);
	}

	public void getTwitterFeedByHashtagUsingEnterKey(String text)
			throws AWTException {

		clickAndWait(NLPRO_Twitter_Feed_Locator);
		clickAndWait(NLPRO_Hashtag_Checkbox_Locator);
		type(NLPRO_Hashtag_Input_Field_Locator, text);
		pressEnterKey();
		pause(3);

	}

	public boolean getInvalidHashtagErrorMessage(String expectedText) {

		return verifyTextMatching(expectedText,
				NLPRO_Invalid_Hashtag_Error_Message_Locator);
	}

	public boolean getTwitterPopupLabel(String expectedText) {

		return verifyTextMatching(expectedText,
				NLPRO_Twitter_Popup_Header_Locator);
	}

	public void getTwitterFeedByUsername(String text) {

		clickAndWait(NLPRO_Twitter_Feed_Locator);
		clickAndWait(NLPRO_Username_Checkbox_Locator);
		type(NLPRO_Username_Input_Field_Locator, text);
		clickAndWait(NLPRO_Get_Feeds_Button_Locator);
	}

	public void twitterFeedInvalidUsername(String text) {

		clickAndWait(NLPRO_Twitter_Feed_Locator);
		clickAndWait(NLPRO_Username_Checkbox_Locator);
		type(NLPRO_Username_Input_Field_Locator, text);
	}

	public void getTwitterFeedByUsernameUsingEnterKey(String text)
			throws AWTException {

		clickAndWait(NLPRO_Twitter_Feed_Locator);
		clickAndWait(NLPRO_Username_Checkbox_Locator);
		type(NLPRO_Username_Input_Field_Locator, text);
		pressEnterKey();
		pause(3);

	}

	public void getTwitterFeedByUsernameAndHashtag(String hashtag,
			String username) throws AWTException {

		clickAndWait(NLPRO_Twitter_Feed_Locator);
		clickAndWait(NLPRO_Hashtag_Checkbox_Locator);
		type(NLPRO_Hashtag_Input_Field_Locator, hashtag);
		clickAndWait(NLPRO_Username_Checkbox_Locator);
		type(NLPRO_Username_Input_Field_Locator, username);
		clickAndWait(NLPRO_Get_Feeds_Button_Locator);

	}

	public boolean scanForPersonEntityInTaxonomyOrStanford(String person,
			String expectedText) {

		type(NLPRO_Scan_Text_Area_Locator, person);
		clickAndWait(NLPRO_Process_Button_Locator);
		clickAndWait(NLPRO_Person_Accordion_Locator);

		return verifyTextMatching(expectedText,
				NLPRO_Person_Accordion_value_Locator);

	}

	public boolean scanForLocationEntityInTaxonomyOrStanford(String location,
			String expectedText) {

		type(NLPRO_Scan_Text_Area_Locator, location);
		clickAndWait(NLPRO_Process_Button_Locator);
		clickAndWait(NLPRO_Location_Accordion_Locator);

		return verifyTextMatching(expectedText,
				NLPRO_Location_Accordion_Value_Locator);

	}

	public boolean scanForOrganizationEntityInTaxonomyOrStanford(
			String organization, String expectedText) {

		type(NLPRO_Scan_Text_Area_Locator, organization);
		clickAndWait(NLPRO_Process_Button_Locator);
		clickAndWait(NLPRO_Organization_Accordion_Locator);

		return verifyTextMatching(expectedText,
				NLPRO_Organization_Accordion_Value_Locator);

	}

	public boolean scanForOrganizationEntityNotInTaxonomy(String text) {

		type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Process_Button_Locator);
		return verifyElementNotDisplayed1(NLPRO_Organization_Accordion_Locator);

	}

	public boolean scanForPersonEntityNotInTaxonomy(String text) {

		type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Process_Button_Locator);

		return verifyElementNotDisplayed1(NLPRO_Person_Accordion_Locator);

	}

	public boolean scanForLocationEntityNotInTaxonomy(String text) {

		type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Process_Button_Locator);

		return verifyElementNotDisplayed1(NLPRO_Location_Accordion_Locator);
	}

	public void performSpellcheck(String text) {

		type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Spellcheck_Button_Locator);
	}

	public boolean performSpellCheckForEmptyEditorAreaAndRetrieveErrorMessage(
			String expectedText) {

		clickAndWait(NLPRO_Spellcheck_Button_Locator);
		return verifyTextMatching(expectedText,
				NLPRO_Spellcheck_Empty_Editor_Error_Message_Locator);

	}

	public boolean performScanForEmptyEditorAreaAndRetrieveErrorMessage(
			String expectedText) {

		clickAndWait(NLPRO_Process_Button_Locator);
		return verifyTextMatching(expectedText,
				NLPRO_Scan_Empty_Editor_Error_Message_Locator);

	}

	public boolean performPhrasesScanForEmptyEditorAreaAndRetrieveErrorMessage(
			String expectedText) {

		clickAndWait(NLPRO_Process_Button_Locator);
		return verifyTextMatching(expectedText,
				NLPRO_Phrases_Scan_Empty_Editor_Error_Message_Locator);

	}

	public boolean performTrainForEmptyEditorAreaAndRetrieveErrorMessage(
			String expectedText) {

		clickAndWait(NLPRO_Named_Entity_Train_Page_Train_Button_Locator);
		return verifyTextMatching(expectedText,
				NLPRO_Named_Entity_Train_Page_Empty_Editor_Area_Error_Message_Locator);

	}

	public boolean performPhrasesTrainForEmptyEditorAreaAndRetrieveErrorMessage(
			String expectedText) {

		clickAndWait(NLPRO_Phrases_Train_Page_Train_Button_Locator);
		return verifyTextMatching(expectedText,
				NLPRO_Phrases_Train_Empty_Editor_Error_Message_Locator);

	}

	public boolean performPhrasesTrainUsingEnterKeyForEmptyEditorAreaAndRetrieveErrorMessage(
			String expectedText) throws AWTException, InterruptedException {

		for (int i = 1; i < 8; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressEnterKey();
		Thread.sleep(3000);
		return verifyTextMatching(expectedText,
				NLPRO_Phrases_Train_Empty_Editor_Error_Message_Locator);

	}

	public boolean performPhrasesScanUsingEnterKeyForEmptyEditorAreaAndRetrieveErrorMessage(
			String expectedText) throws AWTException, InterruptedException {

		for (int i = 1; i < 9; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressEnterKey();
		Thread.sleep(3000);
		return verifyTextMatching(expectedText,
				NLPRO_Phrases_Scan_Empty_Editor_Error_Message_Locator);

	}

	public boolean performNamedEntityTrainUsingEnterKeyForEmptyEditorAreaAndRetrieveErrorMessage(
			String expectedText) throws AWTException, InterruptedException {

		for (int i = 1; i < 8; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressEnterKey();
		Thread.sleep(3000);
		return verifyTextMatching(expectedText,
				NLPRO_Named_Entity_Train_Page_Empty_Editor_Area_Error_Message_Locator);

	}

	public boolean performRefreshUsingEnterKeyForPhrasesTrain(
			String expectedText) throws AWTException, InterruptedException {

		for (int i = 1; i < 10; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		typeDataIntoEditorUsingKeys();

		for (int i = 1; i < 12; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressEnterKey();
		Thread.sleep(3000);
		return verifyTextMatching(expectedText, NLPRO_Scan_Text_Area_Locator);

	}

	public boolean performRefreshUsingEnterKeyForPhrasesScan(String expectedText)
			throws AWTException, InterruptedException {

		for (int i = 1; i < 11; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		typeDataIntoEditorUsingKeys();

		for (int i = 1; i < 13; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressEnterKey();
		Thread.sleep(3000);
		return verifyTextMatching(expectedText, NLPRO_Scan_Text_Area_Locator);

	}

	public boolean performRefreshUsingEnterKeyForNamedEntityTrain(
			String expectedText) throws AWTException, InterruptedException {

		for (int i = 1; i < 10; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		typeDataIntoEditorUsingKeys();

		for (int i = 1; i < 15; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressEnterKey();
		Thread.sleep(3000);
		return verifyTextMatching(expectedText,
				NLPRO_Named_Entity_Train_Text_Area_Locator);

	}

	public boolean performLuceneSearch(String text, String expectedText,
			String tooltiptext) {

		type(NLPRO_Lucene_Search_Input_Locator, text);
		clickAndWait(NLPRO_Lucene_Search_Button_Locator);

		return (verifyTextMatching(expectedText,
				NLPRO_Lucene_Search_Results_Locator) && getToolTipText(
				NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Locator,
				tooltiptext));

	}

	public boolean performPhraseReplacementCancel(String text)
			throws AWTException {

		type(NLPRO_Lucene_Search_Input_Locator, text);
		clickAndWait(NLPRO_Lucene_Search_Button_Locator);
		clickAndWait(NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Locator);
		clickAndWait(NLPRO_Named_Entity_Train_Text_Area_Locator);
		selectAllTextInEditor();
		clickAndWait(NLPRO_Save_As_Template_Button_Locator);
		type(NLPRO_Phrase_To_Replace_Input_Field_Locator, text);
		clickAndWait(NLPRO_Phrase_To_Replace_Cancel_Button_Locator);

		return verifyElementNotDisplayed1(NLPRO_Phrase_To_Replace_Popup_Header_Label_Locator);

	}

	public boolean performSaveAsTemplateForEmptyEditorArea(String expectedText)
			throws AWTException {

		clickAndWait(NLPRO_Save_As_Template_Button_Locator);

		return verifyTextMatching(expectedText,
				NLPRO_Save_As_Template_Empty_Editor_Area_Error_Message_Locator);

	}

	public boolean performSaveAsTemplateForUnselectedDataInEditorArea(
			String text, String expectedText) throws AWTException {

		type(NLPRO_Named_Entity_Train_Text_Area_Locator, text);

		clickAndWait(NLPRO_Save_As_Template_Button_Locator);

		return verifyTextMatching(expectedText,
				NLPRO_Save_As_Template_Unselected_Data_In_Editor_Area_Error_Message_Locator);

	}

	public boolean performLuceneSearchCopyToEditor(String text,
			String expectedText) {

		type(NLPRO_Lucene_Search_Input_Locator, text);
		clickAndWait(NLPRO_Lucene_Search_Button_Locator);
		clickAndWait(NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Locator);

		return (verifyTextMatching(expectedText,
				NLPRO_Named_Entity_Train_Text_Area_Locator));

	}

	public boolean verifyLuceneSearchBarPlaceholderText(String expectedText) {

		return (getPlaceholderText(NLPRO_Lucene_Search_Input_Locator,
				expectedText));

	}

	public boolean verifyLookupSearchBarPlaceholderText(String expectedText) {

		return (getPlaceholderText(NLPRO_Lookup_Search_Input_Locator,
				expectedText));

	}

	public boolean verifyTaxonomyFolders() throws InterruptedException {

		Thread.sleep(4000);
		return (verifyElementIsDisplayed(NLPRO_Lookup_Extension_Folder_Locator)
				&& verifyElementIsDisplayed(NLPRO_Lookup_Filter_Folder_Locator)
				&& verifyElementIsDisplayed(NLPRO_Lookup_Kyc_Folder_Locator)
				&& verifyElementIsDisplayed(NLPRO_Lookup_Location_Folder_Locator)
				&& verifyElementIsDisplayed(NLPRO_Lookup_Money_Folder_Locator)
				&& verifyElementIsDisplayed(NLPRO_Lookup_Organization_Folder_Locator)
				&& verifyElementIsDisplayed(NLPRO_Lookup_Person_Folder_Locator)
				&& verifyElementIsDisplayed(NLPRO_Lookup_Swift_Folder_Locator) && verifyElementIsDisplayed(NLPRO_Lookup_Titles_Folder_Locator));

	}

	public boolean performSaveAsTemplateFromTrainPage(String texttoreplace, String corpus,
			String expectedText) throws AWTException, InterruptedException {

		type(NLPRO_Named_Entity_Train_Text_Area_Locator, corpus);
		//clickAndWait(NLPRO_Lucene_Search_Button_Locator);
		//clickAndWait(NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Locator);
		clickAndWait(NLPRO_Named_Entity_Train_Text_Area_Locator);
		selectAllTextInEditor();
		clickAndWait(NLPRO_Save_As_Template_Button_Locator);
		type(NLPRO_Phrase_To_Replace_Input_Field_Locator, texttoreplace);
		clickAndWait(NLPRO_Phrase_To_Replace_Button_Locator);
		Thread.sleep(3000);
		return (verifyTextMatching(expectedText, NLPRO_Template_Text_Area_Locator));

	}
	
	public boolean performSaveAsTemplateUsingUploadedFileFromTrainPage(String filename, String texttoreplace,
			String expectedText) throws AWTException, InterruptedException {

		pause(3);
		uploadingTextFile(filename);
		//type(NLPRO_Named_Entity_Train_Text_Area_Locator, corpus);
		//clickAndWait(NLPRO_Lucene_Search_Button_Locator);
		//clickAndWait(NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Locator);
		clickAndWait(NLPRO_Named_Entity_Train_Text_Area_Locator);
		selectAllTextInEditor();
		clickAndWait(NLPRO_Save_As_Template_Button_Locator);
		type(NLPRO_Phrase_To_Replace_Input_Field_Locator, texttoreplace);
		clickAndWait(NLPRO_Phrase_To_Replace_Button_Locator);
		Thread.sleep(3000);
		return (verifyTextMatching(expectedText, NLPRO_Template_Text_Area_Locator));

	}
	
	public boolean verifyErrorMessageForIncompleteWordDuringPhraseReplacementInNamedEntityTrainPage(String filename, String texttoreplace,
			String errormessage) throws AWTException, InterruptedException {

		pause(3);
		uploadingTextFile(filename);
		//type(NLPRO_Named_Entity_Train_Text_Area_Locator, corpus);
		//clickAndWait(NLPRO_Lucene_Search_Button_Locator);
		//clickAndWait(NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Locator);
		clickAndWait(NLPRO_Named_Entity_Train_Text_Area_Locator);
		selectAllTextInEditor();
		clickAndWait(NLPRO_Save_As_Template_Button_Locator);
		type(NLPRO_Phrase_To_Replace_Input_Field_Locator, texttoreplace);
		
		Thread.sleep(2000);
		return (verifyTextMatching(errormessage, NLPRO_Phrase_To_Replace_Inline_Error_Message_Locator));

	}

	public boolean performSaveAsTemplateFromTrainPageUsingEnterKey(String text,
			String expectedText) throws AWTException, InterruptedException {

		type(NLPRO_Lucene_Search_Input_Locator, text);
		clickAndWait(NLPRO_Lucene_Search_Button_Locator);
		clickAndWait(NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Locator);
		clickAndWait(NLPRO_Named_Entity_Train_Text_Area_Locator);
		selectAllTextInEditor();
		clickAndWait(NLPRO_Save_As_Template_Button_Locator);
		type(NLPRO_Phrase_To_Replace_Input_Field_Locator, text);
		pressEnterKey();
		Thread.sleep(3000);
		return (verifyTextMatching(expectedText,
				NLPRO_Template_Text_Area_Locator));

	}

	public boolean verifyReplaceButtonInPhraseReplacementPopupIsDisabled(
			String text, String text1, String expectedText)
			throws AWTException, InterruptedException {

		type(NLPRO_Lucene_Search_Input_Locator, text);
		clickAndWait(NLPRO_Lucene_Search_Button_Locator);
		clickAndWait(NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Locator);
		clickAndWait(NLPRO_Named_Entity_Train_Text_Area_Locator);
		selectAllTextInEditor();
		clickAndWait(NLPRO_Save_As_Template_Button_Locator);
		type(NLPRO_Phrase_To_Replace_Input_Field_Locator, text1);
		// clickAndWait(NLPRO_Phrase_To_Replace_Button_Locator);
		return (verifyTextMatching(expectedText,
				NLPRO_Phrase_To_Replace_Inline_Error_Message_Locator) && !isElementClickable(NLPRO_Phrase_To_Replace_Button_Locator));

	}

	public boolean verifyReplaceButtonInPhraseReplacementPopupIsDisabledForUploadedFile(
			String filename, String text, String errorText)
			throws AWTException, InterruptedException {

		uploadingTextFile(filename);
		//type(NLPRO_Named_Entity_Train_Text_Area_Locator, corpus);
		//clickAndWait(NLPRO_Lucene_Search_Button_Locator);
		//clickAndWait(NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Locator);
		clickAndWait(NLPRO_Named_Entity_Train_Text_Area_Locator);
		selectAllTextInEditor();
		clickAndWait(NLPRO_Save_As_Template_Button_Locator);
		type(NLPRO_Phrase_To_Replace_Input_Field_Locator, text);
		
		Thread.sleep(2000);
		return (verifyTextMatching(errorText,
				NLPRO_Phrase_To_Replace_Inline_Error_Message_Locator) && !isElementClickable(NLPRO_Phrase_To_Replace_Button_Locator));

	}

	public boolean performLuceneSearchAndVerifyAllSearchResults(String text,
			String expectedText1, String expectedText2, String tooltiptext) {

		type(NLPRO_Lucene_Search_Input_Locator, text);
		clickAndWait(NLPRO_Lucene_Search_Button_Locator);

		return (verifyTextMatching(expectedText1,
				NLPRO_Lucene_Search_Results_Preceding_Sentence_Locator)
				&& verifyTextMatching(expectedText2,
						NLPRO_Lucene_Search_Results_Following_Sentence_Locator)
				&& getToolTipText(
						NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Preceding_Sentence_Locator,
						tooltiptext) && getToolTipText(
					NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Following_Sentence_Locator,
					tooltiptext));

	}

	public boolean performFailedLuceneSearch(String text, String errorText) {

		type(NLPRO_Lucene_Search_Input_Locator, text);
		clickAndWait(NLPRO_Lucene_Search_Button_Locator);

		return (verifyTextMatching(errorText,
				NLPRO_Lucene_Failed_Search_Error_Message));

	}

	public boolean performLuceneSearchUsingEnterKey(String text,
			String expectedText, String tooltiptext) throws AWTException {

		type(NLPRO_Lucene_Search_Input_Locator, text);
		pressEnterKey();

		return (verifyTextMatching(expectedText,
				NLPRO_Lucene_Search_Results_Locator) && getToolTipText(
				NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Locator,
				tooltiptext));

	}

	public boolean performLuceneSearchUsingKeyboardKeysOnly(
			String expectedText, String tooltiptext) throws AWTException,
			InterruptedException {

		for (int i = 1; i < 12; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		typeDataIntoLuceneSearchFieldUsingKeys();

		pressEnterKey();
		Thread.sleep(3000);
		return (verifyTextMatching(expectedText,
				NLPRO_Lucene_Search_Results_Locator) && getToolTipText(
				NLPRO_Lucene_Search_Results_Copy_To_Editor_Link_Locator,
				tooltiptext));

	}

	public boolean performScanThroughSettingsPopupForEmptyEditorAreaAndRetrieveErrorMessage(
			String expectedText) {

		clickAndWait(NLPRO_Scan_Settings_Button_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
		return verifyTextMatching(expectedText,
				NLPRO_Scan_Empty_Editor_Error_Message_Locator);

	}

	public boolean cancelScanThroughScanModelSettingsPopup() {

		clickAndWait(NLPRO_Scan_Settings_Button_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
		clickAndWait(NLPRO_Scan_Model_Settings_Cancel_Button_Locator);
		return verifyElementNotDisplayed1(NLPRO_Scan_Model_Settings_Header_Label_Locator);

	}

	public boolean performRenewalClauseExtractionAndVerify(String text,
			String expectedText) {

		// text = text.replace("\n", Keys.ENTER);
		type(NLPRO_Scan_Text_Area_Locator, text);

		clickAndWait(NLPRO_Process_Button_Locator);

		clickAndWait(NLPRO_Renewal_Clause_Accordion_Locator);

		return verifyTextMatching(expectedText,
				NLPRO_Renewal_Clause_Accordion_Value_Locator);

	}

	public boolean performNoRenewalClauseExtractionAndVerify(String text) {

		// text = text.replace("\n", Keys.ENTER);
		type(NLPRO_Scan_Text_Area_Locator, text);

		clickAndWait(NLPRO_Process_Button_Locator);

		return verifyElementNotDisplayed1(NLPRO_Renewal_Clause_Accordion_Locator);

	}

	public boolean performTerminationClauseExtractionAndVerify(String text,
			String expectedText) {

		// text = text.replace("\n", Keys.ENTER);
		type(NLPRO_Scan_Text_Area_Locator, text);

		clickAndWait(NLPRO_Process_Button_Locator);

		clickAndWait(NLPRO_Termination_Clause_Accordion_Locator);

		return verifyTextMatching(expectedText,
				NLPRO_Termination_Clause_Accordion_Value_Locator);

	}

	public boolean performNoTerminationClauseExtractionAndVerify(String text) {

		type(NLPRO_Scan_Text_Area_Locator, text);

		clickAndWait(NLPRO_Process_Button_Locator);

		return verifyElementNotDisplayed1(NLPRO_Termination_Clause_Accordion_Locator);

	}

	public boolean performRefreshAndVerify(String text, String expectedText) {

		// text = text.replace("\n", Keys.ENTER);
		type(NLPRO_Scan_Text_Area_Locator, text);

		clickAndWait(NLPRO_Refresh_Button_Locator);

		return verifyTextMatching(expectedText, NLPRO_Scan_Text_Area_Locator);

	}

	public boolean performRefreshForNamedEntityTrainAndVerify(String text,
			String expectedText) {

		// text = text.replace("\n", Keys.ENTER);
		type(NLPRO_Named_Entity_Train_Text_Area_Locator, text);

		clickAndWait(NLPRO_Refresh_Button_Locator);

		return verifyTextMatching(expectedText,
				NLPRO_Named_Entity_Train_Text_Area_Locator);

	}

	public void dismissErrorPopupForSpellcheckUsingEscapeKey()
			throws AWTException {

		clickAndWait(NLPRO_Spellcheck_Button_Locator);
		pressEscapeKey();
	}

	public void dismissErrorPopupForSpellcheckUsingEnterKey()
			throws AWTException {

		clickAndWait(NLPRO_Spellcheck_Button_Locator);
		pressEnterKey();
	}

	public void performSpellcheckAndRightClickOnSpellcheckedWord(String text) {

		type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Spellcheck_Button_Locator);
		rightClick(NLPRO_Spellchecked_Word_In_Text_Area_Locator);
		hoverClick(NLPRO_Suggestions_Menu_Locator);

	}

	public void performSpellcheckAndAddToDictionary(String text) {

		type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Spellcheck_Button_Locator);
		rightClick(NLPRO_Spellchecked_Word_In_Text_Area_Locator);
		pause(3);
		clickAndWait(NLPRO_Add_To_Dictionary_Menu_Locator);
		clickAndWait(NLPRO_Add_To_Dictionary_Confirmation_Yes_Button_Locator);

	}

	public void performSpellcheckAndDeclineAddToDictionary(String text) {

		type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Spellcheck_Button_Locator);
		rightClick(NLPRO_Spellchecked_Word_In_Text_Area_Locator);
		clickAndWait(NLPRO_Add_To_Dictionary_Menu_Locator);
		clickAndWait(NLPRO_Add_To_Dictionary_Confirmation_No_Button_Locator);

	}

	public void performSpellcheckAndDeclineAddToDictionaryUsingEnterKey(
			String text) throws AWTException {

		type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Spellcheck_Button_Locator);
		rightClick(NLPRO_Spellchecked_Word_In_Text_Area_Locator);
		clickAndWait(NLPRO_Add_To_Dictionary_Menu_Locator);
		pressEnterKey();

	}

	public boolean performFragmentAndGetFragmentedElements(String filename)
			throws InterruptedException {

		// text = text.replace("and", Keys.ENTER);
		// text = text.replaceAll("\n", "\n\r");
		uploadingTextFile(filename);

		//Thread.sleep(15000);

		clickAndWait(NLPRO_Fragment_Button_Locator);

		return (verifyElementIsDisplayed(NLPRO_Fragmented_Text_Locator1) && verifyElementIsDisplayed(NLPRO_Fragmented_Text_Locator2));

	}

	public boolean performFragmentUsingEnterKeyAndGetFragmentedElements(
			String filename) throws InterruptedException, AWTException {

		// text = text.replace("and", Keys.ENTER);
		// text = text.replaceAll("\n", "\n\r");
		pause(3);
		uploadingTextFile(filename);

		for (int i = 0; i < 11; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressEnterKey();
		Thread.sleep(3000);

		return (verifyElementIsDisplayed(NLPRO_Fragmented_Text_Locator1) && verifyElementIsDisplayed(NLPRO_Fragmented_Text_Locator2));

	}

	public boolean verifyTooltipTextForNamedEntityScanPageControls(
			String uploadHTMLtooltip, String uploadTexttooltip,
			String facebooktooltip, String twittertooltip,
			String spellchecktooltip, String fragmenttooltip,
			String processtooltip, String scansettingstooltip,
			String refreshtooltip) {

		return (getToolTipText(
				NLPRO_Named_Entity_Scan_Upload_HTML_Button_Locator,
				uploadHTMLtooltip)
				&& getToolTipText(
						NLPRO_Named_Entity_Scan_Upload_Text_Button_Locator,
						uploadTexttooltip)
				&& getToolTipText(
						NLPRO_Named_Entity_Get_Facebook_Feeds_Button_Locator,
						facebooktooltip)
				&& getToolTipText(NLPRO_Twitter_Feed_Locator, twittertooltip)
				&& getToolTipText(NLPRO_Spellcheck_Button_Locator,
						spellchecktooltip)
				&& getToolTipText(NLPRO_Fragment_Button_Locator,
						fragmenttooltip)
				&& getToolTipText(NLPRO_Process_Button_Locator, processtooltip)
				&& getToolTipText(NLPRO_Scan_Settings_Button_Locator,
						scansettingstooltip) && getToolTipText(
					NLPRO_Refresh_Button_Locator, refreshtooltip));

	}

	public boolean verifyHoverOverScanAndClickOnPhrasesSubMenu(String url)
			throws InterruptedException {

		hoverClick(NLPRO_Scan_Header_Menu_Locator);
		Thread.sleep(3000);
		clickAndWait(NLPRO_Header_Phrases_Scan_Sub_Menu);
		return verifyURL(url);

	}

	public boolean verifyHoverOverTrainAndClickOnPhrasesSubMenu(String url)
			throws InterruptedException {

		hoverClick(NLPRO_Train_Header_Menu_Locator);
		Thread.sleep(3000);
		clickAndWait(NLPRO_Header_Phrases_Train_Sub_Menu);
		return verifyURL(url);

	}

	public boolean verifyTraversalToTemplate(String url) {

		clickAndWait(NLPRO_Template_Screen_Header_Link);
		return verifyURL(url);

	}

	public boolean verifyTraversalToLookup(String url) {

		clickAndWait(NLPRO_Lookup_Screen_Header_Link);
		return verifyURL(url);

	}

	public boolean verifyUntaggedText(String text) {

		type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Process_Button_Locator);
		rightClick(NLPRO_Tagged_Text_In_Editor_Area_Locator);
		clickAndWait(NLPRO_Untag_Menu_Locator);

		return (verifyElementNotDisplayed1(NLPRO_Person_Accordion_value_Locator));

	}

	public boolean verifyTooltipTextForNamedEntityTrainPageControls(
			String uploadTexttooltip, String traintooltip,
			String refreshtooltip, String lucenesearchtooltip) {

		return (getToolTipText(
				NLPRO_Named_Entity_Train_Upload_Text_Button_Locator,
				uploadTexttooltip)
				&& getToolTipText(
						NLPRO_Named_Entity_Train_Train_Button_Locator,
						traintooltip)
				&& getToolTipText(
						NLPRO_Named_Entity_Train_Refresh_Button_Locator,
						refreshtooltip) && getToolTipText(
					NLPRO_Lucene_Search_Button_Locator, lucenesearchtooltip));

	}

	public boolean verifyTooltipTextForPhrasesScanPageControls(
			String uploadHTMLtooltip, String uploadTexttooltip,
			String processtooltip, String refreshtooltip) {

		return (getToolTipText(NLPRO_Phrases_Scan_Upload_HTML_Button_Locator,
				uploadHTMLtooltip)
				&& getToolTipText(
						NLPRO_Phrases_Scan_Upload_Text_Button_Locator,
						uploadTexttooltip)
				&& getToolTipText(NLPRO_Phrases_Scan_Process_Button_Locator,
						processtooltip) && getToolTipText(
					NLPRO_Phrases_Scan_Refresh_Button_Locator, refreshtooltip));

	}

	public boolean verifyTooltipTextForPhrasesTrainPageControls(
			String uploadTexttooltip, String traintooltip, String refreshtooltip) {

		return (getToolTipText(NLPRO_Phrases_Train_Upload_Text_Button_Locator,
				uploadTexttooltip)
				&& getToolTipText(NLPRO_Phrases_Train_Train_Button_Locator,
						traintooltip) && getToolTipText(
					NLPRO_Phrases_Train_Refresh_Button_Locator, refreshtooltip));

	}

	public boolean verifyTooltipTextForLookupPageControls(
			String downloadfiletooltip, String searchtooltip,
			String uploadfiletooltip) {

		clickAndWait(NLPRO_Lookup_Extension_Folder_Locator);
		return (getToolTipText(
				NLPRO_Lookup_Results_Table_Extension_Download_File_Button_Locator,
				downloadfiletooltip)
				&& getToolTipText(NLPRO_Lookup_Search_Button_Locator,
						searchtooltip) && getToolTipText(
					NLPRO_Lookup_Upload_File_Button_Locator, uploadfiletooltip));

	}

	public boolean performFragmentAndVerifyUnFragmentedElements(String filename)
			throws InterruptedException {

		// text = text.replace("and", Keys.ENTER);
		// text = text.replaceAll("\n", "\n\r");
		pause(3);
		uploadingTextFile(filename);

		//Thread.sleep(15000);
		clickAndWait(NLPRO_Fragment_Button_Locator);

		return (verifyElementNotDisplayed1(NLPRO_Fragmented_Text_Locator1)
				&& verifyElementNotDisplayed1(NLPRO_Fragmented_Text_Locator2)
				&& verifyElementNotDisplayed1(NLPRO_Fragmented_Text_Locator3)
				&& verifyElementNotDisplayed1(NLPRO_Fragmented_Text_Locator4) && verifyElementNotDisplayed1(NLPRO_Fragmented_Text_Locator5));

	}

	/*
	 * public boolean performFragmentAndVerifyUnFragmentedElements2(String text)
	 * throws InterruptedException {
	 * 
	 * //text = text.replace("and", Keys.ENTER);
	 * type(NLPRO_Scan_Text_Area_Locator, text);
	 * 
	 * Thread.sleep(15000); clickAndWait(NLPRO_Fragment_Button_Locator);
	 * 
	 * return (verifyElementNotDisplayed1(NLPRO_Fragmented_Text_Locator1) &&
	 * verifyElementNotDisplayed1(NLPRO_Fragmented_Text_Locator2) &&
	 * verifyElementNotDisplayed1(NLPRO_Fragmented_Text_Locator3) &&
	 * verifyElementNotDisplayed1(NLPRO_Fragmented_Text_Locator4) &&
	 * verifyElementNotDisplayed1(NLPRO_Fragmented_Text_Locator5));
	 * 
	 * 
	 * }
	 */

	public boolean performFragmentForEmptyEditorAreaAndRetrieveErrorMessage(
			String expectedText) {

		clickAndWait(NLPRO_Fragment_Button_Locator);
		return verifyTextMatching(expectedText,
				NLPRO_Fragment_Empty_Editor_Error_Message_Locator);
	}

	public void performSpellcheckAndIgnoreAll(String text) {

		type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Spellcheck_Button_Locator);
		rightClick(NLPRO_Spellchecked_Word_In_Text_Area_Locator);
		clickAndWait(NLPRO_Ignore_All_Menu_Locator);
	}

	public boolean getFirstSuggestionData(String expectedText) {

		return verifyTextMatching(expectedText, NLPRO_First_Suggestion_Locator);
	}

	public void clickFirstSuggestion() {

		clickAndWait(NLPRO_First_Suggestion_Locator);
	}

	public boolean getSecondSuggestionData(String expectedText) {

		return verifyTextMatching(expectedText, NLPRO_Second_Suggestion_Locator);
	}

	public boolean getThirdSuggestionData(String expectedText) {

		return verifyTextMatching(expectedText, NLPRO_Third_Suggestion_Locator);
	}

	public boolean getSpellcheckedWord() {
		return verifyElementIsDisplayed(NLPRO_Spellchecked_Word_In_Text_Area_Locator);
	}

	public boolean getUnSpellcheckedWord() {

		return verifyElementNotDisplayed1(NLPRO_Spellchecked_Word_In_Text_Area_Locator);
	}

	public boolean getInvalidUsernameErrorMessage(String expectedText) {

		return verifyTextMatching(expectedText,
				NLPRO_Invalid_Username_Error_Message_Locator);
	}

	public boolean getNewPersonTemplateCreatedValue(String text,
			String expectedText) {

		type(NLPRO_Template_Text_Area_Locator, text);
		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);
		type(NLPRO_New_Template_Name_Input_Locator, expectedText);
		SelectNew(NLPRO_New_Template_Type_Select_Locator, "PERSON");
		clickAndWait(NLPRO_New_Template_Save_Template_Locator);
		return iSSelectedValueDisplayed(
				NLPRO_Select_Available_Person_Template_Locator, expectedText);

	}

	public boolean getNewLocationTemplateCreatedValue(String text,
			String expectedText) {

		type(NLPRO_Template_Text_Area_Locator, text);
		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);
		type(NLPRO_New_Template_Name_Input_Locator, expectedText);
		SelectNew(NLPRO_New_Template_Type_Select_Locator, "LOCATION");
		clickAndWait(NLPRO_New_Template_Save_Template_Locator);
		return iSSelectedValueDisplayed(
				NLPRO_Select_Available_Location_Template_Locator, expectedText);

	}

	public boolean getNewOrganizationTemplateCreatedValue(String text,
			String expectedText) {

		type(NLPRO_Template_Text_Area_Locator, text);
		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);
		type(NLPRO_New_Template_Name_Input_Locator, expectedText);
		SelectNew(NLPRO_New_Template_Type_Select_Locator, "ORGANIZATION");
		clickAndWait(NLPRO_New_Template_Save_Template_Locator);
		return iSSelectedValueDisplayed(
				NLPRO_Select_Available_Organization_Template_Locator,
				expectedText);

	}

	public boolean verifyInvalidTemplateCorpus(String text, String expectedText) {

		type(NLPRO_Template_Text_Area_Locator, text);
		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);
		return verifyTextMatching(expectedText,
				NLPRO_Template_Invalid_Corpus_Error_Message_Locator);

	}

	public boolean verifyAlreadyExistingPersonTemplateErrorMessage(
			String corpustext, String templatename, String expectedText) {

		type(NLPRO_Template_Text_Area_Locator, corpustext);
		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);
		type(NLPRO_New_Template_Name_Input_Locator, templatename);
		SelectNew(NLPRO_New_Template_Type_Select_Locator, "PERSON");
		return verifyTextMatching(expectedText,
				NLPRO_Template_Inline_Error_Message_Locator);

	}

	public boolean verifyAlreadyExistingLocationTemplateErrorMessage(
			String corpustext, String templatename, String expectedText) {

		type(NLPRO_Template_Text_Area_Locator, corpustext);
		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);
		type(NLPRO_New_Template_Name_Input_Locator, templatename);
		SelectNew(NLPRO_New_Template_Type_Select_Locator, "LOCATION");
		return verifyTextMatching(expectedText,
				NLPRO_Template_Inline_Error_Message_Locator);

	}

	public boolean verifyAlreadyExistingOrganizationTemplateErrorMessage(
			String corpustext, String templatename, String expectedText) {

		type(NLPRO_Template_Text_Area_Locator, corpustext);
		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);
		type(NLPRO_New_Template_Name_Input_Locator, templatename);
		SelectNew(NLPRO_New_Template_Type_Select_Locator, "ORGANIZATION");
		return verifyTextMatching(expectedText,
				NLPRO_Template_Inline_Error_Message_Locator);

	}

	public boolean verifyEmptyEditorAreaTemplateErrorMessage(String expectedText) {

		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);

		return verifyTextMatching(expectedText,
				NLPRO_Template_Empty_Editor_Area_Error_Message_Locator);

	}

	public boolean verifyUnsavedTemplateConfirmationMessageScenario1(
			String corpustext, String expectedText) {

		type(NLPRO_Template_Text_Area_Locator, corpustext);

		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 1);
		return verifyTextMatching(expectedText,
				NLPRO_Template_Unsaved_Corpus_Confirmation_Message_Locator);

	}

	public boolean verifyUnsavedTemplateConfirmationMessageScenario2(
			String corpustext, String expectedText) {

		type(NLPRO_Template_Text_Area_Locator, corpustext);

		clickAndWait(NLPRO_Train_Menu_Locator);
		return verifyTextMatching(expectedText,
				NLPRO_Template_Unsaved_Corpus_Confirmation_Message_Locator);

	}

	public boolean verifyUnsavedTemplateConfirmationMessageScenario3(
			String expectedText) throws AWTException {

		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 1);

		clickAndWait(NLPRO_Template_Text_Area_Locator);
		pressEnterKey();
		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 2);
		return verifyTextMatching(expectedText,
				NLPRO_Template_Unsaved_Corpus_Confirmation_Message_Locator);

	}

	public boolean verifyUnsavedTemplateConfirmationMessageScenario4(
			String expectedText) throws AWTException {

		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 1);

		clickAndWait(NLPRO_Template_Text_Area_Locator);
		pressEnterKey();
		clickAndWait(NLPRO_Train_Menu_Locator);
		return verifyTextMatching(expectedText,
				NLPRO_Template_Unsaved_Corpus_Confirmation_Message_Locator);

	}

	public boolean verifyAffirmationForUnsavedTemplateScenario1(
			String corpustext) throws AWTException {

		type(NLPRO_Template_Text_Area_Locator, corpustext);
		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 1);

		clickAndWait(NLPRO_Template_Confirmation_Yes_Button_Locator);

		return iSSelectedIndexDisplayed(NLPRO_Select_Available_Person_Template_Locator);

	}

	public boolean verifyAffirmationForUnsavedTemplateScenario2(
			String corpustext, String expectedText) throws AWTException {

		type(NLPRO_Template_Text_Area_Locator, corpustext);

		clickAndWait(NLPRO_Train_Menu_Locator);
		clickAndWait(NLPRO_Template_Confirmation_Yes_Button_Locator);

		return verifyTextMatching(expectedText, NLPRO_Page_Header_Label_Locator);

	}

	public boolean verifyAffirmationForUnsavedTemplateScenario3()
			throws AWTException {

		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 1);

		clickAndWait(NLPRO_Template_Text_Area_Locator);
		pressEnterKey();
		SelectByIndex(NLPRO_Select_Available_Location_Template_Locator, 1);
		clickAndWait(NLPRO_Template_Confirmation_Yes_Button_Locator);
		return iSSelectedIndexDisplayed(NLPRO_Select_Available_Location_Template_Locator);

	}

	public boolean verifyAffirmationForUnsavedTemplateScenario4(
			String expectedText) throws AWTException {

		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 1);

		clickAndWait(NLPRO_Template_Text_Area_Locator);
		pressEnterKey();
		clickAndWait(NLPRO_Train_Menu_Locator);
		clickAndWait(NLPRO_Template_Confirmation_Yes_Button_Locator);
		return verifyTextMatching(expectedText, NLPRO_Page_Header_Label_Locator);

	}

	public boolean verifyDeclineForUnsavedTemplateScenario1(String corpustext)
			throws AWTException {

		type(NLPRO_Template_Text_Area_Locator, corpustext);
		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 1);

		clickAndWait(NLPRO_Template_Confirmation_No_Button_Locator);

		return iSSelectedIndexDisplayed(NLPRO_Select_Available_Person_Template_Locator);

	}

	public boolean verifyDeclineForUnsavedTemplateScenario2(String corpustext,
			String expectedText) throws AWTException {

		type(NLPRO_Template_Text_Area_Locator, corpustext);

		clickAndWait(NLPRO_Train_Menu_Locator);
		clickAndWait(NLPRO_Template_Confirmation_No_Button_Locator);

		return verifyTextMatching(expectedText, NLPRO_Page_Header_Label_Locator);

	}

	public boolean verifyDeclineForUnsavedTemplateScenario3()
			throws AWTException {

		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 1);

		clickAndWait(NLPRO_Template_Text_Area_Locator);
		pressEnterKey();
		SelectByIndex(NLPRO_Select_Available_Location_Template_Locator, 1);
		clickAndWait(NLPRO_Template_Confirmation_No_Button_Locator);
		return iSSelectedIndexDisplayed(NLPRO_Select_Available_Location_Template_Locator);

	}

	public boolean verifyDeclineForUnsavedTemplateScenario4(String expectedText)
			throws AWTException {

		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 1);

		clickAndWait(NLPRO_Template_Text_Area_Locator);
		pressEnterKey();
		clickAndWait(NLPRO_Train_Menu_Locator);
		clickAndWait(NLPRO_Template_Confirmation_No_Button_Locator);
		return verifyTextMatching(expectedText, NLPRO_Page_Header_Label_Locator);

	}

	public boolean getNewTemplateCreatedFromExistingTemplate(String expectedText)
			throws AWTException {

		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 1);

		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);
		type(NLPRO_New_Template_Name_Input_Locator, expectedText);
		SelectNew(NLPRO_New_Template_Type_Select_Locator, "ORGANIZATION");
		clickAndWait(NLPRO_New_Template_Save_Template_Locator);
		return iSSelectedValueDisplayed(
				NLPRO_Select_Available_Organization_Template_Locator,
				expectedText);

	}

	public boolean getSavedChangesFromExistingTemplate(String text)
			throws AWTException {

		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 1);
		pause(2);
		clickAndWait(NLPRO_Template_Text_Area_Locator);
		pause(2);
		type(NLPRO_Template_Text_Area_Locator, text);
		clickAndWait(NLPRO_Template_Save_Changes_Button_Locator);
		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 2);
		SelectByIndex(NLPRO_Select_Available_Person_Template_Locator, 1);
		return verifyTextContains1(text, NLPRO_Template_Text_Area_Locator);

	}

	public boolean getErrorMessageForBlankNameForTemplate(String text,
			String spaces, String expectedText) throws AWTException {

		clickAndWait(NLPRO_Template_Text_Area_Locator);
		type(NLPRO_Template_Text_Area_Locator, text);
		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);
		type(NLPRO_New_Template_Name_Input_Locator, spaces);
		return verifyTextMatching(expectedText,
				NLPRO_Template_Inline_Error_Message_Locator);

	}

	public boolean verifyCancelNewTemplateCreation(String text)
			throws AWTException {

		clickAndWait(NLPRO_Template_Text_Area_Locator);
		type(NLPRO_Template_Text_Area_Locator, text);
		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);
		clickAndWait(NLPRO_Cancel_New_Template_Creation_Button_Locator);

		return verifyElementNotDisplayed1(NLPRO_New_Template_Creation_Popup_Header_Label_Locator);

	}

	public boolean verifyCloseNewTemplateCreationPopup(String text)
			throws AWTException {

		clickAndWait(NLPRO_Template_Text_Area_Locator);
		type(NLPRO_Template_Text_Area_Locator, text);
		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);
		clickAndWait(NLPRO_New_Template_Creation_Popup_Close_Button_Locator);

		return verifyElementNotDisplayed1(NLPRO_New_Template_Creation_Popup_Header_Label_Locator);

	}

	public boolean verifyCreateNewTemplateUsingEnterKey(String text,
			String text1) throws AWTException, InterruptedException {

		// clickAndWait(NLPRO_Template_Text_Area_Locator);
		type(NLPRO_Template_Text_Area_Locator, text);
		clickAndWait(NLPRO_Template_Create_New_Template_Button_Locator);
		type(NLPRO_New_Template_Name_Input_Locator, text1);
		SelectNew(NLPRO_New_Template_Type_Select_Locator, "ORGANIZATION");
		pressShiftPlusTabKey();
		pressEnterKey();
		Actions action = new Actions(getDriver());
		action.moveToElement(
				waitForElement(NLPRO_Select_Available_Organization_Template_Locator))
				.perform();
		return iSSelectedValueDisplayed(
				NLPRO_Select_Available_Organization_Template_Locator, text1);

	}

	public boolean verifySelectionOfTemplateUsingDownArrowKey(String text)
			throws AWTException, InterruptedException {

		// clickAndWait(NLPRO_Template_Text_Area_Locator);
		for (int i = 0; i < 7; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressDownArrowKey();
		// Actions action = new Actions(getDriver());
		// action.moveToElement(waitForElement(NLPRO_Select_Available_Organization_Template_Locator)).perform();
		return iSSelectedValueDisplayed(
				NLPRO_Select_Available_Organization_Template_Locator, text);

	}

	public boolean verifyCreationOfNewTemplateUsingOnlyKeyboardKeys(String text)
			throws AWTException, InterruptedException {

		// clickAndWait(NLPRO_Template_Text_Area_Locator);
		for (int i = 1; i < 10; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}
		typeTemplateCorpusUsingKeys();
		Thread.sleep(1000);
		pressTabKey();
		Thread.sleep(1000);
		pressEnterKey();
		Thread.sleep(1000);
		// pressTabKey();
		Thread.sleep(1000);
		typeTemplateNameUsingKeys();
		Thread.sleep(1000);
		pressTabKey();
		Thread.sleep(1000);
		pressDownArrowKey();
		Thread.sleep(1000);
		pressDownArrowKey();
		Thread.sleep(1000);
		pressTabKey();
		Thread.sleep(1000);
		pressEnterKey();
		Thread.sleep(3000);
		// Actions action = new Actions(getDriver());
		// action.moveToElement(waitForElement(NLPRO_Select_Available_Organization_Template_Locator)).perform();
		return iSSelectedValueDisplayed(
				NLPRO_Select_Available_Organization_Template_Locator, text);

	}

	public boolean verifyOrganizationFolderSelectionInLookupFunctionality(
			String text, String fileSize, String dateYear) throws AWTException,
			InterruptedException {

		clickAndWait(NLPRO_Lookup_Organization_Folder_Locator);

		return (verifyTextMatching(text,
				NLPRO_Lookup_Results_Table_Organization_File_Locator)
				&& verifyTextMatching(fileSize,
						NLPRO_Lookup_Results_Table_Organization_Filesize_Locator)
				&& verifyElementIsDisplayed(NLPRO_Lookup_Results_Table_Organization_Download_File_Button_Locator) && verifyTextContains1(
					dateYear,
					NLPRO_Lookup_Results_Table_Organization_Date_Modified_Locator));

	}

	public boolean verifyExtensionFolderSelectionInLookupFunctionality(
			String text, String fileSize, String dateYear) throws AWTException,
			InterruptedException {

		clickAndWait(NLPRO_Lookup_Extension_Folder_Locator);

		return (verifyTextMatching(text,
				NLPRO_Lookup_Results_Table_Extension_File_Locator)
				&& verifyTextMatching(fileSize,
						NLPRO_Lookup_Results_Table_Extension_Filesize_Locator)
				&& verifyElementIsDisplayed(NLPRO_Lookup_Results_Table_Extension_Download_File_Button_Locator) && verifyTextContains1(
					dateYear,
					NLPRO_Lookup_Results_Table_Extension_Date_Modified_Locator));

	}

	public boolean verifyOrganizationFolderSelectionUsingEnterKeyInLookupFunctionality(
			String text, String fileSize, String dateYear) throws AWTException,
			InterruptedException {

		for (int i = 0; i < 14; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressEnterKey();

		return (verifyTextMatching(text,
				NLPRO_Lookup_Results_Table_Organization_File_Locator)
				&& verifyTextMatching(fileSize,
						NLPRO_Lookup_Results_Table_Organization_Filesize_Locator)
				&& verifyElementIsDisplayed(NLPRO_Lookup_Results_Table_Organization_Download_File_Button_Locator) && verifyTextContains1(
					dateYear,
					NLPRO_Lookup_Results_Table_Organization_Date_Modified_Locator));

	}

	public boolean verifyExtensionFolderSelectionUsingEnterKeyInLookupFunctionality(
			String text, String fileSize, String dateYear) throws AWTException,
			InterruptedException {

		for (int i = 0; i < 9; i++) {

			pressTabKey();
			Thread.sleep(1000);
		}

		pressEnterKey();

		return (verifyTextMatching(text,
				NLPRO_Lookup_Results_Table_Extension_File_Locator)
				&& verifyTextMatching(fileSize,
						NLPRO_Lookup_Results_Table_Extension_Filesize_Locator)
				&& verifyElementIsDisplayed(NLPRO_Lookup_Results_Table_Extension_Download_File_Button_Locator) && verifyTextContains1(
					dateYear,
					NLPRO_Lookup_Results_Table_Extension_Date_Modified_Locator));

	}

	public boolean verifyLookupFunctionality(String text) throws AWTException,
			InterruptedException {

		clickAndWait(NLPRO_Lookup_Organization_Folder_Locator);
		type(NLPRO_Lookup_Search_Input_Locator, text);
		clickAndWait(NLPRO_Lookup_Search_Button_Locator);
		scrollIntoView(NLPRO_Lookup_Search_Result_Text_Locator);
		return verifyTextMatching(text, NLPRO_Lookup_Search_Result_Text_Locator);

	}

	public boolean verifyLookupUsingEnterKeyFunctionality(String text)
			throws AWTException, InterruptedException {

		clickAndWait(NLPRO_Lookup_Organization_Folder_Locator);
		type(NLPRO_Lookup_Search_Input_Locator, text);
		pressEnterKey();
		clickAndWait(NLPRO_Lookup_Organization_Folder_Locator);
		scrollIntoView(NLPRO_Lookup_Search_Result_Text_Locator);
		return verifyTextMatching(text, NLPRO_Lookup_Search_Result_Text_Locator);

	}

	public boolean verifyNoSearchResultsInLookupFunctionality(String text,
			String errortext) throws AWTException, InterruptedException {

		clickAndWait(NLPRO_Lookup_Organization_Folder_Locator);
		type(NLPRO_Lookup_Search_Input_Locator, text);
		clickAndWait(NLPRO_Lookup_Search_Button_Locator);

		return verifyTextMatching(errortext, NLPRO_Lookup_Error_Message_Locator);

	}

	public boolean verifyNoSearchResultsUsingEnterKeyInLookupFunctionality(
			String text, String errortext) throws AWTException,
			InterruptedException {

		clickAndWait(NLPRO_Lookup_Organization_Folder_Locator);
		type(NLPRO_Lookup_Search_Input_Locator, text);
		pressEnterKey();

		return verifyTextMatching(errortext, NLPRO_Lookup_Error_Message_Locator);

	}

	public boolean verifyErrorMessageForUnselectedFolderDuringSearchFunctionality(
			String errortext) throws AWTException, InterruptedException {

		clickAndWait(NLPRO_Lookup_Search_Button_Locator);

		return verifyTextMatching(errortext, NLPRO_Lookup_Error_Message_Locator);

	}

	public boolean verifyErrorMessageForUnselectedFolderDuringSearchUsingEnterKeyFunctionality(
			String errortext) throws AWTException, InterruptedException {

		clickAndWait(NLPRO_Lookup_Search_Input_Locator);
		pressEnterKey();
		return verifyTextMatching(errortext, NLPRO_Lookup_Error_Message_Locator);

	}

	public boolean verifyDismissErrorMessagePopupForUnselectedFolderDuringSearchFunctionality()
			throws AWTException, InterruptedException {

		clickAndWait(NLPRO_Lookup_Search_Button_Locator);

		clickAndWait(NLPRO_Lookup_Error_Message_Popup_OK_Button_Locator);

		return verifyElementNotDisplayed1(NLPRO_Lookup_Error_Message_Locator);

	}
	
	public boolean verifyUntaggedOrganization(String text) {
		
		type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Process_Button_Locator);
		
		return verifyElementNotDisplayed1(NLPRO_Organization_Accordion_Locator);
	}
	
  public boolean verifyUntaggedPerson(String text) {
		
		type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Process_Button_Locator);
		
		return verifyElementNotDisplayed1(NLPRO_Person_Accordion_Locator);
	}
  
  public boolean verifyEntityTaggedAsLocation(String text, String expectedText) {
	  
	  type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Process_Button_Locator);
		
		clickAndWait(NLPRO_Location_Accordion_Locator);

		return verifyTextMatching(expectedText,NLPRO_Location_Accordion_Value_Locator);

  }
  
  public boolean verifyNotOnTheFlyTrainingForPerson(String filename, String modelname, String texttotrain, String expectedText, String count) throws Exception {
	  
	  
	  uploadingTextFile(filename);
	  
	  getTextPosition(NLPRO_Named_Entity_Train_Text_Area_Locator, texttotrain);
	  
	  pause(3);
	  hoverClick(NLPRO_Named_Entity_Train_Add_Menu_Locator);
	  clickAndWait(NLPRO_Named_Entity_Train_Add_Person_Menu_Locator);
	  clickAndWait(NLPRO_Named_Entity_Train_Page_Train_Button_Locator);
	  SelectNew(NLPRO_Named_Entity_Train_Model_Selector_In_Popup_Locator, modelname);
	  clickAndWait(NLPRO_Named_Entity_Train_Process_Button_In_Popup_Locator);
	  clickAndWait(NLPRO_Scan_Header_Menu_Locator);
	  uploadingTextFile(filename);
	  clickAndWait(NLPRO_Scan_Settings_Button_Locator);
	  clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
	  SelectNew(NLPRO_Scan_Model_Settings_Left_Side_Select_Locator, modelname);
	  clickAndWait(NLPRO_Scan_Model_Settings_Left_To_Right_Button_locator);
	  clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
	  clickAndWait(NLPRO_Person_Accordion_Locator);
	  
	  return (verifyTextMatching(expectedText, NLPRO_Person_Accordion_value_Locator_For_John_Depp) &&
			  verifyTextMatching(count, NLPRO_Person_Accordion_Value_Count_Locator_For_John_Depp));
	  
  }
  
public boolean verifyNotOnTheFlyTrainingForLocation(String filename, String modelname, String texttotrain, String expectedText, String count) throws Exception {
	  
	  
	  uploadingTextFile(filename);
	  
	  getTextPosition(NLPRO_Named_Entity_Train_Text_Area_Locator, texttotrain);
	  
	  pause(3);
	  hoverClick(NLPRO_Named_Entity_Train_Add_Menu_Locator);
	  clickAndWait(NLPRO_Named_Entity_Train_Add_Location_Menu_Locator);
	  clickAndWait(NLPRO_Named_Entity_Train_Page_Train_Button_Locator);
	  SelectNew(NLPRO_Named_Entity_Train_Model_Selector_In_Popup_Locator, modelname);
	  clickAndWait(NLPRO_Named_Entity_Train_Process_Button_In_Popup_Locator);
	  clickAndWait(NLPRO_Scan_Header_Menu_Locator);
	  uploadingTextFile(filename);
	  clickAndWait(NLPRO_Scan_Settings_Button_Locator);
	  clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
	  SelectNew(NLPRO_Scan_Model_Settings_Left_Side_Select_Locator, modelname);
	  clickAndWait(NLPRO_Scan_Model_Settings_Left_To_Right_Button_locator);
	  clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
	  clickAndWait(NLPRO_Location_Accordion_Locator);
	  
	  return (verifyTextMatching(expectedText, NLPRO_Location_Accordion_value_Locator_For_Gillie_Band) &&
			  verifyTextMatching(count, NLPRO_Location_Accordion_Value_Count_Locator_For_Gillie_Band));
	  
  }

  public boolean verifyNotOnTheFlyTrainingForOrganization(String filename, String modelname, String texttotrain, String expectedText, String count) throws Exception {
	  
	  
	  uploadingTextFile(filename);
	  
	  getTextPosition(NLPRO_Named_Entity_Train_Text_Area_Locator, texttotrain);
	  
	  pause(3);
	  hoverClick(NLPRO_Named_Entity_Train_Add_Menu_Locator);
	  clickAndWait(NLPRO_Named_Entity_Train_Add_Organization_Menu_Locator);
	  clickAndWait(NLPRO_Named_Entity_Train_Page_Train_Button_Locator);
	  SelectNew(NLPRO_Named_Entity_Train_Model_Selector_In_Popup_Locator, modelname);
	  clickAndWait(NLPRO_Named_Entity_Train_Process_Button_In_Popup_Locator);
	  clickAndWait(NLPRO_Scan_Header_Menu_Locator);
	  uploadingTextFile(filename);
	  clickAndWait(NLPRO_Scan_Settings_Button_Locator);
	  clickAndWait(NLPRO_Scan_Model_Settings_Sub_Menu_Locator);
	  SelectNew(NLPRO_Scan_Model_Settings_Left_Side_Select_Locator, modelname);
	  clickAndWait(NLPRO_Scan_Model_Settings_Left_To_Right_Button_locator);
	  clickAndWait(NLPRO_Scan_Model_Settings_Process_Button_Locator);
	  clickAndWait(NLPRO_Organization_Accordion_Locator);
	  
	  return (verifyTextMatching(expectedText, NLPRO_Organization_Accordion_Value_Locator_For_Kunjan_Holdings) &&
			  verifyTextMatching(count, NLPRO_Organization_Accordion_Value_Count_Locator_For_Kunjan_Holdings));
	  
  }
  
  public boolean verifyEntityTaggedAsOrganizationByCustomRule(String text, String expectedText) {
	  
	  type(NLPRO_Scan_Text_Area_Locator, text);
		clickAndWait(NLPRO_Process_Button_Locator);
		clickAndWait(NLPRO_Organization_Accordion_Locator);

		return verifyTextMatching(expectedText,NLPRO_Organization_Accordion_Value_Locator);

  }
  
  public boolean verifyEntityTaggedAsLocationAfterConversionFromOrganization(String filename) {
	  
	  uploadingTextFile(filename);
	  pause(5);
		clickAndWait(NLPRO_Process_Button_Locator);
		clickAndWait(NLPRO_Location_Accordion_Locator);
		
		return (verifyElementIsDisplayed(NLPRO_Location_Accordion_Value_For_Org_To_Loc_Locator1) &&
				verifyElementIsDisplayed(NLPRO_Location_Accordion_Value_For_Org_To_Loc_Locator2) &&
				verifyElementIsDisplayed(NLPRO_Location_Accordion_Value_For_Org_To_Loc_Locator3) &&
				verifyElementIsDisplayed(NLPRO_Location_Accordion_Value_For_Org_To_Loc_Locator4));
  }
  
  public boolean verifyTextCleanseRule(String text, String expectedText) {
	  
	  type(NLPRO_Scan_Text_Area_Locator, text);
	  pause(3);
		clickAndWait(NLPRO_Process_Button_Locator);
		
		return verifyTextMatching(expectedText,NLPRO_Scan_Text_Area_Locator);
	  
  }
  
     public boolean verifyTextCleanseRule1(String filename, String expectedText) {
	  
    	 uploadingTextFile(filename);
	  
		return verifyTextMatching(expectedText,NLPRO_Scan_Text_Area_Locator);
	  
  }
}
