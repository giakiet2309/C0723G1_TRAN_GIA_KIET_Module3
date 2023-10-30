package com.example.list_member.controller;

import com.example.list_member.model.Customer;
import com.example.list_member.service.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletDisplayCustomer", value = "/home")
public class ServletDisplayCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Customer> list = CustomerService.displayCustomer();
        request.setAttribute("list", list);
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }
}
