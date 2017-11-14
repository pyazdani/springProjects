<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Answer</title>
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<div class="container">
    <h1><c:out value="${question.question}" /></h1>
    <div id="tag">
        <h2>Tags:</h2>
        <div id="tag-buttons">
            <c:forEach var="tag" items="${question.tags}"><button><c:out value="${tag.subject}" /></button></c:forEach>
        </div>
    </div>
    
    <p class='error'><form:errors path="answerModel.*"/></p>
    
    <div id="answer-container">
        <table id="answer-table">
            <thead>
                <tr>
                    <th>Answers</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ans" items="${question.answers}">
                    <tr>
                        <td><c:out value="${ans.answer}" /></td>
                    </tr>
                </c:forEach>			
            </tbody>
        </table>
        
        <form:form id="answer-form" action="/answers" method="POST" modelAttribute="answerModel">
            <form:input type="hidden" path="question" value="${question.id}"/>
            <p>
                <form:label path="answer">Answer:</form:label>
                <form:input type="text" path="answer" />			
            </p>
            <input type="submit" value="Answer it!"/>
        </form:form>
    </div>

</div>
</body>
</html>