<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Show Person</title>
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
	</head>
	<body>
		<main>
		    <nav>
			    <a href="/">Dashboard</a>
			</nav>
			<h1>${ person.firstName } ${ person.lastName }</h1>
			<div class="div">
				<div>
					<p><strong>License Number: </strong> ${ person.license.getNumber() }</p>
					<p><strong>Expiration Date: </strong> <fmt:formatDate value="${ person.license.getExpiration_date() }" type="date" pattern="dd-MMM-yyyy"/></p>
					
				</div>
			</div>
		</main>
	</body>
</html>