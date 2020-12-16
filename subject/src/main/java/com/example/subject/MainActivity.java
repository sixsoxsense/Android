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

        listView = findViewById(R.id.listView);
        DataArr.clear();

        adapter = new ContactAdapter(
                this, R.layout.list_item, DataArr);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("name", DataArr.get(position).name);
                intent.putExtra("phone", DataArr.get(position).phone);
                intent.putExtra("address", DataArr.get(position).address);
                startActivity(intent);
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
                /**
                 * 옵션메뉴 추가버튼 누를시
                 */
                dialogView = View.inflate(MainActivity.this, R.layout.inputdialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("연락처 정보 입력");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edName = dialogView.findViewById(R.id.inputName);
                        edPhone = dialogView.findViewById(R.id.inputPhone);
                        edAddress = dialogView.findViewById(R.id.inputAddress);
                        DataArr.add(new ContactData(edName.getText().toString(), edPhone.getText().toString(), edAddress.getText().toString()));
                        adapter.notifyDataSetChanged();

                        try {
                            FileWriter fileWriter = new FileWriter(initialFile, true);
                            writeContactFile = new BufferedWriter(fileWriter);
                            writeContactFile.append(edName.getText()).append(",")
                                    .append(edPhone.getText()).append(",")
                                    .append(edAddress.getText()).append("\n");
                            writeContactFile.close();
                            fileWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.custom_toast_layout,
                                (ViewGroup) findViewById(R.id.toast_layout_root));

                        TextView title = (TextView) layout.findViewById(R.id.title);
                        TextView description = (TextView) layout.findViewById(R.id.description);
                        description.setText("연락처 추가 완료");

                        Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setView(layout);
                        toast.show();
                        dialog.dismiss();
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
        }
        return true;
    }

    @Override
    protected void onStart() {
        /**
         * 앱 시작시 파일 불러오기
         */
        super.onStart();
        try {
            DataArr.clear();
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast_layout,
                    (ViewGroup) findViewById(R.id.toast_layout_root));

            TextView title = (TextView) layout.findViewById(R.id.title);
            TextView description = (TextView) layout.findViewById(R.id.description);
            description.setText("연락처 목록 불러오는중");

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
            initialFile = new File("/data/data/com.example.subject/ContactFile.txt");
            if (initialFile.exists()) {// 파일이 있으면 불러오기
                filereader = new FileReader(initialFile);
                readContactFile = new BufferedReader(filereader);
                String line = null;
                while ((line = readContactFile.readLine()) != null) {
                    String[] forInsert = line.split(",", 3);
                    DataArr.add(new ContactData(forInsert[0], forInsert[1], forInsert[2]));
                }
                description.setText("파일 불러오기 완료");

                toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
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

    }
}
