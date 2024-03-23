<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chambres</title>
</head>
<body>
    <h1>List of Chambres</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Etat</th>
        </tr>
        <c:forEach var="chambre" items="${chambres}">
            <tr>
                <td>${chambre.id}</td>
                <td>${chambre.nom}</td>
                <td>${chambre.etat}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>