package com.example.l;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.l.R.*;

public class Anbyaa_Stories extends AppCompatActivity {
    RecyclerView rv_anbyaa_stories ;
    DataBase_Stories db ;
    ArrayList<Stories_Card> Stories;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        final ArrayList<Integer>MB3Sounds =new ArrayList<>();

        MB3Sounds .add(R. raw.sydnaadam);
        MB3Sounds .add( R.raw.sound);
        MB3Sounds .add( R.raw.sound);
        MB3Sounds .add( raw.sydnaebraheem);
        final ArrayList<String>MB3page =new ArrayList<>();
        MB3page.add("test");
        MB3page.add("test2");
        MB3page.add("testlHtm");

        super.onCreate(savedInstanceState);
        setContentView(layout.activity_anbyaa__stories);

        final MediaPlayer name_story=MediaPlayer.create(Anbyaa_Stories.this, raw.adam_voice);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        db = new DataBase_Stories(this);
        rv_anbyaa_stories = (RecyclerView)findViewById(id.rv_anbyaa_stories);
        Stories = new ArrayList<>();        // khleh yget men el data base ;
    Stories_Card story1 = new Stories_Card("قصة يوسف" , drawable.icon);
        Stories_Card story2= new Stories_Card("قصة يوسف" , drawable.icon);
        Stories_Card story3 = new Stories_Card("قصة يوسف" , drawable.icon);
        Stories_Card story4= new Stories_Card("قصة يوسف" , drawable.icon);
        Stories_Card story5 = new Stories_Card("قصة يوسف" , drawable.icon);
        Stories = db.getAllStories();
        Recycler_Adapter_Stories adapter_stories = new Recycler_Adapter_Stories(Stories, new OnClickListener_Stories() {
            @Override
            public void onClick(int position) {


                name_story.start();
                Intent intent = new Intent(Anbyaa_Stories.this,webView_Stories.class);
            intent.putExtra("page",MB3page.get(position));
                intent.putExtra("sound",MB3Sounds.get(position));
                startActivity(intent);
            }
        }
        );
        db.insertStory(story1);
        db.insertStory(story2);
        db.insertStory(story3);
        db.insertStory(story4);
        db.insertStory(story5);
        rv_anbyaa_stories.setAdapter(adapter_stories);
        rv_anbyaa_stories.setLayoutManager(new LinearLayoutManager(Anbyaa_Stories.this));

    }

}
