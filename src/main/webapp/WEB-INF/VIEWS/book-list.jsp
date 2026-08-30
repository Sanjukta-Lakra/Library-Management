<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Books</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

</head>
<body>

<div class="container mt-5">

<h2>Library Books</h2>

<a href="${pageContext.request.contextPath}/books/add"
   class="btn btn-success">Add Book</a>

<a href="${pageContext.request.contextPath}/books/trash"
   class="btn btn-danger">Trash</a>

<br><br>

<table class="table table-bordered">

<tr>

<th>ID</th>

<th>Title</th>

<th>Author</th>

<th>Category</th>

<th>Price</th>

<th>Availability</th>

<th>Edit</th>

<th>Delete</th>

</tr>

<c:forEach items="${books}" var="b">

<tr>

<td>${b.id}</td>

<td>${b.title}</td>

<td>${b.author}</td>

<td>${b.category}</td>

<td>${b.price}</td>

<td>${b.available}</td>

<td>

<a href="${pageContext.request.contextPath}/books/edit/${b.id}"
   class="btn btn-warning">Edit</a>

</td>

<td>

<a href="${pageContext.request.contextPath}/books/delete/${b.id}"
   class="btn btn-danger">Delete</a>

</td>

</tr>

</c:forEach>

</table>

</div>

</body>
</html>