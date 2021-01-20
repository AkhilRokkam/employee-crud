package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {
	public Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new Driver());
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
	}
}
