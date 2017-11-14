<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Page</title>
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<div class="container">
    <h1><c:out value="${dojo.name}" /> Location Ninjas:</h1>
    <c:forEach items="${ninjas}" var="ninja">
    <table>
        <tr>
            <td>First Name:</td>
            <td><c:out value="${ninja.firstName}" /></td>
        </tr>
        <tr>
            <td>State: </td>
            <td><c:out value="${ninja.lastName}" /></td>
        </tr>
        <tr>
            <tr>
                <td>Age: </td>
                <td><c:out value="${ninja.age}" /></td>
            </tr>
    </table>
</div>
</body>
</html>