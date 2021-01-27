package com.saf.util;
/*package biz.neustar.nsbiz.automation.util;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class SessionTime extends NbizGlobal{
	
	public void data_Time(String Data) {

		GregorianCalendar date = new GregorianCalendar();
		second = date.get(Calendar.SECOND);
		minute = date.get(Calendar.MINUTE);
		hour = date.get(Calendar.HOUR);
		day = date.get(Calendar.DAY_OF_MONTH);
		month = date.get(Calendar.MONTH);
		year = date.get(Calendar.YEAR);
		System.out.println("----" +"Date"+ "--- Date : Time" + day + ":"
				+ month + ":" + year + "----" + hour + ":" + minute + ":"
				+ second);
	}
	

	public void screenShot(String spath, int i) throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(file, new File(spath + "--"
				+ i + "_" + day + "_" + month + "_" + year + "_" + hour + "_"
				+ minute + "_" + second + ".jpg"));
	//	org.apache.commons.io.FileUtils.copyFile(file, new File(spath+i+".jpg"));
	}

	@Test
	public void napac_Maxsessiontimeout(String surl) {
		try {
			driver.get(surl);
		
			driver.findElement(By.cssSelector("form > input[type=\"submit\"]"))
					.click();
			driver.findElement(By.id("username")).sendKeys(
					"sravan.varma@compugain.com");
			driver.findElement(By.id("password")).sendKeys("test123");
			driver.findElement(By.id("accept_tac")).click();// Check box
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			data_Time("Start Time");
		
			// -------------------------Program
			// starting------------------------------
			for (int i = 0; i <= 61; i++) {
				driver.findElement(By.linkText("Access & Connectivity"))
						.click();
				System.out.println("The value of i ----- is " + i);
				//System.out.println(driver.findElement(By.cssSelector("body"))
					//	.getText().contains("Access & Connectivity"));
				if (true==driver.findElement(By.cssSelector("body"))
						.getText().contains("Access & Connectivity")) {
					//	Thread.sleep(3000);
						Thread.sleep(480000); // 8 MINUTES
					//	Thread.sleep(660000); // 11 MINUTES
					driver.findElement(
							By.xpath("(//a[contains(text(),'Read More')])[1"
									+ "]")).click();
					data_Time("Run Number "+ i);
				//	System.out.println(driver.findElement(By.cssSelector("body"))
					//	.getText().contains("New User Access to the NPAC"));
				}
				if (true==driver.findElement(By.cssSelector("body"))
						.getText().contains("New User Access to the NPAC")) {
					System.out.println("Screenshot printed else if " + i);
					screenShot("D:\\Test Run\\Pass\\", i);
					
				} else {
					System.err.println("Session timed out");
					System.err.println("Screenshot printed else " + i);
					screenShot("D:\\Test Run\\Fail\\", i);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		data_Time("End Time");	
	}
	

}*/