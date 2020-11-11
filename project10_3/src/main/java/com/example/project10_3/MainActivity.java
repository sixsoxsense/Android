package com.example.project10_3;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button btnDial, btnFinish;
    /*
    액티비티 생명주기
    생명부터 소멸까지 주기를 뜻함
    안드로이드는 화면이작아 동시에 여러화면이 나올수없음
    하나의 화면만 나오고 나머지는 비활성화 상태로 남게됨

    create -> start -> resume -> 메인액티비티 실행 -> pause -> stop -> 마칠경우 stop 까지
             (start) <- restart <- 다른액티비티 사용 or 종료 <- (stop) (다른엑티비티 요청시)

    그리고 예기치못한 오류 발생시 원인 파악용으로 로그를 쓰는데 안드로이드에는 로그캣이란게 있음 메소드 개발자가 적절히 사용하기
    디버깅(android.util.log.d):디버깅용
    에러(android.util.log.e):가장 심각한 오류 발생시
    인포메이션(android.util.log.i):정보남기기용
    벌보스(android.util.log.v):상세기록용
    워닝(android.util.log.w):경고수준용
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.util.Log.i("액티비티테스트", "oncreate()");

        btnDial = findViewById(R.id.btnDial);
        btnFinish = findViewById(R.id.btnFinish);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:010-7585-1072");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        android.util.Log.i("액티비티 테스트", "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i("액티비티 테스트", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.i("액티비티 테스트", "onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        android.util.Log.i("액티비티 테스트", "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.i("액티비티 테스트", "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        android.util.Log.i("액티비티 테스트", "onRestart()");
    }
}
