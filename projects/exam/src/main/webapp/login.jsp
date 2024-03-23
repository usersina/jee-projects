<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${empty sessionScope.CIN}">
                <form action="login" method="post">
                    <input type="text" id="cin" name="cin" placeholder="CIN" required>
                    <input type="password" id="password" name="password" placeholder="Password" required>
                    <input type="submit" value="Login">
                </form>
            </c:when>
            <c:when test="${sessionScope.role eq 'student'}">
                <jsp:forward page="/etudiant-trait" />
            </c:when>
            <c:otherwise>
                <jsp:forward page="/menu.jsp" />
            </c:otherwise>
        </c:choose>
    </body>
</html>
