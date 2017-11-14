<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>Dashboard</title>
</head>
<body style="text-align: center">
	<fieldset>
		<legend>Dashboard:</legend>
	<p>Name: <c:out value="${name}"/></p>
	<p>Location: <c:out value="${location}"/></p>
	<p>Language: <c:out value="${language}"/></p>
	<p>Comments: <c:out value="${comments}"/></p>
	</fieldset>
</body>
</html>