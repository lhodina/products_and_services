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
    <title>Category Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h1>${category.name }</h1>
   	<a href="/">Home</a>
   	<h2>Products in the Category:</h2>
   	<c:forEach var="product" items="${categoryProducts }">
   		<p>- ${product.name }</p>
   </c:forEach>
   
   <h2>All Products:</h2>
   <c:forEach var="product" items="${allProducts }">
   		<p>- ${product.name }</p>
   	</c:forEach>
   	
   	<h2>Add Product:</h2>
	<form action="/categories/${category.id}/products" method="post">
		<div class="form-group">
			<label for="productId">Name</label>
			<select name="productId" class="form-control">
			   <c:forEach var="product" items="${allProducts }">
			   		<c:if test = "${!categoryProductNames.contains(product.name) }">
			   			<option value="${product.id }">${product.name }</option>
			   		</c:if>
			   </c:forEach>
			</select>
		</div>
		<button>Submit</button>
	</form>
</body>
</html>

