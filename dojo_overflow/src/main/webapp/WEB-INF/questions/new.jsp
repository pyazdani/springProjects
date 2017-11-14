<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Question</title>
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<div class="container">
    <h1>What is your question?</h1>
    
    <p class='error'><form:errors path="question"/></p>
    
    <form:form action="/questions/new" method="post" modelAttribute="Question">
   <p> <form:label path="question">Question:
        <form:errors path="question"></form:errors>
        <form:input path="question"></form:input>
    </form:label>
    </p>
    <p>	
    <form:label path="tags">Tags:
        <form:errors path="tags"></form:errors>
        <form:input path="tags"></form:input>
    </form:label>	
    </p>	

    <input type="submit" value="Create Category" />
    </form:form>
</div>
</body>
</html>