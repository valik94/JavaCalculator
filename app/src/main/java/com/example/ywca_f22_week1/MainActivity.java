package com.example.ywca_f22_week1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //R.java is auto generated file, has all res ids (int)
        Log.d("Calculator App" , "Activity Created");

        EditText firstNumberText = (EditText)findViewById(R.id.firstnum);
        EditText secondNumberText = (EditText)findViewById(R.id.secondnum);

        Button add_but = findViewById(R.id.addbut);
        Button sub_but = findViewById(R.id.subbut);
        Button times_but = findViewById(R.id.timesbut);
        Button div_but = findViewById(R.id.divbut);
        TextView result_text = findViewById(R.id.resulttext);

        add_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Calculator App" , "Add button clicked");
                if (!firstNumberText.getText().toString().isEmpty() &&
                        !secondNumberText.getText().toString().isEmpty()) {
                    int fn = Integer.parseInt(firstNumberText.getText().toString());
                    int sn = Integer.parseInt(secondNumberText.getText().toString());
                    int result = fn + sn;
                    firstNumberText.setText("");
                    secondNumberText.setText("");
                    result_text.setText(fn + " + " + sn + " = " + result + "");
                }else {
                    Toast.makeText(MainActivity.this,"You have to enter both numbers",Toast.LENGTH_LONG).show();
                }
            }
        });

        sub_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Calculator App" , "Sub button clicked");
                if (!firstNumberText.getText().toString().isEmpty() &&
                        !secondNumberText.getText().toString().isEmpty()) {
                    int fn = Integer.parseInt(firstNumberText.getText().toString());
                    int sn = Integer.parseInt(secondNumberText.getText().toString());
                    int result = fn - sn;
                    firstNumberText.setText("");
                    secondNumberText.setText("");
                    result_text.setText(fn + " - " + sn + " = " + result + "");
                }else {
                    Toast.makeText(MainActivity.this,"You have to enter both numbers",Toast.LENGTH_LONG).show();
                }
            }
        });

        times_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Calculator App" , "Times button clicked");
                if (!firstNumberText.getText().toString().isEmpty() &&
                        !secondNumberText.getText().toString().isEmpty()) {
                    int fn = Integer.parseInt(firstNumberText.getText().toString());
                    int sn = Integer.parseInt(secondNumberText.getText().toString());
                    int result = fn * sn;
                    result_text.setText(fn + " * " + sn + " = " + result + "");
                    firstNumberText.setText("");
                    secondNumberText.setText("");
                }else {
                    Toast.makeText(MainActivity.this,"You have to enter both numbers",Toast.LENGTH_LONG).show();
                }
            }
        });

        div_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Calculator App" , "Div button clicked");
                if (!firstNumberText.getText().toString().isEmpty() &&
                        !secondNumberText.getText().toString().isEmpty()) {
                    int fn = Integer.parseInt(firstNumberText.getText().toString());
                    int sn = Integer.parseInt(secondNumberText.getText().toString());
                    int result = fn / sn;
                    result_text.setText(fn + " / " + sn + " = " + result + "");
                    firstNumberText.setText("");
                    secondNumberText.setText("");
                }else {
                    Toast.makeText(MainActivity.this,"You have to enter both numbers",Toast.LENGTH_LONG).show();
                }
            }
        });
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

//    public void add_clicked(View view) {
//    }
}