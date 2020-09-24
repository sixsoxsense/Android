package com.example.subject_1;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button ChgImg;
    ImageView image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChgImg = findViewById(R.id.ChgImg);
        image1 = findViewById(R.id.image1);

        ChgImg.setOnClickListener(new View.OnClickListener() {
            int i = 0;

            @Override
            public void onClick(View view) {

                if (i == 0) {
                    image1.setImageResource(R.drawable.rabbit);
                    i = 1;
                } else if (i == 1) {
                    image1.setImageResource(R.drawable.cat);
                    i = 2;
                } else {
                    image1.setImageResource(R.drawable.dog);
                    i = 0;
                }
            }
        });

    }
}
