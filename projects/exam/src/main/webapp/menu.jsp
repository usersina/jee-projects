<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Menu - Admin</title>
		<script>
			function handleAdminTraitement() {
				window.location.href = './admin-trait';
			}

			function handleLogout() {
				window.location.href = './login';
			}
		</script>
	</head>
	<body>
		<h1>Welcome to the admins menu</h1>
		<button onclick="handleAdminTraitement()">Afficher les chambres</button>
		<button onclick="handleLogout()">Logout</button>
	</body>
</html>
