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
        DataArr.clear();
        listView = findViewById(R.id.listView);

        //저장장치 불러오기
        try {
            Toast.makeText(getApplicationContext(), "연락처 목록불러오는중", Toast.LENGTH_SHORT).show();
            initialFile = new File("/data/data/com.example.subject/ContactFile.txt");
            if (initialFile.exists()) {// 파일이 있으면 불러오기
                /**
                 * 파일읽기
                 */

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
                Toast.makeText(getApplicationContext(), "before start", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "after start", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(getApplicationContext(),"온클릭",Toast.LENGTH_SHORT).show();
                        edName = dialogView.findViewById(R.id.inputName);
                        edPhone = dialogView.findViewById(R.id.inputPhone);
                        edAddress = dialogView.findViewById(R.id.inputAddress);
                        try {
                            /**
                             * 파일쓰기
                             */
                            Toast.makeText(getApplicationContext(),"트라이진입" ,Toast.LENGTH_SHORT).show();
                            FileWriter fileWriter = new FileWriter(initialFile, true);
                            writeContactFile = new BufferedWriter(fileWriter);
                            Toast.makeText(getApplicationContext(),"쓰기준비완료" ,Toast.LENGTH_SHORT).show();
                            writeContactFile.append(edName.getText()).append(",")
                                    .append(edPhone.getText()).append(",")
                                    .append(edAddress.getText()).append("\n");
                            Toast.makeText(getApplicationContext(),edName.getText(),Toast.LENGTH_SHORT).show();
                            writeContactFile.close();
                            fileWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                dlg.setNegativeButton("취소", null);
                dlg.show();
                return true;
            case R.id.menu2:
                //리스트옆에 체크박스 생기면서 고르기가능
                return true;
        }
        return false;
    }

}
