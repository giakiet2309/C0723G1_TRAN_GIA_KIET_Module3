<%--
  Created by IntelliJ IDEA.
  User: Gia Kiet
  Date: 11/1/2023
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
    <label for="inputSearch">
        <h2>Search by Nation</h2>
        <input id="inputSearch" type="text">
        <button onclick="searchByNation()">submit</button>
    </label>
    <h2>
        <a href="/users?action=sort">Sort By User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
    function searchByNation(){
        let word = document.getElementById("inputSearch").value;
        window.location.href = "/users?action=search&word=" + word;
    }
</script>
</body>
</html>
