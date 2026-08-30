<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trash</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

</head>
<body>

<div class="container mt-5">

<h2>Deleted Books</h2>

<a href="${pageContext.request.contextPath}/books"
   class="btn btn-primary">Back</a>

<br><br>

<table class="table table-bordered">

<tr>

<th>ID</th>

<th>Title</th>

<th>Author</th>

<th>Restore</th>

<th>Permanent Delete</th>

</tr>

<c:forEach items="${books}" var="b">

<tr>

<td>${b.id}</td>

<td>${b.title}</td>

<td>${b.author}</td>

<td>

<a href="${pageContext.request.contextPath}/books/restore/${b.id}"
   class="btn btn-success">Restore</a>

</td>

<td>

<a href="${pageContext.request.contextPath}/books/permanent-delete/${b.id}"
   class="btn btn-danger">Delete</a>

</td>

</tr>

</c:forEach>

</table>

</div>

</body>
</html>