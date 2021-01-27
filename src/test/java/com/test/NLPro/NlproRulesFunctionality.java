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

public class NlproRulesFunctionality extends NlproPageFactory {
	
	public static String excelPath1 = "D:\\Framework_New\\Framework\\Framework\\src\\main\\java\\com\\FP\\data\\Data.xlsx";
	ExcelDataConfig excel = new ExcelDataConfig(excelPath1);
	
	
	@Test(description = "The test case verifies the number_of_Words_ORG filter rule functionality in Named Entity Scan page", groups = { "Sanity" })
	public void verifyNumberOfWordsOrganizationFilterRuleFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyUntaggedOrganization(excel.getData(17, 1, 0)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the number_of_Words_PER filter rule functionality in Named Entity Scan page", groups = { "Sanity" })
	public void verifyNumberOfWordsPersonFilterRuleFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyUntaggedPerson(excel.getData(17, 1, 1)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}

	@Test(description = "The test case verifies the number_of_char_PER filter rule functionality in Named Entity Scan page", groups = { "Sanity" })
	public void verifyNumberOfCharactersPersonFilterRuleFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyUntaggedPerson(excel.getData(17, 1, 2)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the PER_to_loc filter rule functionality in Named Entity Scan page", groups = { "Sanity" })
	public void verifyPersonToLocationConvertorRuleFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyEntityTaggedAsLocation(excel.getData(17, 1, 3), excel.getData(17, 1, 3)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the ORG_to_loc filter rule functionality in Named Entity Scan page", groups = { "Sanity" })
	public void verifyOrganizationToLocationConvertorRuleFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			
			assertTrue(NLProTest().verifyEntityTaggedAsLocationAfterConversionFromOrganization(excel.getData(17, 1, 4)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the ORGANIZATION CUSTOM rule functionality in Named Entity Scan page", groups = { "Sanity" })
	public void verifyOrganizationExtensionRuleFunctionality()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProLocalURL).get(nlprolocalurl);

		
		try {
			
			assertTrue(NLProTest().verifyEntityTaggedAsOrganizationByCustomRule(excel.getData(17, 1, 5), excel.getData(17, 1, 5)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the TEXT CLEANSE rule functionality for ^ character in Named Entity Scan page", groups = { "Sanity" })
	public void verifyTextCleanseRuleFunctionality1()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			
			assertTrue(NLProTest().verifyTextCleanseRule(excel.getData(17, 1, 6), ""));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the TEXT CLEANSE rule functionality for ___ character in Named Entity Scan page", groups = { "Sanity" })
	public void verifyTextCleanseRuleFunctionality2()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		String str = " ";
		
		try {
			
			assertTrue(NLProTest().verifyTextCleanseRule1(excel.getData(17, 1, 7), str));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
	
	@Test(description = "The test case verifies the TEXT CLEANSE rule functionality for § character in Named Entity Scan page", groups = { "Sanity" })
	public void verifyTextCleanseRuleFunctionality3()  {
		
		log("Starting test....");
		log("Logging in....");
		open(NLProURL).get(nlprourl);

		
		try {
			
			assertTrue(NLProTest().verifyTextCleanseRule(excel.getData(17, 1, 8),excel.getData(17, 1, 9)));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Test Completed....");
			
	}
}
