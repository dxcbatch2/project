<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>
	<form action="SaveServlet" method="post">	
		<table>
			<tr>
				<td>Student-ID</td>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<td>Student-Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Student-Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Student-Phoneno</td>
				<td><input type="text" name="phoneno"></td>
			</tr>
			
		</table>
		<input type ="submit" value="Submit">
</form>
</body>
</html>