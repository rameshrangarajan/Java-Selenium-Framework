package com.saf.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.saf.global.Global;


public class ReadJsonFile {

	/*
	 * Raed the input JSON file and parse the data
	 * Output params
	 * 	List of the IDs parsed from the JSON file
	 * 
	 */
	public List<String> readJson() {
		
		JSONParser parser = new JSONParser();
		JSONArray id;
		List<String> idList=new ArrayList<String>();
		Properties prop = new Properties();
		String loadFile = "", filePath = "";
		int i = 0;
		Global npacObject = new Global();
		try {
	 
			prop = npacObject.loadProperties();
			loadFile = prop.getProperty("InputJsonFile");
			npacObject.log.info(loadFile);
			filePath = npacObject.appendProjName(loadFile);
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(filePath));
						
			id = (JSONArray) jsonObject.get("ID");
			Iterator<String> idIterator = id.iterator();
			while (idIterator.hasNext()) {
				String temp = idIterator.next();
				idList.add(temp);
				i++;
			}
						
		} catch (FileNotFoundException excep) {
			excep.printStackTrace();
		} catch (IOException ioexcep) {
			ioexcep.printStackTrace();
		} catch (ParseException parseex) {
			parseex.printStackTrace();
		}
		return idList;
	} 
}

