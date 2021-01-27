package com.saf.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;

public class HTMLReport {
	public static int i = 0, testcaseTABLESNO, id, nam = 0;
	public static String projectName="nbiz", htmlFileProperties, screenSnapLink;
	public static int passedValue, failedValue, skippedValue, totalValue;
	
	public static String endAppTime, startAppTime,htmlReportPath = "..\\NSBIZ-Framework\\Report\\", startTime1;
	double passRate = 0;
	public static BufferedWriter bw;
	public static double totalexecutionTime; 

	
	static Properties prop = new Properties();

	public static int i() {
		i++;
		return i;
	}

	public static int testcaseTABLESNO() {
		testcaseTABLESNO++;
		return testcaseTABLESNO;
	}

	/**
	 * This method will create a HTML Report with static content. String
	 * appname:Name of the application String url: URl of the application
	 */
	public static void createHTML(String appName, String browser, String url)
			throws Exception {

		projectName = "Nbiz";
		DateTime datestamp = new DateTime();
		String time = datestamp.ymdhmsTime();
		System.out.println("HTML Property file: " + htmlReportPath);
		File f = new File("c:"+ appName + "_" + browser + "_Report_" + time
				+ ".htm");
		String sysusername = System.getProperty("user.name");
		@SuppressWarnings("unused")
		String executionTIme = null;

		FileInputStream fis = new FileInputStream(
				"..\\Framework\\test\\Conf\\HTMLprop.properties");
		prop.load(fis);
		bw = new BufferedWriter(new FileWriter(f));
		@SuppressWarnings("unused")
		String detailTable = null;

		((BufferedWriter) bw)
				.write("<html><head>"
						+ "<script type='text/javascript'>"

						+ " function addRow(sno,testcasename, screenSnap,screenSnapLink, result, starttime, endtime, executiontime)"
						+ "{"
						+ "var colorCode='red';"
						+ " tabBody=document.getElementsByTagName('TBODY').item(0);"
						+ "row=document.createElement('TR');"
						+ "cell1 = document.createElement('TD');"
						+ "cell2 = document.createElement('TD');"
						+ "cell3 = document.createElement('TD');"
						+ "cell4 = document.createElement('TD');"
						+ "cell5 = document.createElement('TD');"
						+ "cell6 = document.createElement('TD');"
						+ "cell7 = document.createElement('TD');"
						+ "if(result=='Passed'){"
						+ "cell4.style.color='green';"
						+ "var colorCode='green';}"
						+ "else if(result=='Failed') {"
						+ "cell4.style.color='red'; "
						+ "var colorCode='red';}"
						+ "else if(result=='Skipped') {"
						+ "cell4.style.color='#FFD700'; "
						+ "var colorCode='green';}"

						+ "cell1.setAttribute('align', 'center');"
						+ "cell4.setAttribute('align', 'center');"
						+ "cell5.setAttribute('align', 'center');"
						+ "cell6.setAttribute('align', 'center');"
						+ "cell7.setAttribute('align', 'center');"
						+ "cell4.style.fontWeight = 'bold';"

						+ "textnode1=document.createTextNode(sno);"
						+ "textnode2=document.createTextNode(testcasename);"
						+ "textnode3=document.createTextNode(screenSnap);"
						+ "textnode4=document.createTextNode(result);"
						+ "textnode5=document.createTextNode(starttime);"
						+ "textnode6=document.createTextNode(endtime);"
						+ "textnode7=document.createTextNode(executiontime);"

						+ "link = document.createElement ('A');"
						+ "link.appendChild(textnode3);"
						//+ "link.setAttribute ('href','#'+sno);"
						+ "link.style.textDecoration='none';"

						+ "link1 = document.createElement('A');"
						+ "link1.appendChild(textnode4);"
						+ "link1.setAttribute ('href','file:///'+screenSnapLink);"
						+ "link1.setAttribute ('target','_blank');"
						+ "link1.style.textDecoration='none';"
						+ "link1.style.color=colorCode;"

						+ "cell1.appendChild(textnode1);"
						+ "cell2.appendChild(textnode2);"
						+ "cell3.appendChild(textnode3);"
						+ "cell4.appendChild(link1);"
						+ "cell5.appendChild(textnode5);"
						+ "cell6.appendChild(textnode6);"
						+ "cell7.appendChild(textnode7);"

						+ "row.appendChild(cell1);"
						+ "row.appendChild(cell2);"
						+ "row.appendChild(cell3);"
						+ "row.appendChild(cell4);"
						+ "row.appendChild(cell5);"
						+ "row.appendChild(cell6);"
						+ "row.appendChild(cell7);"

						+ "tabBody.appendChild(row);"
						+ "}"

						+ "function testCaseTable(){"
						+ "tabBody=document.getElementsById('testcaseTable');"
						+ "row=document.createElement('TR');"

						+ "cell1 = document.createElement('TD');"
						+ "textnode1=document.createTextNode();cell1.appendChild(textnode1);tabBody.appendChild(row);"
						+ "}"
						+ "function addDetailRow(testcaseName, detailsno,expected, actual, data, detailresult1)"
						+ "{"

						+ "tabBody=document.getElementsByName(testcaseName).item(0);"
						+ "row=document.createElement('TR');"
						+ "cell1 = document.createElement('TD');"
						+ "cell2 = document.createElement('TD');"
						+ "cell3 = document.createElement('TD');"
						+ "cell4 = document.createElement('TD');"
						+ "cell5 = document.createElement('TD');"
						+ "cell1.setAttribute('align', 'center');"

						+ "if(detailresult1=='Passed'){"
						+ "cell5.style.color='green';}"
						+ "else if (detailresult1=='Failed'){"
						+ "cell5.style.color='red';}"
						+ "else if (detailresult1=='Skipped'){"
						+ "cell5.style.color='#FFD700';}"
						+ "cell5.style.fontWeight = 'bold';"
						+ "cell5.setAttribute('align', 'center');"

						+ "textnode1=document.createTextNode(detailsno);"
						+ "textnode2=document.createTextNode(expected);"
						+ "textnode3=document.createTextNode(actual);"
						+ "textnode4=document.createTextNode(data);"
						+ "textnode5=document.createTextNode(detailresult1);"
						+ "text4=document.createElement('PRE');"
						+ "text4.appendChild(textnode4);"

						+ "cell1.appendChild(textnode1);"
						+ "cell2.appendChild(textnode2);"
						+ "cell3.appendChild(textnode3);"
						+ "cell4.appendChild(text4);"
						+ "cell5.appendChild(textnode5);"

						+ "row.appendChild(cell1);"
						+ "row.appendChild(cell2);"
						+ "row.appendChild(cell3);"
						+ "row.appendChild(cell4);"
						+ "row.appendChild(cell5);"

						+ "tabBody.appendChild(row);"
						+ "}"
						+ "function testcaseTable(testCaseName){"
						+ "var table=document.getElementById('testcaseTable');"
						+ "var row=table.insertRow();"
						+ "var cell1=row.insertCell();"
						+ "var cell2=row.insertCell(1);"
						+ "cell1.innerHTML=testCaseName;"
						+ "}"
						+ "</script></head><body>"
						+

						"<div style= 'height:3%'></div><div id='header' style='height:30px; width:100%;'>"
						+ "<div style='float:left;color:green; width:50%; font-size:25px;height:30px;' align='left'><b>"
						+ prop.getProperty("heading")
						+ "</b></div> "
						+ "<div style='float:left;font-size:13px; width:15%;' align='left'><b>Time: </b>"
						+ startTime1
						+ "<br /><b> Run By:</b> "
						+ sysusername
						+ "</div>"
						+ "<div style='float:left;font-size:13px; '><b>Browser: </b> "
						+ browser
						+ "<br /><b> AUT-URL: </b>"
						+ "<a href="
						+ url
						+ " target='_blank' style='text-decoration: none'>"
						+ url
						+ "</a>"
						+ "</div>"
						+ "</div>"
						+ "<div style= 'height:3%'></div>"
						+

						"<div  style='background-color:#66CCFF;clear:right;font-size:20px; border:2px ' align='left'>"
						+ projectName
						+ "</div><div style= 'height:1%;'></div><div><b>Over View</b></div>"
						// +
						// "<div><div style= 'font-size:20px '><b>Test Cases</b> </div></div>"
						// +
						// "<div><b><div style='float:left;width:15%;'>Duration</div><div style='float:left;width:15%;'>Passed</div><div style='float:left;width:15%;'>Skipped</div><div style='float:left;width:15%;'>Failed</div><div style='float:left;width:15%;'>Total</div><div style='float:left;width:25%;'>Pass Rate</div></b></div>"
						+ "<div><div id='duration' style='float:left;width:15%; background-color:#A4A4A4'>"

						+ "</div><div id='passed' style='float:left;width:15%;background-color:#81F781'>"

						+ "</div><div id='skipped' style='float:left;width:15%;background-color:#FFFF00'>"

						+ "</div><div id='failed' style='float:left;width:15%;background-color:#FA5858'>"

						+ "</div><div id='total' style='float:left;width:15%;background-color:#FFE4B5'>"

						+ "</div><div id='passRate' style='float:left;width:25%;background-color:#B0C4DE'>"

						+ "</div></div>"
						+ "<div style= 'height:4%;'></div><div><b>Summary<b></div>"
						+ "<table id='myTable' border=2 width='100%' BORDERCOLOR=#080808><tr bgcolor=#E0E0E0>"
						+ "<th width='5%'>"
						+ prop.getProperty("tableheader1")
						+ "</th>"
						+ "<th width='15%'>"
						+ prop.getProperty("tableheader2")
						+ " </th>"
						+ "<th width='50%'>"
						+ prop.getProperty("tableheader3")
						+ "</th>"
						+ "<th width='7%'>"
						+ prop.getProperty("tableheader4")
						+ "</th>"
						+ "<th width='8%'>"
						+ prop.getProperty("tableheader5")
						+ "</th>"
						+ "<th width='8%'>"
						+ prop.getProperty("tableheader6")
						+ "</th>"
						+ "<th width='7%'>"
						+ prop.getProperty("tableheader7")
						+ "</th>" +

						"</table><tbody></tbody>");
		bw
				.write("<div align='right'><u><a href='#header'>Go to Top</a></u></div>");

		bw.write("</body>" + "</html>");

	}

//	/**
//	 * @return
//	 */
//	@SuppressWarnings("unused")
//	private static int nam() {
//
//		nam++;
//		return nam;
//	}

	/**
	 * @returns id
	 */
	private static int id() {
		id++;
		return id;
	}

	/**
	 * This method will create OverView section for HTML Report
	 * 
	 */
	public static void reportHTML() throws Exception {

		bw
				.write("<script type='text/javascript'>document.getElementById('passed').innerHTML='Passed: "
						+ passedValue + "';</script>");
		bw
				.write("<script type='text/javascript'>document.getElementById('failed').innerHTML='Failed: "
						+ failedValue + "';</script>");
		bw
				.write("<script type='text/javascript'>document.getElementById('skipped').innerHTML='Skipped: "
						+ skippedValue + "';</script>");
		bw
				.write("<script type='text/javascript'>document.getElementById('total').innerHTML='Total: "
						+ totalValue + "';</script>");
		double passRate = ((double) passedValue / totalValue) * 100;
		bw
				.write("<script type='text/javascript'>document.getElementById('passRate').innerHTML='Pass Rate: "
						+ passRate + "%';</script>");

		DateTime datetime = new DateTime();
		endAppTime = datetime.hmsTime();
		DateTime timediff = new DateTime();
		totalexecutionTime = timediff.timeDifference(startAppTime,
				endAppTime);
		bw
				.write("<script type='text/javascript'>document.getElementById('duration').innerHTML='Duration: "
						+ totalexecutionTime + " (Secs)';</script>");
		bw.close();

	}

	/**
	 * This method will create a table for the test cases steps in HTML Report
	 * 
	 */
	public static void testcaseTable(String testcaseKeyword, String testcaseName)
			throws Exception {
		testcaseTABLESNO = 0;
		bw.write("<table id='' width='100%' ><tr><td>"

		+ "<table id='" + id() + "' name='" + testcaseKeyword
				+ "' border=2 BORDERCOLOR=#080808 width='100%'><tr><b>" + i()
				+ ". " + testcaseName + "</b></tr><tHead><tr>"

				+ "<th width='5%' bgcolor=#E0E0E0>"
				+ prop.getProperty("detailtableheader1") + "</th>"

				+ "<th width='30%' bgcolor=#E0E0E0>"
				+ prop.getProperty("detailtableheader2") + " </th>"
				+ "<th width='30%' bgcolor=#E0E0E0>"
				+ prop.getProperty("detailtableheader3") + "</t>"
				+ "<th width='30%' bgcolor=#E0E0E0>"
				+ prop.getProperty("detailtableheader4") + "</th>"
				+ "<th width='5%' bgcolor=#E0E0E0>"
				+ prop.getProperty("detailtableheader5") + "</th>"
				+ "</tHead></table>" + "</td></table>");
		bw
				.write("<div align='right'><u><a href='#header'>Go to Top</a></u></div>");
		bw.write("<div style= 'height:1%;'></div>");
	}

	public static void main(String[] args) throws Exception {

		DateTime datetime = new DateTime();
		startAppTime = datetime.hmsTime();
		 htmlReportPath = "C:";
			//DateTime datetime=new DateTime();
			endAppTime = datetime.hmsTime();
			DateTime timediff = new DateTime();
			double totalexecutionTime = timediff.timeDifference(startAppTime,
					endAppTime);

		createHTML("Nbiz","FIREFOX", "www.google.com");
		//testcaseTable("Summary_TestCase table", "Test Case Name");
		HTMLReport.bw
				.write("<script type='text/javascript'>addDetailRow('TC_Examle_01','1','asasasasas','q23q232','@#$$$','Failed' )</script>");
		HTMLReport.bw
				.write("<script type='text/javascript'>addDetailRow('TC_Examle_02','2','','','','PAssed' )</script>");
		//testcaseTable("TC_Examle_02", "Verify so and so...");
		HTMLReport.bw
				.write("<script type='text/javascript'>addRow('1','TC_Examle_01','Verify so and so...','','Failed','"
						+ startAppTime + "','"
						+ endAppTime + "','"
						+ totalexecutionTime + "' )</script>");
		reportHTML();
	}

}
