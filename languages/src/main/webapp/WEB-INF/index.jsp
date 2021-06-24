<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<title>All the Languages</title>
</head>
<body>
	<h3 class="jumbotron"> You're not the boss of me machine!</h3>
	
	<!-- <c:out value='${allLanguages}'>Check your controller for "allLanguages"</c:out> -->
	
	<table class="table table-dark">
        <thead>
          <tr>
            
            <th scope="col">Name</th>
            <th scope="col">Creator</th>
            <th scope="col">Current Version</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items='${ allLanguages }' var='lang'>
            <tr>  
                <td><a href="/languages/${lang.id }">${lang.name}</a></td>
                <td>${lang.creator}</td>
                <td>${lang.currentversion}</td>
                <td><a href="/languages/edit/${lang.id}">Edit</a> | <a href="/languages/delete/${lang.id }">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
      </table>
      
      <h1>Create a new Language</h1>
		<form:form action="/languages" method="post" modelAttribute="languages">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:textarea path="creator"/>
		    </p>
		    <p>
		        <form:label path="currentversion">Current Version</form:label>
		        <form:errors path="currentversion"/>
		        <form:input type="number" path="currentversion"/>
		    </p>
	  
	    <input type="submit" value="Submit"/>
		</form:form>    
      
	
</body>
</html>