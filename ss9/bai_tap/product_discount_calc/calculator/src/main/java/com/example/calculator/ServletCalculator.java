package com.example.calculator;

import com.example.calculator.service.CalculatorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "ServletCalculator", value = "/calculate")
public class ServletCalculator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double firstOperator = Double.parseDouble(request.getParameter("first-operator"));
        double secondOperator = Double.parseDouble(request.getParameter("second-operator"));
        String operator = request.getParameter("operator");
        String[] strings = CalculatorService.calculator(firstOperator,secondOperator,operator);
        String result = strings[0];

        if (strings[1].equals("true")){
            request.setAttribute("result", "Không thể chia cho 0");
        }else {
            request.setAttribute("result", result);
        }
        request.setAttribute("operator", operator);
        request.setAttribute("first-operator", firstOperator);
        request.setAttribute("second-operator", secondOperator);
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }
}
