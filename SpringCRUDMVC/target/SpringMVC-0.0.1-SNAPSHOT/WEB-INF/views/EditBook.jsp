<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/SpringMVC/editBookDetails" method="POST">
<center>
<table>
	
<tr><td>BookId:<input type="text" value="${book.bookid}" name="bookid" readonly></td></tr>
<tr><td>Book Name :<input type="text" value="${book.bookname}" name="bookname"></td></tr>
<tr><td>Book Pages:<input type="text" value="${book.numberofpages}" name="numberofpages"></td></tr>

<tr><td><input type="submit" value="Edit"></td></tr>
</table>
</center>
</form>
</body>
</html>