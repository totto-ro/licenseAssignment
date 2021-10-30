<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>People and Licenses</title>
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
	</head>
	<body>
		<main>
			<h1>Information</h1>
			<table>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>License #</th>
						<th>State</th>
						<th>Expiration Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="element" items="${personList}">
					<tr>
						<td><a href="${ element.id }">${element.firstName}</a></td>
						<td>${element.lastName}</td>
						<td>${element.license.number}</td>
						<td>${element.license.state}</td>
						<td><fmt:formatDate value="${ element.license.expiration_date }" type="date" pattern="dd-MMM-yyyy"/></td>				
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="div">
				<a class="links" href="/persons/new">New Person </a>
				<a class="links" href="/licenses/new"> New License</a>
			</div>
		</main>
	</body>
</html>