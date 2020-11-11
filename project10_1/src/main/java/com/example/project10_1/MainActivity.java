package com.example.project10_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
/*
안드로이드 4대 컴포넌트
액티비티 : 화면구성
서비스 : 액티비티 상관없이 백그라운드에서 동작하는 컴포넌트
브로드캐스트 리시버 : sd카드 탈부탁 이런거방송보냄
콘텐트 프로바이더 :
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
