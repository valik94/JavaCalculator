package com.example.ywca_f22_week1;

public class CalculatorClass {

    String history = "";
    public int calculate(int n1, int n2, String op){
        int result = 0;
        switch (op){
            case "+":
                result = n1 + n2;
                break;

            case "-":
                result = n1 - n2;
                break;

            case "*":
                result = n1 * n2;
                break;

            case "/":
                result = n1 / n2;
                break;
        };
        history = n1 + " " + op + " " + n2 + " = " + result;
        return result;
    }

}
