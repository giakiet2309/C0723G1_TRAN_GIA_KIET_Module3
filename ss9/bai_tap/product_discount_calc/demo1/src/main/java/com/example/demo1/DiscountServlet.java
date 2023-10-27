package com.example.demo1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String productDescription = request.getParameter("productDescription");
        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));

        // Tính toán chiết khấu và giá sau chiết khấu
        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;

        // Hiển thị kết quả
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Discount Result</title></head><body>");
        out.println("<h1>Discount Result</h1>");
        out.println("<p>Product Description: " + productDescription + "</p>");
        out.println("<p>List Price: $" + listPrice + "</p>");
        out.println("<p>Discount Percent: " + discountPercent + "%</p>");
        out.println("<p>Discount Amount: $" + discountAmount + "</p>");
        out.println("<p>Discount Price: $" + discountPrice + "</p>");
        out.println("</body></html>");
    }
}