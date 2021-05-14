<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Available Flights</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Flightnum</th>
			<th>Airliner</th>
			<th>Departure_city</th>
			<th>Arrival_city</th>
			<th>Date_of_travel</th>
			<th>Estimated_timetravel</th>
		</tr>
		<c:forEach items="${flights}" var="fl">
			<tr>
				<td>${fl.id}</td>
				<td>${fl.flightnum}</td>
				<td>${fl.airliner}</td>
				<td>${fl.departure_city}</td>
				<td>${fl.arrival_city}</td>
				<td>${fl.date_of_travel}</td>
				<td>${fl.estimated_timetravel}</td>
				<td><a href="selectflight?id=${fl.id}">Select</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>