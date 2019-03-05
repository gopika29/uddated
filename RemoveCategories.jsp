<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Category Id</th>
			<th>Category Name</th>
			<th>Type</th>
		</tr>
		<c:forEach items="${CategoryList}" var="category">
			<tr>
				<td>${category.categoryId}</td>
				<td>${category.categoryName}</td>
				<td>${category.type}</td>
				<td><a href="remove.obj?categoryId=${category.categoryId}">Remove</a></td>
				<td><a href="goToAddProductPage.obj?categoryId=${category.categoryId}">AddProduct</a></td>
			</tr>
		</c:forEach>
	</table>
	${message}
</body>
</html>