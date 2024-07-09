<%--
  Created by IntelliJ IDEA.
  User: Ariel Sandoval Toro
  Date: 03-07-2024
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Details</title>
</head>
<body>
<h1>User Details</h1>
<!-- Mostrar los detalles del usuario -->
<p>ID: ${user.userId}</p>
<p>Name: ${user.name}</p>
<p>Last Name: ${user.lastName}</p>
<p>Email: ${user.email}</p>
<p>Age: ${user.age}</p>
<p>Status: ${user.isActive == 1 ? 'Active' : 'Inactive'}</p>
<a href="user">Back to User List</a>
</body>
</html>