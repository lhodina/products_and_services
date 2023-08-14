<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
   <h1>Home Page</h1>
   <a href="/products/new">New Product</a>
   <a href="/categories/new">New Category</a>
   <h2>Products</h2>
   <c:forEach var="product" items="${allProducts }">
   		<p>- <a href="/products/${product.id}">${product.name }</a></p>
   </c:forEach>
   <h2>Categories</h2>
   <c:forEach var="category" items="${allCategories }">
   		<p>- <a href="/categories/${category.id}">${category.name }</a></p>
   </c:forEach>
</body>
</html>

