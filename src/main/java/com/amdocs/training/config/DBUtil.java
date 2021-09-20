package com.amdocs.training.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static String dbUrl = "jdbc:mysql://localhost:3306/user1";
	private static String username = "luisalvf";
	private static String password = "1234";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, username, password);
			return conn;
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}