<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>User List</title>
</head>
<body>
<h1>User List</h1>
<a href="user?action=new">Add New User</a><br>
<a href="user?action=viewAllMostOne">All Most One</a>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Age</th>
    <th>Active</th>
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
      <td>${user.isActive == 1 ? 'Active' : 'Inactive'}</td>
      <td>
        <a href="user?action=view&id=${user.userId}">View</a>
        <a href="user?action=edit&id=${user.userId}">Edit</a>
        <a href="${ user.isActive == 1 ? 'user?action=deactive&id='.concat(user.userId): 'user?action=active&id='.concat(user.userId)}" onclick="return confirm('Are you sure?')">${user.isActive == 1 ? 'Deactivate' : 'Activate'}</a>
        <a href="user?action=delete&id=${user.userId}" onclick="return confirm('Are you sure?')">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>