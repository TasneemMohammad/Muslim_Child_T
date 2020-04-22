package com.example.l;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.BlockedNumberContract;
import android.view.WindowManager;

import java.util.ArrayList;

public class Entertainment_Stories extends AppCompatActivity {
    RecyclerView rv_entermainment_stories;
    DataBase_Stories db ;
    ArrayList<Stories_Card> Stories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment__stories);
        rv_entermainment_stories = findViewById(R.id.rv_anbyaa_stories);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        db = new DataBase_Stories(this);
        Stories = new ArrayList<>();        // khleh yget men el data base ;
        Stories_Card story1 = new Stories_Card("قصة الأسد والأرنب" ,R.drawable.icon);
        Stories_Card story2 = new Stories_Card("قصة الأسد والأرنب" ,R.drawable.icon);
        Stories_Card story3 = new Stories_Card("قصة الأسد والأرنب" ,R.drawable.icon);
        Stories_Card story4 = new Stories_Card("قصة الأسد والأرنب" ,R.drawable.icon);
        Stories_Card story5 = new Stories_Card("قصة الأسد والأرنب" ,R.drawable.icon);
        Stories = db.getAllStories();
        Recycler_Adapter_Stories adapter_stories = new Recycler_Adapter_Stories(Stories, new OnClickListener_Stories() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(Entertainment_Stories.this,webView_Stories.class);
                intent.putExtra("page",position);
                intent.putExtra("sound",position);
                startActivity(intent);
            }});
        db.insertStory(story1);
        db.insertStory(story2);
        db.insertStory(story3);
        db.insertStory(story4);
        db.insertStory(story5);
        rv_entermainment_stories.setAdapter(adapter_stories);
        rv_entermainment_stories.setLayoutManager(new LinearLayoutManager(Entertainment_Stories.this));
     }}
