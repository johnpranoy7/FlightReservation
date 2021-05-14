<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Billing Page</h2>
	<pre>
<h4>Flight Details</h4>
FlightNum :<input type="text" value="${flight.flightnum}"
			name="flightnum" readonly>
Airliner :<input type="text" value="${flight.airliner}" name="airliner"
			readonly>
Departure City :<input type="text" value="${flight.departure_city}"
			name="departure_city" readonly>
Arrival City :<input type="text" value="${flight.arrival_city}"
			name="arrival_city" readonly>
Date of Travel :<input type="text" value="${flight.date_of_travel}"
			name="date_of_travel" readonly>

<h4>Passenger Details</h4>
<form action="completeReservation" method="get">
<input type="hidden" name="flightId" value="${flight.id}">
First Name :<input type="text" name="first_name">
Last Name :<input type="text" name="last_name">
Email :<input type="text" name="email">
Phone :<input type="text" name="phone">

<h4>Credit Card Details</h4>
Name on Card :<input type="text" name="name_on_card">
Card Numer :<input type="text" name="card_num">
Expiry Date :<input type="text" name="expiry_date">
CVV :<input type="text" name="cvv">
<input type="hidden" name="fl" value="${flight.id}" readonly">


<input type="submit">
</form>
</pre>
</body>
</html>