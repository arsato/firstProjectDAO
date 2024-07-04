<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>User List</title>
</head>
<body>
<h1>User List</h1>
<a href="user?action=new">Add New User</a>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Age</th>
    <th>Actions</th>
  </tr>
  <!-- Iterar sobre la lista de usuarios y mostrar sus datos en la tabla -->
  <c:forEach var="user" items="${listUsers}">
    <tr>
      <td>${user.userId}</td>
      <td>${user.name}</td>
      <td>${user.lastName}</td>
      <td>${user.email}</td>
      <td>${user.age}</td>
      <td>
        <a href="user?action=view&id=${user.userId}">View</a>
        <a href="user?action=edit&id=${user.userId}">Edit</a>
        <a href="user?action=delete&id=${user.userId}" onclick="return confirm('Are you sure?')">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>