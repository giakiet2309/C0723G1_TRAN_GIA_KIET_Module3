<%--
  Created by IntelliJ IDEA.
  User: Gia Kiet
  Date: 11/8/2023
  Time: 7:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Gia Kiet
  Date: 11/6/2023
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <style>
        .title-h2 {
            position: relative;
            border-bottom: 1px solid #e0e0e0;
            margin-bottom: 15px;
            display: block;
            color: #212529;
            transition: 0.3s linear;
            font-size: 22px;
            font-family: 'Roboto', sans-serif;
            text-transform: uppercase;
            font-weight: 600;
        }


        .b1 {
            font-size: 12px;
            font-family: 'Roboto', sans-serif;
        }

        .left1 td {
            font-size: 14px;
            font-family: 'Roboto', sans-serif;
        }

        .btn-outline-secondary {
            font-size: 11px;
            padding: 3px 3px;
        }

        .btn-danger {
            font-size: 11px;
            padding: 3px 3px;
        }

    </style>
</head>


<body>
<nav class="navbar navbar-expand-lg bg-white px-5">
    <div class="container-fluid p-0">
        <div>
            <a class="navbar-brand" href="#">
                <img src="FBDBc3UVcAczrDS.jpeg" height="100" width="130"/></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
        <div style="margin: 0 auto">
            <div class="collapse navbar-collapse ">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li>
                        <a class="nav-link active" aria-current="page" href="#" style="color: black">Trang sức
                            bạc</a>
                    </li>
                    <li>
                        <a class="nav-link" href="#" style="color: black"> Trang sức vàng </a>
                    </li>
                    <li>
                        <a class="nav-link" href="#" style="color: black">Nhẫn cưới </a>
                    </li>
                    <li>
                        <a class="nav-link" href="#" style="color: black">Thành Viên </a>
                    </li>
                </ul>

            </div>

        </div>
        <div>

            <ul class="navbar-nav d-flex me-auto mb-2 mb-lg-0 right">
                <li>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Tìm kiếm" aria-label="Search">
                        <button class="btn " type="submit"><i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                    </form>
                </li>
                <li class="nav-item " style="margin-right: 2%">
                    <button class="btn"><i class="fa-solid fa-cart-shopping"></i></button>

                </li>
                <li class="nav-item " style="margin-right: 2%">
                    <button class="btn"><i class="fa-regular fa-user"></i></button>
            </ul>
        </div>
    </div>
</nav>

<div class="row m-4 ">
    <div class="col-md-2 col-sm-12 left1" style="background-color: #F5F4F4">
        <ul class="nav flex-column ">
            <li class="nav-item">
                <table>
                    <tr>
                        <td><img src="https://i.imgur.com/IERUO2e.png" height="15" width="14"/></td>
                        <td><a class="nav-link text-secondary" href="#">Thông tin tài khoản</a></td>
                    </tr>
                </table>
            </li>
            <li class="nav-item">
                <table>
                    <tr>
                        <td><img src="https://i.imgur.com/uvXA2cO.png" height="16" width="13"/></td>
                        <td><a class="nav-link text-secondary" href="#">Quản lý đơn hàng</a></td>
                    </tr>
                </table>
            </li>
            <li class="nav-item">
                <table>
                    <tr>
                        <td><img src="https://i.imgur.com/3tzjyCZ.png" height="16" width="13"/></td>
                        <td><a class="nav-link text-secondary" href="#">Giỏ hàng</a></td>
                    </tr>
                </table>
            </li>
        </ul>
    </div>

    <div class="col-md-6 " style="float: right">
        <h3 style="margin-bottom: 10px">Chỉnh sửa thông tin tài khoản </h3>
        <form action="/thong_tin_tai_khoan?action=edit" method="post" class="b1">
            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label" style="font-weight: bold">UserName</label>
                <div class="col-sm-8">
                    <input type="text" name="userName" id="userName" value="${userName}" placeholder="${userName}"  readonly>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label" style="font-weight: bold">Họ tên</label>
                <div class="col-sm-8">
                    <input type="text" name="name" id="name" value="${name}">
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label" style="font-weight: bold">Email</label>
                <div class="col-sm-8">
                    <input type="text" name="email" id="email" value="${email}">
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label" style="font-weight: bold">Số điện thoại</label>
                <div class="col-sm-8">
                    <input type="text" name="phone" id="phone" value="${phone}">
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label" style="font-weight: bold">Địa chỉ</label>
                <div class="col-sm-8">
                    <input type="text" name="address" id="address" value="${address}">
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label" style="font-weight: bold">Giới tính</label>
                <div class="col-sm-8">
                    <input type="text" name="gender" id="gender" value="${gender}">
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label" style="font-weight: bold">Xác Nhận mật khẩu</label>
                <div class="col-sm-8">
                    <input type="text" name="conFirmPassword" id="ConFirmPassword">
                </div>
            </div>
            <button type="submit" value="username" value="${userName}" class="btn btn-danger" style="width: 23%; text-transform: uppercase;font-weight: 600 ; font-size: 12px ;
            font-family: 'Roboto', sans-serif;">
                Edit
            </button>
            <button type="button"><a href="/thong_tin_tai_khoan">BACK</a></button>
        </form>
    </div>
    <div class="col-md-4" style="margin-bottom: 100px;    margin-top: 40px;
">
        <p>Trên trang này bạn có thể sửa đổi thông tin đăng nhập và các dữ liệu cá nhân được sử dụng trong để mua
            hàng.</p>
        <p>
            Để giữ cho tài khoản của bạn bảo mật an toàn chúng tôi khuyên bạn nên tránh việc tạo mật khẩu sử dụng:
        </p>
        <ul>
            <li>Từ điển trong ngôn ngữ bất kỳ.</li>
            <li>Từ đánh vần ngược, lỗi chính tả phổ biến, và chữ viết tắt.</li>
            <li>Trình tự hoặc các ký tự lặp đi lặp lại. Ví dụ: 12345678, 222222, abcdefg, hoặc các chữ cái liền kề
                trên
                bàn phím (qwerty).
            </li>
            <li>Thông tin cá nhân. Tên của bạn, sinh nhật, số giấy phép lái xe, số hộ chiếu, hoặc thông tin tương
                tự.
            </li>
        </ul>
    </div>
</div>
</body>
</html>

