package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection getConnection() throws SQLException {

		Connection con = null;
		
		String driver = "com.mysql.cj.jdbc.Driver";
		


		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flyaway","root","7978557203");

		}catch(Exception e)
		{

			e.printStackTrace();
		}

		return con;
	}

	/*
	public static void main(String[] args) {

			getConnection();
			System.out.println("Connection Established");

	}
	 */

}
