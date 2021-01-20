<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Hr Management Employees</title>
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
				<a href="#" class="navbar-brand"> Employee Management App </a>
			</div>

		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Hr Management</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/list" class="btn btn-success">List
					Of All Employees</a>
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
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="hrManagement" items="${listHrManagement}">

						<tr>
							<td><c:out value="${hrManagement.empid}" /></td>
							<td><c:out value="${hrManagement.empname}" /></td>
							<td><c:out value="${hrManagement.date_of_joining}" /></td>
							<td><c:out value="${hrManagement.dept_name}" /></td>
							<td><c:out value="${hrManagement.cat_name}" /></td>
							<td><c:out value="${hrManagement.salary}" /></td>
							<td><c:out value="${hrManagement.isvalid}" /></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
