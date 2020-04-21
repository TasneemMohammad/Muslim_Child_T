package com.example.l;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class webView_Stories extends AppCompatActivity {
    // WebView web_stories;
    TextView tv_title, tv_current_time, tv_total_time;
    Button btn_pause, btn_play, btn_stop;
    private SeekBar seekBar;
    final MediaPlayer sound = MediaPlayer.create(webView_Stories.this, R.raw.sound);
    int[] MB3Sounds = {R.raw.sydnaadam, R.raw.sound};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //soundTime();
        setContentView(R.layout.activity_web_view__stories);
        //  web_stories = findViewById(R.id.webView_stories);
        tv_title = findViewById(R.id.tv_title);
        tv_total_time = findViewById(R.id.tv_total_time);
        tv_current_time = findViewById(R.id.tv_current_time);
        btn_pause = findViewById(R.id.btn_pause);
        btn_play = findViewById(R.id.btn_play);
        seekBar = findViewById(R.id.seekBar);
        // Intent data = getIntent();
        // int url = data.getExtras().getInt("page");
      /*  web_stories.loadUrl("file:///android_asset/test.html");
        web_stories.requestFocus();

     final ProgressDialog progressDialog = new ProgressDialog(webView_AnbyaaStories.this);
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();

        web_stories.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }); */

        //   WebSettings webSettings = web_stories.getSettings();
        //   webSettings.setJavaScriptEnabled(true);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.start();
                Toast.makeText(webView_Stories.this,"test2",Toast.LENGTH_SHORT);
            }});
        //  url++;
        //  web_stories.loadUrl("file:///android_asset/" + url + ".html");
        //  web_stories.setWebViewClient(new WebViewClient());
        //
     /*
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sound.start();

               /* if (!sound.isPlaying()) {
                    Thread updateSeekBar = new Thread() {
                        @Override
                        public void run() {
                            int SoundDuration = sound.getDuration();
                            int currentposition = 0;
                            seekBar.setMax(SoundDuration);
                            while (currentposition < SoundDuration) {
                                try {
                                    sleep(100);   // update every 100 part from second .
                                    currentposition = sound.getCurrentPosition();
                                    seekBar.setProgress(currentposition);   // movement
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                } } }};
                    sound.start();
                    updateSeekBar.start();
            }
        });
       /* btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.pause();
            }
        }); */
      /*  btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.stop();
            }
        });
       /* public void soundTime(){
            seekBar.setMax(sound.getDuration());
            int tim = (seekBar.getMax()/1000);
            int s = tim % 60 ;
            int tim0 = (seekBar.getProgress() / 1000);
            int m0 = tim0 / 60 ;
            int s0 = tim0 % 60 ; } */

/*private void init(){
 webview = (WebView)findViewById(R.id.webview); */




    } }

