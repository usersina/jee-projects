<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Products from Bean</title>
  </head>
  <body>
    <p>The list of products</p>

    <c:forEach var="product" items="${requestScope.products}">
      <p>${product.name} - ${product.quantity}</p>
    </c:forEach>
  </body>
</html>
