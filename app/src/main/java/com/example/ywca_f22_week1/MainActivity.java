package com.example.ywca_f22_week1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
// MVC: M = model, V= layout, C= Activity.
    /// MVVM = model, view, view model
    CalculatorClass obj = new CalculatorClass();
    int mode = 0;

//    CalculatorClass calculatorClass;
    Button num0;
    Button num1;
    Button num2;
    Button num3;
    Button num4;
    Button num5;
    Button num6;
    Button num7;
    Button num8;
    Button num9;

    Button clear;
    Button equals;
    Button add_but;
    Button sub_but;
    Button times_but;
    Button div_but;
    TextView result_text;
    Button advancedBut;
    TextView history_tv;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_constraints);
        setContentView(R.layout.activity_main);
        //R.java is auto generated file, has all res ids (int)
        Log.d("Calculator App", "Activity Created");


        // this line is not correct but ok for now
//        calculatorClass = new CalculatorClass();
        //connecting activity_main.xml button ids to objects here
        result_text = findViewById(R.id.resulttext);
        num0 = findViewById(R.id.zero);
        num1 = findViewById(R.id.one);
        num2 = findViewById(R.id.two);
        num3 = findViewById(R.id.three);
        num4 = findViewById(R.id.four);
        num5 = findViewById(R.id.five);
        num6 = findViewById(R.id.six);
        num7 = findViewById(R.id.seven);
        num8 = findViewById(R.id.eight);
        num9 = findViewById(R.id.nine);

        clear = findViewById(R.id.clear_but);
        equals = findViewById(R.id.equals);
        add_but = findViewById(R.id.add_but);
        sub_but = findViewById(R.id.sub_but);
        times_but = findViewById(R.id.multiply_but);
        div_but = findViewById(R.id.div_but);
        advancedBut = findViewById(R.id.toAdvancedButton); //history
        history_tv = findViewById(R.id.history_tv); //calcHistory

        //setOnclickListener to activate action later such as onClick
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

        add_but.setOnClickListener(this);
        sub_but.setOnClickListener(this);
        times_but.setOnClickListener(this);
        div_but.setOnClickListener(this);
        equals.setOnClickListener(this);


        //History button
        advancedBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //advanced mode
                if (mode ==0){
                    mode =1;
                    System.out.println("AFTER ENTERING ADVACNED MODE"+obj.inputString);
                    history_tv.setVisibility(View.VISIBLE);
                    advancedBut.setText("STANDARD - NO HISTORY");
                    history_tv.setText("");
                }
                else {
                    //standard mode no history
                    mode =0;
                    history_tv.setVisibility(View.INVISIBLE);
                    advancedBut.setText("ADVANCED - WITH HISTORY");
                    obj.historyArrayList.clear();
                    obj.inputString.clear();

                    obj.hisArrayIndex =0;
                    obj.expression ="";
                    obj.expressionHist = "";
                }
            }

        });


    // clear button
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_text.setText("0");
                obj.inputString.clear();
                obj.index = 0;
                obj.expression = "";
            }

        });
    }



    @Override
    public void onClick(View view) {
        Button button = (Button) view; // ?
        String buttonText = button.getText().toString(); //storing the text of the button

        if (view == equals) {
            if (mode == 0) {
                int result = obj.calculate(); //returns solution integer
                result_text.setText(obj.expression + "=" + obj.solution); //display exp = solution
            }

            //ADVANCED mode
            if (mode == 1) {
                obj.storeHistory();
                history_tv.setText(obj.historyArrayList.toString() //obj.historyArrayList.toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", ""));

            }
        }else { //get the text of the button pressed
            String data = ((Button) view).getText().toString();
            obj.push(data);
            result_text.setText(obj.expression);
        }
    }



//        String symbol;
//        switch (view.getId()) {
//            case R.id.clear:
//                CalculatorClass.history = ""; //assign history to blank string ""
//                result_text.setText(CalculatorClass.history); // result_text displayed set to CalculatorClass.history which is ""
//                CalculatorClass.historyArrayList.clear();// clear the historyArrayList of strings
//                break;
//            case R.id.toAdvancedButton: //if AdvancedButton is clicked case
//                Intent firstIntent = new Intent(MainActivity.this, AdvancedVersion.class); //Display intent/switch screen to MainActivity.this, pulling from AdvancedVersion.class logic
//                startActivity(firstIntent); //goes into AdvanceVersion
//                break;
//            default: //all other buttons for calculation (without clear button and advnacedbutton
//                //get user input and validate it
//                symbol = ((Button) view).getText().toString(); //assign symbol to be Buttonclicked as string
//                if (CalculatorClass.isNumber(symbol)) { //of symbol (button clicked) is a number
//                    CalculatorClass.push(symbol); //add the number to the CalculatorClass ArrayList of strings and to history (String)
//                    result_text.setText(CalculatorClass.history); //display the history Strings in result_text (calc display)
//                } else {
//                    if (CalculatorClass.history.isEmpty()) { //if history strings is empty (no numbers to calculate)
//                        Toast.makeText(MainActivity.this, "First input has to be a number", Toast.LENGTH_SHORT).show(); //throw error/Toast and show to user
//                    } else {
//                        String previousSymbol = String.valueOf(calculatorClass.history.charAt(CalculatorClass.history.length() - 1)); //create previousSymbol which is String valueOf history String
//                        if (CalculatorClass.isOperator(previousSymbol)) { //check is previousSymbol entered as operator again?
//                            Toast.makeText(MainActivity.this, "You cannot use two operators in a row, enter a number", Toast.LENGTH_SHORT).show(); // throw error if two operators are back to back
//                        } else {
//                            CalculatorClass.push(symbol); //add the entered button (symbol) to historyListArray of strings and update history string
//                            if (symbol.equals("=")) { //if button entered is '='
//                                if (CalculatorClass.historyArrayList.size() < 3) { //check if historyArrayList has less than 3 elements (num1, operator1, num2) required for a valid compute/calculation
//                                    Toast.makeText(MainActivity.this, "This cannot be calculated, please enter proper values and operators to calculate.", Toast.LENGTH_SHORT).show(); //if true, throw error
//                                    CalculatorClass.historyArrayList.clear(); //clear historyArrayList of previously pushed elements into the array
//                                    calculatorClass.history = CalculatorClass.history.substring(0, CalculatorClass.history.length() - 1); //assign history string to
//                                    //System.out.print("calculatorClass.history"+calculatorClass.history);
//                                } else {
//                                    CalculatorClass.advancedCalculate();
//                                    result_text.setText(CalculatorClass.history);
//                                    CalculatorClass.history = "";
//                                }
//                            } else {
//                                result_text.setText(CalculatorClass.history);
//                            }
//                        }
//                    }
//                }


//        };
//    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Calculator App", "Activity Started ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Calculator App", "Activity Resumed ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Calculator App", "Activity Paused ");

    }

    @Override
    protected void onDestroy() {
        // save some values
        super.onDestroy();
    }
}

