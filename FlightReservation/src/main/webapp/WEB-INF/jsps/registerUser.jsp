<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Register New User</p>
<pre>
<form action="saveUser" method="post">
Id: <input type="text" name="id">
First Name :<input type="text" name="first_name">
Last Name :<input type="text" name="last_name">
Email Id :<input type="text" name="email">
Password :<input type="text" name="password">
<input type="submit">
<br><a href="login">Login</a>
</form>
</pre>
</html>