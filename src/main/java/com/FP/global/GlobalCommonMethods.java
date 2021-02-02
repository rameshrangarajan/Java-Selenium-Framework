package com.FP.global;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

/**
 * @author tandon_r
 *
 */
public class GlobalCommonMethods extends Global {

	
	public void uploadFile(String locator, String fileName) throws InterruptedException {
		//Actions action = new Actions(getDriver());
		WebElement element = findElementM(locator);
		//WebElement element = waitForElement(locator);
		//action.moveToElement(element).sendKeys(fileName).build().perform();
		element.sendKeys(fileName);
		//action.moveToElement(element).sendKeys(fileName);
		//action.moveToElement(element, 35, 10).doubleClick().build().perform();
		//Thread.sleep(3000);
		//action.moveToElement(element, 35, 10).contextClick().build().perform();
		//getDriver().findElement((By) element).sendKeys(fileName);
		//action.moveToElement(element).sendKeys(fileName).perform();
		
	}
	
	
	public void doubleClick(String locator) {
		
		Actions action = new Actions(getDriver());
		WebElement element = waitForElement(locator);
		action.moveToElement(element, 35, 10).doubleClick().build().perform();
		
	}
	
	public void rightClick(String locator) {
		
		Actions action = new Actions(getDriver());
		WebElement element = waitForElement(locator);
		action.moveToElement(element).contextClick().build().perform();
		
	}
	
	/*public void dragAndHighlightAndRightClick(String locator) {
		
		Actions action = new Actions(getDriver());
		WebElement element = waitForElement(locator);
		String temp = element.getText();
		int offset = getTextPosition(temp);
		//action.moveToElement(element, 125, 10).clickAndHold().moveByOffset(50,0).release().build().perform();
		action.moveToElement(element, offset, 10).clickAndHold().moveByOffset(50,0).release().build().perform();
		pause(3);
		action.moveToElement(element, offset + 10, 10).contextClick().build().perform();
	}*/
	
	public void getTextPosition(String locator, String temp) throws Exception{
		
		Robot ro = new Robot();
		Actions action = new Actions(getDriver());
		WebElement element = GetElementLocator(locator);
		//JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		//jse.executeScript("arguments[0].scrollIntoView(true);", element);
		//String temp = "Hello";
		String ch = "";
		int l;
		//action.moveToElement(element, 5, 10);
		String text = element.getText();
		int z = 0;
		/*for(int y = 0; y < text.length(); y++) {
			
			String str = String.valueOf(text.charAt(y));
			if(str.equals("\n")) { z++;
			
			}
		}*/
		//text = text.replaceAll("\r?\n+\W+", "\n");
		String line [] = new String [100];
//		text = text.replaceAll("[\\n]+[\\s]*[\\n]*", "\n");
		line = text.split("\n");
		/*for(z = 0; z < line.length; z++) 
		{
			if(line[z].trim().equals("")) { line[z] = "";}
		}*/
		System.out.println("Line count : " + line.length);
		for(l = 0; l < line.length; l++) 
		{
			
			//if(line[l].trim().equals(null) || line[l].trim().equals("")) {
				//element.sendKeys(Keys.ARROW_DOWN);
			  /// continue;
			//}
			if(line[l].trim().equals("") || !line[l].contains(temp)) {
				element.sendKeys(Keys.ARROW_DOWN);
				//continue;
				}
			//element.sendKeys(Keys.ARROW_DOWN);
			/*if(!line[l].contains(temp) || line[l].trim().equals("")) {
				continue;
				
				}*/
			
			/*if(!line[l].contains(temp) && !line[l].trim().equals(null) && !line[l].trim().equals("")) {
				element.sendKeys(Keys.ARROW_DOWN);
				continue;
				}*/
			
			
			if(line[l].contains(temp)) { 
				break;
			/*if(line[l].trim().equals(null) || line[l].trim().equals("") || line[l].contains("\n")) {
				element.sendKeys(Keys.ARROW_DOWN);*/
			}
			/*if(line[l].startsWith("\n") || line[l].endsWith("\n")) {
				element.sendKeys(Keys.ARROW_DOWN);
			}*/
			
			//else {
			
			
		}
		//for(int y = 0 ; y < line.length; y++) {
			
			System.out.println(line[l]);
			
			 /*if(line[y] == null || line[y].trim().equals("") || !line[y].contains(temp)){
				element.sendKeys(Keys.ARROW_DOWN);
				
				continue;
			 }*/
			 
			
			if(line[l].equals(temp)) {
				temp = line[l];
				//break;
			}
			if(line[l].contains(temp)) {
				
			int index = line[l].indexOf(temp);
		
			System.out.println("Index of " + temp + " = "  + index);
			Thread.sleep(3000);
		for(int i = 0; i < index; i++) {
			
			//ch = String.valueOf(line[y].charAt(i));
			
			//temp = temp + ch;
			/*if(ch.equals(" ")) {
				if(temp.trim().equals("Partner")) {
					for(int g = 0; g < temp.trim().length(); g++) {
						
						element.sendKeys(Keys.ARROW_LEFT);
					}
					break;
				}
				else {
					temp = "";
				}
			}*/
			
			
			
			
			element.sendKeys(Keys.ARROW_RIGHT);
			
			//ro.keyPress(KeyEvent.VK_RIGHT);
			//ro.keyPress(KeyEvent.VK_RIGHT);
			
		}
			}
		//break;
			//}
		//else {
			//continue;
			//element.sendKeys(Keys.ARROW_DOWN);
		//}
			//}
		pause(3);
		for(int m = 0; m < temp.trim().length(); m++) {
			
			
			element.sendKeys(Keys.SHIFT,Keys.ARROW_RIGHT);
			//element.sendKeys(Keys.ARROW_RIGHT);
			//action.wait(3000);
			//action.keyDown(Keys.SHIFT);
			//action.keyDown(Keys.ARROW_RIGHT);
			//action.keyUp(Keys.ARROW_RIGHT);
		}
		//action.keyUp(Keys.SHIFT);
		//action.wait(2000);
		//action.contextClick().build().perform();
		element.sendKeys(Keys.SHIFT,Keys.F10);

		//PointerInfo a = MouseInfo.getPointerInfo();
		//Point b = a.getLocation();
		
		//int x = b.x;
		//int y = b.y;
		//System.out.println("X = " + x);
		//System.out.println("Y = " + y);
		//System.out.print(y + "jjjjjjjjj");
		//System.out.print(x);
		//Robot r = new Robot();
		//r.mouseMove(x, y);
		//r.mousePress(InputEvent.BUTTON3_DOWN_MASK);
	   // r.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
         //Point pt = element.getLocation();
		//action.moveByOffset(pt.getX(), pt.getY()).contextClick().build().perform();
		//ro.mouseMove(350, 100);
		//ro.mousePress(InputEvent.BUTTON3_DOWN_MASK);
	    //ro.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		//ro.mousePress(buttons);
		pause(3);
	}
	
   public void dragAndHighlightAndRightClickForPerson(String locator) {
		
		Actions action = new Actions(getDriver());
		WebElement element = waitForElement(locator);
		
		action.moveToElement(element, 25, 10).clickAndHold().moveByOffset(60,0).release().build().perform();
		
		//action.moveToElement(element, offset, 10).clickAndHold().moveByOffset(60,0).release().build().perform();
		action.moveToElement(element, 35, 10).contextClick().build().perform();
	}
   
   public void dragAndHighlightAndRightClick1(String locator) {
		
		Actions action = new Actions(getDriver());
		WebElement element = waitForElement(locator);
		action.moveToElement(element, 10, 10).clickAndHold().moveByOffset(180,0).release().build().perform();
		action.moveToElement(element, 50, 10).contextClick().build().perform();
	}
	
	public void pressEnterKey() throws AWTException {
		
		Robot ro = new Robot();
    	ro.keyPress(KeyEvent.VK_ENTER);
	    ro.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void pressEnterKey1(String locator) {
		
		WebElement element = waitForElement(locator);
		element.sendKeys(Keys.ENTER);
	}
	
  public void pressDownArrowKey() throws AWTException {
		
		Robot ro = new Robot();
    	ro.keyPress(KeyEvent.VK_DOWN);
	    ro.keyRelease(KeyEvent.VK_DOWN);
	}

  public void typeTemplateCorpusUsingKeys() throws AWTException {
		
		Robot ro = new Robot();
  	    ro.keyPress(KeyEvent.VK_A);
	    ro.keyRelease(KeyEvent.VK_A);
	    ro.keyPress(KeyEvent.VK_SPACE);
	    ro.keyRelease(KeyEvent.VK_SPACE);
	    ro.keyPress(KeyEvent.VK_SHIFT);
	    ro.keyPress(KeyEvent.VK_3);
	    ro.keyRelease(KeyEvent.VK_3);
	    ro.keyRelease(KeyEvent.VK_SHIFT);
	    ro.keyPress(KeyEvent.VK_SHIFT);
	    ro.keyPress(KeyEvent.VK_3);
	    ro.keyRelease(KeyEvent.VK_3);
	    ro.keyRelease(KeyEvent.VK_SHIFT);
	}

  
  public void typeTemplateNameUsingKeys() throws AWTException {
		
		Robot ro = new Robot();
	    ro.keyPress(KeyEvent.VK_A);
	    ro.keyRelease(KeyEvent.VK_A);
	    ro.keyPress(KeyEvent.VK_B);
	    ro.keyRelease(KeyEvent.VK_B);
	    ro.keyPress(KeyEvent.VK_C);
	    ro.keyRelease(KeyEvent.VK_C);
	    
	}
  
  public void typeDataIntoEditorUsingKeys() throws AWTException {
		
		Robot ro = new Robot();
	    ro.keyPress(KeyEvent.VK_A);
	    ro.keyRelease(KeyEvent.VK_A);
	    ro.keyPress(KeyEvent.VK_B);
	    ro.keyRelease(KeyEvent.VK_B);
	    ro.keyPress(KeyEvent.VK_C);
	    ro.keyRelease(KeyEvent.VK_C);
	    
	}
  
  public void typeDataIntoLuceneSearchFieldUsingKeys() throws AWTException {
		
		Robot ro = new Robot();
	    ro.keyPress(KeyEvent.VK_V);
	    ro.keyRelease(KeyEvent.VK_V);
	    ro.keyPress(KeyEvent.VK_E);
	    ro.keyRelease(KeyEvent.VK_E);
	    ro.keyPress(KeyEvent.VK_R);
	    ro.keyRelease(KeyEvent.VK_R);
	    ro.keyPress(KeyEvent.VK_I);
	    ro.keyRelease(KeyEvent.VK_I);
	    ro.keyPress(KeyEvent.VK_Z);
	    ro.keyRelease(KeyEvent.VK_Z);
	    ro.keyPress(KeyEvent.VK_O);
	    ro.keyRelease(KeyEvent.VK_O);
	    ro.keyPress(KeyEvent.VK_N);
	    ro.keyRelease(KeyEvent.VK_N);
	        
	}
  
  public void pressShiftPlusTabKey() throws AWTException {
		
		Robot ro = new Robot();
    	ro.keyPress(KeyEvent.VK_SHIFT);
    	ro.keyPress(KeyEvent.VK_TAB);
	    ro.keyRelease(KeyEvent.VK_SHIFT);
	    ro.keyRelease(KeyEvent.VK_TAB);
	}
  
  public void pressTabKey() throws AWTException {
		
	  Robot ro = new Robot();
    ro.keyPress(KeyEvent.VK_TAB);
	ro.keyRelease(KeyEvent.VK_TAB);
	
  }
  
  public void selectAllTextInEditor() throws AWTException {
		
	  Robot ro = new Robot();
    ro.keyPress(KeyEvent.VK_CONTROL);
    ro.keyPress(KeyEvent.VK_A);
	ro.keyRelease(KeyEvent.VK_A);
	ro.keyRelease(KeyEvent.VK_CONTROL);
	
  }

   public void pressEscapeKey() throws AWTException {
		
		Robot ro = new Robot();
    	ro.keyPress(KeyEvent.VK_ESCAPE);
	    ro.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public void selectFromMenu(String locator) {
		
		WebElement Element = waitForElement(locator);
		Element.click();
		
	}
	
		
	public boolean getBackgroundColor(String locator, String color) {
		
		WebElement Element = waitForElement(locator);
		return Element.getCssValue("background-color").equalsIgnoreCase(color);
	}
	
    public boolean getPlaceholderText(String locator, String expectedText) {
		
		WebElement Element = waitForElement(locator);
		return Element.getAttribute("placeholder").equalsIgnoreCase(expectedText);
	}

    public boolean getToolTipText(String locator, String tooltiptext) {
		
		WebElement Element = waitForElement(locator);
		return Element.getAttribute("tooltip").equalsIgnoreCase(tooltiptext);
	}
	
	public void hoverClick(String locator) {

		Actions action = new Actions(getDriver());
		WebElement Element = waitForElement(locator);
		action.moveToElement(Element).build().perform();
	}

	public void SelectNew(String locator, String VisibleText) {

		WebElement element = waitForElement(locator);
		Select dd = new Select(element);
		dd.selectByVisibleText(VisibleText);
	}

	public boolean verifyURL(String url) {
		
		return getDriver().getCurrentUrl().equals(url);
	}
	
	public boolean iSSelectedValueDisplayed(String locator, String VisibleText) {

		WebElement element = waitForElement(locator);
		Select dd = new Select(element);
		WebElement element1 = dd.getFirstSelectedOption();
		return element1.getText().equals(VisibleText);
	}
	
	public boolean iSSelectedIndexDisplayed(String locator) {

		WebElement element = waitForElement(locator);
		Select dd = new Select(element);
		WebElement element1 = dd.getFirstSelectedOption();
		return element1.getAttribute("value").equals("1");
	}
	
	// Method for Today's Date
	public String todayDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String tDate = null;
		tDate = dateFormat.format(date);
		return tDate;
	}

	// CLOSING THE WINDOW AND BEING SWITCHED BACK TO SPECIFIED WINDOW
	public void ClosingNewWindowAndSwitchBack(String Winhandle) {
		try {

			getDriver().close();
			getDriver().switchTo().window(Winhandle);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// SWITCHING BACK TO SPECIFIED WINDOW
	public void SwitchBack(String Winhandle) {
		try {
			getDriver().switchTo().window(Winhandle);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// TO STORE THE CURRENT WINDOW HANDLE
	public String CurrentWindowHandle() throws Exception {
		return (getDriver().getWindowHandle());

	}

	public void SelectByIndex(String locator, int index) {

		WebElement element = waitForElement(locator);
		Select dd = new Select(element);
		dd.selectByIndex(index);
	}

	public int getNumberOfWindowsOpened() {
		Set<String> win = getDriver().getWindowHandles();
		int size = win.size();
		return size;
	}

	// SWITCH TO PARENT FRAME

	public void SwitchToParentFrame() {
		// getDriver().switchTo().parentFrame();

	}

	// COMING TO MAIN PAGE OUT OF ALL FRAME
	public void DefaultContent() {
		getDriver().switchTo().defaultContent();
	}

	public void AcceptAlert() {
		acceptAlert();
		log("Accept Alert clicked", TestStepType.VERIFICATION_STEP);
	}

	public void dismissalert() {
		dismissAlert(2);
		log("Alert cancel clicked", TestStepType.VERIFICATION_STEP);

	}
	
	
	/**
	 * Type specified text in element Skip to type if text="."
	 */
	public WebElement type(String locator, String text) {
		if (text.equals(".")) {
			return null;
		}
		WebElement element = waitForElement(locator);
		if (element != null) {
			try {
				element.clear();
				element.sendKeys(text);
				wait(LoadProperties.TYPE_WAIT);
				log("Type \"" + text + "\" in \"" + getLocatorName(locator)
						+ "\"", TestStepType.INNER_SUBSTEP);
			} catch (Exception e) {
				try {
					element.sendKeys(text);
					wait(LoadProperties.TYPE_WAIT);
					log("Type Keys  \"" + text + "\" in \""
							+ getLocatorName(locator) + "\"",
							TestStepType.INNER_SUBSTEP);
				} catch (Exception e1) {
					try {
						setValue(element, text);
						wait(LoadProperties.TYPE_WAIT);
						log("Set Value \"" + text + "\" in \""
								+ getLocatorName(locator) + "\"",
								TestStepType.INNER_SUBSTEP);
					} catch (Exception e2) {
						fail("Unable to type in \"" + getLocatorName(locator)
								+ "\"" + " Error: " + e.getMessage());
					}
				}
			}
		}
		return element;
	}
	
	
	private void setValue(WebElement element, String text) {
		try {
			setAttribute(element, "value", text);
		} catch (Exception e) {
			fail("Unable to set value for \"" + element.getText() + "\""
					+ " Error: " + e.getMessage());
		}
	}
	
	
	/**
	 * Click and Wait for 5 Seconds by default
	 */
	public boolean clickAndWait(String locator) {
		return clickAndWait(locator, 5);

	}
	
	/**
	 * Wait for element present for default timeout 30 seconds. Fail and Stop
	 * Script if not found and log in report
	 */
	public WebElement waitForElement(String locator) {
		return waitForElement(locator, timeout, false, false, true, true);
	}

	/**
	 * Wait for element present for specified timeout in seconds. Fail and Stop
	 * Script if not found and log in report
	 */
	public WebElement waitForElement(String locator, int timeout) {
		return waitForElement(locator, timeout, false, true, true, true);
	}

	
	/**
	 * - Clicks on element specified by locator. - Implicitly waits for the
	 * element to be present before click, so no need to explicitly wait for
	 * element using AjaxCondition - Logs to report on successful click - Logs
	 * to report if element not present - Waits for 5 secs if element just
	 * appeared before 1 sec, to allow complete page load
	 * 
	 * @param locator
	 * @return
	 *//*
	public boolean  click(String locator) {
		WebElement element = waitForElement(locator);
		if (element != null) {
			try {
				element.click();
				// wait(500);
				// element.click();
				log("Click \"" + getLocatorName(locator) + "\"",
						TestStepType.INNER_SUBSTEP);
			} catch (Error e) {
				e.printStackTrace();
				return true;
			} catch (TimeoutException e) {
				e.printStackTrace();
				return true;
			} catch (StaleElementReferenceException e) {
				element = waitForElement(locator);
				element.click();
				log("Click \"" + getLocatorName(locator) + "\"",
						TestStepType.INNER_SUBSTEP);
			} catch (Exception e) {
				try {
					executeScript("arguments[0].click()", locator);
					return true;
				} catch (Exception e1) {
					e1.printStackTrace();
					fail("Unable to Click Element :"
							+ getLocatorName(locator)
							+ " Error:"
							+ (e.getMessage().length() > 100 ? e.getMessage()
									.substring(0, 99) + "..." : e.getMessage()));
				}
			}
			return true;
		} else {
			return false;
		}
	}


	*//**
	 * Click and Wait for specified seconds
	 *//*
	public boolean clickAndWait(String locator, int wait) {
		if (click(locator)) {
			wait(wait * 1000);
			return true;
		} else {
			return false;
		}
	}*/

	public String dismissAlert(int timeout) {
		for (int seconds = 0;; seconds++) {
			if (seconds >= timeout) {
				return "";
			} else {
				try {
					String alertText = getDriver().switchTo().alert().getText()
							.trim();
					getDriver().switchTo().alert().dismiss();
					return alertText;
				} catch (Exception e) {

				}
				wait(1000);
			}
		}

	}

	// TO DELETE RECORD FROM DATABASE
	public void DeleteFromDataBase(String URL, String Userame, String Password,
			String Query) {
		Connection conn = null;
		Statement stmt = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(URL, Userame, Password);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			stmt.executeUpdate(Query);

			stmt.close();
			conn.close();

		} catch (SQLException se) {
			se.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		log("Database manupulation is done successfully");
	}

	public void dragAndDrop(String source, String target) {
		Actions builder = new Actions(getDriver());

		Action dragAndDrop = builder.clickAndHold(waitForElement(source))
				.moveToElement(waitForElement(target))
				.release(waitForElement(target)).build();
		dragAndDrop.perform();
		pause(4);
	}

	public void dragAndDropElement(String sourceElementLocator,
			String targetElementLocator) throws InterruptedException,
			AWTException {
		WebElement sourceElement = findElementM(sourceElementLocator);
		WebElement targetElement = findElementM(targetElementLocator);
		try {
			if (sourceElement.isDisplayed() && targetElement.isDisplayed()) {
				Actions action = new Actions(getDriver());
				// action.dragAndDrop(sourceElement, targetElement).build()
				// .perform();

				action.clickAndHold(waitForElement(sourceElementLocator))
						.moveToElement(waitForElement(targetElementLocator))
						.release(waitForElement(targetElementLocator)).build();
				action.perform();
				pause(10);

			} else {
				log("Element was not displayed to drag.");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + sourceElement + "or"
					+ targetElement + "is not attached to the page document. "
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + sourceElement + "or"
					+ targetElement + " was not found in DOM. "
					+ e.getStackTrace());
		} catch (Exception e) {
			System.out
					.println("Error occurred while performing drag and drop operation."
							+ e.getStackTrace());
		}

	}

	public boolean verifyTextMatching(String expectedText, String locator) {
		WebElement element = null;
		try {
		element = waitForElement(locator);
		} catch(ElementNotFoundException e) {e.printStackTrace();}
	
		String actualText = element.getText();
		System.out.println("Expected Text : " +expectedText);
		System.out.println("Actual Text : " +actualText);
		if (expectedText.equals(actualText)) {
			log("Actual Text : \"" + actualText + "\" matches with , "
					+ " Expected Text : \"" + expectedText + "\"",
					TestStepType.VERIFICATION_RESULT);
			return true;
		} else {
			log("Actual Text : \"" + actualText + "\" doesn't match with , "
					+ " Expected Text : \"" + expectedText + "\"",
					TestStepType.ERRORMESSAGE);
			return false;
		}
	
	}

	public boolean verifyTextContains(String textToCheck, String entireText) {
		if (entireText.contains(textToCheck)) {
			log("Actual Text : \"" + entireText + "\" contains , "
					+ " Text : \"" + textToCheck + "\"",
					TestStepType.VERIFICATION_RESULT);
			return true;
		} else {
			log("Actual Text : \"" + entireText + "\" does not contains , "
					+ " Text : \"" + textToCheck + "\"",
					TestStepType.VERIFICATION_RESULT);
			return true;
		}
	}
	
	public boolean verifyTextContains1(String textToCheck, String locator) {
		WebElement element = waitForElement(locator);
		String actualText = element.getText();
		
		if (actualText.contains(textToCheck)) {
			log("Actual Text : \"" + actualText + "\" contains , "
					+ " Text : \"" + textToCheck + "\"",
					TestStepType.VERIFICATION_RESULT);
			return true;
		} else {
			log("Actual Text : \"" + actualText + "\" does not contains , "
					+ " Text : \"" + textToCheck + "\"",
					TestStepType.VERIFICATION_RESULT);
			return false;
		}
	}

	public boolean isElementDisplayed(WebElement element) {
		if (element.isDisplayed()) {
			log("Element \"" + element.getText() + "\"" + " is displayed.",
					TestStepType.VERIFICATION_STEP);
			return true;
		} else {
			log("Element \"" + element.getText() + "\"" + " is not displayed.",
					TestStepType.ERRORMESSAGE);
			return false;
		}
	}

	public boolean isElementClickable(String loc) {
		WebElement ele = findElementM(loc);
		if (ele.isEnabled()) {
			return true;
		} else {
			//log("Element is not clickable", TestStepType.ERRORMESSAGE);
			return false;
		}

	}

	public List<WebElement> getListOfWebElements(WebElement itemContainer,
			String itemList) {
		List<WebElement> elementList = itemContainer.findElements(By
				.xpath(itemList));
		return elementList;
	}

	public List<WebElement> getElementsList(String itemList) {
		List<WebElement> elementList = getDriver().findElements(
				By.xpath(itemList));
		return elementList;
	}

	public String extractStringFromAlphaNumberString(String string) {
		return string;

	}

	public String removeMultipleSpaces(String str, String replace) {
		Pattern ptn = Pattern.compile("\\s+");
		Matcher mtch = ptn.matcher(str);
		return mtch.replaceAll(replace).toString().trim();
	}

	public String removeNumbersAtndOfStringFromString(String str, String replace) {
		Pattern ptn = Pattern.compile("\\d*$");
		Matcher mtch = ptn.matcher(str);
		return mtch.replaceAll(replace).toString().trim();
	}

	public boolean verifyElementNotDisplayed(String locator) {
		WebElement element = waitForElement(locator);
		if (!element.isDisplayed()) {
			log("Element \"" + element.getText() + "\"" + " is not displayed.",
					TestStepType.VERIFICATION_STEP);
			long seconds = System.currentTimeMillis() / (1000L);
			System.out.println("Notification Invisible at " + seconds);
			put("notificationInvisible", seconds);
			return true;
		} else {
			log("Element \"" + element.getText() + "\"" + " is displayed.",
					TestStepType.ERRORMESSAGE);
			return false;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean verifyElementNotDisplayed1(String locator) {
		WebElement element = null;
		try {
		 element = findElementM(locator);
		} catch(org.openqa.selenium.NoSuchElementException e) {e.printStackTrace(); }
		finally 
		{if (element == null) 
			return true;
		else {
			
			return false;
			}
		}
		
	}
	
	@SuppressWarnings("finally")
	public boolean verifyElementIsDisplayed(String locator) {
		WebElement element = null;
		try {
		 element = findElementM(locator);
		} catch(org.openqa.selenium.NoSuchElementException e) {e.printStackTrace(); }
		finally 
		{if (element == null) 
			return false;
		else {
			
			return true;
			}
		}
		
	}
	
	public void scrollIntoView(String locator) {
		
		WebElement element = null;
		try {
			
		 element = findElementM(locator);
		 ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
		
		} catch(org.openqa.selenium.NoSuchElementException e) {e.printStackTrace(); }
		
		
	}

}
