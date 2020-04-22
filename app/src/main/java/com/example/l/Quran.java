package com.example.l;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Quran extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayout linearLayout ;
    DataBase dataBase ;
    TextView textView
    ArrayList<QuranDataBase> quraan_list ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);
        textView = (TextView)findViewById(R.id.txt_title_name);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        quraan_list = new ArrayList<>();
        dataBase = new DataBase(this);
        QuranDataBase first = new QuranDataBase( " سورة عم ",R.drawable.boy);
        quraan_list = dataBase.getallsor() ;
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        ArrayList<modelQuran> quraan = new ArrayList<>();

        Adapter adapter = new Adapter(quraan, new OnClickListener_Stories() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(Quran.this,web_view_quraan.class);
                intent.putExtra("page",position);
                intent.putExtra("sound",position );
                startActivity(intent);
                Toast.makeText(Quran.this, "arwa", Toast.LENGTH_SHORT).show();
            }

        });

        dataBase.insertquraan(first);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

    }


}
