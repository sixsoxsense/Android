package com.example.project6_1domyself;

import android.graphics.Color;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;
    Chronometer chronometer;
    Button chromeStart, chromeEnd;
    RadioButton rdoCal, rdoTime;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMin;
    DatePicker datePicker;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chromeStart = findViewById(R.id.chronometer1);
        chromeEnd = findViewById(R.id.chromeEnd);
        chronometer = findViewById(R.id.chronometer1);
        rdoCal = findViewById(R.id.radioBtn1);
        rdoTime = findViewById(R.id.radioBtn2);

        datePicker = findViewById(R.id.datePicker);

        tvYear = findViewById(R.id.year);
        tvMonth = findViewById(R.id.month);
        tvDay = findViewById(R.id.day);
        tvHour = findViewById(R.id.HH);
        tvMin = findViewById(R.id.MM);


        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.INVISIBLE);
            }
        });

        chromeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.VISIBLE);

                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });

        chromeEnd.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
                tvHour.setText(Integer.toString(timePicker.getCurrentHour()));
                tvMin.setText(Integer.toString(timePicker.getCurrentMinute()));

                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                selectYear = i;
                selectMonth = i1;
                selectDay = i2;
            }
        });
    }
}
