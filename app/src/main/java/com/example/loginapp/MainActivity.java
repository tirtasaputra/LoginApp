package com.example.loginapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etFirstNumber, etSecondNumber;
    Button btnPlus, btnMinus, btnTimes, btnDivide;
    TextView tvResult, tvError;

    String stringNumber1, stringNumber2;

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
        tvError = findViewById(R.id.error_text_view);

        tvError.setText("");

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) {
                    tvError.setText("");
                    tvResult.setText(Operation("plus"));
                }else{
                    tvError.setText("Empty Fields");
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) {
                    tvError.setText("");
                    tvResult.setText(Operation("minus"));
                }else{
                    tvError.setText("Empty Fields");
                }
            }
        });

        btnTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) {
                    tvError.setText("");
                    tvResult.setText(Operation("times"));
                }else{
                    tvError.setText("Empty Fields");
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) {
                    tvError.setText("");
                    tvResult.setText(Operation("divide"));
                }else{
                    tvError.setText("Empty Fields");
                }
            }
        });

    }


    private String Operation(String operation){

        stringNumber1 = etFirstNumber.getText().toString();
        stringNumber2 = etSecondNumber.getText().toString();

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

    private boolean emptyValidation() {
        if (TextUtils.isEmpty(etFirstNumber.getText().toString()) || TextUtils.isEmpty(etSecondNumber.getText().toString())) {
            return true;
        }else {
            return false;
        }
    }

}
