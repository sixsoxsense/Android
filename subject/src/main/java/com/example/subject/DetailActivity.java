package com.example.subject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final Intent intent = getIntent();

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView title = (TextView) layout.findViewById(R.id.title);
        TextView description = (TextView) layout.findViewById(R.id.description);
        description.setText("상세정보 액티비티");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();


        TextView name = (TextView) findViewById(R.id.detailName);
        final TextView phone = (TextView) findViewById(R.id.detailPhone);
        TextView address = (TextView) findViewById(R.id.detailAddress);

        name.setText(intent.getStringExtra("name"));
        phone.setText(intent.getStringExtra("phone"));
        address.setText(intent.getStringExtra("address"));

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + (String) phone.getText());
                Intent intent1 = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent1);
            }
        });
    }

}
