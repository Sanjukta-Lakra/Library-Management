<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
rel="stylesheet">

</head>
<body>

<div class="container mt-5">

<h2>Edit Book</h2>

<form:form action="${pageContext.request.contextPath}/books/update"
           modelAttribute="book"
           method="post">

<form:hidden path="id"/>

Title

<form:input path="title" class="form-control"/>

<form:errors path="title" cssClass="text-danger"/>

<br>

Author

<form:input path="author" class="form-control"/>

<form:errors path="author" cssClass="text-danger"/>

<br>

Category

<form:input path="category" class="form-control"/>

<form:errors path="category" cssClass="text-danger"/>

<br>

Price

<form:input path="price" class="form-control"/>

<form:errors path="price" cssClass="text-danger"/>

<br>

Availability

<form:radiobutton path="available" value="true"/>Available

<form:radiobutton path="available" value="false"/>Not Available

<br><br>

<input type="submit" value="Update Book" class="btn btn-primary">

<a href="${pageContext.request.contextPath}/books"
   class="btn btn-secondary">Back</a>

</form:form>

</div>

</body>
</html>