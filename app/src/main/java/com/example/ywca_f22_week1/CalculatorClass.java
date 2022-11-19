package com.example.ywca_f22_week1;

public class CalculatorClass {

    public void push (String userValues){ //adds al users values in 1 list including operands and operators

    }

    String history = "";
    public int calculate(int n1, int n2, String op){ //parses the string list and calculates the result
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
