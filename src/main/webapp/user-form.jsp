<%--
  Created by IntelliJ IDEA.
  User: Ariel Sandoval Toro
  Date: 03-07-2024
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>${user == null ? 'Add New User' : 'Edit User'}</title>
</head>
<body>
<h1>${user == null ? 'Add New User' : 'Edit User'}</h1>
<form action="user?action=${user == null ? 'insert' : 'update'}" method="post">
    <input type="hidden" name="id" value="${user.userId}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${user.name}" required><br>
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" value="${user.lastName}" required><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${user.email}" required><br>
    <label for="age">Age:</label>
    <input type="number" id="age" name="age" value="${user.age}" required><br>
    <input type="submit" value="${user == null ? 'Add' : 'Update'}">
</form>
<a href="user">Back to User List</a>
</body>
</html>
