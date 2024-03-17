<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Home</title>
  </head>
  <body>
    <c:choose>
      <c:when test="${empty sessionScope.nom}">
        <form action="./connection" method="GET">
          Login : <input type="text" name="login" /><br />
          Password : <input type="password" name="mdp" /><br />
          <input type="submit" value="se connecter" />
        </form>
      </c:when>
      <c:otherwise>
        <jsp:forward page="./menu.jsp" />
      </c:otherwise>
    </c:choose>
  </body>
</html>
