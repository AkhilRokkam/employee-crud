package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Department;
import com.model.Employee;

public class DepartmentDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/employeedb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_DEPARTMENT_SQL = "INSERT INTO department" + "  (dept_id,dept_name) VALUES "
			+ " (?, ?);";
	private static final String SELECT_PM_BY_DEPT = "select e.empid,e.empname,e.date_of_joining,d.dept_name,c.cat_name,e.salary,e.isvalid from employee as e inner join department as d on e.dept_id=d.dept_id left join category as c on c.cat_id=e.cat_id where e.dept_id = 10; ";
	private static final String SELECT_DEPARTMENT = "select * from department";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insertdepartment(Department dep) throws SQLException {
		System.out.println(INSERT_DEPARTMENT_SQL);
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_DEPARTMENT_SQL)) {
			statement.setInt(1, dep.getDept_id());
			statement.setString(2, dep.getDept_name());
			statement.executeUpdate();
			System.out.println("New Department updated successfull");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> selectProductManagementDept() {
		List<Employee> emp = new ArrayList<>();

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PM_BY_DEPT);) {

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int empid = rs.getInt("empid");
				String empname = rs.getString("empname");
				Date date_of_joining = rs.getDate("date_of_joining");
				String dept_name = rs.getString("dept_name");
				String cat_name = rs.getString("cat_name");
				double salary = rs.getDouble("salary");
				boolean isvalid = rs.getBoolean("isvalid");
				emp.add(new Employee(empid, empname, date_of_joining, dept_name, cat_name, salary, isvalid));
				System.out.println("adding");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public List<Department> selectDepartment() {
		List<Department> dep = new ArrayList<>();

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DEPARTMENT);) {

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int dept_id = rs.getInt("dept_id");
				String dept_name = rs.getString("dept_name");
				dep.add(new Department(dept_id, dept_name));
				System.out.println("add in dept list");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dep;
	}
}
