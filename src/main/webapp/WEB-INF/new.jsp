<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Person</title>
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
	</head>
	<body>
		<main>
			<nav>
			    <a href="/">Dashboard</a>
			</nav>
			<h1>New Person</h1>
			<div>
				<form:form action="/persons/new" method="POST" modelAttribute="person">
			    <p>
			        <form:label path="firstName">First Name</form:label>
			        <form:errors path="firstName"/>
			        <form:input class="form-control" path="firstName"/>
			    </p>
			    <p>
			         <form:label path="lastName">Last Name</form:label>
			        <form:errors path="lastName"/>
			        <form:input class="form-control" path="lastName"/>
			    </p>  
			    <input class="bSummit" type="submit" value="Create"/>
			</form:form>    
			</div>
		</main>
	
	</body>
</html>