package com.example.vallespin_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button multiply;
    private Button add;
    private Button subtract;
    private Button divide;
    private Button equals;
    private Button period;

    private Button rightBracket;
    private Button leftBracket;
    private Button clear;
    private TextView input;
    private TextView output;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '×';
    private final char DIVISION = '÷';
    private final char EQU = '0';
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + "9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                output.setText(String.valueOf(val1) + "+");
                input.setText(null);
            }
        });
        period.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + ".");
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                output.setText(String.valueOf(val1) + "-");
                input.setText(null);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                output.setText(String.valueOf(val1) + "×");
                input.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                output.setText(String.valueOf(val1) + "÷");
                input.setText(null);
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;
                output.setText(output.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                input.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().length() > 0){
                    CharSequence name = input.getText().toString();
                    input.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    input.setText(null);
                    output.setText(null);
                }
            }
        });
    }

    private void setupUIViews(){
        clear = (Button)findViewById(R.id.button_clear);
        one = (Button)findViewById(R.id.button_1);
        two = (Button)findViewById(R.id.button_2);
        three = (Button)findViewById(R.id.button_3);
        four = (Button)findViewById(R.id.button_4);
        five = (Button)findViewById(R.id.button_5);
        six = (Button)findViewById(R.id.button_6);
        seven = (Button)findViewById(R.id.button_7);
        eight = (Button)findViewById(R.id.button_8);
        nine = (Button)findViewById(R.id.button_9);
        zero = (Button)findViewById(R.id.button_0);
        multiply = (Button)findViewById(R.id.button_multiplication);
        add = (Button)findViewById(R.id.button_addition);
        subtract = (Button)findViewById(R.id.button_subtraction);
        divide = (Button)findViewById(R.id.button_division);
        equals = (Button)findViewById(R.id.button_equals);
        period = (Button) findViewById(R.id.button_period);
        rightBracket = (Button)findViewById(R.id.button_rightBracket);
        input = (TextView)findViewById(R.id.input);
        output = (TextView)findViewById(R.id.output);

    }
    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(input.getText().toString());
            switch(ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(input.getText().toString());
        }
    }
}