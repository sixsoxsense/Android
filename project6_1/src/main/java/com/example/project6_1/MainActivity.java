package com.example.project6_1;

import android.graphics.Color;
import android.os.SystemClock;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;
    Chronometer chronometer;
    Button btnStart,btnEnd;
    RadioButton rdoCal,rdoTime;
    TextView tvYear,tvMonth,tvDay,tvHour,tvMin;
    CalendarView calendarView;
    int selectYear,selectMonth,selectDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        btnStart=findViewById(R.id.btnStart);
        btnEnd=findViewById(R.id.btnEnd);
        chronometer=findViewById(R.id.chronometer1);
        rdoCal=findViewById(R.id.radioBtn1);
        rdoTime=findViewById(R.id.radioBtn2);

        timePicker=findViewById(R.id.timePicker1);
        calendarView=findViewById(R.id.calendarView1);

        tvYear=findViewById(R.id.year);
        tvMonth=findViewById(R.id.month);
        tvDay=findViewById(R.id.day);
        tvHour=findViewById(R.id.HH);
        tvMin=findViewById(R.id.MM);

        timePicker.setVisibility(View.INVISIBLE);
        calendarView.setVisibility(View.INVISIBLE);
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.INVISIBLE);
                calendarView.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
                calendarView.setVisibility(View.INVISIBLE);
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
                tvHour.setText(Integer.toString(timePicker.getCurrentHour()));
                tvMin.setText(Integer.toString(timePicker.getCurrentMinute()));

            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                selectYear=year;
                selectMonth=month+1;
                selectDay=day;
            }
        });
    }
}
