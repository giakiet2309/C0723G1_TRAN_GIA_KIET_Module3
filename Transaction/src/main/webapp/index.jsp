<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <style>
        table{
            border-collapse: collapse;
            width: 100%;
        }
        td, th{
            border: black 1px solid;
        }

    </style>
</head>
<body>
<h1>Quản lý User</h1>
<span id="main">${data}</span>
<button onclick="add()">add</button>
</body>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        if (document.getElementById("main").textContent == ""){displayAll()};
    });
    function displayAll(){
        window.location.href = "/users?action=displayAll";
    }
    function edit(id){
        window.location.href = "/users?action=edit&id=" + id;
    }
    function deleteById(id){
        window.location.href = "/users?action=delete&id=" + id;
    }
    function add(){
        window.location.href = "/users?action=add"
    }

</script>

</html>