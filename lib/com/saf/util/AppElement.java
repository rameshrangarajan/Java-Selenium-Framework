package com.saf.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This method will be used to find elements based on the Object Type which
 * passed as a parameter. It returns the element found.
 * 
 * @author syed.hussain
 * 
 */
public class AppElement {
	public enum AppElements {
		XPATH, LINKTEXT, ID, CSS, NAME, TAGNAME, CLASSNAME, PARTIALLINKTEXT;
	}

	private boolean highlight = true;

	public WebElement Find_Object(String Object_Id, String Object_Property, WebDriver webDriver) {
		WebElement element = null;
		/*
		 * if(NbizGlobal.explicitWait(driver, Object_Id, Object_Property)==true)
		 * {
		 */
		switch (AppElements.valueOf(Object_Id.toUpperCase())) {
		case XPATH:
			element = webDriver.findElement(By.xpath(Object_Property));
			break;
		case LINKTEXT:
			element = webDriver.findElement(By.linkText(Object_Property));
			break;
		case ID:
			element = webDriver.findElement(By.id(Object_Property));
			break;
		case CSS:
			element = webDriver.findElement(By.cssSelector(Object_Property));
			break;
		case NAME:
			element = webDriver.findElement(By.name(Object_Property));
			break;
		case TAGNAME:
			element = webDriver.findElement(By.tagName(Object_Property));
			break;
		case CLASSNAME:
			element = webDriver.findElement(By.className(Object_Property));
			break;
		case PARTIALLINKTEXT:
			element = webDriver.findElement(By.partialLinkText(Object_Property));
			break;
		default:
			System.err.println("Element Not Found");
			break;
		}
		/*
		 * } else {
		 * 
		 * System.err.println("Element Wait Complted : Object Not Found"); }
		 */
		try {
			if (highlight) {
				if (element != null && element.isDisplayed()) {
					JavascriptExecutor js = (JavascriptExecutor) webDriver;
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid red;");
				}
			}
		} catch (Exception e) {
		}
		return element;
	}
}


