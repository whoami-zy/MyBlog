package com.whoami.sessionHelper;

import java.sql.*;

public class ConnectionHelper {
		Connection conn;
		public Connection  getConnection(){
			 String url = "jdbc:mysql://127.0.0.1:3306/whoami?useUnicode=true&amp;characterEncoding=UTF-8";    
			 String username="root";
			 String password="1010110@whoami";
			 try {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(url, username, password);
				return conn;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("数据库连接失败");
				return null;
			}
		
			
		}
		
}
