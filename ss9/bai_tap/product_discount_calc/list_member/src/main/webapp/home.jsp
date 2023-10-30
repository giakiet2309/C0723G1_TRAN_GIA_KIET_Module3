
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>displayCustomer</title>
    <style>
        td{
            border: black 1px solid;
            margin: 10%;
        }
        td img{
            height: 150px;
        }
        table{
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    </thead>
    <c:forEach var="customer" items="${list}">
        <tr>
            <td>${customer.getName()}</td>
            <td>${customer.getBirthday()}</td>
            <td>${customer.getAdress()}</td>
            <td><img src="${customer.getLinkPicture()}"></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>