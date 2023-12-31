<%--
  Created by IntelliJ IDEA.
  User: Gia Kiet
  Date: 11/1/2023
  Time: 1:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<table class="table">
  <thead class="thead-dark">
  <tr>
    <th scope="col">ID</th>
    <th scope="col">Name</th>
    <th scope="col">Price</th>
    <th scope="col">Description</th>
    <th scope="col">Manufacture</th>
    <th scope="col">Edit</th>
    <th scope="col">Delete</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${products}" var="product">
  <tr>
    <th scope="row">${product.id}</th>
    <th>${product.name}</th>
    <th>${product.price}</th>
    <th>${product.description}</th>
    <th>${product.manufacturer}</th>
    <th><a href="/products?action=edit&id=${product.getId()}">
      <button>Edit</button>
    </a></th>
    <td><a href="/products?action=delete&id=${product.getId()}">
      <button>Delete</button>
    </a></td>
  </tr>
  </tbody>
  </c:forEach>
</table>
<button type="button"><a href="/products">Back</a></button>
</body>
</html>
