package com.example.app16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    Button btn;
    EditText Title;
    EditText Avtor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = findViewById(R.id.btnAddAnime);
        Title = findViewById(R.id.editTitle);
        Avtor = findViewById(R.id.editAvtor);

        DataBaseHelper db = new DataBaseHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Anime anime = new Anime(0, Title.getText().toString(), Avtor.getText().toString());
                db.addManga(anime);
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}