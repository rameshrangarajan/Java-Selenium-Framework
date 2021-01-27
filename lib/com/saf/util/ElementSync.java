package com.saf.util;
/*package biz.neustar.nsbiz.automation.util;

import org.apache.bcel.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import biz.neustar.nbiz.automation.global.NbizGlobal;
import biz.neustar.nsbiz.automation.util.AppElement.AppElements;

public enum ElementSync {
	XPATH, LINKTEXT, ID, CSS, NAME, TAGNAME, CLASSNAME, PARTIALLINKTEXT;

	public static class ElementSyncs extends NbizGlobal {

	public static void element_Sync(String Object_Id, final String Object_Property) {
	ExpectedCondition<Boolean> e = null;
	WebDriverWait d = new WebDriverWait(driver, 60);
	wait(5);
	switch (ElementSync.valueOf(Object_Id.toUpperCase())) {

	 if(Object_Property.equals("XPATH"))
		{
		if(driver.findElement(By.xpath(Object_Property)).isDisplayed());
		{
			AppElements.Find_Object(Object_Id, Object_Property);
		}
		else
		{
			wait(10);
		}
		}
		
		

	case LINKTEXT:
		e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
		driver.findElement(By.linkText(Object_Property));
		return Boolean.valueOf(true);
	}
		};
		break;

	case ID:
		e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
		driver.findElement(By.id(Object_Property));
		return Boolean.valueOf(true);
	}
		};
		break;

	case CSS:
		e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
		driver.findElement(By.cssSelector((Object_Property)));
		return Boolean.valueOf(true);
	}
		};
		break;

	case NAME:
		e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
		driver.findElement(By.name(Object_Property));
		return Boolean.valueOf(true);
	}
		};
		break;

	case TAGNAME:
		e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
		driver.findElement(By.tagName(Object_Property));
		return Boolean.valueOf(true);
	}
		};
		break;

	case CLASSNAME:
		e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
		driver.findElement(By.className(Object_Property));
		return Boolean.valueOf(true);
	}
		};
		break;

	case PARTIALLINKTEXT:
		e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
		driver.findElement(By.partialLinkText(Object_Property));
		return Boolean.valueOf(true);
	}
		};
		break;

	default:
		System.out.println("Element Not Found");
		break;
	}
		}
	}

}
*/