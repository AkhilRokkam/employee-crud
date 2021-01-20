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
				<a href="#" class="navbar-brand">
					Employee Management App </a>
			</div>

		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="idept" method="get">
					<caption>
						<h2>Add New Department</h2>
					</caption>

					<fieldset class="form-group">
						<label>Department Id</label> <input type="text"
							value="<c:out value='${department.dept_id}' />"
							class="form-control" name="dept_id" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Department Name</label> <input type="text"
							value="<c:out value='${department.dept_name}' />"
							class="form-control" name="dept_name" required="required">
					</fieldset>

					<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
