package com.employeeManagement.dbconn;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
//
//	public static final String DRIVER_PROP = "MYSQLJDBC.driver";
//	public static final String DB_NAME_PROP = "MYSQLJDBC.db_name";
//	public static final String DB_USER_NAME_PROP = "MYSQLJDBC.username";
//	public static final String DB_PASSWORD_PROP = "MYSQLJDBC.password";
//	public static final String URL_PROP = "MYSQLJDBC.url";
//	public static final String UNICODE = "?useUnicode=yes&characterEncoding=UTF-8";
	
	
	private static DBConnection dbConnection = new DBConnection();
	private Connection connection;
	/**
	 * make a private constructor to use singleton pattern
	 */
	private DBConnection() {

	}

	public static DBConnection getDB() {
		return dbConnection;
	}


	// must be non static method to be sure that the user get the db instance.
	public void connect() {
		if (connection != null) {
			return;
		}

		try {
			Properties prop = new DBConnection().loadPropertiesFile();
			 
			String driverClass = prop.getProperty("MYSQLJDBC.driver");
			String dbName = prop.getProperty("MYSQLJDBC.db_name");
			String userName = prop.getProperty("MYSQLJDBC.username");
			String password = prop.getProperty("MYSQLJDBC.password");
			String url = prop.getProperty("MYSQLJDBC.url")+dbName;
			
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("connected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("DB Not Connected");
		}

	}

	public Connection getConnection() {
		if (connection == null) {
			connect();
		}
		return connection;
	}

	public void closeConnection() {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// after closing the connection assign it to null
		connection = null;

	}
	
	
	public  Properties loadPropertiesFile() throws Exception {
		 
		Properties prop = new Properties();
		InputStream in=getClass().getResourceAsStream("/com/employeeManagement/jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
	
	
//	public static void main(String[] args) throws Exception {
//		Properties prop = new DBConnection().loadPropertiesFile();
//		 
//		String driverClass = prop.getProperty("MYSQLJDBC.driver");
//		System.out.println("driverClass: "+driverClass);
//		System.err.println("dbName====>"+prop.getProperty("MYSQLJDBC.db_name"));
//		
//	}
// 
}
