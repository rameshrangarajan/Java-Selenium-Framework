package com.saf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.saf.global.LoadProperties;




public class DataHandler {
	// JDBC driver name and database URL
	static final String DRIVER = LoadProperties.DB_DRIVER;//"com.mysql.jdbc.Driver";
	static final String DB_URL = LoadProperties.DB_URL;//"jdbc:mysql://localhost/NSBIZ";

	// Database credentials
	static final String USER = LoadProperties.DB_USERNAME;//"root";
	static final String PASS = LoadProperties.DB_PASSWORD;//"mysql";

	static Connection conn = null;
	static Statement stmt = null;

	public static void init() {
		//  Register JDBC driver
		try {
			Class.forName(DRIVER);

			//Open a connection
			System.out.println("Connecting to database...");
			try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (Exception e) {
				if(e.getMessage().contains("Unknown database"))
				conn = DriverManager.getConnection(DB_URL.toLowerCase().replace("/testdata", ""), USER, PASS);
				stmt = conn.createStatement();
				stmt.executeUpdate("create database testdata");
				conn.close();
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				stmt = conn.createStatement();
				stmt.executeUpdate("CREATE TABLE `testdata` (`sr` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,`key` VARCHAR(200) NULL DEFAULT '.',`value` VARCHAR(200) NULL DEFAULT '.',`ts` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (`sr`)) COLLATE='utf8_general_ci' ENGINE=InnoDB AUTO_INCREMENT=3997;");
				conn.close();
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			}

			// Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setData(String key, String value) {
		if(stmt==null){
			init();
		}
		String sql = "INSERT INTO testdata (testdata.key,testdata.value) " +  "VALUES (\""+key+"\",\""+value+"\")";
	        try {
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				sql="UPDATE testdata SET testdata.value=\""+value+"\" WHERE testdata.key=\""+key+"\"";
				try {
					stmt.executeUpdate(sql);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
	}

	public static String getData(String key) {
		if(stmt==null){
			init();
		}
		
		String value="";
		 String sql = "SELECT testdata.value FROM testdata WHERE testdata.key =\""+key+"\" ORDER BY sr DESC LIMIT 1";
	      try {
	    	  
	    	  ResultSet rs = stmt.executeQuery(sql);
			  // Extract data from result set
			  while(rs.next()){
			     value = rs.getString("value");
			  }
			 rs.close();
			 return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
