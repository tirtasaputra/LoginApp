package com.example.loginapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etFirstNumber, etSecondNumber;
    Button btnPlus, btnMinus, btnTimes, btnDivide;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstNumber = findViewById(R.id.input1_edit_text);
        etSecondNumber = findViewById(R.id.input2_edit_text);
        btnPlus = findViewById(R.id.plus_button);
        btnMinus = findViewById(R.id.minus_button);
        btnTimes = findViewById(R.id.times_button);
        btnDivide = findViewById(R.id.divide_button);
        tvResult = findViewById(R.id.result_text_view);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(Operation("plus"));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(Operation("minus"));
            }
        });

        btnTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(Operation("times"));
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(Operation("divide"));
            }
        });

    }

    private String Operation(String operation){
        String stringNumber1 = etFirstNumber.getText().toString();
        String stringNumber2 = etSecondNumber.getText().toString();

        double doubleNumber1 = Double.parseDouble(stringNumber1);
        double doubleNumber2 = Double.parseDouble(stringNumber2);

        if (operation.equals("plus")){
            double doubleResult = doubleNumber1 + doubleNumber2;
            String stringResult =  String.valueOf(doubleResult);
            return stringResult;
        } else if (operation.equals("minus")){
            double doubleResult = doubleNumber1 - doubleNumber2;
            String stringResult =  String.valueOf(doubleResult);
            return stringResult;
        } else if (operation.equals("times")){
            double doubleResult = doubleNumber1 * doubleNumber2;
            String stringResult =  String.valueOf(doubleResult);
            return stringResult;
        } else if (operation.equals("divide")){
            double doubleResult = doubleNumber1 / doubleNumber2;
            String stringResult =  String.valueOf(doubleResult);
            return stringResult;
        } else {
            return "";
        }

    }
}
