<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>Assignment Page</title>
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<div class="wrapper">
	<div class="nav bar">
		<h1>Fortran! Assignment</h1>
		<span class="menu">
			<a href="/m/38/0553/0733">Setup</a>
			<a href="/m/38/0483/0345">Forms</a>
			<a href="/m/38/0553/0342">Cards</a>
			<a href="/m/38/0553/0348">Advanced</a>
			<a href="/m/38/0483/2342">Binary</a>		
		</span>
	</div>
	
	<input type="checkbox" />
	<label for="checkbox">Assignment Completed</label>
	
	<div class="box">
	<c:out value="${goal}" />
	</div>
</div>
</body>
</html>
