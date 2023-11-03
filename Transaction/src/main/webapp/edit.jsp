<%--
  Created by IntelliJ IDEA.
  User: Gia Kiet
  Date: 11/3/2023
  Time: 7:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h2>Edit User Profile</h2>
<form action="/users?action=edit" method="post">
    <input name="id" type="hidden" value="${id}">
    <input name="name" type="text" value="${name}">
    <input name="age" type="number" value="${age}">
    <input name="nation" type="text" value="${nation}">
    <button type="submit">Submit</button>
</form>
</body>
</html>
