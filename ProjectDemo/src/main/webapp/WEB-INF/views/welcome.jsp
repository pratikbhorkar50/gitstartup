<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome <%=session.getAttribute("username") %></h1>
<form action="addproduct" method="POST">
<table border="4">
	
	<tr><td>Product id</td>
			<td>Category Id</td>
			<td>Product Name</td>
			<td>Product Price</td>
	</tr>
	
<c:forEach var="p" items="${plist}">
	
	<tr><td>${p.productid}</td>
	<td>${p.categoryid}</td>
	<td>${p.productname}</td>
	<td>${p.productprice}</td></tr>
</c:forEach>

</table>
<input type="submit" name="btn" value="AddProduct">
</form>
</body>
</html>