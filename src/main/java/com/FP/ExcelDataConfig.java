package com.FP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author tandon_r 
 * Code to read data from excel sheet
 */
public class ExcelDataConfig {

	XSSFWorkbook workbook;
	XSSFSheet worksheet;

	public ExcelDataConfig(String excelPath) {

		try {
			File excel = new File(excelPath);
			FileInputStream fileInputStream = new FileInputStream(excel);
			workbook = new XSSFWorkbook(fileInputStream);
			// worksheet = workbook.getSheetAt(0);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	/**
	 * @param sheetNumber
	 * @param row
	 * @param col
	 * @return code to fetch data from cell
	 */
	public String getData(int sheetNumber, int row, int col) {
		String data = null;
		try {
			worksheet = workbook.getSheetAt(sheetNumber);
			data = worksheet.getRow(row).getCell(col).getStringCellValue();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;

	}
}
