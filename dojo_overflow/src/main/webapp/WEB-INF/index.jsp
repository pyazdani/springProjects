<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Questions Dashboard</title>
		<link rel="stylesheet" href="/css/style.css" />
	</head>
	<body>
		<div class="container">
			<h1>Questions Dashboard</h1>
			
			<table>
				<thead>
					<tr>
						<th>Question</th>
						<th>Tags</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${questions}" var="q">
						<tr>
							<td><a href="/questions/${q.id}"><c:out value="${q.question}"/></a></td>
							<td><c:forEach var="tag" items="${q.tags}" varStatus="loop">
								<c:out value="${tag.subject}" /><c:if test="${!loop.last}">,</c:if>
							</c:forEach></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p class="answer"><a href="/questions/new">NEW QUESTION</a></a></p>
		</div>
	</body>
	</html>