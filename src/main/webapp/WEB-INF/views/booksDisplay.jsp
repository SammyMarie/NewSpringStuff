<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>

	<div class="container">

		<h2>Books List</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
				    <th>#</th>
					<th>Name</th>
					<th>Title</th>
					<th>ISBN Number</th>
				</tr>
				<c:forEach items="${books}" var="book" varStatus = "status">
					<tr>
					    <td>${status.index + 1}</td>
						<td>${book.authorName}</td>
						<td>${book.bookTitle}</td>
						<td><a href="http://www.amazon.co.uk/dp/${book.isbnNumber}" target = "_blank">${book.isbnNumber}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>