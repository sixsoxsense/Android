package com.example.assignment_3;

import android.app.TabActivity;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
    Button ChgImg, StopImg;
    RadioGroup rgpClass, rgpPhone;
    RadioButton radioButtonA, radioButtonB, radioButtonAnd, radioButtonIp;
    TabHost tabHost;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = getTabHost();

        TabHost.TabSpec tabSpecName = tabHost.newTabSpec("tabName").setIndicator("이름/학번");
        tabSpecName.setContent(R.id.tabName);
        tabHost.addTab(tabSpecName);

        TabHost.TabSpec tabSpecAsk = tabHost.newTabSpec("tabAsk").setIndicator("설문");
        tabSpecAsk.setContent(R.id.tabAsk);
        tabHost.addTab(tabSpecAsk);

        TabHost.TabSpec tabSpecPicture = tabHost.newTabSpec("tabPicture").setIndicator("사진");
        tabSpecPicture.setContent(R.id.tabPicture);
        tabHost.addTab(tabSpecPicture);

        tabHost.setCurrentTab(0);

        ChgImg = findViewById(R.id.ChgImg);
        StopImg = findViewById(R.id.StopImg);

        rgpClass = findViewById(R.id.rgpClass);
        rgpPhone = findViewById(R.id.rgpPhone);

        radioButtonA = findViewById(R.id.radioButtonA);
        radioButtonB = findViewById(R.id.radioButtonB);
        radioButtonAnd = findViewById(R.id.radioButtonAnd);
        radioButtonIp = findViewById(R.id.radioButtonIp);

        radioButtonB.setChecked(true);
        radioButtonAnd.setChecked(true);
        viewFlipper = findViewById(R.id.viewFliper);

        ChgImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.startFlipping();
                viewFlipper.setFlipInterval(1000);
            }
        });

        StopImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.stopFlipping();
            }
        });
    }
}
