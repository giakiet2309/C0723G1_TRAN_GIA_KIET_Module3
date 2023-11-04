<%--
  Created by IntelliJ IDEA.
  User: Gia Kiet
  Date: 11/3/2023
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/quan_ly_chat_lieu?action=edit" method="post">
    <table>
        <tr>
            <td>Mã loại chất liệu</td>
            <td><input type="text" name="nameId" value="${QuanLyChatLieu.getNameId()}" readonly></td>
        <tr>
            <td>Tên loại chất liệu</td>
            <td><input type="text" name="nameType" id="name" value="${QuanLyChatLieu.getNameType()}" ></td>
        </tr>
        <tr>
            <td>Mô tả</td>
            <td><input type="text" name="describe" id="describe" value="${QuanLyChatLieu.getDescribe()}" style="height: 100px ; width: 300px" ></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Edit product"></td>
        </tr>
        </tr>
    </table>

</form>
</body>
</html>
