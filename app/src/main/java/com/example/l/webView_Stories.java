package com.example.l;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class webView_Stories extends AppCompatActivity {
//     WebView web_stories;
    TextView tv_title, tv_current_time, tv_total_time;
    Button btn_pause, btn_play, btn_stop;
     SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        final ArrayList<MediaPlayer> MB3Sounds =new ArrayList<>();
//
//        MB3Sounds .add(MediaPlayer.create(webView_Stories.this, R.raw.sydnaadam));
//        MB3Sounds .add(MediaPlayer.create(webView_Stories.this, R.raw.sound));
//        MB3Sounds .add(MediaPlayer.create(webView_Stories.this, R.raw.qassas_voice));
//        MB3Sounds .add(MediaPlayer.create(webView_Stories.this, R.raw.sydnaebraheem));
//        MB3Sounds .add(MediaPlayer.create(webView_Stories.this, R.raw.sydnaadam));
        //soundTime();
        setContentView(R.layout.activity_web_view__stories);
//         web_stories = findViewById(R.id.webView_stories);
        tv_title = findViewById(R.id.tv_title);
        tv_total_time = findViewById(R.id.tv_total_time);
        tv_current_time = findViewById(R.id.tv_current_time);
        btn_pause = findViewById(R.id.btn_pause);
        btn_stop = findViewById(R.id.btn_stop);
        btn_play = findViewById(R.id.btn_play);
        seekBar = findViewById(R.id.seekBar);


//



        int sound_rec = getIntent().getExtras().getInt("sound");
       String page = getIntent().getExtras().getString("page");

        WebView webview = (WebView) findViewById(R.id.webView_stories);

        webview.loadUrl("file:///android_asset/"+page+".html");
        webview.requestFocus();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();

        webview.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }}});
        final MediaPlayer sound = MediaPlayer.create(webView_Stories.this,sound_rec);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!sound.isPlaying()) {
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
                                }
                            }
                        }
                    };
                    sound.start();
                    updateSeekBar.start();
                }
            }
        });


        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sound.pause();
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.stop();
                sound.start();
            }
        });


    }}

//    public void soundtime(){
//        seekBar.setMax(sound.getDuration());
//        int tim = (seekBar.getMax()/1000);
//        int s = tim % 60 ;
//        int tim0 = (seekBar.getProgress() / 1000);
//        int m0 = tim0 / 60 ;
//        int s0 = tim0 % 60 ; }}




// Intent data = getIntent();
// int url = data.getExtras().getInt("page");

//
//     final ProgressDialog progressDialog = new ProgressDialog(webView_AnbyaaStories.this);
//        progressDialog.setMessage("Loading");
//        progressDialog.setCancelable(false);
//        progressDialog.show();
//
//        web_stories.setWebViewClient(new WebViewClient() {
//            public void onPageFinished(WebView view, String url) {
//                try {
//                    progressDialog.dismiss();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }); */

//   WebSettings webSettings = web_stories.getSettings();
//   webSettings.setJavaScriptEnabled(true);
//        btn_play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MediaPlayer sound=MediaPlayer.create(webView_Stories.this,R.raw.sydnaadam);
//                sound.start();
//                Toast.makeText(webView_Stories.this,"test2",Toast.LENGTH_SHORT);
//            }});
//  url++;

//  web_stories.setWebViewClient(new WebViewClient());
//
