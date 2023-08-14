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
    <title>New Product</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h1>New Product</h1>
  	<a href="/">Home</a>

	<form:form action="/products" method="post" modelAttribute="product">
		<div class="form-group">
			<form:label path="name">Name</form:label>
			<form:input path="name" class="form-control" />
		</div>
		<div class="form-group">
			<form:label path="description">Description</form:label>
			<form:input path="description" class="form-control" />
		</div>
		<div class="form-group">
			<form:label path="price">Price</form:label>
			<form:input type="float" path="price" class="form-control" />
		</div>
		<button>Submit</button>
	</form:form>
   
</body>
</html>