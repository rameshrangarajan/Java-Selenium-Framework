package com.saf.util;
package biz.neustar.nsbiz.automation.util;

import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import biz.neustar.nbiz.automation.global.NbizGlobal;

public class ExcelReport extends NbizGlobal {
	
	public static WritableWorkbook writeWorkBook = null;
	public WritableSheet writeSheet = null;
	Label result = null;
	public FileOutputStream fo=null;


	public void writeExcel() throws IOException {
		fo = new FileOutputStream(excelPath);
		writeWorkBook = Workbook.createWorkbook(fo);
		writeSheet = writeWorkBook.createSheet("Results", 0);
		//System.out.println("File opened");
	}

	/**
	 * Excel template is created in your work space.
	 */
	public void excelTemplate() {
		try {
			writeExcel();
			Label Sno = new Label(0, 0, "Sno");
			Label testCasesname = new Label(1, 0, "Testcase Name");
			Label expected = new Label(2, 0, "Expected");
			Label actual = new Label(3, 0, "Actual");
			Label status = new Label(4, 0, "Status");
			writeSheet.addCell(Sno);
			writeSheet.addCell(testCasesname);
			writeSheet.addCell(expected);
			writeSheet.addCell(actual);
			writeSheet.addCell(status);
			//System.out.println("Template Created");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	int i=1;
	public  void appendExcel(String sTestcasename, String sExpected,String sActual, String sStatus) {
	
		try {
			
				Label sno = new Label(0,i,""+i);
				Label id = new Label(1, i, sTestcasename);// username
				Label expected = new Label(2, i, sExpected);// password
				Label actual = new Label(3, i, sActual);// result
				Label status = new Label(4, i, sStatus);// result
				writeSheet.addCell(sno);
				writeSheet.addCell(id);
				writeSheet.addCell(expected);
				writeSheet.addCell(actual);
				writeSheet.addCell(status);
				
				i=i+1;
			//	writeWorkBook.write();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excelClose() throws IOException, WriteException {
		writeWorkBook.write();
		writeWorkBook.close();
		fo.close();
		System.out.println("File closed");
	}

	public static void main(String ar[]) throws WriteException, IOException{
			ExcelReport report=new ExcelReport();
			report.excelTemplate();
			report.appendExcel("a1","a2","a3","a4");
			report.appendExcel("a1","a2","a3","a4");
			report.appendExcel("a1","a2","a3","a4");
			report.appendExcel("a1","a2","a3","a4");
			report.appendExcel("a1","a2","a3","a4");
			writeWorkBook.write();
			report.excelClose();
	}

}
