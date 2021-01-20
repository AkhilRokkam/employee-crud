<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> User
					Management App </a>
			</div>

		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="insert" method="get">
					<caption>
						<h2>
							<c:if test="${employee == null}">
            			Add New Employee
            		</c:if>
						</h2>
					</caption>

					<c:if test="${employee != null}">
						<input type="hidden" name="id"
							value="<c:out value='${employee.empid}' />" />
					</c:if>

					<fieldset class="form-group">
						<label>Employee Name</label> <input type="text"
							placeholder="Full Name"
							value="<c:out value='${employee.empname}' />"
							class="form-control" name="empname" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Date of Joining</label> <input type="text"
							placeholder="yyyy-mm-dd"
							value="<c:out value='${employee.date_of_joining}' />"
							class="form-control" name="date_of_joining" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Department Id</label> <input type="text"
							placeholder="Department value"
							value="<c:out value='${employee.dept_id}' />"
							class="form-control" name="dept_id" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Category Id</label> <input type="text"
							placeholder="Category value"
							value="<c:out value='${employee.cat_id}' />" class="form-control"
							name="cat_id" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Salary</label> <input type="text"
							value="<c:out value='${employee.salary}' />" class="form-control"
							name="salary" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Exist</label> <input type="text" placeholder="true or false"
							value="<c:out value='${employee.isvalid}' />"
							class="form-control" name="isvalid" required="required">
					</fieldset>

					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
