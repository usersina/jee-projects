<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Home</title>
  </head>
  <body>
    <%
      session = request.getSession();
      String nom = (String) session.getAttribute("nom");
      if (nom==null){
    %>
    <form action="./connection" method="GET">
      login : <input type="text" name="login" /><br />
      password : <input type="password" name="mdp" /><br />
      <input type="submit" value="se connecter" />
    </form>
    <%
      } else {
        request.getRequestDispatcher("./menu.jsp").forward(request, response);
      }
    %>
  </body>
</html>
