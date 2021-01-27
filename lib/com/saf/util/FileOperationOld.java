package com.saf.util;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.Reporter;

import com.saf.global.Logfile;

public  class FileOperation extends Logfile{

	/**
	 * This Method is used to get the Absolute path of the File
	 * @param sFilepath : Contains the Folder Path.
	 * @return : It returns the Path of the File
	 */
	
	
	public String getFilePath(String sFilepath) {
		char cforwardslash = (char) 47;
		char cbackslash = (char) 92;
		String sPath = System.getProperty("user.dir").replace(cbackslash,
				cforwardslash)
				+ sFilepath;

		File file = new File(sPath);
		if (file.exists()) {
			sPath = file.getAbsolutePath();
			log.info("The File Path is " + sPath);
		} else {
			log.info("File not Found");
		}
		return sPath;
	}
	
	/**
	 * This provides the List of Response Files generated during the Test-Case Execution
	 * @param sFilepath : Contains the File Path.
	 * @return: Returning the List of Files
	 */
	public ArrayList<String> getFileName(String sFilepath) {
		ArrayList<String> listofFiles = new ArrayList<String>();
		log.info("The value of path is-------------->"+sFilepath);
		log.info("In get File Name Method------------>");
		
		File file = new File(sFilepath);
		if(file.exists())
		{
		File[] listoffile = file.listFiles();
		log.info("The list of files are "+listoffile.toString());
		log.info("Length of the Files "+listoffile.length);
		for (int i = 0; i < listoffile.length; i++) {
			log.info("The name given is---------->"+ listoffile[i].getAbsolutePath());
			listofFiles.add(listoffile[i].getAbsolutePath());
		}
		}
		else {
			log.error("FILE NOT FOUND");
		}
			return listofFiles;
	}
	
	/**
	 * This Method Provide to move the response file for Failed Test-Case to another Folder and Renaming it according to the TestCase Name 
	 * @param sFilepath : Contains the path for the Downloads Folder.
	 * @param destPath : Contains the Path for the Response Folder.
	 * @param sTestcaseName :Contains the Test case name.
	 * @return:Returning only the boolean value
	 * @throws IOException
	 */
	public boolean moveFile(String sFilepath, String destPath,
			String sTestcaseName) throws IOException {
		File file = null;
		log.info("File path :::"+sFilepath);
		log.info("DestPath ::::"+destPath);
		log.info("TestcaseName:::"+sTestcaseName);
		log.info("In the moveFile Method-------------");
		ArrayList<String> listofFiles  = new ArrayList<String>();
		if(getFileName(sFilepath) != null){
		listofFiles.addAll(getFileName(sFilepath));
		 file = new File(listofFiles.get(0));
		listofFiles=getFileName(sFilepath);  
		//file = new File(listofFiles.toString());
	    //String str=listofFiles.get(0);
		log.info("The file name is--------" + file.getName());
		log.info("---------------------The file is being Moved -------------");
		}
		 Reporter.log("<a href=\"" + destPath +"/"+sTestcaseName
				  + "\"target='blank'><p align=\"left\"><h5>Click to get Response Data"
				  + "value" + "</h5></p></a>");
				  log.info("The file destPath path is--------" + destPath +"/"+sTestcaseName);
		
		return file.renameTo(new File(destPath, sTestcaseName));
		
	}
	
	/**
	 * This Method help us to check the Status of the file wheather it is moved to the new folder and Renamed with the same name as TestCase Name
	 * @param destPath : Contains the path for the Response Folder
	 * @param sTestcaseName : Contains the test-case name.
	 */
	
	
	public void checkFileStatus(String destPath,String sTestcaseName )
	{
	//ArrayList<String> listofFiles = new ArrayList<String>();
		log.info("In Status Check Method------------>");
		File file = new File(destPath);
		File[] listoffile = file.listFiles();
   
		String slistofFiles;
		for (int i = 0; i < listoffile.length; i++) {
			slistofFiles = listoffile[i].getName();
			   if(sTestcaseName.equalsIgnoreCase(slistofFiles))
			   {
				  boolean var= listoffile[i].exists();
				  log.info("File is Found"+var); 
			   }
			   else
			   {
				   log.info("File Not Found in the Folder");
			   }
		}
	}
	
	
	/**
	 * This Method is used to Delete the file from the Folder.
	 * @param sFilepath: Contains the path for the Response Folder.
	 */
	public void deleteResponseFile(String sFilepath)
	{
		File file = new File(sFilepath);
		 File[] listofFile = file.listFiles();
		 for(int i=0;i<listofFile.length;i++)
		 {
			 if(listofFile[i].exists())
			 {
				 log.info("File is Present");
				  boolean status=listofFile[i].delete();
                  log.info("The File is Deleted-------->"+status);				    
			 }
			 else
			 {
				 log.info("File is Not Present");
			 }
		 }
	}
	
	 
	/**
	 * This Method Creates a Directory which stores all the responses.
	 * @param sFolderName :Contains the path for the DownLoads Folder were Response file is created. 
	 * @param sDestPath : Contains the Path for the Response Folder.
	 */
	
	
	
	
	public void createResponseDirectory(String sFolderName,String sDestPath)
	   {
		  
		   File file1 = new File(getFilePath(sDestPath));
		   File file = new File(getFilePath(sFolderName));
		   //log.info(file.getAbsolutePath());
		    file1.mkdir();
		   if(file.exists() || file.isDirectory()){
			  log.info("Folder Exist---------->");
			  log.info("The value of the Absolute File is--------->"+file.getAbsoluteFile().toString());
			   
			   if(file.getAbsoluteFile().exists()){
				   log.info("Searching for the File------------->");
				   
				   File[] fileArr = file.getAbsoluteFile().listFiles();
				     log.info("The Files are Present------------->"+fileArr.toString());
				      log.info("The Files are Present------------->"+fileArr.length); 
				     
				    for(int i=0;i<fileArr.length;i++){
				    	if(fileArr[i].exists()){
				    		fileArr[i].delete();
				    		log.info("The File is Deleted");
				    	}else if(file.length()<=0){
				    		log.info("Folder is Empty");
			    		}
				    }
			   }
		   }else{
			   file.mkdir();
			   log.info("The Folder is Created");
		   }
	   }
	   
	/**   
	 * This Method moves  the Response Folder and Html Reports to the Backup Folder in the Framework.
	 * @param sResponseFolder :Contains the Path for the Response Folder.
	 * @param sBackupFolder : Contains the Path for the Backup Folder.
	 * @param sHtmlReportFolder : Contains the path for the HTML Reports.
	 */
	public void moveDataBackup(String sResponseFolder,String sBackupFolder,String sHtmlReportFolder) 
	{
		   log.info("In the DataBack_Up Folder");
		   File file = new File(getFilePath(sResponseFolder));
		   File file1 = new File(getFilePath(sBackupFolder));
		   File file2 = new File(getFilePath(sHtmlReportFolder));
		    file1.mkdir();
		    log.info("The BackUp directory is created");
		   try {
			file.renameTo(new File(file1,file.getName() + new DateTime().yyyyMMDDHHmmssTime()));
			Thread.sleep(5000);
			file2.renameTo(new File(file1,file2.getName() + new DateTime().yyyyMMDDHHmmssTime()));
			log.info("Folder is Moved-------------");
		     file.mkdir();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param sFilePath
	 * @return
	 */
	public boolean fileExist(File sFilePath){
		log.info("In the File Exist Method");
		boolean status =false;
		if(sFilePath.isFile()){
			log.info("File is Present-------");
		}
		else{
			log.info("File does not exist.........");
		}
		return status;
	}
	 
	/**
	 *    
	 * @param sFilePath
	 * @return
	 */
	public String[] directoryExist(File sFilePath){
		String[] list = null;
		if(sFilePath.isDirectory()){
			 list=sFilePath.list();
			log.info("Directoryis fount and files are getting added");
		}else{
			log.info("The above is not Directory");
			
		}
		return list;
	}

	public static void flog(String msg) {
		flog("flog.html", msg);
	}

	public static void flog(String fileName, String msg, String suffix) {
		try {
			FileWriter fw = new FileWriter(fileName,true);
			fw.write(msg+suffix);
			fw.close();
		} catch (Exception e) {}
	}
	public static void flog(String fileName, String msg) {
		flog(fileName, msg, "<br>\n");
	}
	
	
}


 
   

	
	
	
