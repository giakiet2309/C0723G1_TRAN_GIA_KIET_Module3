<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/9/2023
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="margin:20px 10px 50px">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Trang chủ</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Tìm kiếm
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Củ</a></li>
                        <li><a class="dropdown-item" href="#">Hoa</a></li>
                        <li><a class="dropdown-item" href="#">Rau</a></li>
                        <li><a class="dropdown-item" href="#">Quả</a></li>
                    </ul>
                </li>
            </ul>
            <form action="products" class="d-flex" role="search">
                <input type="text" name="action" hidden="hidden" value="search">
                <input name ="name-product" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Tìm</button>
            </form>
        </div>
    </div>
</nav>
<!--TABLE-->
<div class="container">
    <div class="row" style="margin-bottom: 20px">
        <a href="/products?action=create">
            <button class="btn btn-danger btn-sm">Thêm mới hàng hóa</button>
        </a>
        <table class="table table-hover table-responsive">
            <thead class="thead-inverse">
            <tr>
                <th>STT</th>
                <th>Mã hàng hóa</th>
                <th>Tên hàng hóa</th>
                <th>Đơn vị tính</th>
                <th>Giá</th>
                <th>Loại hàng hóa</th>
                <th>Ngày thu hoạch</th>
                <th colspan="3" style="text-align: center">Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="products" items="${ccc}" varStatus="count">
                <tr>
                    <td scope="row">${count.count}</td>
                    <td>${products.productCode}</td>
                    <td>${products.productName}</td>
                    <td>${products.unit}</td>
                    <td>${products.price}</td>
                    <td>${products.productType}</td>
                    <td>${products.harvestDate}</td>
                    <td style="text-align: center">
                        <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                            <button type="button" role="button" class="btn btn-success btn-sm">Chi tiết</button>
                            <button type="button" class="btn btn-warning btn-sm">Cập nhật</button>
                            <button type="button" class="btn btn-danger btn-sm"
                                    data-bs-toggle="modal" data-bs-target="#exampleModal"
                                    onclick="modalDelete('${products.productId}','${products.productName}')">Xóa
                            </button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row" style="text-align: center">
        <div>
            <a>Previous</a>
            <span>1</span> / <span>5</span>
            <a>Next</a>
        </div>
    </div>
</div>
<!--MODAL-->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/products">
                <input hidden="hidden" name="action" value="delete">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Xác nhận xóa</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input hidden="hidden" name="id" id="idDelete">
                    Bạn chắc chắn muốn xóa <span id="deleteName"></span> này không?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Không</button>
                    <button type="submit" class="btn btn-danger" id="active-delete" role="button">Có</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function modalDelete(id, name) {
        document.getElementById("deleteName").innerHTML = name;
        document.getElementById("idDelete").value = id;
    }
</script>
</body>
</html>
