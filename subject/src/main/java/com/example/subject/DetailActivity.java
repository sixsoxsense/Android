package com.example.subject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class DetailActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(getApplicationContext(),"DetailActivity",Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        TextView name = (TextView) findViewById(R.id.detailName);
        TextView phone = (TextView) findViewById(R.id.detailPhone);
        TextView address = (TextView) findViewById(R.id.detailAddress);

        name.setText(intent.getStringExtra("name"));
        phone.setText(intent.getStringExtra("phone"));
        address.setText(intent.getStringExtra("address"));


    }
}
