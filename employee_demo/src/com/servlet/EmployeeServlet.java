package com.servlet;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.dao.CategoryDao;
import com.dao.DepartmentDao;
import com.dao.EmployeeDao;
import com.model.Admin;
import com.model.Category;
import com.model.Department;
import com.model.Employee;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;
	private CategoryDao categoryDao;

	public void init() {
		employeeDao = new EmployeeDao();
		departmentDao = new DepartmentDao();
		categoryDao = new CategoryDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertEmployee(request, response);
				break;
			case "/delete":
				deleteEmployee(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateEmployee(request, response);
				break;
			case "/dpm":
				displayProductManagement(request, response);
			case "/dhm":
				displayHrManagement(request, response);
			case "/idept":
				insertDepartment(request, response);
			case "/icat":
				insertCategory(request, response);
			case "/ddept":
				displayDepartment(request, response);
			case "/dcat":
				displayCategory(request, response);
			case "/editdep":
				showEditDepartment(request, response);
			case "/editcat":
				showEditCategory(request, response);
			default:
				listEmployee(request, response);
				break;
			}
		} catch (SQLException | ParseException ex) {
			throw new ServletException(ex);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/verify":
				test(request, response);
				break;
			default:
				System.out.println("Login failed");
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			AdminDao adminService = new AdminDao();
			Admin admin = adminService.login(username, password);

			if (admin != null) {
				System.out.println("working");
				List<Employee> listEmployee = employeeDao.selectAllEmployees();
				request.setAttribute("listEmployee", listEmployee);
				RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
				dispatcher.forward(request, response);
			} else {
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("insertlist.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("insertdepartment.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("insertcategory.jsp");
		dispatcher.forward(request, response);
	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
		System.out.println("insert method");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String empname = request.getParameter("empname");
		Date date_of_joining = sdf.parse(request.getParameter("date_of_joining"));
		String department = request.getParameter("dept_id");
		int dept_id = Integer.parseInt(department);
		String category = request.getParameter("cat_id");
		int cat_id = Integer.parseInt(category);
		String sal = request.getParameter("salary");
		Double salary = Double.parseDouble(sal);
		String valid = request.getParameter("isvalid");
		boolean isvalid = Boolean.parseBoolean(valid);

		Employee emp = new Employee(empname, date_of_joining, dept_id, cat_id, salary, isvalid);
		employeeDao.insertEmployee(emp);
		response.sendRedirect("successfull.jsp");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeDao.deleteEmployee(id);
		response.sendRedirect("list.jsp");

	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		int empid = Integer.parseInt(request.getParameter("empid"));
		String empname = request.getParameter("empname");
		String date = request.getParameter("date_of_joining");
		Date date_of_joining = (Date) sdf.parse(date);
		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		int cat_id = Integer.parseInt(request.getParameter("cate_id"));
		double salary = Double.parseDouble(request.getParameter("salary"));
		boolean isvalid = Boolean.parseBoolean(request.getParameter("isvalid"));
		Employee emp = new Employee(empid, empname, date_of_joining, dept_id, cat_id, salary, isvalid);
		employeeDao.updateEmployee(emp);
		response.sendRedirect("list.jsp");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		Employee existingEmployee = employeeDao.selectEmployee(empid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editform.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);

	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Employee> listEmployee = employeeDao.selectAllEmployees();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}

	private void displayProductManagement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> listProductManagement = departmentDao.selectProductManagementDept();
		request.setAttribute("listProductManagement", listProductManagement);
		RequestDispatcher dispatcher = request.getRequestDispatcher("productmanagement.jsp");
		dispatcher.forward(request, response);
	}

	private void displayHrManagement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> listHrManagement = categoryDao.selectHrManagementDept();
		request.setAttribute("listHrManagement", listHrManagement);
		RequestDispatcher dispatcher = request.getRequestDispatcher("hrmanagement.jsp");
		dispatcher.forward(request, response);
	}

	private void insertDepartment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		String dept_name = request.getParameter("dept_name");
		Department dep = new Department(dept_id, dept_name);
		departmentDao.insertdepartment(dep);
		List<Department> listDepartment = departmentDao.selectDepartment();
		request.setAttribute("listDepartment", listDepartment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dept.jsp");
		dispatcher.forward(request, response);

	}

	private void insertCategory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int cat_id = Integer.parseInt(request.getParameter("cat_id"));
		String cat_name = request.getParameter("cat_name");
		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		Category cat = new Category(cat_id, cat_name, dept_id);
		categoryDao.insertCategory(cat);
		List<Category> listCategory = categoryDao.selectCategory();
		request.setAttribute("listCategory", listCategory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cat.jsp");
		dispatcher.forward(request, response);
	}

	private void displayDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Department");
		List<Department> listDepartment = departmentDao.selectDepartment();
		request.setAttribute("listDepartment", listDepartment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("dept.jsp");
		dispatcher.forward(request, response);
	}

	private void displayCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> listCategory = categoryDao.selectCategory();
		request.setAttribute("listCategory", listCategory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cat.jsp");
		dispatcher.forward(request, response);
	}
}