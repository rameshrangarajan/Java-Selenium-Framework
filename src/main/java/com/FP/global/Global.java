//master
package com.FP.global;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/*import com.test.util.FileOperation;
 import com.test.util.Reasons;*/

public class Global extends CustomReport {
	// public final String hubUrlString = "http://10.78.23.75:4444/wd/hub";
	public final String hubUrlString = "http://localhost:4444/wd/hub";
	public String projName = "Framework";
	public static String driverPath = "C:/Selenium/";
	public static int Wait = LoadProperties.TIMEOUT;
	public String WinhandleBefore;
	public static WebDriverWait wait = null;
	public WritableWorkbook writebook = null;
	public WritableSheet sheet = null;
	public FileWriter fstream = null;
	public BufferedWriter fwr = null;
	public Date date = null;
	public Properties CONFIG = null;
	// public static String url = "http://54.225.238.2/";
	public static String url = LoadProperties.APP_URL;
	public static String nlprourl = LoadProperties.NLPRO_APP_URL;
	public static String nlprolocalurl = LoadProperties.NLPRO_LOCAL_APP_URL;
	public static String nlprotemplateurl = LoadProperties.NLPRO_TEMPLATE_URL;
	public static String nlprotemplatelocalurl = LoadProperties.NLPRO_LOCAL_TEMPLATE_URL;
	public static String nlprolookupurl = LoadProperties.NLPRO_LOOKUP_URL;
	public static String nlprolookuplocalurl = LoadProperties.NLPRO_LOCAL_LOOKUP_URL;
	public static String nlprophrasesscanpurl = LoadProperties.NLPRO_PHRASES_SCAN_URL;
	public static String nlprophrasesscanlocalurl = LoadProperties.NLPRO_LOCAL_PHRASES_SCAN_URL;
	public static String nlprophrasestrainpurl = LoadProperties.NLPRO_PHRASES_TRAIN_URL;
	public static String nlprophrasestrainlocalurl = LoadProperties.NLPRO_LOCAL_PHRASES_TRAIN_URL;
	public static String nlpronamedentitytrainpurl = LoadProperties.NLPRO_NAMED_ENTITY_TRAIN_URL;
	public static String nlpronamedentitytrainlocalurl = LoadProperties.NLPRO_LOCAL_NAMED_ENTITY_TRAIN_URL;
	public static String googleurl = LoadProperties.GOOGLE_URL;
	public String os = System.getProperty("os.name");
	public Properties OR = null;
	public WebDriver dr = null;
	public String ALPHA_NUM = "0123456789abcdefghijklmnopqrstuvwxyz";
	public String ALPHA_NUM_SC = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()";
	public String Character = "abcdefghijklmnopqrstuvwxyz";
	public String RegisterFName = "iTestUser" + getAlphaNumeric(8);
	public String RegisterLName = "iTestUser" + getAlphaNumeric(8);
	// Veena on 16-10-13
	public String NUMERICS = "0123456789";

	public static long startTime;

	/**
	 * Reads Objects from Objects Class files
	 * 
	 * @throws Exception
	 */
	@BeforeSuite(alwaysRun = true)
	public void beforeSuiteMethod() throws Exception {
		/*
		 * try { new File("status.html").delete();
		 * FileOperation.flog("status.html",
		 * "<meta http-equiv='refresh' content='3'>"); FileOperatio
		 * .flog("status.html", "<b>Execution in Progress !!</b>");
		 * Runtime.getRuntime() .exec(
		 * "\"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe\" \"file:///"
		 * + System.getProperty("user.dir") + "/status.html\""); } catch
		 * (Exception e) { }
		 */

		try {
			if (LoadProperties.DISPLAYLOCATORNAMES == false) {
				return;
			}
			File[] pageList = new File(LoadProperties.LOCATORS_DIR_PATH)
					.listFiles();
			for (int i = 0; i < pageList.length; i++) {
				extractObjects(pageList[i].getAbsolutePath().replace("\\", "/"));
			}
			pageList = new File(LoadProperties.DATA_DIR_PATH).listFiles();
			for (int i = 0; i < pageList.length; i++) {
				extractObjects(pageList[i].getAbsolutePath().replace("\\", "/"));
			}
			slog("Locators Extracted:" + objects.size());
		} catch (Exception e) {
			// e.printStackTrace();
		}
		startTime = new Date().getTime();
	}

	/**
	 * Reads Objects from Objects Class files
	 * 
	 * @throws Exception
	 */
	@AfterSuite(alwaysRun = true)
	public void afterSuiteMethod() throws Exception {
		log("\n Total Execution Time: " + getMinutes(startTime));

	}

	private String getMinutes(long startTime) {
		return (new Date().getTime() - startTime) / 1000 / 60 + " minutes";
	}

	protected void extractObjects(String fileName) {
		try {
			BufferedReader f = new BufferedReader(new FileReader(fileName));
			String pageName = fileName.substring(fileName.lastIndexOf("/") + 1,
					fileName.lastIndexOf("."));
			Pattern p1 = Pattern.compile("^\\s([a-zA-Z]+.+)\\(\"(.+)\"\\)");
			Pattern p2 = Pattern
					.compile("^.+[String|Locator]+[\\s]+([a-zA-Z]+.+)\\s=\\s.*\"(.+)\".*;");
			Matcher m;
			// Partners_SubMenu("//a[contains(text(),'Partners')]"),
			// public static final String chatLinkTop = "link=Chat Now";
			// public static final Locator Filter_Option = new
			// Locator("//label[contains(text(),'$0')]/input");
			// public static final String blogPostAuthor = new
			// String("//body[@id='blog']//div[@class='post']/p[@class='date']/a");
			String line = f.readLine();
			String oldValue = "";
			while (line != null) {
				m = p2.matcher(line);
				if (m.find()) {
					if (LoadProperties.DISPLAYLOCATORS == true) {
						oldValue = (String) ActionMethods.objects.setProperty(
								m.group(2), pageName + "." + m.group(1) + "::"
										+ m.group(2));
					} else {
						oldValue = (String) ActionMethods.objects.setProperty(
								m.group(2), pageName + "." + m.group(1));
					}
					if (oldValue != null) {
						slog("Duplicate Value for Locator: " + pageName + "."
								+ m.group(1) + "::" + m.group(2) + "->"
								+ oldValue);
					}
				} else {
					m = p1.matcher(line);
					if (m.find()) {
						if (LoadProperties.DISPLAYLOCATORS == true) {
							oldValue = (String) ActionMethods.objects
									.setProperty(m.group(2),
											pageName + "." + m.group(1) + "::"
													+ m.group(2));
						} else {
							oldValue = (String) ActionMethods.objects
									.setProperty(m.group(2),
											pageName + "." + m.group(1));
						}
						if (oldValue != null) {
							slog("Duplicate Value for Locator: " + pageName
									+ "." + m.group(1) + "::" + m.group(2)
									+ "->" + oldValue);
						}
					}
				}
				line = f.readLine();
			}
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method initialize web driver before starting each test.
	 * 
	 * @throws IOException
	 *             In case of any error.
	 * @author tandon_r
	 */

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "version", "platform", "port" })
	public void beforeTest(@Optional("chrome") String browser,
			@Optional("31") String version,
			@Optional("windows") String platform, @Optional("4444") String port)
			throws IOException {
		// public void beforeTest() throws IOException {
		if (LoadProperties.stopSuiteOnFailure & !status) {
			fail("Status Failed");
		}
		put("retry", 0);
		put("Step", -1);
		initialize(browser, LoadProperties.VERSION, LoadProperties.PLATFORM,
				port);
		// initialize("firefox", "32", "windows");
		// getDriver().get(url);
		// test
	}

	@AfterMethod(alwaysRun = true)
	public void afterTestMethod() {
//		browserClose();
		// checkinglist(getAssertList());
		getAssertList().clear();
	}

	/**
	 * This method is used to close the browser
	 */
	public synchronized void browserClose() {
		log.info("browserClose");
		try {
			 getDriver().quit();
			// remove();
		} catch (Exception e) {
			// Assert.assertTrue(false, e.getMessage());
			// log.error("Browser was already closed");
		}
	}

	public void appLaunchURL(String surl) {
		open(url);
		reporter("-The applicatin launched with URL", surl);
	}

	public void fileClose() {
		try {
			fwr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to get and return project name
	 * 
	 * @return Project name
	 */
	public String getProjectName() {
		String projectName = "";
		String directory = System.getProperty("user.dir");
		if (os.toLowerCase().contains("windows")) {
			projectName = directory.substring(directory.lastIndexOf("\\") + 1);
		} else if (os.toLowerCase().contains("linux")) {
			projectName = directory.substring(directory.lastIndexOf("/") + 1);
		}
		return projectName;
	}

	/**
	 * @author This method is used to load FilePaths properties file
	 */
	Properties prop = new Properties();

	public Properties loadProperties() {
		try {
			// load a properties file
			prop.load(new FileInputStream("filePaths.properties"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}

	/**
	 * @author This method is used to append project name
	 */
	public String appendProjName(String pathPropFiles) {
		String finalPath = "";
		finalPath = ".." + File.separator + "" + getProjectName() + ""
				+ File.separator + "" + pathPropFiles;
		return finalPath;
	}

	/**
	 * @author veena.nadipalli This method is to generate random alpha-numeric
	 *         string
	 */
	public String getAlphaNumeric(int len) {
		StringBuffer sb = new StringBuffer(len);
		for (int i = 0; i < len; i++) {
			int ndx = (int) (Math.random() * (ALPHA_NUM.length()));
			sb.append(ALPHA_NUM.charAt(ndx));
		}
		return sb.toString();
	}

	/**
	 * @author veena.nadipalli This method is to generate random numeric string
	 */
	public String getNumeric(int len) {
		StringBuffer sb = new StringBuffer(len);
		for (int i = 0; i < len; i++) {
			int ndx = (int) (Math.random() * (NUMERICS.length()));
			sb.append(NUMERICS.charAt(ndx));
		}
		return sb.toString();
	}

	/**
	 * should be called for every test before execution. it initialises the
	 * properties files and the defines the constants User name, Password and
	 * the browser
	 * 
	 * @throws IOException
	 */
	public void initialize(String browser, String version, String platform,
			String port) throws IOException {
		// LOGGER.info("Entering initialize function .... ");
		// dr = defineBrowser(browser, version, platform, port);
		// driver = new EventFiringWebDriver(dr);
		// get().setWebDriver(dr);

		/*
		 * if (browser.equalsIgnoreCase("explorer")) {
		 * 
		 * getDriver().manage().window().setSize(new Dimension(1024, 1024)); }
		 * else { // getDriver().manage().window().maximize(); //
		 * getDriver().manage().window().setSize(new Dimension(1024, 1024)); }
		 */
		/*
		 * getDriver().manage().timeouts() .pageLoadTimeout(timeout,
		 * TimeUnit.SECONDS);
		 */
		wait(2);
		// log.info(browser + " Browser has been Initialized");
	}

	/**
	 * This method is used to select the browser based on the value declare in
	 * global variable.
	 * 
	 * @param browser
	 * @return
	 */
	/*
	 * public synchronized WebDriver defineBrowser(String browser, String
	 * version, String platform, String port) { URL hubUrl = null;
	 * 
	 * String pathPropFiles = "", finalPropPath = ""; DesiredCapabilities
	 * capabilities = new DesiredCapabilities(); if
	 * (platform.equalsIgnoreCase("WINDOWS")) { //
	 * capabilities.setPlatform(Platform.WINDOWS); } else if
	 * (platform.equalsIgnoreCase("LINUX")) {
	 * capabilities.setPlatform(Platform.LINUX); } loadProperties();
	 * log("under initialize --- " + browser, TestStepType.DATA_CAPTURE);
	 * 
	 * try { hubUrl = new URL("http://" + LoadProperties.HOST + ":" +
	 * LoadProperties.PORT + "/wd/hub");
	 * 
	 * } catch (MalformedURLException e) { e.printStackTrace(); } if
	 * (os.contains("Windows")) { if (browser.equalsIgnoreCase("Firefox")) { try
	 * {
	 * 
	 * dr = new FirefoxDriver(); return dr; } catch (Exception e) {
	 * System.out.println("Error while launching Firefox browser");
	 * e.printStackTrace(); } } else if
	 * (browser.toLowerCase().contains("explorer")) { if
	 * (System.getProperty("os.arch").contains("86")) { pathPropFiles =
	 * prop.getProperty("IEDriverServer_x32"); finalPropPath =
	 * appendProjName(pathPropFiles); System.setProperty("webdriver.ie.driver",
	 * finalPropPath); } else if (System.getProperty("os.arch").contains("64"))
	 * { pathPropFiles = prop.getProperty("IEDriverServer_x64"); finalPropPath =
	 * appendProjName(pathPropFiles); //
	 * System.setProperty("webdriver.ie.driver", finalPropPath); }
	 * capabilities.setBrowserName(DesiredCapabilities
	 * .internetExplorer().getBrowserName()); //
	 * capabilities.setVersion(version);
	 * capabilities.setCapability("ignoreZoomSetting", true);
	 * capabilities.setCapability("ignoreProtectedModeSettings", true); try {
	 * return new RemoteWebDriver(hubUrl, capabilities); } catch
	 * (WebDriverException e) { if (e.getMessage().contains("Unable to bind")) {
	 * try { Thread.sleep(90000); return new RemoteWebDriver(hubUrl,
	 * capabilities); } catch (Exception e1) { System.out
	 * .println("Error while retrying to intialize webdriver");
	 * e1.printStackTrace(); } } else { e.printStackTrace(); } } } else if
	 * (browser.toLowerCase().contains("chrome")) { try {
	 * 
	 * System.setProperty("webdriver.chrome.driver", driverPath +
	 * "chromedriver.exe"); dr = new ChromeDriver(); return dr; } catch
	 * (Exception e) {
	 * System.out.println("Error while launching Chrome browser");
	 * e.printStackTrace(); }
	 * 
	 * } else if (browser.equalsIgnoreCase("Safari")) {
	 * capabilities.setBrowserName(DesiredCapabilities.safari()
	 * .getBrowserName()); capabilities.setVersion(version); try { return new
	 * RemoteWebDriver(hubUrl, capabilities); } catch (WebDriverException e) {
	 * if (e.getMessage().contains("Unable to bind")) { try {
	 * Thread.sleep(90000); return new RemoteWebDriver(hubUrl, capabilities); }
	 * catch (Exception e1) { System.out
	 * .println("Error while retrying to intialize webdriver");
	 * e1.printStackTrace(); } } else { e.printStackTrace(); } } } else if
	 * (browser.toLowerCase().contains("explorer")) { if
	 * (System.getProperty("os.arch").contains("86")) { pathPropFiles =
	 * prop.getProperty("IEDriverServer_x32"); finalPropPath =
	 * appendProjName(pathPropFiles); System.setProperty("webdriver.ie.driver",
	 * finalPropPath); } else if (System.getProperty("os.arch").contains("64"))
	 * { pathPropFiles = prop.getProperty("IEDriverServer_x64"); finalPropPath =
	 * appendProjName(pathPropFiles);
	 * 
	 * } }
	 * 
	 * } return null; }
	 */

	public String getNewRandomEmail() {
		return getNewRandomEmail("test");
	}

	public String getNewRandomEmail(String prefix) {
		return prefix + "_" + dateTime() + getRandomAlphaNumeric(6)
				+ "@sharklasers.com";
	}

	public static String dateTime() {
		return dateFormat.format(new Date());
	}

	public static String Computername() throws UnknownHostException {
		String Computername = null;
		Computername = InetAddress.getLocalHost().getHostName();
		return Computername;
	}

	public void newTab(String Key, String Url) {
		getDriver().findElement(By.cssSelector("body")).sendKeys(
				Keys.CONTROL + Key);
		getDriver().navigate().to(Url);
		reporter("New Tab Opened :: ", Url);
	}

	public void newWindow(String New_Window_Title, List<String> assertList) {
		String p_window = getDriver().getWindowHandle();
		Set<String> s = getDriver().getWindowHandles();
		Iterator<String> ite = s.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			if (!popupHandle.contains(popupHandle)) {
				getDriver().switchTo().window(p_window);
				if (getDriver().getTitle().equals(New_Window_Title)) {
					System.setProperty("org.uncommons.reportng.escape-output",
							"false");
					log.info("driver value :: " + getDriver().toString());
					reporter("Expected URL :: " + New_Window_Title + "</br>"
							+ "Actual URL :: " + getDriver().getTitle()
							+ " :: PASS", "");
					assertList.add("PASS");
				} else {
					reporter("Expected URL :: " + New_Window_Title + "</br>"
							+ "Actual URL :: " + getDriver().getTitle()
							+ " :: FAIL", "");
					assertList.add("FAIL");
				}
			}
			getDriver().switchTo().window(popupHandle);
		}
	}

	public void changeTab() {
		getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,
				Keys.TAB);
		getDriver().navigate().refresh();
	}

	public static String tcName() {
		String TName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		return TName;
	}

	public void accept() {
		getDriver().switchTo().alert().accept();
	}

	public void verifyTextInFields(String Object) {
		String Text = getDriver().findElement(By.id(Object)).getAttribute(
				"value");
		if (Text.isEmpty()) {
			AssertJUnit.assertTrue(true);
		} else {
			AssertJUnit.assertTrue(false);
		}
	}

	public void checkinglist(List<String> ls) {
		checkinglist(ls, "");
	}

	public void checkinglist(List<String> ls, String tName) {
		// reporter("val1","val2");
		for (String temp : ls) {
			if (temp.equals("FAIL")) {
				// throw new Reasons("FAIL");
			}
		}

	}

	public void retry(String locator, Object o) {
		retry(locator, o, 15);
	}

	public void retry(String locator, Object o, int timeout) {
		String methodName = new Throwable().getStackTrace()[1].getMethodName();
		for (int i = 2; excludedMethodNames.contains(methodName); i++) {
			methodName = new Throwable().getStackTrace()[i].getMethodName();
		}
		if (((Integer) (getObject("retry"))) < 2
				&& !waitForElementVisibleNoReport(locator, timeout)) {
			logWithScreenshot("Retrying method: " + methodName
					+ ", Retry Attempt:" + ((Integer) getObject("retry") + 1));
			put("retry", ((Integer) (getObject("retry"))) + 1);
			try {
				// Class.forName(o.getClass().getName().replace("$1",
				// "")).getMethod(methodName, new Class[]
				// {}).invoke(Class.forName(o.getClass().getName().replace("$1",
				// "")).newInstance(), new Object[] {});
				// String className =
				// o.getClass().getName().substring(0,o.getClass().getName().indexOf("$"));
				// Class<?> classI =
				// Class.forName(o.getClass().getName().substring(0,o.getClass().getName().indexOf("$")));
				Class.forName(
						o.getClass()
								.getName()
								.substring(0,
										o.getClass().getName().indexOf("$")))
						.getMethod(methodName, new Class[] {})
						.invoke(Class.forName(
								o.getClass()
										.getName()
										.substring(
												0,
												o.getClass().getName()
														.indexOf("$")))
								.newInstance(), new Object[] {});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		put("retry", 0);
	}

}
