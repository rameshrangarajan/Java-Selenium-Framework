package com.saf.util;
/*package biz.neustar.nsbiz.automation.util;


import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import biz.neustar.nbiz.automation.global.NbizGlobal;

public class Initialize extends NbizGlobal {

	
	*//**
	 * Browser name mentioned will be launched
	 * 
	 * @param sBrowser
	 *//*

	public static void launchBrowser(int sBrowser,String surl)  {
	
		switch (sBrowser) {
		case firefox:
			driver = new FirefoxDriver();
			driver.get(surl);
			driver.manage().window().setSize(new Dimension(1400, 900));
			break;
			
			
		case iexplore:
			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			driver = new InternetExplorerDriver(ieCapabilities);
			driver.get(surl);
			break;
			
		case googlechrome:
			
//			DesiredCapabilities capabilities = DesiredCapabilities.chrome();  
//			capabilities.setCapability("chrome.switches", Arrays.asList("--user-data-dir=/path/to/profile/directory"));  
//			driver = new ChromeDriver(capabilities);
			System.setProperty("webdriver.chrome.driver",
                    "..\\Framework\\lib\\PathChrome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(surl);
			break;
		
		default:
			
			break;
		}

	}
	
}
*/