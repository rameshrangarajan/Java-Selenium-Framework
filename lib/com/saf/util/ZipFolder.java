package com.saf.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import jxl.read.biff.BiffException;

import org.testng.annotations.Test;

import com.saf.global.Global;

public class ZipFolder extends Global {
	private static final String zipFolderPath = null;

	@Test
	public static void zipfile() throws BiffException, IOException
	{
		zipthefolder(zipFolderPath);
		System.out.println("File zipped");
	}
	
	/**
	 * 
	 * @param zipFolderPath : Path of the folder you want to zip.
	 * @throws IOException
	 * @throws BiffException
	 */
	public static void zipthefolder(String zipFolderPath) throws IOException, BiffException {
		try {
				
		File inFolder = new File(zipFolderPath);
		File outFolder = new File(zipFolderPath + ".zip");
		
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));

		BufferedInputStream in = null;
		byte[] data = new byte[1000];
		String files[] = inFolder.list();

		for (int i = 0; i < files.length; i++) {
			String fo = inFolder.getPath()+ "\\" + files[i];
			File fol =  new File(fo);
			//System.out.println("@@@@"+fo);
			//System.out.println("Number of files " +fol.list());
			
			if(fol.list()==null){
				in = new BufferedInputStream(new FileInputStream(inFolder.getPath()+ "/" + files[i]), 1000);
				out.putNextEntry(new ZipEntry(files[i]));
				int count;
				while ((count = in.read(data, 0, 1000)) != -1) {
					out.write(data, 0, count);
				}
				out.closeEntry();
			} else {
				
				
				ziptheinsidfefolder(fo);
			}
		}
		out.flush();
		out.close();
		}catch(Exception e){
			e.printStackTrace();
			//fail(""+e);
		}

	}
	
	public static void ziptheinsidfefolder(String attachment) throws IOException, BiffException {
		try {
				
		File inFolder1 = new File(attachment);
		File outFolder1 = new File(attachment + ".zip");
		
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
				new FileOutputStream(outFolder1)));

		BufferedInputStream in = null;
		byte[] data = new byte[1000];
		String files[] = inFolder1.list();

		for (int i = 0; i < files.length; i++) {
			
				in = new BufferedInputStream(new FileInputStream(inFolder1
						.getPath()
						+ "/" + files[i]), 1000);

				out.putNextEntry(new ZipEntry(files[i]));
				int count;
				while ((count = in.read(data, 0, 1000)) != -1) {
					out.write(data, 0, count);
				}
				out.closeEntry();
			
		}
		out.flush();
		out.close();
		}catch(Exception e){
			e.printStackTrace();
			//fail(""+e);
		}

	}
	
}
