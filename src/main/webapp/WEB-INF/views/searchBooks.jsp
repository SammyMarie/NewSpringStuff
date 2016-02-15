<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookFinder Application</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>

	<div class="container">

		<h2>Book Search</h2>
        <div class="row">
	    <div class="span12">
		    <form id = "custom-search-form" class="form-search form-horizontal pull-right"  action = "booksDisplay">
		        <div class="input-append span12">
			        <input type="text" class="search-query" placeholder="Search" name = "author" path = "authorName">
			        <button type="submit" class="btn"><i class="icon-search"></i></button>
		        </div>
		    </form>
	    </div>
        </div>

        <p>
        	This is the place to do you search, what you need to do is type in an author's name in the search box then press the return(enter) key on your keyboard.
        	This will then trigger your search and display the result of your search. Try using an author name such as Iain Banks and press enter.
        	The cool thing is, you can when you get back result view the books from that author on Amazon.co.uk using the ISBN number.
        </p>
	</div>
</body>
</html>