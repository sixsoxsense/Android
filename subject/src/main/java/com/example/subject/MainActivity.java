package com.example.subject;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;
import java.util.ArrayList;

/**
 * 파일 읽어와서 리스트뷰에 적용할때 파일을 읽고 어댑터데이터로 이루어진 ArrayList 파일로 갱신하면된다. 종료시 저장하는방식쓰면됨
 */
public class MainActivity extends AppCompatActivity {
    View dialogView;
    File initialFile;
    ListView listView;
    EditText edName, edPhone, edAddress;
    BufferedReader readContactFile;
    BufferedWriter writeContactFile;
    ArrayList<ContactData> DataArr = new ArrayList<>();
    ContactAdapter adapter;
    FileReader filereader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연락처");
        listView = findViewById(R.id.listView);
        DataArr.clear();
        try {
            Toast.makeText(getApplicationContext(), "연락처 목록불러오는중", Toast.LENGTH_SHORT).show();
            initialFile = new File("/data/data/com.example.subject/ContactFile.txt");
            if (initialFile.exists()) {// 파일이 있으면 불러오기
                filereader = new FileReader(initialFile);
                readContactFile = new BufferedReader(filereader);
                String line = null;
                while ((line = readContactFile.readLine()) != null) {
                    String[] forInsert = line.split(",", 3);
                    DataArr.add(new ContactData(forInsert[0], forInsert[1], forInsert[2]));
                }
                readContactFile.close();
                filereader.close();
            } else {//없으면
                Toast.makeText(getApplicationContext(), "연락처 파일 생성", Toast.LENGTH_SHORT).show();
                initialFile.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        adapter = new ContactAdapter(
                this, R.layout.list_item, DataArr);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                //putExtra 문제
                intent.putExtra("name", adapter.getItem(0));
                intent.putExtra("phone", adapter.getItem(1));
                intent.putExtra("address", adapter.getItem(2));
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                dialogView = View.inflate(MainActivity.this, R.layout.inputdialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("연락처 정보 입력");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "온클릭", Toast.LENGTH_SHORT).show();
                        edName = dialogView.findViewById(R.id.inputName);
                        edPhone = dialogView.findViewById(R.id.inputPhone);
                        edAddress = dialogView.findViewById(R.id.inputAddress);
                        DataArr.add(new ContactData(edName.getText().toString(), edPhone.getText().toString(), edAddress.getText().toString()));
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            case R.id.menu2:
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            Toast.makeText(getApplicationContext(), "연락처 목록불러오는중", Toast.LENGTH_SHORT).show();
            initialFile = new File("/data/data/com.example.subject/ContactFile.txt");
            if (initialFile.exists()) {// 파일이 있으면 불러오기
                filereader = new FileReader(initialFile);
                readContactFile = new BufferedReader(filereader);
                String line = null;
                while ((line = readContactFile.readLine()) != null) {
                    String[] forInsert = line.split(",", 3);
                    DataArr.add(new ContactData(forInsert[0], forInsert[1], forInsert[2]));
                }
                readContactFile.close();
                filereader.close();
            } else {//없으면
                Toast.makeText(getApplicationContext(), "연락처 파일 생성", Toast.LENGTH_SHORT).show();
                initialFile.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            FileWriter fileWriter = new FileWriter(initialFile, true);
            writeContactFile = new BufferedWriter(fileWriter);

            writeContactFile.append(edName.getText()).append(",")
                    .append(edPhone.getText()).append(",")
                    .append(edAddress.getText()).append("\n");
            writeContactFile.close();
            fileWriter.close();
            DataArr.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
