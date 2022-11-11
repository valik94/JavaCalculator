package com.example.ywca_f22_week1;

import androidx.appcompat.app.AppCompatActivity;

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
    EditText firstNumberText;
    EditText secondNumberText ;
    Button add_but ;
    Button sub_but;
    Button times_but ;
    Button div_but;
    Button clear;
    TextView result_text ;
    Button history;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraints);
        //R.java is auto generated file, has all res ids (int)
        Log.d("Calculator App" , "Activity Created");

       // layout = findViewById(R.id.rootlayout);
        //layout.setBackgroundColor(getResources().getColor(R.color.DeepPink));
        // this line is not correct
        calculatorClass = new CalculatorClass();

         firstNumberText = (EditText)findViewById(R.id.firstnum);
         secondNumberText = (EditText)findViewById(R.id.secondnum);
         clear = findViewById(R.id.clear);
         add_but = findViewById(R.id.addbut);
         sub_but = findViewById(R.id.subbut);
         times_but = findViewById(R.id.timesbut);
         div_but = findViewById(R.id.divbut);
         history = findViewById(R.id.showpreviousoperator);
         result_text = findViewById(R.id.resulttext);
         add_but.setOnClickListener(this);
         sub_but.setOnClickListener(this);
         times_but.setOnClickListener(this);
         div_but.setOnClickListener(this);
        history.setOnClickListener(this);
        clear.setOnClickListener(this);
         //        add_but.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               String op =  ((Button)view).getText().toString();
//               validate(op);
//            }
//        });
//
//        sub_but.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String op =  ((Button)view).getText().toString();
//                validate(op);
//            }
//        });
//
//        times_but.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String op =  ((Button)view).getText().toString();
//                validate(op);
//            }
//        });
//
//        div_but.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String op =  ((Button)view).getText().toString();
//                validate(op);
//            }
//        });
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


    private void validate(String op){
        if (!firstNumberText.getText().toString().isEmpty() &&
                !secondNumberText.getText().toString().isEmpty()) {
            int fn = Integer.parseInt(firstNumberText.getText().toString());
            int sn = Integer.parseInt(secondNumberText.getText().toString());
            int result = calculatorClass.calculate(fn, sn, op);
            result_text.setText(calculatorClass.history);

        }else {
            Toast.makeText(MainActivity.this,"You have to enter both numbers",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.clear:
                firstNumberText.setText("");
                secondNumberText.setText("");
                result_text.setText("");
                break;
            case R.id.showpreviousoperator:
              //  layout.setBackgroundColor(getResources().getColor(R.color.white));

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
}