package com.example.app16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{
    RecyclerView rs;
    Button btn;
    ArrayList<Anime> listanim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rs = findViewById(R.id.list_item);
        btn = findViewById(R.id.btnAdd);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i);
            }
        });

        DataBaseHelper db = new DataBaseHelper(this);
        rs.setLayoutManager(new LinearLayoutManager(this));
        rs.setHasFixedSize(true);
        listanim = db.getMangaList();
        RecuclerAdapter adapter = new RecuclerAdapter(this, db.getMangaList(), this);
        rs.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent i = new Intent(MainActivity.this, MainActivity3.class);
        i.putExtra("ID", listanim.get(position).getID());
        i.putExtra("Title", listanim.get(position).getTitleName());
        i.putExtra("Avtor", listanim.get(position).getAvtorName());
        startActivity(i);
    }
}