package com.example.ywca_f22_week1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CalculatorClass {

    //String record for history user's actions
//    public static String history = "";
    ArrayList<String> inputString = new ArrayList<String>();
    //ArrayList to store String history as elements of ArrayList
    public static ArrayList<String> historyArrayList = new ArrayList<>();
    //String for history list for advanced version
    public static String historyList = "";

    int index = 0;
    int result = 0;
    int solution = 0;
    int hisArrayIndex = 0;
    String expression;
    String expressionHist;



//    public static boolean isNumber(String s){
//        switch (s){
//            case "0":
//            case "1":
//            case "2":
//            case "3":
//            case "4":
//            case "5":
//            case "6":
//            case "7":
//            case "8":
//            case "9":
//                return true;
//        }
//        return false;
//    }
//
//    public static boolean isOperator(String s){
//        switch(s){
//            case "+":
//            case "-":
//            case "/":
//            case "*":
//                return true;
//        }
//        return false;
//    }


    public void push(String symbol) { //adds all users values in 1 list including operands and operators
//        if (symbol.equals("=")){
//            historyArrayList.clear();
//            history+=symbol;
//            parseStringToArrayList(history);
//        } else {
//            history += symbol;
//        }
        inputString.add(index, symbol);
        index++;
        expression = String.join("", inputString); // inputString contains: 1 + 2 - 1

    }

//    public static void parseStringToArrayList (String s){
//        String number = "";
//        String symbol;
//        for (int i = 0; i < s.length(); i++){
//            symbol = "" + s.charAt(i);
//            if (isNumber(symbol)){
//                number += symbol;
//            } else{
//                historyArrayList.add(number);
//                historyArrayList.add(symbol);
//                number = "";
//            }
//        }
//    }

//    public static void advancedCalculate(){
//        double result = Double.parseDouble(historyArrayList.get(0));
//        double operand;
//        String operator;
//        for (int i=0; i<historyArrayList.size()-2; i =i+2) {
//            operator = historyArrayList.get(i+1);
//            operand = Double.parseDouble(historyArrayList.get(i+2));
//            result = calculate(result, operand, operator);
//        }
//        history = history + result;
//    }


    public int calc(int n1, int n2, String op){ //parses the string list and calculates the result
//        int result = 0;
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
//        history = n1 + " " + op + " " + n2 + " = " + result;
        return result;
    }


//Function calculates the result of the expression
    public int calculate (){
        // 1 + 2 - 1, size()=5
        for (int i = 0; i<inputString.size(); i++){
            System.out.println("inputStirng is:"+ inputString);
            if ((inputString.get(i).equals("-")) ||
                    (inputString.get(i).equals("+")) ||
                    (inputString.get(i).equals("/")) ||
                    (inputString.get(i).equals("*")))
            {
                String op = inputString.get(i);
                int num1;
                //for iteration 1, num1 is first number in the expression entered,
                // for the rest of the iteration, num1 will is the result of previous calculations

                if (i==1){
                    num1 = Integer.parseInt(inputString.get(i - 1));
                }
                else { num1= solution; }
                int num2 = Integer.parseInt(inputString.get(i + 1));
                solution = calc(num1,num2,op);
                System.out.println("solution is:"+ solution);

            }
        }
        return solution;
    }

//function stores calculation history, called when calculator is in advanced mode (mode=1)
    public void storeHistory(){
    expressionHist = expression + "=" + solution; //storing string
        System.out.println("object solution is:"+ solution);
        historyArrayList.add(hisArrayIndex, expressionHist+"\n"); //arraylist of strings of history
        hisArrayIndex++;
    }

}