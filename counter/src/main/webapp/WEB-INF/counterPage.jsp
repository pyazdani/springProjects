<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>CounterPage</title>
</head>
<body>
	<p>You have visited <a href="/">http://localhost:8080</a> <c:out value="${count}"></c:out> times</p>
	<p><a href="/">Test another visit?</a></p>
	<p><a href="/reset">Reset Visits</a></p>
</body>
</html>