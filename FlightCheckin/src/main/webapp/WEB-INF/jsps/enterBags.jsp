<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Enter your number of bags</h2>
${reservation}
<pre>
<h2>Flight Details</h2>
Flight Num : ${reservation.flight.flightnum}
Flight Airliner : ${reservation.flight.flightnum}
Departure City : ${reservation.flight.departure_city}
Arrival City : ${reservation.flight.arrival_city}
Date of Travel : ${reservation.flight.date_of_travel}
Travel Time : ${reservation.flight.estimated_traveltime}
<br>
<h2>Passenger Details</h2>
Passenger First Name : ${reservation.passenger.first_name}
Passenger Last Name : ${reservation.passenger.last_name}
Passenger Email : ${reservation.passenger.email}
Passenger Phone : ${reservation.passenger.phone}
<form action="confirmation">
No of Bags : <input type="text" name="no_of_bags">
<input type="hidden" name="id" value="${reservation.id}">
<button type="submit">Submit</button>
</form>
</pre>
</body>
</html>