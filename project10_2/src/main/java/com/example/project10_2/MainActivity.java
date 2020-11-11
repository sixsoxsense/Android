package com.example.project10_2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    /*
    인텐트 : 4대 컴포넌트 (활동,서비스,브로드캐스트리시버,콘텐트프로바이더) 가 상호간 데이터 주고받게 해주는 메시지 객체
    명시적, 암시적 인텐트 구분

    명시적: 다른 액티비티 이름 명확히 지정시 사용
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int voteCount[] = new int[9];
        for (int i = 0; i < 9; i++) {
            voteCount[i] = 0;
        }
        ImageView image[] = new ImageView[9];
        Integer imageID[] = {R.id.image1, R.id.image2, R.id.image3, R.id.image4, R.id.image5, R.id.image6, R.id.image7, R.id.image8, R.id.image9};
        final String imgName[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < image.length; i++) {
            final int index;
            index = i;
            image[index] = findViewById(imageID[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index] + "의 투표수" + voteCount[index], Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnFinish = findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });
    }
}


