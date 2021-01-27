package com.saf.util;
/*package biz.neustar.nsbiz.automation.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import biz.neustar.nbiz.automation.global.NbizGlobal;
import biz.neustar.nsbiz.automation.util.AppElement.AppElements;

public class TestUtil extends NbizGlobal {

	 private static final Logger LOGGER =LoggerFactory.getLogger(TestUtil.class);
	
	 public static void logOut(){
	 LOGGER.info("logOut: In Logout Function !!");
	 if(isLoggedIn){
		 getObjectbyXpath(LoginPageObjects.Logout_link.getProperty()).click();
		 getObjectLinktext("Logout").click();
		 pause(4);
		 isLoggedIn = false;
	 }
	 }

	*//**
	 * get the skip condition True - N, false - Y
	 * 
	 * @param testCase
	 *            - Test case name
	 * @return
	 * @throws IOException
	 *//*
	public boolean isSkip(String testCase) throws IOException {

		String fileName = System.getProperty("user.dir")
				+ "//test//conf//Controller.csv";
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		@SuppressWarnings("unused")
		int lineNumber = 0;
		String testCaseNo = null;
		String testCaseYes = null;
		// if (!testCase.contains(".java")) {
		testCase = testCase + ".java";
		// }
		testCaseNo = testCase + ",no";
		testCaseYes = testCase + ",yes";
		while ((fileName = br.readLine()) != null) {
			lineNumber++;
			if (fileName.equalsIgnoreCase(testCaseNo)) {
				System.out.println(fileName);
				return true;
			} else if (fileName.equalsIgnoreCase(testCaseYes)) {
				System.out.println(fileName);
				return false;
			}
		}
		System.err.println(testCase + " Not Found in the Controller.csv file");
		return true;
	}

	*//**
	 * Takes the Screen shots whenever required and save it in screenshots
	 * folder in the project
	 * 
	 * @param fileName
	 *            - with which the screenshot is named while saving.
	 *//*

	public static void newTab(String Key, String Url) {
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + Key);
		driver.navigate().to(Url);
	}
	
	public static void closeTab() {
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "W");
		driver.navigate().refresh();
	}
	
	public static void MouseOver_Element(String Object_ID,String Object_Properties) {
		wait(2);
		Actions builder = new Actions(driver);
		WebElement Element = AppElements.Find_Object(Object_ID, Object_Properties);
		builder.moveToElement(Element).build().perform();
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.linkText("Menu heading"));
		actions.moveToElement(menuHoverLink);

		WebElement subLink = driver.findElement(By.cssSelector("#headerMenu .subLink"));
		actions.moveToElement(subLink);
		actions.click();
		actions.perform();
	}
	
	public static String ToolTip_Text(String Object_ID,String Object_Properties) {
		
			WebElement element=AppElements.Find_Object(Object_ID, Object_Properties);
	        Actions builder = new Actions(driver);
	        builder.moveToElement(element).build().perform();
	        return  element.getAttribute("validationMessage");
	       // System.out.println("The tooltip is"+driver.findElement(By.id("fname1")).getAttribute("validationMessage"));
	}

	public static void verifyText(String Object_Id, String Object_Properties,
			String sText, String tName) {
		try {
			wait(2);
		//	System.err.println("The value is"+AppElements.Find_Object(Object_Id, Object_Properties).getText());
			if(AppElements.Find_Object(Object_Id, Object_Properties).getText().contains(sText))
			{
				textAppend(tName,"Pass");
				log.info("Executing Testcase "+tName);
				log.info("Testcase "+tName+" is Pass");
				excelReport.appendExcel(tName, sText, "As Expected", "Pass");
				XMLReport.ReportLogData(tName,sText,"As Expected","PASS");
				Assert.assertTrue(true);
				wait(5);
			}
			else
			{
				takeScreenShot(tName);
				textAppend(tName,"Fail");
				log.info("Executing Testcase "+tName);
				excelReport.appendExcel(tName, sText, "Not Expected", "Fail");
				log.info("Testcase "+tName+" is Fail");
				XMLReport.ReportLogData(tName,sText,"As Expected","FAIL");
				Assert.assertFalse(false);
				wait(5);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void verifyToolTipText(String Actual, String Expected, String tName) {
		
		if(Actual.equalsIgnoreCase(Expected)){
			textAppend(tName,"Pass");
			Assert.assertTrue(true);
			wait(5);
		}
		else
		{
			takeScreenShot(tName);
			textAppend(tName,"Fail");
			Assert.assertFalse(false);
			wait(5);
		}
	}
	
	public static void verifyToolTipText1(String Actual, String tName) {
		
		if(Actual.isEmpty()){
			
			Assert.assertTrue(false);
		}
		else
		{
			
			Assert.assertFalse(true);
		}
	}
	public static void verifyElement(String Obj_Id1, String Obj_Property) {
		
		if((AppElements.Find_Object(Obj_Id1, Obj_Property).getText()!= null)){
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
				

	public static void newWindow(String New_Window_Title) {
		String p_window = driver.getWindowHandle();
		Set s = driver.getWindowHandles();
		Iterator ite = s.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			if (!popupHandle.contains(popupHandle)) {
				driver.switchTo().window(p_window);
			//	System.err.println("Title--actual@@@"+driver.getTitle());
				//System.err.println("Title-passed@@@"+New_Window_Title);
				if(driver.getTitle().equals(New_Window_Title)){
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
					}
				}
				//driver.close();
				driver.switchTo().window(popupHandle);
			}
	}

	public static void Navigation(String URL){
		wait(5);
		if (driver.getCurrentUrl().contains(URL)){
			Assert.assertTrue(true);
			driver.navigate().back();
		} else {
			Assert.assertTrue(false);
			driver.navigate().back();
			}
		}

	public static void page_Title(String sTitle, String tName) throws InterruptedException {
		pause(5);
		System.err.println("Title@@--expected"+sTitle);
		System.err.println("Title@@--actual"+driver.getTitle());
		if(driver.getTitle().contains(sTitle)) {
			textAppend(tName,"Pass");
			log.info("Executing Testcase "+tName);
			log.info("Testcase "+tName+" is Pass");
			excelReport.appendExcel(tName, sTitle, "As Expected", "Pass");
			XMLReport.ReportLogData(tName,sTitle,"As Expected","PASS");
			Assert.assertTrue(true);
		} else {
			takeScreenShot(tName);
			textAppend(tName,"Fail");
			log.info("Executing Testcase "+tName);
			excelReport.appendExcel(tName, sTitle, "Not Expected", "Fail");
			log.info("Testcase "+tName+" is Fail");
			XMLReport.ReportLogData(tName,sTitle,"As Expected","FAIL");
			Assert.assertTrue(false);
			}
		}
	
	public static void verifyLink(String Obj_Id1, String Obj_Property) {
		
		wait(5);
		
		if (AppElements.Find_Object(Obj_Id1, Obj_Property).isDisplayed()){
			Assert.assertTrue(true);
			
		} else {
		
			Assert.assertTrue(false);
		}
		
	}
	public static void newWindow_Count(){
		String p_window=driver.getWindowHandle();
		Set s=driver.getWindowHandles();
		Iterator ite=s.iterator();
		//System.out.println("The size of iterator is "+ s.size());
		if(s.size()==2)
		{
			Assert.assertEquals(2, s.size());
		}
		
	}
	public static void verify_BodyText(String sText, String tName) {
		wait(5);
		
		if (driver.findElement(By.cssSelector("body")).getText().contains(sText)) {
			textAppend(tName,"Pass");
			log.info("Executing Testcase "+tName);
			log.info("Testcase "+tName+" is Pass");
			excelReport.appendExcel(tName, sText, "As Expected", "Pass");
			XMLReport.ReportLogData(tName,sText,"As Expected","PASS");
			Assert.assertTrue(true);
		} else {
			takeScreenShot(tName);
			textAppend(tName,"Fail");
			log.info("Executing Testcase "+tName);
			excelReport.appendExcel(tName, sText, "Not Expected", "Fail");
			log.info("Testcase "+tName+" is Fail");
			XMLReport.ReportLogData(tName,sText,"As Expected","FAIL");
			Assert.assertTrue(false);
		}
	}
	
	public static boolean verifyMsg(String sText) {
		
		boolean flag;
		if (driver.findElement(By.cssSelector("body")).getText().contains(sText))
			flag=true;
		else
			flag =false;
		
		return flag;
	}
	
	public static void newWindow_VerifyText(String sObject_ID, String sObject_Properties, String sNew_Window_Text, String tName) {
		String p_window = driver.getWindowHandle(); // parent window id.
		Set s = driver.getWindowHandles();
		Iterator ite = s.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			if (!popupHandle.contains(popupHandle)) {
				driver.switchTo().window(p_window);
				if(AppElements.Find_Object(sObject_ID, sObject_Properties).getText().contains(sNew_Window_Text)){
					textAppend(tName,"Pass");
					log.info("Executing Testcase "+tName);
					log.info("Testcase "+tName+" is Pass");
					excelReport.appendExcel(tName, "", "As Expected", "Pass");
					XMLReport.ReportLogData(tName,"","As Expected","PASS");
					Assert.assertTrue(true);
					
				} else {
					takeScreenShot(tName);
					textAppend(tName,"Fail");
					log.info("Executing Testcase "+tName);
					excelReport.appendExcel(tName, "", "Not Expected", "Fail");
					log.info("Testcase "+tName+" is Fail");
					XMLReport.ReportLogData(tName,"","As Expected","FAIL");
					Assert.assertTrue(false);
					}
				}
				driver.switchTo().window(popupHandle);
				//driver.close();
			}
			}
	
	public static void verify_BodyText_Negative(String sText, String tName) {
        
		wait(5);
		
        if (false==driver.findElement(By.cssSelector("body")).getText().contains(sText)) {
        	textAppend(tName,"Pass"); 
        	log.info("Executing Testcase "+tName);
			log.info("Testcase "+tName+" is Pass");
			excelReport.appendExcel(tName, sText, "As Expected", "Pass");
			XMLReport.ReportLogData(tName,sText,"As Expected","PASS");
        	Assert.assertTrue(true);
        } else {
        	  takeScreenShot(tName);
        	  textAppend(tName,"Fail");
        	  log.info("Executing Testcase "+tName);
  			  excelReport.appendExcel(tName, sText, "Not Expected", "Fail");
  			  log.info("Testcase "+tName+" is Fail");
  			  XMLReport.ReportLogData(tName,sText,"As Expected","FAIL");
              Assert.assertTrue(false);
        }
  }

	*//**
     * Identifies element with tag name
     * @param sObj_Id : Property of the object
     *//*
     public static void findElementbyTag(String sObj_Id,int iTagtype, String tName)
     {
           switch (iTagtype) {
           case SELECT:
                 if ("select".equalsIgnoreCase(driver.findElement(By.id(sObj_Id)).getTagName())) {
                	 
                	 textAppend(tName,"Pass"); 
                	 log.info("Executing Testcase "+tName);
         			 log.info("Testcase "+tName+" is Pass");
         			 excelReport.appendExcel(tName, "", "As Expected", "Pass");
         			 XMLReport.ReportLogData(tName,"","As Expected","PASS");
                     Assert.assertTrue(true);
                 } else {
                	 takeScreenShot(tName);
                	 textAppend(tName,"Fail"); 
                	 log.info("Executing Testcase "+tName);
         			 excelReport.appendExcel(tName, "", "Not Expected", "Fail");
         			 log.info("Testcase "+tName+" is Fail");
         			 XMLReport.ReportLogData(tName,"","As Expected","FAIL");
                     Assert.assertTrue(false);
                 }
                 break;
           case INPUT:
                 if ("input".equalsIgnoreCase(driver.findElement(By.id(sObj_Id)).getTagName())) {
                	 
                	 textAppend(tName,"Pass");
                	 log.info("Executing Testcase "+tName);
         			 log.info("Testcase "+tName+" is Pass");
         			 excelReport.appendExcel(tName, "", "As Expected", "Pass");
         			 XMLReport.ReportLogData(tName,"","As Expected","PASS");
                     Assert.assertTrue(true);
                 } else {
                	 takeScreenShot(tName);
                	 textAppend(tName,"Fail");
                	 log.info("Executing Testcase "+tName);
         			 excelReport.appendExcel(tName, "", "Not Expected", "Fail");
         			 log.info("Testcase "+tName+" is Fail");
         			 XMLReport.ReportLogData(tName,"","As Expected","FAIL");
                     Assert.assertTrue(false);
                 }
                 break;
                 
           default:
                 System.err.println("No tag available");
                 break;
           }
}

     public static void verifyElement(int objType,String Obj_Id, String Obj_Property, String tName) {
         
    	wait(5);
    	
         switch (objType) {
         case VERIFYELEMENTTEXT:
               if((AppElements.Find_Object(Obj_Id, Obj_Property).getText()!= null)){
            	   textAppend(tName,"Pass"); 
            	   log.info("Executing Testcase "+tName);
       			   log.info("Testcase "+tName+" is Pass");
       			   excelReport.appendExcel(tName, "", "As Expected", "Pass");
       			   XMLReport.ReportLogData(tName,"","As Expected","PASS");
                   Assert.assertTrue(true);
               } else {
            	   takeScreenShot(tName);
            	   textAppend(tName,"Fail"); 
            	   log.info("Executing Testcase "+tName);
       			   excelReport.appendExcel(tName, "", "Not Expected", "Fail");
       			   log.info("Testcase "+tName+" is Fail");
       			   XMLReport.ReportLogData(tName,"","As Expected","FAIL");
                   Assert.assertTrue(false);
               }
               break;
         case VERIFYELEMENT:
               if((AppElements.Find_Object(Obj_Id, Obj_Property)!= null)){
            	   
            	     textAppend(tName,"Pass"); 
            	     log.info("Executing Testcase "+tName);
         			 log.info("Testcase "+tName+" is Pass");
         			 excelReport.appendExcel(tName, "", "As Expected", "Pass");
         			 XMLReport.ReportLogData(tName,"","As Expected","PASS");
                     Assert.assertTrue(true);
               } else {
            	   takeScreenShot(tName);
            	   textAppend(tName,"Fail"); 
            	   log.info("Executing Testcase "+tName);
       			   excelReport.appendExcel(tName, "", "Not Expected", "Fail");
       			   log.info("Testcase "+tName+" is Fail");
       			   XMLReport.ReportLogData(tName,"","As Expected","FAIL");
                   Assert.assertTrue(false);
               }
               break;
               
         default:
               System.err.println("No Element available");
               break;
         }
   }
     
 	public static void selectValue(String sSelectVal){
        List <WebElement> options = driver.findElements(By.tagName("option"));
        
		for (WebElement option : options) {
			if (sSelectVal.equalsIgnoreCase(option.getText())){
				option.click();
				}
		    }
	}
 	
 	public static void changeTab() {
 	
 		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.TAB);
		driver.navigate().refresh();
	}
 	
 	public static String tcName() {
 		
 		String TName = new Object(){}.getClass().getEnclosingMethod().getName();
 		return TName;
 	}
 	
 	public static void SelectDDValues(String prop, String data){
 		
 		Select element = new Select(driver.findElement(By.id(prop)));
 		element.selectByVisibleText(data);
 	}
 	
 	public static void accept() {
 		
 		driver.switchTo().alert().accept();
 	}
 	
 	public static void verifyAlertText(String Text) {
 		
 		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		if(message.contains(Text)){
				alert.accept();
			Assert.assertTrue(true);
		} else {
				alert.accept();
			  Assert.assertTrue(false);
			}
 		}
 	
 	public static void verifyTextInFields(String Object) {
 		
 		String Text = driver.findElement(By.id(Object)).getAttribute("value");
 		if(Text.isEmpty()) {
 			Assert.assertTrue(true);
 		} else {
 			 Assert.assertTrue(false);
 		}
 	}
 	
 	public static void mouseOver_Element(String Object_ID1,String Object_Properties1,String Object_ID2,String Object_Properties2) {
		wait(2);
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = AppElements.Find_Object(Object_ID1, Object_Properties1);
		actions.moveToElement(menuHoverLink);

		WebElement subLink = AppElements.Find_Object(Object_ID2, Object_Properties2);
		actions.moveToElement(subLink);
		actions.click();
		actions.perform();
	}
 	
 	public static void StoringCurrentWindowHandle()throws Exception{
        WinhandleBefore=driver.getWindowHandle();//store the current window handle
 	}
 	public static void SwitchingToNewWindowOpened()throws Exception{
        for(String WinHandle:driver.getWindowHandles()){
              driver.switchTo().window(WinHandle);
        }
 	}
 	public static void ClosingNewWindowAndSwitchBack()throws Exception{
        driver.close();
        driver.switchTo().window(WinhandleBefore);
  }

 	public static void verifyUrl() {
 		
 		if(driver.getCurrentUrl().contains("qa.www")) {
		} else {
		driver.quit();
		}
 	}
 	
   
 	
 	}


*/