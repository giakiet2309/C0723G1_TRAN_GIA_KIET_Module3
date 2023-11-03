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
    <title>add user</title>
</head>
<body>
<h2>New User</h2>
<form action="/users?action=add" method="post">
    <h3>Tên</h3>
    <input type="text" name="name">
    <h3>Tuổi</h3>
    <input type="number" name="age">
    <h3>Quốc tịch</h3>
    <input type="text" name="nation">
    <button type="submit">submit</button>
</form>
</body>
</html>
