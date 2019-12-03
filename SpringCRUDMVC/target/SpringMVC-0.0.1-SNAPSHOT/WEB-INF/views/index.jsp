<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="validate" method="POST">
<table>
<tr><td>Username : <input type="text" name="uname"></td></tr>
<tr><td>Password : <input type="text" name="upass"></td></tr>
<tr><td><input type="submit" name="btn" value="login"></td>
<td><a href="forgotpassword">Forgot Password</a></td>
</tr>
<tr><td><a href="registration">New Registration?</a>
</form>
</body>
</html>