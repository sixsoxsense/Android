package com.example.project10_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class ResultActivity extends Activity {
    /*
    getIntArrayExtra 통해 메인한테 받을수있고
    이걸 이용해서 양방향 통신 가능 메인해서 받은값을 서브에서 처리후 메인으로 넘겨주는식으로 ㅇㅇ

    메인때처럼 똑같이 putextra 만들어준다음에
    setResult(RESULT_OK,???);
    finish();
     해주고 메인에선 RESULT_OK == -1 일시 인텐트 받고 값 출력하는걸 만들면됨

     @Override
        protected void onActivityResult(int requestCode,int resultCode, Intent data){
            if (resultCode==RESULT_OK){
                int hap = data.getIntExtra("hap",0);
                Toast.makeText(getApplicationContext(),hap,Toast.LENGTH_SHORT).show();           }
            }
        }
     */
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];


        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
