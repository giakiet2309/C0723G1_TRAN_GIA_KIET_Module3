package com.example.calculator.service;

public class CalculatorService {
    public static String[] calculator(double firstOperator, double secondOperator, String operator){
        Boolean error = false;
        double  result = 0;
        switch (operator){
            case "+":
                result = firstOperator + secondOperator;
                break;
            case "-":
                result = firstOperator - secondOperator;
                break;
            case "x":
                result= firstOperator * secondOperator;
                break;
            case "/":
                if (secondOperator == 0){
                    error = true;
                } else {
                    result = firstOperator / secondOperator;
                }
        }
        return new String[]{result + "", error + ""};
    }
}
