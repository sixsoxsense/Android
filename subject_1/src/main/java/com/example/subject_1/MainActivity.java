package com.example.subject_1;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button ChgImg;
    ImageView image1;
    RadioGroup rgpClass,rgpPhone;
    RadioButton radioButtonA,radioButtonB,radioButtonAnd,radioButtonIp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("자기 소개 앱");

        ChgImg = findViewById(R.id.ChgImg);
        image1 = findViewById(R.id.image1);


        rgpClass= findViewById(R.id.rgpClass);
        rgpPhone= findViewById(R.id.rgpPhone);

        radioButtonA=findViewById(R.id.radioButtonA);
        radioButtonB=findViewById(R.id.radioButtonB);
        radioButtonAnd=findViewById(R.id.radioButtonAnd);
        radioButtonIp=findViewById(R.id.radioButtonIp);

        radioButtonB.setChecked(true);
        radioButtonAnd.setChecked(true);

        image1.setImageResource(R.drawable.one);

        ChgImg.setOnClickListener(new View.OnClickListener() {
            int i = 0;

            @Override
            public void onClick(View view) {

                if (i == 0) {
                    image1.setImageResource(R.drawable.two);
                    i = 1;
                } else if (i == 1) {
                    image1.setImageResource(R.drawable.three);
                    i = 2;
                } else {
                    image1.setImageResource(R.drawable.one);
                    i = 0;
                }
            }
        });

    }
}
