package com.ust.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.ust.exception.EmployeeException;

public class DBUtil {
	private static  Connection conn;
	public static Connection getConnection() throws EmployeeException {
		
		if(conn==null) {
			
			try {
				String configFile = "db.config";
				ReadDBDetails rdb = new ReadDBDetails(configFile);
				Properties props = rdb.getData();
				String driver =(String) props.get("DRIVER");
				String url = (String) props.get("URL");
				String username = (String) props.get("USERNAME");
				String pswd = (String) props.get("PASSWORD");
				Class.forName(driver);
				conn = DriverManager.getConnection(url, username, MyPasswordHandler.decrypt(pswd));
			} catch (ClassNotFoundException e) {
				throw new EmployeeException("Internal Error. Please check with Admin");
//				e.printStackTrace();
			} catch (SQLException e) {
//				e.printStackTrace();
				throw new EmployeeException("Internal Error. Please check with Admin");
			}
			
			
		}
		
		return conn;
	}

}

/*
1. Add driver (jar) to lib and build path //
2. Load the driver class
3. Get connection using Driver Manager Class
4. Create Satement using connection
5. Execute the querry using statement
6. Run while loop to get all row (while select)
*/