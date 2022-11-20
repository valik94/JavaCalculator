package com.example.ywca_f22_week1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CalculatorClass {

//    public void push (String userValues) { //adds all users values in 1 list including operands and operators
//
//    }
    //String record for history user's actions
    public static String history = "";
    //ArrayList to store String history as elements of ArrayList
    public static ArrayList<String> historyArrayList = new ArrayList<>();
    //String for history list for advanced version
    public static String historyList = "";

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
