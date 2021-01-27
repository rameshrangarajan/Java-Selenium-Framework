package com.saf.util;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.saf.global.Global;

public class WriteJsonFile extends Global{
	public static JSONArray deletedList = new JSONArray();
	public static JSONArray noMatchList  = new JSONArray();
	public static JSONArray notDeletedList  = new JSONArray();
	
	/*
	 * Add each account name to the list
	 * Input Params
	 * int type
	 * 		1:Deleted Record
	 * 		2:No Match Found Record
	 * 		3:Not Deleted Record
	 * String name
	 * 		Account name
	 *  
	*/
	JSONObject obj = new JSONObject();
	@SuppressWarnings("unchecked")
	public void writeJson(int type, String name){
					
		switch (type) {
		case 1:
			deletedList.add(name);
			break;
		
		case 2:
			noMatchList.add(name);
			break;
				
		case 3:
			notDeletedList.add(name);
			break;

		default:
			break;
		}
	}
	/*
	 * Write final data to JSON file
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void addJson() {
			
		obj.put("DELETED", deletedList);
		obj.put("NO MATCH FOUND", noMatchList);
		obj.put("NOT DELETED", notDeletedList);
		try {
	 
			FileWriter file = new FileWriter(appendProjName("OutputJsonFile"));
			file.write(obj.toJSONString());
			file.flush();
			file.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		System.out.print(obj);
	 
	}
	
}


 