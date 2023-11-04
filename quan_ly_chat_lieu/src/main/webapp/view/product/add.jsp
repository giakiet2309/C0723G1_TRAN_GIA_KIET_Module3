<%--
  Created by IntelliJ IDEA.
  User: Gia Kiet
  Date: 11/3/2023
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/quan_ly_chat_lieu?action=add" method="post">
    <table>
        <tr>
            <td>Mã loại chất liệu</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td> Tên loại chất liệu</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td> Mô tả</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>
                <button type="submit">Add</button>
            </td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>
