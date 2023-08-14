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
    <title>Product Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
   <h1>${product.name }</h1>
   <a href="/">Home</a>
   <h2>Product Categories:</h2>
   <c:forEach var="category" items="${productCategories }">
   		<p>- ${category.name }</p>
   </c:forEach>
   
   <h2>All Categories:</h2>
   <c:forEach var="category" items="${allCategories }">
   		<p>- ${category.name }</p>
   	</c:forEach>

   <h2>Add Category:</h2>
	<form action="/products/${product.id}/categories" method="post">
		<div class="form-group">
			<label for="categoryId">Name</label>
			<select name="categoryId" class="form-control">
			   <c:forEach var="category" items="${allCategories }">
			   		<c:if test = "${!productCategoryNames.contains(category.name) }">
			   			<option value="${category.id }">${category.name }</option>
			   		</c:if>
			   		
			   </c:forEach>
			</select>
		</div>
		<button>Submit</button>
	</form>
</body>
</html>

