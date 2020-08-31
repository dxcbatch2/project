<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Page</title>
</head>
<body>
	<form action = "RegistrationServlet" method="post">
		<table>
			<tr>
				<td>First name</td>
				<td><input type="text" name="first_name"></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><input type="text" name="last_name"></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input type ="submit" value="submit">
	</form>	
</body>
</html>