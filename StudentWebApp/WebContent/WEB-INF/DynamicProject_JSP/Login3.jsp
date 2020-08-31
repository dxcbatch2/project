<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Successful</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<% String username = request.getParameter("username"); %>
				<a>Welcome <%out.println(username); %>User!! You have logged in</a>
			</td>
		</tr>
		<tr>
			<td>
				<a href="scernario.jsp"><b>Student-Details</b></a>
			</td>
			<td>	
				<a href = "login2.jsp"><b>logout</b></a>
			</td>
		</tr>
	</table>
</body>
</html>