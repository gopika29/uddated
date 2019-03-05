<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form:form modelAttribute="product" method="post" action="addProduct.obj">
<table>
<tr><td>Product Name</td>
<td><form:input path="product_name"/></td></tr>
<tr><td>description</td>
<td><form:input path="description"/></td></tr>
<tr><td>price</td>
<td><form:input path="price"/></td></tr>
<tr><td>sold_quantity</td>
<td><form:input path="sold_quantity" readonly="true"/></td></tr>
<tr><td>avail_stock</td>
<td><form:input path="avail_stock"/></td></tr>
<tr><td>discount</td>
<td><form:input path="discount"/></td></tr>
<tr><td>no_of_views</td>
<td><form:input path="no_of_views" readonly="true"/></td></tr>
<td><input type="submit" value="Add Category"></td></tr>
</table>
</form:form>
${message}
</div>
</body>
</html>