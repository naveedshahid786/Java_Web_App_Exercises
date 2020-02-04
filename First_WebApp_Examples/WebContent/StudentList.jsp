<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students List</title>
</head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
<body>
	<h3>Student Lists</h3>
	
	
	<br>
	
	<table style="width: 100%">
		<thead>
			<tr>
				<th>id</th>
				<th>firstname</th>
				<th>lastname</th>
				<th>streetAddress</th>
				<th>postcode</th>
				<th>postoffice</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ studentList}" var="studentObject">
				<tr>
					<td><c:out value="${studentObject.id }" /></td>
					<td><c:out value="${studentObject.firstname }" /></td>
					<td><c:out value="${studentObject.lastname }" /></td>
					<td><c:out value="${studentObject.streetaddress }" /></td>
					<td><c:out value="${studentObject.postcode }" /></td>
					<td><c:out value="${studentObject.postoffice }" /></td>
					
					<td><form action="DeleteStudentServlet" method="post">
					<a href='DeleteStudentServlet?studentId=<c:out value="${studentObject.id }"/>'onClick="return confirm('Do you want to Delete the student?')">Delete</a></td>
					</form>	
					</td>				
				</tr>
			</c:forEach>
		</tbody>
	</table>
	

</body>
</html>