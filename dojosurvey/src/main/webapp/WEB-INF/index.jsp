<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>Home Page</title>
</head>
<body style="text-align: center">
	<form method="POST" action="/process">
		<label for="name">Name:</label>
		<input type="text" name="name" placeholder="name">
		<label for="location:">Dojo Location:</label>
		<input type="text" name="location" placeholder="location">
		<label for="language">Favorite Language:</label>
		<input type="text" name="language" placeholder="language">
		<label for="comments">Additional Comments:</label>
		<input type="text" name="comments" placeholder="comment">
		<input type="submit" value="Submit!">
		</form>
</body>
</html>