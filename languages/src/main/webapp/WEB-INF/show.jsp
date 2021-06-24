<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<title>Language Detail</title>
</head>
<body>

	<h1 class="jumbotron"> Language Details </h1>
        
        <h1>Show Info about:<c:out value="${langy.name}"/></h1>
			<p>Description: <c:out value="${langy.creator}"/></p>
			<p>Language: <c:out value="${langy.currentversion}"/></p>
			
        
</body>
</html>