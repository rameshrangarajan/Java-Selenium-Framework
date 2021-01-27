package com.saf.util;
/*package biz.neustar.nsbiz.automation.util;

import java.io.*;
import java.util.*;

import org.junit.Test;

import biz.neustar.nbiz.automation.global.NbizGlobal;

public class XMLReport  extends NbizGlobal {
	
	public static FileInputStream fis = null;
	public static ArrayList<String> TestCaseName = new ArrayList<String>();
	public static ArrayList <String> Expected = new ArrayList<String>();;
	public static ArrayList <String> Actual = new ArrayList<String>();;
	public static ArrayList <String> Status = new ArrayList<String>();;
	//public static ArrayList <String> Comment = new ArrayList<String>();
	static Properties prop = new Properties();
	 
@Test
	public void htmlReport() throws Exception {
		
			fis = new FileInputStream(htmlPropertiesPath);
			prop.load(fis);
			
		ReportLogData(prop.getProperty("TestCaseName"),prop.getProperty("Expected"),prop.getProperty("Actual"),prop.getProperty("Status"));
		

		GenerateReport();
	}

	public void GenerateReport() {
		try {
			String Header = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n	    	  <?xml-stylesheet type=\"text/xsl\" href=\"Report.xsl\"?>";
			String Body = "<catalog>\n";
			
			int size = TestCaseName.size();
			for (int i = 0; i < size; i++) 
			{				
				Body = Body + "\n<cd>\n" + "<TestCaseName>"+ TestCaseName.get(i) + "</TestCaseName>";
				Body = Body + "\n\n" + "<Expected>" + Expected.get(i)+ "</Expected>";
				Body = Body + "\n\n" + "<Actual>" + Actual.get(i) + "</Actual>";
				Body = Body + "\n\n" + "<Status>" + Status.get(i) + "</Status>\n</cd>";
			//	Body = Body + "\n\n" + "<Comment>" + Comment.get(i)+"</Comment>\n</cd>";
			}

			Body = Header + Body + "\n</catalog>\n";
			FileWriter fstream = new FileWriter(htmlReportPath);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(Body);
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	//--------------------------------------------------------------------------
	
	*//**
	 * 
	 * @param TestCaseName1
	 * @param Expected1
	 * @param Actual1
	 * @param Status1
	 * @param Comment1
	 *//*
	public static void ReportLogData(String TestCaseName1,String Expected1,String Actual1,String Status1,String Comment1)
	{
		
	    TestCaseName.add(TestCaseName1);
		Expected.add(Expected1);
		Actual.add(Actual1);
		Status.add(Status1);
		//Comment.add(Comment1);
	}
	
	
	//----------------------------------------------------------------------------

}
*/