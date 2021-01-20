package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class EmployeeDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/employeedb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee"
			+ "  (empid,empname,date_of_joining,dept_id,cat_id,salary,isvalid) VALUES " + " (?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_EMPLOYEE_BY_ID = "select empid,empname,date_of_joining,dept_id,cat_id,salary,isvalid from employee where empid =?";
	private static final String SELECT_ALL_USERS = "select e.empid,e.empname,e.date_of_joining,d.dept_name,c.cat_name,e.salary,e.isvalid from employee as e inner join department as d on e.dept_id=d.dept_id left join category as c on c.cat_id=e.cat_id;";
	private static final String DELETE_EMPLOYEE_SQL = "delete from employee where id = ?;";
	private static final String UPDATE_EMPLOYEE_SQL = "update employee set empname =?,date_of_joining =?,dept_id= ?,cat_id =?,salary =?,isvalid =? where id = ?;";

	public EmployeeDao() {
	}

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

	public void insertEmployee(Employee emp) throws SQLException {
		System.out.println(INSERT_EMPLOYEE_SQL);
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(emp.getDate_of_joining());

			statement.setInt(1, emp.getEmpid());
			statement.setString(2, emp.getEmpname());
			statement.setString(3, date);
			statement.setInt(4, emp.getDept_id());
			statement.setInt(5, emp.getCat_id());
			statement.setDouble(6, emp.getSalary());
			statement.setBoolean(7, emp.isIsvalid());
			System.out.println(statement);
			statement.executeUpdate();
			System.out.println("Updates new user");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee selectEmployee(int id) {
		Employee emp = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String empname = rs.getString("empname");
				Date date_of_joining = rs.getDate("date_of_joining");
				int dept_id = rs.getInt("dept_id");
				int cat_id = rs.getInt("cat_id");
				double salary = rs.getDouble("salary");
				boolean isvalid = rs.getBoolean("iscalid");
				emp = new Employee(empname, date_of_joining, dept_id, cat_id, salary, isvalid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public List<Employee> selectAllEmployees() {
		List<Employee> emp = new ArrayList<>();

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {

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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public boolean deleteEmployee(int empid) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
			statement.setInt(1, empid);
			rowDeleted = statement.executeUpdate() > 0;
			System.out.println("row deleted");
		}
		return rowDeleted;
	}

	public boolean updateEmployee(Employee emp) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
			statement.setString(1, emp.getEmpname());
			statement.setDate(2, (Date) emp.getDate_of_joining());
			statement.setInt(3, emp.getDept_id());
			statement.setInt(4, emp.getCat_id());
			statement.setDouble(5, emp.getSalary());
			statement.setBoolean(6, emp.isIsvalid());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
