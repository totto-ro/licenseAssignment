<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New License</title>
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
	</head>
	<body>
		<main>
			<nav>
			    <a href="/">Dashboard</a>
			</nav>
			<h1>New License</h1>
			<div>
				<form:form action="/licenses/new" method="POST" modelAttribute="license">
			    <p>
			    	<form:label path="person">Person</form:label>
			        <form:errors path="person"/>
			        <form:select path="person">
			        <c:forEach items="${ person }" var="element">
			        	<form:option value="${ element.getId() }">${ element.getFirstName() } ${ element.getLastName() }</form:option>
			        </c:forEach>
			        </form:select>
			    </p>
			    <p>
				    <form:label path="state">State</form:label>
			        <form:errors path="state"/>
			        <form:input path="state"/>
			    </p>
			    <p>
				    <form:label path="expiration_date">Expiration Date</form:label>
			        <form:errors path="expiration_date"/>
			        <form:input type="date" path="expiration_date"/>
			    </p>   
			    <input class="bSummit" type="submit" value="Add License"/>
			</form:form>    
			</div>
		</main>
	
	</body>
</html>