<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creating New Student</title>
</head>
<body>
	<h2>Inserting data for new Students</h2>
	<form action="StudentInsertServlet" method="GET">
		<label>Id: </label><input type="text" name="id"><br>
		<br> <label>First Name: </label><input type="text" name="fname"><br>
		<br> <label>Last Name: </label><input type="text" name="lname"><br>
		<br> <label>StreetAddress: </label><input type="text"
			name="address"><br>
		<br> <label>Postal Code: </label><input type="text"
			name="postcode"><br>
		<br> <label>Post Office: </label><input type="text"
			name="postoffice"><br>
		<br> <input type="submit" value="Add">
	</form>
	
	
	
	<!-- Please see the message in console, -->



</body>
</html>
