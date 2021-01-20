<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>admin login</title>
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
				<a href="admin.jsp" class="navbar-brand"> Employee Management
					App </a>
			</div>
		</nav>
	</header>
	<br>

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="verify" method="post">
					<caption>
						<h2>Administrator</h2>
						<br>
					</caption>

					<fieldset class="form-group">
						<label>username</label> <input type="text" class="form-control"
							name="username" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>password</label> <input type="password"
							class="form-control" name="password" required="required">
					</fieldset>

					<button type="submit" value="Login" class="btn btn-success">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
