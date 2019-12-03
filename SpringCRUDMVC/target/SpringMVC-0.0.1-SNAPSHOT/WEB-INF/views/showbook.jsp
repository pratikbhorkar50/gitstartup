<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<c:forEach var="p" items="${list}">
<tr>
<td>${p.bookid}</td>
<td>${p.bookname}</td>
<td>${p.numberofpages}</td>
<td><a href="delete/${p.bookid}">delete/</a>
<a href="edit/${p.bookid}">edit</a>
</td>
</tr>
</c:forEach>
</table>
<a href="addProduct">Add Product</a>
</body>
</html>