package com.example.project4_2;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    RadioGroup RGroup;
    RadioButton rdDog, rdCat, rdRabbit;
    TextView text1, text2;
    CheckBox chkAgree;
    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");
        text1 = findViewById(R.id.Text1);
        chkAgree = findViewById(R.id.ChkAgree);

        text2 = findViewById(R.id.Text2);

        RGroup = findViewById(R.id.RdGroup);
        rdDog = findViewById(R.id.Rdodog);
        rdCat = findViewById(R.id.Rdocat);
        rdRabbit = findViewById(R.id.Rdorabbit);

        btnOK = findViewById(R.id.BtnOK);
        imgPet = findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkAgree.isChecked()) {
                    text2.setVisibility(View.VISIBLE);
                    RGroup.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    RGroup.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (RGroup.getCheckedRadioButtonId()) {
                    case R.id.Rdodog:
                        imgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.Rdocat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.Rdorabbit:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
