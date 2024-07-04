<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>User List</title>
</head>
<body>
<h1>User List</h1>
<a href="users?action=new">Add New User</a>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Actions</th>
  </tr>
  <!-- Iterar sobre la lista de usuarios y mostrar sus datos en la tabla -->
  <c:forEach var="user" items="${listUsers}">
    <tr>
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.email}</td>
      <td>
        <a href="users?action=view&id=${user.id}">View</a>
        <a href="users?action=edit&id=${user.id}">Edit</a>
        <a href="users?action=delete&id=${user.id}" onclick="return confirm('Are you sure?')">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>