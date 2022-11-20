package com.example.ywca_f22_week1;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener
{
// MVC: M = model, V= layout, C= Activity.
    /// MVVM = model, view, view model

    CalculatorClass calculatorClass;
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
    Button add_but ;
    Button sub_but;
    Button times_but ;
    Button div_but;
    TextView result_text;
    Button advancedBut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_constraints);
        setContentView(R.layout.activity_main);
        //R.java is auto generated file, has all res ids (int)
        Log.d("Calculator App" , "Activity Created");

       // layout = findViewById(R.id.rootlayout);
        //layout.setBackgroundColor(getResources().getColor(R.color.DeepPink));

        // this line is not correct
        calculatorClass = new CalculatorClass();
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
        advancedBut = findViewById(R.id.toAdvancedButton);

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
        clear.setOnClickListener(this);
        advancedBut.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String symbol;
        switch (view.getId()){
            case R.id.clear:
                CalculatorClass.history =""; //assign history to blank string ""
                result_text.setText(CalculatorClass.history); // result_text displayed set to CalculatorClass.history which is ""
                CalculatorClass.historyArrayList.clear();// clear the historyArrayList of strings
                break;
            case R.id.toAdvancedButton:
                Intent firstIntent = new Intent(MainActivity.this, AdvancedVersion.this)

                if (!calculatorClass.history.isEmpty())
                    result_text.setText(calculatorClass.history);
                else
                    result_text.setText("No previous operator");
                break;
            default:
                String op =  ((Button)view).getText().toString();
                validate(op);
        };
    }




    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Calculator App" , "Activity Started ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Calculator App" , "Activity Resumed ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Calculator App" , "Activity Paused ");

    }

    @Override
    protected void onDestroy() {
        // save some values
        super.onDestroy();
    }


//    private void validate(String op){
//
//        if (!firstNumberText.getText().toString().isEmpty() &&
//                !secondNumberText.getText().toString().isEmpty()) {
//            int fn = Integer.parseInt(firstNumberText.getText().toString());
//            int sn = Integer.parseInt(secondNumberText.getText().toString());
//            int result = calculatorClass.calculate(fn, sn, op);
//            result_text.setText(calculatorClass.history);
//
//        else {
//            Toast.makeText(MainActivity.this,"You have to enter both numbers",Toast.LENGTH_LONG).show();
//        }
//
//    }


}