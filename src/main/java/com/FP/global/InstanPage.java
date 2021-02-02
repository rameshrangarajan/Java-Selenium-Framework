package com.FP.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InstanPage {

	private static InstanPage instance = null;
	private static WebDriver driver;
	public static String driverPath = System.getProperty("user.dir")+"\\drivers\\";

	public InstanPage() {
		if (LoadProperties.BROWSER.equalsIgnoreCase("firefox")) {
			try {
				System.out.println(LoadProperties.BROWSER
						+ " Browser has been Initialized");
				System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
				driver = new FirefoxDriver();
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else if (LoadProperties.BROWSER.equalsIgnoreCase("chrome")) {
			try {
				System.out.println(LoadProperties.BROWSER
						+ " Browser has been Initialized");
				System.setProperty("webdriver.chrome.driver", driverPath
						+ "chromedriver_88.exe");
				//ChromeOptions chromeOptions= new ChromeOptions();
				//chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
				//System.setProperty("webdriver.chrome.driver", "G:\\Java-Selenium-Framework\\drivers\\chromedriver_88.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid browser passed");
		}

	}

	public WebDriver getDriver() {
		return driver;
	}

	public static InstanPage getInstance() {
		if (instance == null) {
			instance = new InstanPage();
		}
		return instance;
	}

}
