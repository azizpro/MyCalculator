package com.techleadbd.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private enum OPERATOR{
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    TextView txtCalculation;
    TextView txtResult;
    LinearLayout linearLayout3;

    //Instance Variable
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private Long calculationResult;
    private boolean isWhite = true;

    private String calculationString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentNumber = "";
        calculationResult = 0L;
        calculationString = "";


        txtCalculation = findViewById(R.id.txtCalculation);
        txtResult = findViewById(R.id.txtResult);
        linearLayout3 = findViewById(R.id.linearLayout3);

        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);

        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);

        findViewById(R.id.btnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSubtract).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDivide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

                case R.id.btnEqual:
                    operatorIsTapped(OPERATOR.EQUAL);
                break;

                case R.id.btn7:
                numberIsTapped(7);
                break;

                case R.id.btn8:
                numberIsTapped(8);
                break;

                case R.id.btn9:
                    numberIsTapped(9);
                break;

                case R.id.btn4:
                    numberIsTapped(4);
                break;

                case R.id.btn5:
                    numberIsTapped(5);
                break;

                case R.id.btn6:
                    numberIsTapped(6);
                break;

                case R.id.btn1:
                    numberIsTapped(1);
                break;

                case R.id.btn2:
                    numberIsTapped(2);
                break;

                case R.id.btn3:
                    numberIsTapped(3);
                break;

                  case R.id.btn0:
                    numberIsTapped(0);
                    changeBackgroundColor();
                    break;

                case R.id.btnPlus:
                    operatorIsTapped(OPERATOR.PLUS);
                    calculationString = calculationString + " + ";
                break;

                case R.id.btnSubtract:
                    operatorIsTapped(OPERATOR.SUBTRACT);
                    calculationString = calculationString + " - ";
                    break;

                case R.id.btnMultiply:
                    operatorIsTapped(OPERATOR.MULTIPLY);
                    calculationString = calculationString + " * ";
                break;

                case R.id.btnDivide:
                    operatorIsTapped(OPERATOR.DIVIDE);
                    calculationString = calculationString + " / ";
                break;

                case R.id.btnClear:
                    clearTapped();
                break;
        }

        txtCalculation.setText(calculationString);
    }
    private void numberIsTapped(int tappedNumber){
        currentNumber = currentNumber + tappedNumber;
        txtResult.setText(currentNumber);
        calculationString = currentNumber;
        txtCalculation.setText(calculationString);
    }

    private void operatorIsTapped(OPERATOR tappedOperator){
        if (currentOperator != null) {

            if (!currentNumber.equals("")) {

                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {

                    case PLUS:
                        calculationResult = Long.parseLong(stringNumberAtLeft) +
                                Long.parseLong(stringNumberAtRight);
                        break;

                    case SUBTRACT:
                        calculationResult = Long.parseLong(stringNumberAtLeft) -
                                Long.parseLong(stringNumberAtRight);
                        break;

                    case MULTIPLY:
                        calculationResult = Long.parseLong(stringNumberAtLeft) *
                                Long.parseLong(stringNumberAtRight);
                        break;

                    case DIVIDE:
                        calculationResult = Long.parseLong(stringNumberAtLeft) /
                                Long.parseLong(stringNumberAtRight);
                        break;
                }

                stringNumberAtLeft = String.valueOf(calculationResult);
                txtResult.setText(stringNumberAtLeft);
                calculationString = stringNumberAtLeft;
            }
        }
        else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;
    }
    private void clearTapped(){

        stringNumberAtLeft = "";
        stringNumberAtRight = "";
        calculationResult = 0L;
        currentNumber = "";
        currentOperator = null;
        txtResult.setText("0");
        calculationString = "0";
        txtCalculation.setText("0");
    }

    private void changeBackgroundColor(){
        if (isWhite)
            linearLayout3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        else
            linearLayout3.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));
        isWhite = !isWhite;
    }
}
