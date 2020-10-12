package com.example.project5_2;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText Edit1, Edit2;
    Button BtnAdd, BtnSub, BtnMul, BtnDiv;
    TextView TextResult;
    String num1, num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3,
            R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("테이블레이아웃 계산기");
        Edit1 = findViewById(R.id.Edit1);
        Edit2 = findViewById(R.id.Edit2);
        BtnAdd = findViewById(R.id.BtnAdd);
        BtnSub = findViewById(R.id.BtnSub);
        BtnMul = (Button) findViewById(R.id.BtnMul);
        BtnDiv = findViewById(R.id.BtnDiv);
        TextResult = findViewById(R.id.TextResult);
        for (i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = findViewById(numBtnIDs[i]);
        }
        for (i = 0; i < numBtnIDs.length; i++) {
            final int index;
            index = 1;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Edit1.isFocused()) {
                        num1 = Edit1.getText().toString() + numButtons[index].getText().toString();
                        Edit1.setText(num1);
                    } else if (Edit2.isFocused()) {
                        num2 = Edit2.getText().toString() + numButtons[index].getText().toString();
                        Edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 에딭텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        BtnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                TextResult.setText("계산결과: " + result.toString());
                return false;
            }
        });
        BtnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                TextResult.setText("계산결과: " + result.toString());
                return false;
            }
        });
        BtnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                TextResult.setText("계산결과: " + result.toString());
                return false;
            }
        });
        BtnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                TextResult.setText("계산결과: " + result.toString());
                return false;
            }
        });

    }
}
