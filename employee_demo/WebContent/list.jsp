<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List of Employees</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Employee
					Management App </a>
			</div>

		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/list" class="btn btn-success">List
					Of All Employees</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Employee</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/ddept" class="btn btn-success">Department List</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/dcat" class="btn btn-success">Category List</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/dpm" class="btn btn-success">Product Department</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/dhm" class="btn btn-success">Hr Department</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Date of joining</th>
						<th>Department</th>
						<th>Category</th>
						<th>Salary</th>
						<th>Exist</th>
						<%-- ><th>Actions</th>--%>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="employee" items="${listEmployee}">

						<tr>
							<td><c:out value="${employee.empid}" /></td>
							<td><c:out value="${employee.empname}" /></td>
							<td><c:out value="${employee.date_of_joining}" /></td>
							<td><c:out value="${employee.dept_name}" /></td>
							<td><c:out value="${employee.cat_name}" /></td>
							<td><c:out value="${employee.salary}" /></td>
							<td><c:out value="${employee.isvalid}" /></td>
							<%--<td><a href="edit?id=<c:out value='${employee.empid}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${employee.empid}' />">Delete</a></td>--%>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
