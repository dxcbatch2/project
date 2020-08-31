<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam Details</title>
</head>
<body>
<form action="SaveServlet1" method="post">
	<table>
			<tr>
				<td>Exam-ID</td>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<td>Exam-Name</td>
				<td><input type="text" name="exam_name"></td>
			</tr>
	</table>
	<input type ="submit" value="Submit">
</form>
</body>
</html>