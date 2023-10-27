package com.example.servertime;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "ServerTimeServlet", urlPatterns = "/index")
public class ServerTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("");
        Date today = new Date();
        writer.println("<h1>" + today + "</h1>");
        writer.println("");
    }
}
