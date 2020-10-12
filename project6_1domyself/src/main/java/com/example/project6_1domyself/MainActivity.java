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
    Chronometer chrometer;
    RadioButton rdoCal, rdoTime;
    RadioGroup radioGroup1;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMin;
    DatePicker datePicker;
    LinearLayout chromeEnd;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chrometer = findViewById(R.id.chromeStart);
        chromeEnd = findViewById(R.id.chromeEnd);

        radioGroup1 = findViewById(R.id.radioGroup1);
        rdoCal = findViewById(R.id.radioBtn1);
        rdoTime = findViewById(R.id.radioBtn2);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);

        tvYear = findViewById(R.id.year);
        tvMonth = findViewById(R.id.month);
        tvDay = findViewById(R.id.day);
        tvHour = findViewById(R.id.HH);
        tvMin = findViewById(R.id.MM);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });

        chrometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup1.setVisibility(View.VISIBLE);

                chrometer.setBase(SystemClock.elapsedRealtime());
                chrometer.start();
                chrometer.setTextColor(Color.RED);
            }
        });

        chromeEnd.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chrometer.stop();
                chrometer.setTextColor(Color.BLUE);
                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));
                tvHour.setText(Integer.toString(timePicker.getCurrentHour()));
                tvMin.setText(Integer.toString(timePicker.getCurrentMinute()));

                radioGroup1.clearCheck();

                radioGroup1.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
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
