<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Languages</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="lang" varStatus="loop" items="${languages}">
					<tr>
						<td>
							<a href="/languages/${loop.index}"><c:out value="${lang.name}"/></a>
						</td>
						<td><c:out value="${lang.creator}"/></td>
						<td><c:out value="${lang.version}"/></td>
						<td>
							<a href="/languages/edit/${loop.index}">Edit</a> | 
							<a href="/languages/delete/${loop.index}">Delete</a>				
						</td>
					</tr>	
				</c:forEach>							
			</tbody>
		</table>
		
		<p class='error'><form:errors path="language.*"/></p>
		
		<div class="form-container">
			<form:form action="/languages" method="POST" modelAttribute="language">
				<p>
					<form:label path="name" for="name">Name</form:label>
					<form:input path="name" class="input-size float" type="text" name="name"/>
				</p>
				<p>
					<form:label path="creator" for="creator">Creator</form:label>
					<form:input path="creator" class="input-size float" type="text" name="creator"/>
				</p>
				<p>
					<form:label path="version" for="version">Version</form:label>
					<form:input path="version" class="input-size float" type="text" name="version"/>
				</p>
				<input class="float" type="submit" value="Submit" />						
			</form:form>
		</div>
				
	</div>
</body>
</html>