package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Admin;
import com.util.DBConnection;

public class AdminDao {

	private Connection con;

	public AdminDao() throws SQLException {
		con = new DBConnection().getConnection();
	}

	public boolean save(Admin admin) {

		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into admin(username,password) values(?,?)");

			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());

			int count = ps.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Admin login(String username, String password) {

		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from admin where username=? and password = ?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Admin admin = new Admin();
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));

				return admin;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
