package com.example.subject;

import android.content.Intent;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ListAdapter listAdapter;
    ArrayList<ItemData> itemDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연락처");

        itemDatas = new ArrayList<>();

        listView = findViewById(R.id.listView);

        listAdapter = new ListAdapter(itemDatas);
        listView.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.menu1:
                //다이어로그띄워서 메뉴창
                break;
            case R.id.menu2:
                //리스트옆에 체크박스 생기면서 고르기가능
                break;
            case R.id.menu3:
                //다이어로그띄워서 이름순 정렬
                break;
        }
        return true;
    }
}
