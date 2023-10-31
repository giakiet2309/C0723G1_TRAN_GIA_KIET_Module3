<%--
  Created by IntelliJ IDEA.
  User: Gia Kiet
  Date: 11/1/2023
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/products?action=add" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td>Manufacturer</td>
            <td><input type="text" name="manufacturer"></td>
        </tr>
        <tr>
            <td><button type="submit">Add</button></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>
