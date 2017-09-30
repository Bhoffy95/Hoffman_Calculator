package com.example.ben.hoffman_calculator;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    public float prev;
    public String current = null;
    public String operator = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        final TextView textView = (TextView) findViewById(R.id.display);


        final Button buttonClear = (Button) findViewById(R.id.clear_button);
        buttonClear.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){

                textView.setText("0");
                prev = 0;
               current = null;
               operator = null;
           }
        });

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v1){
                if(current == null){
                    current = "1";
                }
                else {
                    current = current + "1";
                }

                textView.setText(current);

            }
        });

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v2){
                if(current == null){
                    current = "2";
                }
                else {
                    current = current + "2";
                }

                textView.setText(current);

            }
        });

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v3){
                if(current == null){
                    current = "3";
                }
                else {
                    current = current + "3";
                }

                textView.setText(current);

            }
        });

        final Button buttonPlus = (Button) findViewById(R.id.add_button);
        buttonPlus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(current == null){
                    operator = "+";
                }
                else if(operator == null){
                    operator = "+";
                    prev = Float.parseFloat(current);
                    current = null;
                }
                else{
                    textView.setText(calculate(operator));
                    operator = "+";
                }

            }
        });

        final Button buttonMinus = (Button) findViewById(R.id.sub_button);
        buttonMinus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(current == null){
                    operator = "-";
                }
               else if(operator == null){
                    operator = "-";
                    prev = Integer.parseInt(current);
                    current = null;

                }
                else{
                    textView.setText(calculate(operator));
                    operator = "-";
                }

            }
        });

        final Button buttonDivide = (Button) findViewById(R.id.divide_button);
        buttonDivide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(current == null) {
                    operator = "/";
                }
                else if(operator == null){
                    operator = "/";
                    prev = Float.parseFloat(current);
                    current = null;
                }
                else{
                    textView.setText(calculate(operator));
                    operator = "/";
                }

            }
        });

        final Button buttonMultiply = (Button) findViewById(R.id.multiply_button);
        buttonMultiply.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(current == null) {
                    operator = "x";
                }
                else if(operator == null) {
                    operator = "x";
                    prev = Float.parseFloat(current);
                    current = null;
                }
                else{
                    textView.setText(calculate(operator));
                    operator = "x";
                }

            }
        });

        final Button buttonEquals = (Button) findViewById(R.id.equals_button);
        buttonEquals.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operator == null){
                    //do nothing
                }
                else if(current == null){
                    //do nothing
                }
                else{
                    textView.setText(calculate(operator));
                    operator = null;
                }

            }
        });

    }


    public String calculate(String operation){
        String returnString = null;
        float returnVal = 0;

        if(operation == "+"){
            returnVal = prev + Float.parseFloat(current);
            returnString = String.valueOf(returnVal);
            current = null;
        }
        else if(operation == "-"){
            returnVal = prev - Float.parseFloat(current);
            returnString = String.valueOf(returnVal);
            current = null;
        }
        else if(operation == "x"){
            returnVal = prev * Float.parseFloat(current);
            returnString = String.valueOf(returnVal);
            current = null;
        }
        else if(operation == "/"){
            returnVal = prev / Float.parseFloat(current);
            returnString = String.valueOf(returnVal);
            current = null;
        }
        else{
            returnString = null;
        }
        prev = returnVal;
        return returnString;
    }


}
