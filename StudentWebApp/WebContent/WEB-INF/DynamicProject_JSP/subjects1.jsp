<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<title>Student Subjects</title>
</head>
<body>
<form action="EditServlet2" method="post">
	<table>
			<tr>
				<td>Student-ID</td>
				<td><input type="number" name="sid"></td>
			</tr>
			<tr>
				<td>Exam-ID</td>
				<td><input type="number" name="eid"></td>
			</tr>
			<tr>
				<td>Subject-1</td>
				<td><input type="number" name="sub1"></td>
			</tr>
			<tr>
				<td>Subject-2</td>
				<td><input type="number" name="sub2"></td>
			</tr>
			<tr>
				<td>Subject-3</td>
				<td><input type="number" name="sub3"></td>
			</tr>
	</table>
	<input type ="submit" value="Operation">
</form>
</body>
</html>