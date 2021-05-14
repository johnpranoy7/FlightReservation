<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<pre>
<h2>Login</h2>
<form action="validatelogin" method="post">
Email Id :<input type="text" name="email" maxlength="20">
Password :<input type="text" name="password" maxlength="20">
<input type="submit">
</form>
</pre>
${msg}
<br>
<a href="showreg">Register User</a>
</body>
</html>