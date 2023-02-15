package com.example.app16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    Button btnB, btnD;
    EditText LT, LA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        DataBaseHelper db = new DataBaseHelper(this);
        btnB = findViewById(R.id.btnBack);
        btnD = findViewById(R.id.btnDelete);
        LT = findViewById(R.id.LTitle);
        LA = findViewById(R.id.LAvtor);

        Bundle arguments = getIntent().getExtras();
        LT.setText(arguments.get("Title").toString());
        LA.setText(arguments.get("Avtor").toString());

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.onUpgrades((Integer) arguments.get("ID"), LT.getText().toString(), LA.getText().toString());
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.onDelte((Integer) arguments.get("ID"));
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}