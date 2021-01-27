package com.saf.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;


import com.saf.global.Global;
import com.saf.global.TestStepType;


public class ExcelUtil extends Global{
	
	/**
	 * Checks for the existence of any file and, if any file exists in the
	 * Downloads folder , it will delete all the files.
	 * 
	 * @param filepath
	 *            : filepath of the directory
	 */
	public void empty_the_directory(String filepath) throws Exception {

		// String filepath=System.getProperty("user.dir")+"\\Downloads";
		new File(filepath).mkdirs();
		FileUtils.cleanDirectory(new File(filepath));
		
	}
	/**
	 * Compares the values of Excelsheet and Webtable
	 * 
	 * @param sExcelsheetFilepath
	 * @param Obj_Property
	 */
	public void ComparingExcelSheetandWebTable(String Obj_Property,
			String sExcelsheetFilepath, String Obj_Type, String tName, WebDriver driver)  {
		
		AppElement appElems = new AppElement();
		
		log.info("<--------------------------------------------------------------------------------------------------------------->");
		log.info(" Verifyng Test Case Name :: "+tName);
		log.info(" Page Title is :: "+driver.getTitle());
		log.info(" Comparing Application Data with Excel");
		WebElement table = appElems.Find_Object(Obj_Type, Obj_Property,driver);
		List<String> webdata = new ArrayList<String>();
		List<WebElement> allrows = table.findElements(By.tagName("tr"));
		for (WebElement row : allrows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				webdata.add(cell.getText().trim());
			}
		}
		List<String> exceldata = getDataFromExcel(sExcelsheetFilepath);
		if ((exceldata).containsAll(webdata)) {
			Assert.assertTrue(true);
			log.info(" Data in Excel Matches with the Application");
			log.info(" Testcase "+tName+" is :::"+" Pass");

		} else {
			
			log(" Data in Excel does not Matches with the Application",TestStepType.ERRORMESSAGE);
			log.info(" Testcase "+tName+" is :::"+" Fail");
		}
		webdata.clear();
	}

	// ////////////////////////////////////////////////////////anudeep 23/5/2013

	/**
	 * Deletes the files from the local disk
	 * 
	 * @param file
	 *            : file name we want to delete
	 * 
	 */

	public void deletefile(String file) throws Exception {
		File f1 = new File(file);
		boolean success = f1.delete();
		if (!success) {
			System.out.println("Deletion failed.");
			System.exit(0);
		} else {
			System.out.println("File deleted.");
		}
	}
	/**
	 * Reads ExcelSheet and returns a list of the data 
	 */
	public List<String> getDataFromExcel(String sExcelsheetFilepath) 
	{
		List<String> fulldata = new ArrayList<String>() ;
		String data;
		//String sFilepath=NSPData.Filepath_ExcelSheet_PortPSResults.getProperty();
		try
		{
			Workbook wb = Workbook.getWorkbook(new File(sExcelsheetFilepath));
			//System.out.println(wb.getNumberOfSheets());
			for(int sheetNo = 0; sheetNo < wb.getNumberOfSheets(); sheetNo++)
			{                
				Sheet sheet = wb.getSheet(sheetNo);
				int nocolumns = sheet.getColumns();
				int norows = sheet.getRows();

				//System.out.println("Sheet Name\t"+wb.getSheet(sheetNo).getName());
				for(int row = 0;row < norows;row++) {
					for(int col = 0;col <nocolumns;col++) {
						data = sheet.getCell(col, row).getContents();

						fulldata.add(data);
						//System.out.print(data+ " ");
					}                          
					// System.out.println("\n");
				}
			}
		} catch(Exception ioe) {
			ioe.printStackTrace();
		}
		return fulldata;

	}
	
	
	
	
	
}
